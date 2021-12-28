package net.elytrapvp.elytracore.listener;

import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class PlayerJoinListener implements Listener {
    private final Plugin plugin;

    public PlayerJoinListener(Plugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatUtils.translate("&2[&a+&2] &f" + e.getPlayer().getName()));
    }
}