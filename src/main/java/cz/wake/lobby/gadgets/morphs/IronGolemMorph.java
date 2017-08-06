package cz.wake.lobby.gadgets.morphs;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class IronGolemMorph implements Listener {

    public static void activate(Player p){
        MobDisguise localDisguise = new MobDisguise(DisguiseType.IRON_GOLEM);
        DisguiseAPI.undisguiseToAll(p);
        LivingWatcher localLivingWatcher = localDisguise.getWatcher();
        localLivingWatcher.setCustomName("§d" + p.getName());
        localLivingWatcher.setCustomNameVisible(true);
        p.getOpenInventory().close();
        DisguiseAPI.disguiseToAll(p, localDisguise);
    }
}
