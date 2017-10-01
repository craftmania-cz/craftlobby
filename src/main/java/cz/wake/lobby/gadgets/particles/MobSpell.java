package cz.wake.lobby.gadgets.particles;

import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class MobSpell {

    public static final HashMap<String, Integer> ms = new HashMap();
    public static int task15;

    @SuppressWarnings("deprecation")
    public void activateSpell(Player p) {
        if (!ms.containsKey(p.getName())) {
            task15 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {

                @Override
                public void run() {
                    if (ms.containsKey(p.getName()) && p.isOnline()) {
                        ParticleEffect.SPELL_MOB.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), SettingsMenu.particles);
                    }
                }
            }, 0L, 1L).getTaskId();
            ms.put(p.getName(), Integer.valueOf(task15));
        }
    }
}
