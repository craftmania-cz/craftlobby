package cz.wake.lobby.listeners;

import cz.craftmania.craftcore.inventory.builder.SmartInventory;
import cz.wake.lobby.gui.BedwarsSelector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class SignInteractListener implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent event) {

        if (!event.getHand().equals(EquipmentSlot.HAND)) return;

        // Check if player clicked on a sign
        if (event.getClickedBlock() != null && event.getClickedBlock().getState() instanceof Sign) {
            // Check if its correct location of sign
            if (event.getClickedBlock().getLocation().equals(new Location(Bukkit.getWorld("obw"), -609, 100, 101))) {
                Player player = event.getPlayer();
                SmartInventory.builder().size(4, 9).title("BedWars servery").provider(new BedwarsSelector()).build().open(player);
            }

        }

    }


}
