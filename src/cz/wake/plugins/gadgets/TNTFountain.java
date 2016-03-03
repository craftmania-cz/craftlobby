package cz.wake.plugins.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilBlock;

public class TNTFountain implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	private final Map<Player, Location> locations = new HashMap();
	private boolean enabled = false;
	
	int counter = 0;
	
	private Main plugin;
	
	public TNTFountain(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void TNTFountainInteract(PlayerInteractEvent event){
		final Player player = event.getPlayer();
	    ItemStack item = event.getItem();
	    Action action = event.getAction();
	    
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.CLAY_BALL)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("TNTFountain")) {
	        return;
	    }
	    if(enabled){
	    	player.sendMessage("§cTento gadget je jiz na tomto lobby aktivovan!");
	    	return;
	    }
	    if (!player.hasPermission("craftlobby.gadgets.tntfountain")){
	    	return;
	    }
	    event.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	    	if (this._time.containsKey(player)){
			  	MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double)this._time.get(player)).doubleValue(), 1)));
			  		return;
			  	}
			    this.locations.put(player, player.getLocation().add(0.0D, 0.5D, 0.0D));
			    Location localLocation = (Location)this.locations.get(player);
			    if (localLocation == null) {
			        return;
			    }
			    this.enabled = true;
			    
			    this._time.put(player, Double.valueOf(120D + 0.1D));
			    new BukkitRunnable()
			      {
			    	@Override
			        public void run()
			        {
			        	float f1 = -0.6F + (float)(Math.random() * 2.2D);
					    float f2 = -0.6F + (float)(Math.random() * 2.2D);
					    float f3 = -0.4F + (float)(Math.random() * 1.2D);
					    float f4 = -0.6F + (float)(Math.random() * 2.2D);
					    float f5 = -0.2F + (float)(Math.random() * 4.2D);
					    float f6 = -0.6F + (float)(Math.random() * 3.2D);
			        	World localWorld = localLocation.getWorld();
					    final TNTPrimed localTNTPrimed = (TNTPrimed)localWorld.spawn(localLocation, TNTPrimed.class);
					    localTNTPrimed.setVelocity(new Vector(f1, 1.8F, f2));
					    localTNTPrimed.setYield(0.0F);
					    localTNTPrimed.setMetadata("BOOM", new FixedMetadataValue(plugin, player.getName()));
					    final TNTPrimed localTNTPrimed2 = (TNTPrimed)localWorld.spawn(localLocation, TNTPrimed.class);
					    localTNTPrimed2.setVelocity(new Vector(f3, 1.8F, f4));
					    localTNTPrimed2.setYield(0.0F);
					    localTNTPrimed2.setMetadata("BOOM", new FixedMetadataValue(plugin, player.getName()));
					    final TNTPrimed localTNTPrimed3 = (TNTPrimed)localWorld.spawn(localLocation, TNTPrimed.class);
					    localTNTPrimed3.setVelocity(new Vector(f5, 1.8F, f6));
					    localTNTPrimed3.setYield(0.0F);
					    localTNTPrimed3.setMetadata("BOOM", new FixedMetadataValue(plugin, player.getName()));
					    Location localLocation = localTNTPrimed.getLocation();

					    ParticleEffect.SMOKE_NORMAL.display(1.0F, 1.0F, 1.0F, 0.0F, 20, localLocation, 15.0D);
					    ParticleEffect.LAVA.display(1.0F, 1.0F, 1.0F, 0.0F, 20, localLocation, 15.0D);
					    ParticleEffect.CLOUD.display(1.0F, 1.0F, 1.0F, 0.0F, 20, localLocation, 15.0D);
		 	    		 counter++;
		 	    		 if(counter == 30){
		 	    			 cancel();
		 	    			 counter = 0;
		 	    			 enabled = false;
		 	    		 }
		 	    	  
			        	}
			      	}.runTaskTimer(plugin, 0, 10L).getTaskId();
			      	this._cdRunnable.put(player, new BukkitRunnable(){
			      		@Override
			      		public void run()
			      		{
			      			TNTFountain.this._time.put(player, Double.valueOf(((Double)TNTFountain.this._time.get(player)).doubleValue() - 0.1D));
			      			if (((Double)TNTFountain.this._time.get(player)).doubleValue() < 0.01D){
			      				TNTFountain.this._time.remove(player);
			      				TNTFountain.this._cdRunnable.remove(player);
			      				cancel();
			      				}
			      		}
			  	    });
			  	    ((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
	    	}
	}
	
	@EventHandler
	private void tntExplode(EntityExplodeEvent e){
		Entity ent = e.getEntity();
		if(e.getEntity() instanceof TNTPrimed){
			if(ent.hasMetadata("BOOM")){
				MobGun.LaunchRandomFirework(ent.getLocation());
			}
		}
	}
	
	public static double arrondi(double A, int B){
	    
		  return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	  }

	public boolean isAboveGround(Player player, int checkLevels) {
		 
        World world = player.getWorld();
        Location location = player.getLocation();
 
        if (location.getBlock().getType() == Material.AIR) {
            for (int i = 1; i < checkLevels; i++) {
                if (world.getBlockAt((int)location.getX(), location.getBlockY() - i, (int)location.getY()).getType() != Material.AIR) {
                    return false;
                }
            }
        }
 
        return true;
    }
}
