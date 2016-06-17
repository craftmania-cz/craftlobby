package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.API.TimeUtils;

public class StatisticsMG {
	
	public void openMinigamesMenu(Player p){
		
		Inventory minigamesMenu = Bukkit.createInventory(null, 45, p.getName());
		
		SkullMeta headItemMeta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		headItemMeta.setOwner(p.getName());
		headItemMeta.setDisplayName("§f§lStatistiky: §7" + p.getName());
		ArrayList<String> hLore = new ArrayList<String>();
		hLore.add("");
		hLore.add("§eCraftCoiny: §f" + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
		headItemMeta.setLore(hLore);
		ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		headItem.setItemMeta(headItemMeta);
		
		ItemStack bedwars = new ItemStack(Material.BED);
		ItemMeta bedwarsMeta = bedwars.getItemMeta();
		bedwarsMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BedWars");
		ArrayList<String> bedwarsLore = new ArrayList<String>();
		bedwarsLore.add("");
		bedwarsLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsScore(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsWins(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsLoses(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsKills(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDeaths(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Zniceno posteli: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDestroyed(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsPlayed(p.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p.getUniqueId()), false)*/);
		bedwarsMeta.setLore(bedwarsLore);
		bedwars.setItemMeta(bedwarsMeta);
		
		ItemStack drawit = new ItemStack(Material.PAINTING);
		ItemMeta drawitMeta = drawit.getItemMeta();
		drawitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "DrawIt");
		ArrayList<String> drawitLore = new ArrayList<String>();
		drawitLore.add("");
		drawitLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitScore(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWins(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitLoses(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Spravne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitRightGuess(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Spatne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWrongGuess(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitPlayed(p.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p.getUniqueId()), false));
		drawitMeta.setLore(drawitLore);
		drawit.setItemMeta(drawitMeta);
		
		ItemStack uhc = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta uhcMeta = uhc.getItemMeta();
		uhcMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "UltraHardcore");
		ArrayList<String> uhcLore = new ArrayList<String>();
		uhcLore.add("");
		uhcLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKills(p.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCDeaths(p.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Killstreak: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKillstreak(p.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Polozene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockPlaced(p.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Znicene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockBroken(p.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getUHCTime(p.getUniqueId()), false));
		uhcMeta.setLore(uhcLore);
		uhc.setItemMeta(uhcMeta);
		
		ItemStack anni = new ItemStack(Material.ENDER_STONE);
		ItemMeta anniMeta = anni.getItemMeta();
		anniMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Annihilation");
		ArrayList<String> anniLore = new ArrayList<String>();
		anniLore.add("");
		anniLore.add(ChatColor.YELLOW + "§cTyto statistiky jsou aktualne nefunkcni.");
		anniMeta.setLore(anniLore);
		anni.setItemMeta(anniMeta);
		
		ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
		ItemMeta bMeta = buildbattle.getItemMeta();
		bMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BuildBattle");
		ArrayList<String> bbLore = new ArrayList<String>();
		bbLore.add("");
		bbLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildWins(p.getUniqueId()));
		bbLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildPlayedGames(p.getUniqueId()));
		//bbLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBuildBattleTime(p.getUniqueId()), false));
		bMeta.setLore(bbLore);
		buildbattle.setItemMeta(bMeta);
		
		ItemStack vanilla = new ItemStack(Material.EMERALD);
		ItemMeta vanMeta = vanilla.getItemMeta();
		vanMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Vanilla");
		ArrayList<String> vanLore = new ArrayList<String>();
		vanLore.add("");
		vanLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaKills(p.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaDeaths(p.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Zniceno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockBroken(p.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Polozeno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockPlaced(p.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getVanillaTime(p.getUniqueId()), false));
		vanMeta.setLore(vanLore);
		vanilla.setItemMeta(vanMeta);
		
		ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta swMeta = skywars.getItemMeta();
		swMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "SkyWars");
		ArrayList<String> swLore = new ArrayList<String>();
		swLore.add("");
		swLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsKills(p.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsDeaths(p.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsWins(p.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsPlayed(p.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Odehrany cas: §cNenalezeno...");
		swMeta.setLore(swLore);
		skywars.setItemMeta(swMeta);
		
		ItemStack turfwars = new ItemStack(Material.WOOL,1,(byte)3);
		ItemMeta twMeta = turfwars.getItemMeta();
		twMeta.setDisplayName("§f§lTurfWars");
		ArrayList<String> twLore = new ArrayList<String>();
		twLore.add("");
		twLore.add("§eZabiti: §f" + Main.getInstance().getAPI().getTurfWarsKills(p.getUniqueId()));
		twLore.add("§eVitezstvi: §f" + Main.getInstance().getAPI().getTurfWarsWins(p.getUniqueId()));
		twLore.add("§eProhry: §f" + Main.getInstance().getAPI().getTurfWarsLosses(p.getUniqueId()));
		twLore.add("§eOdehrany cas: §cNenalezeno...");
		twMeta.setLore(twLore);
		turfwars.setItemMeta(twMeta);
		
		if(p.hasPermission("craftlobby.stats.vip")){
			ItemStack info = new ItemStack(Material.ARROW);
			ItemMeta iMeta = info.getItemMeta();
			iMeta.setDisplayName("§a§lZobrazeni statistik hracu");
			ArrayList<String> iLore = new ArrayList<String>();
			iLore.add("");
			iLore.add("§7Statistiky urciteho hrace zobrazis §b/stats nick");
			iMeta.setLore(iLore);
			info.setItemMeta(iMeta);
			minigamesMenu.setItem(36, info);
		}
		
		minigamesMenu.setItem(13, headItem);
		minigamesMenu.setItem(20, bedwars);
		minigamesMenu.setItem(21, drawit);
		minigamesMenu.setItem(22, uhc);
		minigamesMenu.setItem(23, anni);
		minigamesMenu.setItem(24, buildbattle);
		minigamesMenu.setItem(30, turfwars);
		minigamesMenu.setItem(31, skywars);
		minigamesMenu.setItem(32, vanilla);
		
		
		p.openInventory(minigamesMenu);
	}
	
	public void openOfflineStats(Player p, OfflinePlayer op){
		
		Inventory minigamesMenu = Bukkit.createInventory(null, 45, op.getName());
		
		SkullMeta headItemMeta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		headItemMeta.setOwner(op.getName());
		headItemMeta.setDisplayName("§f§lStatistiky: §7" + op.getName());
		ArrayList<String> hLore = new ArrayList<String>();
		hLore.add("");
		hLore.add("§eCraftCoiny: §f" + Main.getInstance().getAPI().getCraftCoins(op.getUniqueId()) + " CC");
		headItemMeta.setLore(hLore);
		ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		headItem.setItemMeta(headItemMeta);
		
		ItemStack bedwars = new ItemStack(Material.BED);
		ItemMeta bedwarsMeta = bedwars.getItemMeta();
		bedwarsMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BedWars");
		ArrayList<String> bedwarsLore = new ArrayList<String>();
		bedwarsLore.add("");
		bedwarsLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsScore(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsWins(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsLoses(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsKills(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDeaths(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Zniceno posteli: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDestroyed(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsPlayed(op.getUniqueId()));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(op.getUniqueId()), false)*/);
		bedwarsMeta.setLore(bedwarsLore);
		bedwars.setItemMeta(bedwarsMeta);
		
		ItemStack drawit = new ItemStack(Material.PAINTING);
		ItemMeta drawitMeta = drawit.getItemMeta();
		drawitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "DrawIt");
		ArrayList<String> drawitLore = new ArrayList<String>();
		drawitLore.add("");
		drawitLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitScore(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWins(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitLoses(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Spravne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitRightGuess(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Spatne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWrongGuess(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitPlayed(op.getUniqueId()));
		drawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(op.getUniqueId()), false));
		drawitMeta.setLore(drawitLore);
		drawit.setItemMeta(drawitMeta);
		
		ItemStack uhc = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta uhcMeta = uhc.getItemMeta();
		uhcMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "UltraHardcore");
		ArrayList<String> uhcLore = new ArrayList<String>();
		uhcLore.add("");
		uhcLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKills(op.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCDeaths(op.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Killstreak: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKillstreak(op.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Polozene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockPlaced(op.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Znicene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockBroken(op.getUniqueId()));
		uhcLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getUHCTime(op.getUniqueId()), false));
		uhcMeta.setLore(uhcLore);
		uhc.setItemMeta(uhcMeta);
		
		ItemStack anni = new ItemStack(Material.ENDER_STONE);
		ItemMeta anniMeta = anni.getItemMeta();
		anniMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Annihilation");
		ArrayList<String> anniLore = new ArrayList<String>();
		anniLore.add("");
		anniLore.add(ChatColor.YELLOW + "§cTyto statistiky jsou aktualne nefunkcni.");
		anniMeta.setLore(anniLore);
		anni.setItemMeta(anniMeta);
		
		ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
		ItemMeta bMeta = buildbattle.getItemMeta();
		bMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BuildBattle");
		ArrayList<String> bbLore = new ArrayList<String>();
		bbLore.add("");
		bbLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildWins(op.getUniqueId()));
		bbLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildPlayedGames(op.getUniqueId()));
		bbLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBuildBattleTime(op.getUniqueId()), false));
		bMeta.setLore(bbLore);
		buildbattle.setItemMeta(bMeta);
		
		ItemStack vanilla = new ItemStack(Material.EMERALD);
		ItemMeta vanMeta = vanilla.getItemMeta();
		vanMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Vanilla");
		ArrayList<String> vanLore = new ArrayList<String>();
		vanLore.add("");
		vanLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaKills(op.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaDeaths(op.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Zniceno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockBroken(op.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Polozeno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockPlaced(op.getUniqueId()));
		vanLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getVanillaTime(op.getUniqueId()), false));
		vanMeta.setLore(vanLore);
		vanilla.setItemMeta(vanMeta);
		
		ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta swMeta = skywars.getItemMeta();
		swMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "SkyWars");
		ArrayList<String> swLore = new ArrayList<String>();
		swLore.add("");
		swLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsKills(op.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsDeaths(op.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsWins(op.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsPlayed(op.getUniqueId()));
		swLore.add(ChatColor.YELLOW + "Odehrany cas: §cNedostupne");
		swMeta.setLore(swLore);
		skywars.setItemMeta(swMeta);
		
		ItemStack turfwars = new ItemStack(Material.WOOL,1,(byte)3);
		ItemMeta twMeta = turfwars.getItemMeta();
		twMeta.setDisplayName("§f§lTurfWars");
		ArrayList<String> twLore = new ArrayList<String>();
		twLore.add("");
		twLore.add("§eZabiti: §f" + Main.getInstance().getAPI().getTurfWarsKills(op.getUniqueId()));
		twLore.add("§eVitezstvi: §f" + Main.getInstance().getAPI().getTurfWarsWins(op.getUniqueId()));
		twLore.add("§eProhry: §f" + Main.getInstance().getAPI().getTurfWarsLosses(op.getUniqueId()));
		twLore.add("§eOdehrany cas: §cNedostupne");
		twMeta.setLore(twLore);
		turfwars.setItemMeta(twMeta);
		
		minigamesMenu.setItem(20, bedwars);
		minigamesMenu.setItem(21, drawit);
		minigamesMenu.setItem(22, uhc);
		minigamesMenu.setItem(23, anni);
		minigamesMenu.setItem(24, buildbattle);
		minigamesMenu.setItem(13, headItem);
		minigamesMenu.setItem(30, turfwars);
		minigamesMenu.setItem(31, skywars);
		minigamesMenu.setItem(32, vanilla);
		
		p.openInventory(minigamesMenu);
	}

}
