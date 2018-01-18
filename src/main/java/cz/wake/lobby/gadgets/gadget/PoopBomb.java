package cz.wake.lobby.gadgets.gadget;

import cz.wake.craftcore.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class PoopBomb implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    private HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static final HashMap<Player, Integer> countdown = new HashMap();
    public static Random random = new Random();

    private Main plugin;

    public PoopBomb(Main plugin) {
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
        if (!item.getType().equals(Material.MELON_SEEDS)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("PoopBomb")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.poopbomb")) {
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
            this._time.put(player, Double.valueOf(20D + 0.1D));
            SettingsMenu.activeGadgets.add(player);
            final ArrayList localArrayList = new ArrayList();
            final ItemStack localItemStack = ItemFactory.create(Material.INK_SACK, (byte) 3, "nopickup");

            final Item localItem1 = player.getWorld().dropItem(player.getLocation(), localItemStack);
            localItem1.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
            localArrayList.add(localItem1);
            localItem1.getWorld().playSound(localItem1.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1.0F, 1.0F);
            for (int i = 0; i < 2; i++) {
                Item localItem2 = player.getWorld().dropItem(player.getLocation(), localItemStack);
                localItem2.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
                localArrayList.add(localItem2);
            }
            new BukkitRunnable() {
                int step = 0;

                public void run() {
                    this.step += 1;
                    Object localObject;
                    if (this.step <= 100) {
                        if (random.nextInt(100) + 1 <= 60) {
                            for (int i = 0; i < 2; i++) {
                                localObject = ((Item) localArrayList.get(random.nextInt(localArrayList.size()))).getLocation();
                                ParticleEffect.ENCHANTMENT_TABLE.display(0.0F, 0.0F, 0.0F, 0.5F, 3, (Location) localObject, 15.0D);
                                Item localItem2 = localItem1.getWorld().dropItem((Location) localObject, localItemStack);
                                localItem2.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
                                localItem2.setVelocity(new Vector((random.nextDouble() - 0.5D) / 2.0D, 0.2D, (random.nextDouble() - 0.5D) / 2.0D));
                                localItem2.getWorld().playSound(localItem2.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                                localArrayList.add(localItem2);
                            }
                        }
                    } else {
                        for (localObject = localArrayList.iterator(); ((Iterator) localObject).hasNext(); ) {
                            Item localItem1 = (Item) ((Iterator) localObject).next();
                            ParticleEffect.SMOKE_LARGE.display(0.0F, 0.0F, 0.0F, 0.2F, 4, localItem1.getLocation(), 15.0D);
                            localItem1.getWorld().playSound(localItem1.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                            localItem1.remove();
                        }
                        SettingsMenu.activeGadgets.remove(player);
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getPlugin(), 10L, 1L);
        }
        this._cdRunnable.put(player, new BukkitRunnable() {
            @Override
            public void run() {
                if (player.isOnline()) {
                    PoopBomb.this._time.put(player, Double.valueOf(((Double) PoopBomb.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) PoopBomb.this._time.get(player)).doubleValue() < 0.01D) {
                        PoopBomb.this._time.remove(player);
                        PoopBomb.this._cdRunnable.remove(player);
                        cancel();
                    }
                } else {
                    PoopBomb.this._time.remove(player);
                    PoopBomb.this._cdRunnable.remove(player);
                    cancel();
                }

            }
        });
        ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
    }


    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
