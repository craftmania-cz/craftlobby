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
import cz.wake.plugins.pets.CatBlack;
import cz.wake.plugins.pets.CatBlackBaby;
import cz.wake.plugins.pets.CatRed;
import cz.wake.plugins.pets.CatRedBaby;
import cz.wake.plugins.pets.CatSiamese;
import cz.wake.plugins.pets.CatSiameseBaby;
import cz.wake.plugins.pets.ChickenBaby;
import cz.wake.plugins.pets.ChickenNormal;
import cz.wake.plugins.pets.CowBaby;
import cz.wake.plugins.pets.CowNormal;
import cz.wake.plugins.pets.EndermiteNormal;
import cz.wake.plugins.pets.HorseBrown;
import cz.wake.plugins.pets.HorseBrownBaby;
import cz.wake.plugins.pets.PigBaby;
import cz.wake.plugins.pets.PigNormal;
import cz.wake.plugins.pets.RabbitBlack;
import cz.wake.plugins.pets.RabbitBlackBaby;
import cz.wake.plugins.pets.RabbitBrown;
import cz.wake.plugins.pets.RabbitBrownBaby;
import cz.wake.plugins.pets.RabbitGold;
import cz.wake.plugins.pets.RabbitGoldBaby;
import cz.wake.plugins.pets.SheepBrown;
import cz.wake.plugins.pets.SheepBrownBaby;
import cz.wake.plugins.pets.SheepGray;
import cz.wake.plugins.pets.SheepGrayBaby;
import cz.wake.plugins.pets.SheepMagenta;
import cz.wake.plugins.pets.SheepOrange;
import cz.wake.plugins.pets.SheepSilver;
import cz.wake.plugins.pets.SheepSilverBaby;
import cz.wake.plugins.pets.SheepWhite;
import cz.wake.plugins.pets.SheepWhiteBaby;
import cz.wake.plugins.pets.SilverfishNormal;
import cz.wake.plugins.pets.WolfBaby;
import cz.wake.plugins.pets.WolfNormal;
import cz.wake.plugins.pets.ZombieBaby;
import cz.wake.plugins.pets.ZombieNormal;
import cz.wake.plugins.utils.ItemFactory;

public class PetsMenu implements Listener{
	
