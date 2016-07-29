package cz.wake.plugins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FetchData {

    public synchronized int getBedwarsKills(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT kills FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("kills");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsWins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wins FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("wins");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsScore(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT score FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("score");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsLoses(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT loses FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("loses");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsDeaths(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT deaths FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("deaths");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsDestroyed(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT destroyedBeds FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("destroyedBeds");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedwarsPlayed(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT games FROM bw_stats_players WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("games");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBedWarsTime(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM bw_playedtime WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("OnlineTime");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitScore(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT points FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("points");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitWins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT victories FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("victories");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitLoses(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT losses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("losses");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitRightGuess(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT right_guesses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("right_guesses");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitWrongGuess(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT wrong_guesses FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("wrong_guesses");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawitPlayed(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT plays FROM GuessNDraw WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("plays");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBuildBattleTime(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM bb_playedtime WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("OnlineTime");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBuildBattleWins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Wins FROM masterbuilders WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Wins");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getBuildBattlePlayedGames(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT PlayedGames FROM masterbuilders WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("PlayedGames");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getDrawItTime(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT OnlineTime FROM dw_playedtime WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("OnlineTime");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getCraftCoins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT balance FROM CraftCoins WHERE uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("balance");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getSkyWarsKills(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT normal_kills FROM skywars_players WHERE player_uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("normal_kills");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getSkyWarsWins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT normal_wins FROM skywars_players WHERE player_uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("normal_wins");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getSkyWarsDeaths(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT normal_deaths FROM skywars_players WHERE player_uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("normal_deaths");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getSkyWarsPlayed(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT normal_played FROM skywars_players WHERE player_uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("normal_played");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }


    public synchronized int getSkyWarsDust(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT skykeys FROM CraftCoins WHERE uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("skykeys");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
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

            if (result.next()) {
                return result.getLong("time");
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Zkontroluje @param uuid jestli se nachazi v DB.
     *
     * @param uuid - UUID ke kontrole
     * @return true/false podle toho zda tam je nebo ne
     */
    public boolean hasBoxData(final UUID uuid) {

        Boolean hasData = Boolean.valueOf(false);

        final String query = "SELECT * FROM craftboxer WHERE uuid = '" + uuid.toString() + "';";

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

    /**
     * Ziskani poctu jiz danych boxu!
     *
     * @param uuid - UUID hrace
     * @return Pocet boxu jiz danych na @param uuid.
     */
    public final int getBoxes(final UUID uuid) {

        final String query = "SELECT pocet FROM craftboxer WHERE uuid = '" + uuid.toString() + "';";

        try {

            ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);

            if (result.next()) {
                return result.getInt("pocet");
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Cas v milisekundach kdy se ma dat dalsi box!
     *
     * @param uuid - UUID hrace
     * @return Cas @param uuid.
     */
    public final long getNextboxTime(final UUID uuid) {

        final String query = "SELECT dalsiBox FROM craftboxer WHERE uuid = '" + uuid.toString() + "';";

        try {

            ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);

            if (result.next()) {
                return result.getLong("dalsiBox");
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Ziskani casu resetu.
     */
    public final Long getFullResetTime() {

        final String query = "SELECT time FROM craftboxer_nextReset;";

        try {

            ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);

            if (result.next()) {
                return result.getLong("time");
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (long) 0;
    }

    public final int getSkyKeysDust(final UUID uuid) {

        final String query = "SELECT skykeys FROM CraftCoins WHERE uuid = '" + uuid.toString() + "';";

        try {

            ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);

            if (result.next()) {
                return result.getInt("skykeys");
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public synchronized int getVotesWeek(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT week FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("week");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getVotesMonth(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT month FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("month");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getVotesAll(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT votes FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("votes");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniKills(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Kills FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Kills");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniDeaths(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Deaths FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Deaths");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniWins(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Wins FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Wins");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniLosses(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Losses FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Losses");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniDestroyed(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT Destroyed FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("Destroyed");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniKillBoss(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT KillBoss FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("KillBoss");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniMinedDiamond(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT MinedDiamond FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("MinedDiamond");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getAnniPlayedGames(UUID uuid) {

        try {
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT PlayedGames FROM annihilation_stats WHERE UUID = '" + uuid.toString() + "'");
            if (localResultSet.next()) {
                return localResultSet.getInt("PlayedGames");
            }
            localResultSet.close();
        } catch (SQLException localSQLException) {
            localSQLException.printStackTrace();
        }
        return 0;
    }


}
