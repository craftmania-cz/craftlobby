package cz.wake.lobby.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ParticleEffect;

public class FrozenWalk{
	
	public static final HashMap<String,Integer> fw = new HashMap<String,Integer>();
	
	@SuppressWarnings("deprecation")
	public void activateFrozen(final Player p){
		if(!fw.containsKey(p.getName())){
			final int task20 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new BukkitRunnable(){
				public void run() {
					if(fw.containsKey(p.getName())){
						Vector vectorLeft = getLeftVector(p.getLocation()).normalize().multiply(0.15);
				        Vector vectorRight = getRightVector(p.getLocation()).normalize().multiply(0.15);
				        Location locationLeft = p.getLocation().add(vectorLeft);
				        Location locationRight = p.getLocation().add(vectorRight);
				        locationLeft.setY(p.getLocation().getY());
				        locationRight.setY(p.getLocation().getY());
				        
				        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte) 0), 0, 0, 0, 0f, 0, locationLeft, 32);
				        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte)0), 0, 0, 0, 0f, 0, locationRight, 32);
				}
				
			}}, 0L, 1L);
			fw.put(p.getName(), Integer.valueOf(task20));
		} 
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
