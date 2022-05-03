package net.elytrapvp.elytracore.staff.listeners;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.staff.players.StaffPlayer;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListener implements Listener {
    private final ElytraCore plugin;

    public PlayerCommandPreprocessListener(ElytraCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String cmd = event.getMessage();

        // TODO: Add exemption permission

        for(StaffPlayer staff : plugin.getStaffPlayerManager().getCommandSpyEnabled()) {
            ChatUtils.chat(staff.getPlayer(), "&7[&aSpy&7] &a" + player.getName() + ": &f" + cmd);
        }
    }
}