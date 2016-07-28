package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GadgetsAPI implements Listener {

    private MessagesListener ml = new MessagesListener();


    public void openInventory(Player p) {

        Inventory gadgetsInv = Bukkit.createInventory(null, 54, "Gadgets");

        if (p.hasPermission("craftlobby.gadgets.teleportstick")) {
            ItemStack i = ItemFactory.create(Material.STICK, (byte) 0, "§e§lTeleportStick", "§7Teleportuj se jako Enderman!");
            gadgetsInv.setItem(0, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTeleportStick", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(0, i);
        }
        if (p.hasPermission("craftlobby.gadgets.funcannon")) {
            ItemStack i = ItemFactory.create(Material.GOLD_HOE, (byte) 0, "§e§lFunCannon", "§7Kliknutim vystrelis hromadu efektu!");
            gadgetsInv.setItem(1, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lFunCannon", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(1, i);
        }
        if (p.hasPermission("craftlobby.gadgets.colorbomb")) {
            ItemStack i = ItemFactory.create(Material.WOOL, (byte) 0, "§e§lColorBomb", "§7Vsude jenom vlna...");
            gadgetsInv.setItem(2, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lColorBomb", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(2, i);
        }
        if (p.hasPermission("craftlobby.gadgets.cookiefountain")) {
            ItemStack i = ItemFactory.create(Material.COOKIE, (byte) 0, "§e§lCookieFountain", "§7Susenky vsude!");
            gadgetsInv.setItem(3, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lCookieFountain", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(3, i);
        }
        if (p.hasPermission("craftlobby.gadgets.chikenator")) {
            ItemStack i = ItemFactory.create(Material.COOKED_CHICKEN, (byte) 0, "§e§lChickenator", "§7Bouchajici kure!");
            gadgetsInv.setItem(4, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lChickenator", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(4, i);
        }
        if (p.hasPermission("craftlobby.gadgets.pee")) {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 11, "§e§lPee", "§7Pocurej nam lobby,", "§7ale ne zase moc :P");
            gadgetsInv.setItem(5, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPee", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(5, i);
        }
        if (p.hasPermission("craftlobby.gadgets.pigfly")) {
            ItemStack i = ItemFactory.create(Material.SADDLE, (byte) 0, "§e§lPigFly", "§7Litajici prase... :O");
            gadgetsInv.setItem(6, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPigFly", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(6, i);
        }
        if (p.hasPermission("craftlobby.gadgets.firework")) {
            ItemStack i = ItemFactory.create(Material.FIREWORK, (byte) 0, "§e§lFirework", "§7Ohnostroj jako na Silvestra!");
            gadgetsInv.setItem(7, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lFirework", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(7, i);
        }
        if (p.hasPermission("craftlobby.gadgets.poopbomb")) {
            ItemStack i = ItemFactory.create(Material.MELON_SEEDS, (byte) 0, "§e§lPoopBomb", "§7Bobiky vsude :O");
            gadgetsInv.setItem(8, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPoopBomb", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(8, i);
        }
        if (p.hasPermission("craftlobby.gadgets.tnt")) {
            ItemStack i = ItemFactory.create(Material.TNT, (byte) 0, "§e§lTNT", "§7Staci vyhodit a uvidis", "§7bordel. Majgat");
            gadgetsInv.setItem(9, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTNT", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(9, i);
        }
        if (p.hasPermission("craftlobby.gadgets.slimehat")) {
            ItemStack i = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§e§lSlimeHat", "§73x Slime na hlave? OK!");
            gadgetsInv.setItem(10, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lSlimeHat", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(10, i);
        }
        if (p.hasPermission("craftlobby.gadgets.withercatapult")) {
            ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§e§lWitherCatapult", "§7To bude rev :D");
            gadgetsInv.setItem(11, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lWitherCatapult", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(11, i);
        }
        if (p.hasPermission("craftlobby.gadgets.discoball")) {
            ItemStack i = ItemFactory.create(Material.STAINED_GLASS, (byte) 11, "§e§lDiscoBall", "§7A jedeme! :D");
            gadgetsInv.setItem(12, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lDiscoBall", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(12, i);
        }
        if (p.hasPermission("craftlobby.gadgets.blizzardblaster")) {
            ItemStack i = ItemFactory.create(Material.PACKED_ICE, (byte) 0, "§e§lBlizzardBlaster", "§7Epicky led vsude kolem tebe!");
            gadgetsInv.setItem(13, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lBlizzardBlaster", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(13, i);
        }
        if (p.hasPermission("craftlobby.gadgets.ghosts")) {
            ItemStack i = ItemFactory.create(Material.FEATHER, (byte) 0, "§e§lGhosts", "§7Duchove jsou vsude, tak bacha na ne!");
            gadgetsInv.setItem(14, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lGhosts", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(14, i);
        }
        if (p.hasPermission("craftlobby.gadgets.tsunami")) {
            ItemStack i = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§e§lTsunami", "§7Odsun vsechny jako tsunami.");
            gadgetsInv.setItem(15, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTsunami", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(15, i);
        }
        if (p.hasPermission("craftlobby.gadgets.batblaster")) {
            ItemStack i = ItemFactory.create(Material.IRON_BARDING, (byte) 0, "§e§lBatBlaster", "§7Netopyri vsude okolo tebe!", "§7Posli je na nekoho!");
            gadgetsInv.setItem(16, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lBatBlaster", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(16, i);
        }
        if (p.hasPermission("craftlobby.gadgets.trampoline")) {
            ItemStack i = ItemFactory.create(Material.HOPPER, (byte) 0, "§e§lTrampoline", "§7Trampolina, zaskakej si!");
            gadgetsInv.setItem(17, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTrampoline", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(17, i);
        }
        if (p.hasPermission("craftlobby.gadgets.explosivesheep")) {
            ItemStack i = ItemFactory.create(Material.SHEARS, (byte) 0, "§e§lExplosiveSheep", "§7Vybuchujici ovecka, utec.");
            gadgetsInv.setItem(18, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lExplosiveSheep", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(18, i);
        }
        if (p.hasPermission("craftlobby.gadgets.smashdown")) {
            ItemStack i = ItemFactory.create(Material.FIREWORK_CHARGE, (byte) 0, "§e§lSmashDown", "§7Odstrel vsechny z tveho okoli.");
            gadgetsInv.setItem(19, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lSmashDown", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(19, i);
        }
        if (p.hasPermission("craftlobby.gadgets.flowerpopper")) {
            ItemStack i = ItemFactory.create(Material.RED_ROSE, (byte) 0, "§e§lFlowerPopper", "§7Ten pocit, kdyz ti z hlavy", "§7strili kytky.");
            gadgetsInv.setItem(20, i);
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lFlowerPopper", "§7Gadget lze ziskat v CraftBoxu!");
            gadgetsInv.setItem(20, i);
        }

        /** Nepouzivane gadgety

         ItemStack mobgun = new ItemStack(Material.BLAZE_ROD);
         ItemMeta mobgunMeta = mobgun.getItemMeta();
         mobgunMeta.setDisplayName(ChatColor.GREEN + "MobGun");
         ArrayList<String> mbLore = new ArrayList<String>();
         mbLore.add(ChatColor.GRAY + "Pravym kliknutim vystrelis");
         mbLore.add(ChatColor.GRAY + "vybraneho moba. Levym kliknutim");
         mbLore.add(ChatColor.GRAY + "zmenis moba.");
         mobgunMeta.setLore(mbLore);
         mobgun.setItemMeta(mobgunMeta);

         ItemStack gravity = new ItemStack(Material.EYE_OF_ENDER);
         ItemMeta gMeta = gravity.getItemMeta();
         gMeta.setDisplayName(ChatColor.GREEN + "AntiGravity");
         ArrayList<String> gLore = new ArrayList<String>();
         gLore.add(ChatColor.GRAY + "Zrus gravitaci okolo sebe...");
         gMeta.setLore(gLore);
         gravity.setItemMeta(gMeta);

         ItemStack blackhole = new ItemStack(Material.STAINED_CLAY,1,(byte)15);
         ItemMeta bhMeta = blackhole.getItemMeta();
         bhMeta.setDisplayName(ChatColor.RED + "BlackHole");
         ArrayList<String> bhLore = new ArrayList<String>();
         bhLore.add(ChatColor.GRAY + "Cerna dira je velka a tajna!");
         bhLore.add(ChatColor.GRAY + "Kliknutim objevis co je v ni.");
         bhMeta.setLore(bhLore);
         blackhole.setItemMeta(bhMeta);
         */

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet do menu");

        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§c✖ Deaktivace ✖", "§7Kliknutim deaktivujes gadget.");

        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte) 0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

        gadgetsInv.setItem(49, shopItem);
        gadgetsInv.setItem(40, deaktivace);
        gadgetsInv.setItem(39, zpet);

        p.openInventory(gadgetsInv);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Gadgets")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.getInventory().setItem(6, null);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 49) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 0) {
                if (p.hasPermission("craftlobby.gadgets.teleportstick")) {
                    this.ml.prepareGadget(p, "TeleportStick", Material.STICK, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "TeleportStick");
                }
            }
            if (e.getSlot() == 1) {
                if (p.hasPermission("craftlobby.gadgets.funcannon")) {
                    this.ml.prepareGadget(p, "FunCannon", Material.GOLD_HOE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "FunCannon");
                }
            }
            if (e.getSlot() == 2) {
                if (p.hasPermission("craftlobby.gadgets.colorbomb")) {
                    this.ml.prepareGadget(p, "ColorBomb", Material.WOOL, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "ColorBomb");
                }
            }
            if (e.getSlot() == 3) {
                if (p.hasPermission("craftlobby.gadgets.cookiefountain")) {
                    this.ml.prepareGadget(p, "CookieFountain", Material.COOKIE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "CookieFountain");
                }
            }
            if (e.getSlot() == 4) {
                if (p.hasPermission("craftlobby.gadgets.chikenator")) {
                    this.ml.prepareGadget(p, "Chickenator", Material.COOKED_CHICKEN, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "Chickenator");
                }
            }
            if (e.getSlot() == 5) {
                if (p.hasPermission("craftlobby.gadgets.pee")) {
                    this.ml.prepareGadget(p, "Pee", Material.INK_SACK, (byte) 11);
                } else {
                    this.ml.messageNoPerm(p, "Pee");
                }
            }
            if (e.getSlot() == 6) {
                if (p.hasPermission("craftlobby.gadgets.pigfly")) {
                    this.ml.prepareGadget(p, "PigFly", Material.SADDLE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "PigFly");
                }
            }
            if (e.getSlot() == 7) {
                if (p.hasPermission("craftlobby.gadgets.firework")) {
                    this.ml.prepareGadget(p, "Firework", Material.FIREWORK, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "Firework");
                }
            }
            if (e.getSlot() == 8) {
                if (p.hasPermission("craftlobby.gadgets.poopbomb")) {
                    this.ml.prepareGadget(p, "PoopBomb", Material.MELON_SEEDS, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "PoopBomb");
                }
            }
            if (e.getSlot() == 9) {
                if (p.hasPermission("craftlobby.gadgets.tnt")) {
                    this.ml.prepareGadget(p, "TNT", Material.TNT, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "TNT");
                }
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.gadgets.slimehat")) {
                    this.ml.prepareGadget(p, "SlimeHat", Material.SLIME_BALL, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "SlimeHat");
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("craftlobby.gadgets.withercatapult")) {
                    this.ml.prepareGadget(p, "WitherCatapult", Material.COAL, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "WitherCatapult");
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("craftlobby.gadgets.discoball")) {
                    this.ml.prepareGadget(p, "DiscoBall", Material.STAINED_GLASS, (byte) 11);
                } else {
                    this.ml.messageNoPerm(p, "DiscoBall");
                }
            }
            if (e.getSlot() == 13) {
                if (p.hasPermission("craftlobby.gadgets.blizzardblaster")) {
                    this.ml.prepareGadget(p, "BlizzardBlaster", Material.PACKED_ICE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "BlizzardBlaster");
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("craftlobby.gadgets.ghosts")) {
                    this.ml.prepareGadget(p, "Ghosts", Material.FEATHER, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "Ghosts");
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("craftlobby.gadgets.tsunami")) {
                    this.ml.prepareGadget(p, "Tsunami", Material.WATER_BUCKET, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "Tsunami");
                }
            }
            if (e.getSlot() == 16) {
                if (p.hasPermission("craftlobby.gadgets.batblaster")) {
                    this.ml.prepareGadget(p, "BatBlaster", Material.IRON_BARDING, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "BatBlaster");
                }
            }
            if (e.getSlot() == 17) {
                if (p.hasPermission("craftlobby.gadgets.trampoline")) {
                    this.ml.prepareGadget(p, "Trampoline", Material.HOPPER, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "Trampoline");
                }
            }
            if (e.getSlot() == 18) {
                if (p.hasPermission("craftlobby.gadgets.explosivesheep")) {
                    this.ml.prepareGadget(p, "ExplosiveSheep", Material.SHEARS, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "ExplosiveSheep");
                }
            }
            if (e.getSlot() == 19) {
                if (p.hasPermission("craftlobby.gadgets.smashdown")) {
                    this.ml.prepareGadget(p, "SmashDown", Material.FIREWORK_CHARGE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "SmashDown");
                }
            }
            if (e.getSlot() == 20) {
                if (p.hasPermission("craftlobby.gadgets.flowerpopper")) {
                    this.ml.prepareGadget(p, "FlowerPopper", Material.RED_ROSE, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "FlowerPopper");
                }
            }


        }
    }


}
