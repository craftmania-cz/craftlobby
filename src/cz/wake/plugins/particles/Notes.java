package cz.wake.plugins.particles;

import java.util.HashSet;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;

public class Notes{
	
	public HashSet<Player> no = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateNotes(Player p){
		if(!this.no.contains(p)){
			this.no.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				@Override
				public void run() {
					if(no.contains(p) && p.isOnline()){
						for (int i = 0; i < 12; i++) {
							 Random random = new Random();
					         int j = random.nextInt(25);
					         ParticleEffect.ParticleColor pc = new ParticleEffect.NoteColor(j);
					         ParticleEffect.NOTE.display(pc, p.getLocation().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(0, 2.5), UtilMath.randomDouble(-1.5, 1.5)), 32);
						}
					} else {
						Bukkit.getScheduler().cancelTask(task);
						no.remove(p);
					}
					
				}
				
			}, 0L, 4L).getTaskId();
		} 
	}
	
	public void deactivateNotes(Player p){
		Bukkit.getScheduler().cancelTask(task);
		no.remove(p);
	}

}
