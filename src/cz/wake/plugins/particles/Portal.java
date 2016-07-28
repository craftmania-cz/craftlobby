package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class Portal{
	
	public static final HashMap<String,Integer> port = new HashMap();
	public static int task14;
	
	@SuppressWarnings("deprecation")
	public void activatePortal(Player p){
		if(!port.containsKey(p.getName())){
			task14 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(port.containsKey(p.getName()) && p.isOnline()){
						ParticleEffect.PORTAL.display(1.0F, 1.0F, 1.0F, 0.0F, 20, p.getLocation(), 15.0D);
					} 
				}
				
			}, 0L, 4L).getTaskId();
			port.put(p.getName(),Integer.valueOf(task14));
		} 
	}
}
