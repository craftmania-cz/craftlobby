package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class SnowCloud implements Listener{
	
	public static ArrayList<Player> snowClouds = new ArrayList();
	
	public static void activateSnowCloud(Player p){
		if(!SnowCloud.snowClouds.contains(p)){
			SnowCloud.snowClouds.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(SnowCloud.snowClouds.contains(p)){
					UtilParticles.play(p.getLocation().add(0, 3, 0),Effect.CLOUD, 0, 0, 0.5F, 0.1f, 0.5f, 0, 10);
					UtilParticles.play(p.getLocation().add(0, 3, 0), Effect.SNOW_SHOVEL, 0, 0, 0.25F, 0.05f, 0.25f, 0, 1);
				}
			}
		}, 0L, 3L);
	}
	
	public static void deactivateSnowCloud(Player p){
		SnowCloud.snowClouds.remove(p);
	}
}
