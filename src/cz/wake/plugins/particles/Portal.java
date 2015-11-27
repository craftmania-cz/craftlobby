package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class Portal implements Listener{
	
	public static ArrayList<Player> portalPlayers = new ArrayList();
	
	public static void activatePortal(Player p){
		if(!Portal.portalPlayers.contains(p)){
			Portal.portalPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(Portal.portalPlayers.contains(p)){
					ParticleEffect.PORTAL.display(1.0F, 1.0F, 1.0F, 0.0F, 20, p.getLocation(), 15.0D);
				}
			}
		}, 0L, 4L);
	}

	public static void deactivatePortal(Player p){
		Portal.portalPlayers.remove(p);
	}

}
