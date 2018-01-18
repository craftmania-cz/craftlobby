package cz.wake.lobby.gadgets.morphs;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SnowmanMorph implements Listener {

    public static void activate(Player p) {
        MobDisguise localDisguise = new MobDisguise(DisguiseType.SNOWMAN);
        DisguiseAPI.undisguiseToAll(p);
        LivingWatcher localLivingWatcher = localDisguise.getWatcher();
        localLivingWatcher.setCustomName("§b" + p.getName());
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
            if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.SNOWMAN)) {
                return;
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 0.1F, 0.1F);
            Projectile projEp = p.launchProjectile(Snowball.class);
            projEp.setVelocity(projEp.getVelocity().multiply(1));

        }
    }
}
