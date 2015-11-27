package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilBlock;

public class GravityStation implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	public static ArrayList<Entity> activateGravity = new ArrayList();
	private HashMap<Player, Location> stationLocation = new HashMap();
	  
	private Main plugin;
	
	public GravityStation(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onColorBomb(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.ENDER_STONE)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("GravityStation")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadget.gravitystation")){
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
	    	Location localLocation = e.getClickedBlock().getLocation();
	        localLocation.add(0.0D, 1.0D, 0.0D);
	        constructGravityStation(player, localLocation);
	        Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), new Runnable()
	        {
	          public void run()
	          {
	            GravityStation.this.stationLocation.remove(player);
	          }
	        }, 400L);
	        this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			GravityStation.this._time.put(player, Double.valueOf(((Double)GravityStation.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)GravityStation.this._time.get(player)).doubleValue() < 0.01D){
	      				GravityStation.this._time.remove(player);
	      				GravityStation.this._cdRunnable.remove(player);
	      				cancel();
	    		}
	    		
	    	}
	    });((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
	    }
	}
	
	public void constructGravityStation(final Player paramPlayer, Location paramLocation){
		if ((paramLocation.getBlock().isEmpty()) && 
			      (new Location(paramLocation.getWorld(), paramLocation.getX(), paramLocation.getY() + 1.0D, paramLocation.getZ()).getBlock().isEmpty()) && 
			      (new Location(paramLocation.getWorld(), paramLocation.getX(), paramLocation.getY() + 2.0D, paramLocation.getZ()).getBlock().isEmpty())){
			UtilBlock.setToRestore(paramLocation.getBlock(), Material.getMaterial(101), (byte)0, 20);
		    UtilBlock.setToRestore(paramLocation.add(0.0D, 1.0D, 0.0D).getBlock(), Material.getMaterial(95), (byte)11, 20);
		    this.stationLocation.put(paramPlayer, new Location(paramLocation.getWorld(), paramLocation.getX() + 0.5D, paramLocation.getY() + 0.5D, paramLocation.getZ() + 0.5D));
		    UtilBlock.setToRestore(paramLocation.add(0.0D, 1.0D, 0.0D).getBlock(), Material.getMaterial(101), (byte)0, 20);
		}
	}
	
	private static double arrondi(double A, int B){
	    return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	}

}
