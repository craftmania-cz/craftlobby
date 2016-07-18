package cz.wake.plugins;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                    sql.execute();
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
                    sql.execute();
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
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void takeSkyKeys(final Player p, final int coins) {

        final String query = "UPDATE CraftCoins SET skykeys = ? WHERE uuid = '" + p.getUniqueId().toString() + "';";

        new BukkitRunnable() {

            public void run() {

                try {

                    PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
                    sql.setInt(1, Main.getInstance().fetchData().getSkyKeysDust(p.getUniqueId()) - coins);
                    sql.setQueryTimeout(30);
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    /**
     * Pridani boxu bez casu
     *
     * @param uuid   - UUID
     * @param amount - Pocet boxu
     */
    public final void createRecord(final Player p, final int amount, final long milis) {

        final String query = "INSERT INTO craftboxer (nick ,uuid, pocet, dalsiBox) VALUES (?,?,?,?);";

        new BukkitRunnable() {

            public void run() {

                try {

                    PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
                    sql.setString(1, p.getName().toString());
                    sql.setString(2, p.getUniqueId().toString());
                    sql.setInt(3, amount + Main.getInstance().fetchData().getBoxes(p.getUniqueId()));
                    sql.setLong(4, milis);
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    /**
     * Pridani boxu + cas
     *
     * @param uuid   - UUID
     * @param amount - Pocet boxu
     */
    public final void addBoxesWithTime(final Player p, final int amount, final long milis) {

        //final String query = "INSERT INTO craftboxer (nick ,uuid, pocet, dalsiBox) VALUES (?,?,?,?);";
        final String query = "UPDATE craftboxer SET pocet = ?, dalsiBox = ? WHERE uuid = '" + p.getUniqueId().toString() + "'";

        new BukkitRunnable() {

            public void run() {

                try {

                    PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
                    sql.setInt(1, amount + Main.getInstance().fetchData().getBoxes(p.getUniqueId()));
                    sql.setLong(2, milis);
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    /**
     * Reset boxu na 0
     */
    public final void resetBoxes() {

        final String query = "UPDATE craftboxer SET pocet = '0';";

        new BukkitRunnable() {

            public void run() {

                try {

                    PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    /**
     * Reset
     */
    public final void resetTime(final long time) {

        final String query = "UPDATE craftboxer_nextReset SET time = ? WHERE id = 1;";

        new BukkitRunnable() {

            public void run() {

                try {

                    PreparedStatement sql = Main.getInstance().getMySQL().getCurrentConnection().prepareStatement(query);
                    sql.setLong(1, time);
                    sql.execute();
                    sql.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }.runTaskAsynchronously(Main.getInstance());
    }

}
