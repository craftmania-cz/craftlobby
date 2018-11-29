package cz.wake.lobby.gadgets.pets;

/*import cz.wake.lobby.Main;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftVex;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vex;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Iterator;

public class VexNormal {

    public static void activate(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.pet.remove(localObject);
                ((CraftEntity) localObject).remove();
            }
        }
        final CraftVex vex = (CraftVex) p.getWorld().spawnEntity(p.getLocation(), EntityType.VEX);
        PetManager.petFollow(p, (CraftEntity) vex, 0.16D, 1.5D);
        setMetadata((CraftVex) vex, "Pet", "Pet", Main.getInstance());
        PetManager.pet.put(p, (CraftEntity) vex);
        p.closeInventory();
    }

    public static void setMetadata(Vex paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}*/
