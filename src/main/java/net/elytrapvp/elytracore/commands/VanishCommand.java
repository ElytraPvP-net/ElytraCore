package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
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
            sender.sendMessage(Message.noPermission());
            return true;
        }

        // Exit if not a player.
        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.notAPlayer());
            return true;
        }

        Player p = (Player) sender;

        if(getVanished().contains(p.getUniqueId()))
        {
            getVanished().remove(p.getUniqueId());
            ElytraChat.sendMessage(p, "&2&lVanish &8- &aYou are no longer hidden from other players.");

            for(Player pl : Bukkit.getOnlinePlayers())
            {
                pl.showPlayer(ElytraCore.getPlugin(), p);
            }
        }
        else
        {
            getVanished().add(p.getUniqueId());
            ElytraChat.sendMessage(p, "&2&lVanish &8- &aYou are now hidden from other players.");

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
