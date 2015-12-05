package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class EnderSignal{
	
	public HashSet<Player> es = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateSignal(Player p){
		if(!this.es.contains(p)){
			this.es.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(es.contains(p) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0,1.5,0), Effect.ENDER_SIGNAL);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						es.remove(p);
					}
				}
			}, 0L, 1L).getTaskId();
		} 	
	}
	
	public void deaktivateSignal(Player p){
		Bukkit.getScheduler().cancelTask(task);
		es.remove(p);
	}

}
