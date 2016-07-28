package cz.wake.plugins.API;

import java.util.UUID;

import org.bukkit.entity.Player;

import cz.wake.plugins.Main;

public class WakeAPI {
	
	public int getBedwarsKills(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsKills(uuid);
	}
	
	public int getBedwarsScore(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsScore(uuid);
	}
	
	public int getBedwarsWins(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsWins(uuid);
	}
	
	public int getBedwarsLoses(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsLoses(uuid);
	}
	
	public int getBedwarsDeaths(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsDeaths(uuid);
	}
	
	public int getBedwarsDestroyed(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsDestroyed(uuid);
	}
	
	public int getBedwarsPlayed(UUID uuid){
		return Main.getInstance().fetchData().getBedwarsPlayed(uuid);
	}
	
	public int getBedWarsTime(UUID uuid){
		return Main.getInstance().fetchData().getBedWarsTime(uuid);
	}
	
	public int getDrawitScore(UUID uuid){
		return Main.getInstance().fetchData().getDrawitScore(uuid);
	}
	
	public int getDrawitWins(UUID uuid){
		return Main.getInstance().fetchData().getDrawitWins(uuid);
	}
	
	public int getDrawitLoses(UUID uuid){
		return Main.getInstance().fetchData().getDrawitLoses(uuid);
	}
	
	public int getDrawitRightGuess(UUID uuid){
		return Main.getInstance().fetchData().getDrawitRightGuess(uuid);
	}
	
	public int getDrawitWrongGuess(UUID uuid){
		return Main.getInstance().fetchData().getDrawitWrongGuess(uuid);
	}
	
	public int getDrawitPlayed(UUID uuid){
		return Main.getInstance().fetchData().getDrawitPlayed(uuid);
	}
	
	public int getBuildWins(UUID uuid){
		return Main.getInstance().fetchData().getBuildBattleWins(uuid);
	}
	
	public int getBuildPlayedGames(UUID uuid){
		return Main.getInstance().fetchData().getBuildBattlePlayedGames(uuid);
	}
	
	public int getBuildBattleTime(UUID uuid){
		return Main.getInstance().fetchData().getBuildBattleTime(uuid);
	}
	
	public int getDrawItTime(UUID uuid){
		return Main.getInstance().fetchData().getDrawItTime(uuid);
	}
	
	public int getVanillaKills(UUID uuid){
		return Main.getInstance().fetchData().getVanillaKills(uuid);
	}
	
	public int getVanillaDeaths(UUID uuid){
		return Main.getInstance().fetchData().getVanillaDeaths(uuid);
	}
	
	public int getVanillaBlockBroken(UUID uuid){
		return Main.getInstance().fetchData().getVanillaBlockBroken(uuid);
	}
	
	public int getVanillaBlockPlaced(UUID uuid){
		return Main.getInstance().fetchData().getVanillaBlockPlaced(uuid);
	}
	
	public int getVanillaTime(UUID uuid){
		return Main.getInstance().fetchData().getVanillaTime(uuid);
	}
	
	public int getCraftCoins(UUID uuid){
		return Main.getInstance().fetchData().getCraftCoins(uuid);
	}
	
	public int getSkyWarsWins(UUID uuid){
		return Main.getInstance().fetchData().getSkyWarsWins(uuid);
	}
	
	public int getSkyWarsKills(UUID uuid){
		return Main.getInstance().fetchData().getSkyWarsKills(uuid);
	}
	
	public int getSkyWarsDeaths(UUID uuid){
		return Main.getInstance().fetchData().getSkyWarsDeaths(uuid);
	}
	
	public int getSkyWarsPlayed(UUID uuid){
		return Main.getInstance().fetchData().getSkyWarsPlayed(uuid);
	}

}
