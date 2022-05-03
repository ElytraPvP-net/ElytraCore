package net.elytrapvp.elytracore.misc.listeners;

import net.elytrapvp.elytracore.ElytraCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PlayerJoinListener implements Listener {
    private final ElytraCore plugin;

    public PlayerJoinListener(ElytraCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        String ip = player.getAddress().getHostString();

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                PreparedStatement statement1 = plugin.getMySQL().getConnection().prepareStatement("SELECT * from player_info WHERE uuid = ?");
                statement1.setString(1, uuid);
                ResultSet results = statement1.executeQuery();

                if(results.next()) {
                    // Update the username of the player.
                    if(!results.getString("username").equals(player.getName())) {
                        addNameHistory(player);
                    }

                    // Update IP Address of the player.
                    if(!results.getString("ip").equals(ip)) {
                        addIPHistory(uuid, ip);
                    }

                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    PreparedStatement statement3 = plugin.getMySQL().getConnection().prepareStatement("UPDATE player_info SET lastOnline = ? WHERE uuid = ?");
                    statement3.setTimestamp(1, timestamp);
                    statement3.setString(2, uuid);
                    statement3.executeUpdate();
                }
                else {
                    PreparedStatement statement2 = plugin.getMySQL().getConnection().prepareStatement("INSERT INTO player_info (uuid) VALUES (?)");
                    statement2.setString(1, uuid);
                    statement2.executeUpdate();

                    addNameHistory(player);
                    addIPHistory(uuid, ip);
                }
            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }

    /**
     * Add to the player's ip history.
     * @param uuid UUID of the player.
     * @param ip IP of the player.
     */
    private void addIPHistory(String uuid, String ip) {
        try {
            PreparedStatement statement1 = plugin.getMySQL().getConnection().prepareStatement("INSERT INTO player_ips (uuid,ip) VALUES (?,?)");
            statement1.setString(1, uuid);
            statement1.setString(2, ip);
            statement1.executeUpdate();

            PreparedStatement statement2 = plugin.getMySQL().getConnection().prepareStatement("UPDATE player_info SET ip = ? WHERE uuid = ?");
            statement2.setString(1, ip);
            statement2.setString(2, uuid);
            statement2.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Add to the player's username history.
     * @param player Player to add to.
     */
    private void addNameHistory(Player player) {
        try {
            PreparedStatement statement1 = plugin.getMySQL().getConnection().prepareStatement("INSERT INTO player_usernames (uuid,username) VALUES (?,?)");
            statement1.setString(1, player.getUniqueId().toString());
            statement1.setString(2, player.getName());
            statement1.executeUpdate();

            PreparedStatement statement2 = plugin.getMySQL().getConnection().prepareStatement("UPDATE player_info SET username = ? WHERE uuid = ?");
            statement2.setString(1, player.getName());
            statement2.setString(2, player.getUniqueId().toString());
            statement2.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}