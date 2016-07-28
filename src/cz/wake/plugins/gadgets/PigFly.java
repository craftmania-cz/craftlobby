package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class PigFly implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    public static Random random = new Random();

    private Main plugin;

    public PigFly(Main plugin) {
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
        if (!item.getType().equals(Material.SADDLE)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("PigFly")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.pigfly")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(40D + 0.1D));
            Pig localPig = (Pig) player.getWorld().spawn(player.getLocation(), Pig.class);
            final Bat localBat = (Bat) player.getWorld().spawn(player.getLocation(), Bat.class);
            localPig.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
            localBat.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
            localBat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
            localPig.setPassenger(player);
            localBat.setPassenger(localPig);
            new BukkitRunnable() {
                public void run() {
                    displayFirework(localBat.getLocation(), FireworkEffect.Type.BURST, false, false, Arrays.asList(new Color[]{Color.RED}), Arrays.asList(new Color[]{Color.RED}));
                    dropItems(localBat.getLocation(), Arrays.asList(new ItemStack[]{ItemFactory.create(Material.BONE, (byte) 0, "nopickup"), ItemFactory.create(Material.INK_SACK, (byte) 1, "nopickup"), ItemFactory.create(Material.RAW_BEEF, (byte) 0, "nopickup")}), 40, 100, 1);
                    sendStepSound(localBat.getLocation(), Material.REDSTONE_BLOCK, 5);
                    localPig.remove();
                    localBat.remove();
                }
            }.runTaskLater(Main.getPlugin(), 140L);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    PigFly.this._time.put(player, Double.valueOf(((Double) PigFly.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) PigFly.this._time.get(player)).doubleValue() < 0.01D) {
                        PigFly.this._time.remove(player);
                        PigFly.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }
    }

    public static void displayFirework(Location paramLocation, FireworkEffect.Type paramType, boolean paramBoolean1, boolean paramBoolean2, List<Color> paramList1, List<Color> paramList2) {
        Firework localFirework = (Firework) paramLocation.getWorld().spawn(paramLocation, Firework.class);
        FireworkMeta localFireworkMeta = localFirework.getFireworkMeta();
        localFireworkMeta.addEffect(FireworkEffect.builder().with(paramType).flicker(paramBoolean1).trail(paramBoolean2).withColor(paramList1).withFade(paramList2).build());
        localFirework.setFireworkMeta(localFireworkMeta);
        new BukkitRunnable() {
            public void run() {
                localFirework.detonate();
            }
        }.runTaskLater(Main.getPlugin(), 2L);
    }

    public static void dropItems(final Location paramLocation, final List<ItemStack> paramList, final int paramInt1, int paramInt2, int paramInt3) {
        final ArrayList localArrayList = new ArrayList();
        new BukkitRunnable() {
            int step = 0;

            public void run() {
                this.step += 1;
                Object localObject1;
                Object localObject2;
                if (this.step <= paramInt2) {
                    if (this.step <= paramInt1) {
                        localObject1 = (ItemStack) paramList.get(random.nextInt(paramList.size()));
                        localObject2 = paramLocation.getWorld().dropItem(paramLocation, (ItemStack) localObject1);
                        ((Item) localObject2).setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
                        Vector localVector = new Vector(random.nextDouble() - 0.5D, 0.5D, random.nextDouble() - 0.5D);
                        ((Item) localObject2).setVelocity(localVector);
                        localArrayList.add(localObject2);
                    }
                } else {
                    for (localObject2 = localArrayList.iterator(); ((Iterator) localObject2).hasNext(); ) {
                        localObject1 = (Item) ((Iterator) localObject2).next();
                        ((Item) localObject1).remove();
                    }
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, paramInt3);
    }

    public static void sendStepSound(Location paramLocation, Material paramMaterial, int paramInt) {
        for (int i = 0; i < paramInt; i++) {
            paramLocation.getWorld().playEffect(paramLocation, Effect.STEP_SOUND, paramMaterial);
        }
    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }


}
