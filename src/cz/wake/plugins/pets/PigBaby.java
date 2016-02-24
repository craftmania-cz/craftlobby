package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideablePig;

public class PigBaby {
	
public static ArrayList<String> pb = new ArrayList();
	
	public static void activatePig(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	    	 PetManager.forceRemovePet(p);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Pig pig = RideablePig.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)pig, 0.16D, 1.0D);
	    setMetadata((Pig)pig, "Pet", "Pet", Main.getInstance());
	    ((Pig)pig).setBaby();
	    ((Pig)pig).setAgeLock(true);
	    ((Pig)pig).setCustomNameVisible(true);
	    ((Pig)pig).setCustomName("�6" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) pig);
	    pb.add(p.getName());
	    p.closeInventory();
		
	}
	
	public static void setMetadata(Pig paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}