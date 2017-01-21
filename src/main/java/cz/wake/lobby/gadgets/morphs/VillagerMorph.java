package cz.wake.lobby.gadgets.morphs;

import org.bukkit.event.Listener;

import cz.wake.lobby.Main;

public class VillagerMorph implements Listener{
	
	private Main plugin;
	
	public VillagerMorph(Main plugin){
		this.plugin = plugin;
	}
	/*
	public static void activate(Player p){
		MobDisguise localDisguise = new MobDisguise(DisguiseType.VILLAGER);
		DisguiseAPI.undisguiseToAll(p);
		LivingWatcher localLivingWatcher = localDisguise.getWatcher();
		localLivingWatcher.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName());
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
			if(!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.VILLAGER)){
				return;
			}
			p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_IDLE, 10.0F, 1F);
			ParticleEffect.VILLAGER_HAPPY.display(2.0F, 2.0F, 2.0F, 0.0F, 45, p.getLocation(), 15.0D);
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
	      if (!DisguiseAPI.getDisguise(p).getType().equals(DisguiseType.VILLAGER)) {
	        return;
	      }
	      p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_HIT, 10.0F, 1F);
	      ParticleEffect.VILLAGER_ANGRY.display(2.0F, 2.0F, 2.0F, 0.0F, 45, p.getLocation(), 15.0D);
	    }
	  }
	*/
}
