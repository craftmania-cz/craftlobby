package cz.wake.plugins.pets;


import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableEnderman;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class EndermanNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateWitch(Player p){
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
        {
            Object localObject = (CraftEntity)localIterator.next();
            if (localObject == PetManager.pet.get(p))
            {
                PetManager.forceRemovePet(p);
                ((CraftEntity)localObject).remove();
            }
        }
        final Enderman e = RideableEnderman.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity)e, 0.16D, 2D);
        setMetadata((Enderman) e, "Pet", "Pet", Main.getInstance());
        ((Enderman)e).setCustomNameVisible(true);
        ((Enderman)e).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) e);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Enderman paramPig, String paramString, Object paramObject, Main paramMain)
    {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
