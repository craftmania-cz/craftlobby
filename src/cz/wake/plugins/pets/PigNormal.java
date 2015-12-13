package cz.wake.plugins.pets;

import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.metadata.FixedMetadataValue;
import cz.wake.plugins.Main;

public class PigNormal implements Listener{
	
	public static void activatePig(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	        PetManager.pet.remove(localObject);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Pig pig = (Pig) p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
	    PetManager.PetFollow(p, (CraftEntity)pig, 0.16D, 1.0D);
	    setMetadata((Pig)pig, "Pet", "Pet", Main.getInstance());
	    ((Pig)pig).setAgeLock(true);
	    ((Pig)pig).setCustomNameVisible(true);
	    ((Pig)pig).setCustomName(ChatColor.LIGHT_PURPLE + p.getName());
	    PetManager.pet.put(p, (CraftEntity) pig);
		
	}
	
	public static void setMetadata(Pig paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