	public void openPets(Player p){
		
		Inventory petsMenu = Bukkit.createInventory(null, 54, "Pets");
		
		if(p.hasPermission("craftlobby.pets.cow")){
			if(CowNormal.cp.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)92);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lCow");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(0, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)92);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lCow");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(0, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCow");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(0, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.chicken")){
			if(ChickenNormal.cn.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)93);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lChicken");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(1, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)93);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lChicken");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(1, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lChicken");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(1, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.pig")){
			if(PigNormal.pn.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)90);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lPig");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(2, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)90);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lPig");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(2, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lPig");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(2, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.wolf")){
			if(WolfNormal.wn.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)95);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lWolf");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(3, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)95);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lWolf");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(3, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lWolf");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(3, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.silverfish")){
			if(SilverfishNormal.sn.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)60);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lSilverfish");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(4, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)60);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lSilverfish");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(4, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSilverfish");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(4, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.zombie")){
			if(ZombieNormal.zn.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)54);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lZombie");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(5, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)54);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lZombie");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(5, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lZombie");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(5, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.endermite")){
			if(EndermiteNormal.en.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)67);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lEndermite");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(6, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)67);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§lEndermite");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Common");
				lore.add("§7Typ: §8Default");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(6, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lEndermite");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(6, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown")){
			if(RabbitBrown.rb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Brown");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(7, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Brown");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(7, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Brown");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(7, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black")){
			if(RabbitBlack.rb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Black");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Black");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(8, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Black");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Black");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(8, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Black");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(8, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.gold")){
			if(RabbitGold.rg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Gold");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Gold");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(9, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)101);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lRabbit: Gold");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Gold");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(9, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Gold");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(9, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cat.black")){
			if(CatBlack.cb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Black");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Cerna");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(10, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Black");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Cerna");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(10, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Black");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cat.red")){
			if(CatRed.cr.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Red");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(11, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Red");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(11, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Red");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese")){
			if(CatSiamese.cs.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Siamese");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Seda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(12, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)98);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lCat: Siamese");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Seda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(12, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Siamese");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.white")){
			if(SheepWhite.sw.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: White");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Bila");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(13, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: White");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Bila");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(13, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: White");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray")){
			if(SheepGray.sg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)7);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Gray");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Seda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(14, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)7);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Gray");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Seda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(14, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Gray");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown")){
			if(SheepBrown.sb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)12);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(15, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)12);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(15, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Brown");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver")){
			if(SheepSilver.ss.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)8);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Silver");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Svetle seda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(16, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)8);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Silver");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Svetle seda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(16, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Silver");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.horse.brown")){
			if(HorseBrown.hb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)100);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lHorse: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(17, item);
			} else {
				ItemStack item = new ItemStack(Material.MONSTER_EGG,1,(byte)100);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lHorse: Brown");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Hneda");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(17, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lHorse: Brown");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(17, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.zombie.baby")){
			if(ZombieBaby.zb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.ROTTEN_FLESH,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lZombie: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(18, item);
			} else {
				ItemStack item = new ItemStack(Material.ROTTEN_FLESH,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lZombie: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(18, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lZombie: Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(18, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.pig.baby")){
			if(PigBaby.pb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.PORK,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lPig: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(19, item);
			} else {
				ItemStack item = new ItemStack(Material.PORK,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lPig: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(19, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lPig: Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cow.baby")){
			if(CowBaby.cb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RAW_BEEF,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCow: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(20, item);
			} else {
				ItemStack item = new ItemStack(Material.RAW_BEEF,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCow: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(20, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCow: Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.wolf.baby")){
			if(WolfBaby.wb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.BONE,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lWolf: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(21, item);
			} else {
				ItemStack item = new ItemStack(Material.BONE,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lWolf: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(21, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lWolf: Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(21, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.chicken.baby")){
			if(ChickenBaby.cb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.EGG,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lChicken: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(22, item);
			} else {
				ItemStack item = new ItemStack(Material.EGG,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lChicken: Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(22, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lChicken: Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(22, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown.baby")){
			if(RabbitBrownBaby.rb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(23, item);
			} else {
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(23, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Brown Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(23, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black.baby")){
			if(RabbitBlackBaby.rb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Black Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Cerna, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(24, item);
			} else {
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Black Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Cerna, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(24, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Black Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(24, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.gold.baby")){
			if(RabbitGoldBaby.rg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Gold Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Zlata, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(25, item);
			} else {
				ItemStack item = new ItemStack(Material.RABBIT_FOOT,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lRabbit: Gold Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Zlata, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(25, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lRabbit: Gold Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(25, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cat.black.baby")){
			if(CatBlackBaby.cb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Black Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Cerna, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(26, item);
			} else {
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Black Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Cerna, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(26, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Black Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(26, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.cat.red.baby")){
			if(CatRedBaby.cr.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Red Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(27, item);
			} else {
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Red Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(27, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Red Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(27, noPerm);
		}
		if(p.hasPermission("craftloby.pets.cat.siamese.baby")){
			if(CatSiameseBaby.cs.contains(p.getName())){
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Siamese Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Seda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(28, item);
			} else {
				ItemStack item = new ItemStack(Material.RAW_FISH,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lCat: Siamese Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Seda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(28, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCat: Siamese Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(28, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.horse.brown.baby")){
			if(HorseBrownBaby.hb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.SADDLE,1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lHorse: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(29, item);
			} else {
				ItemStack item = new ItemStack(Material.SADDLE,1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lHorse: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(29, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lHorse: Brown Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(29, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.white.baby")){
			if(SheepWhiteBaby.sw.contains(p.getName())){
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)15);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: White Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Bila, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(30, item);
			} else {
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)15);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: White Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Bila, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(30, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: White Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(30, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray.baby")){
			if(SheepGrayBaby.sg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)8);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Gray Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Seda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(31, item);
			} else {
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)8);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Gray Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Seda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(31, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Gray Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(31, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver.baby")){
			if(SheepSilverBaby.ss.contains(p.getName())){
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)7);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Silver Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Stribrna, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(32, item);
			} else {
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)7);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Silver Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Stribrna, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(32, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Silver Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(32, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown.baby")){
			if(SheepBrownBaby.sb.contains(p.getName())){
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)3);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(33, item);
			} else {
				ItemStack item = new ItemStack(Material.INK_SACK,1,(byte)3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§lSheep: Brown Baby");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Legandary");
				lore.add("§7Typ: §8Hneda, Baby");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(33, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Brown Baby");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(33, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.orange")){
			if(SheepOrange.sg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)1);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Orange");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Oranzova");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(34, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Orange");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Oranzova");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(34, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Orange");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(34, noPerm);
		}
		if(p.hasPermission("craftlobby.pets.sheep.magenta")){
			if(SheepMagenta.sg.contains(p.getName())){
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)2);
				item = ItemFactory.addGlow(item);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Magenta");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Svetle fialova");
				lore.add("");
				lore.add("§cAktivovano!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(35, item);
			} else {
				ItemStack item = new ItemStack(Material.WOOL,1,(byte)2);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§lSheep: Magenta");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§7Hodnota: §8Rare");
				lore.add("§7Typ: §8Svetle fialova");
				lore.add("");
				lore.add("§eKliknutim privolas!");
				meta.setLore(lore);
				item.setItemMeta(meta);
				petsMenu.setItem(35, item);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSheep: Magenta");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Mazlicka lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			petsMenu.setItem(35, noPerm);
		}
		
		ItemStack zpet = new ItemStack(Material.ARROW);
		ItemMeta zpetMeta = zpet.getItemMeta();
		zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
		zpet.setItemMeta(zpetMeta);
		
		ItemStack deaktivace = new ItemStack(Material.BARRIER);
		ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
		deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Odvolat mazlicka ✖");
		ArrayList<String> deaktivaceLore = new ArrayList<String>();
		deaktivaceLore.add(ChatColor.GRAY + "Kliknutim zrusis privolaneho mazlicka.");
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
		
		petsMenu.setItem(49, shopItem);
		petsMenu.setItem(40, deaktivace);
		petsMenu.setItem(39, zpet);
		
		p.openInventory(petsMenu);
	}

}
