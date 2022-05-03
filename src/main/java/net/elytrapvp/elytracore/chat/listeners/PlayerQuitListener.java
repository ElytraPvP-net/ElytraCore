package net.elytrapvp.elytracore.chat.listeners;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private final ElytraCore plugin;

    public PlayerQuitListener(ElytraCore plugin) {
        this.plugin = plugin;
    }

    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        plugin.getFilterManager().removePlayer(player);

        // Disables default quit message.
        event.setQuitMessage(null);

        if(player.hasPermission("elytracore.staff")) {
            if(!plugin.getStaffPlayerManager().getPlayer(player).isVanished()) {
                Bukkit.broadcastMessage(ChatUtils.translate("&8[&c-&8] &c" + player.getName()));
            }
        }
        else {
            Bukkit.broadcastMessage(ChatUtils.translate("&8[&c-&8] &c" + player.getName()));
        }
    }
}
