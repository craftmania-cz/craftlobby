package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ItemFrameInteractListener implements Listener {

    public void onClick(PlayerInteractEntityEvent event) {
        if(!event.isCancelled() && event.getRightClicked() instanceof ItemFrame
                && !((ItemFrame)event.getRightClicked()).getItem().getType().equals(Material.AIR)
                && !Main.getInstance().isDebug()) {
            event.setCancelled(true);
        }
    }
}
