package cz.wake.plugins.pets;

import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;

public class OcelotNormal implements Listener{
	
	public static void activateOcelot(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	        PetManager.pet.remove(localObject);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Ocelot ocelot = (Ocelot) p.getWorld().spawnEntity(p.getLocation(), EntityType.OCELOT);
	    PetManager.PetFollow(p, (CraftEntity)ocelot, 0.16D, 1.5D);
	    setMetadata((Ocelot)ocelot, "Pet", "Pet", Main.getInstance());
	    ((Ocelot)ocelot).setAgeLock(true);
	    ((Ocelot)ocelot).setCustomNameVisible(true);
	    ((Ocelot)ocelot).setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + p.getName());
	    PetManager.pet.put(p, (CraftEntity) ocelot);
		
	}
	
	public static void setMetadata(Ocelot paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
