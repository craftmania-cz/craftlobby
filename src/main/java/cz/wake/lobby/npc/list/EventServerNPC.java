package cz.wake.lobby.npc.list;

import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EventServerNPC implements IServerNPC {

    @Override
    public String getId() {
        return "event_server";
    }

    @Override
    public int getSkinId() {
        //return 1517786801;
        return 128714390;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 377.5, 75, 203.5, 0, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§b§lEvent Server");
        list.add("§fSOON TM");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {}
}
