package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class Clouds implements Listener{
	
	public static ArrayList<Player> cloudsPlayers = new ArrayList();
	
	public static void activateClouds(Player p){
		if(!cloudsPlayers.contains(p)){
			Clouds.cloudsPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(cloudsPlayers.contains(p)){
					UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.CLOUD, 0, 0, 0.7f, 1f, 0.7f, 0, 5);
				}
			}
		}, 0L, 4L);
		
	}
	
	public static void deactivateClouds(Player p){
		Clouds.cloudsPlayers.remove(p);
	}

}
