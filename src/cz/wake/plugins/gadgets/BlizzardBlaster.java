package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilMath;
import net.minecraft.server.v1_10_R1.Block;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BlizzardBlaster implements Listener {

    private Main plugin;

    public BlizzardBlaster(Main plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    Random r = new Random();
    List<Entity> cooldownJump = new ArrayList();
    List<ArmorStand> armorStands = new ArrayList();

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
        if (!player.hasPermission("craftlobby.gadgets.blizzardblaster")) {
            return;
        }
        if (!item.getType().equals(Material.PACKED_ICE)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("BlizzardBlaster")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(30D + 0.1D));

            final Vector v = player.getLocation().getDirection().normalize().multiply(0.3);
            v.setY(0);
            final Location loc = player.getLocation().subtract(0, 1, 0).add(v);
            final int i = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                @Override
                public void run() {
                    if (loc.getBlock().getType() != Material.AIR
                            && Block.getByCombinedId(loc.getBlock().getTypeId()).getMaterial().isSolid()) {
                        loc.add(0, 1, 0);
                    }
                    if (loc.clone().subtract(0, 1, 0).getBlock().getType() == Material.AIR) {
                        if (loc.clone().getBlock().getTypeId() != 43 && loc.clone().getBlock().getTypeId() != 44)
                            loc.add(0, -1, 0);
                    }
                    for (int i = 0; i < 5; i++) {
                        final ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc.clone().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(0, .5) - 0.75, UtilMath.randomDouble(-1.5, 1.5)), EntityType.ARMOR_STAND);
                        as.setSmall(true);
                        as.setVisible(false);
                        as.setGravity(false);
                        as.setHelmet(new ItemStack(Material.PACKED_ICE));
                        as.setHeadPose(new EulerAngle(r.nextInt(50), r.nextInt(50), r.nextInt(50)));
                        armorStands.add(as);
                        loc.getWorld().spigot().playEffect(loc.clone().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(0, .5) - 0.75, UtilMath.randomDouble(-1.5, 1.5)), Effect.CLOUD, 0, 0, 0.5f, 0.5f, 0.5f, 0.4f, 2
                                , 32);
                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                armorStands.remove(as);
                                as.remove();
                            }
                        }, 20);
                        for (final Entity ent : as.getNearbyEntities(0.5, 0.5, 0.5)) {
                            if ((!cooldownJump.contains(ent)) && (ent != player) && (!(ent instanceof ArmorStand))) {
                                UtilMath.applyVector(ent, new Vector(0, 1, 0).add(v));
                                cooldownJump.add(ent);
                                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        cooldownJump.remove(ent);
                                    }
                                }, 20);
                            }
                        }
                    }
                    loc.add(v);
                }
            }, 0, 1).getTaskId();

            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(i);
                }
            }, 40);

            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    BlizzardBlaster.this._time.put(player, Double.valueOf(((Double) BlizzardBlaster.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) BlizzardBlaster.this._time.get(player)).doubleValue() < 0.01D) {
                        BlizzardBlaster.this._time.remove(player);
                        BlizzardBlaster.this._cdRunnable.remove(player);
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
