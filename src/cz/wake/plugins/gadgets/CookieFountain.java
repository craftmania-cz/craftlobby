package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;

public class CookieFountain implements Listener {
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	public static Random random = new Random();
	
	private Main plugin;
	
	public CookieFountain(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPee(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.COOKIE)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("CookieFountain")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadgets.cookiefountain")){
	    	return;
	    }
	    e.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	    	if (this._time.containsKey(player)){
			  	MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double)this._time.get(player)).doubleValue(), 1)));
			  		return;
			  	}
	    	this._time.put(player, Double.valueOf(25D + 0.1D));
	    	final ArrayList localArrayList = new ArrayList();
	        new BukkitRunnable()
	        {
	          int step = 0;
	          
	          public void run()
	          {
	            
	            this.step += 1;
	            Item localItem;
	            if (this.step <= 80)
	            {
	              player.getWorld().playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
	              localItem = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(Material.COOKIE, (byte)0, "nopickup"));
	              localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));
	              localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
	              localArrayList.add(localItem);
	            }
	            else
	            {
	              for (Iterator localIterator = localArrayList.iterator(); localIterator.hasNext();)
	              {
	                localItem = (Item)localIterator.next();
	                localItem.remove();
	              }
	              cancel();
	            }
	          }
	        }.runTaskTimer(Main.getPlugin(), 0L, 2L);
	        this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			CookieFountain.this._time.put(player, Double.valueOf(((Double)CookieFountain.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)CookieFountain.this._time.get(player)).doubleValue() < 0.01D){
	      				CookieFountain.this._time.remove(player);
	      				CookieFountain.this._cdRunnable.remove(player);
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
