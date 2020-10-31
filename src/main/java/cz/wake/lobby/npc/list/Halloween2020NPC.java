package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Halloween2020NPC implements IServerNPC {

    @Override
    public String getId() {
        return "halloween";
    }

    @Override
    public int getSkinId() {
        return 204736032;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 379.5, 75, 203.5, 0, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§fHalloween Minihra");
        list.add("§6§lDead By Daylight");
        list.add("§7Klikni pro připojení do hry");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().connectPlayer(player, "halloween-games");
    }
}
