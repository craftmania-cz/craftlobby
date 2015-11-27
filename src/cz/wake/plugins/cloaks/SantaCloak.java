package cz.wake.plugins.cloaks;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ItemFactory;
import cz.wake.plugins.utils.ParticleEffect;
import cz.wake.plugins.utils.UtilMath;
import cz.wake.plugins.utils.UtilParticles;

public class SantaCloak implements Listener{
	
	public HashSet<Player> santaCloaks = new HashSet<Player>();
	int particles;
	
	@SuppressWarnings("deprecation")
	public void activateSanta(Player p){
		if(!this.santaCloaks.contains(p)){
			this.santaCloaks.add(p);
			
			ItemStack skull = ItemFactory.createHead("§fSanta", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
			p.getInventory().setHelmet(skull);
			
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE,1);
			LeatherArmorMeta hMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			hMeta.setColor(Color.RED);
			chestplate.setItemMeta(hMeta);
			p.getInventory().setChestplate(chestplate);
			
			ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS,1);
			LeatherArmorMeta lMeta = (LeatherArmorMeta)leggins.getItemMeta();
			lMeta.setColor(Color.WHITE);
			leggins.setItemMeta(lMeta);
			p.getInventory().setLeggings(leggins);
			
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS,1);
			LeatherArmorMeta bMeta = (LeatherArmorMeta) boots.getItemMeta();
			bMeta.setColor(Color.WHITE);
			boots.setItemMeta(bMeta);
			p.getInventory().setBoots(boots);
			
			particles = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable(){
				float step = 0;
				@Override
				public void run() {
					if(santaCloaks.contains(p) && p.isOnline()){
						for (int i = 0; i < 2; i++) {
				            double inc = (2 * Math.PI) / 100;
				            double toAdd = 0;
				            if(i == 1)
				                toAdd = 3.5;
				            double angle = step * inc + toAdd;
				            Vector v = new Vector();
				            v.setX(Math.cos(angle));
				            v.setZ(Math.sin(angle));
				            if(i == 0) {
				                UtilMath.rotateAroundAxisZ(v, 180);
				            } else {
				            	UtilMath.rotateAroundAxisZ(v, 90);
				            }
				            UtilParticles.play(p.getLocation().clone().add(0, 1, 0).add(v), Effect.COLOURED_DUST, 0f);
				            ParticleEffect.SNOW_SHOVEL.display(1.0f, 1.0f, 1.0f, 0, 3, p.getLocation(), 30.0D);
				        }
				        step += 3;
					} else {
						Bukkit.getScheduler().cancelTask(particles);
						santaCloaks.remove(p);
					}
				}	
			}, 0L, 1L).getTaskId();	
		}
	}
	
	
	public void deaktivateSanda(Player p){
		Bukkit.getScheduler().cancelTask(particles);
		santaCloaks.remove(p);
	}
	
	

}
