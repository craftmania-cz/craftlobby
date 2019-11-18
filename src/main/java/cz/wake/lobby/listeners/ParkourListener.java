package cz.wake.lobby.listeners;

import cl.omegacraft.kledioz.rparkour.ParkourEndEvent;
import cl.omegacraft.kledioz.rparkour.ParkourTeleportEvent;
import cz.wake.lobby.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class ParkourListener implements Listener {

    private InvClick ic = new InvClick();
    public static ArrayList<Player> in_parkour = new ArrayList<>();

    @EventHandler
    public void onParkourStart(ParkourTeleportEvent e) {
        Player p = e.getPlayer();
        in_parkour.add(p);

        p.setAllowFlight(false);
        p.setFlying(false);

        p.getInventory().setItem(6, null);
    }

    @EventHandler
    public void onParkourEnd(ParkourEndEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("craftlobby.vip.fly")
                && Main.getInstance().getSQL().getSettings(p, "lobby_fly") == 1) {
            p.setAllowFlight(true);
        }

        in_parkour.remove(p);
    }
}
