package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.API.TimeUtils;
import cz.wake.plugins.gadgets.GadgetsAPI;

public class GadgetsMenu implements Listener{
	
	HeadsMenu hatsMenu = new HeadsMenu();
	GadgetsAPI gItems = new GadgetsAPI();
	
	public void openGadgetsMenu(Player p){
		
		Inventory gadgetsMenu = Bukkit.createInventory(null, 54,"Hlavni menu");
		
		ItemStack petsItem = new ItemStack(Material.BONE);
		ItemMeta petsItemMeta = petsItem.getItemMeta();
		petsItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD  + "Pets");
		ArrayList<String> petsLore = new ArrayList<String>();
		petsLore.add(ChatColor.GRAY + "Kliknutim zobrazis vyber tech nejlepsich");
		petsLore.add(ChatColor.GRAY + "zviratek na serveru. Vyber si jednoho a ukaz");
		petsLore.add(ChatColor.GRAY + "vsem ktery je ten nej.");
		petsLore.add(ChatColor.GRAY + "");
		petsLore.add(countPets(p));
		petsLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		petsItemMeta.setLore(petsLore);
		petsItem.setItemMeta(petsItemMeta);
		
		ItemStack gadgetsItem = new ItemStack(Material.PISTON_BASE,1);
		ItemMeta gadgetsItemMeta = gadgetsItem.getItemMeta();
		gadgetsItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Gadgets");
		ArrayList<String> gadgetsLore = new ArrayList<String>();
		gadgetsLore.add(ChatColor.GRAY + "Kliknutim si vyberes Gadget");
		gadgetsLore.add(ChatColor.GRAY + "se kterymy se muzes vyradit v");
		gadgetsLore.add(ChatColor.GRAY + "nasem lobby.");
		gadgetsLore.add("");
		gadgetsLore.add(countGadgets(p));
		gadgetsLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		gadgetsItemMeta.setLore(gadgetsLore);
		gadgetsItem.setItemMeta(gadgetsItemMeta);
		
		ItemStack disguisesItem = new ItemStack(Material.SKULL_ITEM,1);
		SkullMeta disguisesItemMeta = (SkullMeta)disguisesItem.getItemMeta();
		disguisesItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Morphs");
		ArrayList<String> disguisesLore = new ArrayList<String>();
		disguisesLore.add(ChatColor.GRAY + "Premen se a nikdo te nepozna!");
		disguisesLore.add("");
		disguisesLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		disguisesItemMeta.setLore(disguisesLore);
		disguisesItem.setItemMeta(disguisesItemMeta);
		
		ItemStack particlesItem = new ItemStack(Material.BLAZE_POWDER,1);
		ItemMeta particlesItemMeta = particlesItem.getItemMeta();
		particlesItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Particles");
		ArrayList<String> particlesLore = new ArrayList<String>();
		particlesLore.add(ChatColor.GRAY + "Kliknutim si vyberes efekt, ktery bude");
		particlesLore.add(ChatColor.GRAY + "poletovat kolem tebe!");
		particlesLore.add("");
		particlesLore.add(countParticles(p));
		particlesLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		particlesItemMeta.setLore(particlesLore);
		particlesItem.setItemMeta(particlesItemMeta);
		
