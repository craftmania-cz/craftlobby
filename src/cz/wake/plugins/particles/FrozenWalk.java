package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class FrozenWalk{
	
	public HashSet<Player> fw = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateFrozen(Player p){
		if(!this.fw.contains(p)){
			this.fw.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(fw.contains(p) && p.isOnline()){
						Vector vectorLeft = getLeftVector(p.getLocation()).normalize().multiply(0.15);
				        Vector vectorRight = getRightVector(p.getLocation()).normalize().multiply(0.15);
				        Location locationLeft = p.getLocation().add(vectorLeft);
				        Location locationRight = p.getLocation().add(vectorRight);
				        locationLeft.setY(p.getLocation().getY());
				        locationRight.setY(p.getLocation().getY());
				        
				        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte) 0), 0, 0, 0, 0f, 0, locationLeft, 32);
				        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte)0), 0, 0, 0, 0f, 0, locationRight, 32);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						fw.remove(p);
					}
				}
				
			}, 0L, 1L).getTaskId();
		} 
	}
	
	public void deactivateFrozen(Player p){
		Bukkit.getScheduler().cancelTask(task);
		fw.remove(p);
	}
	
	public static Vector getLeftVector(Location loc) {
        final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 0))));
        final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 0))));

        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }

    public static Vector getRightVector(Location loc) {
        final float newX = (float) (loc.getX() + (-1 * Math.cos(Math.toRadians(loc.getYaw() + 0))));
        final float newZ = (float) (loc.getZ() + (-1 * Math.sin(Math.toRadians(loc.getYaw() + 0))));

        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }

}
