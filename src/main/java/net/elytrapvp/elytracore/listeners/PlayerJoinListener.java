package net.elytrapvp.elytracore.listeners;

import net.elytrapvp.elytracore.ElytraSettings;
import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{
    private static final ElytraSettings settings = ElytraSettings.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        // Set join message to null if set.
        if(!settings.getConfig().getBoolean("JoinMessage"))
        {
            e.setJoinMessage(null);
            return;
        }

        e.setJoinMessage(Message.translate("&2[&a+&2] &f") + e.getPlayer().getDisplayName());
    }

}