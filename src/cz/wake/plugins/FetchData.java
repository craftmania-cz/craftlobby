package cz.wake.plugins;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class FetchData {
	
	public synchronized int getBedwarsKills(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsWins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsScore(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT score FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("score");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsLoses(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT loses FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("loses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsDeaths(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsDestroyed(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT destroyedBeds FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("destroyedBeds");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsPlayed(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT games FROM bw_stats_players WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("games");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedWarsTime(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM bw_playedtime WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitScore(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT points FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("points");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitWins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT victories FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("victories");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitLoses(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT losses FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("losses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitRightGuess(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT right_guesses FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("right_guesses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitWrongGuess(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wrong_guesses FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wrong_guesses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitPlayed(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT plays FROM GuessNDraw WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("plays");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCKills(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Kills FROM uhc_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCDeaths(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Deaths FROM uhc_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCKillstreak(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Killstreak FROM uhc_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Killstreak");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCBlocksBroken(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksBroken FROM uhc_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksBroken");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCBlocksPlaced(Player p){
	
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksPlaced FROM uhc_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksPlaced");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCTime(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM uhc_playedtime WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public static int getPlayerLevel(Player player)
	  {
	    int level = 0;
	    try
	    {
	      ResultSet rs = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Level FROM cm_leveling WHERE UUID = '" + player.getUniqueId() + "';");
	      while (rs.next()) {
	        level = rs.getInt("Level");
	      }
	      rs.close();
	    }
	    catch (SQLException e)
	    {
	      System.out.println(e.getMessage());
	    }
	    return level;
	  }
	
	public static int getPlayerExp(Player player)
	  {
	    int exp = 0;
	    try
	    {
	      ResultSet rs = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT EXP FROM cm_leveling WHERE UUID = '" + player.getUniqueId() + "';");
	      while (rs.next()) {
	        exp = rs.getInt("EXP");
	      }
	      rs.close();
	    }
	    catch (SQLException e)
	    {
	      System.out.println(e.getMessage());
	    }
	    return exp;
	  }
	
	public static int getExpToLevel(int level){  
		  if(level == 1){
			  return 120;
		  }
		  if(level == 2){
			  return 350;
		  }
		  if(level == 3){
			  return 670;
		  }
		  if(level == 4){
			  return 960;
		  }
		  if(level == 5){
			  return 1500;
		  }
		  if(level == 6){
			  return 2000;
		  }
		  if(level == 7){
			  return 2400;
		  }
		  if(level == 8){
			  return 3000;
		  }
		  if(level == 9){
			  return 3800;
		  }
		  if(level == 10){
			  return 4500;
		  }
		  if(level == 11){
			  return 5000;
		  }
		  if(level == 12){
			  return 5600;
		  }
		  if(level == 13){
			  return 6400;
		  }
		  if(level == 14){
			  return 7000;
		  }
		  if(level == 15){
			  return 7800;
		  }
		  if(level == 16){
			  return 9000;
		  }
		  if(level == 17){
			  return 10000;
		  }
		  if(level == 18){
			  return 10900;
		  }
		  if(level == 19){
			  return 11500;
		  }
		  if(level == 20){
			  return 12300;
		  }
		  if(level == 21){
			  return 13000;
		  }
		  if(level == 22){
			  return 13600;
		  }
		  if(level == 23){
			  return 14200;
		  }
		  if(level == 24){
			  return 15000;
		  }
		  if(level == 25){
			  return 16000;
		  }
		  if(level == 26){
			  return 17200;
		  }
		  if(level == 27){
			  return 18400;
		  }
		  if(level == 28){
			  return 19000;
		  }
		  if(level == 29){
			  return 20000;
		  }
		return 0;
	  }
	
	public synchronized int getAnnihilationKills(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM annihilation WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getAnnihilationDeaths(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM annihilation WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getAnnihilationWins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM annihilation WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getAnnihilationLosses(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT losses FROM annihilation WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("losses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getAnnihilationNexusDamage(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT nexus_damage FROM annihilation WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("nexus_damage");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getAnnihilationTime(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM anni_playedtime WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleWins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleLoses(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT loses FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("loses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleBestScore(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT highestwin FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("highestwin");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattlePlayedGames(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT gamesplayed FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("gamesplayed");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleBrokenBlocks(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT blocksbroken FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("blocksbroken");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattlePlacedBlocks(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT blocksplaced FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("blocksplaced");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleParticles(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT particles FROM buildbattlestats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("particles");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawItTime(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM dw_playedtime WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaKills(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Kills FROM vanilla_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaDeaths(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Deaths FROM vanilla_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaBlockBroken(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksBroken FROM vanilla_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksBroken");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaBlockPlaced(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksPlaced FROM vanilla_stats WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksPlaced");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaTime(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM vanilla_playedtime WHERE UUID = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getCraftCoins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT balance FROM CraftCoins WHERE uuid = '" + p.getUniqueId().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("balance");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsKills(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM SkyWars_Data WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsWins(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM SkyWars_Data WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsDeaths(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM SkyWars_Data WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsPlayed(Player p){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT played FROM SkyWars_Data WHERE username = '" + p.getName().toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("played");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	

}
