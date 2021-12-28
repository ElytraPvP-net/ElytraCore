package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytrapvp.chat.ChatUtils;
import net.elytrapvp.elytrapvp.items.ItemBuilder;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Renames an item in a player's hand.
 */
public class RenameCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public RenameCMD() {
        super("rename", "rename", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        // Exit if no arguments
        if(args.length == 0) {
            ChatUtils.chat(p,"&2&lUsage &8- &c/rename [name]");
            return;
        }

        String name = StringUtils.join(args, " ", 0, args.length);

        ItemStack item = p.getItemInHand();
        ItemStack renamed = new ItemBuilder(item)
                .setDisplayName(name)
                .build();
        p.setItemInHand(renamed);

        ChatUtils.chat(p, "&2&lRename &8- &aItem's name set to &f" + name + "&a.");
    }
}