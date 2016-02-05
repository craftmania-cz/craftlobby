package cz.wake.plugins.API;

import org.bukkit.entity.Player;

import cz.wake.plugins.Main;

public class WakeAPI {
	
	public int getBedwarsKills(Player p){
		return Main.getInstance().fetchData().getBedwarsKills(p);
	}
	
	public int getBedwarsScore(Player p){
		return Main.getInstance().fetchData().getBedwarsScore(p);
	}
	
	public int getBedwarsWins(Player p){
		return Main.getInstance().fetchData().getBedwarsWins(p);
	}
	
	public int getBedwarsLoses(Player p){
		return Main.getInstance().fetchData().getBedwarsLoses(p);
	}
	
	public int getBedwarsDeaths(Player p){
		return Main.getInstance().fetchData().getBedwarsDeaths(p);
	}
	
	public int getBedwarsDestroyed(Player p){
		return Main.getInstance().fetchData().getBedwarsDestroyed(p);
	}
	
	public int getBedwarsPlayed(Player p){
		return Main.getInstance().fetchData().getBedwarsPlayed(p);
	}
	
	public int getBedWarsTime(Player p){
		return Main.getInstance().fetchData().getBedWarsTime(p);
	}
	
	public int getDrawitScore(Player p){
		return Main.getInstance().fetchData().getDrawitScore(p);
	}
	
	public int getDrawitWins(Player p){
		return Main.getInstance().fetchData().getDrawitWins(p);
	}
	
	public int getDrawitLoses(Player p){
		return Main.getInstance().fetchData().getDrawitLoses(p);
	}
	
	public int getDrawitRightGuess(Player p){
		return Main.getInstance().fetchData().getDrawitRightGuess(p);
	}
	
	public int getDrawitWrongGuess(Player p){
		return Main.getInstance().fetchData().getDrawitWrongGuess(p);
	}
	
	public int getDrawitPlayed(Player p){
		return Main.getInstance().fetchData().getDrawitPlayed(p);
	}
	
	public int getUHCKills(Player p){
		return Main.getInstance().fetchData().getUHCKills(p);
	}
	
	public int getUHCDeaths(Player p){
		return Main.getInstance().fetchData().getUHCDeaths(p);
	}
	
	public int getUHCKillstreak(Player p){
		return Main.getInstance().fetchData().getUHCKillstreak(p);
	}
	
	public int getUHCBlockPlaced(Player p){
		return Main.getInstance().fetchData().getUHCBlocksPlaced(p);
	}
	
	public int getUHCBlockBroken(Player p){
		return Main.getInstance().fetchData().getUHCBlocksBroken(p);
	}
	
	public int getUHCTime(Player p){
		return Main.getInstance().fetchData().getUHCTime(p);
	}
	
	public int getAnniKills(Player p){
		return Main.getInstance().fetchData().getAnnihilationKills(p);
	}
	
	public int getAnniDeaths(Player p){
		return Main.getInstance().fetchData().getAnnihilationDeaths(p);
	}
	
	public int getAnniWins(Player p){
		return Main.getInstance().fetchData().getAnnihilationWins(p);
	}
	
	public int getAnniLosses(Player p){
		return Main.getInstance().fetchData().getAnnihilationLosses(p);
	}
	
	public int getAnniNexusDamage(Player p){
		return Main.getInstance().fetchData().getAnnihilationNexusDamage(p);
	}
	
	public int getAnniTime(Player p){
		return Main.getInstance().fetchData().getAnnihilationTime(p);
	}
	
	public int getBuildWins(Player p){
		return Main.getInstance().fetchData().getBuildBattleWins(p);
	}
	
	public int getBuildPlayedGames(Player p){
		return Main.getInstance().fetchData().getBuildBattlePlayedGames(p);
	}
	/*
	public int getBuildBlocksBroken(Player p){
		return Main.getInstance().fetchData().getBuildBattleBrokenBlocks(p);
	}
	
	public int getBuildPlacedBlocks(Player p){
		return Main.getInstance().fetchData().getBuildBattlePlacedBlocks(p);
	}
	*/
	
	public int getBuildBattleTime(Player p){
		return Main.getInstance().fetchData().getBuildBattleTime(p);
	}
	
	public int getDrawItTime(Player p){
		return Main.getInstance().fetchData().getDrawItTime(p);
	}
	
	public int getVanillaKills(Player p){
		return Main.getInstance().fetchData().getVanillaKills(p);
	}
	
	public int getVanillaDeaths(Player p){
		return Main.getInstance().fetchData().getVanillaDeaths(p);
	}
	
	public int getVanillaBlockBroken(Player p){
		return Main.getInstance().fetchData().getVanillaBlockBroken(p);
	}
	
	public int getVanillaBlockPlaced(Player p){
		return Main.getInstance().fetchData().getVanillaBlockPlaced(p);
	}
	
	public int getVanillaTime(Player p){
		return Main.getInstance().fetchData().getVanillaTime(p);
	}
	
	public int getCraftCoins(Player p){
		return Main.getInstance().fetchData().getCraftCoins(p);
	}
	
	public int getSkyWarsWins(Player p){
		return Main.getInstance().fetchData().getSkyWarsWins(p);
	}
	
	public int getSkyWarsKills(Player p){
		return Main.getInstance().fetchData().getSkyWarsKills(p);
	}
	
	public int getSkyWarsDeaths(Player p){
		return Main.getInstance().fetchData().getSkyWarsDeaths(p);
	}
	
	public int getSkyWarsPlayed(Player p){
		return Main.getInstance().fetchData().getSkyWarsPlayed(p);
	}

}
