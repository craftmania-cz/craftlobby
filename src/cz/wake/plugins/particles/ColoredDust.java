package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class ColoredDust{
	
	public static final HashMap<String, Integer> cd = new HashMap();
	public static int task12;
	
	@SuppressWarnings("deprecation")
	public void activateDust(Player p){
		if(!cd.containsKey(p.getName())){
			task12 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(cd.containsKey(p.getName()) && p.isOnline()){
						ParticleEffect.REDSTONE.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
					} 
				}
				
			}, 0L, 4L).getTaskId();
			cd.put(p.getName(),Integer.valueOf(task12));
		} 
	}
}
