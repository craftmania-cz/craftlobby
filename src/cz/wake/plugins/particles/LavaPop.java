package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class LavaPop{
	
	public static final HashMap<String,Integer> lp = new HashMap();
	public static int task13;
	
	@SuppressWarnings("deprecation")
	public void activateDust(Player p){
		if(!lp.containsKey(p.getName())){
			task13 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(lp.containsKey(p.getName()) && p.isOnline()){
						UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.LAVA_POP, 0, 0, 0.5f, 0.5f, 0.5f, 0, 4);
					} 
				}
				
			}, 0L, 4L).getTaskId();
			lp.put(p.getName(), Integer.valueOf(task13));
		} 
	}
}
