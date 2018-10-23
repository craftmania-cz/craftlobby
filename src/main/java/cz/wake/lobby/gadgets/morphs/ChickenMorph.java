package cz.wake.lobby.gadgets.morphs;

import cz.craftmania.craftcore.spigot.utils.effects.ParticleEffect;
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
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ChickenMorph implements Listener {

    public static void activate(Player p) {
        MobDisguise localDisguise = new MobDisguise(DisguiseType.CHICKEN);
        DisguiseAPI.undisguiseToAll(p);
        LivingWatcher localLivingWatcher = localDisguise.getWatcher();
        localLivingWatcher.setCustomName("§e" + p.getName());
        localLivingWatcher.setCustomNameVisible(true);
        p.getOpenInventory().close();
        DisguiseAPI.disguiseToAll(p, localDisguise);
    }

    @EventHandler
    public void onPlayerLeftInteract(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (!DisguiseAPI.isDisguised(p)) {
            return;
        }
        if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.CHICKEN)) {
            return;
        }
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 0.1F, 0.1F);
        ItemStack meatStack = new ItemStack(Material.EGG, 1);
        ItemMeta msMeta = meatStack.getItemMeta();
        msMeta.setDisplayName("EGG");
        meatStack.setItemMeta(msMeta);
        final Item localItem = p.getWorld().dropItemNaturally(p.getEyeLocation(), meatStack);
        new BukkitRunnable() {
            public void run() {
                if (!localItem.isDead()) {
                    ParticleEffect.CLOUD.display(0.2F, 0.2F, 0.2F, 0.0F, 15, localItem.getLocation(), 15.0D);
                    localItem.remove();
                }
            }
        }.runTaskLater(Main.getInstance(), 120L);

    }
}
