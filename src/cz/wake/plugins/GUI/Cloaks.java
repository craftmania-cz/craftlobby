package cz.wake.plugins.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import cz.wake.plugins.Main;
import cz.wake.plugins.cloaks.AngleCloak;
import cz.wake.plugins.cloaks.Hero;
import cz.wake.plugins.cloaks.SantaCloak;
import cz.wake.plugins.utils.ItemFactory;

public class Cloaks {
	
	public void openCloaks(Player p){
		
		Inventory cloakMenu = Bukkit.createInventory(null, 54, "Cloaks");
		
		if(p.hasPermission("craftlobby.cloaks.santa")){
			if(SantaCloak.santaCloaks.containsKey(p.getName())){
				ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte)0, "§a§lSanta Cloak", "", "§7S timto budes vypadat jako", "§7opravdovy santa.", "", "§cAktivovano!");
				i = ItemFactory.addGlow(i);
				cloakMenu.setItem(10, i);
			} else {
				ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte)0, "§a§lSanta Cloak", "", "§7S timto budes vypadat jako", "§7opravdovy santa.", "", "§eKliknutim aktivujes!");
				cloakMenu.setItem(10, i);
			}
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§c§lSanta Cloak", "§7Tento Cloak se ziskat o Vanocich 2015.");
			cloakMenu.setItem(10, i);
		}
		if(p.hasPermission("craftlobby.cloaks.angel")){
			if(AngleCloak.angelCloaks.containsKey(p.getName())){
				ItemStack i = ItemFactory.create(Material.BREAD, (byte)0, "§a§lAngel Cloak", "", "§7Jako ten pravy andel,", "§7budes vypadat.", "", "§cAktivovano!");
				i = ItemFactory.addGlow(i);
				cloakMenu.setItem(11, i);
			} else {
				ItemStack i = ItemFactory.create(Material.BREAD, (byte)0, "§a§lAngel Cloak", "", "§7Jako ten pravy andel,", "§7budes vypadat.", "", "§eKliknutim aktivujes!");
				cloakMenu.setItem(11, i);
			}
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§c§lAngel Cloak", "§7Tento Cloak se da  ziskat v CraftBoxu.");
			cloakMenu.setItem(11, i);
		}
		if(p.hasPermission("craftlobby.cloaks.hero")){
			if(Hero.heroCloaks.containsKey(p.getName())){
				ItemStack i = ItemFactory.create(Material.REDSTONE, (byte)0, "§a§lHero", "", "§7Kazdy superhrdina,", "§7musi mit plast.", "", "§cAktivovano!");
				i = ItemFactory.addGlow(i);
				cloakMenu.setItem(12, i);
			} else {
				ItemStack i = ItemFactory.create(Material.REDSTONE, (byte)0, "§a§lHero", "", "§7Kazdy superhrdina,", "§7musi mit plast.", "", "§eKliknutim aktivujes!");
				cloakMenu.setItem(12, i);
			}
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§c§lHero", "§7Tento Cloak se da ziskat v CraftBoxu.");
			cloakMenu.setItem(12, i);
		}
		
		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet do Gadgets menu");
		
		//Deaktivace
		ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte)0, "§c Vypnout cloak ✖", "§7Kliknutim vypnes cloak.");
		
		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets", 
				"§7Gadgety jsou doplnky do lobby", 
				"§7daji se ziskat z CraftBoxu nebo na", 
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
		
		cloakMenu.setItem(49, shopItem);
		cloakMenu.setItem(40, deaktivace);
		cloakMenu.setItem(39, zpet);
		
		p.openInventory(cloakMenu);
	}

}
