package cz.wake.plugins.particles;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class Notes implements Listener{
	
	public static ArrayList<Player> notesPlayers = new ArrayList();
	
	public static void activateNotes(Player p){
		if(!Notes.notesPlayers.contains(p)){
			Notes.notesPlayers.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(notesPlayers.contains(p)){
					for (int i = 0; i < 12; i++) {
						 Random random = new Random();
				         int j = random.nextInt(25);
				         ParticleEffect.ParticleColor pc = new ParticleEffect.NoteColor(j);
				         ParticleEffect.NOTE.display(pc, p.getLocation().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(0, 2.5), UtilMath.randomDouble(-1.5, 1.5)), 32);
					}
				}
			}
		}, 0L, 4L);
	}
	
	public static void deactivateNotes(Player p){
		Notes.notesPlayers.remove(p);
	}

}
