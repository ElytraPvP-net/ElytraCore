package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class runs the name command, which allows to check the name history of an account.
 */
public class NamesCMD extends AbstractCommand {
    private final ElytraCore plugin;

    /**
     * Creates the /alts command with the permission "elytracore.alts" and no arguments.
     * @param plugin Instance of the plugin.
     */
    public NamesCMD(ElytraCore plugin) {
        super("names", "elytracore.names", true);

        this.plugin = plugin;
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        // Make sure they're using the command properly.
        if(args.length < 1) {
            ChatUtils.chat(sender, "&c&lUsage &8» &c/names [player]");
            return;
        }

        // Runs MySQL async.
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                PreparedStatement statement = plugin.getMySQL().getConnection().prepareStatement("SELECT * FROM player_info WHERE username = ?");
                statement.setString(1, args[0]);
                ResultSet results = statement.executeQuery();

                if(results.next()) {
                    String target = results.getString(2);
                    String uuid = results.getString(1);
                    PreparedStatement statement2 = plugin.getMySQL().getConnection().prepareStatement("SELECT * FROM player_usernames WHERE uuid = ?");
                    statement2.setString(1, uuid);
                    ResultSet results2 = statement2.executeQuery();

                    ChatUtils.chat(sender, "&aPast Names of &f" + target + "&a:");
                    while(results2.next()) {
                        ChatUtils.chat(sender, "&7- &f" + results2.getString(2));
                    }
                }
                else {
                    ChatUtils.chat(sender, "&cError &8» &cThat player has not played.");
                }
            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }
}