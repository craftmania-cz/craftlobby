package cz.wake.plugins;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cz.wake.plugins.API.Glow;
import cz.wake.plugins.API.WakeAPI;
import cz.wake.plugins.GUI.GadgetsMenu;
import cz.wake.plugins.GUI.HeadsMenu;
import cz.wake.plugins.GUI.HeadsMenu2;
import cz.wake.plugins.GUI.MorphsMenu;
import cz.wake.plugins.GUI.MountMenu;
import cz.wake.plugins.GUI.ParticlesMenu;
import cz.wake.plugins.GUI.PetsMenu;
import cz.wake.plugins.GUI.Servers;
import cz.wake.plugins.commands.ProfilCMD;
import cz.wake.plugins.gadgets.AntiGravity;
import cz.wake.plugins.gadgets.BatBlaster;
import cz.wake.plugins.gadgets.BlackHole;
import cz.wake.plugins.gadgets.BlizzardBlaster;
import cz.wake.plugins.gadgets.Chickenator;
import cz.wake.plugins.gadgets.ColorBomb;
import cz.wake.plugins.gadgets.EtherealPearl;
import cz.wake.plugins.gadgets.ExplosiveSheep;
import cz.wake.plugins.gadgets.Fireworks;
import cz.wake.plugins.gadgets.FlowerPopper;
import cz.wake.plugins.gadgets.FunCannon;
import cz.wake.plugins.gadgets.Ghosts;
import cz.wake.plugins.gadgets.Guns;
import cz.wake.plugins.gadgets.MobGun;
import cz.wake.plugins.gadgets.PaintballGun;
import cz.wake.plugins.gadgets.Pee;
import cz.wake.plugins.gadgets.PortalGun;
import cz.wake.plugins.gadgets.SlimeHat;
import cz.wake.plugins.gadgets.SmashDown;
import cz.wake.plugins.gadgets.TNTBomb;
import cz.wake.plugins.gadgets.TNTFountain;
import cz.wake.plugins.gadgets.Trampoline;
import cz.wake.plugins.gadgets.Tsunami;
import cz.wake.plugins.gadgets.WitherCatapult;
import cz.wake.plugins.listeners.InvClick;
import cz.wake.plugins.listeners.PlayerListener;
import cz.wake.plugins.morphs.PigMorph;
import cz.wake.plugins.morphs.VillagerMorph;
import cz.wake.plugins.particles.BloodHelix;
import cz.wake.plugins.particles.Clouds;
import cz.wake.plugins.particles.ColoredDust;
import cz.wake.plugins.particles.EnderSignal;
import cz.wake.plugins.particles.FlameRings;
import cz.wake.plugins.particles.FrostLord;
import cz.wake.plugins.particles.FrozenWalk;
import cz.wake.plugins.particles.GreenSparks;
import cz.wake.plugins.particles.LavaPop;
import cz.wake.plugins.particles.Love;
import cz.wake.plugins.particles.MobSpell;
import cz.wake.plugins.particles.Notes;
import cz.wake.plugins.particles.Portal;
import cz.wake.plugins.particles.RainCloud;
import cz.wake.plugins.particles.SnowCloud;
import cz.wake.plugins.pets.ChickenNormal;
import cz.wake.plugins.pets.CowNormal;
import cz.wake.plugins.pets.IronGolemNormal;
import cz.wake.plugins.pets.OcelotNormal;
import cz.wake.plugins.pets.PetManager;
import cz.wake.plugins.pets.PigNormal;
import cz.wake.plugins.pets.SpiderNormal;

public class Main extends JavaPlugin implements PluginMessageListener{

	private static Main instance;
	private static final Logger log = Logger.getLogger("Minecraft");
	private MySQL mysql = new MySQL();
	private FetchData fd = new FetchData();
	private WakeAPI api = new WakeAPI();
	public boolean debug;
	public HashMap<Block, String> _BlocksToRestore = new HashMap();
	public static ArrayList<Entity> noFallDamageEntities = new ArrayList<>();
	public static List<CustomPlayer> customPlayers = new ArrayList<>();
	public static ArrayList<ExplosiveSheep> explosiveSheep = new ArrayList();
	public VillagerMorph VillagerMorph;
	private int playercount;
    private static ByteArrayOutputStream b = new ByteArrayOutputStream();
    private static DataOutputStream out = new DataOutputStream(b);
	
	
	public void onEnable(){
		instance = this;
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		//this.mysql.checkTable();
		registerGlow();
		loadListeners();
		loadCommands();
		debug = false;
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	}
	
	public void onDisable(){
		instance = null;
		
	}
	
	private void loadListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new InvClick(), this);
		pm.registerEvents(new HeadsMenu(), this);
		pm.registerEvents(new GadgetsMenu(), this);
		pm.registerEvents(new Guns(), this);
		pm.registerEvents(new MobGun(this), this);
		pm.registerEvents(new FunCannon(this), this);
		pm.registerEvents(new PaintballGun(this), this);
		pm.registerEvents(new TNTBomb(this), this);
		pm.registerEvents(new TNTFountain(this), this);
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
		pm.registerEvents(new PetsMenu(), this);
		pm.registerEvents(new PigNormal(), this);
		pm.registerEvents(new ChickenNormal(), this);
		pm.registerEvents(new CowNormal(), this);
		pm.registerEvents(new OcelotNormal(), this);
		pm.registerEvents(new SpiderNormal(), this);
		pm.registerEvents(new IronGolemNormal(), this);
		pm.registerEvents(new PortalGun(this), this);
		pm.registerEvents(new Chickenator(this), this);
		pm.registerEvents(new Tsunami(this), this);
		pm.registerEvents(new ExplosiveSheep(this), this);
		pm.registerEvents(new SlimeHat(this), this);
		pm.registerEvents(new FlowerPopper(this), this);
		pm.registerEvents(new EtherealPearl(this), this);
		pm.registerEvents(new BlackHole(this), this);
		pm.registerEvents(new HeadsMenu2(), this);
		pm.registerEvents(new BatBlaster(this), this);
		pm.registerEvents(new ColorBomb(this), this);
		pm.registerEvents(new WitherCatapult(this), this);
		pm.registerEvents(new Ghosts(this), this);
	}
	
	private void loadCommands(){
		getCommand("wlobby").setExecutor(new ProfilCMD());
		getCommand("wl").setExecutor(new ProfilCMD());
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
	
	public static CustomPlayer getCustomPlayer(Player player) {
        for (CustomPlayer cp : customPlayers)
            if (cp.getPlayer().getName().equals(player.getName()))
                return cp;
        return new CustomPlayer(player.getUniqueId());
    }

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		 if (!channel.equals("BungeeCord")) {
	            return;
	     }
		 
	}
	
	public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glow glow = new Glow(70);
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
	
	
}
