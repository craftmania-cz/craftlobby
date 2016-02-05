package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableWolf;

public class WolfBaby {

	public static ArrayList<String> wb = new ArrayList();
	
	public static void activate(final Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	    	 PetManager.forceRemovePet(p);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Wolf wolf = RideableWolf.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)wolf, 0.16D, 1.0D);
	    setMetadata((Wolf)wolf, "Pet", "Pet", Main.getInstance());
	    ((Wolf)wolf).setBaby();
	    ((Wolf)wolf).setAgeLock(true);
	    ((Wolf)wolf).setCustomNameVisible(true);
	    ((Wolf)wolf).setCustomName("§6" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) wolf);
	    wb.add(p.getName());
	    p.closeInventory();
	}
	
	public static void setMetadata(Wolf paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }
}
