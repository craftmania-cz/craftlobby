package cz.wake.lobby.gadgets.morphs;

import cz.wake.craftcore.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;
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
import org.bukkit.scheduler.BukkitRunnable;

public class PigMorph implements Listener {

    public static void activate(Player p) {
        MobDisguise localDisguise = new MobDisguise(DisguiseType.PIG);
        DisguiseAPI.undisguiseToAll(p);
        LivingWatcher localLivingWatcher = localDisguise.getWatcher();
        localLivingWatcher.setCustomName("§d" + p.getName());
        localLivingWatcher.setCustomNameVisible(true);
        p.getOpenInventory().close();
        DisguiseAPI.disguiseToAll(p, localDisguise);
    }

    @EventHandler
    public void onPlayerLeftInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            if (!DisguiseAPI.isDisguised(p)) {
                return;
            }
            if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.PIG)) {
                return;
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 0.1F, 0.1F);
            ItemStack meatStack = new ItemStack(Material.PORK, 1);
            ItemMeta msMeta = meatStack.getItemMeta();
            msMeta.setDisplayName("PIG_PORK");
            meatStack.setItemMeta(msMeta);
            final Item localItem = p.getWorld().dropItemNaturally(p.getEyeLocation(), meatStack);
            localItem.setVelocity(p.getLocation().getDirection().multiply(1.5));
            new BukkitRunnable() {
                public void run() {
                    if (!localItem.isDead()) {
                        ParticleEffect.FIREWORKS_SPARK.display(0.2F, 0.2F, 0.2F, 0.0F, 15, localItem.getLocation(), 15.0D);
                        localItem.remove();
                    }
                }
            }.runTaskLater(Main.getInstance(), 120L);

        }
    }

    @EventHandler
    public void onPlayerInteractRight(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (!DisguiseAPI.isDisguised(p)) {
                return;
            }
            if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.PIG)) {
                return;
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 10.0F, 1F);
            ParticleEffect.HEART.display(1.5F, 1.5F, 1.5F, 0.0F, 5, p.getLocation(), 10.0D);
        }
    }

    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        Item item = e.getItem();
        if ((item.getItemStack().getType() == Material.PORK) && (item.getItemStack().getItemMeta().getDisplayName().contains("PIG_PORK"))) {
            p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 20.0F, 1.0F);
            ParticleEffect.HEART.display(1.0F, 1.0F, 1.0F, 0.0F, 10, p.getLocation(), 15.0D);
            e.setCancelled(true);
            e.getItem().remove();

        }
    }

}
