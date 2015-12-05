package cz.wake.plugins.particles;

import java.util.HashSet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class ColoredDust{
	
	public HashSet<Player> cd = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateDust(Player p){
		if(!this.cd.contains(p)){
			this.cd.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(cd.contains(p) && p.isOnline()){
						ParticleEffect.REDSTONE.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						cd.remove(p);
					}
					
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}
	
	public void deactivateClouds(Player p){
		Bukkit.getScheduler().cancelTask(task);
		cd.remove(p);
	}

}
