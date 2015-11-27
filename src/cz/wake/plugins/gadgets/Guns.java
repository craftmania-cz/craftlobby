package cz.wake.plugins.gadgets;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.utils.UtilParticles;

public class Guns implements Listener{
	
	@EventHandler
	public void ExplosionGun(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
	    Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.STICK)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().startsWith("§aWizardGun §7- §e")) {
	        return;
	    }
	    if (!p.hasPermission("craftlobby.gadget.wizardgun")){
	    	return;
	    }
	    String gunName = item.getItemMeta().getDisplayName().replace("§aWizardGun §7- §e", "");
	    e.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
            if(gunName.equals("Witch")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
               
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.WITCH_MAGIC);
                }
            }
            else if(gunName.equals("Love")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.HEART);
                }
            }
            else if(gunName.equals("Slime")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.SLIME);
                }
            }
            else if(gunName.equals("Flame")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.FLAME);
                }
            }
            else if(gunName.equals("Clouds")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);

                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.CLOUD);
                }
            }
            else if(gunName.equals("Enchant")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.FLYING_GLYPH);
                }
            }
            else if(gunName.equals("Firework")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.FIREWORKS_SPARK);
                }
            }
            else if(gunName.equals("Redstone")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);

                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.COLOURED_DUST);
                }
            }
            else if(gunName.equals("Portal")){
            	Location localLocation1 = player.getEyeLocation();
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                double d1 = localLocation1.getX();
                double d2 = localLocation1.getY();
                double d3 = localLocation1.getZ();
                
                double d4 = Math.toRadians(localLocation1.getYaw() + 90.0F);
                double d5 = Math.toRadians(localLocation1.getPitch() + 90.0F);
                
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                player.updateInventory();
                for (int i = 1; i <= 30; i++)
                {
                  Location localLocation2 = new Location(player.getWorld(), d1 + i * d6, d2 + i * d8, d3 + i * d7);
                  if (localLocation2.getBlock().getType() != Material.AIR) {
                    break;
                  }
                  UtilParticles.play(localLocation2, Effect.PORTAL);
                }
            }
		}
	    else if((action.equals(Action.LEFT_CLICK_AIR)) || (action.equals(Action.LEFT_CLICK_BLOCK))){
	    	ItemMeta itemMeta = item.getItemMeta();
	    	if(gunName.equals("Witch")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eLove");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Love")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eSlime");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Slime")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eFlame");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Flame")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eClouds");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Clouds")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eEnchant");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Enchant")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eFirework");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Firework")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eRedstone");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Redstone")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §ePortal");
	    		item.setItemMeta(itemMeta);
	    	}
	    	else if(gunName.equals("Portal")){
	    		itemMeta.setDisplayName("§aWizardGun §7- §eWitch");
	    		item.setItemMeta(itemMeta);
	    	}
	    }
	}

}
