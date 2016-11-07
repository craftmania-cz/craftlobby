package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

public class TNTBomb implements Listener {

    private Main plugin;

    public TNTBomb(Main plugin) {
        this.plugin = plugin;
    }

    private ArrayList<TNTPrimed> _tnt = new ArrayList();
    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    @EventHandler
    public void onExplosion(EntityExplodeEvent e) {
        if (!(e.getEntity() instanceof TNTPrimed)) {
            return;
        }
        if (!this._tnt.contains(e.getEntity())) {
            return;
        }
        this._tnt.remove(e.getEntity());
        e.setCancelled(true);
        for (Entity ent : e.getEntity().getNearbyEntities(6.0D, 6.0D, 6.0D)) {
            if ((ent instanceof Player)) {
                if (ent.hasMetadata("NPC")) {
                    e.setCancelled(true);
                } else {
                    double dX = e.getEntity().getLocation().getX() - ent.getLocation().getX();
                    double dY = e.getEntity().getLocation().getY() - ent.getLocation().getY();
                    double dZ = e.getEntity().getLocation().getZ() - ent.getLocation().getZ();
                    double yaw = Math.atan2(dZ, dX);
                    double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + 3.141592653589793D;
                    double X = Math.sin(pitch) * Math.cos(yaw);
                    double Y = Math.sin(pitch) * Math.sin(yaw);
                    double Z = Math.cos(pitch);

                    Vector vector = new Vector(X, Z, Y);
                    ent.setVelocity(vector.multiply(1.321483642374632D).add(new Vector(0.0D, 1.4397268432482635D, 0.0D)));

                    ParticleEffect.EXPLOSION_LARGE.display(2.0F, 2.0F, 2.0F, 0.0F, 110, ent.getLocation(), 15.0D);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if ((e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) &&
                (Bukkit.getPluginManager().getPlugin("HGPLUSMWAddon") == null)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void ShootTnt(PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        ItemStack item = event.getItem();
        Action action = event.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.TNT)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("TNT")) {
            return;
        }
        if (!p.hasPermission("craftlobby.gadgets.tnt")) {
            return;
        }
        event.setCancelled(true);
        p.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(p)) {
                MessagesListener.messageCooldown(p, String.valueOf(arrondi(((Double) this._time.get(p)).doubleValue(), 1)));
                return;
            }
            TNTPrimed tnt = (TNTPrimed) p.getWorld().spawn(p.getLocation().add(0.0D, 2.0D, 0.0D), TNTPrimed.class);

            tnt.setVelocity(p.getLocation().getDirection().multiply(0.854321D));
            this._tnt.add(tnt);
            tnt.setMetadata("TNT_HGPLUS", new FixedMetadataValue(this.plugin, "WHATHERE?"));
            this._time.put(p, 35D + 0.1D);
            this._cdRunnable.put(p, new BukkitRunnable() {
                @Override
                public void run() {
                    TNTBomb.this._time.put(p, Double.valueOf(((Double) TNTBomb.this._time.get(p)).doubleValue() - 0.1D));
                    if (((Double) TNTBomb.this._time.get(p)).doubleValue() < 0.01D) {
                        TNTBomb.this._time.remove(p);
                        TNTBomb.this._cdRunnable.remove(p);
                        cancel();
                    }
                }
            });
            ((BukkitRunnable) this._cdRunnable.get(p)).runTaskTimer(this.plugin, 2L, 2L);
        }
    }


    public static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
