package cz.wake.lobby.gadgets.gadget;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.UtilMath;
import cz.wake.lobby.utils.UtilParticles;
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

public class Tsunami implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    Random r = new Random();
    List<Entity> cooldownJump = new ArrayList();
    List<ArmorStand> armorStands = new ArrayList();

    private Main plugin;

    public Tsunami(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTsunami(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.WATER_BUCKET)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("Tsunami")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.tsunami")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (Main.getInstance().getTPS() < 17) {
                player.sendMessage("§cServer je pretizeny, nelze pouzivat gadget!");
                return;
            }
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(25D + 0.1D));
            final Vector v = player.getLocation().getDirection().normalize().multiply(0.3D);
            v.setY(0);
            final Location loc = player.getLocation().subtract(0.0D, 1.0D, 0.0D).add(v);

            final int i = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                public void run() {
                    if ((loc.getBlock().getType() != org.bukkit.Material.AIR) &&
                            (Block.getByCombinedId(loc.getBlock().getTypeId()).getMaterial().isSolid())) {
                        loc.add(0.0D, 1.0D, 0.0D);
                    }
                    if (loc.clone().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == org.bukkit.Material.AIR) {
                        loc.add(0.0D, -1.0D, 0.0D);
                    }
                    final ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc.clone().add(UtilMath.randomDouble(-1.5D, 1.5D), UtilMath.randomDouble(0.0D, 0.5D) - 0.75D, UtilMath.randomDouble(-1.5D, 1.5D)), EntityType.ARMOR_STAND);
                    as.setSmall(true);
                    as.setVisible(false);
                    as.setGravity(false);
                    as.setHeadPose(new EulerAngle(Tsunami.this.r.nextInt(50), Tsunami.this.r.nextInt(50), Tsunami.this.r.nextInt(50)));
                    Tsunami.this.armorStands.add(as);
                    for (int i = 0; i < 5; i++) {
                        loc.getWorld().spigot().playEffect(loc.clone().add(UtilMath.randomDouble(-1.5D, 1.5D), UtilMath.randomDouble(1.3D, 1.8D) - 0.75D, UtilMath.randomDouble(-1.5D, 1.5D)), Effect.CLOUD, 0, 0, 0.2F, 0.2F, 0.2F, 0.0F, 2, 64);
                        loc.getWorld().spigot().playEffect(loc.clone().add(UtilMath.randomDouble(-1.5D, 1.5D), UtilMath.randomDouble(0.0D, 0.5D) - 0.75D, UtilMath.randomDouble(-1.5D, 1.5D)), Effect.WATERDRIP, 0, 0, 0.5F, 0.5F, 0.5F, 0.4F, 3, 64);
                    }
                    float finalR = -1.0F;
                    float finalG = -1.0F;
                    float finalB = 1.0F;
                    for (int a = 0; a < 100; a++) {
                        UtilParticles.play(loc.clone().add(UtilMath.randomDouble(-1.5D, 1.5D), UtilMath.randomDouble(1.0D, 1.6D) - 0.75D, UtilMath.randomDouble(-1.5D, 1.5D)), Effect.COLOURED_DUST, 0, 0, finalR, finalG, finalB, 1.0F, 0);
                    }
                    Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                        public void run() {
                            Tsunami.this.armorStands.remove(as);
                            as.remove();
                        }
                    }, 20L);
                    for (final Entity ent : as.getNearbyEntities(0.5D, 0.5D, 0.5D)) {
                        if ((!Tsunami.this.cooldownJump.contains(ent)) && (ent != player) && (!(ent instanceof ArmorStand))) {
                            if(SettingsMenu.gadgets.contains((Player)ent)){
                                UtilMath.applyVector(ent, new Vector(0, 1, 0).add(v));
                                Tsunami.this.cooldownJump.add(ent);
                                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                                    public void run() {
                                        Tsunami.this.cooldownJump.remove(ent);
                                    }
                                }, 20L);
                            }
                        }
                    }
                    loc.add(v);
                }
            }, 0L, 1L).getTaskId();

            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                public void run() {
                    Bukkit.getScheduler().cancelTask(i);
                }
            }, 40L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    Tsunami.this._time.put(player, Double.valueOf(((Double) Tsunami.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) Tsunami.this._time.get(player)).doubleValue() < 0.01D) {
                        Tsunami.this._time.remove(player);
                        Tsunami.this._cdRunnable.remove(player);
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
