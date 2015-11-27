package cz.wake.plugins.gadgets;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilMath;

public class AntiGravity implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	
	private Main plugin;
	
	public AntiGravity(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPee(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
	    if (item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadget.antigravity")){
	    	return;
	    }
	    if (!item.getType().equals(Material.EYE_OF_ENDER)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("AntiGravity")) {
	        return;
	    }
	    e.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	    	if (this._time.containsKey(player)){
			  	MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double)this._time.get(player)).doubleValue(), 1)));
			  		return;
			  	}
	    	this._time.put(player, Double.valueOf(20D + 0.1D));
	    	
	    	final ArmorStand as = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
	        as.setGravity(false);
	        as.setSmall(true);
	        as.setVisible(false);
	        as.setHelmet(new ItemStack(Material.SEA_LANTERN));
	        final int taskId = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
	            @Override
	            public void run() {
	                as.setHeadPose(as.getHeadPose().add(0, 0.1, 0));
	                as.getWorld().spigot().playEffect(as.getEyeLocation(), Effect.PORTAL, 0, 0, 3, 3, 3, 0, 150, 64);
	                as.getWorld().spigot().playEffect(as.getEyeLocation(), Effect.WITCH_MAGIC, 0, 0, .3f, 0.3f, 0.3f, 0, 5, 64);
	                for(Entity ent : as.getNearbyEntities(3, 2, 3)) {
	                    UtilMath.applyVector(ent, new Vector(0, 0.1, 0));
	                }
	            }
	        }, 0, 2).getTaskId();
	        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
	            @Override
	            public void run() {
	                as.remove();
	                Bukkit.getScheduler().cancelTask(taskId);
	            }
	        }, 220);
	    	
	    	this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			AntiGravity.this._time.put(player, Double.valueOf(((Double)AntiGravity.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)AntiGravity.this._time.get(player)).doubleValue() < 0.01D){
	      				AntiGravity.this._time.remove(player);
	      				AntiGravity.this._cdRunnable.remove(player);
	      				cancel();
	    		}
	    		
	    	}
	    });((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L); 
	    }	
	    
	}
	
	private static double arrondi(double A, int B){
		return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	}

}
