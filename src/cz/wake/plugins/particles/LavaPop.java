package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class LavaPop{
	
	public HashSet<Player> lp = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateDust(Player p){
		if(!this.lp.contains(p)){
			this.lp.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(lp.contains(p) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.LAVA_POP, 0, 0, 0.5f, 0.5f, 0.5f, 0, 4);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						lp.remove(p);
					}
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}
	
	public void deactivateDust(Player p){
		Bukkit.getScheduler().cancelTask(task);
		lp.remove(p);
	}

}
