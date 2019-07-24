package cz.wake.lobby.gadgets.cloaks;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class DevilCloak {

    public static final HashMap<String, Integer> devilCloaks = new HashMap();
    int particles;
    boolean x = true;
    boolean o = false;

    @SuppressWarnings("deprecation")
    public void activate(Player p) {
        if (Main.getInstance().getTPS() < 17) {
            p.sendMessage("§c§l[!] §cServer je pretizeny, nelze pouzivat gadget!");
            return;
        }
        if (!devilCloaks.containsKey(p.getName())) {

            ItemStack head = ItemFactory.createHead("§7Devil", "c3c88c33-f305-4c10-9303-ce658b2fbde7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRhMzkyNjllZjQ1ZjgyNWVjNjFiYjRmOGFhMDliZDNjZjA3OTk2ZmI2ZmFjMzM4YTZlOTFkNjY5OWFlNDI1In19fQ==");
            p.getInventory().setHelmet(head);

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta hMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            hMeta.setColor(Color.BLACK);
            chestplate.setItemMeta(hMeta);
            p.getInventory().setChestplate(chestplate);

            ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta lMeta = (LeatherArmorMeta) leggins.getItemMeta();
            lMeta.setColor(Color.BLACK);
            leggins.setItemMeta(lMeta);
            p.getInventory().setLeggings(leggins);

            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bMeta = (LeatherArmorMeta) boots.getItemMeta();
            bMeta.setColor(Color.BLACK);
            boots.setItemMeta(bMeta);
            p.getInventory().setBoots(boots);

            particles = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (devilCloaks.containsKey(p.getName())) {
                        drawParticles(p.getLocation().add(0.0D, 0.2D, 0.0D));
                    }
                }
            }, 0L, 4L).getTaskId();
            devilCloaks.put(p.getName(), Integer.valueOf(particles));
        }
    }

    private boolean[][] shape = {
            {o, o, o, o, x, o, o, o, o, o, o, o, x, o, o, o, o, o},
            {o, o, o, x, x, o, o, o, o, o, o, o, x, x, o, o, o, o},
            {o, o, x, x, x, o, o, o, o, o, o, o, x, x, x, o, o, o},
            {o, x, x, x, x, x, o, o, o, o, o, x, x, x, x, x, o, o},
            {o, o, x, x, x, x, x, o, o, o, x, x, x, x, x, o, o, o},
            {o, o, o, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o},
            {o, o, o, o, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
            {o, o, o, o, x, x, x, x, o, x, x, x, x, o, o, o, o, o},
            {o, o, o, o, o, x, x, x, o, x, x, x, o, o, o, o, o, o},
            {o, o, o, o, o, x, x, o, o, o, x, x, o, o, o, o, o, o},
            {o, o, o, o, o, x, x, o, o, o, x, x, o, o, o, o, o, o}
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
                        location.getWorld().spigot().playEffect(location, Effect.FLAME, 0, 0, 1, 1, 1, 0, 0, 64);
                    location.subtract(v2);
                    location.subtract(v);
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

    private static Vector getBackVector(Location loc) {
        final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 90 * 1))));
        final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 90 * 1))));
        return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
    }

}
