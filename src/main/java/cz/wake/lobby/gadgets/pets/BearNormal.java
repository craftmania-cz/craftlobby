package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

/*public class BearNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateGolem(Player p, boolean baby) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final PolarBear golem = RideableBear.spawn(p.getLocation());
        PetManager.petFollow(p, (CraftEntity) golem, 0.16D, 2D);
        setMetadata((PolarBear) golem, "Pet", "Pet", Main.getInstance());
        ((PolarBear) golem).setCustomNameVisible(true);
        ((PolarBear) golem).setCustomName(p.getName());
        ((PolarBear) golem).setAgeLock(true);
        if (baby) {
            ((PolarBear) golem).setBaby();
        }
        PetManager.pet.put(p, (CraftEntity) golem);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(PolarBear paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}*/
