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
		
		Inventory hm = Bukkit.createInventory(null, 54, "Heads (3 z 3 stran)");
		
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
			ItemStack skull = ItemFactory.createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NDc2MDQ4MzA3ODQsInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iNDRmM2FiZGFmYWIyZWU0OWZiODZjNzU1Zjk1NWY5ZTM0ODdiN2M2OWY4ZDY3MWQ1YjI4YTc3NDc2ZDA3ZSJ9fX0=");
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
		if(p.hasPermission("craftlobby.heads.bobmancz")){
			ItemStack skull = ItemFactory.createHead("BobmanCZ", "99e5d498-c467-4857-b3c1-7ec2d9c7f16d", "eyJ0aW1lc3RhbXAiOjE0NDc2MDUxNzk0NDQsInByb2ZpbGVJZCI6Ijk5ZTVkNDk4YzQ2NzQ4NTdiM2MxN2VjMmQ5YzdmMTZkIiwicHJvZmlsZU5hbWUiOiJCb2JtYW5DWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lYzVjNjljYmUwMWJmMTMxOTk5ZDNmZGQ0YTg0MjA2MzJlMmIyNTE2NTY3ZGMyZmU5N2E2M2EwNmM0ZjMzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "BobmanCZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(10, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "BobmanCZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ccarmel")){
			ItemStack skull = ItemFactory.createHead("Ccarmel", "81b28a0a-1b32-4d55-8f10-fff7021d4c23", "eyJ0aW1lc3RhbXAiOjE0NDc2MDUzNTk0OTEsInByb2ZpbGVJZCI6IjgxYjI4YTBhMWIzMjRkNTU4ZjEwZmZmNzAyMWQ0YzIzIiwicHJvZmlsZU5hbWUiOiJDY2FybWVsIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2FmODQxZWMzYzcyMDk2Y2I4MmRiZjhkYWE1OTdiMTE1MjNlMmRhMmQ1MTQwNjJlYWM5YmI2YmEwZWI0OGUxYyJ9fX0=");
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
			ItemStack skull = ItemFactory.createHead("Flafy_LP", "63e2cc82-a760-432c-9cce-f0e297f14389", "eyJ0aW1lc3RhbXAiOjE0NDc2MDg0MDI0MDAsInByb2ZpbGVJZCI6IjYzZTJjYzgyYTc2MDQzMmM5Y2NlZjBlMjk3ZjE0Mzg5IiwicHJvZmlsZU5hbWUiOiJGbGFmeV9MUCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yN2UzZTA1YjE3ODRhNjZjZTYzM2MwM2FiOGRlZDgzMThlZTM0OGJmYWRlZGYxOWE5N2U3ZGE0MmUxM2Y3YyJ9fX0=");
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
		if(p.hasPermission("craftlobby.heads.happymousecz")){
			ItemStack skull = ItemFactory.createHead("HappyMouseCZ", "99f5df27-b1a3-43e8-9441-20ab49dc7a6b", "eyJ0aW1lc3RhbXAiOjE0NDc2MDg1MDYxNzAsInByb2ZpbGVJZCI6Ijk5ZjVkZjI3YjFhMzQzZTg5NDQxMjBhYjQ5ZGM3YTZiIiwicHJvZmlsZU5hbWUiOiJIYXBweU1vdXNlQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ4ZGRkZTllY2JkOTNiMTIxMzRkOWFhMjE4YzI3ZDM2NjU0ZWUwZGI0NGExZTg3ZjQ1NGVlMzg0NzVmOWQzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "HappyMouseCZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(13, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "HappyMouseCZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ispencz")){
			ItemStack skull = ItemFactory.createHead("iSpenCZ", "6c8ea6ed-913c-4b91-a777-cc284da867d2", "eyJ0aW1lc3RhbXAiOjE0NDc2MDg3MzI4MTUsInByb2ZpbGVJZCI6IjZjOGVhNmVkOTEzYzRiOTFhNzc3Y2MyODRkYTg2N2QyIiwicHJvZmlsZU5hbWUiOiJpU3BlbkNaIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzlhYTE2ZTk1Nzk1ZDg2NmFmM2ZjNGE2YWVhY2I1YTNiZGFiZDZhYmY5MjFlNzYyNmY5ZmVlZjhjMWQ5YzkifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "iSpenCZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(14, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "iSpenCZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.aywytristax")){
			ItemStack skull = ItemFactory.createHead("Aywy_TristaX", "1578ab17-9df6-4fa2-96a2-b63a2e07e18b", "eyJ0aW1lc3RhbXAiOjE0NDc2MTEyMDY5MDYsInByb2ZpbGVJZCI6IjE1NzhhYjE3OWRmNjRmYTI5NmEyYjYzYTJlMDdlMThiIiwicHJvZmlsZU5hbWUiOiJBeXd5X1RyaXN0YVgiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWJhZDVmZWNkNTk5OTZjMWQyMjU3OTEyYzlkOWM3MzMxYjZiZjhmNWQ4M2M2Y2QyMmE4OWQ0MGJmOTcyMSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Aywy_TristaX");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(15, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Aywy_TristaX");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.itzjarko")){
			ItemStack skull = ItemFactory.createHead("iTz_Jarko", "cb91e9c3-3ec1-432e-8dad-c631f9b38daf", "eyJ0aW1lc3RhbXAiOjE0NDc2MTEyNjc3MjcsInByb2ZpbGVJZCI6ImNiOTFlOWMzM2VjMTQzMmU4ZGFkYzYzMWY5YjM4ZGFmIiwicHJvZmlsZU5hbWUiOiJpVHpfSmFya28iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5Yzk5MzYxMTc4MmEzZmU5NjNjNmM5ODVhYzg5ZjFjMzE2ZjMyNmU4ZmE4ZThmMmFkODVmYmYzM2UzNWFkIn19fQ==");
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
		if(p.hasPermission("craftlobby.heads.mrdkevcz")){
			ItemStack skull = ItemFactory.createHead("MrdKev_CZ", "bfcf0400-f9ed-4589-b761-04fc35bb8bd6", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE2NjkxNTAsInByb2ZpbGVJZCI6ImJmY2YwNDAwZjllZDQ1ODliNzYxMDRmYzM1YmI4YmQ2IiwicHJvZmlsZU5hbWUiOiJNcmRLZXZfQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJhZThmODA2YTk2NjE0MTRkNmNlZjc1ZmQ0NTMwYTU0MWMyOTljMGU3ZjY1NTEzYTQ5M2QwYmU1YjliZDQiLCJtZXRhZGF0YSI6eyJtb2RlbCI6InNsaW0ifX19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "MrdKev_CZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(19, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "MrdKev_CZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mrspirith")){
			ItemStack skull = ItemFactory.createHead("MrSpirith", "75095752-c042-4aad-aa7f-15dbc57a28d9", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE3NjkzNjEsInByb2ZpbGVJZCI6Ijc1MDk1NzUyYzA0MjRhYWRhYTdmMTVkYmM1N2EyOGQ5IiwicHJvZmlsZU5hbWUiOiJNclNwaXJpdGgiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY1YzNhNjcyYmIzYzYyOWJmMGI5YTc2NGY5NDZkZTIyNmJiMGM1ODEyNDZkNzkyYmFjZWU4NmNkOTZmMiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "MrSpirith");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(20, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "MrSpirith");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.nedzdo")){
			ItemStack skull = ItemFactory.createHead("Nedzdo", "03683a45-67a5-4444-823a-a43c49215767", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE4Nzk3ODIsInByb2ZpbGVJZCI6IjAzNjgzYTQ1NjdhNTQ0NDQ4MjNhYTQzYzQ5MjE1NzY3IiwicHJvZmlsZU5hbWUiOiJOZWR6ZG8iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5NmFlODA4Nzg2ZjYzY2E0YjE1ZWY5NDIxMWU1MWQzMjUwYjRkOWYwYjlkMTdiZDIxMWNiNTJjMTk4YjRkZCJ9fX0=");
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
		if(p.hasPermission("craftlobby.heads.omgmen")){
			ItemStack skull = ItemFactory.createHead("omgmen", "e273ca85-41ac-4f1f-8bc7-915b3cd4caa5", "eyJ0aW1lc3RhbXAiOjE0NDc2MTE5NDE1NjksInByb2ZpbGVJZCI6ImUyNzNjYTg1NDFhYzRmMWY4YmM3OTE1YjNjZDRjYWE1IiwicHJvZmlsZU5hbWUiOiJvbWdtZW4iLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA3N2NlNDMzZjM2NGM2Y2IxZTY0NmQ4Y2ExMDkwZGQ1MDM3YTQwODI2NWYyNWJjZGRjY2YyOWE2NDQzNzE4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "omgmen");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(22, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "omgmen");
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
			ItemStack skull = ItemFactory.createHead("R3pl1kat0r", "379161e5-7373-4917-ba83-ca601e9f0b90", "eyJ0aW1lc3RhbXAiOjE0NDc2NzY4MjA5MDUsInByb2ZpbGVJZCI6IjM3OTE2MWU1NzM3MzQ5MTdiYTgzY2E2MDFlOWYwYjkwIiwicHJvZmlsZU5hbWUiOiJSM3BsMWthdDByIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Y1NTU1ZmFiNTRjMmY3YmVhYWY4YTUxYmI3MTRjMmMyY2FiZmY2N2MzMjI5MmZhMTNmOTEzZTI0MmIzMzQzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "R3pl1kat0r");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(24, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "R3pl1kat0r");
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
		if(p.hasPermission("craftlobby.heads.shadow79")){
			ItemStack skull = ItemFactory.createHead("shadow79", "27bf5ec8-8c2f-4745-8495-53cab2a2b600", "eyJ0aW1lc3RhbXAiOjE0NDc2NzY5MzE0OTcsInByb2ZpbGVJZCI6IjI3YmY1ZWM4OGMyZjQ3NDU4NDk1NTNjYWIyYTJiNjAwIiwicHJvZmlsZU5hbWUiOiJTaGFkb3c3OSIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xYjFmYWU5OWU4ZWU5Mjk0ZWJlYjg4MWRjYWVjZTYzNDcxZTE0MjFmZmFjODJlYzFkZTEyYjYxNTU1YyJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "shadow79");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(26, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "shadow79");
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
			ItemStack skull = ItemFactory.createHead("SpexikEx", "9b72557a-b9a0-480b-829a-32128219af5d", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcxOTM1NjcsInByb2ZpbGVJZCI6IjliNzI1NTdhYjlhMDQ4MGI4MjlhMzIxMjgyMTlhZjVkIiwicHJvZmlsZU5hbWUiOiJTcGV4aWtFeCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84NjI2ZTY5ZDE4ZWNiOWI1Yjk1MzlmOGNkMTIzOGFlNTg0YzdkZmM1OWRkNGRjNGNjYzMzZjU3ZDk4YTQ3MGY3In19fQ==");
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
			ItemStack skull = ItemFactory.createHead("Sprajtiik", "5bc96e8c-eb0b-4028-a433-43185ee30206", "eyJ0aW1lc3RhbXAiOjE0NDc2NzcyOTE3ODksInByb2ZpbGVJZCI6IjViYzk2ZThjZWIwYjQwMjhhNDMzNDMxODVlZTMwMjA2IiwicHJvZmlsZU5hbWUiOiJTcHJhanRpaWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmM2EzMWZjMjJiYmUyMDk0Y2E3MDIxNzM5ZGZlOWZiYmIzOWU2MGU5MjJkN2U2MDVhMTczNDZiNzU0MyJ9fX0=");
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
		if(p.hasPermission("craftlobby.heads.spyrosvk")){
			ItemStack skull = ItemFactory.createHead("SpyroSVK", "cd31c3fd-7464-4ad8-98f6-dbbd71b9f79a", "eyJ0aW1lc3RhbXAiOjE0NDc2Nzg3NTA4NDUsInByb2ZpbGVJZCI6ImNkMzFjM2ZkNzQ2NDRhZDg5OGY2ZGJiZDcxYjlmNzlhIiwicHJvZmlsZU5hbWUiOiJTcHlyb1NWSyIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzMxYjYyNjk3MmI2MTBmOWMxOGJlNDcxNTMyNTUyZjljYTY2NTcwYjBmYzUzOTI4MTRhYWE5M2FkN2MzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "SpyroSVK");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(30, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "SpyroSVK");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(30, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.toumancz")){
			ItemStack skull = ItemFactory.createHead("ToumanCZ", "fd51846d-197b-45cd-ac9a-8b15046ee7bd", "eyJ0aW1lc3RhbXAiOjE0NDc2Nzg4MTIzOTgsInByb2ZpbGVJZCI6ImZkNTE4NDZkMTk3YjQ1Y2RhYzlhOGIxNTA0NmVlN2JkIiwicHJvZmlsZU5hbWUiOiJUb3VtYW5DWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xMDQxM2Y3NzJkMTU3MGIyZmFlMWY2NWY5ZmZlNjZlZjRkNWE1MzkyYzFlZjk5NjI1MGNmYWU3ZTY3NDJlZCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "ToumanCZ");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(31, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "ToumanCZ");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(31, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.xero2000")){
			ItemStack skull = ItemFactory.createHead("xero2000", "3ad14ba5-6575-4827-9f5f-d617e556c47a", "eyJ0aW1lc3RhbXAiOjE0NDc2Nzg4NjMxMjMsInByb2ZpbGVJZCI6IjNhZDE0YmE1NjU3NTQ4Mjc5ZjVmZDYxN2U1NTZjNDdhIiwicHJvZmlsZU5hbWUiOiJ4ZXJvMjAwMCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iM2FjYTM2NDMzNmRmMDJjNzVkYmE4ZmVmODE4YTgyNGM3ZDQyZWFiMzFkZTFmNTdlMjRlMThkOTgxZGRkNDEifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "xero2000");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			hm.setItem(32, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "xero2000");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			hm.setItem(32, noPerm);
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
		shopItemMeta.setDisplayName(ChatColor.GREEN + "Shop");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Kliknutim si otevres shop");
		shopLore.add(ChatColor.GRAY + "kde si muzes nakoupit za CC");
		shopLore.add(ChatColor.GRAY + "nove hats, gadgets, trails atd.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.YELLOW + Main.getInstance().getAPI().getCraftCoins(p) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		hm.setItem(49, shopItem);
		hm.setItem(40, deaktivace);
		hm.setItem(39, zpet);
		
		p.openInventory(hm);
	}

}
