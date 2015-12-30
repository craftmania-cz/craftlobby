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
import cz.wake.plugins.pets.CatRed;
import cz.wake.plugins.pets.CatSiamese;
import cz.wake.plugins.pets.ChickenNormal;
import cz.wake.plugins.pets.CowNormal;
import cz.wake.plugins.pets.EndermiteNormal;
import cz.wake.plugins.pets.PetManager;
import cz.wake.plugins.pets.PigNormal;
import cz.wake.plugins.pets.RabbitBlack;
import cz.wake.plugins.pets.RabbitBrown;
import cz.wake.plugins.pets.RabbitGold;
import cz.wake.plugins.pets.SilverfishNormal;
import cz.wake.plugins.pets.WolfNormal;
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
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		petsMenu.setItem(49, shopItem);
		petsMenu.setItem(40, deaktivace);
		petsMenu.setItem(39, zpet);
		
		p.openInventory(petsMenu);
	}

}
