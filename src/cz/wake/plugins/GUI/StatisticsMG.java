package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.API.TimeUtils;

public class StatisticsMG {
	
	public void openMinigamesMenu(Player p){
		
		Inventory minigamesMenu = Bukkit.createInventory(null, 45, p.getName());
		
		ItemStack bedwars = new ItemStack(Material.BED);
		ItemMeta bedwarsMeta = bedwars.getItemMeta();
		bedwarsMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BedWars");
		ArrayList<String> bedwarsLore = new ArrayList<String>();
		bedwarsLore.add("");
		bedwarsLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsScore(p));
		bedwarsLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsWins(p));
		bedwarsLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsLoses(p));
		bedwarsLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsKills(p));
		bedwarsLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDeaths(p));
		bedwarsLore.add(ChatColor.YELLOW + "Zniceno posteli: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsDestroyed(p));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBedwarsPlayed(p));
		bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p), false));
		bedwarsMeta.setLore(bedwarsLore);
		bedwars.setItemMeta(bedwarsMeta);
		
		ItemStack drawit = new ItemStack(Material.PAINTING);
		ItemMeta drawitMeta = drawit.getItemMeta();
		drawitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "DrawIt");
		ArrayList<String> drawitLore = new ArrayList<String>();
		drawitLore.add("");
		drawitLore.add(ChatColor.YELLOW + "Score: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitScore(p));
		drawitLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWins(p));
		drawitLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitLoses(p));
		drawitLore.add(ChatColor.YELLOW + "Spravne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitRightGuess(p));
		drawitLore.add(ChatColor.YELLOW + "Spatne uhadnuti: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitWrongGuess(p));
		drawitLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getDrawitPlayed(p));
		drawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p), false));
		drawitMeta.setLore(drawitLore);
		drawit.setItemMeta(drawitMeta);
		
		ItemStack uhc = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta uhcMeta = uhc.getItemMeta();
		uhcMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "UltraHardcore");
		ArrayList<String> uhcLore = new ArrayList<String>();
		uhcLore.add("");
		uhcLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKills(p));
		uhcLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCDeaths(p));
		uhcLore.add(ChatColor.YELLOW + "Killstreak: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCKillstreak(p));
		uhcLore.add(ChatColor.YELLOW + "Polozene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockPlaced(p));
		uhcLore.add(ChatColor.YELLOW + "Znicene bloky: " + ChatColor.WHITE + Main.getInstance().getAPI().getUHCBlockBroken(p));
		uhcLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getUHCTime(p), false));
		uhcMeta.setLore(uhcLore);
		uhc.setItemMeta(uhcMeta);
		
		ItemStack anni = new ItemStack(Material.ENDER_STONE);
		ItemMeta anniMeta = anni.getItemMeta();
		anniMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Annihilation");
		ArrayList<String> anniLore = new ArrayList<String>();
		anniLore.add("");
		anniLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getAnniKills(p));
		anniLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getAnniDeaths(p));
		anniLore.add(ChatColor.YELLOW + "Vyhry: " + ChatColor.WHITE + Main.getInstance().getAPI().getAnniWins(p));
		anniLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getAnniLosses(p));
		anniLore.add(ChatColor.YELLOW + "Nexus damage: " + ChatColor.WHITE + Main.getInstance().getAPI().getAnniNexusDamage(p));
		anniLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getAnniTime(p), false));
		anniMeta.setLore(anniLore);
		anni.setItemMeta(anniMeta);
		
		ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
		ItemMeta bMeta = buildbattle.getItemMeta();
		bMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "BuildBattle");
		ArrayList<String> bbLore = new ArrayList<String>();
		bbLore.add("");
		bbLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildWins(p));
		bbLore.add(ChatColor.YELLOW + "Prohry: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildLoses(p));
		bbLore.add(ChatColor.YELLOW + "Nejvyssi pocet bodu: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildBestScore(p));
		bbLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildPlayedGames(p));
		bbLore.add(ChatColor.YELLOW + "Zniceno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildBlocksBroken(p));
		bbLore.add(ChatColor.YELLOW + "Polozeno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildPlacedBlocks(p));
		bbLore.add(ChatColor.YELLOW + "Umisteno efektu: " + ChatColor.WHITE + Main.getInstance().getAPI().getBuildParticles(p));
		bbLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.RED + "Nenalezeno...");
		bMeta.setLore(bbLore);
		buildbattle.setItemMeta(bMeta);
		
		ItemStack vanilla = new ItemStack(Material.EMERALD);
		ItemMeta vanMeta = vanilla.getItemMeta();
		vanMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Vanilla");
		ArrayList<String> vanLore = new ArrayList<String>();
		vanLore.add("");
		vanLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaKills(p));
		vanLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaDeaths(p));
		vanLore.add(ChatColor.YELLOW + "Zniceno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockBroken(p));
		vanLore.add(ChatColor.YELLOW + "Polozeno bloku: " + ChatColor.WHITE + Main.getInstance().getAPI().getVanillaBlockPlaced(p));
		vanLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getVanillaTime(p), false));
		vanMeta.setLore(vanLore);
		vanilla.setItemMeta(vanMeta);
		
		ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta swMeta = skywars.getItemMeta();
		swMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "SkyWars");
		ArrayList<String> swLore = new ArrayList<String>();
		swLore.add("");
		swLore.add(ChatColor.YELLOW + "Zabiti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsKills(p));
		swLore.add(ChatColor.YELLOW + "Smrti: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsDeaths(p));
		swLore.add(ChatColor.YELLOW + "Vitezstvi: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsWins(p));
		swLore.add(ChatColor.YELLOW + "Odehrano her: " + ChatColor.WHITE + Main.getInstance().getAPI().getSkyWarsPlayed(p));
		swLore.add(ChatColor.YELLOW + "Odehrany cas: §cNenalezeno...");
		swMeta.setLore(swLore);
		skywars.setItemMeta(swMeta);
		
		ItemStack zpet = new ItemStack(Material.WOOD_DOOR);
		ItemMeta zpetMeta = zpet.getItemMeta();
		zpetMeta.setDisplayName(ChatColor.RED + "Zpet do menu");
		ArrayList<String> zpetLore = new ArrayList<String>();
		zpetLore.add(ChatColor.GRAY + "Vrati do hlavni nabidky.");
		zpetMeta.setLore(zpetLore);
		zpet.setItemMeta(zpetMeta);
		
		minigamesMenu.setItem(13, vanilla);
		minigamesMenu.setItem(20, bedwars);
		minigamesMenu.setItem(21, drawit);
		minigamesMenu.setItem(22, uhc);
		minigamesMenu.setItem(23, anni);
		minigamesMenu.setItem(24, buildbattle);
		minigamesMenu.setItem(31, skywars);
		minigamesMenu.setItem(44, zpet);
		
		
		p.openInventory(minigamesMenu);
	}

}
