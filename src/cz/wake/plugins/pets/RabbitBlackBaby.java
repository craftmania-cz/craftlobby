package cz.wake.plugins.pets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Rabbit.Type;
import org.bukkit.metadata.FixedMetadataValue;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.mobs.RideableRabbit;

public class RabbitBlackBaby {
	
	public static ArrayList<String> rb = new ArrayList();
	
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
		final Rabbit rabbit = RideableRabbit.spawn(p.getLocation());
	    PetManager.PetFollow(p, (CraftEntity)rabbit, 0.30D, 1.0D);
	    setMetadata((Rabbit)rabbit, "Pet", "Pet", Main.getInstance());
	    ((Rabbit)rabbit).setBaby();
	    ((Rabbit)rabbit).setRabbitType(Type.BLACK);
	    ((Rabbit)rabbit).setCustomNameVisible(true);
	    ((Rabbit)rabbit).setCustomName("§6" + p.getName());
	    PetManager.pet.put(p, (CraftEntity) rabbit);
	    rb.add(p.getName());
	    p.closeInventory();
	}
	
	public static void setMetadata(Rabbit paramPig, String paramString, Object paramObject, Main paramMain)
	  {
	    paramPig.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
	  }

}
