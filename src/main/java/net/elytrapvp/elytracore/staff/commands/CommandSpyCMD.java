package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.staff.players.StaffPlayer;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the commandspy command, which spies on all commands being used.
 */
public class CommandSpyCMD extends AbstractCommand {
    private final ElytraCore plugin;

    /**
     * Creates the /commandspy command with the permission "elytracore.commandspy".
     * @param plugin Instance of the plugin.
     */
    public CommandSpyCMD(ElytraCore plugin) {
        super("commandspy", "elytacore.commandspy", false);
        this.plugin = plugin;
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        StaffPlayer staffPlayer = plugin.getStaffPlayerManager().getPlayer(player);

        if(staffPlayer.isSpying()) {
            staffPlayer.setSpying(false);
            ChatUtils.chat(player, "&aYou are no longer spying on commands.");
        }
        else {
            staffPlayer.setSpying(true);
            ChatUtils.chat(player, "&aYou are now spying on commands.");
        }
    }
}
