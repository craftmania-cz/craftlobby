package cz.wake.lobby.npc.list;

import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TutorialNPC implements IServerNPC {

    @Override
    public String getId() {
        return "tutorial";
    }

    @Override
    public int getSkinId() {
        return 174408428;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 364.5, 75, 208.5, 47, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§d§lTutorial & Info");
        list.add("§7Základní informace");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {}
}
