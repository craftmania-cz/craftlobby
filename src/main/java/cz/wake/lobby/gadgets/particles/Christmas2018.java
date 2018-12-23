package cz.wake.lobby.gadgets.particles;

import com.google.common.base.Preconditions;
import com.sun.scenario.Settings;
import cz.craftmania.craftcore.spigot.utils.effects.ParticleEffect;
import cz.craftmania.craftcore.spigot.utils.effects.UtilParticles;
import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Christmas2018 implements Listener {

    public static final HashMap<String, Integer> sh = new HashMap();
    public static int task17;
    public int particles = 12;

    public void activate(Player p) {
        if (!sh.containsKey(p.getName())) {
            task17 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                boolean up;
                float height;
                int step;
                @Override
                public void run() {
                    if (sh.containsKey(p.getName()) && p.isOnline()) {
                        if (up) {
                            if (height < 2)
                                height += 0.05;
                            else
                                up = false;
                        } else {
                            if (height > 0)
                                height -= 0.05;
                            else
                                up = true;
                        }
                        double inc = (2 * Math.PI) / 100;
                        double angle = step * inc;
                        Vector v = new Vector();
                        v.setX(Math.cos(angle) * 1.1);
                        v.setZ(Math.sin(angle) * 1.1);
                        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(255, 0, 0), p.getLocation().clone().add(v).add(0, height, 0), SettingsMenu.particles);
                        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(255, 255, 255), p.getLocation().clone().subtract(v).add(0, height, 0), SettingsMenu.particles);
                        step += 4;
                    }

                }
            }, 0L, 1L).getTaskId();
            sh.put(p.getName(), Integer.valueOf(task17));
        }
    }

    public Location getRandomLocation(Location loc1, Location loc2) {
        Preconditions.checkArgument(loc1.getWorld() == loc2.getWorld());
        double minX = Math.min(loc1.getX(), loc2.getX());
        double minY = Math.min(loc1.getY(), loc2.getY());
        double minZ = Math.min(loc1.getZ(), loc2.getZ());

        double maxX = Math.max(loc1.getX(), loc2.getX());
        double maxY = Math.max(loc1.getY(), loc2.getY());
        double maxZ = Math.max(loc1.getZ(), loc2.getZ());

        return new Location(loc1.getWorld(), randomDouble(minX, maxX), randomDouble(minY, maxY), randomDouble(minZ, maxZ));
    }

    public double randomDouble(double min, double max) {
        return min + ThreadLocalRandom.current().nextDouble(Math.abs(max - min + 1));
    }
}
