package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HardcoreVanillaNPC implements IServerNPC {

    @Override
    public String getId() {
        return "hardcore-vanilla";
    }

    @Override
    public int getSkinId() {
        return 1958767103;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 388.5, 75, 219.5, 145, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§4§lHardcore Vanilla §e[1.16]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("hardcore-vanilla") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "hardcore-vanilla");
    }
}
