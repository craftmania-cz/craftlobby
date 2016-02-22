package cz.wake.plugins.listeners;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.GUI.Cloaks;
import cz.wake.plugins.GUI.GadgetsItemsMenu;
import cz.wake.plugins.GUI.GadgetsMenu;
import cz.wake.plugins.GUI.HeadsMenu;
import cz.wake.plugins.GUI.HeadsMenu2;
import cz.wake.plugins.GUI.HeadsMenu3;
import cz.wake.plugins.GUI.HeadsMenu4;
import cz.wake.plugins.GUI.Menu;
import cz.wake.plugins.GUI.StatisticsMG;
import cz.wake.plugins.GUI.MorphsMenu;
import cz.wake.plugins.GUI.MountMenu;
import cz.wake.plugins.GUI.ParticlesMenu;
import cz.wake.plugins.GUI.PetsMenu;
import cz.wake.plugins.GUI.VIPMenu;
import cz.wake.plugins.cloaks.AngleCloak;
import cz.wake.plugins.cloaks.SantaCloak;
import cz.wake.plugins.morphs.PigMorph;
import cz.wake.plugins.morphs.VillagerMorph;
import cz.wake.plugins.particles.BloodHelix;
import cz.wake.plugins.particles.CandyCane;
import cz.wake.plugins.particles.Clouds;
import cz.wake.plugins.particles.ColoredDust;
import cz.wake.plugins.particles.Enchanted;
import cz.wake.plugins.particles.EnderSignal;
import cz.wake.plugins.particles.FlameRings;
import cz.wake.plugins.particles.FrostLord;
import cz.wake.plugins.particles.FrozenWalk;
import cz.wake.plugins.particles.GreenSparks;
import cz.wake.plugins.particles.LavaPop;
import cz.wake.plugins.particles.Lily;
import cz.wake.plugins.particles.Love;
import cz.wake.plugins.particles.MobSpell;
import cz.wake.plugins.particles.Notes;
import cz.wake.plugins.particles.Portal;
import cz.wake.plugins.particles.RainCloud;
import cz.wake.plugins.particles.SantaHat;
import cz.wake.plugins.particles.SnowCloud;
import cz.wake.plugins.pets.CatBlack;
import cz.wake.plugins.pets.CatBlackBaby;
import cz.wake.plugins.pets.CatRed;
import cz.wake.plugins.pets.CatRedBaby;
import cz.wake.plugins.pets.CatSiamese;
import cz.wake.plugins.pets.CatSiameseBaby;
import cz.wake.plugins.pets.ChickenBaby;
import cz.wake.plugins.pets.ChickenNormal;
import cz.wake.plugins.pets.CowBaby;
import cz.wake.plugins.pets.CowNormal;
import cz.wake.plugins.pets.EndermiteNormal;
import cz.wake.plugins.pets.HorseBrown;
import cz.wake.plugins.pets.HorseBrownBaby;
import cz.wake.plugins.pets.PetManager;
import cz.wake.plugins.pets.PigBaby;
import cz.wake.plugins.pets.PigNormal;
import cz.wake.plugins.pets.RabbitBlack;
import cz.wake.plugins.pets.RabbitBlackBaby;
import cz.wake.plugins.pets.RabbitBrown;
import cz.wake.plugins.pets.RabbitBrownBaby;
import cz.wake.plugins.pets.RabbitGold;
import cz.wake.plugins.pets.RabbitGoldBaby;
import cz.wake.plugins.pets.SheepBrown;
import cz.wake.plugins.pets.SheepBrownBaby;
import cz.wake.plugins.pets.SheepGray;
import cz.wake.plugins.pets.SheepGrayBaby;
import cz.wake.plugins.pets.SheepSilver;
import cz.wake.plugins.pets.SheepSilverBaby;
import cz.wake.plugins.pets.SheepWhite;
import cz.wake.plugins.pets.SheepWhiteBaby;
import cz.wake.plugins.pets.SilverfishNormal;
import cz.wake.plugins.pets.WolfBaby;
import cz.wake.plugins.pets.WolfNormal;
import cz.wake.plugins.pets.ZombieBaby;
import cz.wake.plugins.pets.ZombieNormal;
import cz.wake.plugins.utils.ItemFactory;

public class InvClick implements Listener{

