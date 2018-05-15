package cz.wake.lobby.armorstands.podlobby;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.CustomSheep;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.metadata.FixedMetadataValue;

public class BedWarsSheep {

    private static ArmorStand as, as2;
    private static Location loc = new Location(Bukkit.getWorld("obw2"), -602.5, 111, 105.5, 0, 0);

    public static void spawnSheep() {
        final Sheep sheep = CustomSheep.spawn(loc);
        setMetadata(sheep, "bwSheep", "bwSheep", Main.getInstance());
        (sheep).setAgeLock(true);
        (sheep).setColor(DyeColor.LIME);
        (sheep).setAI(false);
        hologramSpawn();
    }

    public static void setMetadata(Sheep paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

    private static void hologramSpawn() {

        loc.add(0, 0.2, 0);

        as = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setVisible(false);
        as.setCustomNameVisible(true);

        as.setCustomName("§8Nahodna hra (Zatim nefunkcni)");

        loc.add(0, 0.3, 0);

        as2 = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc, EntityType.ARMOR_STAND);

        as2.setGravity(false);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setVisible(false);
        as2.setCustomNameVisible(true);

        as2.setCustomName("§a§lRandom Join");

    }
}
