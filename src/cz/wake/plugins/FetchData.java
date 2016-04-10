package cz.wake.plugins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

public class FetchData {
	
	public synchronized int getBedwarsKills(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		} 
		return 0;
	}
	
	public synchronized int getBedwarsWins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsScore(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT score FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("score");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsLoses(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT loses FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("loses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsDeaths(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsDestroyed(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT destroyedBeds FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("destroyedBeds");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedwarsPlayed(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT games FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("games");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBedWarsTime(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM bw_playedtime WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitScore(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT points FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("points");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitWins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT victories FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("victories");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitLoses(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT losses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("losses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitRightGuess(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT right_guesses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("right_guesses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitWrongGuess(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wrong_guesses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wrong_guesses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawitPlayed(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT plays FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("plays");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCKills(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Kills FROM uhc_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCDeaths(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Deaths FROM uhc_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCKillstreak(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Killstreak FROM uhc_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Killstreak");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCBlocksBroken(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksBroken FROM uhc_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksBroken");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCBlocksPlaced(UUID uuid){
	
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksPlaced FROM uhc_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksPlaced");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getUHCTime(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM uhc_playedtime WHERE UUID = '" + uuid.toString() + "'");
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
	
	public synchronized int getBuildBattleTime(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM bb_playedtime WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattleWins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Wins FROM masterbuilders WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getBuildBattlePlayedGames(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT PlayedGames FROM masterbuilders WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("PlayedGames");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getDrawItTime(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM dw_playedtime WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaKills(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Kills FROM vanilla_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaDeaths(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Deaths FROM vanilla_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("Deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaBlockBroken(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksBroken FROM vanilla_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksBroken");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaBlockPlaced(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT BlocksPlaced FROM vanilla_stats WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("BlocksPlaced");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getVanillaTime(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM vanilla_playedtime WHERE UUID = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("OnlineTime");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getCraftCoins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT balance FROM CraftCoins WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("balance");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsKills(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM msw WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsWins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM msw WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsDeaths(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM msw WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("deaths");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getSkyWarsPlayed(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT games FROM msw WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("games");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getTurfWarsKills(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM TurfWarsStats WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("kills");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getTurfWarsWins(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM TurfWarsStats WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("wins");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int getTurfWarsLosses(UUID uuid){
		
		try{
			ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT losses FROM TurfWarsStats WHERE uuid = '" + uuid.toString() + "'");
			if(localResultSet.next()){
				return localResultSet.getInt("losses");
			}
			localResultSet.close();
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return 0;
	}
	
	public boolean hasData(final UUID uuid) {
		
		Boolean hasData = Boolean.valueOf(false);
		
		final String query = "SELECT * FROM craftboxer_buys WHERE uuid = '" + uuid.toString() + "';";
		
		try {
			ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);
			if (result.next()) {
		        hasData = Boolean.valueOf(true);
		      }
			result.close();
		} catch (SQLException e) {
			//Nic
		}
		return hasData.booleanValue();
	}
	
	public final long getTimeToBuy(final UUID uuid) {
		
		final String query = "SELECT time FROM craftboxer_buys WHERE uuid = '" + uuid.toString() + "';";
		
		try {
			
			ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);
			
			if(result.next()) {
				return result.getLong("time");
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
