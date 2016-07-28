package cz.wake.plugins.gadgets;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;
import net.minecraft.server.v1_9_R2.PacketPlayOutMount;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftFirework;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

public class SlimeHat implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    private HashMap<Player, ArrayList<Slime>> slim = new HashMap();
    private HashMap<Player, ArrayList<Entity>> slimeball = new HashMap();

    private Main plugin;

    public SlimeHat(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSlimeActivate(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.SLIME_BALL)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("SlimeHat")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.slimehat")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            this._time.put(player, Double.valueOf(35D + 0.1D));
            this.slim.put(player, new ArrayList());
            Slime localSlime1 = (Slime) player.getWorld().spawn(player.getLocation(), Slime.class);
            localSlime1.setSize(1);
            ((ArrayList) this.slim.get(player)).add(localSlime1);
            Slime localSlime2 = (Slime) player.getWorld().spawn(player.getLocation(), Slime.class);
            localSlime2.setSize(2);
            ((ArrayList) this.slim.get(player)).add(localSlime2);
            Slime localSlime3 = (Slime) player.getWorld().spawn(player.getLocation(), Slime.class);
            localSlime3.setSize(3);
            ((ArrayList) this.slim.get(player)).add(localSlime3);
            Slime localSlime4 = (Slime) player.getWorld().spawn(player.getLocation(), Slime.class);
            localSlime4.setSize(4);
            ((ArrayList) this.slim.get(player)).add(localSlime4);
            localSlime1.setPassenger(localSlime2);
            localSlime2.setPassenger(localSlime3);
            localSlime3.setPassenger(localSlime4);
            player.setPassenger(localSlime1);

            //Oprava chyby pri mountu na 1.9
            PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer) player).getHandle());
            for (Player p : player.getWorld().getPlayers()) {
                ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
            }

            this.slimeball.put(player, new ArrayList());
            final int i = Bukkit.getServer().getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Location localLocation = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 2.299999952316284D, player.getLocation().getZ());
                    for (int i = 0; i < 6; i++) {
                        Entity localEntity = localLocation.getWorld().dropItem(localLocation, ItemFactory.create(Material.SLIME_BALL, (byte) 0, "slimeHat"));
                        localEntity.setVelocity(new Vector(UtilMath.randomRange(-0.5D, 0.5D), UtilMath.randomRange(0.20000000298023224D, 0.5D), UtilMath.randomRange(-0.5D, 0.5D)));

                        localEntity.setMetadata("slimeball", new FixedMetadataValue(Main.getPlugin(), "slimeball"));
                        ((ArrayList) SlimeHat.this.slimeball.get(player)).add(localEntity);
                    }
                    FireworkEffect localFireworkEffect = FireworkEffect.builder().trail(true).flicker(false).withColor(new Color[]{Color.OLIVE, Color.GREEN}).with(FireworkEffect.Type.BURST).build();
                    playFirework(localLocation, localFireworkEffect);
                }
            }, 10L, 10L).getTaskId();

            Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().getScheduler().cancelTask(i);
                    if (SlimeHat.this.slim.containsKey(player)) {
                        for (Entity localEntity : SlimeHat.this.slim.get(player)) {
                            localEntity.remove();
                        }
                        SlimeHat.this.slim.remove(player);
                    }
                }
            }, 200L);

            Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                public void run() {
                    if (SlimeHat.this.slimeball.containsKey(player)) {
                        for (Entity localEntity : SlimeHat.this.slimeball.get(player)) {
                            Location localLocation = localEntity.getLocation();
                            ParticleEffect.SLIME.display(0.5F, 0.5F, 0.5F, 0.3F, 2, localLocation, 15.0D);
                            localEntity.remove();
                        }
                        SlimeHat.this.slimeball.remove(player);
                    }
                }
            }, 260L);

            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    SlimeHat.this._time.put(player, Double.valueOf(((Double) SlimeHat.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) SlimeHat.this._time.get(player)).doubleValue() < 0.01D) {
                        SlimeHat.this._time.remove(player);
                        SlimeHat.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }
    }

    public static void playFirework(Location paramLocation, FireworkEffect paramFireworkEffect) {
        Entity localEntity = paramLocation.getWorld().spawnEntity(paramLocation, EntityType.FIREWORK);
        Firework localFirework = (Firework) localEntity;
        FireworkMeta localFireworkMeta = localFirework.getFireworkMeta();
        localFireworkMeta.addEffect(paramFireworkEffect);
        localFireworkMeta.setPower(1);
        localFirework.setFireworkMeta(localFireworkMeta);

        ((CraftFirework) localFirework).getHandle().expectedLifespan = 1;
    }

    private static double arrondi(double A, int B) {

        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

    @EventHandler
    private void onPlayerPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        Item item = e.getItem();
        if ((item.getItemStack().getType() == Material.SLIME_BALL) && (item.getItemStack().getItemMeta().getDisplayName().contains("slimeHat"))) {
            p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 30.0F, 1.0F);
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.SPEED, 200, 2);
            potionEffect.apply(p);
            e.setCancelled(true);
            e.getItem().remove();
        }
    }

}
