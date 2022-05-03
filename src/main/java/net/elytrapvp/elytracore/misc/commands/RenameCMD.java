package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import net.elytrapvp.elytracore.utilities.items.ItemBuilder;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * This class runs the rename command, which allows to a player to rename an item.
 */
public class RenameCMD extends AbstractCommand {

    /**
     * Creates the /rename command with the permission "elytracore.rename".
     */
    public RenameCMD() {
        super("rename", "elytracore.rename", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        // Exit if no arguments
        if(args.length == 0) {
            ChatUtils.chat(player,"&c&lUsage &8» &c/rename [name]");
            return;
        }

        String name = StringUtils.join(args, " ", 0, args.length);

        ItemStack item = player.getItemInHand();
        ItemStack renamed = new ItemBuilder(item)
                .setDisplayName(name)
                .build();
        player.setItemInHand(renamed);

        ChatUtils.chat(player, "&a&lRename &8» &aItem's name set to &f" + name + "&a.");
    }
}