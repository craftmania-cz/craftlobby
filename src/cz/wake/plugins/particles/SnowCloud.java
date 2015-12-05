package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class SnowCloud{
	
	public HashSet<Player> sc = new HashSet<Player>();
	int task1;
	
	@SuppressWarnings("deprecation")
	public void activateSnowCloud(Player p){
		if(!this.sc.contains(p)){
			this.sc.add(p);
			task1 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(sc.contains(p) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 3, 0),Effect.CLOUD, 0, 0, 0.5F, 0.1f, 0.5f, 0, 10);
						UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.SNOW_SHOVEL, 0, 0, 0.25F, 0.05f, 0.25f, 0, 1);
					} else {
						Bukkit.getScheduler().cancelTask(task1);
						sc.remove(p);
					}
				}
				
			}, 0L, 3L).getTaskId();
		} 
	}
	
	public void deactivateSnowCloud(Player p){
		Bukkit.getScheduler().cancelTask(task1);
		sc.remove(p);
	}
}
