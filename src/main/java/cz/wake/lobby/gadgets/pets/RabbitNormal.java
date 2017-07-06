package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableRabbit;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Rabbit.Type;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class RabbitNormal {


    public static ArrayList<String> rb = new ArrayList();

    public static void activate(final Player p, boolean baby, Type type) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Rabbit rabbit = RideableRabbit.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) rabbit, 0.30D, 1.0D);
        setMetadata((Rabbit) rabbit, "Pet", "Pet", Main.getInstance());
        if (baby) {
            ((Rabbit) rabbit).setBaby();
        }
        ((Rabbit) rabbit).setAgeLock(true);
        ((Rabbit) rabbit).setRabbitType(type);
        ((Rabbit) rabbit).setCustomNameVisible(true);
        ((Rabbit) rabbit).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) rabbit);
        rb.add(p.getName());
        p.closeInventory();
    }

    public static void setMetadata(Rabbit paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

}
