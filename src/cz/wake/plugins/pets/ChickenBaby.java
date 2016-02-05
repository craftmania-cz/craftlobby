package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableChicken;

public class ChickenBaby {
	
public static ArrayList<String> cb = new ArrayList();
	
	public static void activateChicken(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	    	PetManager.forceRemovePet(p);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Chicken chicken = RideableChicken.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)chicken, 0.16D, 2D);
	    setMetadata((Chicken)chicken, "Pet", "Pet", Main.getInstance());
	    ((Chicken)chicken).setBaby();
	    ((Chicken)chicken).setAgeLock(true);
	    ((Chicken)chicken).setCustomNameVisible(true);
	    ((Chicken)chicken).setCustomName("§6" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) chicken);
	    cb.add(p.getName());
	    p.closeInventory();
		
	}
	
	public static void setMetadata(Chicken paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
