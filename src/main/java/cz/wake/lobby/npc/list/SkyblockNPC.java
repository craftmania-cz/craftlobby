package cz.wake.lobby.npc.list;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SkyblockNPC implements IServerNPC {

    @Override
    public String getId() {
        return "skyblock";
    }

    @Override
    public int getSkinId() {
        return 861102411;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 388.5, 75, 205.5, 53, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§b§lSkyblock §e[1.12]");
        list.add("§f" + Main.getInstance().getSQL().getOnlinePlayers("skyblock") +" §7hráčů");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock");
    }
}
