package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;

public class Fireworks implements Listener{
	
	private Main plugin;
	
	public Fireworks(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void Activate(PlayerInteractEvent event){
		final Player player = event.getPlayer();
	    ItemStack item = event.getItem();
	    Action action = event.getAction();
	    
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.FIREWORK)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("Firework")) {
	        return;
	    }
	    event.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	  	    if (!player.hasPermission("craftlobby.gadget.firework")) {
	  	      return;
	  	    }
			
	  	    Firework fw = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
	  	    FireworkMeta meta = fw.getFireworkMeta();
	  	    FireworkEffect ef = randomColor();
	  	    meta.addEffect(ef);
	      
	  	    Random r = new Random();
	      
	  	    int rp = r.nextInt(2) + 1;
	  	    meta.setPower(rp);
	      	fw.setFireworkMeta(meta);
	  	 }
	    
	 }
	
	public static double arrondi(double A, int B){
	    
		  return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	}
	
	public FireworkEffect randomColor()
	  {
	    Random r = new Random();
	    
	    int rt = r.nextInt(4) + 1;
	    FireworkEffect.Type type = FireworkEffect.Type.BALL;
	    if (rt == 1) {
	      type = FireworkEffect.Type.BALL;
	    }
	    if (rt == 2) {
	      type = FireworkEffect.Type.BALL_LARGE;
	    }
	    if (rt == 3) {
	      type = FireworkEffect.Type.BURST;
	    }
	    if (rt == 4) {
	      type = FireworkEffect.Type.CREEPER;
	    }
	    if (rt == 5) {
	      type = FireworkEffect.Type.STAR;
	    }
	    int l1 = r.nextInt(17) + 1;
	    int l2 = r.nextInt(17) + 1;
	    Color c1 = getColor(l1);
	    Color c2 = getColor(l2);
	    
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    return effect;
	  }
	
	
	private Color getColor(int i)
	  {
	    Color c = null;
	    if (i == 1) {
	      c = Color.AQUA;
	    }
	    if (i == 2) {
	      c = Color.BLACK;
	    }
	    if (i == 3) {
	      c = Color.BLUE;
	    }
	    if (i == 4) {
	      c = Color.FUCHSIA;
	    }
	    if (i == 5) {
	      c = Color.GRAY;
	    }
	    if (i == 6) {
	      c = Color.GREEN;
	    }
	    if (i == 7) {
	      c = Color.LIME;
	    }
	    if (i == 8) {
	      c = Color.MAROON;
	    }
	    if (i == 9) {
	      c = Color.NAVY;
	    }
	    if (i == 10) {
	      c = Color.OLIVE;
	    }
	    if (i == 11) {
	      c = Color.ORANGE;
	    }
	    if (i == 12) {
	      c = Color.PURPLE;
	    }
	    if (i == 13) {
	      c = Color.RED;
	    }
	    if (i == 14) {
	      c = Color.SILVER;
	    }
	    if (i == 15) {
	      c = Color.TEAL;
	    }
	    if (i == 16) {
	      c = Color.WHITE;
	    }
	    if (i == 17) {
	      c = Color.YELLOW;
	    }
	    return c;
	  }

}
