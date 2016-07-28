package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableWolf;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class WolfNormal {

    public static ArrayList<String> wn = new ArrayList();

    public static void activate(final Player p, boolean baby) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Wolf wolf = RideableWolf.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) wolf, 0.16D, 1.0D);
        setMetadata((Wolf) wolf, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Wolf) wolf).setBaby();
        }
        ((Wolf) wolf).setAgeLock(true);
        ((Wolf) wolf).setCustomNameVisible(true);
        ((Wolf) wolf).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) wolf);
        wn.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Wolf paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
