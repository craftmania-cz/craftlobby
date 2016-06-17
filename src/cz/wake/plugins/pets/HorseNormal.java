package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import cz.wake.plugins.Main;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.utils.mobs.RideableHorse;

public class HorseNormal {

	public static ArrayList<String> hb = new ArrayList();

	public static void activate(Player p, boolean baby, Horse.Color color){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
		{
			Object localObject = (CraftEntity)localIterator.next();
			if (localObject == PetManager.pet.get(p))
			{
				PetManager.forceRemovePet(p);
				((CraftEntity)localObject).remove();
			}
		}
		final Horse h = RideableHorse.spawn(p.getLocation());
		PetManager.PetFollow(p, (CraftEntity)h, 0.23D, 3D);
		setMetadata((Horse)h, "Pet", "Pet", Main.getInstance());
        if(baby){
            ((Horse)h).setBaby();
        }
		((Horse)h).setAgeLock(true);
        ((Horse)h).setColor(color);
		((Horse)h).getInventory().setSaddle(new ItemStack(Material.SADDLE));
		((Horse)h).setCustomNameVisible(true);
		((Horse)h).setCustomName(p.getName());
		PetManager.pet.put(p, (CraftEntity) h);
		hb.add(p.getName());
		p.closeInventory();
	}

	public static void setMetadata(Horse paramPig, String paramString, Object paramObject, Main paramMain){
		paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	}

}
