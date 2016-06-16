package cz.wake.plugins.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cz.wake.plugins.utils.ItemFactory;

public class MessagesListener {
	
	public static void messageCooldown(Player p, String time){
		p.sendMessage(ChatColor.GRAY + "Vyckej jeste " + ChatColor.AQUA + time + "s" + ChatColor.GRAY + " pred pouzitim.");
	}
	
	public void messageNoPerm(Player p, String gadget){
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 15.0F, 15.0F);
		p.sendMessage(ChatColor.RED + "Nemas opraveni k pouzivani: " + ChatColor.WHITE + gadget);
	}
	
	public static void messageOfDebug(Player p, Player user, String message){
		p.sendMessage(ChatColor.GREEN + "[Debug] " + ChatColor.GRAY + user.getName() + ": " + ChatColor.WHITE + message);
	}
	
	public static void messageOfError(Player p, Player user, String message){
		p.sendMessage(ChatColor.RED + "[Error] " + ChatColor.GRAY + user.getName() + ": " + message);
	}
	
	public static void messageOfActive(Player p, String Message){
		p.sendMessage(ChatColor.GRAY + "Jiz mas aktivovany: " + ChatColor.RED + Message);
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 15.0F, 15.0F);
	}
	
	public void prepareGadget(Player p, String gadget, Material mat, byte data){
		p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15.0F, 15.0F);
		p.sendMessage("§7Aktivoval jsi §a" + gadget);
		ItemStack item = ItemFactory.create(mat, data, "§c" + gadget);
		p.getInventory().setItem(6, item);
		p.closeInventory();
	}

}
