package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class RainCloud{
	
	public static final HashMap<String, Integer> rc = new HashMap();
	public static int task3;
	
	@SuppressWarnings("deprecation")
	public void activateRainCloud(Player p){
		if(!rc.containsKey(p.getName())){
			task3 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(rc.containsKey(p.getName()) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.CLOUD, 0, 0, 0.5F, 0.1f, 0.5f, 0, 10);
				        UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.WATERDRIP, 0, 0, 0.25F, 0.05f, 0.25f, 0, 1);
					} 
				}
				
			}, 0L, 3L).getTaskId();
			rc.put(p.getName(), Integer.valueOf(task3));
		} 
	}
}
