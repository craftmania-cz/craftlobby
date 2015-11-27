package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class MobSpell implements Listener{
	
	public static ArrayList<Player> mobSpells = new ArrayList();
	
	public static void activateSpell(Player p){
		if(!MobSpell.mobSpells.contains(p)){
			MobSpell.mobSpells.add(p);
		} else {
			return;
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(MobSpell.mobSpells.contains(p)){
					ParticleEffect.SPELL_MOB.display(1.0F, 1.0F, 1.0F, 0.1F, 15, p.getLocation(), 15.0D);
				}
			}
		}, 0L, 1L);
		
	}
	
	public static void deactivateSpell(Player p){
		MobSpell.mobSpells.remove(p);
	}

}
