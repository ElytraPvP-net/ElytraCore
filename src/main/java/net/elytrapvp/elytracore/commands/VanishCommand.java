package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private static Set<UUID> vanished = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Exit if no permission.
        if (!sender.hasPermission("ep.vanish")) {
            ChatUtils.chat(sender, "&2&lError &8- &cYou do not have access to that command.");
            return true;
        }

        // Exit if not a player.
        if (!(sender instanceof Player)) {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly players can use that command.");
            return true;
        }

        Player p = (Player) sender;

        if(getVanished().contains(p.getUniqueId()))
        {
            getVanished().remove(p.getUniqueId());
            ChatUtils.chat(p, "&2&lVanish &8- &aYou are no longer hidden from other players.");

            for(Player pl : Bukkit.getOnlinePlayers())
            {
                pl.showPlayer(ElytraCore.getPlugin(), p);
            }
        }
        else
        {
            getVanished().add(p.getUniqueId());
            ChatUtils.chat(p, "&2&lVanish &8- &aYou are now hidden from other players.");

            for(Player pl : Bukkit.getOnlinePlayers())
            {
                pl.hidePlayer(ElytraCore.getPlugin(), p);
            }
        }
        return true;
    }

    public static Set<UUID> getVanished()
    {
        return vanished;
    }

}
