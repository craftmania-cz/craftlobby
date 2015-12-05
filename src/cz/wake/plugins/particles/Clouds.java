package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class Clouds{
	
	public HashSet<Player> c = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateClouds(Player p){
		if(!this.c.contains(p)){
			this.c.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(c.contains(p) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.CLOUD, 0, 0, 0.7f, 1f, 0.7f, 0, 5);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						c.remove(p);
					}
					
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}
	
	public void deactivateClouds(Player p){
		Bukkit.getScheduler().cancelTask(task);
		c.remove(p);
	}

}
