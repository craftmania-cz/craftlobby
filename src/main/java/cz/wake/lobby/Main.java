package cz.wake.lobby;

import cz.wake.lobby.GUI.GadgetsMenu;
import cz.wake.lobby.GUI.MorphsMenu;
import cz.wake.lobby.GUI.Servers;
import cz.wake.lobby.banners.BannerAPI;
import cz.wake.lobby.boxer.Boxer;
import cz.wake.lobby.boxer.SkyKeys;
import cz.wake.lobby.cloaks.CloaksAPI;
import cz.wake.lobby.commands.*;
import cz.wake.lobby.gadgets.*;
import cz.wake.lobby.heads.HeadsAPI;
import cz.wake.lobby.listeners.InvClick;
import cz.wake.lobby.listeners.PlayerListener;
import cz.wake.lobby.manager.LagManager;
import cz.wake.lobby.manager.TimeTask;
import cz.wake.lobby.morphs.PigMorph;
import cz.wake.lobby.morphs.VillagerMorph;
import cz.wake.lobby.pets.PetManager;
import cz.wake.lobby.pets.PetsAPI;
import cz.wake.lobby.sql.SQLManager;
import cz.wake.lobby.utils.mobs.*;
import cz.wake.lobby.vanoce.Kalendar;
import cz.wake.lobby.vanoce.TicketSystem;
import cz.wake.lobby.vanoce.WinnerTask;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    private Boxer boxer = new Boxer();
    private CloaksAPI cloaks = new CloaksAPI();
    private GadgetsAPI gadgets = new GadgetsAPI();
    private PetsAPI pets = new PetsAPI();
    private GadgetsMenu gMenu = new GadgetsMenu();
    private Servers s = new Servers();
    private TimeTask tt = new TimeTask();
    public boolean debug;
    public HashMap<Block, String> _BlocksToRestore = new HashMap();
    public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
    public static ArrayList<ExplosiveSheep> explosiveSheep = new ArrayList();
    private static ArrayList<Player> inPortal = new ArrayList<>();
    public VillagerMorph VillagerMorph;
    private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    private static DataOutputStream out = new DataOutputStream(b);
    private SQLManager sql;


    public void onEnable() {
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

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "PlayerBalancer");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "PlayerBalancer", this);

        // Deaktivace fire
        for (World w : Bukkit.getWorlds()) {
            w.setGameRuleValue("doFireTick", "false");
            w.setGameRuleValue("doDaylightCycle", "false");
        }

        // Automaticka zmena casu v lobby podle Real casu
        if(getConfig().getBoolean("timer")){
            tt.initTimeSetter();
        }

        // Ticket system
        if(getConfig().getBoolean("ticket-winner")){
            Bukkit.getScheduler().runTaskTimerAsynchronously(this, new WinnerTask(), 400L, 1200L);
        }

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
    }

    public void onDisable() {
        instance = null;

        sql.onDisable();

        for (Entity e : Bukkit.getWorld("OfficialLobby").getEntities()) {
            e.remove();
        }
    }

    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new GadgetsMenu(), this);
        pm.registerEvents(new TeleportStick(this), this);
        pm.registerEvents(new FunCannon(this), this);
        pm.registerEvents(new TNTBomb(this), this);
        pm.registerEvents(new MorphsMenu(), this);
        pm.registerEvents(new VillagerMorph(this), this);
        pm.registerEvents(new PigMorph(this), this);
        pm.registerEvents(new Pee(this), this);
        pm.registerEvents(new Fireworks(this), this);
        pm.registerEvents(new BlizzardBlaster(this), this);
        pm.registerEvents(new AntiGravity(this), this);
        pm.registerEvents(new SmashDown(this), this);
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
        pm.registerEvents(new FireTrail(this), this);
        pm.registerEvents(new Rocket(this), this);
        pm.registerEvents(new Parachute(this), this);
        pm.registerEvents(new HeadsAPI(), this);
        pm.registerEvents(new Kalendar(), this);
        pm.registerEvents(new SnowBall(this), this);
        pm.registerEvents(new TicketSystem(), this);

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
        getCommand("kalendar").setExecutor(new Kalendar_command());
        getCommand("ticket").setExecutor(new Ticket_Command());
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

    public void activeteDebug() {
        debug = true;
    }

    public boolean isDebug() {
        return debug;
    }

    public void deactivateDebug() {
        debug = false;
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

    public Servers getServerMenu() {
        return s;
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

}
