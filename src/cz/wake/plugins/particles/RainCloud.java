package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class RainCloud implements Listener{
	
	public static ArrayList<Player> rainClouds = new ArrayList();
	
	public static void activateRainCloud(Player p){
		if(!RainCloud.rainClouds.contains(p)){
			RainCloud.rainClouds.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(RainCloud.rainClouds.contains(p)){
					UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.CLOUD, 0, 0, 0.5F, 0.1f, 0.5f, 0, 10);
			        UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.WATERDRIP, 0, 0, 0.25F, 0.05f, 0.25f, 0, 1);
				}
			}
		}, 0L, 3L);
	}
	
	public static void deactivateRainCloud(Player p){
		RainCloud.rainClouds.remove(p);
	}

}
