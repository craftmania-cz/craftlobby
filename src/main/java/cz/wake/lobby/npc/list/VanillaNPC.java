package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanillaNPC implements IServerNPC {

    @Override
    public String getId() {
        return "vanilla";
    }

    @Override
    public int getSkinId() {
        return 1758780134;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 391.5, 75, 212.5, 90, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§6§lVanilla §e[1.16]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("vanilla") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla");
    }
}
