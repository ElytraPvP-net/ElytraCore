package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.staff.players.StaffPlayer;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the vanish command, which hides a player from all others.
 */
public class VanishCMD extends AbstractCommand {
    private final ElytraCore plugin;

    /**
     * Creates the /vanish command with the permission "elytracore.vanish".
     * @param plugin Instance of the plugin.
     */
    public VanishCMD(ElytraCore plugin) {
        super("vanish", "elytracore.vanish", false);
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

        if(staffPlayer.isVanished()) {
            staffPlayer.setVanished(false);
            ChatUtils.chat(player, "&aYou are no longer vanished.");
        }
        else {
            staffPlayer.setVanished(true);
            ChatUtils.chat(player, "&aYou are now vanished.");
        }
    }
}