package cz.wake.lobby.npc.list;

import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GoldenPigNPC implements IServerNPC {

    @Override
    public String getId() {
        return "golden_pig";
    }

    @Override
    public int getSkinId() {
        return 959273406;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 364.5, 75, 216.5, 133, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§e§lGolden Pig");
        list.add("§7Odměny každý den");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {}
}
