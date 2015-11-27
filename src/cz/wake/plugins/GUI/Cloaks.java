package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cloaks {
	
public void openCloaks(Player p){
		
		Inventory cloakMenu = Bukkit.createInventory(null, 54, "Cloaks");
		
		ItemStack santa = new ItemStack(Material.SNOW_BALL);
		ItemMeta sMeta = santa.getItemMeta();
		sMeta.setDisplayName(ChatColor.GREEN + "Santa Cloak");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add("");
		sLore.add(ChatColor.GRAY + "S timto budes vypadat jako");
		sLore.add(ChatColor.GRAY + "opravdovy santa.");
		sMeta.setLore(sLore);
		santa.setItemMeta(sMeta);
		cloakMenu.setItem(10, santa);
		
		ItemStack zpet = new ItemStack(Material.ARROW);
		ItemMeta zpetMeta = zpet.getItemMeta();
		zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
		zpet.setItemMeta(zpetMeta);
		
		ItemStack deaktivace = new ItemStack(Material.BARRIER);
		ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
		deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Sundat blok z hlavy ✖");
		ArrayList<String> deaktivaceLore = new ArrayList<String>();
		deaktivaceLore.add(ChatColor.GRAY + "Kliknutim sundas nasazeny blok.");
		deaktivaceMeta.setLore(deaktivaceLore);
		deaktivace.setItemMeta(deaktivaceMeta);
		
		ItemStack shopItem = new ItemStack(Material.CHEST,1);
		ItemMeta shopItemMeta = shopItem.getItemMeta();
		shopItemMeta.setDisplayName(ChatColor.GREEN + "Shop");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Kliknutim si otevres shop");
		shopLore.add(ChatColor.GRAY + "kde si muzes nakoupit za CC");
		shopLore.add(ChatColor.GRAY + "nove hats, gadgets, trails atd.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.YELLOW + "0 CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		cloakMenu.setItem(49, shopItem);
		cloakMenu.setItem(40, deaktivace);
		cloakMenu.setItem(39, zpet);
		
		p.openInventory(cloakMenu);
	}

}
