package cz.wake.lobby.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilParticles;

public class GreenSparks{
	
	public static final HashMap<String, Integer> greenPlayers = new HashMap();
	public static int task1;
	
	@SuppressWarnings("deprecation")
	public void activateGreenSparks(Player p){
		if(!greenPlayers.containsKey(p.getName())){
			task1 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				boolean up;
				float height;
				int step;
				@Override
				public void run(){
					if(greenPlayers.containsKey(p.getName()) && p.isOnline()){
						if(up) {
							if(height < 2)
								height += 0.05;
					        else
					            up = false;
					        } else {
					        if(height > 0)
					            height -= 0.05;
					        else
					            up = true;
					        }
					        double inc = (2 * Math.PI) / 100;
					        double angle = step * inc;
					        Vector v = new Vector();
					        v.setX(Math.cos(angle) * 1.1);
					        v.setZ(Math.sin(angle) * 1.1);
					        UtilParticles.play(p.getLocation().clone().add(v).add(0, height, 0), Effect.HAPPY_VILLAGER);
					        step += 4;
						} 
					}
				}, 0L, 1L).getTaskId();
			greenPlayers.put(p.getName(), Integer.valueOf(task1)); 
		}
	}

}
