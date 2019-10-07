package cz.wake.lobby.sql;

import com.zaxxer.hikari.HikariDataSource;
import cz.wake.lobby.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class SQLManager {

    private final Main plugin;
    private final ConnectionPoolManager pool;
    private HikariDataSource dataSource;

    public SQLManager(Main plugin) {
        this.plugin = plugin;
        pool = new ConnectionPoolManager(plugin);
    }

    public void onDisable() {
        pool.closePool();
    }

    public ConnectionPoolManager getPool() {
        return pool;
    }

    public final long getTimeToBuy(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT time FROM craftboxer_buys WHERE uuid = '" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getLong("time");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0L;
    }

    public final void updateTimeBuy(final Player p, final long time) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE craftboxer_buys SET time = ? WHERE uuid = '" + p.getUniqueId().toString() + "';");
                    ps.setLong(1, time);
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public int getOnlinePlayers(final String server) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT pocet_hracu FROM stav_survival_server WHERE nazev = '" + server + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("pocet_hracu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final void addSettingsDefault(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("INSERT INTO player_settings (Nick) VALUES (?) ON DUPLICATE KEY UPDATE Nick = ?;");
                    ps.setString(1, p.getName());
                    ps.setString(2, p.getName());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateSettings(final Player p, final String settings, final int value) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_settings SET " + settings + " = " + value + " WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateSettings(final Player p, final String settings, final String value) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_settings SET " + settings + "=? WHERE nick = ?;");
                    //ps.setString(1, p.getName());
                    ps.setString(1, value);
                    ps.setString(2, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final int getSettings(final Player p, final String settings) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + settings + " FROM player_settings WHERE nick = '" + p.getName() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(settings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final String getSettingsString(final Player p, final String settings) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + settings + " FROM player_settings WHERE nick = '" + p.getName() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString(settings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return null;
    }

    public final int getMiniGamesStats(final Player p, final String table, final String playerRow, final String stat) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + stat + " FROM " + table + " WHERE " + playerRow + " = '" + p.getName() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(stat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public int getOnlinePlayersSum(final String table) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT SUM(pocet_hracu) AS total FROM " + table + "");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public int getMaintenance(final String s) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT udrzba FROM stav_survival_server WHERE nazev = '" + s + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("udrzba");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final boolean isAT(Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT * FROM at_table WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            return ps.getResultSet().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            pool.close(conn, ps, null);
        }
    }

    public final int getAtPlayerTime(Player p, String table) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + table + " FROM at_table WHERE nick = '" + p.getName() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final void updateAtLastActive(Player p, long time) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE at_table SET minigames_pos_aktivita = '" + time + "' WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateAtPlayerTime(Player p) {
        int cas = Main.getInstance().getSQL().getAtPlayerTime(p, "minigames_played_time") + 1;
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE at_table SET minigames_played_time = '" + cas + "' WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateAtPoints(Player p) {
        int cas = Main.getInstance().getSQL().getAtPlayerTime(p, "minigames_chat_body") + 1;
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE at_table SET minigames_chat_body = '" + cas + "' WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void createRewardsRecord(final Player p, final String reward) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("INSERT INTO " + reward + " (nick,vybrano) VALUES (?,?) ON DUPLICATE KEY UPDATE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.setInt(2, 0);
                    ps.setString(3, p.getName());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final int hasActiveReward(final Player p, final String reward) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT vybrano FROM " + reward + " WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("vybrano");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final void updateRewardRecord(final Player p, final String reward) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE " + reward + " SET vybrano = 1 WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final long getNextRewardReset(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT time FROM craftboxer_nextReset WHERE id = " + id + ";");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getLong("time");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0L;
    }

    public final void resetDailyReward() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE lobby_denniodmena SET vybrano = 0;");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void resetMonthlyReward() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE lobby_lobby_vipodmena SET vybrano = 0;");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final int getPlayerProfileDataInt(Player p, String data) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + data + " FROM player_profile WHERE uuid = '" + p.getUniqueId().toString() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final int getPlayerProfileDataIntNoUUID(Player p, String data) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + data + " FROM player_profile WHERE nick = '" + p.getName() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final String getPlayerProfileDataString(Player p, String data) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + data + " FROM player_profile WHERE uuid = '" + p.getUniqueId().toString() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return "";
    }

    public final Long getPlayerProfileDataLong(Player p, String data) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + data + " FROM player_profile WHERE uuid = '" + p.getUniqueId().toString() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getLong(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return (long) 0;
    }

    public final void updateStatus(final Player p, final String status) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET status = ? WHERE uuid = ?;");
                    ps.setString(1, status);
                    ps.setString(2, p.getUniqueId().toString());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateSocLinks(final Player p, final String type, final String link) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET " + type + " = ? WHERE uuid = ?;");
                    ps.setString(1, link);
                    ps.setString(2, p.getUniqueId().toString());
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void updateCcominutyForceNick(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET nick = ? WHERE uuid = '" + p.getUniqueId().toString() + "';");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    //e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void addTokens(final String p, final int tokens) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET crafttokens = ? WHERE nick = '" + p + "';");
                    ps.setInt(1, getTokens(p) + tokens);
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final int getTokens(final String p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT crafttokens FROM player_profile WHERE nick = '" + p + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("crafttokens");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final String getNameInCcomunity(final String uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT nick FROM player_profile WHERE uuid = '" + uuid + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("nick");
            }
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return null;
    }

    public int checkDay(final Player p, final int day) {
        Connection conn = null;
        PreparedStatement ps = null;
        String selector = "day" + day;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + selector + " FROM kalendar_vyber WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(selector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public final void addCalendarDefaultValue(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("INSERT INTO kalendar_vyber (Nick) VALUES (?) ON DUPLICATE KEY UPDATE Nick = ?;");
                    ps.setString(1, p.getName());
                    ps.setString(2, p.getName());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final void addCalendarDay(final Player p, final int day) {
        String selector = "day" + String.valueOf(day);
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE kalendar_vyber SET " + selector + " = 1 WHERE nick = ?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final boolean isInWhitelist(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT * FROM ggt_players WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            return ps.getResultSet().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            pool.close(conn, ps, null);
        }
    }

    public final String unlockState() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT server FROM ggt_settings;");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("server");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return "";
    }

    public final void resetWeekVotes() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET week_votes = 0;");
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final String getNameInATS(final String uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT nick FROM at_table WHERE uuid = '" + uuid + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("nick");
            }
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return null;
    }

    public final void updateNickInATS(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE at_table SET nick = ? WHERE uuid = '" + p.getUniqueId().toString() + "';");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                } catch (Exception e) {
                    //e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final int getBedwarsPlayerData(Player p, String data) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT " + data + " FROM bw_stats_players WHERE uuid = '" + p.getUniqueId().toString() + "'");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return 0;
    }

    public int getBedwarsTopPosition(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT count( * ) AS number FROM bw_stats_players WHERE score >= ( SELECT score FROM `bw_stats_players` WHERE uuid = ?);");
            ps.setString(1, p.getUniqueId().toString());
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return -1;
    }

    public int getVotesTopPosition(final Player p, final String type) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT count( * ) AS number FROM player_profile WHERE " + type + "_votes >= ( SELECT " + type + "_votes FROM player_profile WHERE uuid = ?);");
            ps.setString(1, p.getUniqueId().toString());
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return -1;
    }

    //Discord Connections

    public final boolean isConnectedToDiscord(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT discord_user_id FROM player_profile WHERE nick = '" + p.getName() + "';");
            //discord_user_id NULL
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                if (StringUtils.isBlank(ps.getResultSet().getString("discord_user_id"))) return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            pool.close(conn, ps, null);
        }
    }

    public final boolean hasConnectionRequest(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT * FROM player_discordconnections WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            return ps.getResultSet().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            pool.close(conn, ps, null);
        }
    }

    public final String getConnectionCode(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT code FROM player_discordconnections WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("code");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return "";
    }

    public final void createConnectionRequest(final Player p, final String code) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("INSERT INTO player_discordconnections (nick, uuid, end_period, code) VALUES (?, ?, ?, ?);");
                    ps.setString(1, p.getName());
                    ps.setString(2, p.getUniqueId().toString());
                    ps.setLong(3, System.currentTimeMillis() + (5 * 60 * 1000));
                    ps.setString(4, code);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
        removeConnectionRequest(p); //automatically delete after 5 mins
    }

    public final void removeConnectionRequest(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("DELETE FROM player_discordconnections WHERE nick =?;");
                    ps.setString(1, p.getName());
                    ps.executeUpdate();
                    if (p.isOnline()) {
                        p.sendMessage("§c§l(!) §cTvuj prepojovaci kod prave expiroval.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskLaterAsynchronously(Main.getInstance(), 5 * 60 * 20);
    }


    public final boolean sawLatestNews(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT seen_latest_news FROM player_profile WHERE nick = '" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("seen_latest_news") == 1 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return false;
    }

    public final void seeLatestNews(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    conn = pool.getConnection();
                    ps = conn.prepareStatement("UPDATE player_profile SET seen_latest_news = 1 WHERE nick = '" + p.getName() + "';");
                    ps.executeUpdate();
                } catch (Exception e) {
                    //e.printStackTrace();
                } finally {
                    pool.close(conn, ps, null);
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

    public final String getLatestNews() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT `value` FROM craftlobby_settings WHERE `name` = 'important_news';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("value");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return null;
    }

    public final boolean isLatestNewsEnabled() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = pool.getConnection();
            ps = conn.prepareStatement("SELECT `enabled` FROM craftlobby_settings WHERE `name` = 'important_news';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("enabled") == 1 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close(conn, ps, null);
        }
        return false;
    }
}
