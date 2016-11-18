package cz.wake.lobby.cloaks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ParticleEffect;

public class AngleCloak {
	
	public static final HashMap<String, Integer> angelCloaks = new HashMap();
	int particles;
	boolean x = true;
    boolean o = false;

	@SuppressWarnings("deprecation")
	public void activate(Player p){
        if (Main.getInstance().getTPS() < 17) {
            p.sendMessage("§cServer je pretizeny, nelze pouzivat gadgets!");
            return;
        }
		if(!angelCloaks.containsKey(p.getName())){
			
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE,1);
			LeatherArmorMeta hMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			hMeta.setColor(Color.WHITE);
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
				int particles = 40;
			    float radius = 0.4F;
			    protected int i;
			    int speed = 3;
			    double height = 0.25D;
				@Override
				public void run() {
					if(angelCloaks.containsKey(p.getName())){
						Location location = p.getEyeLocation();
				        
				        double angle = 6.283185307179586D * this.i / this.particles;
				        double x = Math.cos(angle) * this.radius;
				        double z = Math.sin(angle) * this.radius;
				        location.add(x, this.height, z);
				        ParticleEffect.FLAME.display(0F, 0F, 0F, 0F, particles, location, 15.0D);
				        location.subtract(x, 0.0D, z);
				        this.i += this.speed;
				        drawParticles(p.getLocation());
					}
				}
				
			}, 0L, 4L).getTaskId();
			angelCloaks.put(p.getName(),Integer.valueOf(particles));
		}
	}
	
	private boolean[][] shape = {
            {o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
            {o, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, o, o},
            {o, o, x, x, x, x, x, o, o, o, x, x, x, x, x, o, o, o},
            {o, o, o, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o},
            {o, o, o, o, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
            {o, o, o, o, x, x, x, x, o, x, x, x, x, o, o, o, o, o},
            {o, o, o, o, o, x, x, x, o, x, x, x, o, o, o, o, o, o},
            {o, o, o, o, o, x, x, o, o, o, x, x, o, o, o, o, o, o},
            {o, o, o, o, x, x, o, o, o, o, o, x, x, o, o, o, o, o}
    };
	
	private void drawParticles(Location location) {
        double space = 0.2;
        double defX = location.getX() - (space * shape[0].length / 2) + space;
        double x = defX;
        double y = location.clone().getY() + 2;
        double angle = -((location.getYaw() + 180) / 60);
        angle += (location.getYaw() < -180 ? 3.25 : 2.985);

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j]) {

                    Location target = location.clone();
                    target.setX(x);
                    target.setY(y);

                    Vector v = target.toVector().subtract(location.toVector());
                    Vector v2 = getBackVector(location);
                    v = rotateAroundAxisY(v, angle);
                    v2.setY(0).multiply(-0.2);

                    location.add(v);
                    location.add(v2);
                    for (int k = 0; k < 3; k++)
                        location.getWorld().spigot().playEffect(location, Effect.COLOURED_DUST, 0, 0, 1, 1, 1, 1, 0, 64);
                    location.subtract(v2);
                    location.subtract(v);
                }
                x += space;
            }
            y -= space;
            x = defX;
        }
    }

    public static Vector rotateAroundAxisY(Vector v, double angle) {
        double x, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static Vector getBackVector(Location loc) {
        final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 90 * 1))));
        final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 90 * 1))));
        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }
    
    /**
     * Location location = p.getEyeLocation();
				        for (int i = 0; i < this.particles; i++)
				        {
				          Vector vector = UtilMath.getRandomVector().multiply(this.radius);
				          location.add(vector);
				          ParticleEffect.FLAME.display(0F, 0F, 0F, 0F, 1, location, 15.0D);
				          location.subtract(vector);
				        }
     */
}
