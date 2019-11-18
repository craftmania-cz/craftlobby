package cz.wake.lobby.npc;

import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public interface IServerNPC {

    String getId();

    int getSkinId();

    Location getLocation();

    List<String> getHologramLines();

    void onClick(Player player, NPCInteractEvent.ClickType clickType);
}
