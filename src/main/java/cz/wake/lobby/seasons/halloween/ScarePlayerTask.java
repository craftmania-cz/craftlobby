package cz.wake.lobby.seasons.halloween;

import cz.craftmania.craftcore.utils.PlayerUtils;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilMath;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ScarePlayerTask implements Runnable {

    @Override
    public void run() {
        this.runEffect(PlayerUtils.getInstance().getRandomPlayer());
    }

    private void runEffect(final Player player) {
        try {
            final int nextInt = UtilMath.randomRangeInt(0,5);
            if (nextInt == 0) {
                player.playSound(player.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1.0f, 1.0f);
            }
            else if (nextInt == 1) {
                player.playSound(player.getLocation(), Sound.ENTITY_WITCH_AMBIENT, 1.0f, 1.0f);
            }
            else if (nextInt == 2) {
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);
            }
            else if (nextInt == 3) {
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1.0f, 1.0f);
            }
            else if (nextInt == 4) {
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0f, 1.0f);
            }
            if (nextInt == 5) {
                this.runLightningEffects(player);
            }
        } catch (Exception e) {
            // BRUH
        }
    }

    private void runLightningEffects(final Player player) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(),
                () -> player.getWorld().strikeLightningEffect(player.getEyeLocation().add(0.0, 2.0, 0.0)), 20L);
    }
}
