package cz.wake.plugins.pets;

import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;

public class IronGolemNormal implements Listener{
	
	public static void actiavteGolem(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	        PetManager.pet.remove(localObject);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final IronGolem irongolem = (IronGolem) p.getWorld().spawnEntity(p.getLocation(), EntityType.IRON_GOLEM);
		PetManager.PetFollow(p, (CraftEntity)irongolem, 0.16D, 2.0D);
		setMetadata((IronGolem)irongolem, "Pet", "Pet", Main.getInstance());
		((IronGolem)irongolem).setCustomNameVisible(true);
		((IronGolem)irongolem).setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + p.getName());
		PetManager.pet.put(p, (CraftEntity)irongolem);
	}
	
	public static void setMetadata(IronGolem paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
