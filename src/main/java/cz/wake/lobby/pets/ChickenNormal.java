package cz.wake.lobby.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableChicken;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class ChickenNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateChicken(Player p, boolean baby) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Chicken chicken = RideableChicken.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) chicken, 0.16D, 2D);
        setMetadata((Chicken) chicken, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Chicken) chicken).setBaby();
        }
        ((Chicken) chicken).setAgeLock(true);
        ((Chicken) chicken).setCustomNameVisible(true);
        ((Chicken) chicken).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) chicken);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Chicken paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
