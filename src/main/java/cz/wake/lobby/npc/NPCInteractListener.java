package cz.wake.lobby.npc;

import cz.wake.lobby.Main;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NPCInteractListener implements Listener {

    @EventHandler
    public void onNpcClick(NPCInteractEvent event) {
        NPC unknownNpc = event.getNPC();
        for (IServerNPC serverNPC : Main.getInstance().getNpcManager().getNpcList()) {
            if (serverNPC.getLocation().equals(unknownNpc.getLocation())) {
                serverNPC.onClick(event.getWhoClicked(), event.getClickType());
            }
        }
    }
}
