package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilMath;

public class BatBlaster implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap<Player, Double>();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap<Player, BukkitRunnable>();
	private HashMap<Player, Location> playerVelocity = new HashMap<Player, Location>();
	private HashMap<Player, ArrayList<Bat>> bats = new HashMap<Player, ArrayList<Bat>>();
	private HashMap<Player, Long> isActive = new HashMap<Player, Long>();
	
	private Main plugin;
	
	public BatBlaster(Main plugin){
		this.plugin = plugin;
	}
	
	private boolean affectPlayers = true;
	
	@EventHandler
	public void onBatBlaster(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.IRON_BARDING)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("BatBlaster")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadgets.batblaster")){
	    	return;
	    }
	    e.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	    	if (this._time.containsKey(player)){
			  	MessagesListener.messageCooldown(player, String.valueOf(arrondi(this._time.get(player).doubleValue(), 1)));
			  		return;
			  	}
	    	this._time.put(player, Double.valueOf(60D + 0.1D));
	    	this.playerVelocity.put(player, player.getEyeLocation());
	    	this.isActive.put(player, Long.valueOf(System.currentTimeMillis()));
	    	this.bats.put(player, new ArrayList<Bat>());
	    	for (int i = 0; i < 16; i++) {
	    	      this.bats.get(player).add(player.getWorld().spawn(player.getEyeLocation(), Bat.class));
	    	}
	    	final int q = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), new Runnable(){
	    		@Override
	    		public void run(){
	    			Location loc = playerVelocity.get(player);
	    			if (isActive.containsKey(player)) {
	    			      for (Iterator localIterator1 = bats.get(player).iterator(); localIterator1.hasNext();)
	    			      {
	    			        Bat bat = (Bat)localIterator1.next();
	    			        if (bat.isValid())
	    			        {
	    			          Vector rand = new Vector((Math.random() - 0.5D) / 3.0D, (Math.random() - 0.5D) / 3.0D, (Math.random() - 0.5D) / 3.0D);
	    			          bat.setVelocity(loc.getDirection().clone().multiply(0.5D).add(rand));
	    			          for (Player other : player.getWorld().getPlayers()) {
	    			            if ((!other.equals(player)) && (hitPlayer(bat.getLocation(), other)))
	    			            {
	    			              Vector v = bat.getLocation().getDirection();
	    			              v.normalize();
	    			              v.multiply(0.4D);
	    			              v.setY(v.getY() + 0.2D);
	    			              if (v.getY() > 7.5D) {
	    			                v.setY(7.5D);
	    			              }
	    			              if (other.isOnGround()) {
	    			                v.setY(v.getY() + 0.2D);
	    			              }
	    			              other.setFallDistance(0.0F);
	    			              if (affectPlayers) {
	    			                  UtilMath.applyVelocity(other, bat.getLocation().getDirection().add(new Vector(0.0F, 0.4F, 0.0F)));
	    			              }
	    			              bat.getWorld().playSound(bat.getLocation(), Sound.BAT_HURT, 1F, 1F);
	    			              bat.getWorld().spigot().playEffect(bat.getLocation(), Effect.SMOKE);
	    			              
	    			              bat.remove();
	    			              
	    			            }
	    			          }
	    			        }
	    			      }
	    			    }
	    		}
	    	}, 0L, 2L).getTaskId();
	    	Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), new Runnable()
	        {
	          public void run()
	          {
	        	isActive.remove(player);
	      	    playerVelocity.remove(player);
	      	    if (bats.containsKey(player))
	      	    {
	      	      for (Bat bat : bats.get(player))
	      	      {
	      	        if (bat.isValid()) {
	      	          bat.getWorld().spigot().playEffect(bat.getLocation(), Effect.SMOKE);
	      	        }
	      	        bat.remove();
	      	      }
	      	      bats.remove(player);
	            Bukkit.getScheduler().cancelTask(q);
	          }
	        }}, 80L);
	    	this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			BatBlaster.this._time.put(player, Double.valueOf(((Double)BatBlaster.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)BatBlaster.this._time.get(player)).doubleValue() < 0.01D){
	      				BatBlaster.this._time.remove(player);
	      				BatBlaster.this._cdRunnable.remove(player);
	      				cancel();
	    		}
	    		
	    	}
	    });((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L); 
	    }
	}
	
	public boolean hitPlayer(Location loc, Player player)
	  {
	    if (loc.add(0.0D, -loc.getY(), 0.0D).toVector().subtract(player.getLocation().add(0.0D, -player.getLocation().getY(), 0.0D).toVector()).length() < 0.8D) {
	      return true;
	    }
	    if ((loc.add(0.0D, -loc.getY(), 0.0D).toVector().subtract(player.getLocation().add(0.0D, -player.getLocation().getY(), 0.0D).toVector()).length() < 1.2D) && 
	      (loc.getY() > player.getLocation().getY()) && (loc.getY() < player.getEyeLocation().getY())) {
	      return true;
	    }
	    return false;
	  }
	
	public void clear(Player p)
	  {
	    this.isActive.remove(p);
	    this.playerVelocity.remove(p);
	    if (this.bats.containsKey(p))
	    {
	      for (Bat bat : this.bats.get(p))
	      {
	        if (bat.isValid()) {
	          bat.getWorld().spigot().playEffect(bat.getLocation(), Effect.SMOKE);
	        }
	        bat.remove();
	      }
	      this.bats.remove(p);
	    }
	    HandlerList.unregisterAll(this);
	  }
	
	private static double arrondi(double A, int B){
	    
		  return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	  }
	
	

}
