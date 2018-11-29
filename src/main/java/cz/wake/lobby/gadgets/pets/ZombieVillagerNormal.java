package cz.wake.lobby.gadgets.pets;

/*import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableZombieVillager;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class ZombieVillagerNormal {

    public static ArrayList<String> zn = new ArrayList();

    public static void activate(final Player p, boolean baby, Villager.Profession prof) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final ZombieVillager zomb = RideableZombieVillager.spawn(p.getLocation());
        PetManager.petFollow(p, (CraftEntity) zomb, 0.16D, 1.0D);
        setMetadata((ZombieVillager) zomb, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((ZombieVillager) zomb).setBaby(true);
        }
        ((ZombieVillager) zomb).setCustomNameVisible(true);
        ((ZombieVillager) zomb).setCustomName(p.getName());
        ((ZombieVillager) zomb).setVillagerProfession(prof);
        PetManager.pet.put(p, (CraftEntity) zomb);
        zn.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(ZombieVillager paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}*/
