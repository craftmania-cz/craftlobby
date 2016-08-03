package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class EndermiteNormal {

    public static ArrayList<String> en = new ArrayList();

    public static void activate(final Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Endermite ender = (Endermite) p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMITE);
        PetManager.PetFollow(p, (CraftEntity) ender, 0.16D, 1.0D);
        setMetadata((Endermite) ender, "Pet", "Pet", Main.getInstance());
        ((Endermite) ender).setCustomNameVisible(true);
        ((Endermite) ender).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) ender);
        en.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Endermite paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
