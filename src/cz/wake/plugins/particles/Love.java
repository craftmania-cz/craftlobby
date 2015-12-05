package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class Love{
	
	public HashSet<Player> l = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateLove(Player p){
		if(!this.l.contains(p)){
			this.l.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(l.contains(p) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.HEART, 0, 0, 0.5f, 0.5f, 0.5f, 0, 2);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						l.remove(p);
					}
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}
	
	public void deaktivateLove(Player p){
		Bukkit.getScheduler().cancelTask(task);
		l.remove(p);
	}

}
