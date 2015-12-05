package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class Enchanted{
	
	public HashSet<Player> e = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateEnchanted(Player p){
		if(!this.e.contains(p)){
			this.e.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(e.contains(p) && p.isOnline()){
						for (int i = 0; i < 60; i++){
							UtilParticles.play(p.getLocation().add(0, UtilMath.randomDouble(0.1, 2), 0), Effect.FLYING_GLYPH, 0, 0, 0, 0, 0, 8f, 1);
						}
					} else {
						Bukkit.getScheduler().cancelTask(task);
						e.remove(p);
					}
				}	
			}, 0L, 4L).getTaskId();
		} 
	}

	public void deactivateEnchanted(Player p){
		Bukkit.getScheduler().cancelTask(task);
		e.remove(p);
	}
}
