package cz.wake.lobby.pets;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftWither;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Iterator;

public class Widder {

    public static void activateCow(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.pet.remove(localObject);
                ((CraftEntity) localObject).remove();
            }
        }
        final CraftWither wither = (CraftWither) p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);
        PetManager.PetFollow(p, (CraftEntity) wither, 0.16D, 1.5D);
        setMetadata((CraftWither) wither, "Pet", "Pet", Main.getInstance());
        ((CraftWither) wither).setCustomName(p.getName() + " Wither");
        PetManager.pet.put(p, (CraftEntity) wither);
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                ((CraftWither) wither).getHandle().g(600);
            }

        }, 0L, 1L);
    }


    public static void setMetadata(CraftWither paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
