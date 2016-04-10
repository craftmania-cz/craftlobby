package cz.wake.plugins;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SetData {
	
	public final void createRecordBuy(final Player p, final long milis) {
		
		final String query = "INSERT INTO craftboxer_buys (uuid, time) VALUES (?,?);";
		
		new BukkitRunnable() {
			
			public void run() {

				try {
					
					PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
					sql.setString(1, p.getUniqueId().toString());
					sql.setLong(2, milis);
					sql.setQueryTimeout(30);
					sql.executeQuery();
					sql.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
			}
		}.runTaskAsynchronously(Main.getInstance());
	}
	
	public final void updateTimeBuy(final Player p, final long time) {
		
		final String query = "UPDATE craftboxer_buys SET time = ? WHERE uuid = '" + p.getUniqueId().toString() + "';";
		
		new BukkitRunnable() {
			
			public void run() {

				try {
					
					PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
					sql.setLong(1, time);
					sql.setQueryTimeout(30);
					sql.executeQuery();
					sql.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}.runTaskAsynchronously(Main.getInstance());
	}
	
	public final void takeCoins(final Player p, final int coins) {
		
		final String query = "UPDATE CraftCoins SET balance = ? WHERE uuid = '" + p.getUniqueId().toString() + "';";
		
		new BukkitRunnable() {
			
			public void run() {

				try {
					
					PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
					sql.setInt(1, Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) - coins);
					sql.setQueryTimeout(30);
					sql.executeUpdate();
					sql.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}.runTaskAsynchronously(Main.getInstance());
	}

}
