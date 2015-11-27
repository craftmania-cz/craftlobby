package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class LavaPop implements Listener{
	
	public static ArrayList<Player> lavaPlayers = new ArrayList();
	
	public static void activateDust(Player p){
		if(!lavaPlayers.contains(p)){
			LavaPop.lavaPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(lavaPlayers.contains(p)){
					UtilParticles.play(p.getLocation().add(0, 1, 0), Effect.LAVA_POP, 0, 0, 0.5f, 0.5f, 0.5f, 0, 4);
				}
			}
		}, 0L, 4L);
		
	}
	
	public static void deactivateDust(Player p){
		LavaPop.lavaPlayers.remove(p);
	}

}
