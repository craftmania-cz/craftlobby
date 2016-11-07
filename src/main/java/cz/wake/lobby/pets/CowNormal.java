package cz.wake.lobby.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableCow;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class CowNormal {

    public static ArrayList<String> cp = new ArrayList();

    public static void activateCow(Player p, boolean baby) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Cow cow = RideableCow.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) cow, 0.16D, 1.5D);
        setMetadata((Cow) cow, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Cow) cow).setBaby();
        }
        ((Cow) cow).setAgeLock(true);
        ((Cow) cow).setCustomNameVisible(true);
        ((Cow) cow).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) cow);
        cp.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Cow paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
