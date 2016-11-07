package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.UtilParticles;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class WakeArmy implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    Map<Bat, ArmorStand> bats = new HashMap();

    private Main plugin;

    public WakeArmy(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGhosting(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.DIAMOND)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("WakeArmy")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.wakearmy")) {
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
            for (int i = 0; i < 20; i++) {
                Bat bat = player.getWorld().spawn(player.getLocation().add(0, 1, 0), Bat.class);
                ArmorStand ghost = bat.getWorld().spawn(bat.getLocation(), ArmorStand.class);
                ghost.setSmall(true);
                ghost.setGravity(false);
                ghost.setVisible(false);
                ghost.setHelmet(ItemFactory.createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0="));
                bat.setPassenger(ghost);
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 160, 1));
                bats.put(bat, ghost);
            }
            final int i = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (!bats.isEmpty()) {
                        for (Bat bat : bats.keySet()) {
                            if (!bat.isDead()) {
                                UtilParticles.play(bat.getLocation().add(0, 1.5, 0), Effect.FIREWORKS_SPARK, 0, 0, 0.05f, 0.05f, 0.05f, 0.02f, 1);
                            }
                        }
                    }
                }
            }, 0L, 3L).getTaskId();

            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    killBats();
                    Bukkit.getScheduler().cancelTask(i);
                }
            }, 160);

            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    WakeArmy.this._time.put(player, Double.valueOf(((Double) WakeArmy.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) WakeArmy.this._time.get(player)).doubleValue() < 0.01D) {
                        WakeArmy.this._time.remove(player);
                        WakeArmy.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }
    }

    @EventHandler
    public void onPlayerInteractGhost(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() != null && event.getRightClicked().getVehicle() != null
                && bats.containsKey(event.getRightClicked().getVehicle()))
            event.setCancelled(true);
    }

    private void killBats() {
        for (Bat bat : bats.keySet()) {
            bats.get(bat).remove();
            bat.remove();
        }
        bats.clear();
    }

    public void clear() {
        killBats();
    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
