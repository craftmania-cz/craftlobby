package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class Love{
	
	public static final HashMap<String, Integer> l = new HashMap();
	int task9;
	
	@SuppressWarnings("deprecation")
	public void activateLove(Player p){
		if(!l.containsKey(p.getName())){
			task9 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(l.containsKey(p.getName()) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.HEART, 0, 0, 0.5f, 0.5f, 0.5f, 0, 2);
					} 
				}
				
			}, 0L, 4L).getTaskId();
			l.put(p.getName(),Integer.valueOf(task9));
		} 
	}
}
