package cz.wake.plugins.pets;


import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableWitch;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class WitchNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateWitch(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Witch e = RideableWitch.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) e, 0.16D, 2D);
        setMetadata((Witch) e, "Pet", "Pet", Main.getInstance());
        ((Witch) e).setCustomNameVisible(true);
        ((Witch) e).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) e);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Witch paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
