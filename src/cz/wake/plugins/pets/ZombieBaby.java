package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableZombie;

public class ZombieBaby {
	
public static ArrayList<String> zb = new ArrayList();
	
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
		final Zombie zomb = RideableZombie.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)zomb, 0.16D, 1.0D);
	    setMetadata((Zombie)zomb, "Pet", "Pet", Main.getInstance());
	    ((Zombie)zomb).setCustomNameVisible(true);
	    ((Zombie)zomb).setBaby(true);
	    ((Zombie)zomb).setCustomName("§a" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) zomb);
	    zb.add(p.getName());
	    p.closeInventory();
	}

	public static void setMetadata(Zombie paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
