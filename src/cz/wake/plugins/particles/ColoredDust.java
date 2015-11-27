package cz.wake.plugins.particles;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilParticles;

public class ColoredDust implements Listener{
	
	public static ArrayList<Player> dustPlayers = new ArrayList();
	
	public static void activateDust(Player p){
		if(!dustPlayers.contains(p)){
			ColoredDust.dustPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(dustPlayers.contains(p)){
					ParticleEffect.REDSTONE.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
				}
			}
		}, 0L, 4L);
		
	}
	
	public static void deactivateClouds(Player p){
		ColoredDust.dustPlayers.remove(p);
	}

}
