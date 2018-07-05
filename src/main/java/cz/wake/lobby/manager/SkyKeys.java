package cz.wake.lobby.manager;

import cz.wake.lobby.Main;
import me.picknchew.cratekeys.CrateOpenEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SkyKeys implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        int sqlDusts = Main.getInstance().getSQL().getSkyKeysDust(p.getUniqueId());
        int finalKeys = sqlDusts / 10;

        if (finalKeys == 0) {
            System.out.println("[SkyKeys] " + p.getName() + " ma 0 klicu. Returning...");
        } else {
            p.getInventory().addItem(giveKeys(finalKeys));
            System.out.println("[SkyKeys] " + p.getName() + " dostal " + finalKeys + " klicu.");
        }
    }

    private ItemStack giveKeys(int amount) {
        ItemStack i = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§aSkyKey §8(Klikni pravym na SkyBox)");
        i.setItemMeta(m);
        i.setAmount(amount);
        return i;
    }

    @EventHandler
    public void onSkyBoxUse(CrateOpenEvent e) {
        Player p = e.getPlayer();

        Main.getInstance().getSQL().takeSkyKeys(p, 10);
        System.out.println("[SkyKeys] " + p.getName() + " bylo odebrano 10 dustu.");
    }

}
