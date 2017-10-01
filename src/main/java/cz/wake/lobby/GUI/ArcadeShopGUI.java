package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArcadeShopGUI implements Listener {

    public void openMainGUI(Player p) {

        Inventory inv = Bukkit.createInventory(null, 27, "Arcade Shop");

        ItemStack getdown = ItemFactory.create(Material.IRON_BOOTS, (byte) 0, "§b§lGetDown", "", "§7Nakup si do hry GetDown", "§7doplnky a kity abys", "§7vyhraval jeste vic!", "", "§eKlikni pro zobrazeni!");
        ItemStack buildbattle = ItemFactory.create(Material.WORKBENCH, (byte) 0, "§6§lBuildBattle", "§8Jiz brzy...");
        ItemStack speedbuilders = ItemFactory.create(Material.PRISMARINE_CRYSTALS, (byte) 0, "§3§lSpeedBuilders", "§8Jiz brzy...");
        ItemStack drawit = ItemFactory.create(Material.PAINTING, (byte) 0, "§d§lDrawIt", "§7Jiz brzy...");

        inv.setItem(10, getdown);
        inv.setItem(12, buildbattle);
        inv.setItem(14, speedbuilders);
        inv.setItem(16, drawit);

        p.openInventory(inv);
    }

    public void openGetDownShop(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, "GetDown Shop");

        ItemStack coiner = ItemFactory.create(Material.GOLD_NUGGET, (byte) 0, "§e§lCoiner", "", "§7Pri startu hry dostanes", "§7instantne §f500 coinu.", "", "§7Cena: §62500 CC", "", checkBuy(p, "getdownplus.kit.coiner", 2500));
        ItemStack healther = ItemFactory.create(Material.GOLDEN_APPLE, (byte) 0, "§e§lHealther", "", "§7Na zacatku hry obdrzis +5§4❤", "", "§7Cena: §61500 CC", "", checkBuy(p, "getdownplus.kit.healther", 1500));
        ItemStack lucker = ItemFactory.create(Material.SPONGE, (byte) 0, "§e§lLucker", "", "§7Kazdy LuckyBlock bude Lucky!", "", "§7Cena: §62000 CC", "", checkBuy(p, "getdownplus.kit.lucker", 2000));
        ItemStack knockbacker = ItemFactory.create(Material.STICK, (byte) 0, "§e§lKnockbacker", "", "§7Na zacatku hry obdrzis klacik", "§7s Knockback 3", "", "§7Cena: §61500 CC", "", checkBuy(p, "getdownplus.kit.knockbacker", 1500));

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet");

        inv.setItem(10, coiner);
        inv.setItem(11, healther);
        inv.setItem(12, lucker);
        inv.setItem(13, knockbacker);

        inv.setItem(31, zpet);

        p.openInventory(inv);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Arcade Shop")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 10) {
                openGetDownShop(p);
            }
        }
        if (e.getInventory().getTitle().equals("GetDown Shop")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 31) {
                openMainGUI(p);
            }
            if (e.getSlot() == 10) {
                if (!p.hasPermission("getdownplus.kit.coiner")) {
                    ItemStack i = ItemFactory.create(Material.GOLD_NUGGET, (byte) 0, "§e§Coiner", "", "§7Pri startu hry dostanes", "§7instantne §f500 coinu.");
                    Shop.open(p, "Coiner", "getdownplus.kit.coiner", i, 2500);
                } else {
                    p.sendMessage("§cJiz mas toto zakoupeno!");
                }
            }
            if (e.getSlot() == 11) {
                if (!p.hasPermission("getdownplus.kit.healther")) {
                    ItemStack i = ItemFactory.create(Material.GOLDEN_APPLE, (byte) 0, "§e§lHealther", "", "§7Na zacatku hry obdrzis +5&4❤");
                    Shop.open(p, "Healther", "getdownplus.kit.healther", i, 1500);
                } else {
                    p.sendMessage("§cJiz mas toto zakoupeno!");
                }
            }
            if (e.getSlot() == 12) {
                if (!p.hasPermission("getdownplus.kit.lucker")) {
                    ItemStack i = ItemFactory.create(Material.SPONGE, (byte) 0, "§e§lLucker", "", "§7Kazdy LuckyBlock bude Lucky!");
                    Shop.open(p, "Lucker", "getdownplus.kit.lucker", i, 2000);
                } else {
                    p.sendMessage("§cJiz mas toto zakoupeno!");
                }
            }
            if (e.getSlot() == 13) {
                if (!p.hasPermission("getdownplus.kit.knockbacker")) {
                    ItemStack i = ItemFactory.create(Material.STICK, (byte) 0, "§e§lKnockbacker", "", "§7Na zacatku hry obdrzis klacik", "§7s Knockback 3");
                    Shop.open(p, "Knockbacker", "getdownplus.kit.knockbacker", i, 1500);
                } else {
                    p.sendMessage("§cJiz mas toto zakoupeno!");
                }
            }
        }
    }

    private String checkBuy(Player p, String perm, int coins) {
        if (p.hasPermission(perm)) {
            return "§a§lJiz zakoupeno";
        } else if (Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) < coins) {
            return "§c§lNemas dostatek coinu";
        } else {
            return "§e§lKlikni pro nakup";
        }
    }
}
