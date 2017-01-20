package cz.wake.lobby.gadgets.gadget;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.ParticleEffect;
import cz.wake.lobby.utils.UtilMath;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftFirework;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FlowerPopper implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    private HashMap<Player, ArrayList<Entity>> flowers = new HashMap();

    private Main plugin;

    public FlowerPopper(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFlowering(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.RED_ROSE)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("FlowerPopper")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.flowerpopper")) {
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
            this._time.put(player, Double.valueOf(20D + 0.1D));
            this.flowers.put(player, new ArrayList());

            final int i = Bukkit.getServer().getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Location location = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 2.0D, player.getLocation().getZ());

                    Entity localEntity = location.getWorld().dropItem(location, ItemFactory.create(Material.RED_ROSE, (byte) UtilMath.randomRange(1, 8), "nopickup"));
                    localEntity.setVelocity(new Vector(UtilMath.randomRange(-0.5D, 0.5D), UtilMath.randomRange(0.20000000298023224D, 0.5D), UtilMath.randomRange(-0.5D, 0.5D)));

                    localEntity.setMetadata("flowers", new FixedMetadataValue(Main.getPlugin(), "flowers"));
                    ((ArrayList) FlowerPopper.this.flowers.get(player)).add(localEntity);

                    playRandomFireworkColor(location, FireworkEffect.Type.BURST);
                }
            }, 5L, 5L).getTaskId();

            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(i);
                }
            }, 200L);

            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (FlowerPopper.this.flowers.containsKey(player)) {
                        for (Entity localEntity : FlowerPopper.this.flowers.get(player)) {
                            Location localLocation = localEntity.getLocation();

                            ParticleEffect.FIREWORKS_SPARK.display(0.5F, 0.5F, 0.5F, 0.0F, 5, localLocation, 15.0D);

                            localEntity.remove();
                        }
                    }
                }
            }, 260L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    FlowerPopper.this._time.put(player, Double.valueOf(((Double) FlowerPopper.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) FlowerPopper.this._time.get(player)).doubleValue() < 0.01D) {
                        FlowerPopper.this._time.remove(player);
                        FlowerPopper.this._cdRunnable.remove(player);
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

    public static void playRandomFireworkColor(Location paramLocation, FireworkEffect.Type paramType) {
        FireworkEffect.Builder localBuilder = FireworkEffect.builder();
        Random localRandom = new Random();

        localBuilder.flicker(localRandom.nextBoolean());
        localBuilder.trail(localRandom.nextBoolean());
        localBuilder.with(paramType);
        localBuilder.withColor(Color.fromRGB(localRandom.nextInt(256), localRandom.nextInt(256), localRandom.nextInt(256)));
        localBuilder.withFade(Color.fromRGB(localRandom.nextInt(256), localRandom.nextInt(256), localRandom.nextInt(256)));
        FireworkEffect localFireworkEffect = localBuilder.build();

        Entity localEntity = paramLocation.getWorld().spawnEntity(paramLocation, EntityType.FIREWORK);
        Firework localFirework = (Firework) localEntity;
        FireworkMeta localFireworkMeta = localFirework.getFireworkMeta();
        localFireworkMeta.addEffect(localFireworkEffect);
        localFireworkMeta.setPower(1);
        localFirework.setFireworkMeta(localFireworkMeta);

        ((CraftFirework) localFirework).getHandle().expectedLifespan = 1;
    }

}
