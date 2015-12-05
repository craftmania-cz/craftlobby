package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class Portal{
	
	public HashSet<Player> port = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activatePortal(Player p){
		if(!this.port.contains(p)){
			this.port.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(port.contains(p) && p.isOnline()){
						ParticleEffect.PORTAL.display(1.0F, 1.0F, 1.0F, 0.0F, 20, p.getLocation(), 15.0D);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						port.remove(p);
					}
					
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}

	public void deactivatePortal(Player p){
		Bukkit.getScheduler().cancelTask(task);
		port.remove(p);
	}

}
