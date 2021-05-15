package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        try {
            if (event.getCurrentItem() == null) {
                return;
            }
            if ((event.getSlot() == 20) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Web"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš web:");
                player.sendMessage("§fhttps://craftmania.cz");
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 22) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Discord"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš Discord server:");
                player.sendMessage("§fhttps://discord.gg/craftmania");
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 24) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Instagram"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš Instagram účet:");
                player.sendMessage("§fhttps://www.instagram.com/craftmania.cz/");
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
