package cz.wake.lobby.armorstands.characters;

import cz.wake.craftcore.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class DJClub implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1540.5, 15, -1249.5, 180, 0);
    private ArmorStand as;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        ItemStack head = ItemFactory.createHead("test", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0=");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 61, 89, 171);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 61, 89, 171);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 61, 89, 171);
        as.setBoots(boots);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Wake", "Wake", Main.getInstance());

        new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
                if (i == 0) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0));
                    as.setLeftArmPose(new EulerAngle(3, 0, 7.0));
                    as.setHeadPose(new EulerAngle(0.1, 0, 0));
                    spawnParticles();
                    i++;
                } else if (i == 1) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0.2));
                    as.setLeftArmPose(new EulerAngle(3, 0, 6.8));
                    as.setHeadPose(new EulerAngle(0.2, 0, 0));
                    spawnParticles();
                    i++;
                } else if (i == 2) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0.4));
                    as.setLeftArmPose(new EulerAngle(3, 0, 6.6));
                    as.setHeadPose(new EulerAngle(0.3, 0, 0));
                    spawnParticles();
                    i++;
                } else if (i == 3) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0.6));
                    as.setLeftArmPose(new EulerAngle(3, 0, 6.4));
                    as.setHeadPose(new EulerAngle(0.2, 0, 0));
                    spawnParticles();
                    i++;
                } else if (i == 4) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0.4));
                    as.setLeftArmPose(new EulerAngle(3, 0, 6.6));
                    as.setHeadPose(new EulerAngle(0.1, 0, 0));
                    spawnParticles();
                    i++;
                } else if (i == 5) {
                    as.setRightArmPose(new EulerAngle(5.2, 0, 0.2));
                    as.setLeftArmPose(new EulerAngle(3, 0, 6.8));
                    as.setHeadPose(new EulerAngle(0.0, 0, 0));
                    spawnParticles();
                    i = 0;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 5l);
    }

    @Override
    public void hologramSpawn() {

    }

    @Override
    public void subtextSpawn() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void remove() {
        as.remove();
    }

    private void spawnParticles() {
        if (Bukkit.getOnlinePlayers().size() >= 1) {
            try {
                Location loc = new Location(Bukkit.getWorld("omain"), 1540, 19, -1257);
                ParticleEffect.FIREWORKS_SPARK.display(3.0f, 0f, 3.0f, 0.05f, 15, loc, SettingsMenu.particles);
            } catch (IllegalArgumentException e) {
                // Nic
            }
        }
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
