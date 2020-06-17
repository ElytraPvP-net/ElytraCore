package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender is not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly players can use that command.");
            return true;
        }

        Player p = (Player) sender;

        switch (cmd.getName())
        {
            case "ecsee":
                ecseeCommand(p, args);
                break;

            case "invsee":
                invseeCommand(p, args);
                break;
        }

        return true;
    }

    /**
     * Runs the /ecsee command.
     * @param p Player running the command.
     * @param args Command arguments.
     */
    private void ecseeCommand(Player p, String[] args)
    {
        // Exit if no permission.
        if(!p.hasPermission("ep.ecsee"))
        {
            ChatUtils.chat(p, "&2&lError &8- You do not have access to that command.");
            return;
        }

        // Exit if no arguments.
        if(args.length == 0)
        {
            ChatUtils.chat(p, "&2&lUsage 78- &c/ecsee [player]");
            return;
        }

        Player t = Bukkit.getPlayer(args[0]);

        // Exit if player is not online.
        if(t == null)
        {
            ChatUtils.chat(p, "&2&lError &8- &cThat player is not online.");
            return;
        }

        p.openInventory(t.getEnderChest());

    }

    /**
     * Runs the /invsee command
     * @param p Player running the command.
     * @param args Command arguments.
     */
    private void invseeCommand(Player p, String[] args)
    {
        // Exit if no permission.
        if(!p.hasPermission("ep.invsee"))
        {
            ChatUtils.chat(p, "&2&lError &8- You do not have access to that command.");
            return;
        }

        // Exit if no arguments.
        if(args.length == 0)
        {
            ChatUtils.chat(p, "&2&lUsage 78- &c/invsee [player]");
            return;
        }

        Player t = Bukkit.getPlayer(args[0]);

        // Exit if player is not online.
        if(t == null)
        {
            ChatUtils.chat(p, "&2&lError &8- &cThat player is not online.");
            return;
        }

        p.openInventory(t.getInventory());
    }

}