		ItemStack shopItem = new ItemStack(Material.CHEST,1);
		ItemMeta shopItemMeta = shopItem.getItemMeta();
		shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby");
		shopLore.add(ChatColor.GRAY + "daji se ziskat z CraftBoxu nebo na");
		shopLore.add(ChatColor.GRAY + "specialnich eventech.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		ItemStack wardrobeItem = new ItemStack(Material.LEATHER_HELMET, 1);
		ItemMeta wardrobeItemMeta = wardrobeItem.getItemMeta();
		wardrobeItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Heads");
		ArrayList<String> wardrobeLore = new ArrayList<String>();
		wardrobeLore.add(ChatColor.GRAY + "Nasad si na hlavu headku a bud");
		wardrobeLore.add(ChatColor.GRAY + "boss v nasem lobby!");
		wardrobeLore.add("");
		wardrobeLore.add(countHeads(p));
		wardrobeLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		wardrobeItemMeta.setLore(wardrobeLore);
		wardrobeItem.setItemMeta(wardrobeItemMeta);
		
		ItemStack banner = new ItemStack(Material.BANNER);
		BannerMeta BA5M = (BannerMeta)banner.getItemMeta();
		BA5M.setBaseColor(DyeColor.BLACK);
		BA5M.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Banners");
		ArrayList<String> mLore = new ArrayList<String>();
		mLore.add(ChatColor.GRAY + "Nasad si na hlavu banner");
		mLore.add(ChatColor.GRAY + "jako nejveci borec!");
		mLore.add("");
		mLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		BA5M.setLore(mLore);
		banner.setItemMeta(BA5M);
		
		ItemStack cloaks = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemMeta cMeta = cloaks.getItemMeta();
		cMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Cloaks");
		ArrayList<String> cLore = new ArrayList<String>();
		cLore.add(ChatColor.GRAY + "Efekty, obleky vse v");
		cLore.add(ChatColor.GRAY + "jednom co ti dodaji pravy");
		cLore.add(ChatColor.GRAY + "SWAG!");
		cLore.add("");
		cLore.add(countCloaks(p));
		cLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
		cMeta.setLore(cLore);
		cloaks.setItemMeta(cMeta);
		
		ItemStack box = new ItemStack(Material.ENDER_CHEST);
		ItemMeta bMeta = box.getItemMeta();
		bMeta.setDisplayName("§c§lNakup CraftBoxu");
		ArrayList<String> bLore = new ArrayList<String>();
		bLore.add("§7Primy nakup jednoho CrafBoxu,");
		bLore.add("§7ktery muzes okamzite otevrit!");
		bLore.add("");
		bLore.add("§ePouze 1x za 24h!");
		bLore.add("");
		bLore.add("§7Muzes si zakoupit " + getStatusBox(p));
		bLore.add("§8Cena CraftBoxu je 1000 CC");
		bMeta.setLore(bLore);
		box.setItemMeta(bMeta);
		
		gadgetsMenu.setItem(11,wardrobeItem);
		gadgetsMenu.setItem(13, banner);
		gadgetsMenu.setItem(15, cloaks);
		gadgetsMenu.setItem(28, petsItem);
		gadgetsMenu.setItem(30, gadgetsItem);
		gadgetsMenu.setItem(32, disguisesItem);
		gadgetsMenu.setItem(34, particlesItem);
		gadgetsMenu.setItem(48, shopItem);
		gadgetsMenu.setItem(50, box);
		
		p.openInventory(gadgetsMenu);
		
	}
	
	public String getStatusBox(Player p){
		long time = System.currentTimeMillis();
		long pTime = Main.getInstance().fetchData().getTimeToBuy(p.getUniqueId());
		
		if(time > pTime){
			return "§a§lIHNED";
		} else {
			return "za §b" + TimeUtils.formatTime("%hh %mm", ((pTime - time)/1000)/60, false);
		}
	}
	
	public String countHeads(Player p){
		int heads = getHeadsCount(p);
		int sum = 120;
		int prc = (heads*100/sum);
		
		return "§7Odemknuto: §f" + heads + "/" + sum + " §8(" + prc + "%)";
	}
	
	public String countCloaks(Player p){
		int cloaks = getCoaksCount(p);
		int sum = 3;
		int prc = (cloaks*100/sum);
		
		return "§7Odemknuto: §f" + cloaks + "/" + sum + " §8(" + prc + "%)";
	}
	
	public String countParticles(Player p){
		int part = getParticlesCount(p);
		int sum = 19;
		int prc = (part*100/sum);
		
		return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
	}
	
	public String countPets(Player p){
		int part = getPetsCount(p);
		int sum = 34;
		int prc = (part*100/sum);
		
		return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
	}
	
	public String countGadgets(Player p){
		int part = getGadgetsCount(p);
		int sum = 21;
		int prc = (part*100/sum);
		
		return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
	}
	
