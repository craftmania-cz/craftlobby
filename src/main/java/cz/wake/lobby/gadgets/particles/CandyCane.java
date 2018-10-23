package cz.wake.lobby.gadgets.particles;

import cz.craftmania.craftcore.spigot.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class CandyCane {

    public static final HashMap<String, Integer> cd = new HashMap();
    public static int task2;
    private int step = 0;
    private static Random random = new Random();

    @SuppressWarnings("deprecation")
    public void activate(Player p) {
        if (!cd.containsKey(p.getName())) {
            task2 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (cd.containsKey(p.getName()) && p.isOnline()) {
                        if (step > 360)
                            step = 0;
                        Location center = p.getEyeLocation().add(0, 0.6, 0);
                        double inc = (2 * Math.PI) / 20;
                        double angle = step * inc;
                        double x = Math.cos(angle) * 1.1f;
                        double z = Math.sin(angle) * 1.1f;
                        center.add(x, 0, z);
                        for (int i = 0; i < 15; i++)
                            ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.INK_SACK, getRandomColor()), 0.2f, 0.2f, 0.2f, 0, 1, center, SettingsMenu.particles);
                        step++;
                    }

                }

            }, 0L, 1L).getTaskId();
            cd.put(p.getName(), Integer.valueOf(task2));
        }
    }

    public static byte getRandomColor() {
        float f = random.nextFloat();
        if (f > 0.98)
            return (byte) 2;
        else if (f > 0.49)
            return (byte) 1;
        else
            return (byte) 15;
    }

}
