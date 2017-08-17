
package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.manager.Shop;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;

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
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§eCat", "", this.getCountCats(p), "", "§aKliknutim zobrazis prehled.");
			inv.setItem(0, i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCat", "§7Nevlastnis ani jeden druh.");
			inv.setItem(0, i);
		}
		if(p.hasPermission("craftlobby.pets.cow")
				|| p.hasPermission("craftlobby.pets.cow.baby")
				|| p.hasPermission("craftlobby.pets.cow.mushroom")
				|| p.hasPermission("craftlobby.pets.cow.mushroom.baby")){
			ItemStack i = ItemFactory.create(Material.COOKED_BEEF,(byte)0, "§eCow", "", this.getCountCows(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(1,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCow", "§7Nevlastnis ani jeden druh.");
			inv.setItem(1, i);
		}
		if(p.hasPermission("craftlobby.pets.pig")
				|| p.hasMetadata("craftlobby.pets.pig.baby")){
			ItemStack i = ItemFactory.create(Material.PORK,(byte)0, "§ePig","", this.getCountPigs(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(2,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cPig", "§7Nevlastnis ani jeden druh.");
			inv.setItem(2, i);
		}
		if(p.hasPermission("craftlobby.pets.chicken")
				|| p.hasPermission("craftlobby.pets.chicken.baby")){
			ItemStack i = ItemFactory.create(Material.EGG,(byte)0, "§eChicken","", this.getCountChickens(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(3,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cChicken", "§7Nevlastnis ani jeden druh.");
			inv.setItem(3, i);
		}
		if(p.hasPermission("craftlobby.pets.endermite")){
			ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER,(byte)0, "§eEndermite","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
            inv.setItem(4, nakup("Endermite", 100));
		}
		if(p.hasPermission("craftlobby.pets.silverfish")){
			ItemStack i = ItemFactory.create(Material.FLINT,(byte)0, "§eSilverfish","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
            inv.setItem(5, nakup("Silverfish", 100));
		}
		if(p.hasPermission("craftlobby.pets.wolf")
				|| p.hasPermission("craftlobby.pets.wolf")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0, "§eWolf","", this.getCountWolf(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(6,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cWolf", "§7Nevlastnis ani jeden druh.");
			inv.setItem(6, i);
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black")
				|| p.hasPermission("craftlobby.pets.rabbit.black.baby")
				|| p.hasPermission("craftlobby.pets.rabbit.blackandwhite")
				|| p.hasPermission("craftlobby.pets.rabbit.blackandwhite.baby")
				|| p.hasPermission("craftlobby.pets.rabbit.brown")
				|| p.hasPermission("craftlobby.pets.rabbit.brown.baby")
				|| p.hasPermission("craftlobby.pets.rabbit.saltandpepper")
				|| p.hasPermission("craftlobby.pets.rabbit.saltandpepper.baby")
				|| p.hasPermission("craftlobby.pets.rabbit.killer")
				|| p.hasPermission("craftlobby.pets.rabbit.killer.baby")
				|| p.hasPermission("craftlobby.pets.rabbit.white")
				|| p.hasPermission("craftlobby.pets.rabbit.white.baby")
                || p.hasPermission("craftlobby.pets.rabbit.gold")
                || p.hasPermission("craftlobby.pets.rabbit.gold.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT_HIDE,(byte)0, "§eRabbit","", this.getCountRabbit(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(7,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cRabbit", "§7Nevlastnis ani jeden druh.");
			inv.setItem(7, i);
		}
		if(p.hasPermission("craftlobby.pets.zombie")
				|| p.hasPermission("craftlobby.pets.zombie.baby")
                || p.hasPermission("craftlobby.pets.zombie.husk")
                || p.hasPermission("craftlobby.pets.zombie.husk.baby")){
			ItemStack i = ItemFactory.create(Material.ROTTEN_FLESH,(byte)0, "§eZombie","", this.getCountZombie(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(8,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cZombie", "§7Nevlastnis ani jeden druh.");
			inv.setItem(8, i);
		}
		if(p.hasPermission("craftlobby.pets.horse.black")
				|| p.hasPermission("craftlobby.pets.horse.black.baby")
				|| p.hasPermission("craftlobby.pets.horse.brown")
				|| p.hasPermission("craftlobby.pets.horse.brown.baby")
				|| p.hasPermission("craftlobby.pets.horse.chestnut")
				|| p.hasPermission("craftlobby.pets.horse.chestnut.baby")
				|| p.hasPermission("craftlobby.pets.horse.creamy")
				|| p.hasPermission("craftlobby.pets.horse.creamy.baby")
				|| p.hasPermission("craftlobby.pets.horse.darkbrown")
				|| p.hasPermission("craftlobby.pets.horse.darkbrown.baby")
				|| p.hasPermission("craftlobby.pets.horse.gray")
				|| p.hasPermission("craftlobby.pets.horse.gray.baby")
				|| p.hasPermission("craftlobby.pets.horse.white")
				|| p.hasPermission("craftlobby.pets.horse.white.baby")
				|| p.hasPermission("craftlobby.pets.horse.donkey")
				|| p.hasPermission("craftlobby.pets.horse.mule")
				|| p.hasPermission("craftlobby.pets.horse.zombie")
				|| p.hasPermission("craftlobby.pets.horse.skeleton")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse","", this.getCountHorse(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(9,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cHorse", "§7Nevlastnis ani jeden druh.");
			inv.setItem(9, i);
		}
		if(p.hasPermission("craftlobby.pets.sheep.white")
				|| p.hasPermission("craftlobby.pets.sheep.white.baby")
				|| p.hasPermission("craftlobby.pets.sheep.black")
				|| p.hasPermission("craftlobby.pets.sheep.black.baby")
				|| p.hasPermission("craftlobby.pets.sheep.blue")
				|| p.hasPermission("craftlobby.pets.sheep.blue.baby")
				|| p.hasPermission("craftlobby.pets.sheep.brown")
				|| p.hasPermission("craftlobby.pets.sheep.brown.baby")
				|| p.hasPermission("craftlobby.pets.sheep.cyan")
				|| p.hasPermission("craftlobby.pets.sheep.cyan.baby")
				|| p.hasPermission("craftlobby.pets.sheep.green")
				|| p.hasPermission("craftlobby.pets.sheep.green.baby")
				|| p.hasPermission("craftlobby.pets.sheep.lightblue")
				|| p.hasPermission("craftlobby.pets.sheep.lightblue.baby")
				|| p.hasPermission("craftlobby.pets.sheep.lime")
				|| p.hasPermission("craftlobby.pets.sheep.lime.baby")
				|| p.hasPermission("craftlobby.pets.sheep.magenta")
				|| p.hasPermission("craftlobby.pets.sheep.magenta.baby")
				|| p.hasPermission("craftlobby.pets.sheep.orange")
				|| p.hasPermission("craftlobby.pets.sheep.orange.baby")
				|| p.hasPermission("craftlobby.pets.sheep.pink")
				|| p.hasPermission("craftlobby.pets.sheep.pink.baby")
				|| p.hasPermission("craftlobby.pets.sheep.purple")
				|| p.hasPermission("craftlobby.pets.sheep.purple.baby")
				|| p.hasPermission("craftlobby.pets.sheep.red")
				|| p.hasPermission("craftlobby.pets.sheep.red.baby")
				|| p.hasPermission("craftlobby.pets.sheep.silver")
				|| p.hasPermission("craftlobby.pets.sheep.silver.baby")
				|| p.hasPermission("craftlobby.pets.sheep.yellow")
				|| p.hasPermission("craftlobby.pets.sheep.yellow.baby")
				|| p.hasPermission("craftlobby.pets.sheep.gray")
				|| p.hasPermission("craftlobby.pets.sheep.gray.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§eSheep","", this.getCountSheep(p), "", "§aKliknutim zobrazis prehled.");
			inv.setItem(10,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cSheep", "§7Nevlastnis ani jeden druh.");
			inv.setItem(10, i);
		}
		if(p.hasPermission("craftlobby.pets.wither")){
			ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)1, "§eWither","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(11,i);
		} else {
            inv.setItem(11, nakup("Wither", 2000));
		}
		if(p.hasPermission("craftlobby.pets.slime.small")
				|| p.hasPermission("craftlobby.pets.slime.normal")
				|| p.hasPermission("craftlobby.pets.slime.big")){
			ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0, "§eSlime","", this.getCountSlime(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(12,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cSlime", "§7Nevlastnis ani jeden druh.");
			inv.setItem(12, i);
		}
		if(p.hasPermission("craftlobby.pets.spider")){
			ItemStack i = ItemFactory.create(Material.SPIDER_EYE,(byte)0, "§eSpider","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(13,i);
		} else {
            inv.setItem(13, nakup("Iron Golem", 200));
		}
		if(p.hasPermission("craftlobby.pets.cavespider")){
			ItemStack i = ItemFactory.create(Material.FERMENTED_SPIDER_EYE,(byte)0, "§eCaveSpider","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(14,i);
		} else {
            inv.setItem(14, nakup("Iron Golem", 200));
		}
		if(p.hasPermission("craftlobby.pets.irongolem")){
			ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0, "§eIronGolem","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(15,i);
		} else {
            inv.setItem(15, nakup("Iron Golem", 500));
		}
		if(p.hasPermission("craftlobby.pets.witch")){
			ItemStack i = ItemFactory.create(Material.SPLASH_POTION,(byte)0, "§eWitch","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(16,i);
		} else {
            inv.setItem(16, nakup("Witch", 300));
		}
		if(p.hasPermission("craftlobby.pets.enderman")){
			ItemStack i = ItemFactory.create(Material.ENDER_PEARL,(byte)0, "§eEnderman","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(17,i);
		} else {
            inv.setItem(17, nakup("Enderman", 300));
		}
		if(p.hasPermission("craftlobby.pets.blaze")){
			ItemStack i = ItemFactory.create(Material.BLAZE_POWDER,(byte)0, "§eBlaze","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(18,i);
		} else {
            inv.setItem(18, nakup("Blaze", 300));
		}
		if(p.hasPermission("craftlobby.pets.bat")){
			ItemStack i = ItemFactory.create(Material.FEATHER,(byte)0, "§eBat","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(19,i);
		} else {
            inv.setItem(19, nakup("Bat", 200));
		}
		if(p.hasPermission("craftlobby.pets.villager.blacksmith")
				|| p.hasPermission("craftlobby.pets.villager.blacksmith.baby")
				|| p.hasPermission("craftlobby.pets.villager.butcher")
				|| p.hasPermission("craftlobby.pets.villager.butcher.baby")
				|| p.hasPermission("craftlobby.pets.villager.farmer")
				|| p.hasPermission("craftlobby.pets.villager.farmer.baby")
				|| p.hasPermission("craftlobby.pets.villager.librarian")
				|| p.hasPermission("craftlobby.pets.villager.librarian.baby")
				|| p.hasPermission("craftlobby.pets.villager.priest")
				|| p.hasPermission("craftlobby.pets.villager.priest.baby")){
			ItemStack i = ItemFactory.create(Material.BOOK,(byte)0, "§eVillager","", this.getCountVillager(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(20,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cVillager", "§7Nevlastnis ani jeden druh.");
			inv.setItem(20, i);
		}
		if(p.hasPermission("craftlobby.pets.creeper")
				|| p.hasPermission("craftlobby.pets.creeper.powered")){
			ItemStack i = ItemFactory.create(Material.getMaterial(289),(byte)0, "§eCreeper","", this.getCountCreeper(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(21,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cCreeper", "§7Nevlastnis ani jeden druh.");
			inv.setItem(21, i);
		}
		if(p.hasPermission("craftlobby.pets.snowman")){
			ItemStack i = ItemFactory.create(Material.SNOW_BALL,(byte)0, "§eSnowman","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
			inv.setItem(22,i);
		} else {
            inv.setItem(22, nakup("Snowman", 100));
		}
		if(p.hasPermission("craftlobby.pets.skeleton")
				|| p.hasPermission("craftlobby.pets.skeleton.wither")){
			ItemStack i = ItemFactory.create(Material.BOW,(byte)0, "§eSkeleton","", this.getCountSkeleton(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(23,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cSkeleton", "§7Nevlastnis ani jeden druh.");
			inv.setItem(23, i);
		}
		if(p.hasPermission("craftlobby.pets.magmacube.small")
				|| p.hasPermission("craftlobby.pets.magmacube.normal")
				|| p.hasPermission("craftlobby.pets.magmacube.big")){
			ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0, "§eMagmaCube","", this.getCountMagaCube(p), "","§aKliknutim zobrazis prehled.");
			inv.setItem(24,i);
		} else {
			ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cMagmaCube", "§7Nevlastnis ani jeden druh.");
			inv.setItem(24, i);
		}
		if(p.hasPermission("craftlobby.pets.polarbear")
                || p.hasPermission("craftlobby.pets.polarbear.baby")){
            ItemStack i = ItemFactory.create(Material.SNOW_BLOCK,(byte)0, "§ePolarBear","", this.getCountPolarBear(p), "","§aKliknutim zobrazis prehled.");
            inv.setItem(25,i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cMagmaCube", "§7Nevlastnis ani jeden druh.");
            inv.setItem(25, i);
        }
        if(p.hasPermission("craftlobby.pets.guardian")
                || p.hasPermission("craftlobby.pets.guardian.elder")){
            ItemStack i = ItemFactory.create(Material.PRISMARINE_CRYSTALS,(byte)0, "§eGuardian","", this.getCountGuardian(p), "","§aKliknutim zobrazis prehled.");
            inv.setItem(26,i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cGuardian", "§7Nevlastnis ani jeden druh.");
            inv.setItem(26, i);
        }
        if(p.hasPermission("craftlobby.pets.vindicator")){
            ItemStack i = ItemFactory.create(Material.IRON_AXE, (byte)0, "§eVindicator", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
            inv.setItem(27, i);
        } else {
            inv.setItem(27, nakup("Vindicator", 100));
        }
        if(p.hasPermission("craftlobby.pets.evoker")){
            ItemStack i = ItemFactory.create(Material.TOTEM, (byte)0, "§eEvoker", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
            inv.setItem(28, i);
        } else {
            inv.setItem(28, nakup("Evoker", 400));
        }
        if(p.hasPermission("craftlobby.pets.vex")){
            ItemStack i = ItemFactory.create(Material.IRON_SWORD, (byte)0, "§eVex", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
            inv.setItem(29, i);
        } else {
            inv.setItem(29, nakup("Vex", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.white")
                || p.hasPermission("craftlobby.pets.llama.orange")
                || p.hasPermission("craftlobby.pets.llama.magenta")
                || p.hasPermission("craftlobby.pets.llama.lightblue")
                || p.hasPermission("craftlobby.pets.llama.yellow")
                || p.hasPermission("craftlobby.pets.llama.lime")
                || p.hasPermission("craftlobby.pets.llama.pink")
                || p.hasPermission("craftlobby.pets.llama.gray")
                || p.hasPermission("craftlobby.pets.llama.lightgray")
                || p.hasPermission("craftlobby.pets.llama.cyan")
                || p.hasPermission("craftlobby.pets.llama.purple")
                || p.hasPermission("craftlobby.pets.llama.blue")
                || p.hasPermission("craftlobby.pets.llama.brown")
                || p.hasPermission("craftlobby.pets.llama.green")
                || p.hasPermission("craftlobby.pets.llama.red")
                || p.hasPermission("craftlobby.pets.llama.black")
                || p.hasPermission("craftlobby.pets.llama.white.baby")
                || p.hasPermission("craftlobby.pets.llama.orange.baby")
                || p.hasPermission("craftlobby.pets.llama.magenta.baby")
                || p.hasPermission("craftlobby.pets.llama.lightblue.baby")
                || p.hasPermission("craftlobby.pets.llama.yellow.baby")
                || p.hasPermission("craftlobby.pets.llama.lime.baby")
                || p.hasPermission("craftlobby.pets.llama.pink.baby")
                || p.hasPermission("craftlobby.pets.llama.gray.baby")
                || p.hasPermission("craftlobby.pets.llama.lightgray.baby")
                || p.hasPermission("craftlobby.pets.llama.cyan.baby")
                || p.hasPermission("craftlobby.pets.llama.purple.baby")
                || p.hasPermission("craftlobby.pets.llama.blue.baby")
                || p.hasPermission("craftlobby.pets.llama.brown.baby")
                || p.hasPermission("craftlobby.pets.llama.green.baby")
                || p.hasPermission("craftlobby.pets.llama.red.baby")
                || p.hasPermission("craftlobby.pets.llama.black.baby")){
            ItemStack i = ItemFactory.create(Material.getMaterial(420), (byte)0,  "§eLlama","", getCountLlama(p), "","§aKliknutim zobrazis prehled.");
            inv.setItem(30, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte)8, "§cLlama", "§7Nevlastnis ani jeden druh.");
            inv.setItem(30, i);
        }

		//Deaktivace
		ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

		//Zpet do menu
		ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet do Gadgets menu");

		//Shop
		ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
				"§7Gadgety jsou doplnky do lobby",
				"§7daji se ziskat z CraftBoxu nebo na",
				"§7specialnich eventech.",
				"",
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(50, dea);
		inv.setItem(49, shopItem);
		inv.setItem(48, zpet);
		
		p.openInventory(inv);
	}

    private void openLlamaMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 54, "Pets - Llama");

        if(p.hasPermission("craftlobby.pets.llama.white")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)0, "§aLlama: White","", "§eKliknutim spawnes!");
            inv.setItem(0, i);
        } else {
            inv.setItem(0, nakup("Llama: White", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.orange")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)1, "§aLlama: Orange","", "§eKliknutim spawnes!");
            inv.setItem(1, i);
        } else {
            inv.setItem(1, nakup("Llama: Orange", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.magenta")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)2, "§aLlama: Magenta","", "§eKliknutim spawnes!");
            inv.setItem(2, i);
        } else {
            inv.setItem(2, nakup("Llama: Magenta", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lightblue")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)3, "§aLlama: Light Blue","", "§eKliknutim spawnes!");
            inv.setItem(3, i);
        } else {
            inv.setItem(3, nakup("Llama: Light Blue", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.yellow")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)4, "§aLlama: Yellow","", "§eKliknutim spawnes!");
            inv.setItem(4, i);
        } else {
            inv.setItem(4, nakup("Llama: Yellow", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lime")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)5, "§aLlama: Lime","", "§eKliknutim spawnes!");
            inv.setItem(5, i);
        } else {
            inv.setItem(5, nakup("Llama: Lime", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.pink")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)6, "§aLlama: Pink","", "§eKliknutim spawnes!");
            inv.setItem(6, i);
        } else {
            inv.setItem(6, nakup("Llama: Pink", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.gray")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)7, "§aLlama: Gray","", "§eKliknutim spawnes!");
            inv.setItem(7, i);
        } else {
            inv.setItem(7, nakup("Llama: Gray", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lightgray")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)8, "§aLlama: Light Gray","", "§eKliknutim spawnes!");
            inv.setItem(8, i);
        } else {
            inv.setItem(8, nakup("Llama: Light Gray", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.cyan")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)9, "§aLlama: Cyan","", "§eKliknutim spawnes!");
            inv.setItem(9, i);
        } else {
            inv.setItem(9, nakup("Llama: Cyan", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.purple")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)10, "§aLlama: Purple","", "§eKliknutim spawnes!");
            inv.setItem(10, i);
        } else {
            inv.setItem(10, nakup("Llama: Purple", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.blue")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)11, "§aLlama: Blue","", "§eKliknutim spawnes!");
            inv.setItem(11, i);
        } else {
            inv.setItem(11, nakup("Llama: Blue", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.brown")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)12, "§aLlama: Brown","", "§eKliknutim spawnes!");
            inv.setItem(12, i);
        } else {
            inv.setItem(12, nakup("Llama: Brown", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.green")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)13, "§aLlama: Green","", "§eKliknutim spawnes!");
            inv.setItem(13, i);
        } else {
            inv.setItem(13, nakup("Llama: Green", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.red")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)14, "§aLlama: Red","", "§eKliknutim spawnes!");
            inv.setItem(14, i);
        } else {
            inv.setItem(14, nakup("Llama: Red", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.black")){
            ItemStack i = ItemFactory.create(Material.WOOL, (byte)15, "§aLlama: Black","", "§eKliknutim spawnes!");
            inv.setItem(15, i);
        } else {
            inv.setItem(15, nakup("Llama: Black", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.white.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)0, "§aLlama: White (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(16, i);
        } else {
            inv.setItem(16, nakup("Llama: White (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.orange.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)1, "§aLlama: Orange (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(17, i);
        } else {
            inv.setItem(17, nakup("Llama: Orange (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.magenta.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)2, "§aLlama: Magenta (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(18, i);
        } else {
            inv.setItem(18, nakup("Llama: Magenta (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lightblue.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)3, "§aLlama: Light Blue (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(19, i);
        } else {
            inv.setItem(19, nakup("Llama: Light Blue (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.yellow.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)4, "§aLlama: Yellow (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(20, i);
        } else {
            inv.setItem(20, nakup("Llama: Yellow (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lime.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)5, "§aLlama: Lime (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(21, i);
        } else {
            inv.setItem(21, nakup("Llama: Lime (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.pink.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)6, "§aLlama: Pink (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(22, i);
        } else {
            inv.setItem(22, nakup("Llama: Pink (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.gray.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)7, "§aLlama: Gray (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(23, i);
        } else {
            inv.setItem(23, nakup("Llama: Gray (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.lightgray.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)8, "§aLlama: Light Gray (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(24, i);
        } else {
            inv.setItem(24, nakup("Llama: Light Gray (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.cyan.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)9, "§aLlama: Cyan (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(25, i);
        } else {
            inv.setItem(25, nakup("Llama: Cyan (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.purple.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)10, "§aLlama: Purple (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(26, i);
        } else {
            inv.setItem(26, nakup("Llama: Purple (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.blue.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)11, "§aLlama: Blue (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(27, i);
        } else {
            inv.setItem(27, nakup("Llama: Blue (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.brown.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)12, "§aLlama: Brown (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(28, i);
        } else {
            inv.setItem(28, nakup("Llama: Brown (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.green.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)13, "§aLlama: Green (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(29, i);
        } else {
            inv.setItem(29, nakup("Llama: Green (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.red.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)14, "§aLlama: Red (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(30, i);
        } else {
            inv.setItem(30, nakup("Llama: Red (Baby)", 100));
        }
        if(p.hasPermission("craftlobby.pets.llama.black.baby")){
            ItemStack i = ItemFactory.create(Material.CARPET, (byte)15, "§aLlama: Black (Baby)","", "§eKliknutim spawnes!");
            inv.setItem(31, i);
        } else {
            inv.setItem(31, nakup("Llama: Red (Baby)", 100));
        }

        //Deaktivace
        ItemStack dea = ItemFactory.create(Material.STAINED_GLASS,(byte)14,"§cDeaktivovat");

        //Zpet do menu
        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§cZpet do Gadgets menu");

        //Shop
        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte)0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

        inv.setItem(50, dea);
        inv.setItem(49, shopItem);
        inv.setItem(48, zpet);

        p.openInventory(inv);
    }

	private void openVillagerMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Villager");

		if(p.hasPermission("craftlobby.pets.villager.blacksmith")){
			ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aVillager: Blacksmith", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
            inv.setItem(0, nakup("Villager: Blacksmith", 100));
		}
		if(p.hasPermission("craftlobby.pets.villager.blacksmith.baby")){
			ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aVillager: Blacksmith (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
            inv.setItem(1, nakup("Villager: Blacksmith (Baby)", 200));
		}
		if(p.hasPermission("craftlobby.pets.villager.butcher")){
			ItemStack i = ItemFactory.create(Material.MUTTON,(byte)0,"§aVillager: Butcher", "", "§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
            inv.setItem(2, nakup("Villager: Butcher", 100));
		}
		if(p.hasPermission("craftlobby.pets.villager.butcher.baby")){
			ItemStack i = ItemFactory.create(Material.MUTTON,(byte)0,"§aVillager: Butcher (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
            inv.setItem(3, nakup("Villager: Butcher (Baby)", 200));
		}
		if(p.hasPermission("craftlobby.pets.villager.farmer")){
			ItemStack i = ItemFactory.create(Material.SEEDS,(byte)0,"§aVillager: Farmer", "", "§eKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
            inv.setItem(4, nakup("Villager: Farmer", 100));
		}
		if(p.hasPermission("craftlobby.pets.villager.farmer.baby")){
			ItemStack i = ItemFactory.create(Material.SEEDS,(byte)0,"§aVillager: Farmer (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
            inv.setItem(5, nakup("Villager: Farmer (Baby)", 200));
		}
		if(p.hasPermission("craftlobby.pets.villager.librarian")){
			ItemStack i = ItemFactory.create(Material.WRITTEN_BOOK,(byte)0,"§aVillager: Librarian", "", "§eKliknutim spawnes!");
			inv.setItem(6,i);
		} else {
            inv.setItem(6, nakup("Villager: Librarian", 100));
		}
		if(p.hasPermission("craftlobby.pets.villager.librarian.baby")){
			ItemStack i = ItemFactory.create(Material.WRITTEN_BOOK,(byte)0,"§aVillager: Librarian (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(7,i);
		} else {
            inv.setItem(7, nakup("Villager: Librarian (Baby)", 200));
		}
		if(p.hasPermission("craftlobby.pets.villager.priest")){
			ItemStack i = ItemFactory.create(Material.GHAST_TEAR,(byte)0,"§aVillager: Priest", "", "§eKliknutim spawnes!");
			inv.setItem(8,i);
		} else {
            inv.setItem(8, nakup("Villager: Priest (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.villager.priest.baby")){
			ItemStack i = ItemFactory.create(Material.GHAST_TEAR,(byte)0,"§aVillager: Priest (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(9,i);
		} else {
            inv.setItem(9, nakup("Villager: Priest (Baby)", 200));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openMagmaMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - MagmaCube");

		if(p.hasPermission("craftlobby.pets.magmacube.small")){
			ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Small", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
            inv.setItem(0, nakup("Slime (Small)", 150));
		}
		if(p.hasPermission("craftlobby.pets.magmacube.normal")){
			ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Normal", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
            inv.setItem(1, nakup("Slime (Normal)", 150));
		}
		if(p.hasPermission("craftlobby.pets.magmacube.big")){
			ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Big", "", "§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
            inv.setItem(2, nakup("Slime (Big)", 150));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openSlimeMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Slime");

		if(p.hasPermission("craftlobby.pets.slime.small")){
			ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Small", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
            inv.setItem(5, nakup("Slime (Small)", 100));
		}
		if(p.hasPermission("craftlobby.pets.slime.normal")){
			ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Normal", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
            inv.setItem(5, nakup("Slime (Normal)", 150));
		}
		if(p.hasPermission("craftlobby.pets.slime.big")){
			ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Big", "", "§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
            inv.setItem(5, nakup("Slime (Big)", 200));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openSheepMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 54, "Pets - Sheep");

		if(p.hasPermission("craftlobby.pets.sheep.white")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep White","","§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
            inv.setItem(0, nakup("Sheep: White", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.white.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep White (Baby)","","§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
            inv.setItem(1, nakup("Sheep: White (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.black")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)15, "§aSheep Black","","§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
            inv.setItem(2, nakup("Sheep: Black", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.black.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)15, "§aSheep Black (Baby)","","§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
            inv.setItem(3, nakup("Sheep: Black (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.blue")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)11, "§aSheep Blue","","§eKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
            inv.setItem(4, nakup("Sheep: Blue", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.blue.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)11, "§aSheep Blue (Baby)","","§eKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
            inv.setItem(5, nakup("Sheep: Blue (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)12, "§aSheep Brown","","§eKliknutim spawnes!");
			inv.setItem(6,i);
		} else {
            inv.setItem(6, nakup("Sheep: Brown", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.brown.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)12, "§aSheep Brown (Baby)","","§eKliknutim spawnes!");
			inv.setItem(7,i);
		} else {
            inv.setItem(7, nakup("Sheep: Brown (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.cyan")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)9, "§aSheep Cyan","","§eKliknutim spawnes!");
			inv.setItem(8,i);
		} else {
            inv.setItem(8, nakup("Sheep: Cyan", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.cyan.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)9, "§aSheep Cyan (Baby)","","§eKliknutim spawnes!");
			inv.setItem(9,i);
		} else {
            inv.setItem(9, nakup("Sheep: Cyan (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.green")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)13, "§aSheep Green","","§eKliknutim spawnes!");
			inv.setItem(10,i);
		} else {
            inv.setItem(10, nakup("Sheep: Green", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.green.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)13, "§aSheep Green (Baby)","","§eKliknutim spawnes!");
			inv.setItem(11,i);
		} else {
            inv.setItem(11, nakup("Sheep: Green (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.lightblue")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)3, "§aSheep LightBlue","","§eKliknutim spawnes!");
			inv.setItem(12,i);
		} else {
            inv.setItem(12, nakup("Sheep: Light Blue", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.lightblue.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)3, "§aSheep LightBlue (Baby)","","§eKliknutim spawnes!");
			inv.setItem(13,i);
		} else {
            inv.setItem(13, nakup("Sheep: Light Blue (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.lime")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)5, "§aSheep Lime","","§eKliknutim spawnes!");
			inv.setItem(14,i);
		} else {
            inv.setItem(14, nakup("Sheep: Lime", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.lime.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)5, "§aSheep Lime (Baby)","","§eKliknutim spawnes!");
			inv.setItem(15,i);
		} else {
            inv.setItem(15, nakup("Sheep: Lime (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.magenta")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)2, "§aSheep Magenta","","§eKliknutim spawnes!");
			inv.setItem(16,i);
		} else {
            inv.setItem(16, nakup("Sheep: Magenta", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.magenta.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)2, "§aSheep Magenta (Baby)","","§eKliknutim spawnes!");
			inv.setItem(17,i);
		} else {
            inv.setItem(17, nakup("Sheep: Magenta (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.orange")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)1, "§aSheep Orange","","§eKliknutim spawnes!");
			inv.setItem(18,i);
		} else {
            inv.setItem(18, nakup("Sheep: Orange", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.orange.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)1, "§aSheep Orange (Baby)","","§eKliknutim spawnes!");
			inv.setItem(19,i);
		} else {
            inv.setItem(19, nakup("Sheep: Orange (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.pink")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)6, "§aSheep Pink","","§eKliknutim spawnes!");
			inv.setItem(20,i);
		} else {
            inv.setItem(20, nakup("Sheep: Pink", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.pink.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)6, "§aSheep Pink (Baby)","","§eKliknutim spawnes!");
			inv.setItem(21,i);
		} else {
            inv.setItem(21, nakup("Sheep: Pink (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.purple")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)10, "§aSheep Purple","","§eKliknutim spawnes!");
			inv.setItem(22,i);
		} else {
            inv.setItem(22, nakup("Sheep: Purple", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.purple.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)10, "§aSheep Purple (Baby)","","§eKliknutim spawnes!");
			inv.setItem(23,i);
		} else {
            inv.setItem(23, nakup("Sheep: Purple (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.red")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)14, "§aSheep Red","","§eKliknutim spawnes!");
			inv.setItem(24,i);
		} else {
            inv.setItem(24, nakup("Sheep: Red", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.red.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)14, "§aSheep Red (Baby)","","§eKliknutim spawnes!");
			inv.setItem(25,i);
		} else {
            inv.setItem(25, nakup("Sheep: Red (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)8, "§aSheep Silver","","§eKliknutim spawnes!");
			inv.setItem(26,i);
		} else {
            inv.setItem(26, nakup("Sheep: Silver", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.silver.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)8, "§aSheep Silver (Baby)","","§eKliknutim spawnes!");
			inv.setItem(27,i);
		} else {
            inv.setItem(27, nakup("Sheep: Silver (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.yellow")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)4, "§aSheep Yellow","","§eKliknutim spawnes!");
			inv.setItem(28,i);
		} else {
            inv.setItem(28, nakup("Sheep: Yellow", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.yellow.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)4, "§aSheep Yellow (Baby)","","§eKliknutim spawnes!");
			inv.setItem(29,i);
		} else{
            inv.setItem(29, nakup("Sheep: Yellow (Baby)", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)7, "§aSheep Gray","","§eKliknutim spawnes!");
			inv.setItem(30,i);
		} else {
            inv.setItem(30, nakup("Sheep: Gray", 100));
		}
		if(p.hasPermission("craftlobby.pets.sheep.gray.baby")){
			ItemStack i = ItemFactory.create(Material.WOOL,(byte)7, "§aSheep Gray (Baby)","","§eKliknutim spawnes!");
			inv.setItem(31,i);
		} else {
            inv.setItem(31, nakup("Sheep: Gray (Baby)", 100));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(50, dea);
		inv.setItem(49, shopItem);
		inv.setItem(48, zpet);


		p.openInventory(inv);
	}

	public void openHorseMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Horse");

		if(p.hasPermission("craftlobby.pets.horse.black")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Black","","§7Kliknutim zobrazis preshled.");
			inv.setItem(0,i);
		} else {
            inv.setItem(0, nakup("Horse: Black", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.black.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Black (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(1,i);
		} else {
            inv.setItem(1, nakup("Horse: Black (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.brown")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Brown","","§7Kliknutim zobrazis preshled.");
			inv.setItem(2,i);
		} else {
            inv.setItem(2, nakup("Horse: Brown", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.brown.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Brown (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(3,i);
		} else {
            inv.setItem(3, nakup("Horse: Brown (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.chestnut")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Chestnut","","§7Kliknutim zobrazis preshled.");
			inv.setItem(4,i);
		} else {
            inv.setItem(4, nakup("Horse: Chestnut", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.chestnut.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Chestnut (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(5,i);
		} else {
            inv.setItem(5, nakup("Horse: Chestnut (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.creamy")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Creamy","","§7Kliknutim zobrazis preshled.");
			inv.setItem(6,i);
		} else {
            inv.setItem(6, nakup("Horse: Cramy", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.creamy.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Creamy (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(7,i);
		} else {
            inv.setItem(7, nakup("Horse: Cramy (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.darkbrown")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse DarkBrown","","§7Kliknutim zobrazis preshled.");
			inv.setItem(8,i);
		} else {
            inv.setItem(8, nakup("Horse: Dark Brown", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.darkbrown.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse DarkBrown (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(9,i);
		} else {
            inv.setItem(9, nakup("Horse: Dark Brown (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.gray")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Gray","","§7Kliknutim zobrazis preshled.");
			inv.setItem(10,i);
		} else {
            inv.setItem(10, nakup("Horse: Gray", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.gray.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Gray (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(11,i);
		} else {
            inv.setItem(10, nakup("Horse: Gray (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.white")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse White","","§7Kliknutim zobrazis preshled.");
			inv.setItem(12,i);
		} else {
            inv.setItem(12, nakup("Horse: White", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.white.baby")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse White (Baby)","","§7Kliknutim zobrazis preshled.");
			inv.setItem(13,i);
		} else {
            inv.setItem(13, nakup("Horse: White (Baby)", 150));
		}
		if(p.hasPermission("craftlobby.pets.horse.donkey")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eDonkey","","§7Kliknutim zobrazis preshled.");
			inv.setItem(14,i);
		} else {
            inv.setItem(14, nakup("Donkey", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.mule")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eMule","","§7Kliknutim zobrazis preshled.");
			inv.setItem(15,i);
		} else {
            inv.setItem(15, nakup("Mule", 100));
		}
		if(p.hasPermission("craftlobby.pets.horse.zombie")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eZombie Horse","","§7Kliknutim zobrazis preshled.");
			inv.setItem(16,i);
		} else {
            inv.setItem(16, nakup("Horse: Zombie", 400));
		}
		if(p.hasPermission("craftlobby.pets.horse.skeleton")){
			ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eSkeleton Horse","","§7Kliknutim zobrazis preshled.");
			inv.setItem(17,i);
		} else {
            inv.setItem(17, nakup("Horse: Skeleton", 400));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openSkeletonMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Skeleton");

		if(p.hasPermission("craftlobby.pets.skeleton")){
			ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)0,"§aSkeleton", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			inv.setItem(0, nakup("Skeleton", 300));
		}
		if(p.hasPermission("craftlobby.pets.skeleton.wither")){
			ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)1,"§aWither Skeleton", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Wither Skeleton", 600));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openGuardianMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 27, "Pets - Guardian");

        if(p.hasPermission("craftlobby.pets.guardian")){
            ItemStack i = ItemFactory.create(Material.PRISMARINE_CRYSTALS,(byte)0,"§aGuardian", "", "§eKliknutim spawnes!");
            inv.setItem(0,i);
        } else {
            inv.setItem(0, nakup("Guardian", 500));
        }
        if(p.hasPermission("craftlobby.pets.guardian.elder")){
            ItemStack i = ItemFactory.create(Material.PRISMARINE_SHARD,(byte)0,"§aGuardian Elder", "", "§eKliknutim spawnes!");
            inv.setItem(1,i);
        } else {
            inv.setItem(1, nakup("Guardian (Elder)", 1000));
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
                "§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

        inv.setItem(23, dea);
        inv.setItem(22, shopItem);
        inv.setItem(21, zpet);

        p.openInventory(inv);
    }

	public void openCreeperMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Creeper");

		if(p.hasPermission("craftlobby.pets.creeper")){
			ItemStack i = ItemFactory.create(Material.getMaterial(289),(byte)0,"§aCreeper", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			inv.setItem(0, nakup("Creeper", 400));
		}
		if(p.hasPermission("craftlobby.pets.creeper.powered")){
			ItemStack i = ItemFactory.create(Material.getMaterial(289),(byte)0,"§aCreeper (Powered)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Creeper (Powered)", 500));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openZombieMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Zombie");

		if(p.hasPermission("craftlobby.pets.zombie")){
			ItemStack i = ItemFactory.create(Material.ROTTEN_FLESH,(byte)0,"§aZombie", "", "§eKliknutim spawnes!");
			inv.setItem(0, i);
		} else {
			inv.setItem(0, nakup("Zombie", 200));
		}
		if(p.hasPermission("craftlobby.pets.zombie.baby")){
			ItemStack i = ItemFactory.create(Material.ROTTEN_FLESH,(byte)0,"§aZombie (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1, i);
		} else {
			inv.setItem(1, nakup("Zombie (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.zombie.husk")){
            ItemStack i = ItemFactory.create(Material.SAND,(byte)0,"§aZombie Husk", "", "§eKliknutim spawnes!");
            inv.setItem(2, i);
        } else {
            inv.setItem(2, nakup("Zombie Husk", 300));
        }
        if(p.hasPermission("craftlobby.pets.zombie.husk.baby")){
            ItemStack i = ItemFactory.create(Material.SAND,(byte)0,"§aZombie Husk (Baby)", "", "§eKliknutim spawnes!");
            inv.setItem(3, i);
        } else {
            inv.setItem(3, nakup("Zombie Husk (Baby)", 350));
        }
        if(p.hasPermission("craftlobby.pets.zombie.blacksmith")){
            ItemStack i = ItemFactory.create(Material.ANVIL,(byte)0,"§aZombie Blacksmith", "", "§eKliknutim spawnes!");
            inv.setItem(4, i);
        } else {
            inv.setItem(4, nakup("Zombie Blacksmith", 200));
        }
        if(p.hasPermission("craftlobby.pets.zombie.butcher")){
            ItemStack i = ItemFactory.create(Material.RAW_BEEF,(byte)0,"§aZombie Butcher", "", "§eKliknutim spawnes!");
            inv.setItem(5, i);
        } else {
            inv.setItem(5, nakup("Zombie Butcher", 200));
        }
        if(p.hasPermission("craftlobby.pets.zombie.farmer")){
            ItemStack i = ItemFactory.create(Material.GOLD_HOE,(byte)0,"§aZombie Farmer", "", "§eKliknutim spawnes!");
            inv.setItem(6, i);
        } else {
            inv.setItem(6, nakup("Zombie Farmer", 200));
        }
        if(p.hasPermission("craftlobby.pets.zombie.librarian")){
            ItemStack i = ItemFactory.create(Material.BOOK_AND_QUILL,(byte)0,"§aZombie Librarian", "", "§eKliknutim spawnes!");
            inv.setItem(7, i);
        } else {
            inv.setItem(7, nakup("Zombie Librarian", 200));
        }
        if(p.hasPermission("craftlobby.pets.zombie.priest")){
            ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aZombie Priest", "", "§eKliknutim spawnes!");
            inv.setItem(8, i);
        } else {
            inv.setItem(8, nakup("Zombie Priest", 200));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openRabbitMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Rabbit");

		if(p.hasPermission("craftlobby.pets.rabbit.black")){
			ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Black", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			inv.setItem(0, nakup("Rabbit Black", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.black.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Black (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Rabbit Black (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite")){
			ItemStack i = ItemFactory.create(Material.RABBIT_STEW,(byte)0,"§aRabbit Black & White", "", "§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
			inv.setItem(2, nakup("Rabbit Black & White", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT_STEW,(byte)0,"§aRabbit Black & White (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
			inv.setItem(3, nakup("Rabbit Black & White (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown")){
			ItemStack i = ItemFactory.create(Material.COOKED_RABBIT,(byte)0,"§aRabbit Brown", "", "§eKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
			inv.setItem(4, nakup("Rabbit Brown", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.brown.baby")){
			ItemStack i = ItemFactory.create(Material.COOKED_RABBIT,(byte)0,"§aRabbit Brown (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
			inv.setItem(5, nakup("Rabbit Brown (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper")){
			ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Salt & Pepper", "", "§eKliknutim spawnes!");
			inv.setItem(6,i);
		} else {
			inv.setItem(6, nakup("Rabbit Salt & Pepper", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Salt & Pepper (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(7,i);
		} else {
			inv.setItem(7, nakup("Rabbit Salt & Pepper (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.killer")){
			ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Killer", "", "§eKliknutim spawnes!");
			inv.setItem(8,i);
		} else {
			inv.setItem(8, nakup("Rabbit Killer", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.killer.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Killer (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(9,i);
		} else {
			inv.setItem(9, nakup("Rabbit Killer (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.white")){
			ItemStack i = ItemFactory.create(Material.RABBIT_HIDE,(byte)0,"§aRabbit White", "", "§eKliknutim spawnes!");
			inv.setItem(10,i);
		} else {
			inv.setItem(10, nakup("Rabbit White", 200));
		}
		if(p.hasPermission("craftlobby.pets.rabbit.white.baby")){
			ItemStack i = ItemFactory.create(Material.RABBIT_HIDE,(byte)0,"§aRabbit White (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(11,i);
		} else {
			inv.setItem(11, nakup("Rabbit White (Baby)", 250));
		}
        if(p.hasPermission("craftlobby.pets.rabbit.gold")){
            ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Gold", "", "§eKliknutim spawnes!");
            inv.setItem(12,i);
        } else {
            inv.setItem(12, nakup("Rabbit Gold", 200));
        }
        if(p.hasPermission("craftlobby.pets.rabbit.gold.baby")){
            ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Gold (Baby)", "", "§eKliknutim spawnes!");
            inv.setItem(13,i);
        } else {
            inv.setItem(13, nakup("Rabbit Gold (Baby)", 250));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openWolfMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - Wolf");

		if(p.hasPermission("craftlobby.pets.wolf")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf", "", "§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			inv.setItem(0, nakup("Wolf", 300));
		}
		if(p.hasPermission("craftlobby.pets.wolf.baby")){
			ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Wolf (Baby)", 350));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);

	}

	public void openBearMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 27, "Pets - PolarBear");

        if(p.hasPermission("craftlobby.pets.polarbear")){
            ItemStack i = ItemFactory.create(Material.SNOW_BLOCK,(byte)0,"§aPolarBear", "", "§eKliknutim spawnes!");
            inv.setItem(0,i);
        } else {
            inv.setItem(0, nakup("PolarBear", 400));
        }
        if(p.hasPermission("craftlobby.pets.polarbear.baby")){
            ItemStack i = ItemFactory.create(Material.SNOW_BLOCK,(byte)0,"§aPolarBear (Baby)", "", "§eKliknutim spawnes!");
            inv.setItem(1,i);
        } else {
            inv.setItem(1, nakup("PolarBear (Baby)", 500));
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
                "§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

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
			inv.setItem(0, nakup("Chicken", 100));
		}
		if(p.hasPermission("craftlobby.pets.chicken.baby")){
			ItemStack i = ItemFactory.create(Material.EGG,(byte)0,"§aChicken (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Chicken (Baby)", 150));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

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
			inv.setItem(0, nakup("Pig", 200));
		}
		if(p.hasPermission("craftlobby.pets.pig.baby")){
			ItemStack i = ItemFactory.create(Material.PORK,(byte)0,"§aPig (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Pig", 250));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

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
			inv.setItem(0, nakup("Cow", 200));
		}
		if(p.hasPermission("craftlobby.pets.cow.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_BEEF,(byte)0,"§aCow (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("Cow (Baby)", 250));
		}
		if(p.hasPermission("craftlobby.pets.cow.mushroom")){
			ItemStack i = ItemFactory.create(Material.RED_MUSHROOM,(byte)0,"§aCow Mushroom", "", "§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
			inv.setItem(2, nakup("Cow Mushroom", 300));
		}
		if(p.hasPermission("craftlobby.pets.cow.mushroom.baby")){
			ItemStack i = ItemFactory.create(Material.BROWN_MUSHROOM,(byte)0,"§aCow Mushroom (Baby)", "", "§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
			inv.setItem(3, nakup("Cow Mushroom", 350));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

		inv.setItem(23, dea);
		inv.setItem(22, shopItem);
		inv.setItem(21, zpet);

		p.openInventory(inv);
	}

	public void openCatMenu(final Player p){

		Inventory inv = Bukkit.createInventory(null, 27, "Pets - CatNormal");

		if(p.hasPermission("craftlobby.pets.cat.black")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Black", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
			inv.setItem(0,i);
		} else {
			inv.setItem(0, nakup("CatNormal: Black", 300));
		}
		if(p.hasPermission("craftlobby.pets.cat.black.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Black (Baby)", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
			inv.setItem(1,i);
		} else {
			inv.setItem(1, nakup("CatNormal: Black (Baby)", 350));
		}
		if(p.hasPermission("craftlobby.pets.cat.red")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Red", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
			inv.setItem(2,i);
		} else {
			inv.setItem(2, nakup("CatNormal: Red", 300));
		}
		if(p.hasPermission("craftlobby.pets.cat.red.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Red (Baby)", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
			inv.setItem(3,i);
		} else {
			inv.setItem(3, nakup("CatNormal: Red (Baby)", 350));
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
			inv.setItem(4,i);
		} else {
			inv.setItem(4, nakup("CatNormal: SIamese", 300));
		}
		if(p.hasPermission("craftlobby.pets.cat.siamese.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese (Baby)", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
			inv.setItem(5,i);
		} else {
			inv.setItem(5, nakup("CatNormal: Siamese (Baby)", 350));
		}
		if(p.hasPermission("craftlobby.pets.cat.wild")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Wild", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
			inv.setItem(6,i);
		} else {
			inv.setItem(6, nakup("CatNormal: Wild", 300));
		}
		if(p.hasPermission("craftlobby.pets.cat.wild.baby")){
			ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Wild (Baby)", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
			inv.setItem(7,i);
		} else {
			inv.setItem(7, nakup("CatNormal: Wild (Baby)", 350));
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
				"§7Aktualni stav: §6" +  Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

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
			if(e.getSlot() == 50){
				PetManager.forceRemovePet(p);
				p.closeInventory();
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
				if(p.hasPermission("craftlobby.pets.endermite")){
					EndermiteNormal.activate(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER,(byte)0, "§eEndermite","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
					Shop.open(p, "Endermite", "craftlobby.pets.endermite", i, 100);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.silverfish")){
					SilverfishNormal.activate(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.FLINT,(byte)0, "§eSilverfish","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Silverfish", "craftlobby.pets.silverfish", i, 100);
				}
			}
			if(e.getSlot() == 6){
				this.openWolfMenu(p);
			}
			if(e.getSlot() == 7){
				this.openRabbitMenu(p);
			}
			if(e.getSlot() == 8){
				this.openZombieMenu(p);
			}
			if(e.getSlot() == 9){
				this.openHorseMenu(p);
			}
			if(e.getSlot() == 10){
				this.openSheepMenu(p);
			}
			if(e.getSlot() == 11){
				if(p.hasPermission("craftlobby.pets.wither")){
					Widder.activateCow(p);
					p.closeInventory();
				} else {
                    ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)1, "§eWither","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Wither", "craftlobby.pets.wither", i, 2000);
				}
			}
			if(e.getSlot() == 12){
				this.openSlimeMenu(p);
			}
			if(e.getSlot() == 13){
				if(p.hasPermission("craftlobby.pets.spider")){
					SpiderNormal.activateSpider(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.SPIDER_EYE,(byte)0, "§eSpider","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Spider", "craftlobby.pets.spider", i, 200);
				}
			}
			if(e.getSlot() == 14){
				if(p.hasPermission("craftlobby.pets.cavespider")){
					CaveSpiderNormal.activateCave(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.FERMENTED_SPIDER_EYE,(byte)0, "§eCaveSpider","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Cave Spider", "craftlobby.pets.cavespider", i, 200);
				}
			}
			if(e.getSlot() == 15){
				if(p.hasPermission("craftlobby.pets.irongolem")){
					IronGolemNormal.activateGolem(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0, "§eIronGolem","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Iron Golem", "craftlobby.pets.irongolem", i, 500);
				}
			}
			if(e.getSlot() == 16){
				if(p.hasPermission("craftlobby.pets.witch")){
					WitchNormal.activateWitch(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.SPLASH_POTION,(byte)0, "§eWitch","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Witch", "craftlobby.pets.witch", i, 300);
				}
			}
			if(e.getSlot() == 17){
				if(p.hasPermission("craftlobby.pets.enderman")){
					EndermanNormal.activateWitch(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.ENDER_PEARL,(byte)0, "§eEnderman","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Enderman", "craftlobby.pets.enderman", i, 300);
				}
			}
			if(e.getSlot() == 18){
				if(p.hasPermission("craftlobby.pets.blaze")){
					BlazeNormal.activateWitch(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.BLAZE_POWDER,(byte)0, "§eBlaze","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
					Shop.open(p, "Blaze", "craftlobby.pets.blaze", i, 300);
				}
			}
			if(e.getSlot() == 19){
				if(p.hasPermission("craftlobby.pets.bat")){
					BatNormal.activate(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.FEATHER,(byte)0, "§eBat","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Bat", "craftlobby.pets.bat", i, 200);
				}
			}
			if(e.getSlot() == 20){
				this.openVillagerMenu(p);
			}
			if(e.getSlot() == 21){
				this.openCreeperMenu(p);
			}
			if(e.getSlot() == 22){
				if(p.hasPermission("craftlobby.pets.snowman")){
					SnowmanNormal.activate(p);
				} else {
                    ItemStack i = ItemFactory.create(Material.SNOW_BALL,(byte)0, "§eSnowman","", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Snowman", "craftlobby.pets.snowman", i, 100);
				}
			}
			if(e.getSlot() == 23){
				this.openSkeletonMenu(p);
			}
			if(e.getSlot() == 24){
				this.openMagmaMenu(p);
			}
			if(e.getSlot() == 25){
			    this.openBearMenu(p);
            }
            if(e.getSlot() == 26){
                this.openGuardianMenu(p);
            }
            if(e.getSlot() == 27){
                if(p.hasPermission("craftlobby.pets.vindicator")){
                    VindicatorNormal.activateWitch(p);
                } else {
                    ItemStack i = ItemFactory.create(Material.IRON_AXE, (byte)0, "§eVindicator", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Vindicator", "craftlobby.pets.vindicator", i, 100);
                }
            }
            if(e.getSlot() == 28){
                if(p.hasPermission("craftlobby.pets.evoker")){
                    EvokerNormal.activateWitch(p);
                } else {
                    ItemStack i = ItemFactory.create(Material.TOTEM, (byte)0, "§eEvoker", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Evoker", "craftlobby.pets.evoker", i, 400);
                }
            }
            if(e.getSlot() == 29){
                if(p.hasPermission("craftlobby.pets.vex")){
                    VexNormal.activate(p);
                } else {
                    ItemStack i = ItemFactory.create(Material.IRON_SWORD, (byte)0, "§eVex", "", "§7Odemknuto: §f1/1 §8(100%)","","§aKliknutim spawnes!");
                    Shop.open(p, "Vex", "craftlobby.pets.vex", i, 100);
                }
            }
            if(e.getSlot() == 30){
                this.openLlamaMenu(p);
            }
		}
		if(e.getInventory().getTitle().equals("Pets - CatNormal")){
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
					CatNormal.activate(p, false, Ocelot.Type.BLACK_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Black", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Black", "craftlobby.pets.cat.black", i, 300);
                }
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.cat.black.baby")){
					CatNormal.activate(p, true, Ocelot.Type.BLACK_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Black (Baby)", "", "§7Barva: §8Black","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Black (Baby)", "craftlobby.pets.cat.black.baby", i, 350);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.cat.red")){
					CatNormal.activate(p, false, Ocelot.Type.RED_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Red", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Red", "craftlobby.pets.cat.red", i, 300);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.cat.red.baby")){
					CatNormal.activate(p, true, Ocelot.Type.RED_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Red (Baby)", "", "§7Barva: §8Red","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Red (Baby)", "craftlobby.pets.cat.red.baby", i, 350);
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.cat.siamese")){
					CatNormal.activate(p, false, Ocelot.Type.SIAMESE_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Siamese", "craftlobby.pets.cat.siamese", i, 300);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.cat.siamese.baby")){
					CatNormal.activate(p, true, Ocelot.Type.SIAMESE_CAT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)2, "§aCat: Siamese (Baby)", "", "§7Barva: §8Seda","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Siamese (Baby)", "craftlobby.pets.cat.siamese.baby", i, 350);
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.cat.wild")){
					CatNormal.activate(p, false, Ocelot.Type.WILD_OCELOT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)0, "§aCat: Wild", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Wild", "craftlobby.pets.cat.wild", i, 300);
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.cat.wild.baby")){
					CatNormal.activate(p, true, Ocelot.Type.WILD_OCELOT);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_FISH, (byte)1, "§aCat: Wild (Baby)", "", "§7Barva: §8Zlata","","§eKliknutim spawnes!");
                    Shop.open(p, "CatNormal: Wild (Baby)", "craftlobby.pets.cat.wild.baby", i, 350);
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
                    ItemStack i = ItemFactory.create(Material.COOKED_BEEF,(byte)0,"§aCow", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Cow", "craftlobby.pets.cow", i, 200);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.cow.baby")){
					CowNormal.activateCow(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.RAW_BEEF,(byte)0,"§aCow (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Cow (Baby)", "craftlobby.pets.cow.baby", i, 250);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.cow.mushroom")){
					MushroomNormal.activateCow(p,false);
				} else {
                    ItemStack i = ItemFactory.create(Material.RED_MUSHROOM,(byte)0,"§aCow Mushroom", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Cow Mushroom", "craftlobby.pets.cow.mushroom", i, 300);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.cow.mushroom.baby")){
					MushroomNormal.activateCow(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.BROWN_MUSHROOM,(byte)0,"§aCow Mushroom (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Cow Mushroom (Baby)", "craftlobby.pets.cow.mushroom.baby", i, 350);
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
                    ItemStack i = ItemFactory.create(Material.GRILLED_PORK,(byte)0,"§aPig", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Pig", "craftlobby.pets.pig", i, 200);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.pig.baby")){
					PigNormal.activatePig(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.PORK,(byte)0,"§aPig (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Pig (Baby)", "craftlobby.pets.pig.baby", i, 250);
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
                    ItemStack i = ItemFactory.create(Material.EGG,(byte)0,"§aChicken", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Chicken", "craftlobby.pets.chicken", i, 100);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.chicken.baby")){
					ChickenNormal.activateChicken(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.EGG,(byte)0,"§aChicken (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Chicken (Baby)", "craftlobby.pets.chicken.baby", i, 150);
				}
			}
		}
        if(e.getInventory().getTitle().equals("Pets - Llama")){
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
                this.openMainInv(p);
            }
            if(e.getSlot() == 50){
                PetManager.forceRemovePet(p);
                p.closeInventory();
            }
            if(e.getSlot() == 0){
                if(p.hasPermission("craftlobby.pets.llama.white")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)0, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)0, "§aLlama: White","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: White", "craftlobby.pets.llama.white", i, 100);
                }
            }
            if(e.getSlot() == 1){
                if(p.hasPermission("craftlobby.pets.llama.orange")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)1, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)1, "§aLlama: Orange","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Orange", "craftlobby.pets.llama.orange", i, 100);
                }
            }
            if(e.getSlot() == 2){
                if(p.hasPermission("craftlobby.pets.llama.magenta")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)2, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)2, "§aLlama: Magenta","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Magenta", "craftlobby.pets.llama.magenta", i, 100);
                }
            }
            if(e.getSlot() == 3){
                if(p.hasPermission("craftlobby.pets.llama.lightblue")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)3, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)3, "§aLlama: Light Blue","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Light Blue", "craftlobby.pets.llama.lightblue", i, 100);
                }
            }
            if(e.getSlot() == 4){
                if(p.hasPermission("craftlobby.pets.llama.yellow")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)4, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)4, "§aLlama: Yellow","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Yellow", "craftlobby.pets.llama.yellow", i, 100);
                }
            }
            if(e.getSlot() == 5){
                if(p.hasPermission("craftlobby.pets.llama.lime")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)5, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)5, "§aLlama: Lime","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Lime", "craftlobby.pets.llama.lime", i, 100);
                }
            }
            if(e.getSlot() == 6){
                if(p.hasPermission("craftlobby.pets.llama.pink")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)6, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)6, "§aLlama: Pink","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Pink", "craftlobby.pets.llama.pink", i, 100);
                }
            }
            if(e.getSlot() == 7){
                if(p.hasPermission("craftlobby.pets.llama.gray")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)7, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)7, "§aLlama: Gray","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Gray", "craftlobby.pets.llama.gray", i, 100);
                }
            }
            if(e.getSlot() == 8){
                if(p.hasPermission("craftlobby.pets.llama.lightgray")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)8, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)8, "§aLlama: Light Gray","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Light Gray", "craftlobby.pets.llama.lightgray", i, 100);
                }
            }
            if(e.getSlot() == 9){
                if(p.hasPermission("craftlobby.pets.llama.cyan")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)9, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)9, "§aLlama: Cyan","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Cyan", "craftlobby.pets.llama.cyan", i, 100);
                }
            }
            if(e.getSlot() == 10){
                if(p.hasPermission("craftlobby.pets.llama.purple")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)10, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)10, "§aLlama: Purple","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Purple", "craftlobby.pets.llama.purple", i, 100);
                }
            }
            if(e.getSlot() == 11){
                if(p.hasPermission("craftlobby.pets.llama.blue")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)11, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)11, "§aLlama: Blue","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Blue", "craftlobby.pets.llama.blue", i, 100);
                }
            }
            if(e.getSlot() == 12){
                if(p.hasPermission("craftlobby.pets.llama.brown")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)12, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)12, "§aLlama: Brown","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Brown", "craftlobby.pets.llama.brown", i, 100);
                }
            }
            if(e.getSlot() == 13){
                if(p.hasPermission("craftlobby.pets.llama.green")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)13, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)13, "§aLlama: Green","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Green", "craftlobby.pets.llama.green", i, 100);
                }
            }
            if(e.getSlot() == 14){
                if(p.hasPermission("craftlobby.pets.llama.red")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)14, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)14, "§aLlama: Red","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Red", "craftlobby.pets.llama.red", i, 100);
                }
            }
            if(e.getSlot() == 15){
                if(p.hasPermission("craftlobby.pets.llama.black")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)15, "Super secret");
                    LlamaNormal.activate(p,false, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte)15, "§aLlama: Black","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Black", "craftlobby.pets.llama.black", i, 100);
                }
            }
            if(e.getSlot() == 16){
                if(p.hasPermission("craftlobby.pets.llama.white.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)0, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)0, "§aLlama: White (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: White (Baby)", "craftlobby.pets.llama.white.baby", i, 100);
                }
            }
            if(e.getSlot() == 17){
                if(p.hasPermission("craftlobby.pets.llama.orange.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)1, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)1, "§aLlama: Orange (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Orange (Baby)", "craftlobby.pets.llama.orange.baby", i, 100);
                }
            }
            if(e.getSlot() == 18){
                if(p.hasPermission("craftlobby.pets.llama.magenta.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)2, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)2, "§aLlama: Magenta (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Magenta (Baby)", "craftlobby.pets.llama.magenta.baby", i, 100);
                }
            }
            if(e.getSlot() == 19){
                if(p.hasPermission("craftlobby.pets.llama.lightblue.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)3, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)3, "§aLlama: Light Blue (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Light Blue (Baby)", "craftlobby.pets.llama.lightblue.baby", i, 100);
                }
            }
            if(e.getSlot() == 20){
                if(p.hasPermission("craftlobby.pets.llama.yellow.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)4, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)4, "§aLlama: Yellow (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Yellow (Baby)", "craftlobby.pets.llama.yellow.baby", i, 100);
                }
            }
            if(e.getSlot() == 21){
                if(p.hasPermission("craftlobby.pets.llama.lime.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)5, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)5, "§aLlama: Lime (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Lime (Baby)", "craftlobby.pets.llama.lime.baby", i, 100);
                }
            }
            if(e.getSlot() == 22){
                if(p.hasPermission("craftlobby.pets.llama.pink.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)6, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)6, "§aLlama: Pink (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Pink (Baby)", "craftlobby.pets.llama.pink.baby", i, 100);
                }
            }
            if(e.getSlot() == 23){
                if(p.hasPermission("craftlobby.pets.llama.gray.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)7, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)7, "§aLlama: Gray (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Gray (Baby)", "craftlobby.pets.llama.gray.baby", i, 100);
                }
            }
            if(e.getSlot() == 24){
                if(p.hasPermission("craftlobby.pets.llama.lightgray.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)8, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)8, "§aLlama: Light Gray (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Light Gray (Baby)", "craftlobby.pets.llama.lightgray.baby", i, 100);
                }
            }
            if(e.getSlot() == 25){
                if(p.hasPermission("craftlobby.pets.llama.cyan.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)9, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)9, "§aLlama: Cyan (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Cyan (Baby)", "craftlobby.pets.llama.cyan.baby", i, 100);
                }
            }
            if(e.getSlot() == 26){
                if(p.hasPermission("craftlobby.pets.llama.purple.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)10, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)10, "§aLlama: Purple (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Purple (Baby)", "craftlobby.pets.llama.purple.baby", i, 100);
                }
            }
            if(e.getSlot() == 27){
                if(p.hasPermission("craftlobby.pets.llama.blue.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)11, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)11, "§aLlama: Blue (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Blue (Baby)", "craftlobby.pets.llama.blue.baby", i, 100);
                }
            }
            if(e.getSlot() == 28){
                if(p.hasPermission("craftlobby.pets.llama.brown.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)12, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)12, "§aLlama: Brown (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Brown (Baby)", "craftlobby.pets.llama.brown.baby", i, 100);
                }
            }
            if(e.getSlot() == 29){
                if(p.hasPermission("craftlobby.pets.llama.green.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)13, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)13, "§aLlama: Green (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Green (Baby)", "craftlobby.pets.llama.green.baby", i, 100);
                }
            }
            if(e.getSlot() == 30){
                if(p.hasPermission("craftlobby.pets.llama.red.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)14, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)14, "§aLlama: Red (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Red (Baby)", "craftlobby.pets.llama.red.baby", i, 100);
                }
            }
            if(e.getSlot() == 31){
                if(p.hasPermission("craftlobby.pets.llama.black.baby")){
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)15, "Super secret");
                    LlamaNormal.activate(p,true, Llama.Color.WHITE,i);
                } else {
                    ItemStack i = ItemFactory.create(Material.CARPET, (byte)15, "§aLlama: Black (Baby)","", "§eKliknutim spawnes!");
                    Shop.open(p, "Llama: Black (Baby)", "craftlobby.pets.llama.black.baby", i, 100);
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
                    ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf", "", "§eKliknutim spawnes!");
                    Shop.open(p,"Wolf", "craftlobby.pets.wolf", i, 300);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.wolf.baby")){
					WolfNormal.activate(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.BONE,(byte)0,"§aWolf (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p,"Wolf (Baby)", "craftlobby.pets.wolf.baby", i, 300);
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Rabbit")){
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
				if(p.hasPermission("craftlobby.pets.rabbit.black")){
					RabbitNormal.activate(p,false, Rabbit.Type.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Black", "", "§eKliknutim spawnes!");
					Shop.open(p, "Rabbit Black", "craftlobby.pets.rabbit.black", i, 200);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.rabbit.black.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Black (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Black (Baby)", "craftlobby.pets.rabbit.black.baby", i, 250);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite")){
					RabbitNormal.activate(p,false, Rabbit.Type.BLACK_AND_WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_STEW,(byte)0,"§aRabbit Black & White", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Rabbit Black & White", "craftlobby.pets.rabbit.blackandwhite", i, 200);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.BLACK_AND_WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_STEW,(byte)0,"§aRabbit Black & White (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Black & White (Baby)", "craftlobby.pets.rabbit.blackandwhite.baby", i, 250);
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.rabbit.brown")){
					RabbitNormal.activate(p,false, Rabbit.Type.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.COOKED_RABBIT,(byte)0,"§aRabbit Brown", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Brown", "craftlobby.pets.rabbit.brown", i, 200);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.rabbit.brown.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.COOKED_RABBIT,(byte)0,"§aRabbit Brown (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Brown (Baby)", "craftlobby.pets.rabbit.brown.baby", i, 250);
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper")){
					RabbitNormal.activate(p,false, Rabbit.Type.SALT_AND_PEPPER);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Salt & Pepper", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Rabbit Salt & Pepper", "craftlobby.pets.rabbit.saltandpepper", i, 200);
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.SALT_AND_PEPPER);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Salt & Pepper (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Salt & Pepper (Baby)", "craftlobby.pets.rabbit.saltandpepper.baby", i, 250);
				}
			}
			if(e.getSlot() == 8){
				if(p.hasPermission("craftlobby.pets.rabbit.killer")){
					RabbitNormal.activate(p,false, Rabbit.Type.THE_KILLER_BUNNY);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Killer", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Rabbit Killer", "craftlobby.pets.rabbit.killer", i, 200);
				}
			}
			if(e.getSlot() == 9){
				if(p.hasPermission("craftlobby.pets.rabbit.killer.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.THE_KILLER_BUNNY);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_FOOT,(byte)0,"§aRabbit Killer (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Killer (Baby)", "craftlobby.pets.rabbit.killer.baby", i, 250);
				}
			}
			if(e.getSlot() == 10){
				if(p.hasPermission("craftlobby.pets.rabbit.white")){
					RabbitNormal.activate(p,false, Rabbit.Type.WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_HIDE,(byte)0,"§aRabbit White", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Rabbit White", "craftlobby.pets.rabbit.white", i, 200);
				}
			}
			if(e.getSlot() == 11){
				if(p.hasPermission("craftlobby.pets.rabbit.white.baby")){
					RabbitNormal.activate(p,true, Rabbit.Type.WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.RABBIT_HIDE,(byte)0,"§aRabbit White (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit White (Baby)", "craftlobby.pets.rabbit.white.baby", i, 250);
				}
			}
            if(e.getSlot() == 12){
                if(p.hasPermission("craftlobby.pets.rabbit.gold")){
                    RabbitNormal.activate(p,false, Rabbit.Type.GOLD);
                } else {
                    ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Gold", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Gold", "craftlobby.pets.rabbit.gold", i, 200);
                }
            }
            if(e.getSlot() == 13){
                if(p.hasPermission("craftlobby.pets.rabbit.gold.baby")){
                    RabbitNormal.activate(p,true, Rabbit.Type.GOLD);
                } else {
                    ItemStack i = ItemFactory.create(Material.RABBIT,(byte)0,"§aRabbit Gold (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Rabbit Gold (Baby)", "craftlobby.pets.rabbit.gold.baby", i, 250);
                }
            }
		}
		if(e.getInventory().getTitle().equals("Pets - Zombie")){
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
				if(p.hasPermission("craftlobby.pets.zombie")){
					ZombieNormal.activate(p,false);
				} else {
                    ItemStack i = ItemFactory.create(Material.ROTTEN_FLESH,(byte)0,"§aZombie", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie", "craftlobby.pets.zombie", i, 200);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.zombie.baby")){
					ZombieNormal.activate(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.ROTTEN_FLESH,(byte)0,"§aZombie (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie (Baby)", "craftlobby.pets.zombie.baby", i, 2500);
				}
			}
			if(e.getSlot() == 2){
                if(p.hasPermission("craftlobby.pets.zombie.husk")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.HUSK);
                } else {
                    ItemStack i = ItemFactory.create(Material.SAND,(byte)0,"§aZombie Husk", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Husk", "craftlobby.pets.zombie.husk", i, 300);
                }
            }
            if(e.getSlot() == 3){
                if(p.hasPermission("craftlobby.pets.zombie.husk.baby")){
                    ZombieVillagerNormal.activate(p, true, Villager.Profession.HUSK);
                } else {
                    ItemStack i = ItemFactory.create(Material.SAND,(byte)0,"§aZombie Husk (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Husk (Baby)", "craftlobby.pets.zombie.husk.baby", i, 350);
                }
            }
            if(e.getSlot() == 4){
                if(p.hasPermission("craftlobby.pets.zombie.blacksmith")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.BLACKSMITH);
                } else {
                    ItemStack i = ItemFactory.create(Material.ANVIL,(byte)0,"§aZombie Blacksmith", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Blacksmith", "craftlobby.pets.zombie.blacksmith", i, 200);
                }
            }
            if(e.getSlot() == 5){
                if(p.hasPermission("craftlobby.pets.zombie.butcher")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.BUTCHER);
                } else {
                    ItemStack i = ItemFactory.create(Material.RAW_BEEF,(byte)0,"§aZombie Butcher", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Butcher", "craftlobby.pets.zombie.butcher", i, 200);
                }
            }
            if(e.getSlot() == 6){
                if(p.hasPermission("craftlobby.pets.zombie.farmer")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.FARMER);
                } else {
                    ItemStack i = ItemFactory.create(Material.GOLD_HOE,(byte)0,"§aZombie Farmer", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Farmer", "craftlobby.pets.zombie.farmer", i, 200);
                }
            }
            if(e.getSlot() == 7){
                if(p.hasPermission("craftlobby.pets.zombie.librarian")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.LIBRARIAN);
                } else {
                    ItemStack i = ItemFactory.create(Material.BOOK_AND_QUILL,(byte)0,"§aZombie Librarian", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Librarian", "craftlobby.pets.zombie.librarian", i, 200);
                }
            }
            if(e.getSlot() == 8){
                if(p.hasPermission("craftlobby.pets.zombie.priest")){
                    ZombieVillagerNormal.activate(p, false, Villager.Profession.PRIEST);
                } else {
                    ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aZombie Priest", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Zombie Priest", "craftlobby.pets.zombie.priest", i, 200);
                }
            }
		}
		if(e.getInventory().getTitle().equals("Pets - Horse")){
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
				if(p.hasPermission("craftlobby.pets.horse.black")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Black");
                    Shop.open(p, "Horse Black", "craftlobby.pets.horse.black", i, 100);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.horse.black.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Black (Baby)");
                    Shop.open(p, "Horse Black (Baby)", "craftlobby.pets.horse.black.baby", i, 150);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.horse.brown")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Brown");
                    Shop.open(p, "Horse Brown", "craftlobby.pets.horse.brown", i, 100);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.horse.brown.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Brown (Baby)");
                    Shop.open(p, "Horse Brown (Baby)", "craftlobby.pets.horse.brown.baby", i, 150);
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.horse.chestnut")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.CHESTNUT);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Chestnut");
                    Shop.open(p, "Horse Chestnut", "craftlobby.pets.horse.chestnut", i, 100);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.horse.chestnut.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.CHESTNUT);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Chestnut (Baby)");
                    Shop.open(p, "Horse Chestnut (Baby)", "craftlobby.pets.horse.chestnut.baby", i, 150);
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.horse.creamy")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.CREAMY);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Creamy");
                    Shop.open(p, "Horse Creamy", "craftlobby.pets.horse.creamy", i, 100);
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.horse.creamy.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.CREAMY);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Creamy (Baby)");
                    Shop.open(p, "Horse Creamy (Baby)", "craftlobby.pets.horse.creamy.baby", i, 150);
				}
			}
			if(e.getSlot() == 8){
				if(p.hasPermission("craftlobby.pets.horse.darkbrown")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.DARK_BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Dark Brown");
                    Shop.open(p, "Horse Dark Brown", "craftlobby.pets.horse.darkbrown", i, 100);
				}
			}
			if(e.getSlot() == 9){
				if(p.hasPermission("craftlobby.pets.horse.darkbrown.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.DARK_BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Dark Brown (Baby)");
                    Shop.open(p, "Horse Dark Brown (Baby)", "craftlobby.pets.horse.darkbrown.baby", i, 150);
				}
			}
			if(e.getSlot() == 10){
				if(p.hasPermission("craftlobby.pets.horse.gray")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.GRAY);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Gray");
                    Shop.open(p, "Horse Gray", "craftlobby.pets.horse.gray", i, 100);
				}
			}
			if(e.getSlot() == 11){
				if(p.hasPermission("craftlobby.pets.horse.gray.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.GRAY);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse Gray (Baby)");
                    Shop.open(p, "Horse Gray (Baby)", "craftlobby.pets.horse.gray.baby", i, 150);
				}
			}
			if(e.getSlot() == 12){
				if(p.hasPermission("craftlobby.pets.horse.white")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.WHITE );
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse White");
                    Shop.open(p, "Horse White", "craftlobby.pets.horse.white", i, 100);
				}
			}
			if(e.getSlot() == 13){
				if(p.hasPermission("craftlobby.pets.horse.white.baby")){
					HorseNormal.activate(p,true, Horse.Style.NONE, Horse.Color.WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eHorse White (Baby)");
                    Shop.open(p, "Horse White (Baby)", "craftlobby.pets.horse.white.baby", i, 150);
				}
			}
			//TODO: Nefunkcni Donkey, Mule, Zombie Horse, Skeleton Horse
			if(e.getSlot() == 14){
				if(p.hasPermission("craftlobby.pets.horse.donkey")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eDonkey");
                    Shop.open(p, "Donkey", "craftlobby.pets.horse.donkey", i, 100);
				}
			}
			if(e.getSlot() == 15){
				if(p.hasPermission("craftlobby.pets.horse.mule")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eMule");
                    Shop.open(p, "Mule", "craftlobby.pets.horse.mule", i, 100);
				}
			}
			if(e.getSlot() == 16){
				if(p.hasPermission("craftlobby.pets.horse.zombie")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eZombie Horse");
                    Shop.open(p, "Zombie Horse", "craftlobby.pets.horse.zombie", i, 400);
				}
			}
			if(e.getSlot() == 17){
				if(p.hasPermission("craftlobby.pets.horse.skeleton")){
					HorseNormal.activate(p,false, Horse.Style.NONE, Horse.Color.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.SADDLE,(byte)0, "§eSkeleton Horse");
                    Shop.open(p, "Skeleton Horse", "craftlobby.pets.horse.skeleton", i, 400);
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Sheep")){
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
				this.openMainInv(p);
			}
			if(e.getSlot() == 50){
				PetManager.forceRemovePet(p);
				p.closeInventory();
			}
			if(e.getSlot() == 0){
				if(p.hasPermission("craftlobby.pets.sheep.white")){
					 SheepNormal.activate(p,false, DyeColor.WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep White","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep White", "craftlobby.pets.sheep.white", i, 100);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.sheep.white.baby")){
					SheepNormal.activate(p,true,DyeColor.WHITE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep White (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep White (Baby)", "craftlobby.pets.sheep.white.baby", i, 100);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.sheep.black")){
					SheepNormal.activate(p,false,DyeColor.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)15, "§aSheep Black","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Black", "craftlobby.pets.sheep.black", i, 100);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.sheep.black.baby")){
					SheepNormal.activate(p,true,DyeColor.BLACK);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)15, "§aSheep Black (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Black (Baby)", "craftlobby.pets.sheep.black.baby", i, 100);
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.sheep.blue")){
					SheepNormal.activate(p,false,DyeColor.BLUE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)11, "§aSheep Blue","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Blue", "craftlobby.pets.sheep.blue", i, 100);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.sheep.blue.baby")){
					SheepNormal.activate(p,true,DyeColor.BLUE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)11, "§aSheep Blue (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Blue (Baby)", "craftlobby.pets.sheep.blue.baby", i, 100);
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.sheep.brown")){
					SheepNormal.activate(p,false,DyeColor.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)12, "§aSheep Brown","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Brown", "craftlobby.pets.sheep.brown", i, 100);
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.sheep.brown.baby")){
					SheepNormal.activate(p,true,DyeColor.BROWN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)12, "§aSheep Brown (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Brown (Baby)", "craftlobby.pets.sheep.brown.baby", i, 100);
				}
			}
			if(e.getSlot() == 8){
				if(p.hasPermission("craftlobby.pets.sheep.cyan")){
					SheepNormal.activate(p,false,DyeColor.CYAN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)9, "§aSheep Cyan","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Cyan", "craftlobby.pets.sheep.cyan", i, 100);
				}
			}
			if(e.getSlot() == 9){
				if(p.hasPermission("craftlobby.pets.sheep.cyan.baby")){
					SheepNormal.activate(p,true,DyeColor.CYAN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)9, "§aSheep Cyan (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Cyan (Baby)", "craftlobby.pets.sheep.cyan.baby", i, 100);
				}
			}
			if(e.getSlot() == 10){
				if(p.hasPermission("craftlobby.pets.sheep.green")){
					SheepNormal.activate(p,false,DyeColor.GREEN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)13, "§aSheep Green","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Green", "craftlobby.pets.sheep.green", i, 100);
				}
			}
			if(e.getSlot() == 11){
				if(p.hasPermission("craftlobby.pets.sheep.green.baby")){
					SheepNormal.activate(p,true,DyeColor.GREEN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)13, "§aSheep Green (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Green (Baby)", "craftlobby.pets.sheep.green.baby", i, 100);
				}
			}
			if(e.getSlot() == 12){
				if(p.hasPermission("craftlobby.pets.sheep.lightblue")){
					SheepNormal.activate(p,false,DyeColor.LIGHT_BLUE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)3, "§aSheep Light Blue","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Light Blue", "craftlobby.pets.sheep.lightblue", i, 100);
				}
			}
			if(e.getSlot() == 13){
				if(p.hasPermission("craftlobby.pets.sheep.lightblue.baby")){
					SheepNormal.activate(p,true,DyeColor.LIGHT_BLUE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)3, "§aSheep Light Blue (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Light Blue (Baby)", "craftlobby.pets.sheep.lightblue.baby", i, 100);
				}
			}
			if(e.getSlot() == 14){
				if(p.hasPermission("craftlobby.pets.sheep.lime")){
					SheepNormal.activate(p,false,DyeColor.LIME);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)5, "§aSheep White","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep White", "craftlobby.pets.sheep.white", i, 100);
				}
			}
			if(e.getSlot() == 15){
				if(p.hasPermission("craftlobby.pets.sheep.lime.baby")){
					SheepNormal.activate(p,true,DyeColor.LIME);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)5, "§aSheep White","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep White", "craftlobby.pets.sheep.white", i, 100);
				}
			}
			if(e.getSlot() == 16){
				if(p.hasPermission("craftlobby.pets.sheep.magenta")){
					SheepNormal.activate(p,false,DyeColor.MAGENTA);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)2, "§aSheep Magenta","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Magenta", "craftlobby.pets.sheep.magenta", i, 100);
				}
			}
			if(e.getSlot() == 17){
				if(p.hasPermission("craftlobby.pets.sheep.magenta.baby")){
					SheepNormal.activate(p,true,DyeColor.MAGENTA);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)2, "§aSheep Magenta (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Magenta (Baby)", "craftlobby.pets.sheep.magenta.baby", i, 100);
				}
			}
			if(e.getSlot() == 18){
				if(p.hasPermission("craftlobby.pets.sheep.orange")){
					SheepNormal.activate(p,false,DyeColor.ORANGE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)1, "§aSheep Orange","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Orange", "craftlobby.pets.sheep.orange", i, 100);
				}
			}
			if(e.getSlot() == 19){
				if(p.hasPermission("craftlobby.pets.sheep.orange.baby")){
					SheepNormal.activate(p,true,DyeColor.ORANGE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)1, "§aSheep Orange (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Orange (Baby)", "craftlobby.pets.sheep.orange.baby", i, 100);
				}
			}
			if(e.getSlot() == 20){
				if(p.hasPermission("craftlobby.pets.sheep.pink")){
					SheepNormal.activate(p,false,DyeColor.PINK);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep Pink","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Pink", "craftlobby.pets.sheep.pink", i, 100);
				}
			}
			if(e.getSlot() == 21){
				if(p.hasPermission("craftlobby.pets.sheep.pink.baby")){
					SheepNormal.activate(p,true,DyeColor.PINK);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)0, "§aSheep Pink (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Pink (Baby)", "craftlobby.pets.sheep.pink.baby", i, 100);
				}
			}
			if(e.getSlot() == 22){
				if(p.hasPermission("craftlobby.pets.sheep.purple")){
					SheepNormal.activate(p,false,DyeColor.PURPLE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)6, "§aSheep Purple","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Purple", "craftlobby.pets.sheep.purple", i, 100);
				}
			}
			if(e.getSlot() == 23){
				if(p.hasPermission("craftlobby.pets.sheep.purple.baby")){
					SheepNormal.activate(p,true,DyeColor.PURPLE);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)6, "§aSheep Purple (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Purple (Baby)", "craftlobby.pets.sheep.purple.baby", i, 100);
				}
			}
			if(e.getSlot() == 24){
				if(p.hasPermission("craftlobby.pets.sheep.red")){
					SheepNormal.activate(p,false,DyeColor.RED);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)14, "§aSheep Red","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Red", "craftlobby.pets.sheep.red", i, 100);
				}
			}
			if(e.getSlot() == 25){
				if(p.hasPermission("craftlobby.pets.sheep.red.baby")){
					SheepNormal.activate(p,true,DyeColor.RED);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)14, "§aSheep Red (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Red (Baby)", "craftlobby.pets.sheep.red.baby", i, 100);
				}
			}
			if(e.getSlot() == 26){
				if(p.hasPermission("craftlobby.pets.sheep.silver")){
					SheepNormal.activate(p,false,DyeColor.SILVER);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)8, "§aSheep Silver","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Silver", "craftlobby.pets.sheep.silver", i, 100);
				}
			}
			if(e.getSlot() == 27){
				if(p.hasPermission("craftlobby.pets.sheep.silver.baby")){
					SheepNormal.activate(p,true,DyeColor.SILVER);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)8, "§aSheep Silver (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Silver (Baby)", "craftlobby.pets.sheep.silver.baby", i, 100);
				}
			}
			if(e.getSlot() == 28){
				if(p.hasPermission("craftlobby.pets.sheep.yellow")){
					SheepNormal.activate(p,false,DyeColor.YELLOW);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)4, "§aSheep Yellow","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Yellow", "craftlobby.pets.sheep.yellow", i, 100);
				}
			}
			if(e.getSlot() == 29){
				if(p.hasPermission("craftlobby.pets.sheep.yellow.baby")){
					SheepNormal.activate(p,true,DyeColor.YELLOW);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)4, "§aSheep Yellow (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Yellow (Baby)", "craftlobby.pets.sheep.yellow.baby", i, 100);
				}
			}
			if(e.getSlot() == 30){
				if(p.hasPermission("craftlobby.pets.sheep.gray")){
					SheepNormal.activate(p,false,DyeColor.GRAY);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)7, "§aSheep Gray","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Gray", "craftlobby.pets.sheep.gray", i, 100);
				}
			}
			if(e.getSlot() == 31){
				if(p.hasPermission("craftlobby.pets.sheep.gray.baby")){
					SheepNormal.activate(p,true,DyeColor.GRAY);
				} else {
                    ItemStack i = ItemFactory.create(Material.WOOL,(byte)7, "§aSheep Gray (Baby)","","§eKliknutim spawnes!");
                    Shop.open(p, "Sheep Gray (Baby)", "craftlobby.pets.sheep.gray.baby", i, 100);
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Slime")){
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
				if(p.hasPermission("craftlobby.pets.slime.small")){
					SlimeNormal.activateSlime(p,1);
				} else {
                    ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Small", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Slime: Small", "craftlobby.pets.slime.small", i, 100);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.slime.normal")){
					SlimeNormal.activateSlime(p,2);
				} else {
                    ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Normal", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Slime: Normal", "craftlobby.pets.slime.normal", i, 150);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.slime.big")){
					SlimeNormal.activateSlime(p,3);
				} else {
                    ItemStack i = ItemFactory.create(Material.SLIME_BALL,(byte)0,"§aSlime: Big", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Slime: Big", "craftlobby.pets.slime.big", i, 200);
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Villager")){
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
				if(p.hasPermission("craftlobby.pets.villager.blacksmith")){
					VilagerNormal.activateWitch(p, false, Villager.Profession.BLACKSMITH);
				} else {
                    ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aVillager: Blacksmith", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Blacksmith", "craftlobby.pets.villager.blacksmith", i, 100);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.villager.blacksmith.baby")){
					VilagerNormal.activateWitch(p, true, Villager.Profession.BLACKSMITH);
				} else {
                    ItemStack i = ItemFactory.create(Material.IRON_INGOT,(byte)0,"§aVillager: Blacksmith (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Blacksmith (Baby)", "craftlobby.pets.villager.blacksmith.baby", i, 200);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.villager.butcher")){
					VilagerNormal.activateWitch(p, false, Villager.Profession.BUTCHER);
				} else {
                    ItemStack i = ItemFactory.create(Material.MUTTON,(byte)0,"§aVillager: Butcher", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Butcher", "craftlobby.pets.villager.butcher", i, 100);
				}
			}
			if(e.getSlot() == 3){
				if(p.hasPermission("craftlobby.pets.villager.butcher.baby")){
					VilagerNormal.activateWitch(p, true, Villager.Profession.BUTCHER);
				} else {
                    ItemStack i = ItemFactory.create(Material.MUTTON,(byte)0,"§aVillager: Butcher (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Butcher (Baby)", "craftlobby.pets.villager.butcher.baby", i, 200);
				}
			}
			if(e.getSlot() == 4){
				if(p.hasPermission("craftlobby.pets.villager.farmer")){
					VilagerNormal.activateWitch(p, false, Villager.Profession.FARMER);
				} else {
                    ItemStack i = ItemFactory.create(Material.SEEDS,(byte)0,"§aVillager: Farmer", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Farmer", "craftlobby.pets.villager.farmer", i, 100);
				}
			}
			if(e.getSlot() == 5){
				if(p.hasPermission("craftlobby.pets.villager.farmer.baby")){
					VilagerNormal.activateWitch(p, true, Villager.Profession.FARMER);
				} else {
                    ItemStack i = ItemFactory.create(Material.SEEDS,(byte)0,"§aVillager: Farmer (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Farmer (Baby)", "craftlobby.pets.villager.farmer.baby", i, 200);
				}
			}
			if(e.getSlot() == 6){
				if(p.hasPermission("craftlobby.pets.villager.librarian")){
					VilagerNormal.activateWitch(p, false, Villager.Profession.LIBRARIAN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WRITTEN_BOOK,(byte)0,"§aVillager: Librarian", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Librarian", "craftlobby.pets.villager.librarian", i, 100);
				}
			}
			if(e.getSlot() == 7){
				if(p.hasPermission("craftlobby.pets.villager.librarian.baby")){
					VilagerNormal.activateWitch(p, true, Villager.Profession.LIBRARIAN);
				} else {
                    ItemStack i = ItemFactory.create(Material.WRITTEN_BOOK,(byte)0,"§aVillager: Librarian (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Librarian (Baby)", "craftlobby.pets.villager.librarian.baby", i, 200);
				}
			}
			if(e.getSlot() == 8){
				if(p.hasPermission("craftlobby.pets.villager.priest")){
					VilagerNormal.activateWitch(p, false, Villager.Profession.PRIEST);
				} else {
                    ItemStack i = ItemFactory.create(Material.GHAST_TEAR,(byte)0,"§aVillager: Priest", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Priest", "craftlobby.pets.villager.priest", i, 100);
				}
			}
			if(e.getSlot() == 9) {
				if (p.hasPermission("craftlobby.pets.villager.priest.baby")) {
					VilagerNormal.activateWitch(p, true, Villager.Profession.PRIEST);
				} else {
                    ItemStack i = ItemFactory.create(Material.GHAST_TEAR,(byte)0,"§aVillager: Priest (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Villager: Priest (Baby)", "craftlobby.pets.villager.priest.baby", i, 100);
				}
			}
		}
        if(e.getInventory().getTitle().equals("Pets - Guardian")){
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
                if(p.hasPermission("craftlobby.pets.guardian")){
                    GuardianNormal.activateGuardian(p);
                } else {
                    ItemStack i = ItemFactory.create(Material.PRISMARINE_CRYSTALS,(byte)0,"§aGuardian", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Guardian", "craftlobby.pets.guardian", i, 500);
                }
            }
            if(e.getSlot() == 1){
                if(p.hasPermission("craftlobby.pets.guardian.elder")){
                    ElderGuardianNormal.activateGuardian(p);
                } else {
                    ItemStack i = ItemFactory.create(Material.PRISMARINE_SHARD,(byte)0,"§aGuardian (Elder)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Guardian (Elder)", "craftlobby.pets.guardian.elder", i, 1000);
                }
            }
        }
		if(e.getInventory().getTitle().equals("Pets - Creeper")){
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
				if(p.hasPermission("craftlobby.pets.creeper")){
					CreeperNormal.activateWitch(p,false);
				} else {
                    ItemStack i = ItemFactory.create(Material.getMaterial(289),(byte)0,"§aCreeper", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Creeper", "craftlobby.pets.creeper", i, 400);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.creeper.powered")){
					CreeperNormal.activateWitch(p,true);
				} else {
                    ItemStack i = ItemFactory.create(Material.getMaterial(289),(byte)0,"§aCreeper (Powered)", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Creeper (Powered)", "craftlobby.pets.creeper.powered", i, 500);
				}
			}
		}
		if(e.getInventory().getTitle().equals("Pets - Skeleton")){
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
				if(p.hasPermission("craftlobby.pets.skeleton")){
					SkeletonNormal.activateWitch(p, Skeleton.SkeletonType.NORMAL);
				} else {
                    ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)0,"§aSkeleton", "", "§eKliknutim spawnes!");
				    Shop.open(p, "Skeleton", "craftlobby.pets.skeleton", i, 300);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.skeleton.wither")){
					SkeletonNormal.activateWitch(p, Skeleton.SkeletonType.WITHER);
				} else {
                    ItemStack i = ItemFactory.create(Material.SKULL_ITEM,(byte)1,"§aWither Skeleton", "", "§eKliknutim spawnes!");
                    Shop.open(p, "Wither Skeleton", "craftlobby.pets.skeleton.wither", i, 600);
				}
			}
		}
        if(e.getInventory().getTitle().equals("Pets - PolarBear")){
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
                if(p.hasPermission("craftlobby.pets.polarbear")){
                    BearNormal.activateGolem(p,false);
                } else {
                    ItemStack i = ItemFactory.create(Material.SNOW_BLOCK,(byte)0,"§aPolarBear", "", "§eKliknutim spawnes!");
                    Shop.open(p, "PolarBear", "craftlobby.pets.polarbear", i, 400);
                }
            }
            if(e.getSlot() == 1){
                if(p.hasPermission("craftlobby.pets.polarbear.baby")){
                    BearNormal.activateGolem(p,true);
                } else {
                    ItemStack i = ItemFactory.create(Material.SNOW_BLOCK,(byte)0,"§aPolarBear (Baby)", "", "§eKliknutim spawnes!");
                    Shop.open(p, "PolarBear (Baby)", "craftlobby.pets.polarbear.baby", i, 500);
                }
            }

        }
		if(e.getInventory().getTitle().equals("Pets - MagmaCube")){
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
				if(p.hasPermission("craftlobby.pets.magmacube.small")){
					MagmaCubeNormal.activateSlime(p,1);
				} else {
                    ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Small", "", "§eKliknutim spawnes!");
                    Shop.open(p, "MagmaCube: Small", "craftlobby.pets.magmacube.small", i, 150);
				}
			}
			if(e.getSlot() == 1){
				if(p.hasPermission("craftlobby.pets.magmacube.normal")){
					MagmaCubeNormal.activateSlime(p,2);
				} else {
                    ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Small", "", "§eKliknutim spawnes!");
                    Shop.open(p, "MagmaCube: Normal", "craftlobby.pets.magmacube.normal", i, 150);
				}
			}
			if(e.getSlot() == 2){
				if(p.hasPermission("craftlobby.pets.magmacube.big")){
					MagmaCubeNormal.activateSlime(p,3);
				} else {
                    ItemStack i = ItemFactory.create(Material.MAGMA_CREAM,(byte)0,"§aMagmaCube: Small", "", "§eKliknutim spawnes!");
                    Shop.open(p, "MagmaCube: Big", "craftlobby.pets.magmacube.big", i, 150);
				}
			}
		}
	}

    private String getCountCats(Player p){
        int i = this.countCatsPermissions(p);
        int sum = 8;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountCows(Player p){
        int i = this.countCowPermissions(p);
        int sum = 4;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountPigs(Player p){
        int i = this.countPigPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountChickens(Player p){
        int i = this.countChickenPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountWolf(Player p){
        int i = this.countWolfPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountRabbit(Player p){
        int i = this.countRabbitPermissions(p);
        int sum = 14;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountZombie(Player p){
        int i = this.countZonbiePermissions(p);
        int sum = 9;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountHorse(Player p){
        int i = this.countHorsePermissions(p);
        int sum = 18;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountSheep(Player p){
        int i = this.countSheepPermissions(p);
        int sum = 32;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountSlime(Player p){
        int i = this.countSlimePermissions(p);
        int sum = 3;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountVillager(Player p){
        int i = this.countVillagerPermissions(p);
        int sum = 10;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountCreeper(Player p){
        int i = this.countCreeperPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountSkeleton(Player p){
        int i = this.countSkeletonPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountMagaCube(Player p){
        int i = this.countMagmaCubePermissions(p);
        int sum = 3;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountPolarBear(Player p){
        int i = this.countPolarBearPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountGuardian(Player p){
        int i = this.countGuardianPermissions(p);
        int sum = 2;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }

    private String getCountLlama(Player p){
        int i = this.countLlamaPermissions(p);
        int sum = 32;
        int prc = (i * 100 / sum);

        return "§7Odemknuto: §f" + i + "/" + sum + " §8(" + prc + "%)";
    }


    private int countCowPermissions(Player p){
        int c = 0;
        if (p.hasPermission("craftlobby.pets.cow")){
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.baby")){
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.mushroom")){
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.mushroom.baby")){
            c++;
        }
        return c;
    }

    private int countLlamaPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.llama.white")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.orange")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.magenta")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lightblue")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.yellow")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lime")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.pink")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.gray")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lightgray")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.cyan")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.purple")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.blue")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.brown")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.green")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.red")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.black")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.white.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.orange.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.magenta.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lightblue.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.yellow.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lime.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.pink.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.gray.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.lightgray.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.cyan.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.purple.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.blue.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.brown.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.green.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.red.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.llama.black.baby")){
            c++;
        }
        return c;
    }

    private int countGuardianPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.guardian")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.guardian.elder")){
            c++;
        }
        return c;
    }

	private int countCatsPermissions(Player p){
        int c = 0;
        if (p.hasPermission("craftlobby.pets.cat.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.red")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.siamese")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.red.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.siamese.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.wild")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.wild.baby")) {
            c++;
        }
        return c;
    }

    private int countPigPermissions(Player p){
        int c = 0;
        if (p.hasPermission("craftlobby.pets.pig")){
            c++;
        }
        if (p.hasPermission("craftlobby.pets.pig.baby")){
            c++;
        }
        return c;
    }

    private int countChickenPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.chicken")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.chicken.baby")){
            c++;
        }
        return c;
    }

    private int countWolfPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.wolf")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.wolf.baby")){
            c++;
        }
        return c;
    }

    private int countSlimePermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.slime.small")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.slime.normal")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.slime.big")){
            c++;
        }
        return c;
    }

    private int countVillagerPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.villager.blacksmith")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.blacksmith.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.butcher")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.butcher.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.farmer")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.farmer.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.librarian")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.librarian.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.priest")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.villager.priest.baby")){
            c++;
        }
        return c;

    }

    private int countRabbitPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.rabbit.black")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.black.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.blackandwhite.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.brown")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.brown.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.saltandpepper.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.killer")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.killer.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.white")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.white.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.gold")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.rabbit.gold")){
            c++;
        }
        return c;
    }

    private int countZonbiePermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.zombie")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.husk")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.husk.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.blacksmith")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.butcher")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.farmer")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.librarian")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.zombie.priest")){
            c++;
        }
        return c;
    }

    private int countSheepPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.sheep.white")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.white.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.black")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.black.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.blue")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.blue.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.brown")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.brown.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.cyan")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.cyan.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.green")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.green.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.lightblue")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.lightblue.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.lime")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.lime.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.magenta")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.magenta.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.orange")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.orange.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.pink")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.pink.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.purple")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.purple.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.red")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.red.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.silver")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.silver.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.yellow")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.yellow.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.gray")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.sheep.gray.baby")){
            c++;
        }
        return c;
    }

    private int countHorsePermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.horse.black")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.black.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.brown")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.brown.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.chestnut")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.chestnut.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.creamy")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.creamy.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.darkbrown")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.darkbrown.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.gray")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.gray.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.white")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.white.baby")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.donkey")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.mule")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.zombie")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.horse.skeleton")){
            c++;
        }
        return c;
    }

    private int countCreeperPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.creeper")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.creeper.powered")){
            c++;
        }
        return c;

    }

    private int countSkeletonPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.skeleton")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.skeleton.wither")){
            c++;
        }
        return c;
    }

    private int countMagmaCubePermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.magmacube.small")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.magmacube.normal")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.magmacube.big")){
            c++;
        }
        return c;
    }

    private int countPolarBearPermissions(Player p){
        int c = 0;
        if(p.hasPermission("craftlobby.pets.polarbear")){
            c++;
        }
        if(p.hasPermission("craftlobby.pets.polarbear.baby")){
            c++;
        }
        return c;
    }

    private ItemStack nakup(final String name, final int price){
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§l" + name, "§7Lze zakoupit za §e" + price + " CC.");
        return i;
    }

}
