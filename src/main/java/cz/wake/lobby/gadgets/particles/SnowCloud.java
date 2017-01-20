package cz.wake.lobby.gadgets.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilParticles;

public class SnowCloud{
	
	public static final HashMap<String, Integer> sc = new HashMap();
	public static int task6;
	
	@SuppressWarnings("deprecation")
	public void activateSnowCloud(Player p){
		if(!sc.containsKey(p.getName())){
			task6 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(sc.containsKey(p.getName()) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 3, 0),Effect.CLOUD, 0, 0, 0.5F, 0.1f, 0.5f, 0, 10);
						UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.SNOW_SHOVEL, 0, 0, 0.25F, 0.05f, 0.25f, 0, 1);
					} 
				}
				
			}, 0L, 3L).getTaskId();
			sc.put(p.getName(), Integer.valueOf(task6));
		} 
	}
}
