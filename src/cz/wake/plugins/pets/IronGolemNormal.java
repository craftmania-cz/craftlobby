package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableGolem;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class IronGolemNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateGolem(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final IronGolem golem = RideableGolem.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) golem, 0.16D, 2D);
        setMetadata((IronGolem) golem, "Pet", "Pet", Main.getInstance());
        ((IronGolem) golem).setCustomNameVisible(true);
        ((IronGolem) golem).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) golem);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(IronGolem paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
