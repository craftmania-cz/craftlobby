package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import cz.wake.plugins.utils.UtilMath;

public class ColorBomb implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	private Item bomb;
	private ArrayList<Item> items = new ArrayList();
	Random random = new Random();
	private boolean running = false;
	private Main plugin;
	private boolean affectPlayers = true;
	
	public ColorBomb(Main plugin){
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
	    if (!item.getType().equals(Material.WOOL)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("ColorBomb")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadgets.colorbomb")){
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
	    	final Item bomb = player.getWorld().dropItem(player.getEyeLocation(), ItemFactory.create(Material.WOOL, (byte)this.random.nextInt(15), UUID.randomUUID().toString()));
	        bomb.setPickupDelay(50000);
	        bomb.setVelocity(player.getEyeLocation().getDirection().multiply(0.7532D));
	        this.bomb = bomb;
	        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), new Runnable(){
	        	@Override
	        	public void run(){
	        		if ((bomb != null) && (bomb.isValid()) && (!running) && (bomb.isOnGround())){
	        	      running = true;
	        	      bomb.setVelocity(new Vector(0, 0, 0));
	        	      if (running){
	        	        switch (random.nextInt(5)){
	        	        case 2:
	        	        	bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.FLAME, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
		        	        break;
	        	        case 3: 
	        	        	bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.FIREWORKS_SPARK, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
		        	        break;
	        	        default: 
	        	          bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.FIREWORKS_SPARK, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
	        	          break;
	        	        case 1: 
	        	          bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.FIREWORKS_SPARK, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
	        	          break;
	        	        case 4: 
	        	          bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.FLAME, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
	        	          break;
	        	        case 5: 
	        	          bomb.getWorld().spigot().playEffect(bomb.getLocation(), Effect.WITCH_MAGIC, 0, 0, 0.0F, 0.0F, 0.0F, 0.2F, 1, 32);
	        	        }
	        	        try{
	        	          Bukkit.getScheduler().runTask(Main.getPlugin(), new Runnable(){
	        	            public void run(){
	        	              running = false;
	        	              Item i = ColorBomb.this.bomb.getWorld().dropItem(ColorBomb.this.bomb.getLocation().add(0.0D, 0.15000000596046448D, 0.0D), ItemFactory.create(Material.WOOL, (byte)ColorBomb.this.random.nextInt(15), UUID.randomUUID().toString()));
	        	              i.setPickupDelay(500000);
	        	              i.setVelocity(new Vector(0.0D, 0.5D, 0.0D).add(UtilMath.getRandomCircleVector().multiply(0.1D)));
	        	              ColorBomb.this.items.add(i);
	        	              i.getWorld().playSound(i.getLocation(), Sound.ENTITY_CHICKEN_EGG, 0.2F, 1.0F);
	        	              for (Entity entity : ColorBomb.this.bomb.getNearbyEntities(1.5D, 1.0D, 1.5D)) {
	        	            	  if (((entity instanceof Player)) && (affectPlayers)) {
	        	            		  entity.setVelocity(new Vector(0.0D, 0.5D, 0.0D).add(UtilMath.getRandomCircleVector().multiply(0.1D)));
	        	            	  }
	        	              }
	        	            }
	        	          });
	        	          for (Item item : items) {
		        	            if (item.getTicksLived() > 15)
		        	            {
		        	              item.remove();
		        	              items.remove(item);
		        	            } else {
		        	            	return;
		        	            }
		        	        }
	        	        }
	        	        catch (Exception localException1) {
	        	        }
	        	      
	        	   }
	        	}
	        }}, 0L, 2L);
	        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable(){
	          @Override
	          public void run(){
	        	  if (bomb != null){
	        	      bomb.remove();
	        	  }
	        	  if (items != null){
	        	      for (Item item : items) {
	        	        item.remove();
	        	      }
	        	      items.clear();
	        	  }
	        	  running = false;
	          }
	        }, 200L);
	        this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			ColorBomb.this._time.put(player, Double.valueOf(((Double)ColorBomb.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)ColorBomb.this._time.get(player)).doubleValue() < 0.01D){
	      				ColorBomb.this._time.remove(player);
	      				ColorBomb.this._cdRunnable.remove(player);
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
