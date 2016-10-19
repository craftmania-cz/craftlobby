package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilMath;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Parachute implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    java.util.HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static Random random = new Random();
    List<Chicken> chickens = new ArrayList<>();
    boolean active;

    private Main plugin;

    public Parachute(Main plugin) {
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
        if (!item.getType().equals(Material.LEASH)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("Parachute")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.parachute")) {
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

            Location loc = player.getLocation();
            player.teleport(loc.clone().add(0, 35, 0));
            player.setVelocity(new Vector(0, 0, 0));
            for (int i = 0; i < 20; i++) {
                Chicken chicken = (Chicken) player.getWorld().spawnEntity(player.getLocation().add(UtilMath.randomDouble(0, 0.5), 3, UtilMath.randomDouble(0, 0.5)), EntityType.CHICKEN);
                chickens.add(chicken);
                chicken.setLeashHolder(player);
            }
            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    active = true;
                }
            }, 5);

            Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (active) {
                        if (!player.isOnGround() && player.getVelocity().getY() < -0.3) {
                            UtilMath.applyVelocity(player, player.getVelocity().add(new Vector(0, 0.1, 0)));
                        }
                        if (player.isOnGround()) {
                            killParachute(player);
                        }
                    }
                }
            }, 0L, 1L);


            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    Parachute.this._time.put(player, Double.valueOf(((Double) Parachute.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) Parachute.this._time.get(player)).doubleValue() < 0.01D) {
                        Parachute.this._time.remove(player);
                        Parachute.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }

    }

    @EventHandler
    public void onLeashBreak(EntityUnleashEvent event) {
        if (chickens.contains(event.getEntity())) {
            event.getEntity().getNearbyEntities(1, 1, 1).stream().filter(ent -> ent instanceof Item
                    && ((Item) ent).getItemStack().getType() == Material.LEASH).forEachOrdered(Entity::remove);
        }
    }

    private void killParachute(Player player) {
        for (Chicken chicken : chickens) {
            chicken.setLeashHolder(null);
            chicken.remove();
        }
        UtilMath.applyVelocity(player, new Vector(0, 0.15, 0));
        active = false;
    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }
}
