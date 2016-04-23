package cz.wake.plugins.GUI;

import java.sql.Time;
import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.API.TimeUtils;
import cz.wake.plugins.utils.ItemFactory;

public class Servers implements Listener{
	
	public void openServersMenu(Player p){
		
		Inventory serverMenu = Bukkit.createInventory(null, 45, "Kam jit?");
		
		ItemStack survival = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta sMeta = survival.getItemMeta();
		sMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Survival §b§l1.8");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add(ChatColor.DARK_GRAY + "PVP");
		sLore.add("");
		sLore.add(ChatColor.GRAY + "Stan se legendou, zacni od");
		sLore.add(ChatColor.GRAY + "uplneho zacatku az po bohace!");
		sLore.add("");
		sLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		sMeta.setLore(sLore);
		survival.setItemMeta(sMeta);
		
		ItemStack skyblock = new ItemStack(Material.COOKIE);
		ItemMeta skMeta = skyblock.getItemMeta();
		skMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Skyblock §c§l1.9");
		ArrayList<String> skLore = new ArrayList<String>();
		skLore.add(ChatColor.DARK_GRAY + "PVP");
		skLore.add("");
		skLore.add(ChatColor.GRAY + "Sam a opusteny na ostrove,");
		skLore.add(ChatColor.GRAY + "dokazes prezit? Nebo ne?");
		skLore.add("");
		skLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		skMeta.setLore(skLore);
		skyblock.setItemMeta(skMeta);
		
		ItemStack creative = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta cMeta = creative.getItemMeta();
		cMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Creative §c§l1.9");
		ArrayList<String> cLore = new ArrayList<String>();
		cLore.add(ChatColor.DARK_GRAY + "NO-PVP");
		cLore.add("");
		cLore.add(ChatColor.GRAY + "Umis stavet? Nebo si chces");
		cLore.add(ChatColor.GRAY + "jenom tak stavet a trenovat");
		cLore.add(ChatColor.GRAY + "na BuildEvent?");
		cLore.add("");
		cLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		cMeta.setLore(cLore);
		creative.setItemMeta(cMeta);
		
		ItemStack creative2 = new ItemStack(Material.WATER_BUCKET);
		ItemMeta cMeta2 = creative2.getItemMeta();
		cMeta2.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Creative #2 §c§l1.9");
		ArrayList<String> cLore2 = new ArrayList<String>();
		cLore2.add(ChatColor.DARK_GRAY + "NO-PVP");
		cLore2.add("");
		cLore2.add(ChatColor.GRAY + "Bylo narvano, tak je tu");
		cLore2.add(ChatColor.GRAY + "dalsi server! :O");
		cLore2.add("");
		cLore2.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		cMeta2.setLore(cLore2);
		creative2.setItemMeta(cMeta2);
		
		ItemStack prison = new ItemStack(Material.getMaterial(101));
		ItemMeta pMeta = prison.getItemMeta();
		pMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Prison §c§l1.9");
		ArrayList<String> pLore = new ArrayList<String>();
		pLore.add(ChatColor.DARK_GRAY + "PVP");
		pLore.add("");
		pLore.add(ChatColor.GRAY + "Legendarni server prvni v CZ/SK!");
		pLore.add(ChatColor.GRAY + "Uchop krumpac a ukaz svetu,");
		pLore.add(ChatColor.GRAY + "ze byla chyba te tam pustit!");
		pLore.add("");
		pLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		pMeta.setLore(pLore);
		prison.setItemMeta(pMeta);
		
		ItemStack vanilla = new ItemStack(Material.EMERALD);
		ItemMeta vMeta = vanilla.getItemMeta();
		vMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Vanilla §c§l1.9");
		ArrayList<String> vLore = new ArrayList<String>();
		vLore.add(ChatColor.DARK_GRAY + "PVP");
		vLore.add("");
		vLore.add(ChatColor.GRAY + "Zakladni Minecraft bez prikazu");
		vLore.add(ChatColor.GRAY + "pluginu atd. Ta prava hra o preziti!");
		vLore.add("");
		vLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		vMeta.setLore(vLore);
		vanilla.setItemMeta(vMeta);
		
		ItemStack anni = new ItemStack(Material.ENDER_STONE);
		ItemMeta aMeta = anni.getItemMeta();
		aMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Annihilation §b§l1.8 §7+ §c§l1.9");
		ArrayList<String> aLore = new ArrayList<String>();
		aLore.add(ChatColor.DARK_GRAY + "PVP");
		aLore.add("");
		aLore.add(ChatColor.GRAY + "Teamova hra, znic Nexus driv");
		aLore.add(ChatColor.GRAY + "nez ho znici tobe a vyhraj!");
		aLore.add("");
		aLore.add(ChatColor.GRAY + "Coins Multiplier: 1.0x");
		aLore.add("");
		aLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		aMeta.setLore(aLore);
		anni.setItemMeta(aMeta);
		
		ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta skyMeta = skywars.getItemMeta();
		skyMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "SkyWars §b§l1.8 §7+ §c§l1.9");
		ArrayList<String> skyLore = new ArrayList<String>();
		skyLore.add(ChatColor.DARK_GRAY + "PVP");
		skyLore.add("");
		skyLore.add(ChatColor.GRAY + "Kazdy sam za sebe proti az 16 hracum!");
		skyLore.add(ChatColor.GRAY + "Klasicky SkyWars");
		skyLore.add("");
		skyLore.add(ChatColor.GRAY + "Coins Multiplier: 1.0x");
		skyLore.add("");
		skyLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		skyMeta.setLore(skyLore);
		skywars.setItemMeta(skyMeta);
		
