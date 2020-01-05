package cz.wake.lobby.seasons.christmas;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilMath;
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
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            for (Firework f : fireworks) {
                f.detonate();
            }
        }, 2L);
    }

    public static void runLauncher() {

        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
            int ranX = UtilMath.random(299, 415);
            int ranY = UtilMath.random(100, 140);
            int ranZ = UtilMath.random(139, 295);

            Location loc5 = new Location(Bukkit.getWorld("lobby_4"), ranX, ranY, ranZ);
            spawnRandomFirework(loc5);
        }, 0L, 10);
    }
}
