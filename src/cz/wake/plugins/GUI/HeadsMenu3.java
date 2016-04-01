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
import cz.wake.plugins.utils.ItemFactory;

public class HeadsMenu3 {
	
	public void openHeadsMenu3(Player p){
		
		Inventory hm = Bukkit.createInventory(null, 54, "Heads (3 z 4 stran)");
		
		/*if(p.hasPermission("craftlobby.heads.")){
		ItemStack skull = ItemFactory.createHead("", "", "");
		ItemMeta sMeta = skull.getItemMeta();
		sMeta.setDisplayName(ChatColor.GREEN + "");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
		sMeta.setLore(sLore);
		skull.setItemMeta(sMeta);
		hm.setItem(0, skull);
	} else {
		ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
		ItemMeta noPermMeta = noPerm.getItemMeta();
		noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "");
		ArrayList<String> noPermLore = new ArrayList<String>();
		noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
		noPermMeta.setLore(noPermLore);
		noPerm.setItemMeta(noPermMeta);
		hm.setItem(0, noPerm);
	}*/
		
		if(p.hasPermission("craftlobby.heads.evilbunny")){
			ItemStack skull = ItemFactory.createHead("EvilBunny", "e4f254ad-1413-4853-8736-10c7aa53fbaf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q0ZmRhZDVhNjEwNGFhNTQ5ZDFlNzZkNzNhM2M2ZmUzYzY3MjRiZjA5ZjdmZmNjMDJmMzNmOWVkZTdmYWRlIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "EvilBunny");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(0, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "EvilBunny");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(0, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.scaryclown")){
			ItemStack skull = ItemFactory.createHead("ScaryClown", "d1956517-9a4d-421d-8647-2d940dc64518", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZkYmMxZGViYzU3NDM4YTVkZTRiYTkxNTE1MTM4MmFiYzNkOGYxMzE4ZTJhMzVlNzhkZmIzMGYwNGJjNDY3In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "ScaryClown");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(1, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "ScaryClown");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(1, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.frankensteinsmonster")){
			ItemStack skull = ItemFactory.createHead("FrankensteinsMonster", "aec7b0b6-7bf8-46a6-b873-feb3d6277af8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjYmUwNjFiNDQ1Yjg4Y2IyZGY1OWFjY2M4ZDJjMWMxMjExOGZlMGIyMTI3ZTZlNzU4MTM1NTBhZGFjNjdjZiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "FrankensteinsMonster");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(2, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "FrankensteinsMonster");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(2, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ogre")){
			ItemStack skull = ItemFactory.createHead("Ogre", "579a7117-023d-4183-80d1-f33ab649f7ff", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNhNDc5NDZkNzI4NTgzNGVmMWUxNzYyOWY3MjgyYjY1ZTkxNDM1OTdmZTdiZjJiZTFkZTI0M2YxYzYzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Ogre");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(3, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Ogre");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(3, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.werewolf")){
			ItemStack skull = ItemFactory.createHead("WereWolf", "fdc7eb2a-0bec-408d-8f16-f8494d3960d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFjOTkzNGNkZDU1YTllNjMzNTk2MmE4Nzc2MjYwZDc5MTYxNTA4MTM0ODNlOTU2YzI4NjFiMTFhOGEyNjdmNyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "WereWolf");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(4, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "WereWolf");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(4, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.guardian")){
			ItemStack skull = ItemFactory.createHead("Guardian", "2e9c0a67-92b3-4949-9be1-faf12318ee88", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Guardian");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(5, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Guardian");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(5, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.walrus")){
			ItemStack skull = ItemFactory.createHead("Walrus", "a185ff1a-f32e-47e0-be61-5a612f130f33", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Walrus");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(6, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Walrus");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(6, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.batman")){
			ItemStack skull = ItemFactory.createHead("Batman", "af20c020-6810-4abe-8437-97d3bff52bec", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Batman");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(7, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Batman");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(7, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ilusionblock")){
			ItemStack skull = ItemFactory.createHead("IlusionBlock", "d27723ec-8f68-4bbf-a2b0-58f0adf0b7f9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQ2MmRkZmE1NTNjZTc4NjgzYmU0NzdiOGQ4NjU0ZjNkZmMzYWEyOTY5ODA4NDc4Yzk4N2FiODhjMzc2YTAifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "IlusionBlock");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(8, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "IlusionBlock");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(8, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mrwakecz")){
			ItemStack skull = ItemFactory.createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "MrWakeCZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(9, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "MrWakeCZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(9, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.deawen")){
			ItemStack skull = ItemFactory.createHead("Deawen", "75095752-c042-4aad-aa7f-15dbc57a28d9", "eyJ0aW1lc3RhbXAiOjE0NTk0NDYxNDU4MDUsInByb2ZpbGVJZCI6Ijc1MDk1NzUyYzA0MjRhYWRhYTdmMTVkYmM1N2EyOGQ5IiwicHJvZmlsZU5hbWUiOiJEZWF3ZW4iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViYWI5YTNmMWI4YjgxZmQ4N2FkNzg4NmFlMTFjMjgzZDYyODg0OWU1ZDFlYzYzMDQ5NjA2ZmJlYTVmNjYzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Deawen");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(10, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Deawen");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ccarmel")){
			ItemStack skull = ItemFactory.createHead("Ccarmel", "81b28a0a-1b32-4d55-8f10-fff7021d4c23", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIxNjI1NzUsInByb2ZpbGVJZCI6IjgxYjI4YTBhMWIzMjRkNTU4ZjEwZmZmNzAyMWQ0YzIzIiwicHJvZmlsZU5hbWUiOiJDY2FybWVsIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzI0MjVlNTVlZjA0NjMzYjcyNWU2NmNhM2E2NWFmNDFkM2ZjMmZiMDY5YjJiNjFlNzhlYTE4Y2U5MjkwMmY2ZiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Ccarmel");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(11, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Ccarmel");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.flafylp")){
			ItemStack skull = ItemFactory.createHead("Flafy_LP", "63e2cc82-a760-432c-9cce-f0e297f14389", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIxODk1MDUsInByb2ZpbGVJZCI6IjYzZTJjYzgyYTc2MDQzMmM5Y2NlZjBlMjk3ZjE0Mzg5IiwicHJvZmlsZU5hbWUiOiJGbGFmeV9MUCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mZmJlYTE5ZTc3Y2FjMmE5YjdjM2EyN2Q2Yjc3OTdkNGM4NmIxYWVhYTYzYjIyNDlkZWQ4YTgwN2JiM2I4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Flafy_LP");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(12, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Flafy_LP");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.itztoky")){
			ItemStack skull = ItemFactory.createHead("iTzToky", "1fe73673-484e-429b-97bc-c959365d3b9d", "eyJ0aW1lc3RhbXAiOjE0NTk0NDYyNTQ1ODgsInByb2ZpbGVJZCI6IjFmZTczNjczNDg0ZTQyOWI5N2JjYzk1OTM2NWQzYjlkIiwicHJvZmlsZU5hbWUiOiJpVHpUb2t5IiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIwZTMyNjUyMzlmYjg4ODU5NzljZTc1NTFkNGJiYzExYjRlNjhlNTM3M2Q3OTg0YWNkZmFiNWM5NDUzYjFlIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "iTzToky");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(13, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "iTzToky");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.delfik")){
			ItemStack skull = ItemFactory.createHead("Delfik", "2ae3d9b6-d86e-4bd9-ab64-9d90b6736ce0", "eyJ0aW1lc3RhbXAiOjE0NTAyODQzOTM0MDEsInByb2ZpbGVJZCI6IjJhZTNkOWI2ZDg2ZTRiZDlhYjY0OWQ5MGI2NzM2Y2UwIiwicHJvZmlsZU5hbWUiOiJEZWxmaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFmNzY3MTRmY2ZjOWJlMzQxZTdjMmQzMzJiZDZmZmJhNzg0YWE3OTdhYTg2NTk2YmM4N2E0NjE0OTg4ZSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Delfik");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(14, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Delfik");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mrzaky")){
			ItemStack skull = ItemFactory.createHead("MrZaky", "0cf27547-32ac-4f0b-90e8-f185d8124c76", "eyJ0aW1lc3RhbXAiOjE0NTk0NDYzNjMzMjUsInByb2ZpbGVJZCI6IjBjZjI3NTQ3MzJhYzRmMGI5MGU4ZjE4NWQ4MTI0Yzc2IiwicHJvZmlsZU5hbWUiOiJNclpha3kiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQyOGNlMmZjNjdjYmU0YzI0OTE3ZWZiNjk4OWQxNjk0ZjQ0OTVmNjE4YWQ5NDg5ZTkyZDZjODNjZmY4Y2MifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "MrZaky");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(15, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "MrZaky");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.itzjarko")){
			ItemStack skull = ItemFactory.createHead("iTz_Jarko", "cb91e9c3-3ec1-432e-8dad-c631f9b38daf", "eyJ0aW1lc3RhbXAiOjE0NTk0NTI2ODQ4OTksInByb2ZpbGVJZCI6ImNiOTFlOWMzM2VjMTQzMmU4ZGFkYzYzMWY5YjM4ZGFmIiwicHJvZmlsZU5hbWUiOiJpVHpfSmFya28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmOWU5N2M4NGRhNmNhOWVlMzQxYmYwYjMzZWI5MzYyZGYzMmZiY2IwYzE0ZWIyNDVmYzU1YzBhOGM0YWJkMSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "iTz_Jarko");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(16, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "iTz_Jarko");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.kapr20")){
			ItemStack skull = ItemFactory.createHead("kapr20", "e94d212c-8016-43df-9dbc-0e058bfe2adf", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE0MTczMjgsInByb2ZpbGVJZCI6ImU5NGQyMTJjODAxNjQzZGY5ZGJjMGUwNThiZmUyYWRmIiwicHJvZmlsZU5hbWUiOiJrYXByMjAiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNjM2JlOTkzOGRlZDVlYTkyMjQxNzQwNWI3OTIxMDkyZjM3OWNhZTlkYjUyYmUzNzFjZjkyNjllOTAifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "kapr20");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(17, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "kapr20");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(17, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.misery96")){
			ItemStack skull = ItemFactory.createHead("Misery96", "f3dbccbc-73ef-4d2a-9592-e87860c1fb0b", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE1MDA1MzYsInByb2ZpbGVJZCI6ImYzZGJjY2JjNzNlZjRkMmE5NTkyZTg3ODYwYzFmYjBiIiwicHJvZmlsZU5hbWUiOiJNaXNlcnk5NiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83OGQ2ZjFlY2NjMTA2MGM5ZGY3NjZkYWUwZDU0OTJlNGVmMzYxMTIyYWZmODYyNjg1ZTE0ZGRiOGRiMjM2YyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Misery96");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(18, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Misery96");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(18, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.trewish")){
			ItemStack skull = ItemFactory.createHead("Trewish", "a78598c6-d85e-4197-833c-793dbe7d387c", "eyJ0aW1lc3RhbXAiOjE0NTk0NDY0NjIxOTEsInByb2ZpbGVJZCI6ImE3ODU5OGM2ZDg1ZTQxOTc4MzNjNzkzZGJlN2QzODdjIiwicHJvZmlsZU5hbWUiOiJUcmV3aXNoIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzU4NDhjNmM5ZDhmY2RjN2ZjZjkxODllNzE5NjRjYzI1YWFiYmY1NDA5MWJmZTBhZjY1NDQ3MmNkMjg2Y2FjIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Trewish");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(19, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Trewish");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.keyio")){
			ItemStack skull = ItemFactory.createHead("Keyio", "2cefcef0-0342-4a88-a1b8-d9019f3542ca", "eyJ0aW1lc3RhbXAiOjE0NTk0NDY1NzUxNTcsInByb2ZpbGVJZCI6IjJjZWZjZWYwMDM0MjRhODhhMWI4ZDkwMTlmMzU0MmNhIiwicHJvZmlsZU5hbWUiOiJLZXlpbyIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kNjc1NDgzZTA2ZTRjY2M5ZTg2NjhmZTlhOGNlOTlmNTg5NDdmZmM0YWFkZjkyN2RmMmI5MTFhNGM1OTQwYmUifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Keyio");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(20, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Keyio");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.nedzdo")){
			ItemStack skull = ItemFactory.createHead("Nedzdo", "03683a45-67a5-4444-823a-a43c49215767", "eyJ0aW1lc3RhbXAiOjE0NTk0NTI2MDUwNzMsInByb2ZpbGVJZCI6IjAzNjgzYTQ1NjdhNTQ0NDQ4MjNhYTQzYzQ5MjE1NzY3IiwicHJvZmlsZU5hbWUiOiJOZWR6ZG8iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzVjZGFmZjRmNjY0MTBjNDJmOGExYTcwMjFmY2M1MWEyNWE5ODhlZDg1ZmNkZDE5Mjc1YjBhNGJiYzFhZjFkIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Nedzdo");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(21, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Nedzdo");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(21, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.cheap")){
			ItemStack skull = ItemFactory.createHead("Cheap_", "bfe196c4-2e8e-427a-be3b-36c716d373d3", "eyJ0aW1lc3RhbXAiOjE0NTk0NDY3MjQyNDEsInByb2ZpbGVJZCI6ImJmZTE5NmM0MmU4ZTQyN2FiZTNiMzZjNzE2ZDM3M2QzIiwicHJvZmlsZU5hbWUiOiJDaGVhcF8iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTJkYmM2NGNkMTI1MmE2MDEwMDhiYTY1NzNhMmVlYjExMmMxNDNhMGZiNDZjODZlZjZjZGVkZWU5MWFhZGQifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Cheap_");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(22, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Cheap_");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(22, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.pvnst")){
			ItemStack skull = ItemFactory.createHead("PVNST", "70dc3eaa-e5e2-48b7-b94b-9fa1a0dabfbc", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE5OTY2MDAsInByb2ZpbGVJZCI6IjcwZGMzZWFhZTVlMjQ4YjdiOTRiOWZhMWEwZGFiZmJjIiwicHJvZmlsZU5hbWUiOiJQVk5TVCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lMDM1YmVkY2U1ODA2NmNlN2RjNzMyZTA1NDdlMzMyNDYzNzY3ODJlYTAzOGNkNjRjOTZlODI0YWE5OWY4OTM4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "PVNST");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(23, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "PVNST");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(23, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.r3pl1kat0r")){
			ItemStack skull = ItemFactory.createHead("_R3pl1_", "379161e5-7373-4917-ba83-ca601e9f0b90", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIyNTkwODksInByb2ZpbGVJZCI6IjM3OTE2MWU1NzM3MzQ5MTdiYTgzY2E2MDFlOWYwYjkwIiwicHJvZmlsZU5hbWUiOiJfUjNwbDFfIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzU1Njk3MTM4ZTczMTUwY2FkNTIxMjcyYzczNjA3NWQ3ZTQ3ZjNlZjM4MDcyOTNlNmUxZTdkMTIzODY2ODk3In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "_R3pl1_");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(24, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "_R3pl1_");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(24, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.radiko")){
			ItemStack skull = ItemFactory.createHead("Radiko", "07ef2b1b-183d-4808-8fb8-60fba3131fd7", "eyJ0aW1lc3RhbXAiOjE0NDc2NzY4ODkwMDUsInByb2ZpbGVJZCI6IjA3ZWYyYjFiMTgzZDQ4MDg4ZmI4NjBmYmEzMTMxZmQ3IiwicHJvZmlsZU5hbWUiOiJSYWRpa28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMxMzZmZWQxMzllNzU1ODViZDNkMDQ3YzlmZjI3YzBhZDM0ZmQyZTgwMjUxY2I4ZjIyMTc1NmU0Yzk4M2Y0ZSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Radiko");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(25, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Radiko");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(25, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.filip6cz")){
			ItemStack skull = ItemFactory.createHead("Filip6_CZ", "c25f01ec-9fa8-4ff6-ae34-7286f8c44b27", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIyODgyMjEsInByb2ZpbGVJZCI6ImMyNWYwMWVjOWZhODRmZjZhZTM0NzI4NmY4YzQ0YjI3IiwicHJvZmlsZU5hbWUiOiJGaWxpcDZfQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBlZDhlNjhmMTE1NjgwZWQ4NWZkODk2OGMxOTIyNWFkNzM3ZWUyZTViMTJmM2Y4MWJkMmMyZWQ0NzViZTIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Filip6_CZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(26, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Filip6_CZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(26, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.skateque")){
			ItemStack skull = ItemFactory.createHead("SkateQue", "4049f7f9-6869-4d1b-983e-246f348603c4", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcwNTgxOTgsInByb2ZpbGVJZCI6IjQwNDlmN2Y5Njg2OTRkMWI5ODNlMjQ2ZjM0ODYwM2M0IiwicHJvZmlsZU5hbWUiOiJTa2F0ZVF1ZSIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82MjgxNzI1MWEzNTZlMWE1ZmRkMzQ2MjY3YjQ0MTIxZGYyOWRjYjBjOWJhNzQ2MGNjYjYxNmM2NTM3YTI0MyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "SkateQue");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(27, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "SkateQue");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(27, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.spexikex")){
			ItemStack skull = ItemFactory.createHead("SpexikEx", "9b72557a-b9a0-480b-829a-32128219af5d", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIzMzQ3OTcsInByb2ZpbGVJZCI6IjliNzI1NTdhYjlhMDQ4MGI4MjlhMzIxMjgyMTlhZjVkIiwicHJvZmlsZU5hbWUiOiJTcGV4aWtFeCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mM2E1MjRiM2MzMmI0MzdkNzY0MThjNGI5NTg5YTA3M2Y5NTRjMmJlN2VkYmM3YzBkNGZiNDI1NGFmN2JmYmU0IiwibWV0YWRhdGEiOnsibW9kZWwiOiJzbGltIn19fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "SpexikEx");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(28, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "SpexikEx");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(28, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.sprajtiik")){
			ItemStack skull = ItemFactory.createHead("Sprajtiik", "5bc96e8c-eb0b-4028-a433-43185ee30206", "eyJ0aW1lc3RhbXAiOjE0NTk0NTIzNjI0NDIsInByb2ZpbGVJZCI6IjViYzk2ZThjZWIwYjQwMjhhNDMzNDMxODVlZTMwMjA2IiwicHJvZmlsZU5hbWUiOiJTcHJhanRpaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDRmOTNlZDI4YzU0MThmYzRhYjJlYjFlODUxYWU1YTU2ZTc1YTE3ZDFlNTBlNTk3MmEyYTY1YWY3NGJjZDMifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Sprajtiik");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(29, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Sprajtiik");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(29, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.brancesko")){
			ItemStack skull = ItemFactory.createHead("Brancesko", "87e761a3-65c0-43b8-9551-bad0dbacd6f0", "eyJ0aW1lc3RhbXAiOjE0NTk0NDY5OTkxOTgsInByb2ZpbGVJZCI6Ijg3ZTc2MWEzNjVjMDQzYjg5NTUxYmFkMGRiYWNkNmYwIiwicHJvZmlsZU5hbWUiOiJCcmFuY2Vza28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzBjODE3MTM1MDk1ODZlZDQ1YmZmNzczYjU1OTM4N2YwOTIzMmU0MTk1ZTZmMjkzZTFjODk2NWZlNDUyMmUifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Brancesko");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(30, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Brancesko");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(30, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.crazyshanncz")){
			ItemStack skull = ItemFactory.createHead("CrazyShann_Cz", "95fffed8-8961-434a-9355-59ae809a2ada", "eyJ0aW1lc3RhbXAiOjE0NTk0NDcwNjE4NTAsInByb2ZpbGVJZCI6Ijk1ZmZmZWQ4ODk2MTQzNGE5MzU1NTlhZTgwOWEyYWRhIiwicHJvZmlsZU5hbWUiOiJDcmF6eVNoYW5uX0N6IiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Y4MmJiZGMzMjYyNTk3YTg5YTkyMmIzMTNlY2E0ZDg3Njg5NmVmYTMyYTVmNDg5M2Y3OTA1NzExZjAyZjg3ZiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "CrazyShann_Cz");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(31, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "CrazyShann_Cz");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(31, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.soony37cze")){
			ItemStack skull = ItemFactory.createHead("Soony37CZE", "f4376c30-07ca-4dd3-992e-3fc9f2410c92", "eyJ0aW1lc3RhbXAiOjE0NTk0NTI0MDIzMDksInByb2ZpbGVJZCI6ImY0Mzc2YzMwMDdjYTRkZDM5OTJlM2ZjOWYyNDEwYzkyIiwicHJvZmlsZU5hbWUiOiJTb29ueTM3Q1pFIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc1NGQ3NjUxMDkzYjlhNWQ2NjU3MTE0ZDQ4Y2E0ZTY1MDZlYmI4OTJjOTgyNGZkMzZjOWMzNjk4MWM5MTcifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Soony37CZE");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(32, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Soony37CZE");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(32, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.marki35")){
			ItemStack skull = ItemFactory.createHead("Marki35", "b0a6ea8c-1119-41eb-a806-49c287baf3ed", "eyJ0aW1lc3RhbXAiOjE0NTk0NTE3OTYwNTAsInByb2ZpbGVJZCI6ImIwYTZlYThjMTExOTQxZWJhODA2NDljMjg3YmFmM2VkIiwicHJvZmlsZU5hbWUiOiJNYXJraTM1IiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Q3MmFjNzliOTcyMDc0NDBlYmMwNmQyMTc1ZmQ3MTRhM2VjZjQwNDM1ZTU5YzQ1Yzk3ZGYxN2Q3YzI4MjEzYSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Marki35");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(33, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Marki35");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(33, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.nurtuka")){
			ItemStack skull = ItemFactory.createHead("Nurtuka", "1f159f46-90dc-4f01-8ba3-9dcdc53b2046", "eyJ0aW1lc3RhbXAiOjE0NTk0NTE4ODkxMDIsInByb2ZpbGVJZCI6IjFmMTU5ZjQ2OTBkYzRmMDE4YmEzOWRjZGM1M2IyMDQ2IiwicHJvZmlsZU5hbWUiOiJOdXJ0dWthIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Q5YzYxNTQ1NTE2YjE2ZTJjNGQ0M2FkOGJlNGQ4YWYyNjY3ZDdhOGIzYzMyYzUxYTgwMjg3NWM0YjBlNjVhYTEifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Nurtuka");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(34, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Nurtuka");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(34, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.patule1215")){
			ItemStack skull = ItemFactory.createHead("patule1215", "d47a6921-6d3b-49e2-a66e-700656ff8497", "eyJ0aW1lc3RhbXAiOjE0NTk0NTE5ODM2MjgsInByb2ZpbGVJZCI6ImQ0N2E2OTIxNmQzYjQ5ZTJhNjZlNzAwNjU2ZmY4NDk3IiwicHJvZmlsZU5hbWUiOiJwYXR1bGUxMjE1IiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzlkNTRiZmY2YTZiMzc2NmNjZDFhYzY0OTU5N2Y1YTgyNTE2NzdmNjQ1YTk3Njc3OGMyNWE5MTFmM2RiN2RjIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "patule1215");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(35, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "patule1215");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(35, noPerm);
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
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		hm.setItem(49, shopItem);
		hm.setItem(40, deaktivace);
		hm.setItem(41, dalsi);
		hm.setItem(39, zpet);
		
		p.openInventory(hm);
	}

}
