package net.elytrapvp.elytracore.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffModePlayer {
    private static Map<UUID, StaffModePlayer> players = new HashMap<>();

    private final UUID uuid;
    private final ItemStack[] inventory;
    private final Location location;

    public StaffModePlayer(final UUID uuid) {
        this.uuid = uuid;

        Player p = Bukkit.getPlayer(uuid);
        inventory = p.getInventory().getContents();
        location = p.getLocation();

        players.put(uuid, this);
    }

    public static Map<UUID, StaffModePlayer> getPlayers() {
        return players;
    }

    public void delete() {
        Player p = Bukkit.getPlayer(uuid);

        p.teleport(location);
        p.getInventory().setContents(inventory);

        players.remove(uuid);
    }

    public UUID getUuid() {
        return uuid;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
    }

}