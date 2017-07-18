package cz.wake.lobby;

import cz.wake.lobby.GUI.ArcadeShopGUI;
import cz.wake.lobby.GUI.GadgetsMenu;
import cz.wake.lobby.GUI.Menu;
import cz.wake.lobby.GUI.Servers;
import cz.wake.lobby.armorstands.ArmorStandManager;
import cz.wake.lobby.armorstands.ArmorStandUpdateTask;
import cz.wake.lobby.commands.servers.*;
import cz.wake.lobby.gadgets.banners.BannerAPI;
import cz.wake.lobby.listeners.ArmorStandInteract;
import cz.wake.lobby.listeners.ChatListener;
import cz.wake.lobby.manager.*;
import cz.wake.lobby.gadgets.cloaks.CloaksAPI;
import cz.wake.lobby.commands.*;
import cz.wake.lobby.gadgets.gadget.*;
import cz.wake.lobby.gadgets.heads.HeadsAPI;
import cz.wake.lobby.listeners.InvClick;
import cz.wake.lobby.listeners.PlayerListener;
import cz.wake.lobby.gadgets.morphs.PigMorph;
import cz.wake.lobby.gadgets.morphs.VillagerMorph;
import cz.wake.lobby.gadgets.pets.PetManager;
import cz.wake.lobby.gadgets.pets.PetsAPI;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.sql.SQLManager;
import cz.wake.lobby.utils.ExceptionHandler;
import cz.wake.lobby.utils.mobs.*;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    private CloaksAPI cloaks = new CloaksAPI();
    private GadgetsAPI gadgets = new GadgetsAPI();
    private PetsAPI pets = new PetsAPI();
    private GadgetsMenu gMenu = new GadgetsMenu();
    private ArmorStandManager asm = new ArmorStandManager();
    private Menu m = new Menu();
    private TimeTask tt = new TimeTask();
    public boolean debug;
    public HashMap<Block, String> _BlocksToRestore = new HashMap();
    public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
    public static ArrayList<ExplosiveSheep> explosiveSheep = new ArrayList();
    public static ArrayList<Player> preQuest = new ArrayList();
    public static ArrayList<Player> inQuest = new ArrayList();
    private static ArrayList<Player> inPortal = new ArrayList();
    private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    private static DataOutputStream out = new DataOutputStream(b);
    public ArrayList<Player> at_list = new ArrayList<>();
    private String idServer;
    private SQLManager sql;

    public void onEnable() {

        // Instance
        instance = this;

        // Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Listeners
        loadListeners();
        loadCommands();

        // Debug rezim
        debug = false;

        // HikariCP
        initDatabase();

        //Detekce TPS
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LagManager(), 100L, 1L);

        //CraftBoxy reset
        //boxer.runTaskDelete();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "LobbyBalancer");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "LobbyBalancer", this);

        // Deaktivace fire + bezpecnostni odebrani vsech entit
        for (World w : Bukkit.getWorlds()) {
            w.setGameRuleValue("doFireTick", "false");
            w.setGameRuleValue("doDaylightCycle", "false");
            for(Entity e : w.getEntities()){
                e.remove();
            }
        }

        // Automaticka zmena casu v lobby podle Real casu
        if (getConfig().getBoolean("timer")) {
            tt.initTimeSetter();
        }

        // Id serveru
        idServer = getConfig().getString("server");

        // Zachytavac unhandled exceptions
        ExceptionHandler.enable(instance);

        // MDC tagy pro Sentry
        MDC.put("server", idServer);
        MDC.put("players", String.valueOf(Bukkit.getOnlinePlayers().size()));
        MDC.put("version", Bukkit.getBukkitVersion());

        //Register custom entit pro Pets
        NMSUtils.registerEntity("Cow", 92, EntityCow.class, RideableCow.class);
        NMSUtils.registerEntity("Chicken", 93, EntityChicken.class, RideableChicken.class);
        NMSUtils.registerEntity("Pig", 90, EntityPig.class, RideablePig.class);
        NMSUtils.registerEntity("Silverfish", 60, EntitySilverfish.class, RideableSilverfish.class);
        NMSUtils.registerEntity("Wolf", 95, EntityWolf.class, RideableWolf.class);
        NMSUtils.registerEntity("Zombie", 54, EntityZombie.class, RideableZombie.class);
        NMSUtils.registerEntity("Rabbit", 101, EntityRabbit.class, RideableRabbit.class);
        NMSUtils.registerEntity("Ozelot", 98, EntityOcelot.class, RideableCat.class);
        NMSUtils.registerEntity("EntityHorse", 100, EntityHorse.class, RideableHorse.class);
        NMSUtils.registerEntity("Sheep", 91, EntitySheep.class, RideableSheep.class);
        NMSUtils.registerEntity("MushroomCow", 96, EntityMushroomCow.class, RideableMushroomCow.class);
        NMSUtils.registerEntity("Slime", 55, EntitySlime.class, RideableSlime.class);
        NMSUtils.registerEntity("Spider", 52, EntitySpider.class, RideableSpider.class);
        NMSUtils.registerEntity("CaveSpider", 59, EntityCaveSpider.class, RideableCaveSpider.class);
        NMSUtils.registerEntity("VillagerGolem", 99, EntityIronGolem.class, RideableGolem.class);
        NMSUtils.registerEntity("Witch", 66, EntityWitch.class, RideableWitch.class);
        NMSUtils.registerEntity("Enderman", 58, EntityEnderman.class, RideableEnderman.class);
        NMSUtils.registerEntity("Blaze", 61, EntityBlaze.class, RideableBlaze.class);
        NMSUtils.registerEntity("Villager", 120, EntityVillager.class, RideableVillager.class);
        NMSUtils.registerEntity("Creeper", 50, EntityCreeper.class, RideableCreeper.class);
        NMSUtils.registerEntity("Skeleton", 51, EntitySkeleton.class, RideableSkeleton.class);
        NMSUtils.registerEntity("LavaSlime", 62, EntityMagmaCube.class, RideableMagmaCube.class);
        NMSUtils.registerEntity("PolarBear", 102, EntityPolarBear.class, RideableBear.class);
        NMSUtils.registerEntity("Guardian", 68, EntityGuardian.class, RideableGuardian.class);

        if(getConfig().getString("server").equalsIgnoreCase("main")
                || getConfig().getString("server").equalsIgnoreCase("arcade")){

            // Spawn armorstandu
            ArmorStandManager.init();
            ArmorStandManager.spawn();

            if(getConfig().getString("server").equalsIgnoreCase("main")){
                // Update ArmorStandu
                getServer().getScheduler().runTaskTimerAsynchronously(getInstance(), new ArmorStandUpdateTask(), 200L,1200L);
            }
        }

        // Update AT time
        getServer().getScheduler().runTaskTimerAsynchronously(this, new ATChecker(), 200, 1200);
    }

    public void onDisable() {
        sql.onDisable();
        ExceptionHandler.disable(instance);
        instance = null;
    }

    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new GadgetsMenu(), this);
        pm.registerEvents(new TeleportStick(this), this);
        pm.registerEvents(new FunCannon(this), this);
        pm.registerEvents(new TNTBomb(this), this);
        pm.registerEvents(new VillagerMorph(this), this);
        pm.registerEvents(new PigMorph(this), this);
        pm.registerEvents(new Pee(this), this);
        pm.registerEvents(new Fireworks(this), this);
        pm.registerEvents(new BlizzardBlaster(this), this);
        pm.registerEvents(new AntiGravity(this), this);
        pm.registerEvents(new Servers(), this);
        pm.registerEvents(new Trampoline(this), this);
        pm.registerEvents(new PetManager(this), this);
        pm.registerEvents(new Chickenator(this), this);
        pm.registerEvents(new Tsunami(this), this);
        pm.registerEvents(new ExplosiveSheep(this), this);
        pm.registerEvents(new SlimeHat(this), this);
        pm.registerEvents(new FlowerPopper(this), this);
        pm.registerEvents(new BlackHole(this), this);
        pm.registerEvents(new BatBlaster(this), this);
        pm.registerEvents(new ColorBomb(this), this);
        pm.registerEvents(new WitherCatapult(this), this);
        pm.registerEvents(new Ghosts(this), this);
        pm.registerEvents(new PoopBomb(this), this);
        pm.registerEvents(new CookieFountain(this), this);
        pm.registerEvents(new PigFly(this), this);
        pm.registerEvents(new DiscoBall(this), this);
        pm.registerEvents(new PartyCoins(this), this);
        pm.registerEvents(new WakeArmy(this), this);
        //pm.registerEvents(new Boxer(), this);
        pm.registerEvents(new CloaksAPI(), this);
        pm.registerEvents(new GadgetsAPI(), this);
        pm.registerEvents(new PetsAPI(), this);
        pm.registerEvents(new FunCannonIce(this), this);
        pm.registerEvents(new BannerAPI(), this);
        pm.registerEvents(new DiamondsFountain(this), this);
        pm.registerEvents(new Rocket(this), this);
        pm.registerEvents(new Parachute(this), this);
        pm.registerEvents(new HeadsAPI(), this);
        pm.registerEvents(new SnowBall(this), this);
        pm.registerEvents(new SettingsMenu(), this);
        pm.registerEvents(new Shop(), this);
        pm.registerEvents(new ArmorStandInteract(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new ArcadeShopGUI(), this);

        //SkyKeys pro SLOBBY
        if (pm.isPluginEnabled("CrateKeys")) {
            if (getConfig().getString("server").contains("slobby")) {
                pm.registerEvents(new SkyKeys(), this);
            }
        }
    }

    private void loadCommands() {
        getCommand("wlobby").setExecutor(new ProfilCMD());
        getCommand("wl").setExecutor(new ProfilCMD());
        getCommand("stats").setExecutor(new Stats_Command());
        getCommand("sbperms").setExecutor(new SBPerms_command());
        getCommand("cbperms").setExecutor(new CBPerms_command());
        getCommand("vip").setExecutor(new VIP_Command());
        getCommand("survival").setExecutor(new Survival_command());
        getCommand("skyblock").setExecutor(new Skyblock_command());
        getCommand("creative").setExecutor(new Creative_command());
        getCommand("creative2").setExecutor(new Creative2_command());
        getCommand("prison").setExecutor(new Prison_command());
        getCommand("vanilla").setExecutor(new Vanilla_command());
        getCommand("bedwars").setExecutor(new BedWars_command());
        getCommand("skywars").setExecutor(new SkyWars_command());
        getCommand("arcade").setExecutor(new Arcade_command());
        getCommand("skygiants").setExecutor(new SkyGiants_command());
        getCommand("vanillasb").setExecutor(new VanillaSb_command());
    }

    public static Main getInstance() {
        return instance;
    }

    public SQLManager fetchData() {
        return this.sql;
    }

    public SQLManager setData() {
        return this.sql;
    }

    public boolean isDebug() {
        return debug;
    }

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("WakesLobby");
    }

    public double getTPS() {
        return LagManager.getTPS();
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
    }

    public CloaksAPI getCloaksAPI() {
        return cloaks;
    }

    public GadgetsMenu getMainGadgetsMenu() {
        return gMenu;
    }

    public GadgetsAPI getGadgetsAPI() {
        return gadgets;
    }

    public PetsAPI getPetsAPI() {
        return pets;
    }

    public Menu getMenu(){
        return m;
    }

    public void addPortal(Player p) {
        inPortal.add(p);
    }

    public boolean inPortal(Player p) {
        return inPortal.contains(p);
    }

    public void removePortal(Player p) {
        inPortal.remove(p);
    }

    private void initDatabase() {
        sql = new SQLManager(this);
    }

    public String getIdServer() {
        return idServer;
    }

    public ArrayList<Player> getPreQuestPlayers(){
        return preQuest;
    }

    public ArrayList<Player> getInQuestPlayers(){
        return inQuest;
    }

    public ArmorStandManager getASM(){
        return asm;
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

}
