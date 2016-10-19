package cz.wake.plugins.banners;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannerAPI implements Listener {

    private MessagesListener ml = new MessagesListener();

    public void openInventory(Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "Bannery");


        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet do menu");

        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§c✖ Deaktivace ✖", "§7Kliknutim deaktivujes banner.");

        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte) 0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");

        if (p.hasPermission("craftlobby.banner.tardis")) {
            inv.setItem(0, tardis());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTardis", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(0, i);
        }
        if (p.hasPermission("craftlobby.banner.duck")) {
            inv.setItem(1, duck());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lDuck", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(1, i);
        }
        if (p.hasPermission("craftlobby.banner.king")) {
            inv.setItem(2, king());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lKing", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(2, i);
        }
        if (p.hasPermission("craftlobby.banner.creeper")) {
            inv.setItem(3, creeper());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lCreeper", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(3, i);
        }
        if (p.hasPermission("craftlobby.banner.rabbit")) {
            inv.setItem(4, rabbit());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lRabbit", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(4, i);
        }
        if (p.hasPermission("craftlobby.banner.panda")) {
            inv.setItem(5, panda());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPanda", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(5, i);
        }
        if (p.hasPermission("craftlobby.banner.assassin")) {
            inv.setItem(6, assassin());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lAssassin", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(6, i);
        }
        if (p.hasPermission("craftlobby.banner.dragon")) {
            inv.setItem(7, dragon());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lDragon", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(7, i);
        }
        if (p.hasPermission("craftlobby.banner.slime")) {
            inv.setItem(8, slime());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lSlime", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(8, i);
        }
        if (p.hasPermission("craftlobby.banner.bumbum")) {
            inv.setItem(9, bumbum());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lBumbum", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(9, i);
        }
        if (p.hasPermission("craftlobby.banner.zoidberg")) {
            inv.setItem(10, zoidberg());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lZoidberg", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(10, i);
        }
        if (p.hasPermission("craftlobby.banner.smile")) {
            inv.setItem(11, smile());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lSmile", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(11, i);
        }
        if (p.hasPermission("craftlobby.banner.bear")) {
            inv.setItem(12, bear());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lBear", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(12, i);
        }
        if (p.hasPermission("craftlobby.banner.grumpy")) {
            inv.setItem(13, grumpy());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lGrumpy", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(13, i);
        }
        if (p.hasPermission("craftlobby.banner.pencil")) {
            inv.setItem(14, pencil());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPencil", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(14, i);
        }
        if (p.hasPermission("craftlobby.banner.batman")) {
            inv.setItem(15, batman());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lBatman", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(15, i);
        }
        if (p.hasPermission("craftlobby.banner.twitch")) {
            inv.setItem(16, twitch());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lTwitch", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(16, i);
        }
        if (p.hasPermission("craftlobby.banner.penguin")) {
            inv.setItem(17, penguin());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lPenguin", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(17, i);
        }
        if (p.hasPermission("craftlobby.banner.thunder")) {
            inv.setItem(18, thunder());
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lThunder", "§7Banner lze ziskat v CraftBoxu!");
            inv.setItem(18, i);
        }

        inv.setItem(49, shopItem);
        inv.setItem(40, deaktivace);
        inv.setItem(39, zpet);

        p.openInventory(inv);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Bannery")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.getInventory().setHelmet(null);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 49) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 0) {
                if (p.hasPermission("craftlobby.banner.tardis")) {
                    p.getInventory().setHelmet(tardis());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Tardis");
                }
            }
            if (e.getSlot() == 1) {
                if (p.hasPermission("craftlobby.banner.duck")) {
                    p.getInventory().setHelmet(duck());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Duck");
                }
            }
            if (e.getSlot() == 2) {
                if (p.hasPermission("craftlobby.banner.king")) {
                    p.getInventory().setHelmet(king());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "King");
                }
            }
            if (e.getSlot() == 3) {
                if (p.hasPermission("craftlobby.banner.creeper")) {
                    p.getInventory().setHelmet(creeper());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Creeper");
                }
            }
            if (e.getSlot() == 4) {
                if (p.hasPermission("craftlobby.banner.rabbit")) {
                    p.getInventory().setHelmet(rabbit());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Rabbit");
                }
            }
            if (e.getSlot() == 5) {
                if (p.hasPermission("craftlobby.banner.panda")) {
                    p.getInventory().setHelmet(panda());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Panda");
                }
            }
            if (e.getSlot() == 6) {
                if (p.hasPermission("craftlobby.banner.assassin")) {
                    p.getInventory().setHelmet(assassin());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Assassin");
                }
            }
            if (e.getSlot() == 7) {
                if (p.hasPermission("craftlobby.banner.dragon")) {
                    p.getInventory().setHelmet(dragon());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Dragon");
                }
            }
            if (e.getSlot() == 8) {
                if (p.hasPermission("craftlobby.banner.slime")) {
                    p.getInventory().setHelmet(slime());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Slime");
                }
            }
            if (e.getSlot() == 9) {
                if (p.hasPermission("craftlobby.banner.bumbum")) {
                    p.getInventory().setHelmet(bumbum());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Bumbum");
                }
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.banner.zoidberg")) {
                    p.getInventory().setHelmet(zoidberg());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Zoidberg");
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("craftlobby.banner.smile")) {
                    p.getInventory().setHelmet(smile());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Slime");
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("craftlobby.banner.bear")) {
                    p.getInventory().setHelmet(bear());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Bear");
                }
            }
            if (e.getSlot() == 13) {
                if (p.hasPermission("craftlobby.banner.grumpy")) {
                    p.getInventory().setHelmet(grumpy());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Grumpy");
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("craftlobby.banner.pencil")) {
                    p.getInventory().setHelmet(pencil());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Pencil");
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("craftlobby.banner.batman")) {
                    p.getInventory().setHelmet(batman());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Batman");
                }
            }
            if (e.getSlot() == 16) {
                if (p.hasPermission("craftlobby.banner.twitch")) {
                    p.getInventory().setHelmet(twitch());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Twitch");
                }
            }
            if (e.getSlot() == 17) {
                if (p.hasPermission("craftlobby.banner.penguin")) {
                    p.getInventory().setHelmet(penguin());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Penguin");
                }
            }
            if (e.getSlot() == 18) {
                if (p.hasPermission("craftlobby.banner.thunder")) {
                    p.getInventory().setHelmet(thunder());
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Thunder");
                }
            }

        }
    }

    private ItemStack tardis() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLUE);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.BRICKS));
        bm.addPattern(new Pattern(DyeColor.BLUE, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRAIGHT_CROSS));
        bm.addPattern(new Pattern(DyeColor.BLUE, PatternType.STRAIGHT_CROSS));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.BLUE, PatternType.BORDER));
        bm.setDisplayName("§e§lTardis");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);

        return b;
    }

    private ItemStack duck() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLACK);
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_CENTER));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP));
        bm.setDisplayName("§e§lDuck");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);

        return b;
    }

    private ItemStack king() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLACK);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.CREEPER));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
        bm.setDisplayName("§e§lKing");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack creeper() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.GREEN);
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
        bm.setDisplayName("§e§lCreeper");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack rabbit() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.CROSS));
        bm.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_BOTTOM));
        bm.setDisplayName("§e§lKralik");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack panda() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
        bm.setDisplayName("§e§lPanda");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack assassin() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.HALF_HORIZONTAL));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLE_BOTTOM));
        bm.setDisplayName("§e§lAssassin");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack dragon() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.MAGENTA);
        bm.addPattern(new Pattern(DyeColor.MAGENTA, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.MAGENTA, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
        bm.setDisplayName("§e§lDragon");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack slime() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.LIME);
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.STRIPE_RIGHT));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.HALF_VERTICAL));
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.HALF_HORIZONTAL));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.STRAIGHT_CROSS));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.LIME, PatternType.STRIPE_BOTTOM));
        bm.setDisplayName("§e§lSlime");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack bumbum() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.MOJANG));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
        bm.addPattern(new Pattern(DyeColor.GRAY, PatternType.CREEPER));
        bm.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_TOP));
        bm.setDisplayName("§e§lBumbum");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack zoidberg() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLACK);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_CENTER));
        bm.setDisplayName("§e§lZoidberg");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack smile() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.YELLOW);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.BRICKS));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.MOJANG));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_MIDDLE));
        bm.setDisplayName("§e§lSmile");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack bear() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_CENTER));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.SKULL));
        bm.setDisplayName("§e§lBear");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack grumpy() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.LIGHT_BLUE);
        bm.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.CIRCLE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.CROSS));
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.SKULL));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.GREEN, PatternType.STRIPE_TOP));
        bm.setDisplayName("§e§lGrumpy");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack pencil() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.YELLOW);
        bm.addPattern(new Pattern(DyeColor.BROWN, PatternType.HALF_VERTICAL));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRAIGHT_CROSS));
        bm.addPattern(new Pattern(DyeColor.GRAY, PatternType.CREEPER));
        bm.addPattern(new Pattern(DyeColor.SILVER, PatternType.STRIPE_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.SILVER, PatternType.SKULL));
        bm.addPattern(new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_RIGHT));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_LEFT));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_LEFT));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_RIGHT));
        bm.setDisplayName("§e§lPencil");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack batman() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.YELLOW);
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_SMALL));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLES_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLES_TOP));
        bm.setDisplayName("§e§lBatman");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack twitch() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.WHITE);
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.SQUARE_BOTTOM_LEFT));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.SQUARE_BOTTOM_LEFT));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.SQUARE_BOTTOM_LEFT));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.BORDER));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP));
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP));
        bm.setDisplayName("§e§lTwitch");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack penguin() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLACK);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.RHOMBUS_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.CIRCLE_MIDDLE));
        bm.setDisplayName("§e§lPenguin");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

    private ItemStack thunder() {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.YELLOW);
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_TOP_RIGHT));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_LEFT));
        bm.setDisplayName("§e§lThunder");
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }
}
