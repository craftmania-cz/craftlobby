package cz.wake.lobby.gadgets.gadget;

import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.utils.ItemFactory;
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
            gadgetsInv.setItem(0, nakup("TeleportStick", 750));
        }
        if (p.hasPermission("craftlobby.gadgets.funcannon")) {
            ItemStack i = ItemFactory.create(Material.GOLD_HOE, (byte) 0, "§e§lFunCannon", "§7Kliknutim vystrelis hromadu efektu!");
            gadgetsInv.setItem(1, i);
        } else {
            gadgetsInv.setItem(1, nakup("FunCannon", 500));
        }
        if (p.hasPermission("craftlobby.gadgets.colorbomb")) {
            ItemStack i = ItemFactory.create(Material.WOOL, (byte) 0, "§e§lColorBomb", "§7Vsude jenom vlna...");
            gadgetsInv.setItem(2, i);
        } else {
            gadgetsInv.setItem(2, nakup("ColorBomb", 750));
        }
        if (p.hasPermission("craftlobby.gadgets.cookiefountain")) {
            ItemStack i = ItemFactory.create(Material.COOKIE, (byte) 0, "§e§lCookieFountain", "§7Susenky vsude!");
            gadgetsInv.setItem(3, i);
        } else {
            gadgetsInv.setItem(3, nakup("CookieFountain", 400));
        }
        if (p.hasPermission("craftlobby.gadgets.chikenator")) {
            ItemStack i = ItemFactory.create(Material.COOKED_CHICKEN, (byte) 0, "§e§lChickenator", "§7Bouchajici kure!");
            gadgetsInv.setItem(4, i);
        } else {
            gadgetsInv.setItem(4, nakup("Chickenator", 800));
        }
        if (p.hasPermission("craftlobby.gadgets.pee")) {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 11, "§e§lPee", "§7Pocurej nam lobby,", "§7ale ne zase moc :P");
            gadgetsInv.setItem(5, i);
        } else {
            gadgetsInv.setItem(5, nakup("Pee", 1300));
        }
        if (p.hasPermission("craftlobby.gadgets.pigfly")) {
            ItemStack i = ItemFactory.create(Material.SADDLE, (byte) 0, "§e§lPigFly", "§7Litajici prase... :O");
            gadgetsInv.setItem(6, i);
        } else {
            gadgetsInv.setItem(6, nakup("PigFly", 900));
        }
        if (p.hasPermission("craftlobby.gadgets.firework")) {
            ItemStack i = ItemFactory.create(Material.FIREWORK, (byte) 0, "§e§lFirework", "§7Ohnostroj jako na Silvestra!");
            gadgetsInv.setItem(7, i);
        } else {
            gadgetsInv.setItem(7, nakup("Firework", 300));
        }
        if (p.hasPermission("craftlobby.gadgets.poopbomb")) {
            ItemStack i = ItemFactory.create(Material.MELON_SEEDS, (byte) 0, "§e§lPoopBomb", "§7Bobiky vsude :O");
            gadgetsInv.setItem(8, i);
        } else {
            gadgetsInv.setItem(8, nakup("PoopBomb", 600));
        }
        if (p.hasPermission("craftlobby.gadgets.tnt")) {
            ItemStack i = ItemFactory.create(Material.TNT, (byte) 0, "§e§lTNT", "§7Staci vyhodit a uvidis", "§7bordel. Majgat");
            gadgetsInv.setItem(9, i);
        } else {
            gadgetsInv.setItem(9, nakup("TNT", 1500));
        }
        if (p.hasPermission("craftlobby.gadgets.slimehat")) {
            ItemStack i = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§e§lSlimeHat", "§73x Slime na hlave? OK!");
            gadgetsInv.setItem(10, i);
        } else {
            gadgetsInv.setItem(10, nakup("SlimeHat", 1000));
        }
        if (p.hasPermission("craftlobby.gadgets.withercatapult")) {
            ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§e§lWitherCatapult", "§7To bude rev :D");
            gadgetsInv.setItem(11, i);
        } else {
            gadgetsInv.setItem(11, nakup("WitherCatapult", 1500));
        }
        if (p.hasPermission("craftlobby.gadgets.discoball")) {
            ItemStack i = ItemFactory.create(Material.STAINED_GLASS, (byte) 11, "§e§lDiscoBall", "§7A jedeme! :D");
            gadgetsInv.setItem(12, i);
        } else {
            gadgetsInv.setItem(12, nakup("DiscoBall", 700));
        }
        if (p.hasPermission("craftlobby.gadgets.blizzardblaster")) {
            ItemStack i = ItemFactory.create(Material.PACKED_ICE, (byte) 0, "§e§lBlizzardBlaster", "§7Epicky led vsude kolem tebe!");
            gadgetsInv.setItem(13, i);
        } else {
            gadgetsInv.setItem(13, nakup("BlizzardBlaster", 700));
        }
        if (p.hasPermission("craftlobby.gadgets.ghosts")) {
            ItemStack i = ItemFactory.create(Material.FEATHER, (byte) 0, "§e§lGhosts", "§7Duchove jsou vsude, tak bacha na ne!");
            gadgetsInv.setItem(14, i);
        } else {
            gadgetsInv.setItem(14, nakup("Ghosts", 800));
        }
        if (p.hasPermission("craftlobby.gadgets.tsunami")) {
            ItemStack i = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§e§lTsunami", "§7Odsun vsechny jako tsunami.");
            gadgetsInv.setItem(15, i);
        } else {
            gadgetsInv.setItem(15, nakup("Tsunami", 500));
        }
        if (p.hasPermission("craftlobby.gadgets.batblaster")) {
            ItemStack i = ItemFactory.create(Material.IRON_BARDING, (byte) 0, "§e§lBatBlaster", "§7Netopyri vsude okolo tebe!", "§7Posli je na nekoho!");
            gadgetsInv.setItem(16, i);
        } else {
            gadgetsInv.setItem(16, nakup("BatBlaster", 1500));
        }
        if (p.hasPermission("craftlobby.gadgets.trampoline")) {
            ItemStack i = ItemFactory.create(Material.HOPPER, (byte) 0, "§e§lTrampoline", "§7Trampolina, zaskakej si!");
            gadgetsInv.setItem(17, i);
        } else {
            gadgetsInv.setItem(17, nakup("Trampoline", 2000));
        }
        if (p.hasPermission("craftlobby.gadgets.explosivesheep")) {
            ItemStack i = ItemFactory.create(Material.SHEARS, (byte) 0, "§e§lExplosiveSheep", "§7Vybuchujici ovecka, utec.");
            gadgetsInv.setItem(18, i);
        } else {
            gadgetsInv.setItem(18, nakup("ExplosiveSheep", 3000));
        }
        if (p.hasPermission("craftlobby.gadgets.flowerpopper")) {
            ItemStack i = ItemFactory.create(Material.RED_ROSE, (byte) 0, "§e§lFlowerPopper", "§7Ten pocit, kdyz ti z hlavy", "§7strili kytky.");
            gadgetsInv.setItem(19, i);
        } else {
            gadgetsInv.setItem(19, nakup("FlowerPopper", 600));
        }
        if (p.hasPermission("craftlobby.gadgets.funcannon.ender")) {
            ItemStack i = ItemFactory.create(Material.DIAMOND_HOE, (byte) 0, "§e§lFunCannon Ender", "§7Efekty, efekty, vsude jenom efekty!");
            gadgetsInv.setItem(20, i);
        } else {
            gadgetsInv.setItem(20, nakup("FunCannon Ender", 200));
        }
        if (p.hasPermission("craftlobby.gadgets.antigravity")|| p.hasPermission("craftlobby.gadget.antigravity")) {
            ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER, (byte) 0, "§e§lAntiGravity", "§7Zrus gravitaci okolo sebe...");
            gadgetsInv.setItem(21, i);
        } else {
            gadgetsInv.setItem(21, nakup("AntiGravity", 3000));
        }
        if (p.hasPermission("craftlobby.gadgets.blackhole")) {
            ItemStack i = ItemFactory.create(Material.STAINED_CLAY, (byte) 15, "§e§lBlackHole", "§7Vhod vsechny do cerne diry a uvezni je tam!");
            gadgetsInv.setItem(22, i);
        } else {
            gadgetsInv.setItem(22, nakup("BlackHole", 10000));
        }
        if (p.hasPermission("craftlobby.gadgets.diamondfountain")) {
            ItemStack i = ItemFactory.create(Material.DIAMOND, (byte) 0, "§e§lDiamondFountain", "§7Vsude jenom veci z dia! OMG");
            gadgetsInv.setItem(23, i);
        } else {
            gadgetsInv.setItem(23, nakup("DiamondFountain", 500));
        }
        if (p.hasPermission("craftlobby.gadgets.rocket")) {
            ItemStack i = ItemFactory.create(Material.COAL, (byte) 1, "§e§lRocket", "§7NASA te potrebuje, my ale take!");
            gadgetsInv.setItem(24, i);
        } else {
            //gadgetsInv.setItem(24, nakup("Rocket", 8000));
            ItemStack i = ItemFactory.create(Material.BARRIER, (byte) 1, "§c§lRocket", "§8Nelze si zakoupit. (Docasne)");
            gadgetsInv.setItem(24, i);
        }
        if (p.hasPermission("craftlobby.gadgets.snowball")) {
            ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§e§lSnowBall", "§7Sestrel vsechny! :P");
            gadgetsInv.setItem(25, i);
        } else {
            // Default pravo
        }

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet do menu");

        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§c✖ Deaktivace ✖", "§7Kliknutim deaktivujes gadget.");

        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte) 0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" + CraftCoinsAPI.getCoins(p) + " CC");

        gadgetsInv.setItem(49, shopItem);
        gadgetsInv.setItem(40, deaktivace);
        gadgetsInv.setItem(39, zpet);

        p.openInventory(gadgetsInv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
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
                    ItemStack i = ItemFactory.create(Material.STICK, (byte) 0, "§e§lTeleportStick", "§7Teleportuj se jako Enderman!");
                    Shop.open(p, "TeleportStick", "craftlobby.gadgets.teleportstick", i, 750);
                }
            }
            if (e.getSlot() == 1) {
                if (p.hasPermission("craftlobby.gadgets.funcannon")) {
                    this.ml.prepareGadget(p, "FunCannon", Material.GOLD_HOE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.GOLD_HOE, (byte) 0, "§e§lFunCannon", "§7Kliknutim vystrelis hromadu efektu!");
                    Shop.open(p, "FunCannon", "craftlobby.gadgets.funcannon", i, 500);
                }
            }
            if (e.getSlot() == 2) {
                if (p.hasPermission("craftlobby.gadgets.colorbomb")) {
                    this.ml.prepareGadget(p, "ColorBomb", Material.WOOL, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.WOOL, (byte) 0, "§e§lColorBomb", "§7Vsude jenom vlna...");
                    Shop.open(p, "ColorBomb", "craftlobby.gadgets.colorbomb", i, 750);
                }
            }
            if (e.getSlot() == 3) {
                if (p.hasPermission("craftlobby.gadgets.cookiefountain")) {
                    this.ml.prepareGadget(p, "CookieFountain", Material.COOKIE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.COOKIE, (byte) 0, "§e§lCookieFountain", "§7Susenky vsude!");
                    Shop.open(p, "CookieFountain", "craftlobby.gadgets.cookiefountain", i, 400);
                }
            }
            if (e.getSlot() == 4) {
                if (p.hasPermission("craftlobby.gadgets.chikenator")) {
                    this.ml.prepareGadget(p, "Chickenator", Material.COOKED_CHICKEN, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.COOKED_CHICKEN, (byte) 0, "§e§lChickenator", "§7Bouchajici kure!");
                    Shop.open(p, "Chickenator", "craftlobby.gadgets.chikenator", i, 800);
                }
            }
            if (e.getSlot() == 5) {
                if (p.hasPermission("craftlobby.gadgets.pee")) {
                    this.ml.prepareGadget(p, "Pee", Material.INK_SACK, (byte) 11);
                } else {
                    ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 11, "§e§lPee", "§7Pocurej nam lobby,", "§7ale ne zase moc :P");
                    Shop.open(p, "Pee", "craftlobby.gadgets.pee", i, 1300);
                }
            }
            if (e.getSlot() == 6) {
                if (p.hasPermission("craftlobby.gadgets.pigfly")) {
                    this.ml.prepareGadget(p, "PigFly", Material.SADDLE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.SADDLE, (byte) 0, "§e§lPigFly", "§7Litajici prase... :O");
                    Shop.open(p, "PigFly", "craftlobby.gadgets.pigfly", i, 900);
                }
            }
            if (e.getSlot() == 7) {
                if (p.hasPermission("craftlobby.gadgets.firework")) {
                    this.ml.prepareGadget(p, "Firework", Material.FIREWORK, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.FIREWORK, (byte) 0, "§e§lFirework", "§7Ohnostroj jako na Silvestra!");
                    Shop.open(p, "Firework", "craftlobby.gadgets.firework", i, 300);
                }
            }
            if (e.getSlot() == 8) {
                if (p.hasPermission("craftlobby.gadgets.poopbomb")) {
                    this.ml.prepareGadget(p, "PoopBomb", Material.MELON_SEEDS, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.MELON_SEEDS, (byte) 0, "§e§lPoopBomb", "§7Bobiky vsude :O");
                    Shop.open(p, "PoopBomb", "craftlobby.gadgets.poopbomb", i, 600);
                }
            }
            if (e.getSlot() == 9) {
                if (p.hasPermission("craftlobby.gadgets.tnt")) {
                    this.ml.prepareGadget(p, "TNT", Material.TNT, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.TNT, (byte) 0, "§e§lTNT", "§7Staci vyhodit a uvidis", "§7bordel. Majgat");
                    Shop.open(p, "TNT", "craftlobby.gadgets.tnt", i, 1500);
                }
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.gadgets.slimehat")) {
                    this.ml.prepareGadget(p, "SlimeHat", Material.SLIME_BALL, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§e§lSlimeHat", "§73x Slime na hlave? OK!");
                    Shop.open(p, "SlimeHat", "craftlobby.gadgets.slimehat", i, 1000);
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("craftlobby.gadgets.withercatapult")) {
                    this.ml.prepareGadget(p, "WitherCatapult", Material.COAL, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§e§lWitherCatapult", "§7To bude rev :D");
                    Shop.open(p, "WitherCatapult", "craftlobby.gadgets.withercatapult", i, 1500);
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("craftlobby.gadgets.discoball")) {
                    this.ml.prepareGadget(p, "DiscoBall", Material.STAINED_GLASS, (byte) 11);
                } else {
                    ItemStack i = ItemFactory.create(Material.STAINED_GLASS, (byte) 11, "§e§lDiscoBall", "§7A jedeme! :D");
                    Shop.open(p, "DiscoBall", "craftlobby.gadgets.discoball", i, 700);
                }
            }
            if (e.getSlot() == 13) {
                if (p.hasPermission("craftlobby.gadgets.blizzardblaster")) {
                    this.ml.prepareGadget(p, "BlizzardBlaster", Material.PACKED_ICE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.PACKED_ICE, (byte) 0, "§e§lBlizzardBlaster", "§7Epicky led vsude kolem tebe!");
                    Shop.open(p, "BlizzardBlaster", "craftlobby.gadgets.blizzardblaster", i, 700);
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("craftlobby.gadgets.ghosts")) {
                    this.ml.prepareGadget(p, "Ghosts", Material.FEATHER, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.FEATHER, (byte) 0, "§e§lGhosts", "§7Duchove jsou vsude, tak bacha na ne!");
                    Shop.open(p, "Ghosts", "craftlobby.gadgets.ghosts", i, 800);
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("craftlobby.gadgets.tsunami")) {
                    //this.ml.prepareGadget(p, "Tsunami", Material.WATER_BUCKET, (byte) 0);
                    p.sendMessage("§c§l[!] §cTento Gadget je docasne deaktivovany!");
                } else {
                    ItemStack i = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§e§lTsunami", "§7Odsun vsechny jako tsunami.");
                    //Shop.open(p, "Tsunami", "craftlobby.gadgets.tsunami", i, 500);
                    p.sendMessage("§c§l[!] §cTento Gadget je docasne deaktivovany!");
                }
            }
            if (e.getSlot() == 16) {
                if (p.hasPermission("craftlobby.gadgets.batblaster")) {
                    this.ml.prepareGadget(p, "BatBlaster", Material.IRON_BARDING, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.IRON_BARDING, (byte) 0, "§e§lBatBlaster", "§7Netopyri vsude okolo tebe!", "§7Posli je na nekoho!");
                    Shop.open(p, "BatBlaster", "craftlobby.gadgets.batblaster", i, 1500);
                }
            }
            if (e.getSlot() == 17) {
                if (p.hasPermission("craftlobby.gadgets.trampoline")) {
                    this.ml.prepareGadget(p, "Trampoline", Material.HOPPER, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.HOPPER, (byte) 0, "§e§lTrampoline", "§7Trampolina, zaskakej si!");
                    Shop.open(p, "Trampoline", "craftlobby.gadgets.trampoline", i, 2000);
                }
            }
            if (e.getSlot() == 18) {
                if (p.hasPermission("craftlobby.gadgets.explosivesheep")) {
                    this.ml.prepareGadget(p, "ExplosiveSheep", Material.SHEARS, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.SHEARS, (byte) 0, "§e§lExplosiveSheep", "§7Vybuchujici ovecka, utec.");
                    Shop.open(p, "ExplosiveSheep", "craftlobby.gadgets.explosivesheep", i, 3000);
                }
            }
            if (e.getSlot() == 19) {
                if (p.hasPermission("craftlobby.gadgets.flowerpopper")) {
                    this.ml.prepareGadget(p, "FlowerPopper", Material.RED_ROSE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.RED_ROSE, (byte) 0, "§e§lFlowerPopper", "§7Ten pocit, kdyz ti z hlavy", "§7strili kytky.");
                    Shop.open(p, "FlowerPopper", "craftlobby.gadgets.flowerpopper", i, 600);
                }
            }
            if (e.getSlot() == 20) {
                if (p.hasPermission("craftlobby.gadgets.funcannon.ender")) {
                    this.ml.prepareGadget(p, "FunCannon Ender", Material.DIAMOND_HOE, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.DIAMOND_HOE, (byte) 0, "§e§lFunCannon Ender", "§7Efekty, efekty, vsude jenom efekty!");
                    Shop.open(p, "FunCannon Ender", "craftlobby.gadgets.funcannon.ender", i, 200);
                }
            }
            if (e.getSlot() == 21) {
                if (p.hasPermission("craftlobby.gadgets.antigravity") || p.hasPermission("craftlobby.gadget.antigravity")) {
                    this.ml.prepareGadget(p, "AntiGravity", Material.EYE_OF_ENDER, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER, (byte) 0, "§e§lAntiGravity", "§7Zrus gravitaci okolo sebe...");
                    Shop.open(p, "AntiGravity", "craftlobby.gadgets.antigravity", i, 3000);
                }
            }
            if (e.getSlot() == 22) {
                if (p.hasPermission("craftlobby.gadgets.blackhole")) {
                    this.ml.prepareGadget(p, "BlackHole", Material.STAINED_CLAY, (byte) 15);
                } else {
                    ItemStack i = ItemFactory.create(Material.STAINED_CLAY, (byte) 15, "§e§lBlackHole", "§7Vhod vsechny do cerne diry a uvezni je tam!");
                    Shop.open(p, "BlackHole", "craftlobby.gadgets.blackhole", i, 10000);
                }
            }
            if (e.getSlot() == 23) {
                if (p.hasPermission("craftlobby.gadgets.diamondfountain")) {
                    this.ml.prepareGadget(p, "DiamondFountain", Material.DIAMOND, (byte) 0);
                } else {
                    ItemStack i = ItemFactory.create(Material.DIAMOND, (byte) 0, "§e§lDiamondFountain", "§7Vsude jenom veci z dia! OMG");
                    Shop.open(p, "DiamondFountain", "craftlobby.gadgets.diamondfountain", i, 500);
                }
            }
            if (e.getSlot() == 24) {
                if (p.hasPermission("craftlobby.gadgets.rocket")) {
                    this.ml.prepareGadget(p, "Rocket", Material.COAL, (byte) 1);
                } else {
                    ItemStack i = ItemFactory.create(Material.COAL, (byte) 1, "§e§lRocket", "§7NASA te potrebuje, my ale take!");
                    //Shop.open(p, "Rocket", "craftlobby.gadgets.rocket", i, 8000);
                    p.sendMessage("§c§l[!] §cNelze si docasne tento Gadget zakoupit.");
                }
            }
            if (e.getSlot() == 25) {
                if (p.hasPermission("craftlobby.gadgets.snowball")) {
                    this.ml.prepareGadget(p, "SnowBall", Material.SNOW_BALL, (byte) 0);
                } else {
                    this.ml.messageNoPerm(p, "SnowBall");
                }
            }


        }
    }

    private ItemStack nakup(final String name, final int price) {
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§l" + name, "§7Lze zakoupit za §e" + price + " CC.");
        return i;
    }


}
