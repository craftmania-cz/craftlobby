package cz.wake.plugins.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ItemFactory;
import cz.wake.plugins.utils.UtilParticles;

public class Ghosts implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	Map<Bat, ArmorStand> bats = new HashMap<>();
	
	private Main plugin;
	
	public Ghosts(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onGhosting(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.FEATHER)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("Ghosts")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadgets.ghosts")){
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
	    	for (int i = 0; i < 20; i++) {
	            Bat bat = player.getWorld().spawn(player.getLocation().add(0, 1, 0), Bat.class);
	            ArmorStand ghost = bat.getWorld().spawn(bat.getLocation(), ArmorStand.class);
	            ghost.setSmall(true);
	            ghost.setGravity(false);
	            ghost.setVisible(false);
	            ghost.setHelmet(ItemFactory.createHead("Ghost", "31152fb2-cb1e-45c3-86dd-b23f7a20a6f8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkMjE4MzY0MDIxOGFiMzMwYWM1NmQyYWFiN2UyOWE5NzkwYTU0NWY2OTE2MTllMzg1NzhlYTRhNjlhZTBiNiJ9fX0="));
	            ghost.setChestplate(ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 255, 255, 255));
	            ghost.setItemInHand(new ItemStack(Material.DIAMOND_HOE));
	            bat.setPassenger(ghost);
	            bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 160, 1));
	            bats.put(bat, ghost);
	        }
	    	final int i = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), new Runnable(){
	    		@Override
	    		public void run(){
	    			if (!bats.isEmpty()) {
	                    for (Bat bat : bats.keySet())
	                        UtilParticles.play(bat.getLocation().add(0, 1.5, 0), Effect.CLOUD, 0, 0, 0.05f, 0.05f, 0.05f, 0.02f, 1);
	                }
	    		}
	    	}, 0L, 3L).getTaskId();
	    	
	        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), new Runnable() {
	            @Override
	            public void run() {
	                killBats();
	                Bukkit.getScheduler().cancelTask(i);
	            }
	        }, 160);
	        
	        this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			Ghosts.this._time.put(player, Double.valueOf(((Double)Ghosts.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)Ghosts.this._time.get(player)).doubleValue() < 0.01D){
	      				Ghosts.this._time.remove(player);
	      				Ghosts.this._cdRunnable.remove(player);
	      				cancel();
	    		}
	    		
	    	}
	    });((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L); 
	    }
	}
	
	@EventHandler
    public void onPlayerInteractGhost(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() != null && event.getRightClicked().getVehicle() != null
                && bats.containsKey(event.getRightClicked().getVehicle()))
            event.setCancelled(true);
    }

    private void killBats() {
        for (Bat bat : bats.keySet()) {
            bats.get(bat).remove();
            bat.remove();
        }
        bats.clear();
    }
    
    public void clear() {
        killBats();
    }
    
    private static double arrondi(double A, int B){
	    return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	}
    
    

}
