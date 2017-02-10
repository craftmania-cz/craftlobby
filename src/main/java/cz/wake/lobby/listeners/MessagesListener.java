package cz.wake.lobby.listeners;

import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MessagesListener {

    public static void messageCooldown(Player p, String time) {
        p.sendMessage(ChatColor.GRAY + "Vyckej jeste " + ChatColor.AQUA + time + "s" + ChatColor.GRAY + " pred pouzitim.");
    }

    public void messageNoPerm(Player p, String gadget) {
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 15.0F, 15.0F);
        p.sendMessage(ChatColor.RED + "Nemas opraveni k pouzivani: " + ChatColor.WHITE + gadget);
    }

    public void prepareGadget(Player p, String gadget, Material mat, byte data) {
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15.0F, 15.0F);
        p.sendMessage("§7Aktivoval jsi §a" + gadget);
        ItemStack item = ItemFactory.create(mat, data, "§c" + gadget);
        p.getInventory().setItem(6, item);
        p.closeInventory();
    }

}
