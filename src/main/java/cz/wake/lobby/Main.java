package cz.wake.lobby;

import co.aikar.commands.PaperCommandManager;
import cz.craftmania.craftcore.spigot.bungee.BungeeAPI;
import cz.wake.lobby.gui.ChangelogsGUI;
import cz.wake.lobby.npc.NPCInteractListener;
import cz.wake.lobby.npc.NPCManager;
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
import net.jitse.npclib.NPCLib;
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
import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    public boolean debug;
    public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
    private RewardsManager rm = new RewardsManager();
    private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    public ArrayList<Player> at_list = new ArrayList<>();
    private String idServer;
    private SQLManager sql;
    private boolean isSilvester;
    private boolean isChristmas;
    private boolean isHalloween;
    private CraftBalancerManager craftBalancerManager;
    private NPCLib npclib;
    private NPCManager npcManager;
    private BungeeAPI bungeeAPI;
    private long lastChangelogDate = 0L;
    private LuckPerms luckPermsApi;
    private PaperCommandManager manager = null;
    private boolean isNpcLibProvided = false;

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

        bungeeAPI = new BungeeAPI();

        craftBalancerManager = new CraftBalancerManager(this);

        // Setup NPC
        if (this.getServer().getPluginManager().isPluginEnabled("NPCLibPlugin")) {
            this.isNpcLibProvided = true;
            this.npclib = new NPCLib(this);
            this.npcManager = new NPCManager();
            this.npcManager.loadNpcs();
        }

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

        // Setup last changelog
        //this.lastChangelogDate = fetchLastChangelogDate();

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
        pm.registerEvents(new NPCInteractListener(), this);
        pm.registerEvents(new PlayerInteractListener(), this);
        pm.registerEvents(new ItemFrameInteractListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);

        // OLD
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new TimedResetListener(), this);
        pm.registerEvents(new RewardsManager(), this);

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
        manager.registerCommand(new Craftlobby_Command());
        manager.registerCommand(new Link_Command());
        manager.registerCommand(new Seen_Command());
        manager.registerCommand(new Spawn_Command());
        manager.registerCommand(new VIP_Command());
        manager.registerCommand(new Discord_Command());
        manager.registerCommand(new Wiki_Command());
        manager.registerCommand(new ChangePassword_Command());
        manager.registerCommand(new TutorialCommand());
        manager.registerCommand(new DailyRewardCommand());

        //Servers
        manager.registerCommand(new Creative_command());
        manager.registerCommand(new Prison_command());
        manager.registerCommand(new Skyblock_command());
        manager.registerCommand(new Skycloud_command());
        manager.registerCommand(new Survival_command());
        manager.registerCommand(new Vanilla_command());

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

    public NPCLib getNpclib() {
        return npclib;
    }

    public NPCManager getNpcManager() {
        return npcManager;
    }

    public long getLastChangelogDate() {
        return this.lastChangelogDate;
    }

    private long fetchLastChangelogDate() {
        try {
            JSONArray json = ChangelogsGUI.readJsonFromUrl("https://changelog-api.craftmania.cz/public/channels/servers");
            String publishDate = json.getJSONObject(0).getString("publishDate");

            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date d = input.parse(publishDate);
            return d.getTime();
        } catch (Exception ignored) {}
        return 0;
    }

    public LuckPerms getLuckPermsApi() {
        return luckPermsApi;
    }

    public boolean isNpcLibProvided() {
        return isNpcLibProvided;
    }
}
