package cz.wake.plugins.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilParticles;

public class SuperHero {
	
	public static ArrayList<Player> superHero = new ArrayList();
	boolean x = true;
    boolean o = false;
	
	public void activateHero(Player p){
		if(!superHero.contains(p)){
			superHero.add(p);
		}
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
			@Override
			public void run(){
				if(superHero.contains(p)){
					drawParticles(p.getLocation(), p);
			        UtilParticles.play(p.getLocation(), Effect.CLOUD, 0, 0, 0.15F, 0.1f, 0.15f, 0, 4);
				}
			}
		}, 0L, 3L);
	}
	
	private boolean[][] shape = {
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
            {x, x, x, x, x,},
    };
	
	private void drawParticles(Location location,Player p) {
        double space = 0.2;
        double defX = location.getX() - (space * shape[0].length / 2) + space / 2;
        double x = defX;
        double defY = location.getY() + 1.5;
        double y = defY;
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
                    double iT = ((double) i) / 10;
                    v2.setY(0).multiply(-0.2 - iT);

                    Location loc = location.clone();

                    loc.add(v);
                    loc.add(v2);
                    if (p.isSprinting())
                        loc.setY(defY);

                    for (int k = 0; k < 3; k++)
                        location.getWorld().spigot().playEffect(loc, Effect.COLOURED_DUST, 0, 0, 1, 0, 0, 1, 0, 64);
                    loc.subtract(v2);
                    loc.subtract(v);
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

    public static final Vector rotateAroundAxisX(Vector v, double angle) {
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static final Vector rotateAroundAxisZ(Vector v, double angle) {
        double x, y, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos - v.getY() * sin;
        y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    public static Vector getBackVector(Location loc) {
        final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 90 * 1))));
        final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 90 * 1))));
        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }
    
    public static void deactivateHero(Player p){
    	superHero.remove(p);
	}

}
