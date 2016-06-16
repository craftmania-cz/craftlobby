package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;

public class PetsAPI implements Listener{
	
	private MessagesListener ml = new MessagesListener();
	
	public void openMainInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "Pets");
		
		if(p.hasPermission("craftlobby.pets.cat.black") 
				|| p.hasPermission("craftlobby.pets.cat.red") 
				|| p.hasPermission("craftlobby.pets.cat.siamese")
				|| p.hasPermission("craftlobby.pets.cat.black.baby")
				|| p.hasPermission("craftlobby.pets.cat.red.baby")
				|| p.hasPermission("craftlobby.pets.cat.siamese.baby")
				|| p.hasPermission("craftlobby.pets.cat.wild")
				|| p.hasPermission("craftlobby.pets.cat.wild.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§eCat", "", "§7Kliknutim zobrazis prehled.");
			inv.setItem(0, i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat", "§7Nevlastnis ani jeden druh.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.cow")
				|| p.hasPermission("craftlobby.pets.cow.baby")){
			ItemStack i = ItemFactory.create(Material.COOKED_BEEF,(byte)0, "§eCow","","§7Kliknutim zobrazis preshled.");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCow", "§7Nevlastnis ani jeden druh.");
			inv.setItem(1, i);
		}
		if(p.hasPermission("craftlobby.pets.pig")
				|| p.hasMetadata("craftlobby.pets.pig.baby")){
			ItemStack i = ItemFactory.create(Material.PORK,(byte)0, "§ePig","","§7Kliknutim zobrazis preshled.");
			inv.setItem(2,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cPig", "§7Nevlastnis ani jeden druh.");
			inv.setItem(2, i);
		}
		if(p.hasPermission("craftlobby.pets.chicken")
				|| p.hasPermission("craftlobby.pets.chicken.baby")){
			ItemStack i = ItemFactory.create(Material.EGG,(byte)0, "§eChicken","","§7Kliknutim zobrazis preshled.");
			inv.setItem(3,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cChicken", "§7Nevlastnis ani jeden druh.");
			inv.setItem(3, i);
		}
		if(p.hasPermission("craftlobby.pets.endermite")){
			ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER,(byte)0, "§eEndermite","","§7Kliknutim zobrazis preshled.");
			inv.setItem(4,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cEndermite", "§7Nevlastnis ani jeden druh.");
			inv.setItem(4, i);
		}
		if(p.hasPermission("craftlobby.pets.silverfish")){
			ItemStack i = ItemFactory.create(Material.FLINT,(byte)0, "§eSilverfish","","§7Kliknutim zobrazis preshled.");
			inv.setItem(5,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cSilverfish", "§7Nevlastnis ani jeden druh.");
			inv.setItem(5, i);
		}
		if(p.hasPermission("craftlobby.pets.wolf")
				|| p.hasPermission("craftlobby.pets.wolf")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0, "§eWolf","","§7Kliknutim zobrazis preshled.");
			inv.setItem(6,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cWolf", "§7Nevlastnis ani jeden druh.");
			inv.setItem(6, i);
		}

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet do Gadgets menu");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(49, shopItem);
		inv.setItem(48, zpet);
		
		p.openInventory(inv);
	}

	public void openWolfMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Wolf");

		if(p.hasPermission("craftlobby.pets.wolf")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cWolf", "§7Tento typ nevlastnis.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.wolf.baby")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cWolf (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(1, i);
		}

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openChickenMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Chicken");

		if(p.hasPermission("craftlobby.pets.chicken")){
			ItemStack i = ItemFactory.create(Material.EGG,(byte)0,"§aChicken", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cChicken", "§7Tento typ nevlastnis.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.chicken.baby")){
			ItemStack i = ItemFactory.create(Material.EGG,(byte)0,"§aChicken (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cChicken (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(1, i);
		}

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openPigMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Pig");

		if(p.hasPermission("craftlobby.pets.pig")){
			ItemStack i = ItemFactory.create(Material.GRILLED_PORK,(byte)0,"§aPig", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cPig", "§7Tento typ nevlastnis.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.pig.baby")){
			ItemStack i = ItemFactory.create(Material.PORK,(byte)0,"§aPig (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cPig (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(1, i);
		}

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openCowMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Cow");

		if(p.hasPermission("craftlobby.pets.cow")){
			ItemStack i = ItemFactory.create(Material.COOKED_BEEF,(byte)0,"§aCow", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCow", "§7Tento typ nevlastnis.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.cow.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_BEEF,(byte)0,"§aCow (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCow (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(1, i);
		}

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openCatMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Cat");

		if(p.hasPermission("craftlobby.pets.cat.black")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Black", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Black", "§7Tento typ nevlastnis.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.black.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Black (Baby)", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Black (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(1, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.red")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Red", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Red", "§7Tento typ nevlastnis.");
			inv.setItem(2, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.red.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Red (Baby)", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Red (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(3, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Siamese", "§7Tento typ nevlastnis.");
			inv.setItem(4, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese (Baby)", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Siamese (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(5, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.wild")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Wild", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
			inv.setItem(6,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Wild", "§7Tento typ nevlastnis.");
			inv.setItem(6, i);
		}
		if(p.hasPermission("craftlobby.pets.cat.wild.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Wild (Baby)", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
			inv.setItem(7,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat: Wild (Baby)", "§7Tento typ nevlastnis.");
			inv.setItem(7, i);
		}

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	@EventHandler
	private void onClick(InventoryClickEvent e){
		final Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equals("Pets")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 49){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 48){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 0){
				this.openCatMenu(p);
			}
			if(e.getSlot() == 1){
				this.openCowMenu(p);
			}
			if(e.getSlot() == 2){
				this.openPigMenu(p);
			}
			if(e.getSlot() == 3){
				this.openChickenMenu(p);
			}
			if(e.getSlot() == 4){
				EndermiteNormal.activate(p);
			}
			if(e.getSlot() == 5){
				SilverfishNormal.activate(p);
			}
			if(e.getSlot() == 6){
				this.openWolfMenu(p);
			}

		}
		if(e.getInventory().getTitle().equals("Pets - Cat")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 22){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 21){
				this.openMainInv(p);
			}
			if(e.getSlot() == 23){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.cat.black")){
					Cat.activate(p, false, Ocelot.Type.BLACK_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Black");
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.cat.black.baby")){
					Cat.activate(p, true, Ocelot.Type.BLACK_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Black (Baby)");
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.cat.red")){
					Cat.activate(p, false, Ocelot.Type.RED_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Red");
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.cat.red.baby")){
					Cat.activate(p, true, Ocelot.Type.RED_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Red (Baby)");
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.cat.siamese")){
					Cat.activate(p, false, Ocelot.Type.SIAMESE_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Siamese");
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.cat.siamese.baby")){
					Cat.activate(p, true, Ocelot.Type.SIAMESE_CAT);
				} else {
					this.ml.messageNoPerm(p,"Cat Siamese (Baby)");
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.cat.wild")){
					Cat.activate(p, false, Ocelot.Type.WILD_OCELOT);
				} else {
					this.ml.messageNoPerm(p,"Cat Wild");
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.cat.wild.baby")){
					Cat.activate(p, true, Ocelot.Type.WILD_OCELOT);
				} else {
					this.ml.messageNoPerm(p,"Cat Wild (Baby)");
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Cow")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 22){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 21){
				this.openMainInv(p);
			}
			if(e.getSlot() == 23){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.cow")){
					CowNormal.activateCow(p,false);
				} else {
					this.ml.messageNoPerm(p,"Cow");
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.cow.baby")){
					CowNormal.activateCow(p,true);
				} else {
					this.ml.messageNoPerm(p,"Cow (Baby)");
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Pig")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 22){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 21){
				this.openMainInv(p);
			}
			if(e.getSlot() == 23){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.pig")){
					PigNormal.activatePig(p,false);
				} else {
					this.ml.messageNoPerm(p,"Pig");
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.pig.baby")){
					PigNormal.activatePig(p,true);
				} else {
					this.ml.messageNoPerm(p,"Pig (Baby)");
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Chicken")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 22){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 21){
				this.openMainInv(p);
			}
			if(e.getSlot() == 23){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.chicken")){
					ChickenNormal.activateChicken(p,false);
				} else {
					this.ml.messageNoPerm(p,"Chicken");
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.chicken.baby")){
					ChickenNormal.activateChicken(p,true);
				} else {
					this.ml.messageNoPerm(p,"Chicken (Baby)");
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Wolf")){
			if (e.getCurrentItem() == null){
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			if(e.getSlot() == 22){
				Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
			}
			if(e.getSlot() == 21){
				this.openMainInv(p);
			}
			if(e.getSlot() == 23){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.wolf")){
					WolfNormal.activate(p,false);
				} else {
					this.ml.messageNoPerm(p,"Wolf");
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.wolf.baby")){
					WolfNormal.activate(p,true);
				} else {
					this.ml.messageNoPerm(p,"Wolf (Baby)");
				}
			}
		}
	}

}
