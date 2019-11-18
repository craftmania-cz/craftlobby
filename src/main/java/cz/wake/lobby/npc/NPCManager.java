package cz.wake.lobby.npc;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.list.*;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.skin.MineSkinFetcher;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class NPCManager {

    private static List<IServerNPC> npcList = new ArrayList<>();
    private final SortedSet<String> ids = new TreeSet<>();

    public void loadNpcs() {
        npcList.add(new SurvivalNPC());
        npcList.add(new SkyblockNPC());
        npcList.add(new OldDeprecatedServersNPC());
        npcList.add(new GoldenPigNPC());
        npcList.add(new CreativeNPC());
        npcList.add(new EventServerNPC());
        npcList.add(new TutorialNPC());
        npcList.add(new VanillaNPC());
    }

    public void spawnForPlayer(final Player player) {
        for (IServerNPC npc : npcList) {
            MineSkinFetcher.fetchSkinFromIdAsync(npc.getSkinId(), skin -> {
                NPC spawnNpc = Main.getInstance().getNpclib().createNPC(npc.getHologramLines());
                spawnNpc.setLocation(npc.getLocation());
                spawnNpc.setSkin(skin);
                spawnNpc.create();

                // Sync zobrazení hráči
                Bukkit.getScheduler().runTask(Main.getInstance(), () -> spawnNpc.show(player));

                // Fix duplikací ID (debilní API)
                if (ids.size() <= npcList.size()) {
                    if (ids.contains(spawnNpc.getId())) return;
                    ids.add(spawnNpc.getId());
                }
            });
        }
    }

    public void despawnNpc() {

    }

    public List<IServerNPC> getNpcList() {
        return npcList;
    }
}
