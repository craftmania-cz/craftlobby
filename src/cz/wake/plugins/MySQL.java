package cz.wake.plugins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.Bukkit;


public class MySQL {
	
	private Connection con;
	
	public Connection getCurrentConnection(){
		try{
			if((this.con == null) || (this.con.isClosed())){
				this.con = DriverManager.getConnection("jdbc:mysql://" + Main.getInstance().getConfig().getString("host") + ":" + Main.getInstance().getConfig().getString("port") + "/" +  Main.getInstance().getConfig().getString("database"), Main.getInstance().getConfig().getString("user"), Main.getInstance().getConfig().getString("password"));
				Bukkit.getServer().getLogger().log(Level.WARNING, "[CraftLobby] Pripojovani do SQL: " + Main.getInstance().getConfig().getString("database"));
			}
		} catch(SQLException localSQLException){
			localSQLException.printStackTrace();
		}
		return this.con;
	}
	
	public synchronized void closeConnection()
	  {
	    try
	    {
	      if ((!this.con.isClosed()) || (this.con != null)) {
	        this.con.close();
	      }
	    }
	    catch (SQLException localSQLException)
	    {
	      localSQLException.printStackTrace();
	    }
	  }
	
	public synchronized void checkTable()
	  {
	    try
	    {
	      getCurrentConnection().createStatement().execute(
	        "CREATE TABLE IF NOT EXISTS `CM_levels` (\n`UUID` varchar(36),\n`Level` int(11),\n`Exp` int(11),\n`Karma` int(11),\nPRIMARY KEY  (`UUID`)\n)");
	    }
	    catch (SQLException localSQLException)
	    {
	      localSQLException.printStackTrace();
	    }
	  }

}
