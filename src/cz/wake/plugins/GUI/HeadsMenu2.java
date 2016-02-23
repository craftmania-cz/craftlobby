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
import cz.wake.plugins.utils.ItemFactory;

public class HeadsMenu2 implements Listener{
	
	public void openHeadsMenu2(Player p){
		
		Inventory headsMenu = Bukkit.createInventory(null, 54, "Heads (2 z 4 stran)");
		
		if(p.hasPermission("craftlobby.heads.a")){
			ItemStack skull = ItemFactory.createHead("A", "d9e6ae1b-8e1d-4ae7-8f5b-b581b1771d40", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MGRhMjk0NGExNzdkZDA4MjY4ZmJlYzA0ZTQwODEyZDFkOTI5NjUwYmU2NjUyOWIxZWU1ZTFlN2VjYSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "A");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(0, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "A");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(0, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.b")){
			ItemStack skull = ItemFactory.createHead("B", "a389402c-129b-4de2-8877-7912a1afe881", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA0MWY1ZTg2OTgzZDM2ZWFlYzRlMTY3YjJiYmI1YTM3Mjc2MDdjZGU4OGY3NTU1Y2ExYjUyMmEwMzliYiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "B");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(1, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "B");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(1, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.c")){
			ItemStack skull = ItemFactory.createHead("C", "5aafc18c-4341-4d65-bbfe-062706ffb067", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDk0NTk5NmM4YWU5MWUzNzYxOTZkNGRjNjc2ZmVjMzFmZWFjNzkwYTJmMTk1YjI5ODFhNzAzY2ExZDE2Y2I2In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "C");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(2, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "C");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(2, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.d")){
			ItemStack skull = ItemFactory.createHead("D", "2bb28566-da08-4b69-963f-da9561f1d0a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY0MTE1MGY0ODFlODQ5MmY3MTI4Yzk0ODk5NjI1NGQyZDkxZmM5MGY1YThmZjRkOGFjNWMzOWE2YTg4YSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "D");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(3, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "D");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(3, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.e")){
			ItemStack skull = ItemFactory.createHead("E", "72c35d01-c507-4efc-9184-63c32cdf4687", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGIyNTE0ODdmZjhlZWYyZWJjN2E1N2RhYjZlM2Q5ZjFkYjdmYzkyNmRkYzY2ZmVhMTRhZmUzZGZmMTVhNDUifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "E");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(4, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "E");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(4, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.f")){
			ItemStack skull = ItemFactory.createHead("F", "b46b2241-5546-48db-a457-a2dbad23db27", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U0MzM2NTZiNDQzNjY4ZWQwM2RhYzhjNDQyNzIyYTJhNDEyMjFiZThiYjQ4ZTIzYjM1YmQ4YzJlNTlmNjMifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "F");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(5, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "F");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(5, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.g")){
			ItemStack skull = ItemFactory.createHead("G", "4b0845df-5f9a-47ab-8ab7-044f810017fd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk1ODYzYjczNjM3NjA1ZmVhY2JiMTczYjc3ZDVlMTU1ZTY1MjA0Yzc4ZDVjNzkxMWY3MzhmMjhkZWI2MCJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "G");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(6, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "G");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(6, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.h")){
			ItemStack skull = ItemFactory.createHead("H", "ea507bde-e39a-4e8c-b6a7-35fffed066c6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2MxZDM1OGQ5MjcwNzQyODljYzI2YmZmNWIxMjQwNzQ2ZjlmNGYwY2M0NmY5NDJmNTk4MWM2NTk1ZjcyZGQifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "H");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(7, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "H");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(7, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.i")){
			ItemStack skull = ItemFactory.createHead("I", "84143d3c-f198-461d-aecc-40741d5494fe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYyMjk1ODY1YmRhNGU0Nzk3OWQzNmI4YTg4N2E3NWExM2IwMzRlNjk4OGY3ODY3MGI2NGExZTY0NDJjIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "I");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(8, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "I");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(8, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.j")){
			ItemStack skull = ItemFactory.createHead("J", "3814608a-d3e2-49ce-9ebf-fe4c25efd882", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NDYyYjU1ZDdmNTgyMzY4MGFkMTNmMmFkYmQ3ZDFlZDQ2YmE1MTAxMDE3ZWQ0YjM3YWVlZWI3NzVkIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "J");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(9, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "J");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(9, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.k")){
			ItemStack skull = ItemFactory.createHead("K", "519c18a7-f30d-4f03-8975-9655f2360347", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzczMzI1YTkzNWMwNjdiNmVmMjI3MzY3ZjYyY2E0YmY0OWY2N2FkYjlmNmRhMzIwOTFlMmQzMmM1ZGRlMzI4In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "K");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(10, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "K");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.l")){
			ItemStack skull = ItemFactory.createHead("L", "c5d1650f-c193-4f67-be23-7eae09a66e1c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVhMWUzMzI4YzU3MWFhNDk1ZDljNWY0OTQ4MTVjY2ExNzZjM2FjYjE4NGZlYjVhN2I5Yzk2Y2U4ZTUyZmNlIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "L");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(11, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "L");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.m")){
			ItemStack skull = ItemFactory.createHead("M", "d6a7ebad-3f25-4d4c-9bf0-36b069dc38ca", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ2N2JmNmJlOTVlNWM4ZTlkMDE5NzdhMmYwYzQ4N2VkNWIwZGU1Yzg3OTYzYTJlYjE1NDExYzQ0MmZiMmIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "M");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(12, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "M");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.n")){
			ItemStack skull = ItemFactory.createHead("N", "d621ae4e-f103-4b78-a180-c756b76b45b4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIzZTQzNGQ2Mzk1ZmU3ZTYzNDkyNDMxYmRlZTU3ODJiZDVlZTViYzhjYWI3NTU5NDY3YmRkMWY5M2I5MjVhIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "N");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(13, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "N");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.o")){
			ItemStack skull = ItemFactory.createHead("O", "425da042-932b-483d-9252-b7783871b66e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0NDU0NjZiZGM1YWQ1YmNlYTgyMjM5YzRlMWI1MTBmNmVhNTI2MmQ4MmQ4YTk2ZDcyOTFjMzQyZmI4OSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "O");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(14, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "O");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.p")){
			ItemStack skull = ItemFactory.createHead("P", "ebfde078-cc98-48f1-ac64-608c8545cc28", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkZTYwMWRlZTNmZmVjYTRkNTQ1OTVmODQ0MjAxZDBlZDIwOTFhY2VjNDU0OGM2OTZiYjE2YThhMTU4ZjYifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "P");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(15, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "P");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.q")){
			ItemStack skull = ItemFactory.createHead("Q", "5f94a01f-2bf4-497b-90fb-188e38055ca9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjZjYTc2OWJkZTI1ZDRjYzQxZTE5ZTQyYWRjMzVhYjRjMTU1N2I3NmFmMjMyNjQ5YWNjOTk2N2ZmMTk4ZjEzIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Q");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(16, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Q");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.r")){
			ItemStack skull = ItemFactory.createHead("R", "ff745ee1-3463-473e-9e5d-db5b3f9e56a1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdhMTg4ODA1MTYyY2E1ZGQ0ZjQ2NDljNjYxZDNmNmQyM2M0MjY2MmFlZjAxNjQ1YjFhOTdmNzhiM2YxMzIxOSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "R");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(17, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "R");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(17, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.s")){
			ItemStack skull = ItemFactory.createHead("S", "7fdd4eda-abdb-4019-aa25-9c23b69f0012", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkMDlkZmQ5ZjVkZTYyNDMyMzNlMGUzMzI1YjZjMzQ3OTMzNWU3Y2NmMTNmMjQ0OGQ0ZTFmN2ZjNGEwZGYifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "S");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(18, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "S");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(18, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.t")){
			ItemStack skull = ItemFactory.createHead("T", "28408552-4d4a-4830-a90e-8d2d98f84dcc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRjNzU2MTliOTFkMjQxZjY3ODM1MGFkOTIzN2MxMzRjNWUwOGQ4N2Q2ODYwNzQxZWRlMzA2YTRlZjkxIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "T");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(19, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "T");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.u")){
			ItemStack skull = ItemFactory.createHead("U", "0b7ee6c6-f3ae-43a2-b19b-0c9df57a752d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTlmNmQyYzZkNTI4NWY4ODJhZTU1ZDFlOTFiOGY5ZWZkZmM5YjM3NzIwOGJmNGM4M2Y4OGRkMTU2NDE1ZSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "U");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(20, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "U");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.v")){
			ItemStack skull = ItemFactory.createHead("V", "4a7d6a90-977e-4708-976b-c52d27ecaa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNlMjdhMTUzNjM1ZjgzNTIzN2Q4NWM2YmY3NGY1YjFmMmU2MzhjNDhmZWU4YzgzMDM4ZDA1NThkNDFkYTcifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "V");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(21, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "V");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(21, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.w")){
			ItemStack skull = ItemFactory.createHead("W", "eacab58c-56fb-46d9-97f6-c1c2cab2cf9e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVkY2Y0ZmZjYjUzYjU2ZDQyYmFhYzlkMGRmYjExOGUzNDM0NjIzMjc0NDJkZDliMjlkNDlmNTBhN2QzOGIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "W");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(22, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "W");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(22, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.x")){
			ItemStack skull = ItemFactory.createHead("X", "1f5d7b63-569e-4d96-b7fb-ef437ef39850", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM2MThmZjEyMTc2NDBiZWM1YjUyNWZhMmE4ZTY3MWM3NWQyYTdkN2NiMmRkYzMxZDc5ZDlkODk1ZWFiMSJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "X");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(23, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "X");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(23, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.y")){
			ItemStack skull = ItemFactory.createHead("Y", "fd3e1792-dd5e-497a-b2af-c24a22ca75e0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDljMWQyOWEzOGJjZjExM2I3ZThjMzRlMTQ4YTc5ZjlmZTQxZWRmNDFhYThiMWRlODczYmIxZDQzM2IzODYxIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Y");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(24, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Y");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(24, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.z")){
			ItemStack skull = ItemFactory.createHead("Z", "34b483d5-b7b7-4a33-b8c1-bb725969bd4a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjkyOTU3MzQxOTVkMmM3ZmEzODliOTg3NTdlOTY4NmNlNjQzN2MxNmM1OGJkZjJiNGNkNTM4Mzg5YjU5MTIifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Z");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(25, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Z");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(25, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.enderchest")){
			ItemStack skull = ItemFactory.createHead("Enderchest", "42db67b6-9dd1-4bfe-b478-8829c1622218", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Enderchest");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(26, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Enderchest");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(26, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.fishtank")){
			ItemStack skull = ItemFactory.createHead("FishTank", "afcf2ba0-0405-428f-b727-c4acdda0dc75", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNlOGZkYTEzMDNiNWIzMjM5Yjk2ZWZiYTM5NWY2MjcxN2NjODc4NWJlMzJlMWQ4ODlhZmU2Yjk3YmIxYzFhIn19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "FishTank");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(27, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "FishTank");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(27, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.herobrine")){
			ItemStack skull = ItemFactory.createHead("Herobrine", "d0b15454-36fa-43e4-a247-f882bb9fe288", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThiN2NhM2M3ZDMxNGE2MWFiZWQ4ZmMxOGQ3OTdmYzMwYjZlZmM4NDQ1NDI1YzRlMjUwOTk3ZTUyZTZjYiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Herobrine");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(28, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Herobrine");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(28, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.mummy")){
			ItemStack skull = ItemFactory.createHead("Mummy", "8f7c0c5b-720f-4944-8481-b0f7931f303f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U5MWU5NTgyMmZlOThjYzVhNTY1OGU4MjRiMWI4Y2YxNGQ0ZGU5MmYwZTFhZjI0ODE1MzcyNDM1YzllYWI2In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Mummy");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(29, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Mummy");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(29, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.blackcat")){
			ItemStack skull = ItemFactory.createHead("BlackCat", "6dbe3930-9e7c-426a-a7aa-4a48e93078a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q4Y2RjYTg3Mjk2Njc5Y2EyNmFhZDY3MDQzYmYxZDQ0Yjk4MjYyMTljY2E5ZjRjNDlhNDExM2IxNzZlNGMifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "BlackCat");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(30, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "BlackCat");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(30, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.helloweenpumpkin")){
			ItemStack skull = ItemFactory.createHead("HelloweenPumpkin", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "HelloweenPumpkin");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(31, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "HelloweenPumpkin");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(31, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.devil")){
			ItemStack skull = ItemFactory.createHead("Devil", "c3c88c33-f305-4c10-9303-ce658b2fbde7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRhMzkyNjllZjQ1ZjgyNWVjNjFiYjRmOGFhMDliZDNjZjA3OTk2ZmI2ZmFjMzM4YTZlOTFkNjY5OWFlNDI1In19fQ==");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Devil");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(32, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Devil");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(32, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.skeletonminer")){
			ItemStack skull = ItemFactory.createHead("SkeletonMiner", "fc0cbbe8-e2e2-4118-99a4-e4f811e75511", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM3ZjhmOTVjMTI1NzU3Y2JmNzY3YTExZjUyYTRlNjY5MWNlMThhMjU5NzhjNjhjZmEzOTEwMzYwZmUifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "SkeletonMiner");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(33, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "SkeletonMiner");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(33, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.witch")){
			ItemStack skull = ItemFactory.createHead("Witch", "68ab540e-1ad4-4680-9fc3-b42bcf869253", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRlZGJlZTQyYmU0NzJlM2ViNzkxZTdkYmRmYWYxOGM4ZmU1OTNjNjM4YmExMzk2YzllZjY4ZjU1NWNiY2UifX19");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Witch");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(34, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Witch");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(34, noPerm);
		}
		if(p.hasPermission("craftlobby.heads.ghost")){
			ItemStack skull = ItemFactory.createHead("Ghost", "31152fb2-cb1e-45c3-86dd-b23f7a20a6f8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkMjE4MzY0MDIxOGFiMzMwYWM1NmQyYWFiN2UyOWE5NzkwYTU0NWY2OTE2MTllMzg1NzhlYTRhNjlhZTBiNiJ9fX0=");
			ItemMeta sMeta = skull.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "Ghost");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
			sMeta.setLore(sLore);
			skull.setItemMeta(sMeta);
			headsMenu.setItem(35, skull);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Ghost");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			headsMenu.setItem(35, noPerm);
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
		
		headsMenu.setItem(49, shopItem);
		headsMenu.setItem(41, dalsi);
		headsMenu.setItem(40, deaktivace);
		headsMenu.setItem(39, zpet);
		
		p.openInventory(headsMenu);
	}

}
