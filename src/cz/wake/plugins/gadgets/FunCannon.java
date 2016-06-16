package cz.wake.plugins.gadgets;

import java.util.HashMap;

import net.minecraft.server.v1_9_R2.EntityEnderPearl;
import net.minecraft.server.v1_9_R2.EntitySnowball;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilBlock;

public class FunCannon implements Listener{
	
	private Main plugin;
	
	public FunCannon(Main plugin){
		this.plugin = plugin;
	}
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	
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
	    if (!item.getType().equals(Material.GOLD_HOE)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("FunCannon")) {
	        return;
	    }
	    event.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	  	    if (!player.hasPermission("craftlobby.gadgets.funcannon")) {
	  	      return;
	  	    }
	  	    if (this._time.containsKey(player))
	  	    {
	  	      MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double)this._time.get(player)).doubleValue(), 1)));
	  	      return;
	  	    }
	  	    this._time.put(player, Double.valueOf(5D + 0.1D));
	  	    Projectile projEp = player.launchProjectile(EnderPearl.class);
	  	    Projectile projEp2 = player.launchProjectile(EnderPearl.class);
	  	    Projectile projSb = player.launchProjectile(Snowball.class);
	  	    Projectile projSb2 = player.launchProjectile(Snowball.class);
	  	    projEp.setVelocity(projEp.getVelocity().multiply(1));
	  	    projEp2.setVelocity(projEp2.getVelocity().multiply(1));
	  	    projEp.setMetadata("FUNCANNON", new FixedMetadataValue(plugin, player.getName()));
	  	    projEp2.setMetadata("FUNCANNON", new FixedMetadataValue(plugin, player.getName()));
	  	    projSb.setVelocity(projSb.getVelocity().multiply(1));
	  	    projSb.setMetadata("FUNCANNON", new FixedMetadataValue(plugin, player.getName()));
	  	    projSb2.setVelocity(projSb2.getVelocity().multiply(1));
	  	    projSb2.setMetadata("FUNCANNON", new FixedMetadataValue(plugin, player.getName()));
	  	    
	  	    this._cdRunnable.put(player, new BukkitRunnable()
	  	    {
	  	      @Override
	  	      public void run()
	  	      {
	  	        FunCannon.this._time.put(player, Double.valueOf(((Double)FunCannon.this._time.get(player)).doubleValue() - 0.1D));
	  	        if (((Double)FunCannon.this._time.get(player)).doubleValue() < 0.01D)
	  	        {
	  	          FunCannon.this._time.remove(player);
	  	          FunCannon.this._cdRunnable.remove(player);
	  	          cancel();
	  	        }
	  	      }
	  	    });
	  	    ((BukkitRunnable)this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
	  	 }
	    
	 }
	
	 @EventHandler
 	 public void onProjectileHit(ProjectileHitEvent e){
 	    Entity en = e.getEntity();
 	    if ((en instanceof Projectile)){
 	      if (en.hasMetadata("FUNCANNON")){
 	    	  	    	  
 	    	  ParticleEffect.FLAME.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);
 	    	  ParticleEffect.HEART.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);
 	    	  ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);
 	    	  ParticleEffect.SMOKE_LARGE.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);
 	    	  ParticleEffect.CLOUD.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);
 	    	  ParticleEffect.LAVA.display(0.0F, 0.0F, 0.0F, 0.0F, 20, en.getLocation(), 15.0D);

 	        en.getLocation().getWorld().playSound(en.getLocation(), Sound.ENTITY_CAT_PURREOW, 1.0F, 1.0F);
 	        en.getLocation().getWorld().playSound(en.getLocation(), Sound.ENTITY_WOLF_HURT, 1.0F, 1.0F);
 	      }
 	      en.remove();
 	    }
	 }
	 
	 @EventHandler
	 public void onTeleport(PlayerTeleportEvent event) {
		 if(event.getCause().equals(TeleportCause.ENDER_PEARL)) { 
			 event.setCancelled(true);
		 }
	 }
	 
	  
	  public static double arrondi(double A, int B){
	    
		  return (int)(A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
	  }

}
