package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class EnderSignal implements Listener{
	
	public static ArrayList<Player> enderSignalPlayers = new ArrayList();
	
	public static void activateSignal(Player p){
		if(!EnderSignal.enderSignalPlayers.contains(p)){
			EnderSignal.enderSignalPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(enderSignalPlayers.contains(p)){
					UtilParticles.play(p.getLocation().add(0,1.5,0), Effect.ENDER_SIGNAL);
				}
			}
		}, 0L, 1L);
		
		
	}
	
	public static void deaktivateSignal(Player p){
		if(enderSignalPlayers.contains(p)){
			enderSignalPlayers.remove(p);
		} else {
			return;
		}
	}

}
