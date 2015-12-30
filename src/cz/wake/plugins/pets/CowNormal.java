package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableCow;

public class CowNormal{
	
	public static ArrayList<String> cp = new ArrayList();
	
	public static void activateCow(Player p){
		for (Iterator localIterator = p.getWorld().getEntities().iterator(); localIterator.hasNext();)
	    {
	      Object localObject = (CraftEntity)localIterator.next();
	      if (localObject == PetManager.pet.get(p))
	      {
	    	  PetManager.forceRemovePet(p);
	        ((CraftEntity)localObject).remove();
	      }
	    }
		final Cow cow = RideableCow.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)cow, 0.16D, 1.5D);
	    setMetadata((Cow)cow, "Pet", "Pet", Main.getInstance());
	    ((Cow)cow).setAgeLock(true);
	    ((Cow)cow).setCustomNameVisible(true);
	    ((Cow)cow).setCustomName("§a" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) cow);
	    cp.add(p.getName());
	    p.closeInventory();
		
	}
	
	public static void setMetadata(Cow paramPig, String paramString, Object paramObject, Main paramMain){
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	}


}
