package cz.wake.lobby.gadgets.gadget;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;
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

public class DiamondsFountain implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static Random random = new Random();

    private Main plugin;

    public DiamondsFountain(Main plugin) {
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
        if (!item.getType().equals(Material.DIAMOND)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("DiamondFountain")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.diamondfountain")) {
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
                MessagesListener.messageCooldown(player, String.valueOf(arrondi((Double) this._time.get(player), 1)));
                return;
            }
            this._time.put(player, 25D + 0.1D);
            final ArrayList localArrayList = new ArrayList();
            new BukkitRunnable() {
                int step = 0;

                public void run() {

                    this.step += 1;
                    Item localItem;
                    if (this.step <= 130) {
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                        int number = randRange(0, 6);
                        switch (number) {
                            case 0:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 1:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_BARDING, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 2:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_CHESTPLATE, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 3:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_HOE, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 4:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_PICKAXE, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 5:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_SWORD, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            case 6:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                            default:
                                localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.DIAMOND_AXE, (byte) 0, "nopickup"));
                                localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                                localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                                localArrayList.add(localItem);
                        }
                    } else {
                        for (Iterator localIterator = localArrayList.iterator(); localIterator.hasNext(); ) {
                            localItem = (Item) localIterator.next();
                            localItem.remove();
                        }
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getPlugin(), 0L, 2L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    DiamondsFountain.this._time.put(player, Double.valueOf(((Double) DiamondsFountain.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) DiamondsFountain.this._time.get(player)).doubleValue() < 0.01D) {
                        DiamondsFountain.this._time.remove(player);
                        DiamondsFountain.this._cdRunnable.remove(player);
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

    private static int randRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }


}