		ItemStack bedwars = new ItemStack(Material.BED);
		bedwars = ItemFactory.addGlow(bedwars);
		ItemMeta bedMeta = bedwars.getItemMeta();
		bedMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "BedWars §c§l1.9");
		ArrayList<String> bedLore = new ArrayList<String>();
		bedLore.add(ChatColor.DARK_GRAY + "PVP");
		bedLore.add("");
		bedLore.add(ChatColor.GRAY + "Hra podobna Annihilation");
		bedLore.add(ChatColor.GRAY + "4 teamy, 4 postele, 1 vitez!");
		bedLore.add("");
		bedLore.add(ChatColor.GRAY + "Coins Multiplier: §63.0x");
		bedLore.add("");
		bedLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		bedMeta.setLore(bedLore);
		bedwars.setItemMeta(bedMeta);
		
		ItemStack drawit = new ItemStack(Material.PAINTING);
		drawit = ItemFactory.addGlow(drawit);
		ItemMeta drawMeta = drawit.getItemMeta();
		drawMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "DrawIt §c§l1.9");
		ArrayList<String> drawLore = new ArrayList<String>();
		drawLore.add(ChatColor.DARK_GRAY + "NO-PVP");
		drawLore.add("");
		drawLore.add(ChatColor.GRAY + "Nakreslit zadany predmet neni");
		drawLore.add(ChatColor.GRAY + "jenom tak jednoduche!");
		drawLore.add(ChatColor.GRAY + "Jeste tezsi je ho uhadnout.");
		drawLore.add("");
		drawLore.add(ChatColor.GRAY + "Coins Multiplier: §63.0x");
		drawLore.add("");
		drawLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		drawMeta.setLore(drawLore);
		drawit.setItemMeta(drawMeta);
		
		ItemStack uhc = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta uMeta = uhc.getItemMeta();
		uMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "UHC Run §b§l1.8 §7+ §c§l1.9");
		ArrayList<String> uhcLore = new ArrayList<String>();
		uhcLore.add(ChatColor.DARK_GRAY + "PVP");
		uhcLore.add("");
		uhcLore.add(ChatColor.GRAY + "Overis si zda umis hrat?");
		uhcLore.add(ChatColor.GRAY + "Dokazes prezit a zachranit se?");
		uhcLore.add(ChatColor.GRAY + "Nebo zemres jako my vsichni?");
		uhcLore.add("");
		uhcLore.add(ChatColor.GRAY + "Coins Multiplier: 1.0x");
		uhcLore.add("");
		uhcLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		uMeta.setLore(uhcLore);
		uhc.setItemMeta(uMeta);
		
		ItemStack bb = new ItemStack(Material.WORKBENCH);
		bb = ItemFactory.addGlow(bb);
		ItemMeta bbMeta = bb.getItemMeta();
		bbMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Build Battle §c§l1.9");
		ArrayList<String> bbLore = new ArrayList<String>();
		bbLore.add(ChatColor.DARK_GRAY + "Arcade");
		bbLore.add("");
		bbLore.add(ChatColor.GRAY + "Kreslit umis a co treba stavet?");
		bbLore.add(ChatColor.GRAY + "Dokazes postavit zadane veci v casovem");
		bbLore.add(ChatColor.GRAY + "intervale a vyhrat?");
		bbLore.add("");
		bbLore.add(ChatColor.GRAY + "Coins Multiplier: §63.0x");
		bbLore.add("");
		bbLore.add(ChatColor.AQUA + "▸ Kliknutim te portnu");
		bbMeta.setLore(bbLore);
		bb.setItemMeta(bbMeta);
		
		ItemStack tw = new ItemStack(Material.WOOL,1,(byte)3);
		ItemMeta twMeta = tw.getItemMeta();
		twMeta.setDisplayName("§e§lTurfWars §b§l1.8 §7+ §c§l1.9");
		ArrayList<String> twLore = new ArrayList<String>();
		twLore.add("§8TEAM PVP");
		twLore.add("");
		twLore.add("§7Dva teamy proti sobe");
		twLore.add("§7a vyhraje pouze jeden!");
		twLore.add("§7Ve kterem budes ty?");
		twLore.add("");
		twLore.add("§7Coins Multiplier: 1.0x");
		twLore.add("");
		twLore.add("§a▸ Kliknutim te portnu");
		twMeta.setLore(twLore);
		tw.setItemMeta(twMeta);
		
		
		new BukkitRunnable() {

			@Override
			public void run() {
				ItemStack factions = new ItemStack(Material.TNT);
				ItemMeta facMeta = factions.getItemMeta();
				facMeta.setDisplayName("§c§lFactions");
				ArrayList<String> facLore = new ArrayList<String>();
				facLore.add("");
				facLore.add("§7Tvrdili, ze preziji jenom ti nejlepsi,");
				facLore.add("§7bude tedy tvuj team na vrcholu?");
				facLore.add("§7Zit nebo zemrit, vyber si!");
				facLore.add("");
				facLore.add("§cZbyvajici cas: §f" + countTime());
				facMeta.setLore(facLore);
				factions.setItemMeta(facMeta);
				serverMenu.setItem(16, factions);
				
			}
			
		}.runTaskTimerAsynchronously(Main.getInstance(), 0, 600);
		
		
		ItemStack pripravujeme = new ItemStack(Material.STAINED_GLASS);
		ItemMeta priMeta = pripravujeme.getItemMeta();
		priMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pripravujeme");
		ArrayList<String> priLore = new ArrayList<String>();
		priLore.add("");
		priLore.add(ChatColor.GRAY + "Jiz brzy neco noveho...");
		priMeta.setLore(priLore);
		pripravujeme.setItemMeta(priMeta);
		
		serverMenu.setItem(10, survival);
		serverMenu.setItem(11, skyblock);
		serverMenu.setItem(12, creative);
		serverMenu.setItem(13, creative2);
		serverMenu.setItem(14, prison);
		serverMenu.setItem(15, vanilla);
		
		serverMenu.setItem(19, anni);
		serverMenu.setItem(20, skywars);
		serverMenu.setItem(21, bedwars);
		serverMenu.setItem(22, drawit);
		serverMenu.setItem(23, uhc);
		serverMenu.setItem(24, bb);
		serverMenu.setItem(25, tw);
		
		p.openInventory(serverMenu);
		
	}
	
	private String countTime(){
		long time = System.currentTimeMillis();
		long pTime = 1462053600000L;

		return TimeUtils.formatTime("%d dni, %hh %mm", ((pTime - time)/1000)/60, false);
	}


}
