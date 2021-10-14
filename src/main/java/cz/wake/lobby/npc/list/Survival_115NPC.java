package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Survival_115NPC implements IServerNPC {

    @Override
    public String getId() {
        return "survival";
    } // 1.15

    @Override
    public int getSkinId() {
        return 279251979;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 384.5, 75, 204.5, 35, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§3§lSurvival §e[1.17]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("survival2") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "survival");
    }
}
