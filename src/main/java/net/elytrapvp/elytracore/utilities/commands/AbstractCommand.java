package net.elytrapvp.elytracore.utilities.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.chat.commands.ChatLogCMD;
import net.elytrapvp.elytracore.chat.commands.ClearChatCMD;
import net.elytrapvp.elytracore.chat.commands.PersonalClearChatCMD;
import net.elytrapvp.elytracore.misc.commands.*;
import net.elytrapvp.elytracore.staff.commands.*;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CommandExecutor {
    private final String commandName;
    private final String permission;
    private final boolean canConsoleUse;
    private static ElytraCore plugin;

    /**
     * Creates a new AbstractCommand.
     * @param commandName Name of the command.
     * @param permission Permission required to use the command.
     * @param canConsoleUse Whether or not console can use the command.
     */
    public AbstractCommand(final String commandName, final String permission, final boolean canConsoleUse) {
        this.commandName = commandName;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        plugin.getCommand(commandName).setExecutor(this);
    }

    /**
     * Registers all commands in the plugin.
     * @param pl Plugin.
     */
    public static void registerCommands(ElytraCore pl) {
        plugin = pl;

        // Chat
        new ChatLogCMD(pl);
        new ClearChatCMD();
        new PersonalClearChatCMD();

        // Staff
        new AltsCMD(pl);
        new ECSeeCMD();
        new FlyCMD();
        new InvisibleCMD();
        new InvSeeCMD();
        new NamesCMD(pl);
        new UUIDCMD();

        // Misc
        new BroadcastCMD();
        new FeedCMD();
        new HealCMD();
        new RenameCMD();
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public abstract void execute(CommandSender sender, String[] args);

    /**
     * Processes early execution of the plugin.
     * @param sender Command Sender.
     * @param cmd The Command.
     * @param label Command Label.
     * @param args Command Arugments.
     * @return Successful Completion.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!permission.equals("") && !sender.hasPermission(permission)) {
            ChatUtils.chat(sender, "&cError &8» &cYou do not have access to that command.");
            return true;
        }
        if(!canConsoleUse && !(sender instanceof Player)) {
            ChatUtils.chat(sender, "&cError &8» &cOnly players can use that command.");
            return true;
        }
        execute(sender, args);
        return true;
    }
}