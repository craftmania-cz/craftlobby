package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableCow;
import cz.wake.plugins.utils.mobs.RideableMushroomCow;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class MushroomNormal {

    public static ArrayList<String> cp = new ArrayList();

    public static void activateCow(Player p, boolean baby){
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
        {
            Object localObject = (CraftEntity)localIterator.next();
            if (localObject == PetManager.pet.get(p))
            {
                PetManager.forceRemovePet(p);
                ((CraftEntity)localObject).remove();
            }
        }
        final MushroomCow cow = RideableMushroomCow.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity)cow, 0.16D, 1.5D);
        setMetadata((MushroomCow)cow, "Pet", "Pet", Main.getInstance());
        if(baby){
            ((MushroomCow)cow).setBaby();
        }
        ((MushroomCow)cow).setAgeLock(true);
        ((MushroomCow)cow).setCustomNameVisible(true);
        ((MushroomCow)cow).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) cow);
        cp.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(MushroomCow paramPig, String paramString, Object paramObject, Main paramMain){
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
