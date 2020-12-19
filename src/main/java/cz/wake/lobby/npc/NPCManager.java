package cz.wake.lobby.npc;

import cz.wake.lobby.Main;
import cz.wake.lobby.npc.list.*;
import cz.wake.lobby.npc.list.minigames.BedWarsNPC;
import cz.wake.lobby.npc.list.minigames.MurderNPC;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.skin.MineSkinFetcher;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class NPCManager {

    private static List<IServerNPC> npcList = new ArrayList<>();
    private final SortedSet<String> ids = new TreeSet<>();

    public void loadNpcs() {
        if (Main.getInstance().getIdServer().equalsIgnoreCase("main")) {
            //npcList.add(new SurvivalNPC());
            //npcList.add(new SkyblockNPC());
            //npcList.add(new OldDeprecatedServersNPC());
            npcList.add(new GoldenPigNPC());
            npcList.add(new CreativeNPC());
            npcList.add(new EventServerNPC());
            npcList.add(new TutorialNPC());
            npcList.add(new VanillaNPC());
            npcList.add(new Survival_115NPC());
            //npcList.add(new MinigamesNPC());
            npcList.add(new SkyCloudNPC());
            npcList.add(new Skyblock115NPC());
            npcList.add(new HardcoreVanillaNPC());
            npcList.add(new Halloween2020NPC());
            npcList.add(new PrisonNPC());
        }
        if (Main.getInstance().getIdServer().equalsIgnoreCase("bedwars")) {
            npcList.add(new BedWarsNPC());
            npcList.add(new MurderNPC());
        }
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

    public static String formatOnlinePlayers(int players) {
        if (players >= 5) {
            return "§f" + players + " §7 hráčů";
        } else if (players >= 2) {
            return "§f" + players + " §7 hráči";
        } else if (players == 1) {
            return "§f1 §7 hráč";
        } else {
            return "§7Nikdo nehraje!";
        }
    }
}
