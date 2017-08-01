package cz.wake.lobby.listeners;

import cl.omegacraft.kledioz.rparkour.ParkourEndEvent;
import cl.omegacraft.kledioz.rparkour.ParkourTeleportEvent;
import cz.wake.lobby.Main;
import cz.wake.lobby.gadgets.cloaks.RankCape;
import cz.wake.lobby.gadgets.pets.PetManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ParkourListener implements Listener {

    InvClick ic = new InvClick();

    @EventHandler
    public void onParkourStart(ParkourTeleportEvent e){
        Player p = e.getPlayer();

        p.setAllowFlight(false);
        p.setFlying(false);

        // Deaktivace particles
        ic.deactivateParticles(p);

        // Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        RankCape.deactivateCape(p);

        // Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);

        p.getInventory().setItem(6, null);
    }

    @EventHandler
    public void onParkourEnd(ParkourEndEvent e){
        Player p = e.getPlayer();

        if (p.hasPermission("craftlobby.vip.fly")) {
            if (Main.getInstance().fetchData().getSettings(p, "lobby_fly") == 1) {
                p.setAllowFlight(true);
            }
        }
    }
}
