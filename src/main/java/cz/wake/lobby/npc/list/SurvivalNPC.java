package cz.wake.lobby.npc.list;

import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SurvivalNPC implements IServerNPC {

    @Override
    public String getId() {
        return "survival";
    }

    @Override
    public int getSkinId() {
        return 1883561795;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 384.5, 75, 204.5, 35, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§a§lSurvival §e[1.12]");
        list.add("§f10 §fhráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {}
}