	StatisticsMG statistics = new StatisticsMG();
	Menu profilMenu = new Menu();
	HeadsMenu hatsMenu = new HeadsMenu();
	GadgetsItemsMenu gItems = new GadgetsItemsMenu();
	GadgetsMenu gadgetsMenu = new GadgetsMenu();
	MorphsMenu mpMenu = new MorphsMenu();
	ParticlesMenu pMenu = new ParticlesMenu();
	MountMenu mMenu = new MountMenu();
	PetsMenu petsMenu = new PetsMenu();
	HeadsMenu2 headsMenu2 = new HeadsMenu2();
	HeadsMenu3 headsMenu3 = new HeadsMenu3();
	VIPMenu vMenu = new VIPMenu();
	GreenSparks gs = new GreenSparks();
	Cloaks cl = new Cloaks();
	SantaCloak sc = new SantaCloak();
	FrostLord fl = new FrostLord();
	FlameRings fr = new FlameRings();
	SnowCloud ss = new SnowCloud();
	RainCloud rc = new RainCloud();
	BloodHelix bh = new BloodHelix();
	Portal p = new Portal();
	EnderSignal es = new EnderSignal();
	Enchanted e = new Enchanted();
	Love l = new Love();
	Notes n = new Notes();
	Clouds c = new Clouds();
	ColoredDust cd = new ColoredDust();
	LavaPop lp = new LavaPop();
	MobSpell sp = new MobSpell();
	FrozenWalk fw = new FrozenWalk();
	Lily lil = new Lily();
	SantaHat sh = new SantaHat();
	HeadsMenu4 headsMenu4 = new HeadsMenu4();
	CandyCane cc = new CandyCane();
	AngleCloak ac = new AngleCloak();
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
      Player player = (Player) event.getWhoClicked();
      //**************************** PROFILE MENU ****************************//
        if (event.getInventory().getTitle().equals(player.getName())) {
        	if(event.getSlot() == 29){
        		this.statistics.openMinigamesMenu(player);
        	}
            event.setCancelled(true);
            player.updateInventory();                   
        }
      //**************************** MiniGames VIP MENU ****************************//
        if(event.getInventory().getTitle().equals("§lSMS > MiniGames VIP")){
        	if(event.getSlot() == 26){
        		this.vMenu.openMenuSMS(player);
        	}
        }
      //**************************** SMS SERVERS MENU ****************************//
        if(event.getInventory().getTitle().equals("§lSMS > Vyber serveru")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 26){
            	this.vMenu.openVIPMenu(player);
            }
            if(event.getSlot() == 15){
            	this.vMenu.openMinigamesSMS(player);
            }
            if(event.getSlot() == 11){
            	player.playSound(player.getLocation(), Sound.ZOMBIE_WOOD, 13.0F, 1.0F);
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.sendMessage("");
            	player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
            	player.sendMessage("§b/vip");
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.closeInventory();
            }
            if(event.getSlot() == 12){
            	player.playSound(player.getLocation(), Sound.ZOMBIE_WOOD, 13.0F, 1.0F);
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.sendMessage("");
            	player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
            	player.sendMessage("§b/vip");
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.closeInventory();
            }
            if(event.getSlot() == 13){
            	player.playSound(player.getLocation(), Sound.ZOMBIE_WOOD, 13.0F, 1.0F);
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.sendMessage("");
            	player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
            	player.sendMessage("§b/vip");
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.closeInventory();
            }
            if(event.getSlot() == 14){
            	player.sendMessage("§cV soucasne dobe nedostupne!");
            }
            
        }
      //**************************** VIP MENU ****************************//
        if(event.getInventory().getTitle().equals("§lVIP Shop")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 11){
            	this.vMenu.openMenuSMS(player);
            }
            if(event.getSlot() == 15){
            	player.playSound(player.getLocation(), Sound.COW_HURT, 13.0F, 1.0F);
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.sendMessage("");
            	player.sendMessage("§eNakup pomoci Paypal/PSC provedes zde:");
            	player.sendMessage("§bhttp://store.craftmania.cz");
            	player.sendMessage("");
            	player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            	player.sendMessage("");
            	player.closeInventory();
            }
        }
      //**************************** MINIGAMES STATS ****************************//  
        if(event.getInventory().getTitle().equals(player.getName())){
        	if(event.getCurrentItem().getType() == Material.AIR)
        		return;
        	if(event.getSlot() == 35){
        		this.profilMenu.openMenu(player);
        	}
        	event.setCancelled(true);
        	player.updateInventory();
        }
      //**************************** SERVERS MENU ****************************//
        if(event.getInventory().getTitle().equals("Kam jit?")){
        	if(event.getSlot() == 10){
        		sendToServer(player, "survival");
        	}
        	if(event.getSlot() == 11){
        		sendToServer(player, "skyblock");
        	}
        	if(event.getSlot() == 12){
        		sendToServer(player, "creative");
        	}
        	if(event.getSlot() == 13){
        		sendToServer(player, "creative2");
        	}
        	if(event.getSlot() == 14){
        		sendToServer(player, "prison");
        	}
        	if(event.getSlot() == 15){
        		sendToServer(player, "vanilla");
        	}
        	if(event.getSlot() == 19){
        		player.performCommand("warp anni");
        	}
        	if(event.getSlot() == 20){
        		player.performCommand("warp sw");
        	}
        	if(event.getSlot() == 21){
        		player.performCommand("warp bedwars");
        	}
        	if(event.getSlot() == 22){
        		player.performCommand("warp drawit");
        	}
        	if(event.getSlot() == 23){
        		player.performCommand("warp anni");
        	}
        	if(event.getSlot() == 24){
        		player.performCommand("warp drawit");
        	}
        	if(event.getSlot() == 25){
        		player.performCommand("warp turfwars");
        	}
        	if(event.getSlot() == 40){
        		player.performCommand("spawn");
        	}
        }
      //**************************** GADGETS HLAVNI MENU ****************************//
        if (event.getInventory().getTitle().equals("Hlavni menu")) {
        	if(event.getSlot() == 11){
	        	this.hatsMenu.openHatsMenu(player);
	        }
	        if(event.getSlot() == 30){
	        	this.gItems.openInventory(player);
	        }
	        if(event.getSlot() == 32){
	        	if(player.hasPermission("craftlobby.pristup")){
	        		this.mpMenu.openMorphsMenu(player);
	        	} else {
	        		MessagesListener.messageNoPerm(player, "Morph Menu");
	        	}
	        }
	        if(event.getSlot() == 34){
	        	this.pMenu.openParticles(player);
	        }
	        if(event.getSlot() == 13){
	        	if(player.hasPermission("craftlobby.pristup")){
	        		this.mMenu.openMount(player);
	        	} else {
	        		MessagesListener.messageNoPerm(player, "Banner Menu");
	        	}
	        }
	        if(event.getSlot() == 28){
	        	this.petsMenu.openPets(player);
	        }
	        if(event.getSlot() == 15){
	        	this.cl.openCloaks(player);
	        }
            event.setCancelled(true);
            player.updateInventory();                   
        }
      //**************************** CLOAKS MENU ****************************//
        if(event.getInventory().getTitle().equals("Cloaks")){
        	if(event.getSlot() == 40){
        		deactivateCloaks(player);
        		player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
        		player.closeInventory();
        	}
        	if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 10){
        		if(player.hasPermission("craftlobby.cloaks.santa")){
        			deactivateCloaks(player);
        			this.sc.activateSanta(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Santa Cloak");
        		}
        	}
        	if(event.getSlot() == 11){
        		if(player.hasPermission("craftlobby.cloaks.angel")){
        			deactivateCloaks(player);
        			this.ac.activate(player);
        			player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Angel Cloak");
        		}
        	}
        }
      //**************************** PARTICLES MENU ****************************//
        if(event.getInventory().getTitle().equals("Particles")){
        	if(event.getSlot() == 40){
        		deactivateParticles(player);
        		player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
        		player.closeInventory();
        	}
        	if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 10){
        		if(player.hasPermission("craftlobby.particles.frostlord")){
        			deactivateParticles(player);
            		fl.activateFrost(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "FrostLord");
        		}
        	}
        	if(event.getSlot() == 11){
        		if(player.hasPermission("craftlobby.particles.flamerings")){
        			deactivateParticles(player);
            		fr.activateFlame(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "FlameRings");
        		}	
        	}
        	if(event.getSlot() == 12){
        		if(player.hasPermission("craftlobby.particles.snowclouds")){
        			deactivateParticles(player);
            		ss.activateSnowCloud(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "SnowClouds");
        		}
        	}
        	if(event.getSlot() == 13){
        		if(player.hasPermission("craftlobby.particles.rainclouds")){
        			deactivateParticles(player);
            		rc.activateRainCloud(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "RainClouds");
        		}
        	}
        	if(event.getSlot() == 14){
        		if(player.hasPermission("craftlobby.particles.bloodhelix")){
        			deactivateParticles(player);
            		bh.activateHelix(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "BloodHelix");
        		}
        	}
        	if(event.getSlot() == 15){
        		if(player.hasPermission("craftlobby.particles.greensparks")){
        			deactivateParticles(player);
            		gs.activateGreenSparks(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "GreenSparks");
        		}
        	}
        	if(event.getSlot() == 16){
        		if(player.hasPermission("craftlobby.particles.endersignal")){
        			deactivateParticles(player);
            		es.activateSignal(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "EnderSignal");	
        		}
        	}
        	if(event.getSlot() == 19){
        		if(player.hasPermission("craftlobby.particles.enchanted")){
        			deactivateParticles(player);
            		e.activateEnchanted(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Enchanted");
        		}
        	}
        	if(event.getSlot() == 20){
        		if(player.hasPermission("craftlobby.particles.love")){
        			deactivateParticles(player);
            		l.activateLove(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Love");
        		}
        	}
        	if(event.getSlot() == 21){
        		if(player.hasPermission("craftlobby.particles.notes")){
        			deactivateParticles(player);
            		n.activateNotes(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Notes");
        		}
        	}
        	if(event.getSlot() == 22){
        		if(player.hasPermission("craftlobby.particles.clouds")){
        			deactivateParticles(player);
            		c.activateClouds(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Clouds");
        		}
        	}
        	if(event.getSlot() == 23){
        		if(player.hasPermission("craftlobby.particles.coloreddust")){
        			deactivateParticles(player);
            		cd.activateDust(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "ColoredDust");
        		}
        	}
        	if(event.getSlot() == 24){
        		if(player.hasPermission("craftlobby.particles.lavapop")){
        			deactivateParticles(player);
            		lp.activateDust(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "LavaPop");
        		}
        	}
        	if(event.getSlot() == 25){
        		if(player.hasPermission("craftlobby.particles.portal")){
        			deactivateParticles(player);
            		p.activatePortal(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Portal");
        		}
        	}
        	if(event.getSlot() == 28){
        		if(player.hasPermission("craftlobby.particles.spell")){
        			deactivateParticles(player);
            		sp.activateSpell(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Spell");
        		}
        	}
        	if(event.getSlot() == 29){
        		if(player.hasPermission("craftlobby.particles.frozenwalk")){
        			deactivateParticles(player);
            		fw.activateFrozen(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "FrozenWalk");
        		}
        	}
        	if(event.getSlot() == 30){
        		if(player.hasPermission("craftlobby.particles.lilly")){
        			deactivateParticles(player);
            		lil.activateSignal(player);
            		player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "Lilly");
        		}
        	}
        	if(event.getSlot() == 31){
        		if(player.hasPermission("craftlobby.particles.santahat")){
        			deactivateParticles(player);
        			sh.activateHat(player);
        			player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "SantaHat");
        		}
        	}
        	if(event.getSlot() == 32){
        		if(player.hasPermission("craftlobby.particles.candycane")){
        			deactivateParticles(player);
        			cc.activate(player);
        			player.closeInventory();
        		} else {
        			MessagesListener.messageNoPerm(player, "CandyCane");
        		}
        	}
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        }
      //**************************** MOUNT MENU ****************************//
        if(event.getInventory().getTitle().equals("Mounts")){
        	if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        }
      //**************************** PETS MENU ****************************//
        if(event.getInventory().getTitle().equals("Pets")){
        	if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 40){
        		PetManager.forceRemovePet(player);
        		player.closeInventory();
        	}
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 0){
        		if(player.hasPermission("craftlobby.pets.cow")){
        			CowNormal.activateCow(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cow Pet");
        		}
        	}
        	if(event.getSlot() == 1){
        		if(player.hasPermission("craftlobby.pets.chicken")){
        			ChickenNormal.activateChicken(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Chicken Pet");
        		}
        	}
        	if(event.getSlot() == 2){
        		if(player.hasPermission("craftlobby.pets.pig")){
        			PigNormal.activatePig(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Pig Pet");
        		}
        	}
        	if(event.getSlot() == 3){
        		if(player.hasPermission("craftlobby.pets.wolf")){
        			WolfNormal.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Wolf Pet");
        		}
        	}
        	if(event.getSlot() == 4){
        		if(player.hasPermission("craftlobby.pets.silverfish")){
        			SilverfishNormal.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Silverfish Pet");
        		}
        	}
        	if(event.getSlot() == 5){
        		if(player.hasPermission("craftlobby.pets.zombie")){
        			ZombieNormal.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Zombie Pet");
        		}
        	}
        	if(event.getSlot() == 6){
        		if(player.hasPermission("craftlobby.pets.endermite")){
        			EndermiteNormal.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Endermite Pet");
        		}
        	}
        	if(event.getSlot() == 7){
        		if(player.hasPermission("craftlobby.pets.rabbit.brown")){
        			RabbitBrown.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Pet");
        		}
        	}
        	if(event.getSlot() == 8){
        		if(player.hasPermission("craftlobby.pets.rabbit.black")){
        			RabbitBlack.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Pet");
        		}
        	}
        	if(event.getSlot() == 9){
        		if(player.hasPermission("craftlobby.pets.rabbit.gold")){
        			RabbitGold.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Pet");
        		}
        	}
        	if(event.getSlot() == 10){
        		if(player.hasPermission("craftlobby.pets.cat.black")){
        			CatBlack.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Pet");
        		}
        	}
        	if(event.getSlot() == 11){
        		if(player.hasPermission("craftlobby.pets.cat.red")){
        			CatRed.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Pet");
        		}
        	}
        	if(event.getSlot() == 12){
        		if(player.hasPermission("craftlobby.pets.cat.siamese")){
        			CatSiamese.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Pet");
        		}
        	}
        	if(event.getSlot() == 13){
        		if(player.hasPermission("craftlobby.pets.sheep.white")){
        			SheepWhite.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Pet");
        		}
        	}
        	if(event.getSlot() == 14){
        		if(player.hasPermission("craftlobby.pets.sheep.gray")){
        			SheepGray.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Pet");
        		}
        	}
        	if(event.getSlot() == 15){
        		if(player.hasPermission("craftlobby.pets.sheep.brown")){
        			SheepBrown.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Pet");
        		}
        	}
        	if(event.getSlot() == 16){
        		if(player.hasPermission("craftlobby.pets.sheep.silver")){
        			SheepSilver.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Pet");
        		}
        	}
        	if(event.getSlot() == 17){
        		if(player.hasPermission("craftlobby.pets.horse.brown")){
        			HorseBrown.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Horse Pet");
        		}
        	}
        	if(event.getSlot() == 18){
        		if(player.hasPermission("craftlobby.pets.zombie.baby")){
        			ZombieBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Zombie Baby Pet");
        		}
        	}
        	if(event.getSlot() == 19){
        		if(player.hasPermission("craftlobby.pets.pig.baby")){
        			PigBaby.activatePig(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Pig Baby Pet");
        		}
        	}
        	if(event.getSlot() == 20){
        		if(player.hasPermission("craftlobby.pets.cow.baby")){
        			CowBaby.activateCow(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cow Baby Pet");
        		}
        	}
        	if(event.getSlot() == 21){
        		if(player.hasPermission("craftlobby.pets.wolf.baby")){
        			WolfBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Wolf Baby Pet");
        		}
        	}
        	if(event.getSlot() == 22){
        		if(player.hasPermission("craftlobby.pets.chicken.baby")){
        			ChickenBaby.activateChicken(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Chicken Baby Pet");
        		}
        	}
        	if(event.getSlot() == 23){
        		if(player.hasPermission("craftlobby.pets.rabbit.brown.baby")){
        			RabbitBrownBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Baby Pet");
        		}
        	} else {
        		
        	}
        	if(event.getSlot() == 24){
        		if(player.hasPermission("craftlobby.pets.rabbit.black.baby")){
        			RabbitBlackBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Baby Pet");
        		}
        	} else {
        		
        	}
        	if(event.getSlot() == 25){
        		if(player.hasPermission("craftlobby.pets.rabbit.gold.baby")){
        			RabbitGoldBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Rabbit Baby Pet");
        		}
        	}
        	if(event.getSlot() == 26){
        		if(player.hasPermission("craftlobby.pets.cat.black.baby")){
        			CatBlackBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Baby Pet");
        		}
        	}
        	if(event.getSlot() == 27){
        		if(player.hasPermission("craftlobby.pets.cat.red.baby")){
        			CatRedBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Baby Pet");
        		}
        	}
        	if(event.getSlot() == 28){
        		if(player.hasPermission("craftloby.pets.cat.siamese.baby")){
        			CatSiameseBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Cat Baby Pet");
        		}
        	}
        	if(event.getSlot() == 29){
        		if(player.hasPermission("craftlobby.pets.horse.brown.baby")){
        			HorseBrownBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Horse Baby Pet");
        		}
        	}
        	if(event.getSlot() == 30){
        		if(player.hasPermission("craftlobby.pets.sheep.white.baby")){
        			SheepWhiteBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Baby Pet");
        		}
        	}
        	if(event.getSlot() == 31){
        		if(player.hasPermission("craftlobby.pets.sheep.gray.baby")){
        			SheepGrayBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Baby Pet");
        		}
        	}
        	if(event.getSlot() == 32){
        		if(player.hasPermission("craftlobby.pets.sheep.silver.baby")){
        			SheepSilverBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Baby Pet");
        		}
        	}
        	if(event.getSlot() == 33){
        		if(player.hasPermission("craftlobby.pets.sheep.brown.baby")){
        			SheepBrownBaby.activate(player);
        		} else {
        			MessagesListener.messageNoPerm(player, "Sheep Baby Pet");
        		}
        	}
        }
      //**************************** MORPHS MENU ****************************//
        if (event.getInventory().getTitle().equals("Morphs")) {
        	if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 40){
        		DisguiseAPI.undisguiseToAll(player);
        		player.sendMessage(ChatColor.GRAY + "Zrusil jsi aktualni premenu.");
        		player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
        		player.closeInventory();
        	}
        	if(event.getSlot() == 10){
        		VillagerMorph.activate(player);
        		player.playSound(player.getLocation(), Sound.ANVIL_LAND, 15.0F, 15.0F);
        		player.sendMessage(ChatColor.BLUE + "Aktivoval jsi Villager Morph.");
        		player.closeInventory();
        	}
        	if(event.getSlot() == 11){
        		PigMorph.activate(player);
        		player.playSound(player.getLocation(), Sound.ANVIL_LAND, 15.0F, 15.0F);
        		player.sendMessage(ChatColor.BLUE + "Aktivoval jsi Pig Morph.");
        		player.closeInventory();
        	}
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
            event.setCancelled(true);
            player.updateInventory();                   
        }
      //**************************** GADGETS MENU ****************************//
        if(event.getInventory().getTitle().equals("Gadgets")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
            if(event.getSlot() == 40){
            	player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
            	player.getInventory().setItem(6, null);
        		player.closeInventory();
            }
            if(event.getSlot() == 0){
            	if(player.hasPermission("craftlobby.gadgets.teleportstick")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack wg = new ItemStack(Material.STICK);
                	ItemMeta wgMeta = wg.getItemMeta();
                	wgMeta.setDisplayName(ChatColor.RED + "TeleportStick");
                	wg.setItemMeta(wgMeta);
                	player.getInventory().setItem(6, wg);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "TeleportStick.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "TeleportStick");
            	}
            }
            if(event.getSlot() == 1){
            	if(player.hasPermission("craftlobby.gadgets.funcannon")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.GOLD_HOE);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.GOLD + "FunCannon");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "FunCannon.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "FunCannon");
            	}
            }
            if(event.getSlot() == 2){
            	if(player.hasPermission("craftlobby.gadgets.colorbomb")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.WOOL);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "ColorBomb");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "ColorBomb.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "ColorBomb");
            	}
            }
            if(event.getSlot() == 3){
            	if(player.hasPermission("craftlobby.gadgets.cookiefountain")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.COOKIE);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "CookieFountain");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "CookieFointain.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "CookieFountain");
            	}
            }
            if(event.getSlot() == 4){
            	if(player.hasPermission("craftlobby.gadgets.chikenator")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.COOKED_CHICKEN);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "Chickenator");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Chickenator.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Chickenator");
            	}
            }
            if(event.getSlot() == 5){
            	if(player.hasPermission("craftlobby.gadgets.pee")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.INK_SACK,1,(short)11);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "Pee");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Pee.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Pee");
            	}
            }
            if(event.getSlot() == 6){
            	if(player.hasPermission("craftlobby.gadgets.pigfly")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.SADDLE);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "PigFly");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "PigFly.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "PigFly");
            	}
            }
            if(event.getSlot() == 7){
            	if(player.hasPermission("craftlobby.gadgets.firework")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.FIREWORK);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "Firework");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Firework.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Firework");
            	}
            }
            if(event.getSlot() == 8){
            	if(player.hasPermission("craftlobby.gadgets.poopbomb")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.MELON_SEEDS);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "PoopBomb");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "PoopBomb.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "PoopBomb");
            	}
            }
            if(event.getSlot() == 9){
            	if(player.hasPermission("craftlobby.gadgets.tnt")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.TNT);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "TNT");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "TNT.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "TNT");
            	}
            }
            if(event.getSlot() == 10){
            	if(player.hasPermission("craftlobby.gadgets.slimehat")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.SLIME_BALL);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "SlimeHat");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "SlimeHat.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "SlimeHat");
            	}
            }
            if(event.getSlot() == 11){
            	if(player.hasPermission("craftlobby.gadgets.withercatapult")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.COAL);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "WitherCatapult");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "WitherCatapult.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "WitherCatapult");
            	}
            }
            if(event.getSlot() == 12){
            	if(player.hasPermission("craftlobby.gadgets.discoball")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.STAINED_GLASS,1,(byte)11);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "DiscoBall");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "DiscoBall.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "DiscoBall");
            	}
            }
            if(event.getSlot() == 13){
            	if(player.hasPermission("craftlobby.gadgets.blizzardblaster")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.PACKED_ICE);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "BlizzardBlaster");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "BlizzardBlaster.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "BlizzardBlaster");
            	}
            }
            if(event.getSlot() == 14){
            	if(player.hasPermission("craftlobby.gadgets.ghosts")){
            		player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
                	ItemStack fc = new ItemStack(Material.FEATHER);
                	ItemMeta fcMeta = fc.getItemMeta();
                	fcMeta.setDisplayName(ChatColor.RED + "Ghosts");
                	fc.setItemMeta(fcMeta);
                	player.getInventory().setItem(6, fc);
                	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Ghosts.");
                	player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Ghosts");
            	}
            }
            /*
            if(event.getSlot() == 1){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack mg = new ItemStack(Material.BLAZE_ROD);
            	ItemMeta mgMeta = mg.getItemMeta();
            	mgMeta.setDisplayName("§6§lMob Gun §f§l- §b§lPig");
            	mg.setItemMeta(mgMeta);
            	player.getInventory().setItem(6, mg);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "MobGun.");
            	player.closeInventory();
            }
            if(event.getSlot() == 3){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.DIAMOND_BARDING);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.AQUA + "PaintballGun");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "PaintballGun.");
            	player.closeInventory();
            }
            if(event.getSlot() == 5){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.CLAY_BALL);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "TNTFountain");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "TNTFountain.");
            	player.closeInventory();
            }
            if(event.getSlot() == 9){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.EYE_OF_ENDER);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "AntiGravity");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "AntiGravity.");
            	player.closeInventory();
            }
            if(event.getSlot() == 10){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.FIREWORK_CHARGE);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "SmashDown");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "SmashDown.");
            	player.closeInventory();
            }
            if(event.getSlot() == 11){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.HOPPER);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "Trampoline");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Trampoline.");
            	player.closeInventory();
            }
            if(event.getSlot() == 12){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.REDSTONE_COMPARATOR);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "PortalGun");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "PortalGun.");
            	player.closeInventory();
            }
            if(event.getSlot() == 14){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.WATER_BUCKET);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "Tsunami");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "Tsunami.");
            	player.closeInventory();
            }
            if(event.getSlot() == 15){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.SHEARS);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "ExplosiveSheep");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "ExplosiveSheep.");
            	player.closeInventory();
            }
            if(event.getSlot() == 17){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.RED_ROSE);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "FlowerPopper");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "FlowerPopper.");
            	player.closeInventory();
            }
            if(event.getSlot() == 18){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.ENDER_PEARL);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "EtherealPearl");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "EtherealPearl.");
            	player.closeInventory();
            }
            if(event.getSlot() == 19){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.STAINED_CLAY,1,(byte)15);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "BlackHole");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "BlackHole.");
            	player.closeInventory();
            }
            if(event.getSlot() == 20){
            	player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 15.0F, 15.0F);
            	ItemStack fc = new ItemStack(Material.IRON_BARDING);
            	ItemMeta fcMeta = fc.getItemMeta();
            	fcMeta.setDisplayName(ChatColor.RED + "BatBlaster");
            	fc.setItemMeta(fcMeta);
            	player.getInventory().setItem(6, fc);
            	player.sendMessage(ChatColor.AQUA + "Gadgets" + ChatColor.GRAY + " Aktivoval jsi " + ChatColor.GREEN + "BatBlaster.");
            	player.closeInventory();
            }*/
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        }
      //**************************** HATS MENU ****************************//
        if(event.getInventory().getTitle().equals("Heads (1 z 4 stran)")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 39){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
            if(event.getSlot() == 40){
            	player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
            	player.getInventory().setHelmet(null);
        		player.closeInventory();
            }
            if(event.getSlot() == 0){
            	if(player.hasPermission("craftlobby.heads.strawberryjam")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Strawberry Jam", "adc3ea73-5b42-4fea-a237-4a72b52dd72b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Strawberry Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Strawberry Head");
            	}
            }
            if(event.getSlot() == 1){
            	if(player.hasPermission("craftlobby.heads.oreo")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Oreo", "37dd5612-efdb-4f4b-bb55-9040a4403ff8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZkNzFlMjBmYzUwYWJmMGRlMmVmN2RlY2ZjMDFjZTI3YWQ1MTk1NTc1OWUwNzJjZWFhYjk2MzU1ZjU5NGYwIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Oreo Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Oreo Head");
            	}
            }
            if(event.getSlot() == 2){
            	if(player.hasPermission("craftlobby.heads.chocolate")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Chocolate", "eaa47b1d-cb57-48c8-af33-cf4fd9872341", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE5Zjk0OGQxNzcxOGFkYWNlNWRkNmUwNTBjNTg2MjI5NjUzZmVmNjQ1ZDcxMTNhYjk0ZDE3YjYzOWNjNDY2In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Chocolate Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Chocolate Head");
            	}
            }
            if(event.getSlot() == 3){
            	if(player.hasPermission("craftlobby.heads.whitechocolate")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("White Chocolate", "91f8d9e9-0514-4319-902f-f2662f4df272", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWVkNTUyNjBkY2NjOGRhNTkzMzhjNzVlNDFkNTQ0YTJlMWU3ZGJlZjMxYTY5ZmU0MmMwMWIzMjk4YmYyZCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "White Chocolate Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "White Chocolate Head");
            	}
            }
            if(event.getSlot() == 4){
            	if(player.hasPermission("craftlobby.heads.melon")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Melon", "983afea2-cf1b-4732-9726-c81e3f621630", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5MDMwNjZjY2M0Njk1ZTExM2ZlZTMxNGM5NmE1NDRlYjkxOTYyMmVlZTdkYWExZDE5NjYzNzRmM2ZlODQ4In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Melon Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Melon Head");
            	}
            }
            if(event.getSlot() == 5){
            	if(player.hasPermission("craftlobby.heads.hamburger")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Hamburger", "d1375075-c727-40ad-bcce-7e4277099e30", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Hamburger Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Hamburger Head");
            	}
            }
            if(event.getSlot() == 6){
            	if(player.hasPermission("craftlobby.heads.lemon")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Lemon", "09d10b7a-f525-412c-bedf-b2fe7c8bfc70", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3ZmQ1NmNhMTU5Nzg3NzkzMjRkZjUxOTM1NGI2NjM5YThkOWJjMTE5MmM3YzNkZTkyNWEzMjliYWVmNmMifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Lemon Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Lemon Head");
            	}
            }
            if(event.getSlot() == 7){
            	if(player.hasPermission("craftlobby.heads.donut")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Donut", "b48503a4-6dec-438c-a3bc-6b5da7fb1fde", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM3YzliODJiMTg2NjU2ZTlmNjM2M2EyYTFjNmE0YjViOTNjZmE5ZWY0ZGFkNmYxNmI5NGViYjVlMzYyNjc4In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Donut Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Donut Head");
            	}
            }
            if(event.getSlot() == 8){
            	if(player.hasPermission("craftlobby.heads.pepsi")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Pepsi", "92b6dbd7-11df-4702-b4d1-ec0dcc7ce114", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmJiYWU2ZGY5OWRjODJiZWFmNDlkMDY0ZGY3NGExYmJjMTVlOGUzNzY1MzMyNzY5MTJjOGM4ZmU1OWNiNGY0In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Pepsi Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Pepsi Head");
            	}
            }
            if(event.getSlot() == 9){
            	if(player.hasPermission("craftlobby.heads.cocacola")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Coca Cola", "8a145e5e-957d-418c-b000-511c971ae698", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTNiMDFmYjJmNmJhNDdjOWQ3NjM4NDkxZjM3Y2Q4NTgyYTkzNzczMTE4NmRmNGQxZWNjZDU5YjY1YmYzNyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "CocaCola Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "CocaCola Head");
            	}
            }
            if(event.getSlot() == 10){
            	if(player.hasPermission("craftlobby.heads.sprite")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Sprite", "8b8c8496-88f0-4907-bbfc-5453a2333326", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhhMzRkODZhN2JiMTNkNDVhZmRjNTBkM2RjZTVlZWQ5NWUxODQ0ZmJkZWUwY2NhNzUzYzZkMzM0NmUzMzllIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Sprite Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Sprite Head");
            	}
            }
            if(event.getSlot() == 11){
            	if(player.hasPermission("craftlobby.heads.apple")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Apple", "ebd81954-37b1-49f4-aaa1-8e79e2e3a856", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNlODY1OTQ3OGRkMjhiMWFkZTZlYmU3ZDNlMWQ2NzU4ZTIxOWY0MzhkYjc4NGE1YWRkZWRhODZlZDFhMzhhIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Apple Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Apple Head");
            	}
            }
            if(event.getSlot() == 12){
            	if(player.hasPermission("craftlobby.heads.clock")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Clock", "f952235c-44a2-4f91-a6aa-0fcf361507ac", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmRlNGUyNzgzZjg1YTM5MTIyMWRkOTE2NTZiYTY4OGU3ZTQyZDE2ZjZhYmJmYmNmYWQ5Y2E1MzYxN2ZjYTYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Clock Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Clock Head");
            	}
            }
            if(event.getSlot() == 13){
            	if(player.hasPermission("craftlobby.heads.computer")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Computer", "81c080fd-022b-477c-9f24-f637324d4c4c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlNTJhZThjOThhYzE5ZmQwNzYzN2E0NjlmZmEyNTZhYjBiM2IxMGVjZTYyNDMxODYxODhiYTM4ZGYxNTQifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Computer Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Computer Head");
            	}
            }
            if(event.getSlot() == 14){
            	if(player.hasPermission("craftlobby.heads.monitor")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Monitor", "5a929f7f-1a74-4d25-860d-40ff532acfbe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2ZjcyYzE2YjFlOWZlNmUwOTllNzZiNWY3YTg4NGZiNzgyY2ZjYzU4OGM5NWM0ZTM4M2RjNTI3ZDFiODQifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Monitor Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Monitor Head");
            	}
            }
            if(event.getSlot() == 15){
            	if(player.hasPermission("craftlobby.heads.instagram")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Instagram", "5e469ecf-80a4-40ae-8d9d-7c12bd2d3a3f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjViM2YyY2ZhMDczOWM0ZTgyODMxNmYzOWY5MGIwNWJjMWY0ZWQyN2IxZTM1ODg4NTExZjU1OGQ0Njc1In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Instagram Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Instagram Head");
            	}
            }
            if(event.getSlot() == 16){
            	if(player.hasPermission("craftlobby.heads.c4")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("C4", "8b8fcca0-6880-4108-a46a-5a21320e0d7c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRhMzMyYWJkZTMzM2ExNWE2YzZmY2ZlY2E4M2YwMTU5ZWE5NGI2OGU4ZjI3NGJhZmMwNDg5MmI2ZGJmYyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "C4 Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "C4 Head");
            	}
            }
            if(event.getSlot() == 17){
            	if(player.hasPermission("craftlobby.heads.policesiren")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Police Siren", "e8297346-5aca-4ae8-b2a3-e341b6d0921f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWFmYTU4NjMxNjA5NzkxZmZlMjVmM2E4NzlkZmJmZmVhMTE1MWY4N2JmZjYyYzU0MjNlZDYxMzZlZTAifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Police Siren Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Police Siren Head");
            	}
            }
            if(event.getSlot() == 18){
            	if(player.hasPermission("craftlobby.heads.spacehelmet")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Space Helmet", "822833e6-c3ec-457e-aeef-1fac97799e5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAyZTIyZjY1MDNjMzYzZGY2OWJmOWU5NDQ4ZmU4OWQyZjA1YmFlMzA1MzRiOGJiMTlkMjY4ZjA5ODliOTYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Space Helmet Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Space Helmet Head");
            	}
            }
            if(event.getSlot() == 19){
            	if(player.hasPermission("craftlobby.heads.facebook")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Facebook", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Facebook Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Facebook Head");
            	}
            }
            if(event.getSlot() == 20){
            	if(player.hasPermission("craftlobby.heads.youtube")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("YouTube", "4ec6d571-4553-4a75-a4ae-6e104bcc76f0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "YouTube Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Youtube Head");
            	}
            }
            if(event.getSlot() == 21){
            	if(player.hasPermission("craftlobby.heads.goldsteve")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Gold Steve", "844064fd-71f0-4aa2-a336-10bbada597d1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjkzN2UxYzQ1YmI4ZGEyOWIyYzU2NGRkOWE3ZGE3ODBkZDJmZTU0NDY4YTVkZmI0MTEzYjRmZjY1OGYwNDNlMSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Gold Steve Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Gold Steve Head");
            	}
            }
            if(event.getSlot() == 22){
            	if(player.hasPermission("craftlobby.heads.scared")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Scared", "2cd3dbb5-6136-4127-9e14-89c328660871", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM2ZTI2YzQ0NjU5ZTgxNDhlZDU4YWE3OWU0ZDYwZGI1OTVmNDI2NDQyMTE2ZjgxYjU0MTVjMjQ0NmVkOCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Scared Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Scared Head");
            	}
            }
            if(event.getSlot() == 23){
            	if(player.hasPermission("craftlobby.heads.embarrased")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Embarrased", "80e16b56-8d8c-4ea0-b3b2-dd69c7bd56cf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjcyMGRmOTExYzA1MjM3NzA2NTQwOGRiNzhhMjVjNjc4Zjc5MWViOTQ0YzA2MzkzNWFlODZkYmU1MWM3MWIifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Embarrased Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Embarrased Head");
            	}
            }
            if(event.getSlot() == 24){
            	if(player.hasPermission("craftlobby.heads.kissy")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Kissy", "c7360c40-1b10-4a11-8322-697962372596", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ1YmQxOGEyYWFmNDY5ZmFkNzJlNTJjZGU2Y2ZiMDJiZmJhYTViZmVkMmE4MTUxMjc3Zjc3OWViY2RjZWMxIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Kissy Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Kissy Head");
            	}
            }
            if(event.getSlot() == 25){
            	if(player.hasPermission("craftlobby.heads.cool")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Cool", "bcefcc41-e997-4845-ae08-7b8a1a2d51b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Cool Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Cool Head");
            	}
            }
            if(event.getSlot() == 26){
            	if(player.hasPermission("craftlobby.heads.suprised")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Suprised", "1a61537c-52d6-429d-9314-8420d631b494", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMyYjliOWFlNjIyYmQ2OGFkZmY3MTgwZjgyMDZlYzQ0OTRhYmJmYTEzMGU5NGE1ODRlYzY5MmU4OTg0YWIyIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Suprised Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Suprised Head");
            	}
            }
            if(event.getSlot() == 27){
            	if(player.hasPermission("craftlobby.heads.crying")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Crying", "b03562f3-2a20-4257-bb62-e040f552c297", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWYxYjg3NWRlNDljNTg3ZTNiNDAyM2NlMjRkNDcyZmYyNzU4M2ExZjA1NGYzN2U3M2ExMTU0YjViNTQ5OCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Crying Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Crying Head");
            	}
            }
            if(event.getSlot() == 28){
            	if(player.hasPermission("craftlobby.heads.grin")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Grin", "988770c2-3a2d-41c3-a753-b13fa383e823", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA1OWQ1OWViNGU1OWMzMWVlY2Y5ZWNlMmY5Y2YzOTM0ZTQ1YzBlYzQ3NmZjODZiZmFlZjhlYTkxM2VhNzEwIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Grin Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Grin Head");
            	}
            }
            if(event.getSlot() == 29){
            	if(player.hasPermission("craftlobby.heads.derp")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Derp", "58c6ac60-cbce-4ecb-981b-e79a87ad2bb6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JhYWJlNzI0ZWFlNTljNWQxM2Y0NDJjN2RjNWQyYjFjNmI3MGMyZjgzMzY0YTQ4OGNlNTk3M2FlODBiNGMzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Derp Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Derp Head");
            	}
            }
            if(event.getSlot() == 30){
            	if(player.hasPermission("craftlobby.heads.mustache")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Mustache", "0d7d6e4d-fb18-491b-a7b6-dbf45d923811", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYzNmYyNzI0YWE2YWE0ZGU3YWM0NmMxOWYzYzg0NWZiMTQ4NDdhNTE4YzhmN2UwM2Q3OTJjODJlZmZiMSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Mustache Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Mustache Head");
            	}
            }
            if(event.getSlot() == 31){
            	if(player.hasPermission("craftlobby.heads.smile")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Smile", "0beedb99-f64e-4a26-93f3-8f3af84050aa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZmYWNjZjE3ODc5YjE3ODkxZmM1ZWY2NjQ3MmNjMDY2YTg1YmZhMzFiNmQ3ODZjMzJhZmVlNDc5NjA2OGQifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Smile Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Smile Head");
            	}
            }
            if(event.getSlot() == 32){
            	if(player.hasPermission("craftlobby.heads.dead")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Dead", "275a74fe-e3e4-4aff-86a2-68e3fb9720d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Dead Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Dead Head");
            	}
            }
            if(event.getSlot() == 33){
            	if(player.hasPermission("craftlobby.heads.skull")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Skull", "c659cdd4-e436-4977-a6a7-d5518ebecfbb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Skull Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Skull Head");
            	}
            }
            if(event.getSlot() == 34){
            	if(player.hasPermission("craftlobby.heads.mailbox")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Mailbox", "4113ced7-576b-4c03-8a92-0937d5966ea1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFjYmJjYTU2NzM3MmE5YjJiMzZjOGY2ODE1NDg1MWJkYTVlZTFkNTNlMmJjMjA4YTExNTJkOWExOGQyY2IifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Mailbox Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Mailbox Head");
            	}
            }
            if(event.getSlot() == 35){
            	if(player.hasPermission("craftlobby.heads.texture")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("MissingTexture", "5d43c6dd-ca01-466c-9614-764449140917", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "MissingTexture Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "MissingTexture Head");
            	}
            }
            if(event.getSlot() == 41){
            	this.headsMenu2.openHeadsMenu2(player);
            }
        		
        }
      //**************************** HEADS MENU 2 ****************************//
        if(event.getInventory().getTitle().equals("Heads (2 z 4 stran)")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 39){
            	this.hatsMenu.openHatsMenu(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
            if(event.getSlot() == 40){
            	player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
            	player.getInventory().setHelmet(null);
        		player.closeInventory();
            }
            if(event.getSlot() == 41){
            	this.headsMenu3.openHeadsMenu3(player);
            }
            if(event.getSlot() == 0){
            	if(player.hasPermission("craftlobby.heads.a")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("A", "d9e6ae1b-8e1d-4ae7-8f5b-b581b1771d40", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MGRhMjk0NGExNzdkZDA4MjY4ZmJlYzA0ZTQwODEyZDFkOTI5NjUwYmU2NjUyOWIxZWU1ZTFlN2VjYSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "A Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "A Head");
            	}
            }
            if(event.getSlot() == 1){
            	if(player.hasPermission("craftlobby.heads.b")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("B", "a389402c-129b-4de2-8877-7912a1afe881", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA0MWY1ZTg2OTgzZDM2ZWFlYzRlMTY3YjJiYmI1YTM3Mjc2MDdjZGU4OGY3NTU1Y2ExYjUyMmEwMzliYiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "B Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "B Head");
            	}
            }
            if(event.getSlot() == 2){
            	if(player.hasPermission("craftlobby.heads.c")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("C", "5aafc18c-4341-4d65-bbfe-062706ffb067", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDk0NTk5NmM4YWU5MWUzNzYxOTZkNGRjNjc2ZmVjMzFmZWFjNzkwYTJmMTk1YjI5ODFhNzAzY2ExZDE2Y2I2In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "C Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "C Head");
            	}
            }
            if(event.getSlot() == 3){
            	if(player.hasPermission("craftlobby.heads.d")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("D", "2bb28566-da08-4b69-963f-da9561f1d0a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY0MTE1MGY0ODFlODQ5MmY3MTI4Yzk0ODk5NjI1NGQyZDkxZmM5MGY1YThmZjRkOGFjNWMzOWE2YTg4YSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "D Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "D Head");
            	}
            }
            if(event.getSlot() == 4){
            	if(player.hasPermission("craftlobby.heads.e")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("E", "72c35d01-c507-4efc-9184-63c32cdf4687", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGIyNTE0ODdmZjhlZWYyZWJjN2E1N2RhYjZlM2Q5ZjFkYjdmYzkyNmRkYzY2ZmVhMTRhZmUzZGZmMTVhNDUifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "E Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "E Head");
            	}
            }
            if(event.getSlot() == 5){
            	if(player.hasPermission("craftlobby.heads.f")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("F", "b46b2241-5546-48db-a457-a2dbad23db27", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U0MzM2NTZiNDQzNjY4ZWQwM2RhYzhjNDQyNzIyYTJhNDEyMjFiZThiYjQ4ZTIzYjM1YmQ4YzJlNTlmNjMifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "F Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "F Head");
            	}
            }
            if(event.getSlot() == 6){
            	if(player.hasPermission("craftlobby.heads.g")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("G", "4b0845df-5f9a-47ab-8ab7-044f810017fd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk1ODYzYjczNjM3NjA1ZmVhY2JiMTczYjc3ZDVlMTU1ZTY1MjA0Yzc4ZDVjNzkxMWY3MzhmMjhkZWI2MCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "G Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "G Head");
            	}
            }
            if(event.getSlot() == 7){
            	if(player.hasPermission("craftlobby.heads.h")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("H", "ea507bde-e39a-4e8c-b6a7-35fffed066c6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2MxZDM1OGQ5MjcwNzQyODljYzI2YmZmNWIxMjQwNzQ2ZjlmNGYwY2M0NmY5NDJmNTk4MWM2NTk1ZjcyZGQifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "H Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "H Head");
            	}
            }
            if(event.getSlot() == 8){
            	if(player.hasPermission("craftlobby.heads.i")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("I", "84143d3c-f198-461d-aecc-40741d5494fe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYyMjk1ODY1YmRhNGU0Nzk3OWQzNmI4YTg4N2E3NWExM2IwMzRlNjk4OGY3ODY3MGI2NGExZTY0NDJjIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "I Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "I Head");
            	}
            }
            if(event.getSlot() == 9){
            	if(player.hasPermission("craftlobby.heads.j")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("J", "3814608a-d3e2-49ce-9ebf-fe4c25efd882", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NDYyYjU1ZDdmNTgyMzY4MGFkMTNmMmFkYmQ3ZDFlZDQ2YmE1MTAxMDE3ZWQ0YjM3YWVlZWI3NzVkIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "J Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "J Head");
            	}
            }
            if(event.getSlot() == 10){
            	if(player.hasPermission("craftlobby.heads.k")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("K", "519c18a7-f30d-4f03-8975-9655f2360347", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzczMzI1YTkzNWMwNjdiNmVmMjI3MzY3ZjYyY2E0YmY0OWY2N2FkYjlmNmRhMzIwOTFlMmQzMmM1ZGRlMzI4In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "K Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "K Head");
            	}
            }
            if(event.getSlot() == 11){
            	if(player.hasPermission("craftlobby.heads.l")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("L", "c5d1650f-c193-4f67-be23-7eae09a66e1c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVhMWUzMzI4YzU3MWFhNDk1ZDljNWY0OTQ4MTVjY2ExNzZjM2FjYjE4NGZlYjVhN2I5Yzk2Y2U4ZTUyZmNlIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "L Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "L Head");
            	}
            }
            if(event.getSlot() == 12){
            	if(player.hasPermission("craftlobby.heads.m")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("M", "d6a7ebad-3f25-4d4c-9bf0-36b069dc38ca", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ2N2JmNmJlOTVlNWM4ZTlkMDE5NzdhMmYwYzQ4N2VkNWIwZGU1Yzg3OTYzYTJlYjE1NDExYzQ0MmZiMmIifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "M Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "M Head");
            	}
            }
            if(event.getSlot() == 13){
            	if(player.hasPermission("craftlobby.heads.n")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("N", "d621ae4e-f103-4b78-a180-c756b76b45b4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIzZTQzNGQ2Mzk1ZmU3ZTYzNDkyNDMxYmRlZTU3ODJiZDVlZTViYzhjYWI3NTU5NDY3YmRkMWY5M2I5MjVhIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "N Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "N Head");
            	}
            }
            if(event.getSlot() == 14){
            	if(player.hasPermission("craftlobby.heads.o")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("O", "425da042-932b-483d-9252-b7783871b66e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0NDU0NjZiZGM1YWQ1YmNlYTgyMjM5YzRlMWI1MTBmNmVhNTI2MmQ4MmQ4YTk2ZDcyOTFjMzQyZmI4OSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "O Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "O Head");
            	}
            }
            if(event.getSlot() == 15){
            	if(player.hasPermission("craftlobby.heads.p")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("P", "ebfde078-cc98-48f1-ac64-608c8545cc28", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkZTYwMWRlZTNmZmVjYTRkNTQ1OTVmODQ0MjAxZDBlZDIwOTFhY2VjNDU0OGM2OTZiYjE2YThhMTU4ZjYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "P Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "P Head");
            	}
            }
            if(event.getSlot() == 16){
            	if(player.hasPermission("craftlobby.heads.q")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Q", "5f94a01f-2bf4-497b-90fb-188e38055ca9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjZjYTc2OWJkZTI1ZDRjYzQxZTE5ZTQyYWRjMzVhYjRjMTU1N2I3NmFmMjMyNjQ5YWNjOTk2N2ZmMTk4ZjEzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Q Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Q Head");
            	}
            }
            if(event.getSlot() == 17){
            	if(player.hasPermission("craftlobby.heads.r")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("R", "ff745ee1-3463-473e-9e5d-db5b3f9e56a1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdhMTg4ODA1MTYyY2E1ZGQ0ZjQ2NDljNjYxZDNmNmQyM2M0MjY2MmFlZjAxNjQ1YjFhOTdmNzhiM2YxMzIxOSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "R Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "R Head");
            	}
            }
            if(event.getSlot() == 18){
            	if(player.hasPermission("craftlobby.heads.s")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("S", "7fdd4eda-abdb-4019-aa25-9c23b69f0012", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkMDlkZmQ5ZjVkZTYyNDMyMzNlMGUzMzI1YjZjMzQ3OTMzNWU3Y2NmMTNmMjQ0OGQ0ZTFmN2ZjNGEwZGYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "S Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "S Head");
            	}
            }
            if(event.getSlot() == 19){
            	if(player.hasPermission("craftlobby.heads.t")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("T", "28408552-4d4a-4830-a90e-8d2d98f84dcc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRjNzU2MTliOTFkMjQxZjY3ODM1MGFkOTIzN2MxMzRjNWUwOGQ4N2Q2ODYwNzQxZWRlMzA2YTRlZjkxIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "T Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "T Head");
            	}
            }
            if(event.getSlot() == 20){
            	if(player.hasPermission("craftlobby.heads.u")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("U", "0b7ee6c6-f3ae-43a2-b19b-0c9df57a752d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTlmNmQyYzZkNTI4NWY4ODJhZTU1ZDFlOTFiOGY5ZWZkZmM5YjM3NzIwOGJmNGM4M2Y4OGRkMTU2NDE1ZSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "U Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "U Head");
            	}
            }
            if(event.getSlot() == 21){
            	if(player.hasPermission("craftlobby.heads.v")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("V", "4a7d6a90-977e-4708-976b-c52d27ecaa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNlMjdhMTUzNjM1ZjgzNTIzN2Q4NWM2YmY3NGY1YjFmMmU2MzhjNDhmZWU4YzgzMDM4ZDA1NThkNDFkYTcifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "V Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "V Head");
            	}
            }
            if(event.getSlot() == 22){
            	if(player.hasPermission("craftlobby.heads.w")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("W", "eacab58c-56fb-46d9-97f6-c1c2cab2cf9e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVkY2Y0ZmZjYjUzYjU2ZDQyYmFhYzlkMGRmYjExOGUzNDM0NjIzMjc0NDJkZDliMjlkNDlmNTBhN2QzOGIifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "W Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "W Head");
            	}
            }
            if(event.getSlot() == 23){
            	if(player.hasPermission("craftlobby.heads.x")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("X", "1f5d7b63-569e-4d96-b7fb-ef437ef39850", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM2MThmZjEyMTc2NDBiZWM1YjUyNWZhMmE4ZTY3MWM3NWQyYTdkN2NiMmRkYzMxZDc5ZDlkODk1ZWFiMSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "X Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "X Head");
            	}
            }
            if(event.getSlot() == 24){
            	if(player.hasPermission("craftlobby.heads.y")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Y", "fd3e1792-dd5e-497a-b2af-c24a22ca75e0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDljMWQyOWEzOGJjZjExM2I3ZThjMzRlMTQ4YTc5ZjlmZTQxZWRmNDFhYThiMWRlODczYmIxZDQzM2IzODYxIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Y Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Y Head");
            	}
            }
            if(event.getSlot() == 25){
            	if(player.hasPermission("craftlobby.heads.z")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Z", "34b483d5-b7b7-4a33-b8c1-bb725969bd4a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjkyOTU3MzQxOTVkMmM3ZmEzODliOTg3NTdlOTY4NmNlNjQzN2MxNmM1OGJkZjJiNGNkNTM4Mzg5YjU5MTIifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Z Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Z Head");
            	}
            }
            if(event.getSlot() == 26){
            	if(player.hasPermission("craftlobby.heads.enderchest")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Enderchest", "42db67b6-9dd1-4bfe-b478-8829c1622218", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Enderchest Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Enderchest Head");
            	}
            }
            if(event.getSlot() == 27){
            	if(player.hasPermission("craftlobby.heads.fishtank")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("FishTank", "afcf2ba0-0405-428f-b727-c4acdda0dc75", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNlOGZkYTEzMDNiNWIzMjM5Yjk2ZWZiYTM5NWY2MjcxN2NjODc4NWJlMzJlMWQ4ODlhZmU2Yjk3YmIxYzFhIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "FishTank Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "FishTank Head");
            	}
            }
            if(event.getSlot() == 28){
            	if(player.hasPermission("craftlobby.heads.herobrine")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Herobrine", "d0b15454-36fa-43e4-a247-f882bb9fe288", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThiN2NhM2M3ZDMxNGE2MWFiZWQ4ZmMxOGQ3OTdmYzMwYjZlZmM4NDQ1NDI1YzRlMjUwOTk3ZTUyZTZjYiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Herobrine Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Herobrine Head");
            	}
            }
            if(event.getSlot() == 29){
            	if(player.hasPermission("craftlobby.heads.mummy")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Mummy", "8f7c0c5b-720f-4944-8481-b0f7931f303f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U5MWU5NTgyMmZlOThjYzVhNTY1OGU4MjRiMWI4Y2YxNGQ0ZGU5MmYwZTFhZjI0ODE1MzcyNDM1YzllYWI2In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Mummy Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Mummy Head");
            	}
            }
            if(event.getSlot() == 30){
            	if(player.hasPermission("craftlobby.heads.blackcat")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("BlackCat", "6dbe3930-9e7c-426a-a7aa-4a48e93078a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q4Y2RjYTg3Mjk2Njc5Y2EyNmFhZDY3MDQzYmYxZDQ0Yjk4MjYyMTljY2E5ZjRjNDlhNDExM2IxNzZlNGMifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "BlackCat Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "BlackCat Head");
            	}
            }
            if(event.getSlot() == 31){
            	if(player.hasPermission("craftlobby.heads.helloweenpumpkin")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("HelloweenPumpkin", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "HelloweenPumpkin Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "HelloweenPumpkin Head");
            	}
            }
            if(event.getSlot() == 32){
            	if(player.hasPermission("craftlobby.heads.devil")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Devil", "c3c88c33-f305-4c10-9303-ce658b2fbde7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRhMzkyNjllZjQ1ZjgyNWVjNjFiYjRmOGFhMDliZDNjZjA3OTk2ZmI2ZmFjMzM4YTZlOTFkNjY5OWFlNDI1In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Devil Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Devil Head");
            	}
            }
            if(event.getSlot() == 33){
            	if(player.hasPermission("craftlobby.heads.skeletonminer")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("SkeletonMiner", "fc0cbbe8-e2e2-4118-99a4-e4f811e75511", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM3ZjhmOTVjMTI1NzU3Y2JmNzY3YTExZjUyYTRlNjY5MWNlMThhMjU5NzhjNjhjZmEzOTEwMzYwZmUifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "SkeletonMiner Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "SkeletonMiner Head");
            	}
            }
            if(event.getSlot() == 34){
            	if(player.hasPermission("craftlobby.heads.witch")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Witch", "68ab540e-1ad4-4680-9fc3-b42bcf869253", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRlZGJlZTQyYmU0NzJlM2ViNzkxZTdkYmRmYWYxOGM4ZmU1OTNjNjM4YmExMzk2YzllZjY4ZjU1NWNiY2UifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Witch Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Witch Head");
            	}
            }
            if(event.getSlot() == 35){
            	if(player.hasPermission("craftlobby.heads.ghost")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Ghost", "31152fb2-cb1e-45c3-86dd-b23f7a20a6f8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkMjE4MzY0MDIxOGFiMzMwYWM1NmQyYWFiN2UyOWE5NzkwYTU0NWY2OTE2MTllMzg1NzhlYTRhNjlhZTBiNiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Ghost Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Ghost Head");
            	}
            }
        }
      //**************************** HEADS MENU 3 ****************************//
        if(event.getInventory().getTitle().equals("Heads (3 z 4 stran)")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 39){
            	this.headsMenu2.openHeadsMenu2(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
        	if(event.getSlot() == 41){
            	this.headsMenu4.openHeadsMenu4(player);
            }
            if(event.getSlot() == 40){
            	player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
            	player.getInventory().setHelmet(null);
        		player.closeInventory();
            }
            if(event.getSlot() == 0){
            	if(player.hasPermission("craftlobby.heads.evilbunny")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("EvilBunny", "e4f254ad-1413-4853-8736-10c7aa53fbaf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q0ZmRhZDVhNjEwNGFhNTQ5ZDFlNzZkNzNhM2M2ZmUzYzY3MjRiZjA5ZjdmZmNjMDJmMzNmOWVkZTdmYWRlIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "EvilBunny Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "EvilBunny Head");
            	}
            }
            if(event.getSlot() == 1){
            	if(player.hasPermission("craftlobby.heads.scaryclown")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("ScaryClown", "d1956517-9a4d-421d-8647-2d940dc64518", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZkYmMxZGViYzU3NDM4YTVkZTRiYTkxNTE1MTM4MmFiYzNkOGYxMzE4ZTJhMzVlNzhkZmIzMGYwNGJjNDY3In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "ScaryClown Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "ScaryClown Head");
            	}
            }
            if(event.getSlot() == 2){
            	if(player.hasPermission("craftlobby.heads.frankensteinsmonster")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("FrankensteinsMonster", "aec7b0b6-7bf8-46a6-b873-feb3d6277af8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjYmUwNjFiNDQ1Yjg4Y2IyZGY1OWFjY2M4ZDJjMWMxMjExOGZlMGIyMTI3ZTZlNzU4MTM1NTBhZGFjNjdjZiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "FrankensteinsMonster Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "FrankensteinsMonster Head");
            	}
            }
            if(event.getSlot() == 3){
            	if(player.hasPermission("craftlobby.heads.ogre")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Ogre", "579a7117-023d-4183-80d1-f33ab649f7ff", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNhNDc5NDZkNzI4NTgzNGVmMWUxNzYyOWY3MjgyYjY1ZTkxNDM1OTdmZTdiZjJiZTFkZTI0M2YxYzYzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Ogre Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Ogre Head");
            	}
            }
            if(event.getSlot() == 4){
            	if(player.hasPermission("craftlobby.heads.werewolf")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("WereWolf", "fdc7eb2a-0bec-408d-8f16-f8494d3960d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFjOTkzNGNkZDU1YTllNjMzNTk2MmE4Nzc2MjYwZDc5MTYxNTA4MTM0ODNlOTU2YzI4NjFiMTFhOGEyNjdmNyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "WereWolf Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "WereWolf Head");
            	}
            }
            if(event.getSlot() == 5){
            	if(player.hasPermission("craftlobby.heads.guardian")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Guardian", "2e9c0a67-92b3-4949-9be1-faf12318ee88", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Guardian Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Guardian Head");
            	}
            }
            if(event.getSlot() == 6){
            	if(player.hasPermission("craftlobby.heads.walrus")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Walrus", "a185ff1a-f32e-47e0-be61-5a612f130f33", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Walrus Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Walrus Head");
            	}
            }
            if(event.getSlot() == 7){
            	if(player.hasPermission("craftlobby.heads.batman")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Batman", "af20c020-6810-4abe-8437-97d3bff52bec", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Batman Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Batman Head");
            	}
            }
            if(event.getSlot() == 8){
            	if(player.hasPermission("craftlobby.heads.ilusionblock")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("IlusionBlock", "d27723ec-8f68-4bbf-a2b0-58f0adf0b7f9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQ2MmRkZmE1NTNjZTc4NjgzYmU0NzdiOGQ4NjU0ZjNkZmMzYWEyOTY5ODA4NDc4Yzk4N2FiODhjMzc2YTAifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "IlusionBlock Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "IlusionBlock Head");
            	}
            }
            if(event.getSlot() == 9){
            	if(player.hasPermission("craftlobby.heads.mrwakecz")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "MrWakeCZ Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "MrWakeCZ Head");
            	}
            }
            if(event.getSlot() == 10){
            	if(player.hasPermission("craftlobby.heads.bobmancz")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("BobmanCZ", "99e5d498-c467-4857-b3c1-7ec2d9c7f16d", "eyJ0aW1lc3RhbXAiOjE0NDc2MDUxNzk0NDQsInByb2ZpbGVJZCI6Ijk5ZTVkNDk4YzQ2NzQ4NTdiM2MxN2VjMmQ5YzdmMTZkIiwicHJvZmlsZU5hbWUiOiJCb2JtYW5DWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lYzVjNjljYmUwMWJmMTMxOTk5ZDNmZGQ0YTg0MjA2MzJlMmIyNTE2NTY3ZGMyZmU5N2E2M2EwNmM0ZjMzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "BobmanCZ Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "BobmanCZ Head");
            	}
            }
            if(event.getSlot() == 11){
            	if(player.hasPermission("craftlobby.heads.ccarmel")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Ccarmel", "81b28a0a-1b32-4d55-8f10-fff7021d4c23", "eyJ0aW1lc3RhbXAiOjE0NDc2MDUzNTk0OTEsInByb2ZpbGVJZCI6IjgxYjI4YTBhMWIzMjRkNTU4ZjEwZmZmNzAyMWQ0YzIzIiwicHJvZmlsZU5hbWUiOiJDY2FybWVsIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2FmODQxZWMzYzcyMDk2Y2I4MmRiZjhkYWE1OTdiMTE1MjNlMmRhMmQ1MTQwNjJlYWM5YmI2YmEwZWI0OGUxYyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Ccarmel Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Ccarmel Head");
            	}
            }
            if(event.getSlot() == 12){
            	if(player.hasPermission("craftlobby.heads.flafylp")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Flafy_LP", "63e2cc82-a760-432c-9cce-f0e297f14389", "eyJ0aW1lc3RhbXAiOjE0NDc2MDg0MDI0MDAsInByb2ZpbGVJZCI6IjYzZTJjYzgyYTc2MDQzMmM5Y2NlZjBlMjk3ZjE0Mzg5IiwicHJvZmlsZU5hbWUiOiJGbGFmeV9MUCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yN2UzZTA1YjE3ODRhNjZjZTYzM2MwM2FiOGRlZDgzMThlZTM0OGJmYWRlZGYxOWE5N2U3ZGE0MmUxM2Y3YyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Flafy_LP Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Flafy_LP Head");
            	}
            }
            if(event.getSlot() == 13){
            	if(player.hasPermission("craftlobby.heads.happymousecz")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
        			ItemStack skull = ItemFactory.createHead("HappyMouseCZ", "99f5df27-b1a3-43e8-9441-20ab49dc7a6b", "eyJ0aW1lc3RhbXAiOjE0NDc2MDg1MDYxNzAsInByb2ZpbGVJZCI6Ijk5ZjVkZjI3YjFhMzQzZTg5NDQxMjBhYjQ5ZGM3YTZiIiwicHJvZmlsZU5hbWUiOiJIYXBweU1vdXNlQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ4ZGRkZTllY2JkOTNiMTIxMzRkOWFhMjE4YzI3ZDM2NjU0ZWUwZGI0NGExZTg3ZjQ1NGVlMzg0NzVmOWQzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "HappyMouseCZ Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "HappyMouseCZ Head");
            	}
            }
            if(event.getSlot() == 14){
            	if(player.hasPermission("craftlobby.heads.delfik")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Delfik", "2ae3d9b6-d86e-4bd9-ab64-9d90b6736ce0", "eyJ0aW1lc3RhbXAiOjE0NTAyODQzOTM0MDEsInByb2ZpbGVJZCI6IjJhZTNkOWI2ZDg2ZTRiZDlhYjY0OWQ5MGI2NzM2Y2UwIiwicHJvZmlsZU5hbWUiOiJEZWxmaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFmNzY3MTRmY2ZjOWJlMzQxZTdjMmQzMzJiZDZmZmJhNzg0YWE3OTdhYTg2NTk2YmM4N2E0NjE0OTg4ZSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Delfik Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Delfik Head");
            	}
            }
            if(event.getSlot() == 15){
            	if(player.hasPermission("craftlobby.heads.fapsik")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Fapsik", "c7dbdc5b-e6de-49c9-8e67-df465898b516", "eyJ0aW1lc3RhbXAiOjE0NTAyODQ0NDUzNzQsInByb2ZpbGVJZCI6ImM3ZGJkYzViZTZkZTQ5Yzk4ZTY3ZGY0NjU4OThiNTE2IiwicHJvZmlsZU5hbWUiOiJGYXBzaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGJhMDE0NWQyODNiYzM1OTE0OGI5NDA2MjlmMWIyZGFmYmJlMGQ5YmZlODc5NTdhYWFlYzg5MzhmZjU1OWQifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Fapsik Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Fapsik Head");
            	}
            }
            if(event.getSlot() == 16){
            	if(player.hasPermission("craftlobby.heads.itzjarko")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("iTz_Jarko", "cb91e9c3-3ec1-432e-8dad-c631f9b38daf", "eyJ0aW1lc3RhbXAiOjE0NDc2MTEyNjc3MjcsInByb2ZpbGVJZCI6ImNiOTFlOWMzM2VjMTQzMmU4ZGFkYzYzMWY5YjM4ZGFmIiwicHJvZmlsZU5hbWUiOiJpVHpfSmFya28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5Yzk5MzYxMTc4MmEzZmU5NjNjNmM5ODVhYzg5ZjFjMzE2ZjMyNmU4ZmE4ZThmMmFkODVmYmYzM2UzNWFkIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "iTz_Jarko Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "iTz_Jarko Head");
            	}
            }
            if(event.getSlot() == 17){
            	if(player.hasPermission("craftlobby.heads.kapr20")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("kapr20", "e94d212c-8016-43df-9dbc-0e058bfe2adf", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE0MTczMjgsInByb2ZpbGVJZCI6ImU5NGQyMTJjODAxNjQzZGY5ZGJjMGUwNThiZmUyYWRmIiwicHJvZmlsZU5hbWUiOiJrYXByMjAiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNjM2JlOTkzOGRlZDVlYTkyMjQxNzQwNWI3OTIxMDkyZjM3OWNhZTlkYjUyYmUzNzFjZjkyNjllOTAifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "kapr20 Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "kapr20 Head");
            	}
            }
            if(event.getSlot() == 18){
            	if(player.hasPermission("craftlobby.heads.misery96")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Misery96", "f3dbccbc-73ef-4d2a-9592-e87860c1fb0b", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE1MDA1MzYsInByb2ZpbGVJZCI6ImYzZGJjY2JjNzNlZjRkMmE5NTkyZTg3ODYwYzFmYjBiIiwicHJvZmlsZU5hbWUiOiJNaXNlcnk5NiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83OGQ2ZjFlY2NjMTA2MGM5ZGY3NjZkYWUwZDU0OTJlNGVmMzYxMTIyYWZmODYyNjg1ZTE0ZGRiOGRiMjM2YyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Misery96 Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Misery96 Head");
            	}
            }
            if(event.getSlot() == 19){
            	if(player.hasPermission("craftlobby.heads.skuban9999")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Skuban9999", "2bf8e3d3-e5eb-41db-b921-64cfa0b26bcc", "eyJ0aW1lc3RhbXAiOjE0NTAyODQ1MTc3MzYsInByb2ZpbGVJZCI6IjJiZjhlM2QzZTVlYjQxZGJiOTIxNjRjZmEwYjI2YmNjIiwicHJvZmlsZU5hbWUiOiJTa3ViYW45OTk5IiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzEwNjZlNjM5Mjg5MzlhMTk4ZTEzNWI4MGE2MzlmODU4NTE1MmJjZjRkNDVkNDU5MTViYTBlMDhkZWFmZDcyIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Skuban9999 Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Skuban9999 Head");
            	}
            }
            if(event.getSlot() == 20){
            	if(player.hasPermission("craftlobby.heads.annie")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("_AnNie", "bb8146b2-647f-450b-a1c9-9c4db9e9cdcb", "eyJ0aW1lc3RhbXAiOjE0NTAyODQ1ODEzMDEsInByb2ZpbGVJZCI6ImJiODE0NmIyNjQ3ZjQ1MGJhMWM5OWM0ZGI5ZTljZGNiIiwicHJvZmlsZU5hbWUiOiJfQW5OaWUiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc4ZGI1OWJhNzFlZjNjZDcwZDJhNThjYjk2Yzc3MmI0MzhjMWEzNzdjMTQ0YWYxZTI1ZWI4NDg2OTE0YzM2In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "_AnNie Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "_AnNie Head");
            	}
            }
            if(event.getSlot() == 21){
            	if(player.hasPermission("craftlobby.heads.nedzdo")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Nedzdo", "03683a45-67a5-4444-823a-a43c49215767", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE4Nzk3ODIsInByb2ZpbGVJZCI6IjAzNjgzYTQ1NjdhNTQ0NDQ4MjNhYTQzYzQ5MjE1NzY3IiwicHJvZmlsZU5hbWUiOiJOZWR6ZG8iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5NmFlODA4Nzg2ZjYzY2E0YjE1ZWY5NDIxMWU1MWQzMjUwYjRkOWYwYjlkMTdiZDIxMWNiNTJjMTk4YjRkZCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Nedzdo Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Nedzdo Head");
            	}
            }
            if(event.getSlot() == 22){
            	if(player.hasPermission("craftlobby.heads.omgmen")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("omgmen", "e273ca85-41ac-4f1f-8bc7-915b3cd4caa5", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE5NDE1NjksInByb2ZpbGVJZCI6ImUyNzNjYTg1NDFhYzRmMWY4YmM3OTE1YjNjZDRjYWE1IiwicHJvZmlsZU5hbWUiOiJvbWdtZW4iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA3N2NlNDMzZjM2NGM2Y2IxZTY0NmQ4Y2ExMDkwZGQ1MDM3YTQwODI2NWYyNWJjZGRjY2YyOWE2NDQzNzE4In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "omgmen Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "omgmen Head");
            	}
            }
            if(event.getSlot() == 23){
            	if(player.hasPermission("craftlobby.heads.pvnst")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("PVNST", "70dc3eaa-e5e2-48b7-b94b-9fa1a0dabfbc", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE5OTY2MDAsInByb2ZpbGVJZCI6IjcwZGMzZWFhZTVlMjQ4YjdiOTRiOWZhMWEwZGFiZmJjIiwicHJvZmlsZU5hbWUiOiJQVk5TVCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lMDM1YmVkY2U1ODA2NmNlN2RjNzMyZTA1NDdlMzMyNDYzNzY3ODJlYTAzOGNkNjRjOTZlODI0YWE5OWY4OTM4In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "PVNST Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "PVNST Head");
            	}
            }
            if(event.getSlot() == 24){
            	if(player.hasPermission("craftlobby.heads.r3pl1kat0r")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("R3pl1kat0r", "379161e5-7373-4917-ba83-ca601e9f0b90", "eyJ0aW1lc3RhbXAiOjE0NDc2NzY4MjA5MDUsInByb2ZpbGVJZCI6IjM3OTE2MWU1NzM3MzQ5MTdiYTgzY2E2MDFlOWYwYjkwIiwicHJvZmlsZU5hbWUiOiJSM3BsMWthdDByIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Y1NTU1ZmFiNTRjMmY3YmVhYWY4YTUxYmI3MTRjMmMyY2FiZmY2N2MzMjI5MmZhMTNmOTEzZTI0MmIzMzQzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "R3pl1kat0r Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "R3pl1kat0r Head");
            	}
            }
            if(event.getSlot() == 25){
            	if(player.hasPermission("craftlobby.heads.radiko")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Radiko", "07ef2b1b-183d-4808-8fb8-60fba3131fd7", "eyJ0aW1lc3RhbXAiOjE0NDc2NzY4ODkwMDUsInByb2ZpbGVJZCI6IjA3ZWYyYjFiMTgzZDQ4MDg4ZmI4NjBmYmEzMTMxZmQ3IiwicHJvZmlsZU5hbWUiOiJSYWRpa28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMxMzZmZWQxMzllNzU1ODViZDNkMDQ3YzlmZjI3YzBhZDM0ZmQyZTgwMjUxY2I4ZjIyMTc1NmU0Yzk4M2Y0ZSJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Radiko Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Radiko Head");
            	}
            }
            if(event.getSlot() == 26){
            	if(player.hasPermission("craftlobby.heads.filip6cz")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Filip6_CZ", "c25f01ec-9fa8-4ff6-ae34-7286f8c44b27", "eyJ0aW1lc3RhbXAiOjE0NTAyODQ2MzgxNjQsInByb2ZpbGVJZCI6ImMyNWYwMWVjOWZhODRmZjZhZTM0NzI4NmY4YzQ0YjI3IiwicHJvZmlsZU5hbWUiOiJGaWxpcDZfQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI0NjUyMjQ2OTlmMzJlNzdkZGJjNTgzM2FjNjYzZTk1NWRmOTVmNTJmMjU0OTY5ODczOWYzZWNkODg0MjkifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Filip6_CZ Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Filip6_CZ Head");
            	}
            }
            if(event.getSlot() == 27){
            	if(player.hasPermission("craftlobby.heads.skateque")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
        			ItemStack skull = ItemFactory.createHead("SkateQue", "4049f7f9-6869-4d1b-983e-246f348603c4", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcwNTgxOTgsInByb2ZpbGVJZCI6IjQwNDlmN2Y5Njg2OTRkMWI5ODNlMjQ2ZjM0ODYwM2M0IiwicHJvZmlsZU5hbWUiOiJTa2F0ZVF1ZSIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82MjgxNzI1MWEzNTZlMWE1ZmRkMzQ2MjY3YjQ0MTIxZGYyOWRjYjBjOWJhNzQ2MGNjYjYxNmM2NTM3YTI0MyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "SkateQue Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "SkateQue Head");
            	}
            }
            if(event.getSlot() == 28){
            	if(player.hasPermission("craftlobby.heads.spexikex")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("SpexikEx", "9b72557a-b9a0-480b-829a-32128219af5d", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcxOTM1NjcsInByb2ZpbGVJZCI6IjliNzI1NTdhYjlhMDQ4MGI4MjlhMzIxMjgyMTlhZjVkIiwicHJvZmlsZU5hbWUiOiJTcGV4aWtFeCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84NjI2ZTY5ZDE4ZWNiOWI1Yjk1MzlmOGNkMTIzOGFlNTg0YzdkZmM1OWRkNGRjNGNjYzMzZjU3ZDk4YTQ3MGY3In19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "SpexikEx Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "SpexikEx Head");
            	}
            	
            }
            if(event.getSlot() == 29){
            	if(player.hasPermission("craftlobby.heads.sprajtiik")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Sprajtiik", "5bc96e8c-eb0b-4028-a433-43185ee30206", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcyOTE3ODksInByb2ZpbGVJZCI6IjViYzk2ZThjZWIwYjQwMjhhNDMzNDMxODVlZTMwMjA2IiwicHJvZmlsZU5hbWUiOiJTcHJhanRpaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmM2EzMWZjMjJiYmUyMDk0Y2E3MDIxNzM5ZGZlOWZiYmIzOWU2MGU5MjJkN2U2MDVhMTczNDZiNzU0MyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Sprajtiik Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Sprajtiik Head");
            	}
            }
            if(event.getSlot() == 30){
            	if(player.hasPermission("craftlobby.heads.spyrosvk")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("SpyroSVK", "cd31c3fd-7464-4ad8-98f6-dbbd71b9f79a", "eyJ0aW1lc3RhbXAiOjE0NDc2Nzg3NTA4NDUsInByb2ZpbGVJZCI6ImNkMzFjM2ZkNzQ2NDRhZDg5OGY2ZGJiZDcxYjlmNzlhIiwicHJvZmlsZU5hbWUiOiJTcHlyb1NWSyIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzMxYjYyNjk3MmI2MTBmOWMxOGJlNDcxNTMyNTUyZjljYTY2NTcwYjBmYzUzOTI4MTRhYWE5M2FkN2MzIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "SpyroSVK Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "SpyroSVK Head");
            	}
            }
            if(event.getSlot() == 31){
            	if(player.hasPermission("craftlobby.heads.toumancz")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("ToumanCZ", "fd51846d-197b-45cd-ac9a-8b15046ee7bd", "eyJ0aW1lc3RhbXAiOjE0NDc2Nzg4MTIzOTgsInByb2ZpbGVJZCI6ImZkNTE4NDZkMTk3YjQ1Y2RhYzlhOGIxNTA0NmVlN2JkIiwicHJvZmlsZU5hbWUiOiJUb3VtYW5DWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xMDQxM2Y3NzJkMTU3MGIyZmFlMWY2NWY5ZmZlNjZlZjRkNWE1MzkyYzFlZjk5NjI1MGNmYWU3ZTY3NDJlZCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "ToumanCZ Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "ToumanCZ Head");
            	}
            }
            if(event.getSlot() == 32){
            	if(player.hasPermission("craftlobby.heads.soony37cze")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Soony37CZE", "f4376c30-07ca-4dd3-992e-3fc9f2410c92", "eyJ0aW1lc3RhbXAiOjE0NTAyODQ2OTcyMzcsInByb2ZpbGVJZCI6ImY0Mzc2YzMwMDdjYTRkZDM5OTJlM2ZjOWYyNDEwYzkyIiwicHJvZmlsZU5hbWUiOiJTb29ueTM3Q1pFIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2U0YmY2NzgzODVlNmRkYjEzZjRhMjEzZDc4NWFkOWU1ZDFkY2NkMmQ3YmI4YmFiNTY0MjNhOGI5MCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Soony37CZE Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Soony37CZE Head");
            	}
            }
            if(event.getSlot() == 33){
            	if(player.hasPermission("craftlobby.heads.candle")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Candle", "fcc307c9-5dcd-461f-b2be-978246755e65", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjlkNWYyNWNlOWE4YmZmNWJhZDBmNTZiYjUxYjUyZmQ2MjM0NjM5NWQ2ZWM3YzY0NzE0ODRlYzdlYWJhZiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Candle Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Candle Head");
            	}
            }
            if(event.getSlot() == 34){
            	if(player.hasPermission("craftlobby.heads.candycane")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Candycane", "e2c883e6-2812-448c-bd9e-cc7e91d72913", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZiMzJiNmViYWE3MzczZWY3NDQ3Mzg1ZTBiOTYxNmI2N2VmOTgyZjY5MzQxMzcxNDI5MWZmMzVlYjAyM2MifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Candycane Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Candycane Head");
            	}
            }
            if(event.getSlot() == 35){
            	if(player.hasPermission("craftlobby.heads.starbucks")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Starbucks", "c7884dcf-5b70-4ffb-be14-7e3442fb9275", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjVmZTEzMjJjYWQ5ODM4NWE4YjdmMTFmMjdmY2ZjNTMzZThmNjQ1NWFkYjIwN2I3MGU4ODliYjIzYzYyMzdmIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Starbucks Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Starbucks Head");
            	}
            }
        }
      //**************************** HEADS MENU 4 ****************************//
        if(event.getInventory().getTitle().equals("Heads (4 z 4 stran)")){
        	event.setCancelled(true);
            player.updateInventory();
            if(event.getSlot() == 39){
            	this.headsMenu3.openHeadsMenu3(player);
            }
        	if(event.getSlot() == 49){
            	this.gadgetsMenu.openGadgetsMenu(player);
            }
            if(event.getSlot() == 40){
            	player.playSound(player.getLocation(), Sound.EXPLODE, 15.0F, 15.0F);
            	player.getInventory().setHelmet(null);
        		player.closeInventory();
            }
            if(event.getSlot() == 0){
            	if(player.hasPermission("craftlobby.heads.snowhead")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Snowhead", "da2407bc-43b4-4bbd-bd19-020258f61009", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY4MTI5NjIzZmZkZTIyY2JjNTM0OTE1YWUzOGE1ZDYwZjMyZGFlZGJjNGZkNWQyYzMxMGZlYTUzN2VkIn19fQ==");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Snowhead Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Snowhead Head");
            	}
            }
            if(event.getSlot() == 1){
            	if(player.hasPermission("craftlobby.heads.rudolf")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Rudolf", "4cf3986b-2ec9-41cf-a976-01335a6266c3", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWJkNDZiMzhiMjFiMzQyY2FmOTE3YWQ5Y2E0MmFmYjY4Mzg4YTU1OTFiY2M5YWRlZDFlOGUzNDZlMTg4OTAifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Rudolf Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Rudolf Head");
            	}
            }
            if(event.getSlot() == 2){
            	if(player.hasPermission("craftlobby.heads.snowman")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Snowman", "cac3fe21-e50a-413e-a3b4-fda3fd396034", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThlMzM0ZTRiZWUwNDI2NDc1OWE3NjZiYzE5NTVjZmFmM2Y1NjIwMTQyOGZhZmVjOGQ0YmYxYmIzNmFlNiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Snowman Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Snowman Head");
            	}
            }
            if(event.getSlot() == 3){
            	if(player.hasPermission("craftlobby.heads.snowglobe")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Snowglobe", "be6b6cbc-223a-4c98-b205-b00b7c545579", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRkNjYzMTM2Y2FmYTExODA2ZmRiY2E2YjU5NmFmZDg1MTY2YjRlYzAyMTQyYzhkNWFjODk0MWQ4OWFiNyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Snowglobe Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Snowglobe Head");
            	}
            }
            if(event.getSlot() == 4){
            	if(player.hasPermission("craftlobby.heads.present1")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("BluePresent", "9e7cfed7-6eab-419e-ade9-dcdd59c3949d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyZTk0NTFjZGIxOTZiNzgxOTVhOGYwYTRiOWMxYzBhMDRmNTgyNzg4NzkyN2I2YTgyYWFkMzljYWIyZjQzMCJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "BluePresent Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "BluePresent Head");
            	}
            }
            if(event.getSlot() == 5){
            	if(player.hasPermission("craftlobby.heads.present2")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("GoldPresent", "d8b36e98-b8ee-4cdc-ac57-f4ef5a6e74b1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0Y2RlMTZhNDAxNGRlMGE3NjUxZjYwNjdmMTI2OTViYjVmZWQ2ZmVhZWMxZTk0MTNjYTQyNzFlN2M4MTkifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "GoldPresent Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "GoldPresent Head");
            	}
            }
            if(event.getSlot() == 6){
            	if(player.hasPermission("craftlobby.heads.present3")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("GreenPresent", "4fabccc8-0092-49b6-b010-689e521857a0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDA4Y2U3ZGViYTU2YjcyNmE4MzJiNjExMTVjYTE2MzM2MTM1OWMzMDQzNGY3ZDVlM2MzZmFhNmZlNDA1MiJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "GreenPresent Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "GreenPresent Head");
            	}
            }
            if(event.getSlot() == 7){
            	if(player.hasPermission("craftlobby.heads.present4")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("RedPresent", "dca29a3a-76d3-4979-88a2-2da034b99212", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNlZjlhYTE0ZTg4NDc3M2VhYzEzNGE0ZWU4OTcyMDYzZjQ2NmRlNjc4MzYzY2Y3YjFhMjFhODViNyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "RedPresent Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "RedPresent Head");
            	}
            }
            if(event.getSlot() == 8){
            	if(player.hasPermission("craftlobby.heads.santa")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Santa", "f4b89f66-750d-4ffb-8002-90a097de4b9b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGExNTkyMzZkNzUxMmJkYjQzMjZhMjRlMTQ1MDIxNjdiNzZiY2Q4NWMwNDE5MzFjMjE5NDIwMWIxN2Y1ZTcifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Santa Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Santa Head");
            	}
            }
            if(event.getSlot() == 9){
            	if(player.hasPermission("craftlobby.heads.santa2")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
        			ItemStack skull = ItemFactory.createHead("Santa", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Santa Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Santa Head");
            	}
            }
            if(event.getSlot() == 10){
            	if(player.hasPermission("craftlobby.heads.elf")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Elf", "203a3caa-9053-468d-9b82-a5e143e54c74", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3YmU0N2JlNmY0YjI2YjA3OWM3NzU4YjY2Y2E4ODhiOWMzNGVhZWQ3MmU2ZTU4YjEzZDg3ZmZkYTBiMyJ9fX0=");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Elf Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Elf Head");
            	}
            }
            if(event.getSlot() == 11){
            	if(player.hasPermission("craftlobby.heads.elf2")){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
            		ItemStack skull = ItemFactory.createHead("Elf", "f879b9f5-ec53-472b-8626-a0b98b6bd153", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmM2ZTc5ZDE3MTc5MDJmNzFkYzU1M2M1MzczZmYyZTE3YmFlNjE5YjM5ZjhkZGJkZDIzMzgzZGQ1NWIzOTYifX19");
            		player.getInventory().setHelmet(skull);
            		player.sendMessage(ChatColor.GRAY + "Nasadil sis na hlavu " + ChatColor.GREEN + "Elf Head.");
            		player.closeInventory();
            	} else {
            		MessagesListener.messageNoPerm(player, "Elf Head");
            	}
            }
        }
        return;
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
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }
	
	public void deactivateParticles(Player player){
		if(GreenSparks.greenPlayers.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)GreenSparks.greenPlayers.get(player.getName())).intValue());
			GreenSparks.greenPlayers.remove(player.getName());
			player.closeInventory();
		}
		if(BloodHelix.bh.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)BloodHelix.bh.get(player.getName())).intValue());
			BloodHelix.bh.remove(player.getName());
			player.closeInventory();
		}
		if(RainCloud.rc.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)RainCloud.rc.get(player.getName())).intValue());
			RainCloud.rc.remove(player.getName());
			player.closeInventory();
		}
		if(FrostLord.fl.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)FrostLord.fl.get(player.getName())).intValue());
			FrostLord.fl.remove(player.getName());
			player.closeInventory();
		}
		if(FlameRings.fr.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)FlameRings.fr.get(player.getName())).intValue());
			FlameRings.fr.remove(player.getName());
			player.closeInventory();
		}
		if(SnowCloud.sc.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)SnowCloud.sc.get(player.getName())).intValue());
			SnowCloud.sc.remove(player.getName());
			player.closeInventory();
		}
		if(EnderSignal.es.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)EnderSignal.es.get(player.getName())).intValue());
			EnderSignal.es.remove(player.getName());
			player.closeInventory();
		}
		if(Enchanted.e.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Enchanted.e.get(player.getName())).intValue());
			Enchanted.e.remove(player.getName());
			player.closeInventory();
		}
		if(Love.l.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Love.l.get(player.getName())).intValue());
			Love.l.remove(player.getName());
			player.closeInventory();
		}
		if(Notes.no.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Notes.no.get(player.getName())).intValue());
			Notes.no.remove(player.getName());
			player.closeInventory();
		}
		if(Clouds.c.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Clouds.c.get(player.getName())).intValue());
			Clouds.c.remove(player.getName());
			player.closeInventory();
		}
		if(ColoredDust.cd.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)ColoredDust.cd.get(player.getName())).intValue());
			ColoredDust.cd.remove(player.getName());
			player.closeInventory();
		}
		if(LavaPop.lp.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)LavaPop.lp.get(player.getName())).intValue());
			LavaPop.lp.remove(player.getName());
			player.closeInventory();
		}
		if(Portal.port.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Portal.port.get(player.getName())).intValue());
			Portal.port.remove(player.getName());
			player.closeInventory();
		}
		if(MobSpell.ms.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)MobSpell.ms.get(player.getName())).intValue());
			MobSpell.ms.remove(player.getName());
			player.closeInventory();
		}
		if(FrozenWalk.fw.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)FrozenWalk.fw.get(player.getName())).intValue());
			FrozenWalk.fw.remove(player.getName());
			player.closeInventory();
		}
		if(Lily.li.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)Lily.li.get(player.getName())).intValue());
			Lily.li.remove(player.getName());
			player.closeInventory();
		}
		if(SantaHat.sh.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)SantaHat.sh.get(player.getName())).intValue());
			SantaHat.sh.remove(player.getName());
			player.closeInventory();
		}
		if(CandyCane.cd.containsKey(player.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)CandyCane.cd.get(player.getName())).intValue());
			CandyCane.cd.remove(player.getName());
			player.closeInventory();
		}
	}
	
	public void deactivateCloaks(Player p){
		if(SantaCloak.santaCloaks.containsKey(p.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)SantaCloak.santaCloaks.get(p.getName())).intValue());
			SantaCloak.santaCloaks.remove(p.getName());
			p.getInventory().setArmorContents(null);
			p.closeInventory();
		}
		if(AngleCloak.angelCloaks.containsKey(p.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)AngleCloak.angelCloaks.get(p.getName())).intValue());
			AngleCloak.angelCloaks.remove(p.getName());
			p.getInventory().setArmorContents(null);
			p.closeInventory();
		}
	}

}
