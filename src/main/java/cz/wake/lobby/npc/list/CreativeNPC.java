package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CreativeNPC implements IServerNPC {

    @Override
    public String getId() {
        return "creative";
    }

    @Override
    public int getSkinId() {
        return 1176210402;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 390.5, 75, 208.5, 86, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§c§lCreative §e[1.14]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("creative") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative");
    }
}
