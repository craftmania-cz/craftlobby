package cz.wake.lobby.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MessagesListener {

    public static void messageCooldown(Player p, String time) {
        p.sendMessage(ChatColor.GRAY + "Vyčkej ještě " + ChatColor.AQUA + time + "s" + ChatColor.GRAY + " před dalším použitím.");
    }

    public void messageNoPerm(Player p, String gadget) {
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 15.0F, 15.0F);
        p.sendMessage(ChatColor.RED + "Nemas opraveni k pouzivani: " + ChatColor.WHITE + gadget);
    }

}
