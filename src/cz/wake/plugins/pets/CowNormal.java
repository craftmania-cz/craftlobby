package cz.wake.plugins.pets;

import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;

public class CowNormal implements Listener{
	
	public static void activateCow(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	        PetManager.pet.remove(localObject);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Cow cow = (Cow) p.getWorld().spawnEntity(p.getLocation(), EntityType.COW);
	    PetManager.PetFollow(p, (CraftEntity)cow, 0.16D, 1.5D);
	    setMetadata((Cow)cow, "Pet", "Pet", Main.getInstance());
	    ((Cow)cow).setBaby();
	    ((Cow)cow).setAgeLock(true);
	    ((Cow)cow).setCustomNameVisible(true);
	    ((Cow)cow).setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + p.getName());
	    PetManager.pet.put(p, (CraftEntity) cow);
		
	}
	
	public static void setMetadata(Cow paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
