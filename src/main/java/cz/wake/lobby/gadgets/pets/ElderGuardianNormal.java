package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableGuardianElder;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class ElderGuardianNormal {

    public static ArrayList<String> cp = new ArrayList();

    public static void activateGuardian(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final ElderGuardian e = RideableGuardianElder.spawn(p.getLocation());
        PetManager.petFollow(p, (CraftEntity) e, 0.16D, 1.5D);
        setMetadata((ElderGuardian) e, "Pet", "Pet", Main.getInstance());
        ((ElderGuardian) e).setCustomNameVisible(true);
        ((ElderGuardian) e).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) e);
        cp.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(ElderGuardian paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
