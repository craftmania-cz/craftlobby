package cz.wake.plugins.gadgets;

import cz.wake.plugins.API.CustomEntityFirework;
import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class WitherCatapult implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    private Main plugin;

    public WitherCatapult(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWither(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.COAL)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("WitherCatapult")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.withercatapult")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(25D + 0.1D));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH, 1.0F, 1.0F);
            for (Entity e1 : player.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
                if ((e1 instanceof Player)) {
                    Player p = (Player) e1;
                    p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 1.0F, 1.0F);
                }
            }
            final int task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    final WitherSkull wSkull = (WitherSkull) player.launchProjectile(WitherSkull.class);
                    wSkull.setShooter(player);
                    wSkull.setVelocity(UtilMath.getRandomVector());
                    wSkull.setMetadata("WITHERCATAPULT", new FixedMetadataValue(Main.getPlugin(), ""));
                    wSkull.setBounce(true);
                    ParticleEffect.SUSPENDED_DEPTH.display(2.0F, 2.0F, 2.0F, 0.0F, 20, player.getLocation(), 15.0D);
                    Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                        public void run() {
                            if (wSkull.isValid()) {
                                LaunchRandomFirework(wSkull.getLocation());
                                wSkull.remove();
                            }
                        }
                    }, 13L);
                }
            }, 10L, 8L).getTaskId();
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(task);
                }
            }, 240L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    WitherCatapult.this._time.put(player, Double.valueOf(((Double) WitherCatapult.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) WitherCatapult.this._time.get(player)).doubleValue() < 0.01D) {
                        WitherCatapult.this._time.remove(player);
                        WitherCatapult.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if (e.getEntity().hasMetadata("WITHERCATAPULT")) {
            LaunchRandomFirework(e.getEntity().getLocation());
        }
        e.setCancelled(true);
    }

    private static double arrondi(double A, int B) {

        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

    public void LaunchRandomFirework(Location location) {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        if (RandomUtils.nextInt(3) == 0) {
            builder.withTrail();
        } else if (RandomUtils.nextInt(2) == 0) {
            builder.withFlicker();
        }
        builder.with(FireworkEffect.Type.BURST);

        int colorCount = 17;

        builder.withColor(Color.BLACK);
        while (RandomUtils.nextInt(colorCount) != 0) {
            builder.withColor(Color.BLACK);
            colorCount--;
        }
        FireworkEffect effect = builder.build();
        CustomEntityFirework.spawn(location, effect, new Player[0]);
    }


}
