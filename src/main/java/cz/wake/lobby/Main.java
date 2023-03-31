package cz.wake.lobby;

import co.aikar.commands.PaperCommandManager;
import cz.wake.lobby.seasons.christmas.Kalendar;
import cz.wake.lobby.seasons.christmas.Kalendar_command;
import cz.wake.lobby.seasons.christmas.SilvesterTask;
import cz.wake.lobby.seasons.halloween.ScarePlayerTask;
import cz.wake.lobby.commands.*;
import cz.wake.lobby.commands.servers.*;
import cz.wake.lobby.listeners.*;
import cz.wake.lobby.manager.*;
import cz.wake.lobby.sql.SQLManager;
import cz.wake.lobby.utils.CraftBalancerManager;
import cz.wake.lobby.utils.Log;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    public boolean debug;
    public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
    private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    public ArrayList<Player> at_list = new ArrayList<>();
    private String idServer;
    private SQLManager sql;
    private boolean isSilvester;
    private boolean isChristmas;
    private boolean isHalloween;
    private CraftBalancerManager craftBalancerManager;
    private LuckPerms luckPermsApi;
    private PaperCommandManager manager = null;

    public void onEnable() {

        // Instance
        instance = this;

        // Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Aikar command manager
        Log.info("Probíhá registrace příkazů pomocí Aikar commands!");
        manager = new PaperCommandManager(this);
        manager.enableUnstableAPI("help");

        // Listeners
        Log.info("Nacitani listeneru...");
        loadListeners();
        loadCommands();

        // Debug rezim
        debug = false;

        // HikariCP
        Log.info("Nacitani databaze...");
        initDatabase();

        // Id serveru
        idServer = getConfig().getString("server");
        Log.info("Server zaevidovany jako " + idServer);

        //Detekce TPS
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LagManager(), 100L, 1L);

        // Plugin Mesages
        Log.info("Nacitani plugin messages.");
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        craftBalancerManager = new CraftBalancerManager(this);

        // Deaktivace fire + bezpecnostni odebrani vsech entit
        Log.info("Preventivni nastavovani svetu pro lobby.");
        for (World w : Bukkit.getWorlds()) {
            w.setGameRule(GameRule.DO_FIRE_TICK, false);
            w.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            w.setGameRule(GameRule.DISABLE_RAIDS, true);
            w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false);
            w.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        }

        // Nastaveni specialnich eventu
        isChristmas = getConfig().getBoolean("seasons.christmas", false);
        isSilvester = getConfig().getBoolean("seasons.silvester", false);
        isHalloween = getConfig().getBoolean("seasons.halloween", false);

        if (isHalloween) {
            Log.info("Aktivace Halloween eventu pro lobby.");
            getServer().getScheduler().runTaskTimerAsynchronously(this, new ScarePlayerTask(), 200L, 200L);
        }

        // Silvester ohnostroje
        if(isSilvester){
            Log.info("Aktivace Silvester eventu pro lobby.");
            SilvesterTask.runLauncher();
        }

        if (this.getIdServer().equalsIgnoreCase("main")) {
            // LuckPerms register
            RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null) {
                luckPermsApi = provider.getProvider();
            }
        }
    }

    public void onDisable() {
        sql.onDisable();
        instance = null;
    }

    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();

        // NEW
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerInteractListener(), this);
        pm.registerEvents(new ItemFrameInteractListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);

        // OLD
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new ChatListener(), this);

        if (getConfig().getString("server").equalsIgnoreCase("main")
                && pm.isPluginEnabled("RogueParkour")) {
            Log.info("Detekce a aktivace Parkour pluginu.");
            pm.registerEvents(new ParkourListener(), this);
        }

        if(getConfig().getBoolean("seasons.christmas")){
            pm.registerEvents(new Kalendar(), this);
            Log.info("Aktivace Vanocnich eventu pro lobby.");
        }
    }

    private void loadCommands() {
        manager.registerCommand(new CraftlobbyCommand());
        manager.registerCommand(new LinkCommand());
        manager.registerCommand(new SeenCommand());
        manager.registerCommand(new SpawnCommand());
        manager.registerCommand(new VIPCommand());
        manager.registerCommand(new DiscordCommand());
        manager.registerCommand(new WikiCommand());
        manager.registerCommand(new ChangePasswordCommand());
        manager.registerCommand(new TutorialCommand());
        manager.registerCommand(new DailyRewardCommand());

        //Servers
        manager.registerCommand(new CreativeCommand());
        manager.registerCommand(new PrisonCommand());
        manager.registerCommand(new SkyblockCommand());
        manager.registerCommand(new SurvivalCommand());
        manager.registerCommand(new VanillaCommand());
        manager.registerCommand(new AnarchyCommand());
        manager.registerCommand(new EventServerCommand());
        manager.registerCommand(new Survival2Command());

        if(getConfig().getBoolean("seasons.christmas")){
            manager.registerCommand(new Kalendar_command());
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public SQLManager getSQL() {
        return this.sql;
    }

    public boolean isDebug() {
        return debug;
    }

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("CraftLobby");
    }

    public double getTPS() {
        return LagManager.getTPS();
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
    }

    public void sendToServer(Player player, String target) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
    }

    private void initDatabase() {
        sql = new SQLManager(this);
    }

    public String getIdServer() {
        return idServer;
    }

    public boolean isSilvester() {
        return isSilvester;
    }

    public boolean isChristmas() {
        return isChristmas;
    }

    public CraftBalancerManager getCraftBalancerManager() {
        return craftBalancerManager;
    }

    public LuckPerms getLuckPermsApi() {
        return luckPermsApi;
    }
}
