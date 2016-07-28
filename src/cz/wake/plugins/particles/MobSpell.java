package cz.wake.plugins.particles;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;

public class MobSpell{
	
	public static final HashMap<String,Integer> ms = new HashMap();
	public static int task15;
	
	@SuppressWarnings("deprecation")
	public void activateSpell(Player p){
		if(!ms.containsKey(p.getName())){
			task15 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){

				@Override
				public void run() {
					if(ms.containsKey(p.getName()) && p.isOnline()){
						ParticleEffect.SPELL_MOB.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
					} 
				}
			}, 0L, 1L).getTaskId();
			ms.put(p.getName(), Integer.valueOf(task15));
		} 
	}
}
