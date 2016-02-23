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
import cz.wake.plugins.cloaks.AngleCloak;
import cz.wake.plugins.cloaks.SantaCloak;
import cz.wake.plugins.utils.ItemFactory;

public class Cloaks {
	
public void openCloaks(Player p){
		
		Inventory cloakMenu = Bukkit.createInventory(null, 54, "Cloaks");
		
		if(p.hasPermission("craftlobby.cloaks.santa")){
			if(SantaCloak.santaCloaks.containsKey(p.getName())){
				ItemStack santa = new ItemStack(Material.SNOW_BALL);
				santa = ItemFactory.addGlow(santa);
				ItemMeta sMeta = santa.getItemMeta();
				sMeta.setDisplayName("§a§lSanta Cloak");
				ArrayList<String> sLore = new ArrayList<String>();
				sLore.add("");
				sLore.add("§7S timto budes vypadat jako");
				sLore.add("§7opravdovy santa.");
				sLore.add("");
				sLore.add("§cAktivovano!");
				sMeta.setLore(sLore);
				santa.setItemMeta(sMeta);
				cloakMenu.setItem(10, santa);
			} else {
				ItemStack santa = new ItemStack(Material.SNOW_BALL);
				ItemMeta sMeta = santa.getItemMeta();
				sMeta.setDisplayName("§a§lSanta Cloak");
				ArrayList<String> sLore = new ArrayList<String>();
				sLore.add("");
				sLore.add("§7S timto budes vypadat jako");
				sLore.add("§7opravdovy santa.");
				sLore.add("");
				sLore.add("§eKliknutim aktivujes!");
				sMeta.setLore(sLore);
				santa.setItemMeta(sMeta);
				cloakMenu.setItem(10, santa);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSanta Cloak");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add("§7Tento Cloak se ziskat o Vanocich 2015.");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			cloakMenu.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.cloaks.angel")){
			if(AngleCloak.angelCloaks.containsKey(p.getName())){
				ItemStack santa = new ItemStack(Material.BREAD);
				santa = ItemFactory.addGlow(santa);
				ItemMeta sMeta = santa.getItemMeta();
				sMeta.setDisplayName("§a§lAngel Cloak");
				ArrayList<String> sLore = new ArrayList<String>();
				sLore.add("");
				sLore.add("§7Jako ten pravy andel,");
				sLore.add("§7budes vypadat.");
				sLore.add("");
				sLore.add("§cAktivovano!");
				sMeta.setLore(sLore);
				santa.setItemMeta(sMeta);
				cloakMenu.setItem(11, santa);
			} else {
				ItemStack santa = new ItemStack(Material.BREAD);
				ItemMeta sMeta = santa.getItemMeta();
				sMeta.setDisplayName("§a§lAngel Cloak");
				ArrayList<String> sLore = new ArrayList<String>();
				sLore.add("");
				sLore.add("§7Jako ten pravy andel,");
				sLore.add("§7budes vypadat.");
				sLore.add("");
				sLore.add("§eKliknutim aktivujes!");
				sMeta.setLore(sLore);
				santa.setItemMeta(sMeta);
				cloakMenu.setItem(11, santa);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lAngel Cloak");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add("§7Tento Cloak se ziskat v CraftBoxu.");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			cloakMenu.setItem(11, noPerm);
		}
		
		ItemStack zpet = new ItemStack(Material.ARROW);
		ItemMeta zpetMeta = zpet.getItemMeta();
		zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
		zpet.setItemMeta(zpetMeta);
		
		ItemStack deaktivace = new ItemStack(Material.BARRIER);
		ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
		deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Vypnout cloak ✖");
		ArrayList<String> deaktivaceLore = new ArrayList<String>();
		deaktivaceLore.add(ChatColor.GRAY + "Kliknutim vypnes cloak.");
		deaktivaceMeta.setLore(deaktivaceLore);
		deaktivace.setItemMeta(deaktivaceMeta);
		
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
		
		cloakMenu.setItem(49, shopItem);
		cloakMenu.setItem(40, deaktivace);
		cloakMenu.setItem(39, zpet);
		
		p.openInventory(cloakMenu);
	}

}
