package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BlockIterator;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.UtilBlock;

public class PaintballGun implements Listener{
	
	private Main plugin;
	
	public PaintballGun(Main plugin){
		this.plugin = plugin;
	}
	
	private HashSet<Projectile> _balls = new HashSet();
	private ArrayList<UUID> _coolDown = new ArrayList();
	
	@EventHandler
	  public void Paint(ProjectileHitEvent event)
	  {
	    if (!this._balls.remove(event.getEntity())) {
	      return;
	    }
	    BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
	    Block hitBlock = null;
	    while (iterator.hasNext())
	    {
	      hitBlock = iterator.next();
	      if (hitBlock.getTypeId() != 0) {
	        break;
	      }
	    }
	    Location loc = event.getEntity().getLocation().add(event.getEntity().getVelocity());
	    loc.getWorld().playEffect(loc, Effect.STEP_SOUND, 49);
	    
	    byte color = 2;
	    double r = Math.random();
	    if (r > 0.9D) {
	      color = 4;
	    } else if (r > 0.8D){
	      color = 8;
	    } else if (r > 0.7D) {
	      color = 5;
	    } else if (r > 0.6D){
		  color = 10;
	    } else if (r > 0.5D) {
	      color = 9;
	    } else if (r > 0.4D){
		  color = 1;
	    } else if (r > 0.3D) {
	      color = 14;
	    } else if (r > 0.01D) {
		  color = 11;
		}
	    for (Block block : UtilBlock.getInRadius(loc, 4).keySet())
	    {
	      if (block.getType() == Material.PORTAL) {
	        return;
	      }
	      if (block.getType() == Material.CACTUS) {
	        return;
	      }
	      if (block.getType() == Material.IRON_PLATE) {
	        return;
	      }
	      if (block.getType() == Material.SIGN) {
	        return;
	      }
	      if (block.getType() == Material.WALL_SIGN) {
	        return;
	      }
	      if (block.getType() == Material.SIGN_POST) {
	        return;
	      }
	    }
	    for (Block block : UtilBlock.getInRadius(loc, 4 / 2.0D).keySet()) {
	      if (UtilBlock.solid(block))
	      {
	        Location bLoc = block.getLocation().add(0.0D, 1.0D, 0.0D);
	        if (block.getType() == Material.CARPET) {
	          setBlockToRestore(block, 171, color, 6L);
	        }
	        if ((block.getType() != Material.STAINED_CLAY) && 
	          (block.getType() != Material.JUKEBOX) && 
	          (block.getType() != Material.CHEST) && 
	          (block.getType() != Material.SIGN_POST) && 
	          (block.getType() != Material.WALL_SIGN) && 
	          (block.getType() != Material.SIGN) && 
	          (UtilBlock.fullSolid(block)) && 
	          (!badGrassBlock(block)))
	        {
	          setBlockToRestore(block, 159, color, 6L);
	        }
	      }
	    }
	  }
	  
	  public boolean badGrassBlock(Block b)
	  {
	    if ((b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.LONG_GRASS) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.DOUBLE_PLANT) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.YELLOW_FLOWER) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.RED_ROSE) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.CROPS) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.CARROT) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.POTATO) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.MELON_STEM) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.PUMPKIN_STEM) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.MELON) || 
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.PUMPKIN) ||
	      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.SUGAR_CANE)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public void setBlockToRestore(final Block block, int id, byte color, long timeInSecs)
	  {
	    final String BeforeId = block.getType().toString();
	    final byte BeforeData = block.getData();
	    block.setTypeId(id);
	    block.setData(color);
	    if (this.plugin._BlocksToRestore.containsKey(block)) {
	      return;
	    }
	    this.plugin._BlocksToRestore.put(block, BeforeId + " l " + BeforeData);
	    Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
	    {
	      @Override
	      public void run()
	      {
	        block.setType(Material.valueOf(BeforeId));
	        block.setData(BeforeData);
	        try
	        {
	          PaintballGun.this.plugin._BlocksToRestore.remove(block);
	        }
	        catch (Exception localException) {}
	      }
	    }, timeInSecs * 20L);
	  }
	  
	  @EventHandler
	  public void Shoot(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    Player player = event.getPlayer();
	    ItemStack item = event.getItem();
	    Action action = event.getAction();
	    
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.DIAMOND_BARDING)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("PaintballGun")) {
	        return;
	    }
	    event.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	  	    if (this._coolDown.contains(p.getUniqueId())) {
	  	      return;
	  	    }
	  	    if (!p.hasPermission("craftlobby.gadgets.paintballgun")) {
	  	      return;
	  	    }
	  	    event.setCancelled(true);
	  	    
	  	    this._coolDown.add(p.getUniqueId());
	  	    Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
	  	    {
	  	      @Override
	  	      public void run()
	  	      {
	  	        PaintballGun.this._coolDown.remove(p.getUniqueId());
	  	      }
	  	    }, 5L);
	  	    
	  	    Projectile proj = player.launchProjectile(EnderPearl.class);
	  	    proj.setVelocity(proj.getVelocity().multiply(2));
	  	    this._balls.add(proj);
	  	    proj.setMetadata("SUPAPEARL", new FixedMetadataValue(this.plugin, player.getName()));
	  	    player.getWorld().playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.5F, 1.2F);
	  	  }
	    }
	  

}
