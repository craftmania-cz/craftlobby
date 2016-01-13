package cz.wake.plugins.gadgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import cz.wake.plugins.Main;
import cz.wake.plugins.API.CustomEntityFirework;
import cz.wake.plugins.utils.UtilColor;

public class PartyCoins implements Listener{
	
	private HashMap<Player, Double> _time = new HashMap();
	HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
	public static double radius = 5.0D;
	public static int fi = 0;
	private int FireworkTask;
	private int SpawnTask;
	private int CountdownTask1;
	private int CountdownTask2;
	private int CountdownTask3;
	private int CountdownTask4;
	boolean runa = false;
	
	private Main plugin;
	
	public PartyCoins(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPee(PlayerInteractEvent e){
		final Player player = e.getPlayer();
	    ItemStack item = e.getItem();
	    Action action = e.getAction();
		
	    if(item == null){
	    	return;
	    }
	    if (!item.hasItemMeta()) {
	        return;
	    }
	    if (!item.getType().equals(Material.GOLD_INGOT)) {
	        return;
	    }
	    if (!item.getItemMeta().getDisplayName().contains("PartyCoins")) {
	        return;
	    }
	    if (!player.hasPermission("craftlobby.admin")){
	    	return;
	    }
	    e.setCancelled(true);
	    player.updateInventory();
	    if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))){
	    	if (!this.runa){
	    		
	          this.runa = true;
	          ItemStack todrop = new ItemStack(Material.GOLD_NUGGET, 1);
	          ItemMeta tometa = todrop.getItemMeta();
	          tometa.setDisplayName("Party: " + fi);
	          tometa.setLore(Arrays.asList(new String[] { "Bomb" }));
	          todrop.setItemMeta(tometa);
	          final Item item1 = player.getWorld().dropItem(player.getLocation().add(0.0D, 1.5D, 0.0D), todrop);
	          item1.getWorld().playSound(item1.getLocation(), Sound.FUSE, 1.0F, 1.0F);
	          item1.setVelocity(player.getLocation().getDirection().multiply(0.9D));
	          item1.setPickupDelay(130);
	          Bukkit.broadcastMessage("§a" + player.getName() + " §eprave vyhodil §6CoinsParty!");
	          removedRightClickedItem(player);
	          player.updateInventory();
	          
	          this.FireworkTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              Color FireworkColor = UtilColor.getColor("YELLOW");
	              CustomEntityFirework.spawn(item1.getLocation().add(0.0D, -0.15D, 0.0D), FireworkEffect.builder().with(FireworkEffect.Type.BURST).withColor(FireworkColor).flicker(false).trail(false).build(), new Player[0]);
	            }
	          }, 60L, 1L);
	          
	          this.SpawnTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              fi += 1;
	              Location loc1 = getRandomLoc(item1);
	              ItemStack todrop = new ItemStack(Material.GOLD_NUGGET, 1);
	              ItemMeta tometa = todrop.getItemMeta();
	              tometa.setDisplayName("Party: " + fi);
	              List<String> test = new ArrayList<String>();
	              test.add("Bomb");
	              tometa.setLore(test);
	              todrop.setItemMeta(tometa);
	              player.getWorld().dropItemNaturally(loc1, todrop);
	              item1.getWorld().playSound(item1.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
	            }
	          }, 120L, 4L);
	          
	          Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable(){

				@Override
				public void run() {
					item1.getWorld().playSound(item1.getLocation(), Sound.COW_HURT, 1.0F, 1.0F);
	                fi = 0;
	                Bukkit.getScheduler().cancelTask(FireworkTask);
	                Bukkit.getScheduler().cancelTask(SpawnTask);
	                Bukkit.getScheduler().cancelTask(CountdownTask1);
	                Bukkit.getScheduler().cancelTask(CountdownTask2);
	                Bukkit.getScheduler().cancelTask(CountdownTask3);
	                Bukkit.getScheduler().cancelTask(CountdownTask4);
	                runa = false;
				}
	        	  
	          }, 400L);
	          
	          this.CountdownTask1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              item1.getWorld().playSound(item1.getLocation(), Sound.FALL_BIG, 1.0F, 1.0F);
	            }
	          }, 50L);
	          
	          this.CountdownTask2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              item1.getWorld().playSound(item1.getLocation(), Sound.FALL_BIG, 1.0F, 1.0F);
	            }
	          }, 70L);
	          
	          this.CountdownTask3 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              item1.getWorld().playSound(item1.getLocation(), Sound.FALL_BIG, 1.0F, 1.0F);
	            }
	          }, 90L);
	          
	          this.CountdownTask4 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	          {
	            public void run()
	            {
	              item1.getWorld().playSound(item1.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
	            }
	          }, 110L);
	        }
	      }
	    }
	
	public static Location getRandomLoc(Item item1)
	  {
	    int x = (int) item1.getLocation().getX();
	    int y = (int) item1.getLocation().getY();
	    int z = (int) item1.getLocation().getZ();
	    World world = item1.getWorld();
	    double newX = getRandomX(x);
	    double newY = getRandomY(y);
	    double newZ = z + 0.5D;
	    Location loc = new Location(world, newX, newY, newZ);
	    return loc;
	  }
	
	public static double getRandomX(double x)
	  {
	    double toRadM = x - radius;
	    double toRadP = x + radius;
	    Random r = new Random();
	    double randomValue = toRadM + (toRadP - toRadM) * r.nextDouble();
	    return randomValue;
	  }
	  
	  public static double getRandomY(double y)
	  {
	    double toRadM = y - radius;
	    double toRadP = y + radius;
	    Random r = new Random();
	    double randomValue = toRadM + (toRadP - toRadM) * r.nextDouble();
	    return randomValue;
	  }
	  
	  public void removedRightClickedItem(Player p)
	  {
	    if (p.getInventory().getItemInHand().getAmount() == 1)
	    {
	      p.setItemInHand(null);
	      return;
	    }
	    int amount = p.getInventory().getItemInHand().getAmount();
	    amount--;
	    p.getInventory().getItemInHand().setAmount(amount);
	  }
	  
	  @EventHandler
	  public void onPickup(PlayerPickupItemEvent event)
	  {
	    Player player = event.getPlayer();
	    if ((event.getItem().getItemStack().hasItemMeta()) && 
	      (event.getItem().getItemStack().getItemMeta().hasLore()) && 
	      (event.getItem().getItemStack().getItemMeta().getLore().contains("Bomb")))
	    {
	      Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "addbalance " + player.getName() + " 1");
	      event.getPlayer().getWorld().playSound(event.getItem().getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	      event.setCancelled(true);
	      event.getItem().remove();
	    }
	  }
}
