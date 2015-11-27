package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class Enchanted implements Listener{
	
	public static ArrayList<Player> enchantedPlayers = new ArrayList();
	
	public static void activateEnchanted(Player p){
		if(!Enchanted.enchantedPlayers.contains(p)){
			Enchanted.enchantedPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(Enchanted.enchantedPlayers.contains(p)){
					for (int i = 0; i < 60; i++){
						UtilParticles.play(p.getLocation().add(0, UtilMath.randomDouble(0.1, 2), 0), Effect.FLYING_GLYPH, 0, 0, 0, 0, 0, 8f, 1);
					}
				}
			}
		}, 0L, 4L);
	}

	public static void deactivateEnchanted(Player p){
		Enchanted.enchantedPlayers.remove(p);
	}
}
