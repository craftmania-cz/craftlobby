package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableSilverfish;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class SilverfishNormal {

    public static ArrayList<String> sn = new ArrayList();

    public static void activate(final Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Silverfish silver = RideableSilverfish.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) silver, 0.16D, 1.0D);
        setMetadata((Silverfish) silver, "Pet", "Pet", Main.getInstance());
        ((Silverfish) silver).setCustomNameVisible(true);
        ((Silverfish) silver).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) silver);
        sn.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Silverfish paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
