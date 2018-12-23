package cz.wake.lobby.seasons.christmas;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.Random;

public class SilvesterTask {

    public static int delay = 1; // seconds
    static Random r = new Random();

    public static FireworkEffect getRandomFireworkEffect() {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).build();
        return effect;
    }

    public static void spawnRandomFirework(Location location) {

        final ArrayList<Firework> fireworks = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Firework f = (Firework) location.getWorld().spawn(location, Firework.class);
            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(getRandomFireworkEffect());
            f.setFireworkMeta(fm);
            fireworks.add(f);
        }
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            public void run() {
                for (Firework f : fireworks) {
                    f.detonate();
                }
            }
        }, 2L);
    }

    public static void runLauncher() {

        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                int ranX = r.nextInt(1602 - 1481 + 1) + 1481;
                int ranY = r.nextInt(85 - 40 + 1) + 40;
                int ranZ = r.nextInt(-1175 - -1300 + 1) + -1300;

                Location loc5 = new Location(Bukkit.getWorld("omain"), ranX, ranY, ranZ);
                spawnRandomFirework(loc5);
            }

        }, 0L, 13);
    }
}
