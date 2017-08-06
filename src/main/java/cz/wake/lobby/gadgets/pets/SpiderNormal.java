package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableSpider;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class SpiderNormal {

    public static ArrayList<String> pn = new ArrayList();

    public static void activateSpider(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Spider spider = RideableSpider.spawn(p.getLocation());
        PetManager.petFollow(p, (CraftEntity) spider, 0.16D, 1.0D);
        setMetadata((Spider) spider, "Pet", "Pet", Main.getInstance());
        ((Spider) spider).setCustomNameVisible(true);
        ((Spider) spider).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) spider);
        pn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Spider paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
