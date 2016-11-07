package cz.wake.lobby.boxer;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cz.wake.lobby.Main;

public class Boxer implements Listener{
	
	public void giveBox(final Player p, int boxes){
		Bukkit.broadcastMessage("§b" + p.getName() + "§f nasel §6CraftBox!");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mb add " + p.getName() + " " + boxes);
	}
	
	public static int randRange(int min, int max){
	    Random rand = new Random();
	    int randomNum = rand.nextInt(max - min + 1) + min;
	    return randomNum;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		if(!Main.getInstance().fetchData().hasBoxData(p.getUniqueId())){
			long dalsiBox = randRange(1800000, 10800000); //30 minut az 3h
			long cas = System.currentTimeMillis() + dalsiBox;
			Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
				@Override
				public void run(){
					Main.getInstance().setData().createRecord(p, 3, cas); //Novy hraci dostanou 3x box!
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mb add " + p.getName() + " 3");
				}
			}, 40L);
		} else {
			int sance = randRange(1, 100);
			if(sance <= 10){ //20% sance na ziskani boxu
				if((Main.getInstance().fetchData().getBoxes(p.getUniqueId()) < 12) 
						&& (Main.getInstance().fetchData().getNextboxTime(p.getUniqueId()) < System.currentTimeMillis())){
					long dalsiBox = randRange(1800000, 10800000); //30 minut az 3h
					long cas = System.currentTimeMillis() + dalsiBox;
					Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
						@Override
						public void run(){
							Main.getInstance().setData().addBoxesWithTime(p, 1, cas);
							giveBox(p,1);
						}
					}, 40L);
				} else if((Main.getInstance().fetchData().getBoxes(p.getUniqueId()) == 12)){
					return;
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}
	
	//Kazdy 2h kontrola prekroceni
		public void runTaskDelete(){
			Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), new Runnable(){
				@Override
				public void run(){
					System.out.println("[Craftboxer] Kontrola resetu boxu.");
					if(Main.getInstance().fetchData().getFullResetTime() < System.currentTimeMillis()){
						System.out.println("[Craftboxer] Kontrola potvrzena. Probehne cisteni boxu...");
						long nextReset = (System.currentTimeMillis() + 604800000);
						Main.getInstance().setData().resetBoxes();
						System.out.println("[Craftboxer] Vsechny boxy vyresetovany na 0");
						Main.getInstance().setData().resetTime(nextReset);
						System.out.println("[Craftboxer] Probehl reset casu!");
					} else {
						System.out.println("[Craftboxer] Cas na reset jeste nenastal.");
					}
				}
			}, 60L, 144000);
		}

}
