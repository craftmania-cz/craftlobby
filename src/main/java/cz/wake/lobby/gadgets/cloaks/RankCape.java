package cz.wake.lobby.gadgets.cloaks;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.UtilParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class RankCape {

    public static final HashMap<String, Integer> heroCloaks = new HashMap();
    private boolean x = true;
    private boolean y = false;
    private int particles;

    private boolean[][] shapeM = {
            {x, x, x, x, x,},
            {x, y, x, y, x,},
            {x, y, y, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, x, x, x, x,},
    };

    private boolean[][] shapeH = {
            {x, x, x, x, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, y, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, x, x, x, x,},
    };

    private boolean[][] shapeA = {
            {x, x, x, x, x,},
            {x, y, y, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, y, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, x, x, x, x,},
    };

    private boolean[][] shapeB = {
            {x, x, x, x, x,},
            {x, x, y, y, x,},
            {x, y, x, y, x,},
            {x, x, y, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, x, y, y, x,},
            {x, x, x, x, x,},
    };

    private boolean[][] shapeVIP = {
            {x, x, x, x, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, y, x, y, x,},
            {x, x, y, x, x,},
            {x, x, x, x, x,},
    };

    private boolean[][] shapeSpirit = {
            {x, x, x, x, x,},
            {x, y, y, y, x,},
            {x, x, x, y, x,},
            {x, y, y, y, x,},
            {x, y, x, x, x,},
            {x, y, x, x, x,},
            {x, y, y, y, x,},
            {x, x, x, x, x,},
    };

    public void activate(Player p) {
        boolean[][] type = shapeM;
        int borderRed = 0;
        int borderGreen = 0;
        int borderBlue = 0;
        int textRed = 255;
        int textGreen = 255;
        int textBlue = 255;
        if (p.hasPermission("craftlobby.cape.majitel")) {
            type = shapeM;
            borderRed = 30;
            borderGreen = 144;
            borderBlue = 255;
        } else if (p.hasPermission("craftlobby.cape.admin")) {
            type = shapeA;
            borderRed = 255;
            borderGreen = 48;
            borderBlue = 48;
        } else if (p.hasPermission("craftlobby.cape.builder")) {
            type = shapeB;
            borderRed = 142;
            borderGreen = 56;
            borderBlue = 142;
        } else if (p.hasPermission("craftlobby.cape.helper")) {
            type = shapeH;
            borderRed = 0;
            borderGreen = 139;
            borderBlue = 0;
        } else if (p.hasPermission("craftlobby.cape.vip")) {
            type = shapeVIP;
            borderRed = 0;
            borderGreen = 240;
            borderBlue = 0;
        } else if (p.hasPermission("craftlobby.cape.spirit")) {
            type = shapeSpirit;
            borderRed = 139;
            borderGreen = 0;
            borderBlue = 0;
            textRed = 255;
            textGreen = 165;
            textBlue = 0;
        }
        if (!heroCloaks.containsKey(p.getName())) {
            boolean[][] finalType = type;
            int finalBorderRed = borderRed;
            int finalBorderGreen = borderGreen;
            int finalBorderBlue = borderBlue;
            int finalTextRed = textRed;
            int finalTextGreen = textGreen;
            int finalTextBlue = textBlue;
            particles = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (heroCloaks.containsKey(p.getName())) {
                        drawParticles(p.getLocation(), p, finalType, finalBorderRed, finalBorderGreen, finalBorderBlue,
                                finalTextRed, finalTextGreen, finalTextBlue);
                    }
                }

            }, 0L, 2L).getTaskId();
            heroCloaks.put(p.getName(), Integer.valueOf(particles));
            p.closeInventory();
        }
    }

    private void drawParticles(Location location, Player p, boolean[][] typeShape, int red, int green, int blue,
                               int textRed, int textGreen, int textBlue) {
        double space = 0.2;
        double defX = location.getX() - (space * typeShape[0].length / 2) + space / 2;
        double x = defX;
        double defY = location.getY() + 1.5;
        double y = defY;
        double angle = -((location.getYaw() + 180) / 60);
        angle += (location.getYaw() < -180 ? 3.25 : 2.985);
        for (int i = 0; i < typeShape.length; i++) {
            for (int j = 0; j < typeShape[i].length; j++) {
                if (typeShape[i][j]) {
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
                        UtilParticles.display(red, green, blue, loc);
                    loc.subtract(v2);
                    loc.subtract(v);
                } else {
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
                        UtilParticles.display(textRed, textGreen, textBlue, loc);
                    loc.subtract(v2);
                    loc.subtract(v);
                }
                x += space;
            }
            y -= space;
            x = defX;
        }
    }

    private static Vector rotateAroundAxisY(Vector v, double angle) {
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

    private static Vector getBackVector(Location loc) {
        final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 90 * 1))));
        final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 90 * 1))));
        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }

    public static void deactivateCape(Player player) {
        if (RankCape.heroCloaks.containsKey(player.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) RankCape.heroCloaks.get(player.getName())).intValue());
            RankCape.heroCloaks.remove(player.getName());
        }
    }

}
