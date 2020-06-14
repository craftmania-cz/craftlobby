package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SkyCloudNPC implements IServerNPC {

    @Override
    public String getId() {
        return "skycloud";
    }

    @Override
    public int getSkinId() {
        return 876462411;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 390.5, 75, 216.5, 120, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§b§lSkyCloud §e[1.15]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("skycloud") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skycloud");
    }
}
