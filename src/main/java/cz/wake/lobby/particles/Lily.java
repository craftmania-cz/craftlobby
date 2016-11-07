package cz.wake.lobby.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ParticleEffect;
import cz.wake.lobby.utils.UtilMath;
import cz.wake.lobby.utils.UtilParticles;
import cz.wake.lobby.utils.UtilVelocity;

public class Lily {
	
	public static final HashMap<String,Integer> li = new HashMap();
	public int step = 0;
	public static int task17;
	
	@SuppressWarnings("deprecation")
	public void activateSignal(Player p){
		if(!li.containsKey(p.getName())){
			task17 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				double radius = 0.1D;
				double angularVelocityX = 0.08975979010256552D;
				@Override
				public void run() {
					if(li.containsKey(p.getName()) && p.isOnline()){
						Location location = p.getLocation();
			            Location location2 = p.getLocation();
			            step += 1;
			            if (step >= 3000) {
			              step = 0;
			            }
			            double xRotation = step * this.angularVelocityX;
			            this.radius += 0.1D;
			            if (this.radius >= 1.0D) {
			              this.radius = 0.1D;
			            }
			            if (p.isInsideVehicle())
			              {
			                location.subtract(0.0D, 1.0D, 0.0D);
			                location2.subtract(0.0D, 1.0D, 0.0D);
			              }
			              double amount = this.radius * 20.0D;
			              double inc = 6.283185307179586D / amount;
			              for (int i = 0; i < amount; i++)
			              {
			                double angle = i * inc;
			                double x = 0.2617993877991494D * angle * Math.cos(angle);
			                double z = 0.2617993877991494D * angle * Math.sin(angle);
			                
			                double x2 = -0.2617993877991494D * angle * Math.cos(angle);
			                double z2 = -0.2617993877991494D * angle * Math.sin(angle);
			                Vector v = new Vector(x, 0.10000000149011612D, z);
			                Vector v2 = new Vector(x2, 0.10000000149011612D, z2);
			                UtilVelocity.rotateAroundAxisY(v, -xRotation);
			                UtilVelocity.rotateAroundAxisY(v2, -xRotation);
			                location.add(v);
			                location2.add(v2);
			                int step = UtilMath.randRange(0, 50);
			                int step2 = UtilMath.randRange(100, 255);
			                if (step % 2 == 0)
			                {
			                  ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(step, step2, 0), location, 5.0D);
			                  ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(step, step2, 0), location2, 5.0D);
			                  
			                }
			                else
			                {
			                  ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, step2, step), location, 5.0D);
			                  ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, step2, step), location2, 5.0D);
			                }
			                if (step2 % 2 == 0){
			                  UtilParticles.play(location, Effect.FLAME, 0.0F, 0.0F, 0.0f);
			                } else {
			                	UtilParticles.play(location2, Effect.FLAME, 0.0F, 0.0F, 0.0f);
			                }
			                location.subtract(v);
			                location2.subtract(v2);
			              }
					} 
				}
				
			}, 0L, 1L).getTaskId();
			li.put(p.getName(), Integer.valueOf(task17));
		}
	}

}
