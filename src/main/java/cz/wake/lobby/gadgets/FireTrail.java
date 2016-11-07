package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class FireTrail implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static Random random = new Random();

    private Main plugin;

    public FireTrail(Main plugin) {
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
        if (!item.getType().equals(Material.BLAZE_POWDER)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("FireTrail")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.firetrail")) {
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

            final ArrayList localArrayList = new ArrayList();
            final World localWorld = player.getWorld();

            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 240, 0));

            new BukkitRunnable() {
                int step = 0;

                @Override
                public void run() {
                    this.step += 1;
                    Location localLocation;
                    if (this.step <= 200) {
                        localLocation = player.getLocation().getBlock().getLocation();
                        if ((localLocation.getBlock().isEmpty()) && (!localArrayList.contains(localLocation)) && (player.isOnGround())) {
                            localLocation.getBlock().setType(Material.FIRE);
                            localArrayList.add(localLocation);
                        }
                        player.setFireTicks(0);
                    } else {
                        for (Iterator localIterator = localArrayList.iterator(); localIterator.hasNext(); ) {
                            localLocation = (Location) localIterator.next();
                            if (localLocation.getBlock().getType() == Material.FIRE) {
                                localLocation.getBlock().setType(Material.AIR);
                            }
                        }
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0L, 1L);

            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    FireTrail.this._time.put(player, Double.valueOf(((Double) FireTrail.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) FireTrail.this._time.get(player)).doubleValue() < 0.01D) {
                        FireTrail.this._time.remove(player);
                        FireTrail.this._cdRunnable.remove(player);
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
