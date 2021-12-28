package net.elytrapvp.elytracore.commands.utility;

import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.UUID;

public class TeleportCMDs implements CommandExecutor {
    private static HashMap<UUID, UUID> requests = new HashMap<>();
    private JavaPlugin plugin;

    public TeleportCMDs(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getCommand("tpa").setExecutor(this);
        plugin.getCommand("tpaccept").setExecutor(this);
        plugin.getCommand("tpdeny").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Exit if sender is not a player.
        if(!(sender instanceof Player)) {
            ChatUtils.chat(sender, "&c&lError &8» &cOnly players can use that command.");
            return true;
        }

        Player p = (Player) sender;

        switch (cmd.getName()) {
            case "tpa":
                tpa(p, args);
                break;

            case "tpaccept":
                tpaccept(p, args);
                break;

            case "tpdeny":
                tpdeny(p, args);
                break;
        }

        return true;
    }

    private void tpa(Player p, String[] args) {
        // Exit if no permission.
        if(!p.hasPermission("tpa")) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have access to that command.");
            return;
        }

        // Exit if no arguments.
        if(args.length == 0) {
            ChatUtils.chat(p, "&c&lUsage &8» &c/tpa [player]");
            return;
        }

        Player t = Bukkit.getPlayer(args[0]);
        // Exit if target is not online
        if(t == null) {
            ChatUtils.chat(p, "&c&lError &8» &cThat player is not online.");
            return;
        }

        ChatUtils.chat(p, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(t, "&7"+ t.getDisplayName() + " &ais requesting to teleport to you.");
        ChatUtils.chat(t, "");
        ChatUtils.chat(t, "  &8» &7/tpaccept &ato accept.");
        ChatUtils.chat(t, "  &8» &7/tpdeny &ato deny.");
        ChatUtils.chat(t, "");
        ChatUtils.centeredChat(t, "&aThis request will be discarded in 60 seconds.");
        ChatUtils.chat(p, "&2&l]&8&m---------------------------------------------------&2&l[");

        requests.put(t.getUniqueId(), p.getUniqueId());

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            if(requests.containsKey(t.getUniqueId()) && requests.get(t.getUniqueId()) == p.getUniqueId())
            {
                requests.remove(t.getUniqueId());
                ChatUtils.chat(p, "&a&lTeleport &8» &aRequest timed out.");
                ChatUtils.chat(t, "&a&lTeleport &8» &aRequest timed out.");
            }
        }, 1200);

        ChatUtils.chat(p, "&a&lTeleport &8» &aTeleport request sent.");


    }

    private void tpaccept(Player p, String[] args) {
        // Exit if no permission.
        if(!p.hasPermission("tpaccept")) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have access to that command.");
            return;
        }

        // Exit if no requests
        if(!requests.containsKey(p.getUniqueId())) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have any pending requests.");
            return;
        }

        Player t = Bukkit.getPlayer(requests.get(p.getUniqueId()));

        // Exit if player is not online.
        if(t == null) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have any pending requests.");
            requests.remove(p.getUniqueId());
            return;
        }

        ChatUtils.chat(p, "&a&lTeleport &8» &aTeleport request accepted.");
        ChatUtils.chat(t, "&a&lTeleport &8» &aRequest accepted. Teleporting in &f5 &aseconds.");
        requests.remove(t.getUniqueId());
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            t.teleport(p.getLocation());
        }, 100);
    }

    private void tpdeny(Player p, String[] args) {
        // Exit if no permission.
        if(!p.hasPermission("tpdeny")) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have access to that command.");
            return;
        }

        // Exit if no requests
        if(!requests.containsKey(p.getUniqueId())) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have any pending requests.");
            return;
        }

        Player t = Bukkit.getPlayer(requests.get(p.getUniqueId()));

        // Exit if player is not online.
        if(t == null) {
            ChatUtils.chat(p, "&c&lError &8» &cYou do not have any pending requests.");
            requests.remove(p.getUniqueId());
            return;
        }

        ChatUtils.chat(p, "&a&lTeleport &8» &aRequest denied.");
        ChatUtils.chat(t, "&a&lTeleport &8» &aRequest denied.");
        requests.remove(p.getUniqueId());
    }
}