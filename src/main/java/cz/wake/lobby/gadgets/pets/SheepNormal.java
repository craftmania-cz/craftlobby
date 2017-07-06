package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableSheep;
import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class SheepNormal {

    public static ArrayList<String> sb = new ArrayList();

    public static void activate(Player p, boolean baby, DyeColor type) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Sheep sheep = RideableSheep.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) sheep, 0.16D, 2D);
        setMetadata((Sheep) sheep, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Sheep) sheep).setBaby();
        }
        ((Sheep) sheep).setAgeLock(true);
        ((Sheep) sheep).setColor(type);
        ((Sheep) sheep).setCustomNameVisible(true);
        ((Sheep) sheep).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) sheep);
        sb.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Sheep paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
