package cz.wake.lobby.gadgets.particles;

import cz.craftmania.craftcore.spigot.utils.effects.UtilParticles;
import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class EnderSignal {

    public static final HashMap<String, Integer> es = new HashMap();
    public static int task7;

    @SuppressWarnings("deprecation")
    public void activateSignal(Player p) {
        if (!es.containsKey(p.getName())) {
            task7 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (es.containsKey(p.getName()) && p.isOnline()) {
                        UtilParticles.play(p.getLocation().add(0, 1.5, 0), Effect.ENDER_SIGNAL);
                    }
                }
            }, 0L, 2L).getTaskId();
            es.put(p.getName(), Integer.valueOf(task7));
        }
    }
}
