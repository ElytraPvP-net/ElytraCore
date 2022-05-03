package net.elytrapvp.elytracore.chat.filter.filters;

import net.elytrapvp.elytracore.chat.filter.Filter;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class RepeatMessageFilter extends Filter {
    private final Map<Player, String> lastMessage = new HashMap<>();

    public RepeatMessageFilter() {
        setFalseMessage(false);
    }

    public boolean passesFilter(Player player, String message) {
        if(player.hasPermission("elytracore.bypass.repeatfilter")) {
            return true;
        }

        if(lastMessage.get(player) == null) {
            lastMessage.put(player, message);
            return true;
        }

        if(message.length() <= 5 || (message.length() * 2) <= lastMessage.get(player).length() || (lastMessage.get(player).length() * 2) <= message.length()) {
            lastMessage.put(player, message);
            return true;
        }

        if(message.contains(lastMessage.get(player)) || lastMessage.get(player).contains(message)) {
            ChatUtils.chat(player, "&cYou cannot say the same message twice!");
            return false;
        }

        lastMessage.put(player, message);
        return true;
    }

    public void removePlayer(Player player) {
        lastMessage.remove(player);
    }
}
