package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class DiscoBall implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static Random random = new Random();

    private Main plugin;

    public DiscoBall(Main plugin) {
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
        if (!item.getType().equals(Material.STAINED_GLASS)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("DiscoBall")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.discoball")) {
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
            final Location localLocation = player.getLocation().add(0.0D, 5.0D, 0.0D);
            if (!localLocation.getBlock().isEmpty()) {
                player.sendMessage("�cNad tebou musi byt misto!");
                return;
            }
            new BukkitRunnable() {
                int step = 0;
                int step2 = 2;

                public void run() {
                    this.step += 1;
                    this.step2 += 1;
                    Iterator localIterator;
                    Player localPlayer;
                    if (this.step <= 75) {
                        for (localIterator = getPlayers(localLocation.getWorld()).iterator(); localIterator.hasNext(); ) {
                            localPlayer = (Player) localIterator.next();
                            localPlayer.sendBlockChange(localLocation, Material.STAINED_GLASS, (byte) getRandomInt(0, 15));
                        }
                        if (this.step2 == 3) {
                            ParticleEffect.FIREWORKS_SPARK.display(2.0F, 0.0F, 2.0F, 0.2F, 70, localLocation, 15.0D);
                            this.step2 = 0;
                        }
                    } else {
                        for (localIterator = getPlayers(localLocation.getWorld()).iterator(); localIterator.hasNext(); ) {
                            localPlayer = (Player) localIterator.next();
                            localPlayer.sendBlockChange(localLocation, Material.AIR, (byte) 0);
                        }
                        cancel();
                    }
                }
            }.runTaskTimer(plugin, 0L, 2L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    DiscoBall.this._time.put(player, Double.valueOf(((Double) DiscoBall.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) DiscoBall.this._time.get(player)).doubleValue() < 0.01D) {
                        DiscoBall.this._time.remove(player);
                        DiscoBall.this._cdRunnable.remove(player);
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

    public static List<Player> getPlayers(World paramWorld) {
        ArrayList localArrayList = new ArrayList();
        for (Entity localEntity : paramWorld.getEntities()) {
            if ((localEntity instanceof Player)) {
                localArrayList.add((Player) localEntity);
            }
        }
        return localArrayList;
    }

    public static int getRandomInt(int paramInt1, int paramInt2) {
        return random.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
    }
}
