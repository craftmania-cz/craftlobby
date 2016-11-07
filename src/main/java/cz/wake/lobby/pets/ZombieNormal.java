package cz.wake.lobby.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableZombie;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class ZombieNormal {

    public static ArrayList<String> zn = new ArrayList();

    public static void activate(final Player p, boolean baby) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Zombie zomb = RideableZombie.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) zomb, 0.16D, 1.0D);
        setMetadata((Zombie) zomb, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Zombie) zomb).setBaby(true);
        }
        ((Zombie) zomb).setCustomNameVisible(true);
        ((Zombie) zomb).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) zomb);
        zn.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Zombie paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
