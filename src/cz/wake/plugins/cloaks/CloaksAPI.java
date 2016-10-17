package cz.wake.plugins.cloaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;

public class CloaksAPI implements Listener{
	
	private AngleCloak angel = new AngleCloak();
	private Hero hero = new Hero();
	private SantaCloak santa = new SantaCloak();
	private MessagesListener ml = new MessagesListener();
	
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
	
	@EventHandler
	private void onClick(InventoryClickEvent e){
		final Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equals("Cloaks")){
			if (e.getCurrentItem() == null){
	    		return;
	        }
			if (e.getCurrentItem().getType() == Material.AIR){
            	return;
            }
			if(e.getSlot() == 40){
				deactivateCloaks(p);
        		p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
        		p.closeInventory();
			}
			if(e.getSlot() == 39){
            	Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
        	if(e.getSlot() == 49){
        		Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
        	if(e.getSlot() == 10){
        		if(p.hasPermission("craftlobby.cloaks.santa")){
        			deactivateCloaks(p);
        			this.santa.activateSanta(p);
            		p.closeInventory();
        		} else {
					this.ml.messageNoPerm(p, "Santa Cloak");
        		}
        	}
        	if(e.getSlot() == 11){
        		if(p.hasPermission("craftlobby.cloaks.angel")){
        			deactivateCloaks(p);
        			this.angel.activate(p);
        			p.closeInventory();
        		} else {
					this.ml.messageNoPerm(p, "Angel Cloak");
        		}
        	}
            Hero.deactivateCape(p);
		}
	}
	
	public void deactivateCloaks(Player p){
		if(SantaCloak.santaCloaks.containsKey(p.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)SantaCloak.santaCloaks.get(p.getName())).intValue());
			SantaCloak.santaCloaks.remove(p.getName());
			p.getInventory().setArmorContents(null);
			p.closeInventory();
		}
		if(AngleCloak.angelCloaks.containsKey(p.getName())){
			Bukkit.getScheduler().cancelTask(((Integer)AngleCloak.angelCloaks.get(p.getName())).intValue());
			AngleCloak.angelCloaks.remove(p.getName());
			p.getInventory().setArmorContents(null);
			p.closeInventory();
		}
	}

}
