package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableMagmaCube;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class MagmaCubeNormal {

    public static ArrayList<String> pn = new ArrayList();

    public static void activateSlime(Player p, int size) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final MagmaCube slime = RideableMagmaCube.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) slime, 0.16D, 1.0D);
        setMetadata((MagmaCube) slime, "Pet", "Pet", Main.getInstance());
        ((MagmaCube) slime).setSize(size);
        ((MagmaCube) slime).setCustomNameVisible(true);
        ((MagmaCube) slime).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) slime);
        pn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(MagmaCube paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
