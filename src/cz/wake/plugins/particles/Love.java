package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class Love implements Listener{
	
	public static ArrayList<Player> lovePlayers = new ArrayList();
	
	public static void activateLove(Player p){
		if(!Love.lovePlayers.contains(p)){
			Love.lovePlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(lovePlayers.contains(p)){
					UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.HEART, 0, 0, 0.5f, 0.5f, 0.5f, 0, 2);
				}
			}
		}, 0L, 4L);
	}
	
	public static void deaktivateLove(Player p){
		Love.lovePlayers.remove(p);
	}

}
