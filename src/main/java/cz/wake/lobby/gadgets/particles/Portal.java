package cz.wake.lobby.gadgets.particles;

import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Portal {

    public static final HashMap<String, Integer> port = new HashMap();
    public static int task14;

    @SuppressWarnings("deprecation")
    public void activatePortal(Player p) {
        if (!port.containsKey(p.getName())) {
            task14 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (port.containsKey(p.getName()) && p.isOnline()) {
                        ParticleEffect.PORTAL.display(1.0F, 1.0F, 1.0F, 0.0F, 20, p.getLocation(), SettingsMenu.particles);
                    }
                }

            }, 0L, 4L).getTaskId();
            port.put(p.getName(), Integer.valueOf(task14));
        }
    }
}
