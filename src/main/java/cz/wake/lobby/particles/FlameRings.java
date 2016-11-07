package cz.wake.lobby.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilMath;
import cz.wake.lobby.utils.UtilParticles;

public class FlameRings{
	
	public static final HashMap<String, Integer> fr = new HashMap();
	public static int task5;
	
	@SuppressWarnings("deprecation")
	public void activateFlame(Player p){
		if(!fr.containsKey(p.getName())){
			task5 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				float step = 0;
				@Override
				public void run() {
					if(fr.containsKey(p.getName()) && p.isOnline()){
						for (int i = 0; i < 2; i++) {
				            double inc = (2 * Math.PI) / 100;
				            double toAdd = 0;
				            if(i == 1)
				                toAdd = 3.5;
				            double angle = step * inc + toAdd;
				            Vector v = new Vector();
				            v.setX(Math.cos(angle));
				            v.setZ(Math.sin(angle));
				            if(i == 0) {
				                UtilMath.rotateAroundAxisZ(v, 180);
				            } else {
				            	UtilMath.rotateAroundAxisZ(v, 90);
				            }
				            UtilParticles.play(p.getLocation().clone().add(0, 1, 0).add(v), Effect.FLAME);
				        }
				        step += 3;
					} 
				}
			}, 0L, 1L).getTaskId();
			fr.put(p.getName(),Integer.valueOf(task5));
		}
	}

}
