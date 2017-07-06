package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class SnowmanNormal {

    public static ArrayList<String> en = new ArrayList();

    public static void activate(final Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Snowman ender = (Snowman) p.getWorld().spawnEntity(p.getLocation(), EntityType.SNOWMAN);
        PetManager.PetFollow(p, (CraftEntity) ender, 0.16D, 1.0D);
        setMetadata((Snowman) ender, "Pet", "Pet", Main.getInstance());
        ((Snowman) ender).setCustomNameVisible(true);
        ((Snowman) ender).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) ender);
        en.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Snowman paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
