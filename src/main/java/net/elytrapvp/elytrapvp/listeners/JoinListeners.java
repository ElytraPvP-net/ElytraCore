package net.elytrapvp.elytrapvp.listeners;

import net.elytrapvp.elytrapvp.chat.ChatUtils;
import net.elytrapvp.elytrapvp.scoreboard.CustomScoreboard;
import net.elytrapvp.elytrapvp.scoreboard.ScoreHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatUtils.translate("&2[&a+&2] &f" + e.getPlayer().getName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(ScoreHelper.hasScore(p)) {
            ScoreHelper.removeScore(p);
        }

        CustomScoreboard.getPlayers().remove(p.getUniqueId());

        e.setQuitMessage(ChatUtils.translate("&2[&c-&2] &f" + e.getPlayer().getName()));
    }
}