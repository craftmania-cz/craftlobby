package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.UtilParticles;

public class FrostLord{
	
	public static final HashMap<String, Integer> fl = new HashMap();
	public static int task4;
	
	@SuppressWarnings("deprecation")
	public void activateFrost(Player p){
		if(!fl.containsKey(p.getName())){
			task4 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				int step = 0;
			    float stepY = 0;
			    float radius = 1.5f;
				@Override
				public void run() {
					if(fl.containsKey(p.getName()) && p.isOnline()){
						for (int i = 0; i < 6; i++) {
				            Location location = p.getLocation();
				            double inc = (2 * Math.PI) / 100;
				            double angle = step * inc + stepY + i;
				            Vector v = new Vector();
				            v.setX(Math.cos(angle) * radius);
				            v.setZ(Math.sin(angle) * radius);
				            UtilParticles.play(location.add(v).add(0, stepY, 0), Effect.SNOW_SHOVEL);
				            location.subtract(v).subtract(0, stepY, 0);
				            if (stepY < 3) {
				                radius -= 0.022;
				                stepY += 0.045;
				            } else {
				                stepY = 0;
				                step = 0;
				                radius = 1.5f;
				                location.getWorld().playSound(location, Sound.BLOCK_SNOW_BREAK, .5f, 1.5f);
				                UtilParticles.play(location.clone().add(0, 3, 0), Effect.SNOW_SHOVEL, 0, 0, 0, 0, 0, 0.3f, 40);
				            }
				        }
					} 
					
				}
				
			}, 0L, 3L).getTaskId();
			fl.put(p.getName(),Integer.valueOf(task4));
		} 
	}

}
