package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.Main;

public class PetsMenu implements Listener{
	
	public void openPets(Player p){
		
		Inventory petsMenu = Bukkit.createInventory(null, 54, "Pets");
		
		ItemStack pig = new ItemStack(Material.PORK);
		ItemMeta pigMeta = pig.getItemMeta();
		pigMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pig");
		ArrayList<String> pigLore = new ArrayList<String>();
		pigLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		pigMeta.setLore(pigLore);
		pig.setItemMeta(pigMeta);
		petsMenu.setItem(10, pig);
		
		ItemStack chicken = new ItemStack(Material.COOKED_CHICKEN);
		ItemMeta chickenMeta = chicken.getItemMeta();
		chickenMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Chicken");
		ArrayList<String> chickenLore = new ArrayList<String>();
		chickenLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		chickenMeta.setLore(chickenLore);
		chicken.setItemMeta(chickenMeta);
		petsMenu.setItem(11, chicken);
		
		ItemStack cow = new ItemStack(Material.MILK_BUCKET);
		ItemMeta cowMeta = cow.getItemMeta();
		cowMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Cow");
		ArrayList<String> cowLore = new ArrayList<String>();
		cowLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		cowMeta.setLore(cowLore);
		cow.setItemMeta(cowMeta);
		petsMenu.setItem(12, cow);
		
		ItemStack ocelot = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
		ItemMeta ocelotMeta = ocelot.getItemMeta();
		ocelotMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ocelot");
		ArrayList<String> ocelotLore = new ArrayList<String>();
		ocelotLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		ocelotMeta.setLore(ocelotLore);
		ocelot.setItemMeta(ocelotMeta);
		petsMenu.setItem(13, ocelot);
		
		ItemStack spider = new ItemStack(Material.FERMENTED_SPIDER_EYE);
		ItemMeta spiderMeta = spider.getItemMeta();
		spiderMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Spider");
		ArrayList<String> spiderLore = new ArrayList<String>();
		spiderLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		spiderMeta.setLore(spiderLore);
		spider.setItemMeta(spiderMeta);
		petsMenu.setItem(14, spider);
		
		ItemStack golem = new ItemStack(Material.IRON_INGOT);
		ItemMeta golemMeta = golem.getItemMeta();
		golemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "IronGolem");
		ArrayList<String> golemLore = new ArrayList<String>();
		golemLore.add(ChatColor.GRAY + "Kliknutim privolas mazlicka!");
		golemMeta.setLore(golemLore);
		golem.setItemMeta(golemMeta);
		petsMenu.setItem(15, golem);
		
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
		shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby");
		shopLore.add(ChatColor.GRAY + "daji se ziskat z CraftBoxu nebo na");
		shopLore.add(ChatColor.GRAY + "specialnich eventech.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		petsMenu.setItem(49, shopItem);
		petsMenu.setItem(40, deaktivace);
		petsMenu.setItem(39, zpet);
		
		p.openInventory(petsMenu);
	}

}
