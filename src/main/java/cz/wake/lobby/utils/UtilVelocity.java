package cz.wake.lobby.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class UtilVelocity {

    public static Vector getBumpVector(Entity entity, Location from, double power) {
        Vector bump = entity.getLocation().toVector().subtract(from.toVector()).normalize();
        bump.multiply(power);
        return bump;
    }

    public static Vector getPullVector(Entity entity, Location to, double power) {
        Vector pull = to.toVector().subtract(entity.getLocation().toVector()).normalize();
        pull.multiply(power);
        return pull;
    }

    public static void bumpEntity(Entity entity, Location from, double power) {
        entity.setVelocity(getBumpVector(entity, from, power));
    }

    public static void bumpEntity(Entity entity, Location from, double power, double fixedY) {
        Vector vector = getBumpVector(entity, from, power);
        vector.setY(fixedY);
        entity.setVelocity(vector);
    }

    public static void pullEntity(Entity entity, Location to, double power) {
        entity.setVelocity(getPullVector(entity, to, power));
    }

    public static void pullEntity(Entity entity, Location from, double power, double fixedY) {
        Vector vector = getPullVector(entity, from, power);
        vector.setY(fixedY);
        entity.setVelocity(vector);
    }

    public static final Vector rotateAroundAxisX(Vector v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static final Vector rotateAroundAxisY(Vector v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static final Vector rotateAroundAxisZ(Vector v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos - v.getY() * sin;
        double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    public static final Vector rotateVector(Vector v, double angleX, double angleY, double angleZ) {
        rotateAroundAxisX(v, angleX);
        rotateAroundAxisY(v, angleY);
        rotateAroundAxisZ(v, angleZ);
        return v;
    }


}
