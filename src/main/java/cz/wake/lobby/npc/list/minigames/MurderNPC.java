package cz.wake.lobby.npc.list.minigames;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.IServerNPC;
import cz.wake.lobby.npc.NPCManager;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MurderNPC implements IServerNPC {

    @Override
    public String getId() {
        return "murder";
    }

    @Override
    public int getSkinId() {
        return 1045101919;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("obw2"), -599.5, 111.0, 105.5, 8, 4);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§c§lMurder");
        Main.getInstance().getCraftBalancerManager().getSectionPlayerCount("murder", pocet -> {
            list.add(NPCManager.formatOnlinePlayers(pocet));
        });
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        Main.getInstance().getCraftBalancerManager().connectPlayer(player, "murder");
    }
}
