package cz.wake.plugins.particles;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class BloodHelix{
	
	public static final HashMap<String, Integer> bh = new HashMap();
	public static int task2;
	
	//Posledni uprava 7.12.2015
	
	@SuppressWarnings("deprecation")
	public void activateHelix(Player p){
		if(!bh.containsKey(p.getName())){
			task2 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				double i = 0;
				@Override
				public void run() {
					if(bh.containsKey(p.getName()) && p.isOnline()){
						Location location = p.getLocation();
				        Location location2 = p.getLocation().clone();
				        double radius = 1.1d;
				        double radius2 = 1.1d;
				        double particles = 100;

				        for (int step = 0; step < 100; step += 4) {
				            double inc = (2 * Math.PI) / particles;
				            double angle = step * inc + i;
				            Vector v = new Vector();
				            v.setX(Math.cos(angle) * radius);
				            v.setZ(Math.sin(angle) * radius);
				            UtilParticles.play(location.add(v), Effect.COLOURED_DUST, 0);
				            location.subtract(v);
				            location.add(0, 0.12d, 0);
				            radius -= 0.044f;
				        }
				        for (int step = 0; step < 100; step += 4) {
				            double inc = (2 * Math.PI) / particles;
				            double angle = step * inc + i + 3.5;
				            Vector v = new Vector();
				            v.setX(Math.cos(angle) * radius2);
				            v.setZ(Math.sin(angle) * radius2);
				            UtilParticles.play(location2.add(v), Effect.COLOURED_DUST, 0);
				            location2.subtract(v);
				            location2.add(0, 0.12d, 0);
				            radius2 -= 0.044f;
				        }
				        i += 0.05;
					}
				}
			}, 0L, 2L).getTaskId();
			bh.put(p.getName(), Integer.valueOf(task2));
		} 
	}
}
