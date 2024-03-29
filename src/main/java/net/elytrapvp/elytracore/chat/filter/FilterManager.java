package net.elytrapvp.elytracore.chat.filter;

import net.elytrapvp.elytracore.chat.filter.filters.RepeatMessageFilter;
import net.elytrapvp.elytracore.chat.filter.filters.TooFastFilter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FilterManager {
    private final List<Filter> filters = new ArrayList<>();

    public FilterManager() {
        filters.add(new TooFastFilter());
        filters.add(new RepeatMessageFilter());
    }

    public boolean passesFilter(Player player, String message) {
        for(Filter filter: filters) {
            if(!filter.passesFilter(player, message)) {
                return false;
            }
        }

        return true;
    }

    public void removePlayer(Player player) {
        for(Filter filter: filters) {
            filter.removePlayer(player);
        }
    }
}
