package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;

public class EtherealPearl implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	HashMap<Player, BukkitRunnable> runnableHashMap = new HashMap<>();
	ArrayList<EnderPearl> pearls = new ArrayList<>();
	
	private Main plugin;
	
	public EtherealPearl(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPerl(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.ENDER_PEARL)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("EtherealPearl")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.gadget.etherealpearl")){
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
	        final EnderPearl pearl = player.launchProjectile(EnderPearl.class);
	        pearl.setVelocity(player.getEyeLocation().getDirection().multiply(1.53d));
	        pearl.setPassenger(player);
	        player.teleport(player.getLocation().add(0, 5, 0));
	        pearls.add(pearl);
	        if (!player.getAllowFlight()) {
	            player.setAllowFlight(true);
	        }
	        BukkitRunnable runnable = new BukkitRunnable() {
	            @Override
	            public void run() {
	                if (pearl.isValid()) {
	                    player.eject();
	                    pearl.setPassenger(player);
	                } else {
	                    pearl.remove();
	                    player.eject();
	                    if (player.getGameMode() != GameMode.CREATIVE)
	                        player.setAllowFlight(false);
	                    runnableHashMap.remove(player);
	                    spawnRandomFirework(player.getLocation(), player);
	                    cancel();
	                }
	                if (runnableHashMap.containsKey(player)) {
	                	if (player.isOnGround()) {
	                		player.eject();
	                	}
	                }
	            }
	        };
	        runnableHashMap.put(player, runnable);
	        runnable.runTaskTimer(Main.getPlugin(), 0, 10);
	        
	        this._cdRunnable.put(player, new BukkitRunnable(){
	    		@Override
	    		public void run(){
	    			EtherealPearl.this._time.put(player, Double.valueOf(((Double)EtherealPearl.this._time.get(player)).doubleValue() - 0.1D));
	      			if (((Double)EtherealPearl.this._time.get(player)).doubleValue() < 0.01D){
	      				EtherealPearl.this._time.remove(player);
	      				EtherealPearl.this._cdRunnable.remove(player);
	      				cancel();
	    		}
	    		
	    	}
	    });((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L); 
	    }
	}
	
	@EventHandler
    public void onToggleSneak(PlayerToggleSneakEvent event) {
		Player player = (Player)event.getPlayer();
        if (runnableHashMap.containsKey(event.getPlayer()) && event.getPlayer().getName().equals(player.getName())) {
            player.eject();
            if (player.getGameMode() != GameMode.CREATIVE)
                player.setAllowFlight(false);
            runnableHashMap.get(player).cancel();
            runnableHashMap.remove(player);
            spawnRandomFirework(player.getLocation(), player);
        }
    }

    public FireworkEffect getRandomFireworkEffect() {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.fromRGB(100, 0, 100)).withFade(Color.fromRGB(30, 0, 30)).build();
        return effect;
    }

    public void spawnRandomFirework(Location location, Player player) {
        final ArrayList<Firework> fireworks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final Firework f = player.getWorld().spawn(location, Firework.class);

            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(getRandomFireworkEffect());
            f.setFireworkMeta(fm);
            fireworks.add(f);
        }
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                for (Firework f : fireworks)
                    f.detonate();
            }
        }, 2);
    }


    @EventHandler
    public void onItemFrameBreak(HangingBreakByEntityEvent event) {
    	Player player = (Player)event.getEntity();
        if (pearls.contains(event.getRemover())
                || event.getRemover() == player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof EnderPearl) {
            if (pearls.contains(event.getEntity())) {
                pearls.remove(event.getEntity());
                event.getEntity().remove();
            }
        }
    }
    
    private static double arrondi(double A, int B){
	    
		  return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	  }

}
