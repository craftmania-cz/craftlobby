package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class FlameRings{
	
	public HashSet<Player> fr = new HashSet<Player>();
	int task1;
	
	@SuppressWarnings("deprecation")
	public void activateFlame(Player p){
		if(!this.fr.contains(p)){
			this.fr.add(p);
			task1 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				float step = 0;
				@Override
				public void run() {
					if(fr.contains(p) && p.isOnline()){
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
					} else {
						Bukkit.getScheduler().cancelTask(task1);
						fr.remove(p);
					}
				}
			}, 0L, 1L).getTaskId();
		}
	}
	
	public void deactivateFlame(Player p){
		Bukkit.getScheduler().cancelTask(task1);
		fr.remove(p);
	}

}
