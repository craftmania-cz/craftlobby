package cz.wake.lobby.gadgets.gadget;

import cz.craftmania.craftcore.spigot.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.settings.SettingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class Pee implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    private HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    private int counter = 0;

    private Main plugin;

    public Pee(Main plugin) {
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
        if (!item.getType().equals(Material.INK_SACK)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("Pee")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.pee")) {
            return;
        }
        if (SettingsMenu.activeGadgets.contains(player)) {
            player.sendMessage("§cLze mit aktivni pouze jeden gadget!");
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
            this._time.put(player, Double.valueOf(35D + 0.1D));
            SettingsMenu.activeGadgets.add(player);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location loc = player.getLocation();
                    loc.add(0.0D, 0.6D, 0.0D);
                    ItemStack is = new ItemStack(Material.STAINED_GLASS, 1, (byte) 4);
                    ItemMeta im = is.getItemMeta();
                    im.setDisplayName("Peee");
                    is.setItemMeta(im);
                    final Item fb = player.getWorld().dropItem(loc, is);
                    fb.setVelocity(player.getLocation().getDirection().multiply(0.4D).add(new Vector(0.0D, 0.25D, 0.0D)));
                    fb.setMetadata("takeable", new FixedMetadataValue(plugin, "takeable"));
                    player.playSound(player.getLocation(), Sound.WEATHER_RAIN, 1.0F, 1.0F);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {

                            ParticleEffect.WATER_WAKE.display(0.5F, 0.5F, 0.5F, 0.0F, 5, fb.getLocation(), 10.0D);
                            fb.remove();
                        }
                    }, 13L);
                    counter++;
                    if (counter == 350) {
                        cancel();
                        counter = 0;
                        SettingsMenu.activeGadgets.remove(player);
                    }
                }
            }.runTaskTimer(plugin, 0, 1L).getTaskId();
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    Pee.this._time.put(player, Double.valueOf(((Double) Pee.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) Pee.this._time.get(player)).doubleValue() < 0.01D) {
                        Pee.this._time.remove(player);
                        Pee.this._cdRunnable.remove(player);
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

    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        Item item = e.getItem();
        if ((item.getItemStack().getType() == Material.STAINED_GLASS) && (item.getItemStack().getItemMeta().getDisplayName().contains("Peee"))) {
            if (SettingsMenu.gadgets.contains(p)) {
                PotionEffect potionEffect = new PotionEffect(PotionEffectType.CONFUSION, 150, 2);
                potionEffect.apply(p);
                e.setCancelled(true);
                e.getItem().remove();
            } else {
                e.setCancelled(true);
            }
        }
    }
}
