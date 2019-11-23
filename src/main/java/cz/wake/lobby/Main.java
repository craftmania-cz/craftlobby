package cz.wake.lobby;

import cz.craftmania.craftcore.spigot.bungee.BungeeAPI;
import cz.wake.lobby.npc.NPCInteractListener;
import cz.wake.lobby.npc.NPCManager;
import cz.wake.lobby.seasons.christmas.Kalendar;
import cz.wake.lobby.seasons.christmas.Kalendar_command;
import cz.wake.lobby.seasons.christmas.SilvesterTask;
import cz.wake.lobby.seasons.halloween.ScarePlayerTask;
import cz.wake.lobby.gui.Profil;
import cz.wake.lobby.commands.*;
import cz.wake.lobby.commands.servers.*;
import cz.wake.lobby.listeners.*;
import cz.wake.lobby.manager.*;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.sql.SQLManager;
import cz.wake.lobby.utils.CraftBalancerManager;
import cz.wake.lobby.utils.Log;
import net.jitse.npclib.NPCLib;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    private Profil m = new Profil();
    public boolean debug;
    public HashMap<Block, String> _BlocksToRestore = new HashMap();
    public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
    public static ArrayList<Player> preQuest = new ArrayList();
    public static ArrayList<Player> inQuest = new ArrayList();
    private static ArrayList<Player> inPortal = new ArrayList();
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

    public void onEnable() {

        // Instance
        instance = this;

        // Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Listeners
        Log.info("Nacitani listeneru...");
        loadListeners();
        loadCommands();

        // Debug rezim
        debug = false;

        // HikariCP
        Log.info("Nacitani databaze...");
        initDatabase();

        //Detekce TPS
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LagManager(), 100L, 1L);

        // Plugin Mesages
        Log.info("Nacitani plugin messages.");
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        bungeeAPI = new BungeeAPI();

        craftBalancerManager = new CraftBalancerManager(this);

        // Setup NPC
        this.npclib = new NPCLib(this);
        this.npcManager = new NPCManager();
        this.npcManager.loadNpcs();

        // Deaktivace fire + bezpecnostni odebrani vsech entit
        Log.info("Preventivni nastavovani svetu pro lobby.");
        for (World w : Bukkit.getWorlds()) {
            w.setGameRule(GameRule.DO_FIRE_TICK, false);
            w.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            w.setGameRule(GameRule.DISABLE_RAIDS, true);
            w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false);
            w.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        }

        // Id serveru
        idServer = getConfig().getString("server");
        Log.info("Server zaevidovany jako " + idServer);

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

        // OLD
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new SettingsMenu(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new Profil(), this);
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
        getCommand("clobby").setExecutor(new Craftlobby_Command());
        getCommand("cl").setExecutor(new Craftlobby_Command()); //TODO: Proc je tu alias?
        getCommand("vip").setExecutor(new VIP_Command());
        getCommand("survival").setExecutor(new Survival_command());
        getCommand("skyblock").setExecutor(new Skyblock_command());
        getCommand("creative").setExecutor(new Creative_command());
        getCommand("prison").setExecutor(new Prison_command());
        getCommand("vanilla").setExecutor(new Vanilla_command());
        getCommand("oldcrafttokens").setExecutor(new CraftTokens_command());
        getCommand("link").setExecutor(new Link_Command());
        getCommand("precteno").setExecutor(new Seen_Command());

        if(getConfig().getBoolean("seasons.christmas")){
            getCommand("kalendar").setExecutor(new Kalendar_command());
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

    public Profil getMenu() {
        return m;
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
}
