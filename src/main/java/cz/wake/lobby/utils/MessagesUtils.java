package cz.wake.lobby.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class MessagesUtils {

    public void sendMessageNearby(Location loc, double distance, String message) {
        for (Entity ent : loc.getWorld().getEntities()) {
            if (ent.getLocation().distance(loc) <= distance) {
                ent.sendMessage(message);
            }
        }
    }
}
