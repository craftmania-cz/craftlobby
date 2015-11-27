package cz.wake.plugins.pets;

import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;

public class ChickenNormal implements Listener{
	
	public static void activateChicken(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	        PetManager.pet.remove(localObject);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Chicken chicken = (Chicken) p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
	    PetManager.PetFollow(p, (CraftEntity)chicken, 0.16D, 2D);
	    setMetadata((Chicken)chicken, "Pet", "Pet", Main.getInstance());
	    ((Chicken)chicken).setBaby();
	    ((Chicken)chicken).setAgeLock(true);
	    ((Chicken)chicken).setCustomNameVisible(true);
	    ((Chicken)chicken).setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + p.getName());
	    PetManager.pet.put(p, (CraftEntity) chicken);
		
	}
	
	public static void setMetadata(Chicken paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
