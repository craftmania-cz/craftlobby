package cz.wake.lobby.morphs;

import org.bukkit.event.Listener;
import cz.wake.lobby.Main;

public class PigMorph implements Listener{
	
	private Main plugin;
	
	public PigMorph(Main plugin){
		this.plugin = plugin;
	}
	
	/*
	public static void activate(Player p){
		MobDisguise localDisguise = new MobDisguise(DisguiseType.PIG);
		DisguiseAPI.undisguiseToAll(p);
		LivingWatcher localLivingWatcher = localDisguise.getWatcher();
		localLivingWatcher.setCustomName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + p.getName());
		localLivingWatcher.setCustomNameVisible(true);
		p.getOpenInventory().close();
		DisguiseAPI.disguiseToAll(p, localDisguise);
	}
	
	@EventHandler
	private void onPlayerLeftInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)){
			if(!DisguiseAPI.isDisguised(p)){
				return;
			}
			if(!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.PIG)){
				return;
			}
			
			p.getWorld().playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.1F, 0.1F);
			ItemStack meatStack = new ItemStack(Material.PORK,1);
			ItemMeta msMeta = meatStack.getItemMeta();
			msMeta.setDisplayName("PIG_PORK");
			meatStack.setItemMeta(msMeta);
			final Item localItem = p.getWorld().dropItemNaturally(p.getEyeLocation(), meatStack);
			localItem.setVelocity(p.getLocation().getDirection().multiply(1.5));
			new BukkitRunnable(){
				public void run(){
					if(!localItem.isDead()){
						ParticleEffect.FIREWORKS_SPARK.display(0.2F, 0.2F, 0.2F, 0.0F, 15, localItem.getLocation(), 15.0D);
				        localItem.remove();
					}
				}
			}.runTaskLater(plugin, 120L);
			
		}
	}
	
	@EventHandler
	private void onPlayerInteractRight(PlayerInteractEvent e){
	    Player p = e.getPlayer();
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
	    {
	      if (!DisguiseAPI.isDisguised(p)) {
	        return;
	      }
	      if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.PIG)) {
	        return;
	      }
	      p.getWorld().playSound(p.getLocation(), Sound.PIG_IDLE, 10.0F, 1F);
	      ParticleEffect.HEART.display(1.5F, 1.5F, 1.5F, 0.0F, 5, p.getLocation(), 10.0D);
	    }
	  }
	
	@EventHandler
	private void onPlayerPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		Item item = e.getItem();
		if((item.getItemStack().getType() == Material.PORK) && (item.getItemStack().getItemMeta().getDisplayName().contains("PIG_PORK"))){
			p.playSound(p.getLocation(), Sound.EAT, 20.0F, 1.0F);
			ParticleEffect.HEART.display(1.0F, 1.0F, 1.0F, 0.0F, 10, p.getLocation(), 15.0D);
			e.setCancelled(true);
			e.getItem().remove();
			
		}
	}
	
	*/

}
