package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableGuardian;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class GuardianNormal {

    public static ArrayList<String> cp = new ArrayList();

    public static void activateGuardian(Player p, boolean elder) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Guardian e = RideableGuardian.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) e, 0.16D, 1.5D);
        setMetadata((Guardian) e, "Pet", "Pet", Main.getInstance());
        if (elder) {
            ((Guardian) e).setElder(true);
        }
        ((Guardian) e).setCustomNameVisible(true);
        ((Guardian) e).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) e);
        cp.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Guardian paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
