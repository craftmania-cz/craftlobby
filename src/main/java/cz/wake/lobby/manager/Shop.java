package cz.wake.lobby.manager;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop implements Listener {

    private static String permission;
    private static ItemStack item;
    private static Player player;
    private static int coin;
    private static String name;

    public static void open(final Player p, final String names, final String permissions, final ItemStack i, final int coins){

        if(Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) >= coins){
            coin = coins;
            player = p;
            permission = permissions;
            item = i;
            name = names;

            Inventory inv = Bukkit.createInventory(null, 45, "[S] Nakup za coiny");

            inv.setItem(13, item);

            ItemStack nakup = ItemFactory.create(Material.STAINED_GLASS_PANE,(byte)5,"§a§lZakoupit","§7Zakoupis Gadget za §e" + coin + " CC.");
            ItemStack zamitnout = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte)14, "§c§lZrusit", "§7Zpet do menu");

            inv.setItem(30, nakup);
            inv.setItem(32,zamitnout);

            player.openInventory(inv);
        } else {
            p.sendMessage("§cNedostatek coinu k nakupu: §f" + coins + " CC");
        }
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("[S] Nakup za coiny")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 13) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 30){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pp user " + p.getName() + " add " + permission);
                Main.getInstance().fetchData().takeCoins(p, coin);
                p.sendMessage("§eZakoupil jsi si §a" + name + " §eza §6" + coin + " CC.");
                p.closeInventory();
            }
            if (e.getSlot() == 32){
                p.closeInventory();
            }
        }
    }
}
