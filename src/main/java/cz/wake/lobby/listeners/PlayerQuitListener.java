package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onLeave(final PlayerQuitEvent e) {
        Player p = e.getPlayer();

        // Deaktivace leave zprav
        e.setQuitMessage(null);

        // ATS
        Main.getInstance().at_list.remove(p);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();

        //AT
        Main.getInstance().at_list.remove(p);
    }
}
