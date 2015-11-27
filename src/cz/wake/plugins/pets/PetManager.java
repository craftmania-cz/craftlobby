package cz.wake.plugins.pets;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.PathEntity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;

public class PetManager implements Listener{
	
	public static Map<Player, CraftEntity> pet = new HashMap();
	
	private Main plugin;
	
	public PetManager(Main plugin){
		this.plugin = plugin;
	}
	
	public static void PetFollow(final Player player , final org.bukkit.entity.Entity pet , final double speed, final double distance){
		new BukkitRunnable(){
			@Override
			public void run(){
				if ((!pet.isValid() || (!player.isOnline()))){
					this.cancel();}
				net.minecraft.server.v1_8_R3.Entity pett = ((CraftEntity) pet).getHandle();
				((EntityInsentient) pett).getNavigation().a(2);
				Object petf = ((CraftEntity) pet).getHandle();
				Location targetLocation = player.getLocation();
				PathEntity path;
				path = ((EntityInsentient) petf).getNavigation().a(targetLocation.getX() + distance, targetLocation.getY(), targetLocation.getZ() + distance);
				if (path != null) {
					((EntityInsentient) petf).getNavigation().a(path, 1.0D);
					((EntityInsentient) petf).getNavigation().a(2.0D);}
				if(player.getWorld().getName().equalsIgnoreCase(pet.getWorld().getName()) ){
                    if(!player.isOnline()){
                        pet.remove();
                    } else {
                        int distance = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
                        if (distance > 10 && !pet.isDead() && player.isOnGround()) {
                            pet.teleport(player.getLocation());
                        }
                    }
                } else {
                    if(!player.isOnline()){
                        pet.remove();
                    }else{
                        pet.teleport(player);
                    }
                }
				if(player.isOnline()){
					int distance = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
					if (distance > 10 && !pet.isDead() && player.isOnGround()) {
						pet.teleport(player.getLocation());}
				}
				AttributeInstance attributes = ((EntityInsentient)((CraftEntity)pet).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
				attributes.setValue(speed);
			}
		}.runTaskTimer(Main.getPlugin(), 0L, 20L);}

	@EventHandler
	public void onEntityTeleport(EntityTeleportEvent e){
		Entity localEntity = e.getEntity();
	    if (!(localEntity instanceof Enderman)) {
	      return;
	    }
	    if (localEntity.hasMetadata("Pet")) {
	      e.setCancelled(true);
	    }
	}
	
	@EventHandler
	  public void PetRemoveOnLeave(PlayerQuitEvent paramPlayerQuitEvent){
	    Player localPlayer = paramPlayerQuitEvent.getPlayer();
	    for (Entity localEntity : localPlayer.getWorld().getEntities()) {
	      if (localEntity == pet.get(localPlayer)){
	        pet.remove(localEntity);
	        localEntity.remove();
	      }
	    }
	  }
	  
	  @EventHandler
	  public void PetRemoveOnLeave(PlayerKickEvent paramPlayerKickEvent) {
	    Player localPlayer = paramPlayerKickEvent.getPlayer();
	    for (Entity localEntity : localPlayer.getWorld().getEntities()) {
	      if (localEntity == pet.get(localPlayer)){
	        pet.remove(localEntity);
	        localEntity.remove();
	      }
	    }
	  }
	  
	  @EventHandler
	  public void MobOnFire(EntityCombustEvent paramEntityCombustEvent){
	    Entity localEntity = paramEntityCombustEvent.getEntity();
	    if ((!(localEntity instanceof Skeleton)) && (!(localEntity instanceof Zombie))) {
	      return;
	    }
	    if (localEntity.hasMetadata("Pet")) {
	      paramEntityCombustEvent.setCancelled(true);
	    }
	  }
	  
	  public static void forceRemovePet(Player p){
		  for (Entity localEntity : p.getWorld().getEntities()) {
		      if (localEntity == pet.get(p)){
		        pet.remove(localEntity);
		        localEntity.remove();
		      }
		  }
	  }
}
