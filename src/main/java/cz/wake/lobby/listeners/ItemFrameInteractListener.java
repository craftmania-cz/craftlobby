package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ItemFrameInteractListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onClick(PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof ItemFrame
                //&& !((ItemFrame)event.getRightClicked()).getItem().getType().equals(Material.AIR)
                && !Main.getInstance().isDebug()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void hanging (HangingPlaceEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof ItemFrame) {
            if (Main.getInstance().isDebug()) {
                event.setCancelled(false);
            } else{
                event.setCancelled(true);
            }
        }
    }
}
