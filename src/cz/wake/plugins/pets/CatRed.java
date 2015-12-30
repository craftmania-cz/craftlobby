package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableCat;

public class CatRed {
	
	public static ArrayList<String> cr = new ArrayList();
	
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
		final Ocelot ocelot = RideableCat.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)ocelot, 0.18D, 1.0D);
	    setMetadata((Ocelot)ocelot, "Pet", "Pet", Main.getInstance());
	    ((Ocelot)ocelot).setAdult();
	    ((Ocelot)ocelot).setCatType(Type.RED_CAT);
	    ((Ocelot)ocelot).setCustomNameVisible(true);
	    ((Ocelot)ocelot).setCustomName("§5" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) ocelot);
	    cr.add(p.getName());
	    p.closeInventory();
	}
	
	public static void setMetadata(Ocelot paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }


}
