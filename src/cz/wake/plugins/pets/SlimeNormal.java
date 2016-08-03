package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableSlime;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class SlimeNormal {

    public static ArrayList<String> pn = new ArrayList();

    public static void activateSlime(Player p, int size) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Slime slime = RideableSlime.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) slime, 0.16D, 1.0D);
        setMetadata((Slime) slime, "Pet", "Pet", Main.getInstance());
        ((Slime) slime).setSize(size);
        ((Slime) slime).setCustomNameVisible(true);
        ((Slime) slime).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) slime);
        pn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Slime paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
