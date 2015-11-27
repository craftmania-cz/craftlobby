package cz.wake.plugins.utils;

import java.text.DecimalFormat;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import cz.wake.plugins.Main;

public class UtilMath
{
	
  public static double trim(int degree, double d)
  {
    String format = "#.#";
    for (int i = 1; i < degree; i++) {
      format = format + "#";
    }
    DecimalFormat twoDForm = new DecimalFormat(format);
    return Double.valueOf(twoDForm.format(d)).doubleValue();
  }
  
  public static Random random = new Random();
  
  public static int r(int i)
  {
    return random.nextInt(i);
  }
  
  public static int randRange(int min, int max)
  {
    Random rand = new Random();
    int randomNum = rand.nextInt(max - min + 1) + min;
    return randomNum;
  }
  
  public static double randomRange(double paramDouble1, double paramDouble2)
  {
    return Math.random() < 0.5D ? (1.0D - Math.random()) * (paramDouble2 - paramDouble1) + paramDouble1 : Math.random() * (paramDouble2 - paramDouble1) + paramDouble1;
  }
  
  public static double offset2d(Entity a, Entity b)
  {
    return offset2d(a.getLocation().toVector(), b.getLocation().toVector());
  }
  
  public static double offset2d(Location a, Location b)
  {
    return offset2d(a.toVector(), b.toVector());
  }
  
  public static double offset2d(Vector a, Vector b)
  {
    a.setY(0);
    b.setY(0);
    return a.subtract(b).length();
  }
  
  public static double offset(Entity a, Entity b)
  {
    return offset(a.getLocation().toVector(), b.getLocation().toVector());
  }
  
  
  public static double offset(Location a, Location b)
  {
    return offset(a.toVector(), b.toVector());
  }
  
  public static double offset(Vector a, Vector b)
  {
    return a.subtract(b).length();
  }
  
  public static Vector getRandomVector()
  {
    double x = random.nextDouble() * 2.0D - 1.0D;
    double y = random.nextDouble() * 2.0D - 1.0D;
    double z = random.nextDouble() * 2.0D - 1.0D;
    
    return new Vector(x, y, z).normalize();
  }
  
  
  public static Vector getRandomCircleVector()
  {
    double rnd = random.nextDouble() * 2.0D * 3.141592653589793D;
    double x = Math.cos(rnd);
    double z = Math.sin(rnd);
    
    return new Vector(x, 0.0D, z);
  }
  
  public static Material getRandomMaterial(Material[] materials)
  {
    return materials[random.nextInt(materials.length)];
  }
  
  public static double getRandomAngle()
  {
    return random.nextDouble() * 2.0D * 3.141592653589793D;
  }
  
  public static final Vector rotateAroundAxisX(Vector v, double angle) {
      double y, z, cos, sin;
      cos = Math.cos(angle);
      sin = Math.sin(angle);
      y = v.getY() * cos - v.getZ() * sin;
      z = v.getY() * sin + v.getZ() * cos;
      return v.setY(y).setZ(z);
  }

  public static final Vector rotateAroundAxisY(Vector v, double angle) {
      double x, z, cos, sin;
      cos = Math.cos(angle);
      sin = Math.sin(angle);
      x = v.getX() * cos + v.getZ() * sin;
      z = v.getX() * -sin + v.getZ() * cos;
      return v.setX(x).setZ(z);
  }

  public static final Vector rotateAroundAxisZ(Vector v, double angle) {
      double x, y, cos, sin;
      cos = Math.cos(angle);
      sin = Math.sin(angle);
      x = v.getX() * cos - v.getY() * sin;
      y = v.getX() * sin + v.getY() * cos;
      return v.setX(x).setY(y);
  }

  public static final Vector rotateVector(Vector v, double angleX, double angleY, double angleZ) {
      rotateAroundAxisX(v, angleX);
      rotateAroundAxisY(v, angleY);
      rotateAroundAxisZ(v, angleZ);
      return v;
  }

  public static final double angleToXAxis(Vector vector) {
      return Math.atan2(vector.getX(), vector.getY());
  }


  public static void applyVector(final Entity ent, Vector v) {
      if (ent instanceof Player) {
          final Player p = (Player) ent;
          if (p.hasPermission("ultracosmetics.sneakfornoeffects") && p.isSneaking()) {
              return;
          }
      }
      ent.setVelocity(v);
      Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
          @Override
          public void run() {
              Main.noFallDamageEntities.add(ent);
          }
      }, 4);
  }

  public static double randomDouble(double min, double max) {
      return Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min);
  }

  public static float randomRangeFloat(float min, float max) {
      return (float) (Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min));
  }

  public static int randomRangeInt(int min, int max) {
      return (int) (Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min));
  }
  
  public static Vector getVector(Boolean light)
  {
    int length = 5;
    if (light.booleanValue()) {
      length = 1 + random.nextInt(3);
    } else {
      length = 1 + random.nextInt(12);
    }
    float flt = (random.nextInt(2 * length) - length) / 10.0F;
    
    Vector velocity = new Vector(flt, 1.0F + Math.abs(flt), flt);
    
    return velocity;
  }
  
  public static float get(int length)
  {
    return (random.nextInt(2 * length) - length) / 10.0F;
  }
  
  public static void applyVelocity(Entity ent, Vector v)
  {
    if (ent.hasMetadata("NPC")) {
      return;
    }
    ent.setVelocity(v);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable()
    {
	public void run()
      {
        Main.noFallDamageEntities.add(ent);
      }
    }, 4L);
  }
}
