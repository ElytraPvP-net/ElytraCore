package net.elytrapvp.elytracore.chat.listeners;

import net.elytrapvp.elytracore.ElytraCore;
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
    }
}
