package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Chickenator implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    static Random r = new Random();
    ArrayList<Item> items = new ArrayList();

    private Main plugin;

    public Chickenator(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChicken(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();
        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.COOKED_CHICKEN)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("Chickenator")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.chikenator")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (Main.getInstance().getTPS() < 17) {
                player.sendMessage("§cServer je pretizeny, nelze pouzivat gadgets!");
                return;
            }
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(20D + 0.1D));
            final Chicken CHICKEN = (Chicken) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.CHICKEN);
            CHICKEN.setNoDamageTicks(500);
            CHICKEN.setVelocity(player.getLocation().getDirection().multiply(2.0943951023931953D));
            player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_STEP, 1.4F, 1.5F);
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.3F, 1.5F);
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                public void run() {
                    Chickenator.this.spawnRandomFirework(CHICKEN.getLocation());
                    player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_HURT, 1.4F, 1.5F);
                    CHICKEN.remove();
                    for (int i = 0; i < 30; i++) {
                        Item ITEM = CHICKEN.getWorld().dropItem(CHICKEN.getLocation(), ItemFactory.create(Material.COOKED_CHICKEN, (byte) 0, UUID.randomUUID().toString()));
                        ITEM.setPickupDelay(30000);
                        ITEM.setVelocity(new Vector(Chickenator.r.nextDouble() - 0.5D, Chickenator.r.nextDouble() / 2.0D, Chickenator.r.nextDouble() - 0.5D));
                        Chickenator.this.items.add(ITEM);
                    }
                    Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                        public void run() {
                            for (Item i : Chickenator.this.items) {
                                i.remove();
                            }
                        }
                    }, 50L);
                }
            }, 9L);

            player.updateInventory();
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    Chickenator.this._time.put(player, Double.valueOf(((Double) Chickenator.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) Chickenator.this._time.get(player)).doubleValue() < 0.01D) {
                        Chickenator.this._time.remove(player);
                        Chickenator.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }

    }

    public static FireworkEffect getRandomFireworkEffect() {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))).build();
        return effect;
    }

    public void spawnRandomFirework(Location location) {
        final ArrayList<Firework> fireworks = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Firework f = (Firework) location.getWorld().spawn(location, Firework.class);

            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(getRandomFireworkEffect());
            f.setFireworkMeta(fm);
            fireworks.add(f);
        }
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
            public void run() {
                for (Firework f : fireworks) {
                    f.detonate();
                }
            }
        }, 2L);
    }

    private static double arrondi(double A, int B) {

        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
