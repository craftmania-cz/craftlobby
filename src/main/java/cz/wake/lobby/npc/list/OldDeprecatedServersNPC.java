package cz.wake.lobby.npc.list;

import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.wake.lobby.gui.DeprecatedServersGUI;
import cz.wake.lobby.npc.IServerNPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class OldDeprecatedServersNPC implements IServerNPC {

    @Override
    public String getId() {
        return "deprecated_servers";
    }

    @Override
    public int getSkinId() {
        return 10978463;
    }

    @Override
    public Location getLocation() {
        return new Location(Bukkit.getWorld("lobby_4"), 384.5, 75, 220.5, 142, 0);
    }

    @Override
    public List<String> getHologramLines() {
        List<String> list = new ArrayList<>();
        list.add("§3§lStaré servery");
        list.add("§7Servery, které se brzy smažou");
        return list;
    }

    @Override
    public void onClick(Player player, NPCInteractEvent.ClickType clickType) {
        SmartInventory.builder().size(6, 9).title("Staré servery").provider(new DeprecatedServersGUI()).build().open(player);
    }
}
