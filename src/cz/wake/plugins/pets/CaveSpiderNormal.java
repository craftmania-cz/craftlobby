package cz.wake.plugins.pets;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableCaveSpider;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class CaveSpiderNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activateCave(Player p) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final CaveSpider spider = RideableCaveSpider.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) spider, 0.16D, 2D);
        setMetadata((CaveSpider) spider, "Pet", "Pet", Main.getInstance());
        ((CaveSpider) spider).setCustomNameVisible(true);
        ((CaveSpider) spider).setCustomName(p.getName());
        PetManager.pet.put(p, (CraftEntity) spider);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(CaveSpider paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
