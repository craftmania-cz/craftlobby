package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NakupBoxu {
	
	public void openNakup(Player p){
		
		Inventory inv = Bukkit.createInventory(p, 27, "Nakup CraftBoxu");
		
		ItemStack ano = new ItemStack(Material.STAINED_CLAY,1,(byte)5);
		ItemMeta aMeta = ano.getItemMeta();
		aMeta.setDisplayName("§a§lAno");
		ArrayList<String> aLore = new ArrayList<String>();
		aLore.add("§7Kliknutim potvrdis.");
		aMeta.setLore(aLore);
		ano.setItemMeta(aMeta);
		
		ItemStack ne = new ItemStack(Material.STAINED_CLAY,1,(byte)14);
		ItemMeta nMeta = ne.getItemMeta();
		nMeta.setDisplayName("§c§lNe");
		ArrayList<String> nLore = new ArrayList<String>();
		nLore.add("§7Kliknutim se vratis zpet!");
		nMeta.setLore(nLore);
		ne.setItemMeta(nMeta);
		
		inv.setItem(11, ano);
		inv.setItem(15, ne);
		
		p.openInventory(inv);
		
	}

}
