package cz.wake.plugins.particles;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class MobSpell{
	
	public HashSet<Player> ms = new HashSet<Player>();
	int task;
	
	@SuppressWarnings("deprecation")
	public void activateSpell(Player p){
		if(!this.ms.contains(p)){
			this.ms.add(p);
			task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){

				@Override
				public void run() {
					if(ms.contains(p) && p.isOnline()){
						ParticleEffect.SPELL_MOB.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
					} else {
						Bukkit.getScheduler().cancelTask(task);
						ms.remove(p);
					}
				}
			}, 0L, 1L).getTaskId();
		} 
	}
	
	public void deactivateSpell(Player p){
		Bukkit.getScheduler().cancelTask(task);
		ms.remove(p);
	}

}
