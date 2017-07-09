package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.mobs.RideableLlama;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Iterator;

public class LlamaNormal {

    public static ArrayList<String> cn = new ArrayList();

    public static void activate(Player p, boolean baby, Llama.Color color, ItemStack decor) {
        for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext(); ) {
            Object localObject = (CraftEntity) localIterator.next();
            if (localObject == PetManager.pet.get(p)) {
                PetManager.forceRemovePet(p);
                ((CraftEntity) localObject).remove();
            }
        }
        final Llama lama = RideableLlama.spawn(p.getLocation());
        PetManager.PetFollow(p, (CraftEntity) lama, 0.16D, 2D);
        setMetadata((Llama) lama, "Pet", "Pet", Main.getInstance());
        ((Llama) lama).setCustomNameVisible(true);
        ((Llama) lama).setCustomName(p.getName());
        ((Llama) lama).setTamed(true);
        if(baby){
            ((Llama) lama).setBaby();
        }
        ((Llama) lama).setColor(color);
        ((Llama) lama).getInventory().setDecor(decor);
        PetManager.pet.put(p, (CraftEntity) lama);
        cn.add(p.getName());
        p.closeInventory();

    }

    public static void setMetadata(Llama paramPig, String paramString, Object paramObject, Main paramMain) {
        paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }
}