	public int getGadgetsCount(Player p){
		int c = 0;
		if(p.hasPermission("craftlobby.gadgets.teleportstick")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.funcannon")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.colorbomb")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.cookiefountain")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.chikenator")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.pee")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.pigfly")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.firework")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.poopbomb")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.tnt")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.slimehat")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.withercatapult")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.discoball")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.blizzardblaster")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.ghosts")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.tsunami")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.batblaster")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.trampoline")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.explosivesheep")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.smashdown")){
			c++;
		}
		if(p.hasPermission("craftlobby.gadgets.flowerpopper")){
			c++;
		}
		return c;
	}
	
	public int getPetsCount(Player p){
		int c = 0;
		if(p.hasPermission("craftlobby.pets.cow")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.chicken")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.pig")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.wolf")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.silverfish")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.zombie")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.endermite")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.gold")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cat.black")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cat.red")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.white")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.horse.brown")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.zombie.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.pig.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cow.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.wolf.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.chicken.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.rabbit.gold.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cat.black.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.cat.red.baby")){
			c++;
		}
		if(p.hasPermission("craftloby.pets.cat.siamese.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.horse.brown.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.white.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver.baby")){
			c++;
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown.baby")){
			c++;
		}
		return c;
	}
	
	public int getParticlesCount(Player p){
		int c = 0;
		if(p.hasPermission("craftlobby.particles.frostlord")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.flamerings")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.snowclouds")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.rainclouds")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.bloodhelix")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.greensparks")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.endersignal")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.enchanted")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.love")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.notes")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.clouds")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.coloreddust")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.lavapop")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.portal")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.spell")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.frozenwalk")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.lilly")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.santahat")){
			c++;
		}
		if(p.hasPermission("craftlobby.particles.candycane")){
			c++;
		}
		return c;
	}
	
	public int getCoaksCount(Player p){
		int c = 0;
		if(p.hasPermission("craftlobby.cloaks.santa")){
			c++;
		}
		if(p.hasPermission("craftlobby.cloaks.angel")){
			c++;
		}
		if(p.hasPermission("craftlobby.cloaks.hero")){
			c++;
		}
		return c;
	}
	
	public int getHeadsCount(Player p){
		int c = 0;
		if(p.hasPermission("craftlobby.heads.strawberryjam")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.oreo")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.chocolate")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.whitechocolate")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.melon")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.hamburger")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.lemon")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.donut")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.pepsi")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.cocacola")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.sprite")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.apple")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.clock")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.computer")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.monitor")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.instagram")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.c4")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.policesiren")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.spacehelmet")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.facebook")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.youtube")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.goldsteve")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.scared")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.embarrased")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.kissy")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.cool")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.suprised")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.crying")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.grin")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.derp")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.mustache")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.smile")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.dead")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.skull")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.mailbox")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.texture")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.a")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.b")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.c")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.d")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.e")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.f")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.g")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.h")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.i")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.j")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.k")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.l")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.m")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.n")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.o")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.p")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.q")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.r")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.s")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.t")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.u")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.v")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.w")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.x")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.y")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.z")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.enderchest")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.fishtank")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.herobrine")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.mummy")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.blackcat")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.helloweenpumpkin")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.devil")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.skeletonminer")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.witch")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.ghost")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.evilbunny")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.scaryclown")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.frankensteinsmonster")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.ogre")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.werewolf")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.guardian")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.walrus")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.batman")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.ilusionblock")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.mrwakecz")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.bobmancz")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.ccarmel")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.flafylp")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.happymousecz")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.delfik")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.fapsik")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.itzjarko")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.kapr20")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.misery96")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.skuban9999")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.annie")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.nedzdo")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.omgmen")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.pvnst")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.r3pl1kat0r")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.radiko")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.filip6cz")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.skateque")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.spexikex")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.sprajtiik")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.spyrosvk")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.toumancz")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.soony37cze")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.candle")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.candycane")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.starbucks")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.snowhead")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.rudolf")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.snowman")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.snowglobe")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.present1")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.present2")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.present3")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.present4")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.santa")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.santa2")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.elf")){
			c++;
		}
		if(p.hasPermission("craftlobby.heads.elf2")){
			c++;
		}
		return c;
	}

}
