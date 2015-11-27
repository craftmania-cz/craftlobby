package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ItemFactory;

public class HeadsMenu implements Listener{
	
	public void openHatsMenu(Player p){
		
		Inventory hatsMenu = Bukkit.createInventory(null, 54, "Heads (1 z 3 stran)");
		
		//ItemStack skull = ItemFactory.createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NDM4MTEyMzg1OTgsInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0=");
		
		if(p.hasPermission("craftlobby.heads.strawberryjam")){
			ItemStack skull = ItemFactory.createHead("Strawberry Jam", "adc3ea73-5b42-4fea-a237-4a72b52dd72b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Strawberry Jam");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(0, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Strawberry Jam");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(0, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.oreo")){
			ItemStack skull = ItemFactory.createHead("Oreo", "37dd5612-efdb-4f4b-bb55-9040a4403ff8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZkNzFlMjBmYzUwYWJmMGRlMmVmN2RlY2ZjMDFjZTI3YWQ1MTk1NTc1OWUwNzJjZWFhYjk2MzU1ZjU5NGYwIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Oreo");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(1, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Oreo");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(1, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.chocolate")){
			ItemStack skull = ItemFactory.createHead("Chocolate", "eaa47b1d-cb57-48c8-af33-cf4fd9872341", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE5Zjk0OGQxNzcxOGFkYWNlNWRkNmUwNTBjNTg2MjI5NjUzZmVmNjQ1ZDcxMTNhYjk0ZDE3YjYzOWNjNDY2In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Chocolate");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(2, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Chocolate");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(2, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.whitechocolate")){
			ItemStack skull = ItemFactory.createHead("White Chocolate", "91f8d9e9-0514-4319-902f-f2662f4df272", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWVkNTUyNjBkY2NjOGRhNTkzMzhjNzVlNDFkNTQ0YTJlMWU3ZGJlZjMxYTY5ZmU0MmMwMWIzMjk4YmYyZCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "White Chocolate");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(3, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "White Chocolate");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(3, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.melon")){
			ItemStack skull = ItemFactory.createHead("Melon", "983afea2-cf1b-4732-9726-c81e3f621630", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM5MDMwNjZjY2M0Njk1ZTExM2ZlZTMxNGM5NmE1NDRlYjkxOTYyMmVlZTdkYWExZDE5NjYzNzRmM2ZlODQ4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Melon");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(4, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Melon");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(4, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.hamburger")){
			ItemStack skull = ItemFactory.createHead("Hamburger", "d1375075-c727-40ad-bcce-7e4277099e30", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Hamburger");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(5, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Hamburger");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(5, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.lemon")){
			ItemStack skull = ItemFactory.createHead("Lemon", "09d10b7a-f525-412c-bedf-b2fe7c8bfc70", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3ZmQ1NmNhMTU5Nzg3NzkzMjRkZjUxOTM1NGI2NjM5YThkOWJjMTE5MmM3YzNkZTkyNWEzMjliYWVmNmMifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Lemon");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(6, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Lemon");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(6, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.donut")){
			ItemStack skull = ItemFactory.createHead("Donut", "b48503a4-6dec-438c-a3bc-6b5da7fb1fde", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM3YzliODJiMTg2NjU2ZTlmNjM2M2EyYTFjNmE0YjViOTNjZmE5ZWY0ZGFkNmYxNmI5NGViYjVlMzYyNjc4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Donut");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(7, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Donut");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(7, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.pepsi")){
			ItemStack skull = ItemFactory.createHead("Pepsi", "92b6dbd7-11df-4702-b4d1-ec0dcc7ce114", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmJiYWU2ZGY5OWRjODJiZWFmNDlkMDY0ZGY3NGExYmJjMTVlOGUzNzY1MzMyNzY5MTJjOGM4ZmU1OWNiNGY0In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Pepsi");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(8, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Pepsi");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(8, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.cocacola")){
			ItemStack skull = ItemFactory.createHead("Coca Cola", "8a145e5e-957d-418c-b000-511c971ae698", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTNiMDFmYjJmNmJhNDdjOWQ3NjM4NDkxZjM3Y2Q4NTgyYTkzNzczMTE4NmRmNGQxZWNjZDU5YjY1YmYzNyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Coca Cola");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(9, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Coca Cola");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(9, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.sprite")){
			ItemStack skull = ItemFactory.createHead("Sprite", "8b8c8496-88f0-4907-bbfc-5453a2333326", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhhMzRkODZhN2JiMTNkNDVhZmRjNTBkM2RjZTVlZWQ5NWUxODQ0ZmJkZWUwY2NhNzUzYzZkMzM0NmUzMzllIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Sprite");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(10, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Sprite");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.apple")){
			ItemStack skull = ItemFactory.createHead("Apple", "ebd81954-37b1-49f4-aaa1-8e79e2e3a856", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNlODY1OTQ3OGRkMjhiMWFkZTZlYmU3ZDNlMWQ2NzU4ZTIxOWY0MzhkYjc4NGE1YWRkZWRhODZlZDFhMzhhIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Apple");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(11, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Apple");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.clock")){
			ItemStack skull = ItemFactory.createHead("Clock", "f952235c-44a2-4f91-a6aa-0fcf361507ac", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmRlNGUyNzgzZjg1YTM5MTIyMWRkOTE2NTZiYTY4OGU3ZTQyZDE2ZjZhYmJmYmNmYWQ5Y2E1MzYxN2ZjYTYifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Clock");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(12, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Clock");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.computer")){
			ItemStack skull = ItemFactory.createHead("Computer", "81c080fd-022b-477c-9f24-f637324d4c4c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlNTJhZThjOThhYzE5ZmQwNzYzN2E0NjlmZmEyNTZhYjBiM2IxMGVjZTYyNDMxODYxODhiYTM4ZGYxNTQifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Computer");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(13, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Computer");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.monitor")){
			ItemStack skull = ItemFactory.createHead("Monitor", "5a929f7f-1a74-4d25-860d-40ff532acfbe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2ZjcyYzE2YjFlOWZlNmUwOTllNzZiNWY3YTg4NGZiNzgyY2ZjYzU4OGM5NWM0ZTM4M2RjNTI3ZDFiODQifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Monitor");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(14, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Monitor");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.instagram")){
			ItemStack skull = ItemFactory.createHead("Instagram", "5e469ecf-80a4-40ae-8d9d-7c12bd2d3a3f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjViM2YyY2ZhMDczOWM0ZTgyODMxNmYzOWY5MGIwNWJjMWY0ZWQyN2IxZTM1ODg4NTExZjU1OGQ0Njc1In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Instagram");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(15, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Instagram");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.c4")){
			ItemStack skull = ItemFactory.createHead("C4", "8b8fcca0-6880-4108-a46a-5a21320e0d7c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRhMzMyYWJkZTMzM2ExNWE2YzZmY2ZlY2E4M2YwMTU5ZWE5NGI2OGU4ZjI3NGJhZmMwNDg5MmI2ZGJmYyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "C4");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(16, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "C4");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.policesiren")){
			ItemStack skull = ItemFactory.createHead("Police Siren", "e8297346-5aca-4ae8-b2a3-e341b6d0921f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWFmYTU4NjMxNjA5NzkxZmZlMjVmM2E4NzlkZmJmZmVhMTE1MWY4N2JmZjYyYzU0MjNlZDYxMzZlZTAifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Police Siren");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(17, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Police Siren");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(17, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.spacehelmet")){
			ItemStack skull = ItemFactory.createHead("Space Helmet", "822833e6-c3ec-457e-aeef-1fac97799e5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAyZTIyZjY1MDNjMzYzZGY2OWJmOWU5NDQ4ZmU4OWQyZjA1YmFlMzA1MzRiOGJiMTlkMjY4ZjA5ODliOTYifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Space Helmet");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(18, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Space Helmet");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(18, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.facebook")){
			ItemStack skull = ItemFactory.createHead("Facebook", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Facebook");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(19, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Facebook");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.youtube")){
			ItemStack skull = ItemFactory.createHead("YouTube", "4ec6d571-4553-4a75-a4ae-6e104bcc76f0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "YouTube");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(20, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "YouTube");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.goldsteve")){
			ItemStack skull = ItemFactory.createHead("Gold Steve", "844064fd-71f0-4aa2-a336-10bbada597d1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjkzN2UxYzQ1YmI4ZGEyOWIyYzU2NGRkOWE3ZGE3ODBkZDJmZTU0NDY4YTVkZmI0MTEzYjRmZjY1OGYwNDNlMSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Gold Steve");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(21, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Gold Steve");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(21, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.scared")){
			ItemStack skull = ItemFactory.createHead("Scared", "2cd3dbb5-6136-4127-9e14-89c328660871", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM2ZTI2YzQ0NjU5ZTgxNDhlZDU4YWE3OWU0ZDYwZGI1OTVmNDI2NDQyMTE2ZjgxYjU0MTVjMjQ0NmVkOCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Scared");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(22, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Scared");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(22, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.embarrased")){
			ItemStack skull = ItemFactory.createHead("Embarrased", "80e16b56-8d8c-4ea0-b3b2-dd69c7bd56cf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjcyMGRmOTExYzA1MjM3NzA2NTQwOGRiNzhhMjVjNjc4Zjc5MWViOTQ0YzA2MzkzNWFlODZkYmU1MWM3MWIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Embarrased");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(23, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Embarrased");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(23, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.kissy")){
			ItemStack skull = ItemFactory.createHead("Kissy", "c7360c40-1b10-4a11-8322-697962372596", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ1YmQxOGEyYWFmNDY5ZmFkNzJlNTJjZGU2Y2ZiMDJiZmJhYTViZmVkMmE4MTUxMjc3Zjc3OWViY2RjZWMxIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Kissy");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(24, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Kissy");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(24, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.cool")){
			ItemStack skull = ItemFactory.createHead("Cool", "bcefcc41-e997-4845-ae08-7b8a1a2d51b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Cool");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(25, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Cool");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(25, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.suprised")){
			ItemStack skull = ItemFactory.createHead("Suprised", "1a61537c-52d6-429d-9314-8420d631b494", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMyYjliOWFlNjIyYmQ2OGFkZmY3MTgwZjgyMDZlYzQ0OTRhYmJmYTEzMGU5NGE1ODRlYzY5MmU4OTg0YWIyIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Suprised");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(26, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Suprised");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(26, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.crying")){
			ItemStack skull = ItemFactory.createHead("Crying", "b03562f3-2a20-4257-bb62-e040f552c297", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWYxYjg3NWRlNDljNTg3ZTNiNDAyM2NlMjRkNDcyZmYyNzU4M2ExZjA1NGYzN2U3M2ExMTU0YjViNTQ5OCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Crying");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(27, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Crying");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(27, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.grin")){
			ItemStack skull = ItemFactory.createHead("Grin", "988770c2-3a2d-41c3-a753-b13fa383e823", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA1OWQ1OWViNGU1OWMzMWVlY2Y5ZWNlMmY5Y2YzOTM0ZTQ1YzBlYzQ3NmZjODZiZmFlZjhlYTkxM2VhNzEwIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Grin");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(28, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Grin");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(28, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.derp")){
			ItemStack skull = ItemFactory.createHead("Derp", "58c6ac60-cbce-4ecb-981b-e79a87ad2bb6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JhYWJlNzI0ZWFlNTljNWQxM2Y0NDJjN2RjNWQyYjFjNmI3MGMyZjgzMzY0YTQ4OGNlNTk3M2FlODBiNGMzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Derp");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(29, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Derp");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(29, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mustache")){
			ItemStack skull = ItemFactory.createHead("Mustache", "0d7d6e4d-fb18-491b-a7b6-dbf45d923811", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYzNmYyNzI0YWE2YWE0ZGU3YWM0NmMxOWYzYzg0NWZiMTQ4NDdhNTE4YzhmN2UwM2Q3OTJjODJlZmZiMSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Mustache");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(30, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Mustache");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(30, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.smile")){
			ItemStack skull = ItemFactory.createHead("Smile", "0beedb99-f64e-4a26-93f3-8f3af84050aa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZmYWNjZjE3ODc5YjE3ODkxZmM1ZWY2NjQ3MmNjMDY2YTg1YmZhMzFiNmQ3ODZjMzJhZmVlNDc5NjA2OGQifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Smile");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(31, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Smile");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(31, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.dead")){
			ItemStack skull = ItemFactory.createHead("Dead", "275a74fe-e3e4-4aff-86a2-68e3fb9720d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Dead");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(32, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Dead");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(32, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.skull")){
			ItemStack skull = ItemFactory.createHead("Skull", "c659cdd4-e436-4977-a6a7-d5518ebecfbb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Skull");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(33, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Skull");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(33, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mailbox")){
			ItemStack skull = ItemFactory.createHead("Mailbox", "4113ced7-576b-4c03-8a92-0937d5966ea1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFjYmJjYTU2NzM3MmE5YjJiMzZjOGY2ODE1NDg1MWJkYTVlZTFkNTNlMmJjMjA4YTExNTJkOWExOGQyY2IifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Mailbox");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(34, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Mailbox");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(34, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.texture")){
			ItemStack skull = ItemFactory.createHead("MissingTexture", "5d43c6dd-ca01-466c-9614-764449140917", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "MissingTexture");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hatsMenu.setItem(35, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "MissingTexture");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hatsMenu.setItem(35, noPerm);
		}
		
		ItemStack zpet = new ItemStack(Material.ARROW);
		ItemMeta zpetMeta = zpet.getItemMeta();
		zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
		zpet.setItemMeta(zpetMeta);
		
		ItemStack dalsi = new ItemStack(Material.ARROW);
		ItemMeta dalsiMeta = dalsi.getItemMeta();
		dalsiMeta.setDisplayName(ChatColor.RED + "Dalsi stranka");
		dalsi.setItemMeta(dalsiMeta);
		
		ItemStack deaktivace = new ItemStack(Material.BARRIER);
		ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
		deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Sundat headku z hlavy ✖");
		ArrayList<String> deaktivaceLore = new ArrayList<String>();
		deaktivaceLore.add(ChatColor.GRAY + "Kliknutim sundas nasazenou headku.");
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
		
		hatsMenu.setItem(49, shopItem);
		hatsMenu.setItem(41, dalsi);
		hatsMenu.setItem(40, deaktivace);
		hatsMenu.setItem(39, zpet);
		
		p.openInventory(hatsMenu);
		
		
	}
	

}
