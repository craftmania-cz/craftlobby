package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class FrozenWalk{
	
	public static ArrayList<Player> fwPlayers = new ArrayList();
	
	public static void activateFrozen(Player p){
		if(!fwPlayers.contains(p)){
			fwPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(fwPlayers.contains(p)){
					Vector vectorLeft = getLeftVector(p.getLocation()).normalize().multiply(0.15);
			        Vector vectorRight = getRightVector(p.getLocation()).normalize().multiply(0.15);
			        Location locationLeft = p.getLocation().add(vectorLeft);
			        Location locationRight = p.getLocation().add(vectorRight);
			        locationLeft.setY(p.getLocation().getY());
			        locationRight.setY(p.getLocation().getY());
			        
			        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte) 0), 0, 0, 0, 0f, 0, locationLeft, 32);
			        ParticleEffect.ITEM_CRACK.display(new ParticleEffect.ItemData(Material.SNOW, (byte)0), 0, 0, 0, 0f, 0, locationRight, 32);
				}
			}
		}, 0L, 1L);
	}
	
	public static void deactivateFrozen(Player p){
		fwPlayers.remove(p);
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
