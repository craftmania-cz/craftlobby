package cz.wake.lobby.gadgets.morphs;

import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.utils.ItemFactory;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MorphAPI implements Listener {

    public void openMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "Morphs");

        ItemStack pig = ItemFactory.createHead("pig", "fe235c9f-d021-461b-9c22-d265bc867e21", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTI3YWQ1MWRkNzczYjcyZGNhMWMxM2U2ZjM1NDdhODMxODFhYWQ5MTE2NTI4Mjk5OWJiZGYxM2EzYjNjOSJ9fX0=", "§e§lPig Morph", "", "§7Premen se na prase", "§7a ochrochtej vsechny dokola!", "", "§8Levym kliknutim strilis sunku!", "", "§aKlikni pro aktivaci!");

        ItemStack villager = ItemFactory.createHead("villager", "27e2e46c-18b8-4257-b74b-aa3b3383b327", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjNiMzY0MjVjYmZhNDhlNDY4NGM4ZTFhNzE0Nzc5MTllMGE0NmI2MTM1MTFhODQzNmM3NzViMTVmNTYxNSJ9fX0=", "§e§lVillager Morph", "", "§7Premen se na Villagera", "§7a rozdavej lasku.", "", "§8Pouzij prave ale leve", "§8tlacitko k zjisteni nalady!", "", "§aKlikni pro aktivaci");

        ItemStack golem = ItemFactory.createHead("golem", "cb6bbe69-f97f-4635-854c-5cee7f75ee2e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQ0MmMyMjhmMDk5ZmRmYzFjNmI0NmRmYzgwYjI1MmQ4MWY3ZmIxNzM5ZGViMTZlZTdhNTk3YzE3ZjdjOSJ9fX0=", "§e§lIronGolem Morph", "", "§7Premen se na IronGolema", "§7nez se usmazis v lave!", "", "§aKlikni pro aktivaci!");

        ItemStack snowman = ItemFactory.createHead("snowman", "30c81c0b-ce4a-4bf8-8af1-4b573e04b373", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTk3ZTkwZTEzNzkzMTg5NGQ1YzA3NWJjMzM3NDE1NzU3MzQ3MjFiNGE1ZmVmOWIzYzk3YTJlZmFkZDU0YTcifX19", "§e§lSnowman Morph", "", "§7Premen se na Snehulaka", "§7a sestrel vsechny!", "", "§aKlikni pro aktivaci!");

        ItemStack chicken = ItemFactory.createHead("chicken", "192e9a04-f27b-4ff2-9402-90df71c3e5cb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQyOWZmMWQyMDE1Y2IxMTM5ODQ3MWJiMmY4OTVmN2I0YzNjY2VjMjAxZTRhZDdhODZmZjI0Yjc0NDg3OGMifX19", "§e§lChicken Morph", "", "§7Premen se na kure", "§7a ukaz vsem, kdo tu vyrobi","§7nejvic vajicek!", "", "§aKlikni pro aktivaci!");

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet do menu");

        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§c✖ Deaktivace ✖", "§7Kliknutim deaktivujes banner.");

        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte) 0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" + CraftCoinsAPI.getCoins(p) + " CC");

        if (p.hasPermission("craftlobby.morphs.pig")) {
            inv.setItem(10, pig);
        } else {
            inv.setItem(10, nakup("Pig Morph", 600));
        }
        if (p.hasPermission("craftlobby.morphs.villager")) {
            inv.setItem(11, villager);
        } else {
            inv.setItem(11, nakup("Villager Morph", 600));
        }
        if (p.hasPermission("craftlobby.morphs.irongolem")) {
            inv.setItem(12, golem);
        } else {
            inv.setItem(12, nakup("Iron Golem Morph", 900));
        }
        if (p.hasPermission("craftlobby.morphs.snowman")){
            inv.setItem(13, snowman);
        } else {
            inv.setItem(13, nakup("Snowman Morph", 1500));
        }
        if (p.hasPermission("craftlobby.morphs.chicken")){
            inv.setItem(14, chicken);
        } else {
            inv.setItem(14, nakup("Chicken Morph", 900));
        }

        inv.setItem(49, shopItem);
        inv.setItem(40, deaktivace);
        inv.setItem(39, zpet);

        p.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Morphs")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                DisguiseAPI.undisguiseToAll(p);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.morphs.pig")) {
                    PigMorph.activate(p);
                } else {
                    ItemStack pig = ItemFactory.createHead("pig", "fe235c9f-d021-461b-9c22-d265bc867e21", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTI3YWQ1MWRkNzczYjcyZGNhMWMxM2U2ZjM1NDdhODMxODFhYWQ5MTE2NTI4Mjk5OWJiZGYxM2EzYjNjOSJ9fX0=", "§e§lPig Morph", "", "§7Premen se na prase", "§7a ochrochtej vsechny dokola!", "", "§8Levym kliknutim strilis sunku!", "", "§aKlikni pro aktivaci!");
                    Shop.open(p, "Pig Morph", "craftlobby.morphs.pig", pig, 600);
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("craftlobby.morphs.villager")) {
                    VillagerMorph.activate(p);
                } else {
                    ItemStack villager = ItemFactory.createHead("villager", "27e2e46c-18b8-4257-b74b-aa3b3383b327", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjNiMzY0MjVjYmZhNDhlNDY4NGM4ZTFhNzE0Nzc5MTllMGE0NmI2MTM1MTFhODQzNmM3NzViMTVmNTYxNSJ9fX0=", "§e§lVillager Morph", "", "§7Premen se na Villagera", "§7a rozdavej lasku.", "", "§8Pouzij prave ale leve", "§8tlacitko k zjisteni nalady!", "", "§aKlikni pro aktivaci");
                    Shop.open(p, "Villager Morph", "craftlobby.morphs.villager", villager, 600);
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("craftlobby.morphs.irongolem")) {
                    IronGolemMorph.activate(p);
                } else {
                    ItemStack golem = ItemFactory.createHead("golem", "cb6bbe69-f97f-4635-854c-5cee7f75ee2e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQ0MmMyMjhmMDk5ZmRmYzFjNmI0NmRmYzgwYjI1MmQ4MWY3ZmIxNzM5ZGViMTZlZTdhNTk3YzE3ZjdjOSJ9fX0=", "§e§lIronGolem Morph", "", "§7Premen se na IronGolema", "§7nez se usmazis v lave!", "", "§aKlikni pro aktivaci!");
                    Shop.open(p, "Iron Golem Morph", "craftlobby.morphs.irongolem", golem, 900);
                }
            }
            if (e.getSlot() == 13){
                if (p.hasPermission("craftlobby.morphs.snowman")){
                    SnowmanMorph.activate(p);
                } else {
                    ItemStack snowman = ItemFactory.createHead("snowman", "30c81c0b-ce4a-4bf8-8af1-4b573e04b373", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTk3ZTkwZTEzNzkzMTg5NGQ1YzA3NWJjMzM3NDE1NzU3MzQ3MjFiNGE1ZmVmOWIzYzk3YTJlZmFkZDU0YTcifX19", "§b§lSnowman Morph", "", "§7Premen se na Snehulaka", "§7a sestrel vsechny!", "", "§aKlikni pro aktivaci!");
                    Shop.open(p, "Snowman Morph", "craftlobby.morphs.snowman", snowman, 1500);
                }
            }
            if(e.getSlot() == 14){
                if(p.hasPermission("craftlobby.morphs.chicken")){
                    ChickenMorph.activate(p);
                } else {
                    ItemStack chicken = ItemFactory.createHead("chicken", "192e9a04-f27b-4ff2-9402-90df71c3e5cb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQyOWZmMWQyMDE1Y2IxMTM5ODQ3MWJiMmY4OTVmN2I0YzNjY2VjMjAxZTRhZDdhODZmZjI0Yjc0NDg3OGMifX19", "§e§lChicken Morph", "", "§7Premen se na kure", "§7a ukaz vsem, kdo tu vyrobi","§7nejvic vajicek!", "", "§aKlikni pro aktivaci!");
                    Shop.open(p, "Chicken Morph", "craftlobby.morphs.chicken", chicken, 900);
                }
            }

        }
    }

    private ItemStack nakup(final String name, final int price) {
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§l" + name, "§7Lze zakoupit za §e" + price + " CC.");
        return i;
    }


}
