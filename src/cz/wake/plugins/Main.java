package cz.wake.plugins;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import cz.wake.plugins.boxer.SkyKeys;
import cz.wake.plugins.commands.Changepassword_Command;
import cz.wake.plugins.commands.SBPerms_command;
import cz.wake.plugins.gadgets.*;
import cz.wake.plugins.utils.mobs.*;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.*;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import cz.wake.plugins.API.WakeAPI;
import cz.wake.plugins.GUI.GadgetsMenu;
import cz.wake.plugins.GUI.HeadsMenu;
import cz.wake.plugins.GUI.HeadsMenu2;
import cz.wake.plugins.GUI.MorphsMenu;
import cz.wake.plugins.GUI.MountMenu;
import cz.wake.plugins.GUI.Servers;
import cz.wake.plugins.boxer.Boxer;
import cz.wake.plugins.cloaks.CloaksAPI;
import cz.wake.plugins.cloaks.Hero;
import cz.wake.plugins.commands.ProfilCMD;
import cz.wake.plugins.commands.Stats_Command;
import cz.wake.plugins.listeners.InvClick;
import cz.wake.plugins.listeners.PlayerListener;
import cz.wake.plugins.manager.LagManager;
import cz.wake.plugins.morphs.PigMorph;
import cz.wake.plugins.morphs.VillagerMorph;
import cz.wake.plugins.pets.PetManager;
import cz.wake.plugins.pets.PetsAPI;

public class Main extends JavaPlugin implements PluginMessageListener{

	private static Main instance;
	private MySQL mysql = new MySQL();
	private FetchData fd = new FetchData();
	private SetData sd = new SetData();
	private WakeAPI api = new WakeAPI();
	private Boxer boxer = new Boxer();
	private CloaksAPI cloaks = new CloaksAPI();
	private GadgetsAPI gadgets = new GadgetsAPI();
	private PetsAPI pets = new PetsAPI();
	private GadgetsMenu gMenu = new GadgetsMenu();
    private Servers s = new Servers();
	public boolean debug;
	public HashMap<Block, String> _BlocksToRestore = new HashMap();
	public static ArrayList<Entity> noFallDamageEntities = new ArrayList();
	public static ArrayList<ExplosiveSheep> explosiveSheep = new ArrayList();
    public static ArrayList<Player> inPortal = new ArrayList<>();
	public VillagerMorph VillagerMorph;
	private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    private static DataOutputStream out = new DataOutputStream(b);
	
	
	public void onEnable(){
		instance = this;
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		//this.mysql.checkTable();
		loadListeners();
		loadCommands();
		debug = false;
		
		//Detekce TPS
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LagManager(), 100L, 1L);
		
		//CraftBoxy reset
		boxer.runTaskDelete();
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        // Deaktivace fire
        for(World w : Bukkit.getWorlds()){
            w.setGameRuleValue("doFireTick", "false");
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
		NMSUtils.registerEntity("MushroomCow", 96,EntityMushroomCow.class, RideableMushroomCow.class);
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
	}
	
	public void onDisable(){
		instance = null;
		
		for(Entity e : Bukkit.getWorld("OfficialLobby").getEntities()){
			e.remove();
		}
	}
	
	private void loadListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new InvClick(), this);
		pm.registerEvents(new HeadsMenu(), this);
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
		pm.registerEvents(new MountMenu(), this);
		pm.registerEvents(new PetManager(this), this);
		pm.registerEvents(new Chickenator(this), this);
		pm.registerEvents(new Tsunami(this), this);
		pm.registerEvents(new ExplosiveSheep(this), this);
		pm.registerEvents(new SlimeHat(this), this);
		pm.registerEvents(new FlowerPopper(this), this);
		pm.registerEvents(new BlackHole(this), this);
		pm.registerEvents(new HeadsMenu2(), this);
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
		pm.registerEvents(new Hero(), this);
		//pm.registerEvents(new Boxer(), this);
		pm.registerEvents(new CloaksAPI(), this);
		pm.registerEvents(new GadgetsAPI(), this);
		pm.registerEvents(new PetsAPI(), this);
        pm.registerEvents(new FunCannonIce(this), this);
        pm.registerEvents(new DiamondsFountain(this), this);
        pm.registerEvents(new FireTrail(this), this);

        //SkyKeys pro SLOBBY
        if(pm.isPluginEnabled("CrateKeys")){
            if(getConfig().getString("server").contains("slobby")){
                pm.registerEvents(new SkyKeys(), this);
            }
        }
	}
	
	private void loadCommands(){
		getCommand("wlobby").setExecutor(new ProfilCMD());
		getCommand("wl").setExecutor(new ProfilCMD());
		getCommand("stats").setExecutor(new Stats_Command());
        getCommand("sbperms").setExecutor(new SBPerms_command());
        getCommand("changepassword").setExecutor(new Changepassword_Command());
	}
	
	public static Main getInstance(){
		return instance;
	}
	
	public MySQL getMySQL(){
		return this.mysql;
	}
	
	public FetchData fetchData(){
		return this.fd;
	}
	
	public SetData setData(){
		return this.sd;
	}
	
	public WakeAPI getAPI(){
		return this.api;
	}
	
	public void activeteDebug(){
		debug = true;
	}
	
	public boolean isDebug(){
		return debug;
	}
	
	public void deactivateDebug(){
		debug = false;
	}
	
	public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("WakesLobby");
    }
	
	public double getTPS(){
		return LagManager.getTPS();
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if(!channel.equalsIgnoreCase("BungeeCord")) return;
	}
	
	public CloaksAPI getCloaksAPI(){
		return cloaks;
	}
	
	public GadgetsMenu getMainGadgetsMenu(){
		return gMenu;
	}
	
	public GadgetsAPI getGadgetsAPI(){
		return gadgets;
	}
	
	public PetsAPI getPetsAPI(){
		return pets;
	}

	public Servers getServerMenu(){
	    return s;
    }

    public void addPortal(Player p){
        inPortal.add(p);
    }

    public boolean inPortal(Player p){
        return inPortal.contains(p);
    }

    public void removePortal(Player p){
        inPortal.remove(p);
    }
	
}
