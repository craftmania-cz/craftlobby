package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilBlock;
import cz.wake.plugins.utils.UtilMath;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmashDown implements Listener {

    private Main plugin;

    public SmashDown(Main plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    List<Player> activePlayers = new ArrayList();
    List<FallingBlock> fallingBlocks = new ArrayList();

    @EventHandler
    public void smashDown(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.FIREWORK_CHARGE)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("SmashDown")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.smashdown")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(15D + 0.1D));

            player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_LAUNCH, 2, 1);
            player.setVelocity(new Vector(0, 3, 0));
            final int taskId = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                @Override
                public void run() {
                    ParticleEffect.CLOUD.display(0.5F, 0.5F, 0.5F, 0.0F, 1, player.getLocation(), 10.0D);
                }
            }, 0, 1).getTaskId();
            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(taskId);
                    player.setVelocity(new Vector(0, -3, 0));
                    activePlayers.add(player);
                }
            }, 25);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    SmashDown.this._time.put(player, Double.valueOf(((Double) SmashDown.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) SmashDown.this._time.get(player)).doubleValue() < 0.01D) {
                        SmashDown.this._time.remove(player);
                        SmashDown.this._cdRunnable.remove(player);
                        //activePlayers.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }

    }

    private void playBoomEffect(Entity entity) {
        final Location loc = entity.getLocation();
        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 2, 1);
        new BukkitRunnable() {
            int i = 1;

            @Override
            public void run() {
                if (i == 5) {
                    cancel();
                }
                for (Block b : UtilBlock.getBlocksInRadius(loc.clone().add(0, -1, 0), i, true)) {
                    if (b.getLocation().getBlockY() == loc.getBlockY() - 1) {
                        if (b.getType() != Material.AIR
                                && b.getType() != Material.SIGN_POST
                                && b.getType() != Material.CHEST
                                && b.getType() != Material.STONE_PLATE
                                && b.getType() != Material.WOOD_PLATE
                                && b.getType() != Material.WALL_SIGN
                                && b.getType() != Material.WALL_BANNER
                                && b.getType() != Material.STANDING_BANNER
                                && b.getType() != Material.CROPS
                                && b.getType() != Material.LONG_GRASS
                                && b.getType() != Material.SAPLING
                                && b.getType() != Material.DEAD_BUSH
                                && b.getType() != Material.RED_ROSE
                                && b.getType() != Material.RED_MUSHROOM
                                && b.getType() != Material.BROWN_MUSHROOM
                                && b.getType() != Material.TORCH
                                && b.getType() != Material.LADDER
                                && b.getType() != Material.VINE
                                && b.getType() != Material.DOUBLE_PLANT
                                && b.getType() != Material.PORTAL
                                && b.getType() != Material.CACTUS
                                && b.getType() != Material.WATER
                                && b.getType() != Material.STATIONARY_WATER
                                && b.getType() != Material.LAVA
                                && b.getType() != Material.STATIONARY_LAVA
                                && b.getType() != Material.LEAVES
                                && b.getType() != Material.LEAVES_2
                                && b.getType() != Material.QUARTZ_STAIRS
                                && b.getType() != Material.QUARTZ_BLOCK
                                && net.minecraft.server.v1_9_R2.Block.getByCombinedId(b.getTypeId()).getMaterial().isSolid()
                                && b.getType().getId() != 43
                                && b.getType().getId() != 44) {
                            FallingBlock fb = loc.getWorld().spawnFallingBlock(b.getLocation().clone().add(0, 1.1f, 0), b.getType(), b.getData());
                            fb.setVelocity(new Vector(0, 0.3f, 0));
                            fb.setDropItem(false);
                            fallingBlocks.add(fb);
                            for (Entity ent : fb.getNearbyEntities(1, 1, 1)) {
                                if (ent != entity && ent.getType() != EntityType.FALLING_BLOCK)
                                    UtilMath.applyVector(ent, new Vector(0, 0.5, 0));
                            }
                        }
                    }
                }
                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    @EventHandler
    private void onBlockChangeState(EntityChangeBlockEvent event) {
        if (fallingBlocks.contains(event.getEntity())) {
            event.setCancelled(true);
            fallingBlocks.remove(event.getEntity());
            FallingBlock fb = (FallingBlock) event.getEntity();
            fb.getWorld().spigot().playEffect(fb.getLocation(), Effect.STEP_SOUND, fb.getBlockId(), (int) fb.getBlockData(), 0, 0, 0, 0, 1, 32);
            event.getEntity().remove();
        }
    }

    @EventHandler
    private void onEntityDamage(EntityDamageEvent event) {
        if (activePlayers.contains(event.getEntity()))
            event.setCancelled(true);
        if (activePlayers.contains(event.getEntity()) && event.getEntity().isOnGround()) {
            event.setCancelled(true);
            activePlayers.remove(event.getEntity());
            playBoomEffect(event.getEntity());
        }
    }


    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
