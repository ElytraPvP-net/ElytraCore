package net.elytrapvp.elytracore.listeners;

import net.elytrapvp.elytracore.ElytraSettings;
import net.elytrapvp.elytracore.commands.VanishCommand;
import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener
{
    private static final ElytraSettings settings = ElytraSettings.getInstance();

    @EventHandler
    public void onJoin(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();

        // Remove player from vanished list.
        VanishCommand.getVanished().remove(p.getUniqueId());

        // Set join message to null if set.
        if(!settings.getConfig().getBoolean("QuitMessage"))
        {
            e.setQuitMessage(null);
            return;
        }

        e.setQuitMessage(ChatUtils.translate("&2[&c-&2] &f") + p.getDisplayName());
    }

}