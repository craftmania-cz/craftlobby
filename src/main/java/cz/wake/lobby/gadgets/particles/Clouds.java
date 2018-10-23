package cz.wake.lobby.gadgets.particles;

import cz.craftmania.craftcore.spigot.utils.effects.UtilParticles;
import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Clouds {

    public static final HashMap<String, Integer> c = new HashMap();
    public static int task11;

    @SuppressWarnings("deprecation")
    public void activateClouds(Player p) {
        if (!c.containsKey(p.getName())) {
            task11 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (c.containsKey(p.getName()) && p.isOnline()) {
                        UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.CLOUD, 0, 0, 0.7f, 1f, 0.7f, 0, 5);
                    }
                }

            }, 0L, 4L).getTaskId();
            c.put(p.getName(), Integer.valueOf(task11));
        }
    }
}
