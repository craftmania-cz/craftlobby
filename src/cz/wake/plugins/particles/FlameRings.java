package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class FlameRings implements Listener{
	
	public static ArrayList<Player> flameRings = new ArrayList();
	
	public static void activateFlame(Player p){
		if(!FlameRings.flameRings.contains(p)){
			FlameRings.flameRings.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			float step = 0;
			@Override
			public void run(){
				if(FlameRings.flameRings.contains(p)){
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
		}, 0L, 1L);
		
	}
	
	public static void deactivateFlame(Player p){
		FlameRings.flameRings.remove(p);
	}

}
