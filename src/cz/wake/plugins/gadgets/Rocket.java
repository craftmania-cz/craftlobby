package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Rocket implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    private HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    private static Random random = new Random();
    private static final List<Block> BLOCKS = new ArrayList<>();
    private boolean launching;
    private ArmorStand armorStand;
    private List<FallingBlock> fallingBlocks = new ArrayList<>();

    private Main plugin;

    public Rocket(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPee(PlayerInteractEvent e) {
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
        if (!item.getItemMeta().getDisplayName().contains("Rocket")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.rocket")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(40D + 0.1D));

            player.setVelocity(new Vector(0, 1, 0));
            final Location loc = player.getLocation();
            loc.setX(loc.getBlockX() + 0.5);
            loc.setY(loc.getBlockY());
            loc.setZ(loc.getBlockZ() + 0.5);
            final int task = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                for (int i = 0; i < 2; i++) {
                    Block b1 = loc.clone().add(1, i, 0).getBlock();
                    Block b2 = loc.clone().add(-1, i, 0).getBlock();
                    Block b3 = loc.clone().add(0, i, 1).getBlock();
                    Block b4 = loc.clone().add(0, i, -1).getBlock();
                    Block b5 = loc.clone().add(0, i + 1, 0).getBlock();
                    b1.setType(Material.FENCE);
                    b2.setType(Material.FENCE);
                    b3.setType(Material.FENCE);
                    b4.setType(Material.FENCE);
                    b5.setType(Material.QUARTZ_BLOCK);
                    BLOCKS.add(b1);
                    BLOCKS.add(b2);
                    BLOCKS.add(b3);
                    BLOCKS.add(b4);
                    BLOCKS.add(b5);
                }
                armorStand = loc.getWorld().spawn(loc.add(0, 1.5, 0), ArmorStand.class);
                armorStand.setVisible(false);
                armorStand.setGravity(false);
            }, 10).getTaskId();
            final int task4 = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    armorStand.setPassenger(player);
                    final int task3 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                        int i = 5;
                        @Override
                        public void run() {
                            if (i > 0) {
                                player.sendTitle("§c§l" + i, "");
                                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0f, 1.0f);
                                ParticleEffect.SMOKE_LARGE.display(0.3f, 0.2f, 0.3f, 0.0F, 20, player.getLocation().add(0, -3, 0), 15.0D);
                                i--;
                            } else {

                                player.sendTitle("§e§lSTART", "");
                                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                                armorStand.remove();
                                armorStand = null;


                                for (Block block : BLOCKS) {
                                    block.setType(Material.AIR);
                                }

                                BLOCKS.clear();

                                final FallingBlock top = player.getWorld().spawnFallingBlock(player.getLocation().add(0, 3, 0), Material.QUARTZ_BLOCK, (byte) 0);
                                FallingBlock base = player.getWorld().spawnFallingBlock(player.getLocation().add(0, 2, 0), Material.QUARTZ_BLOCK, (byte) 0);
                                for (int i = 0; i < 2; i++) {
                                    FallingBlock fence1 = player.getWorld().spawnFallingBlock(player.getLocation().add(0, 1 + i, 1), Material.FENCE, (byte) 0);
                                    FallingBlock fence2 = player.getWorld().spawnFallingBlock(player.getLocation().add(0, 1 + i, -1), Material.FENCE, (byte) 0);
                                    FallingBlock fence3 = player.getWorld().spawnFallingBlock(player.getLocation().add(1, 1 + i, 0), Material.FENCE, (byte) 0);
                                    FallingBlock fence4 = player.getWorld().spawnFallingBlock(player.getLocation().add(-1, 1 + i, 0), Material.FENCE, (byte) 0);
                                    fallingBlocks.add(fence1);
                                    fallingBlocks.add(fence2);
                                    fallingBlocks.add(fence3);
                                    fallingBlocks.add(fence4);
                                }

                                fallingBlocks.add(top);
                                fallingBlocks.add(base);
                                if (fallingBlocks.get(8).getPassenger() == null)
                                    fallingBlocks.get(8).setPassenger(player);
                                top.setPassenger(player);
                                launching = true;

                                final int task2 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                                    @Override
                                    public void run() {
                                        if (armorStand != null) {
                                            if (armorStand.getPassenger() == null)
                                                armorStand.setPassenger(player);
                                            player.playSound(armorStand.getLocation().clone().add(0, -3, 0), Sound.BLOCK_FIRE_EXTINGUISH, 1.0f, 1.0f);
                                        }
                                        for (FallingBlock fallingBlock : fallingBlocks) {
                                            fallingBlock.setVelocity(new Vector(0, 0.8, 0));
                                        }
                                        if (launching) {
                                            player.sendTitle("", "");
                                            if (fallingBlocks.get(8).getPassenger() == null) {
                                                fallingBlocks.get(8).setPassenger(player);
                                            }
                                            ParticleEffect.FLAME.display(0.3f, 0.2f, 0.3f, 0.0F, 20, player.getLocation().add(0, -3, 0), 15.0D);
                                            ParticleEffect.LAVA.display(0.3f, 0.2f, 0.3f, 0.0F, 20, player.getLocation().add(0, -3, 0), 15.0D);
                                            player.playSound(fallingBlocks.get(9).getLocation().clone().add(0, -1, 0), Sound.BLOCK_FIRE_EXTINGUISH, 1.0f, 1.0f);
                                            player.playSound(fallingBlocks.get(9).getLocation().clone().add(0, -1, 0), Sound.ENTITY_BAT_LOOP, 1.0f, 1.0f);
                                        }
                                    }
                                }, 0L, 2L).getTaskId();

                                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                                    fallingBlocks.forEach(Entity::remove);
                                    fallingBlocks.clear();
                                    //FallDamageManager.addNoFall(getPlayer());
                                    Bukkit.getScheduler().cancelTask(task2);
                                    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                                    ParticleEffect.EXPLOSION_HUGE.display(0.3f, 0.2f, 0.3f, 0.0F, 20, player.getLocation().add(0, -3, 0), 15.0D);
                                    launching = false;
                                }, 160);
                            }
                        }
                    }, 0L, 20L).getTaskId();
                    final int cancelTask = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.getScheduler().cancelTask(task3);
                        }
                    }, 120L).getTaskId();
                }
            },12L).getTaskId();

            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    for (Block block : BLOCKS)
                        block.setType(Material.AIR);
                    for (FallingBlock fallingBlock : fallingBlocks)
                        fallingBlock.remove();
                    BLOCKS.clear();
                    fallingBlocks.clear();
                    if (armorStand != null)
                        armorStand.remove();
                    launching = false;
                    player.sendTitle(" ", "");
                }
            }, 400L);

            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    Rocket.this._time.put(player, Double.valueOf(((Double) Rocket.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) Rocket.this._time.get(player)).doubleValue() < 0.01D) {
                        Rocket.this._time.remove(player);
                        Rocket.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }


    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
