package net.elytrapvp.elytracore.chat.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import net.elytrapvp.elytracore.utilities.gui.CustomGUI;
import net.elytrapvp.elytracore.utilities.items.ItemBuilder;
import net.elytrapvp.elytracore.utilities.items.SkullBuilder;
import net.elytrapvp.elytracore.utilities.items.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatLogCMD extends AbstractCommand {
    private final ElytraCore plugin;

    public ChatLogCMD(ElytraCore plugin) {
        super("chatlog", "elytracore.chatlog", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        // Make sure they're using the command properly.
        if(args.length < 1) {
            ChatUtils.chat(sender, "&c&lUsage &8» &c/chatlog [player]");
            return;
        }

        // Runs MySQL async.
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                PreparedStatement statement = plugin.getMySQL().getConnection().prepareStatement("SELECT * FROM player_info WHERE username = ?");
                statement.setString(1, args[0]);
                ResultSet results = statement.executeQuery();

                if(results.next()) {
                    String target = results.getString(2);
                    String uuid = results.getString(1);

                    Bukkit.getScheduler().runTask(plugin, () -> {
                        new ChatLogGUI(target, uuid, 1).open((Player) sender);
                    });
                }
                else {
                    ChatUtils.chat(sender, "&cError &8» &cThat player has not played.");
                }
            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }

    private class ChatLogGUI extends CustomGUI {
        public ChatLogGUI(String target, String uuid, int page) {
            super(54, "Chat Log - " + target);

            String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
            int subVersion = Integer.parseInt(version.replace("1_", "").replaceAll("_R\\d", "").replace("v", ""));

            if(subVersion >= 13) {
                int[] fillers = {0,1,2,3,4,5,6,7,8,45,46,47,49,51,52,53};
                for(int i : fillers) {
                    setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName(" ").build());
                }

                if(page == 1) {
                    ItemStack previous = new SkullBuilder("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0=")
                            .setDisplayName("&cPrevious Page")
                            .build();
                    setItem(48, previous);
                }
                else {
                    ItemStack previous = new SkullBuilder("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzU0YWFhYjM5NzY0NjQxZmY4NjI3OTMyZDJmZTFhNGNjY2VkOTY1Mzc1MDhkNGFiYzZjZDVmYmJiODc5MTMifX19")
                            .setDisplayName("&aPrevious Page")
                            .build();
                    setItem(48, previous, (p,a) -> new ChatLogGUI(target, uuid, page-1).open(p));
                }

                ItemStack next = new SkullBuilder("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYzMzlmZjJlNTM0MmJhMThiZGM0OGE5OWNjYTY1ZDEyM2NlNzgxZDg3ODI3MmY5ZDk2NGVhZDNiOGFkMzcwIn19fQ==")
                        .setDisplayName("&aNext Page")
                        .build();
                setItem(50, next, (p,a) -> new ChatLogGUI(target, uuid, page+1).open(p));
            }
            else {
                // Loads the filler items.
                int[] fillers = {0,1,2,3,4,5,6,7,8,45,46,47,49,51,52,53};
                ItemBuilder builder = new ItemBuilder(XMaterial.GRAY_STAINED_GLASS_PANE.parseItem())
                        .setDisplayName(" ");
                for(int i : fillers) {
                    setItem(i, builder.build());
                }

                if(page == 1) {
                    ItemStack previous = new ItemBuilder(Material.ARROW)
                            .setDisplayName("&cPrevious Page")
                            .build();
                    setItem(48, previous);
                }
                else {
                    ItemStack previous = new ItemBuilder(Material.ARROW)
                            .setDisplayName("&aPrevious Page")
                            .build();
                    setItem(48, previous, (p,a) -> new ChatLogGUI(target, uuid, page-1).open(p));
                }

                ItemStack next = new ItemBuilder(Material.ARROW)
                        .setDisplayName("&aNext Page")
                        .build();
                setItem(50, next, (p,a) -> new ChatLogGUI(target, uuid, page+1).open(p));
            }

            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                try {
                    PreparedStatement statement = plugin.getMySQL().getConnection().prepareStatement("SELECT * FROM chat_logs WHERE uuid = ? ORDER BY time DESC LIMIT ?, 36");
                    statement.setString(1, uuid);
                    statement.setInt(2, (page-1) * 36);
                    ResultSet results = statement.executeQuery();

                    int slot = 9;
                    while(results.next()) {
                        int id = results.getInt(1);
                        String server = results.getString(2);
                        String channel = results.getString(3);
                        String message = results.getString(6);
                        String time = results.getString(7);

                        addMessage(slot, id, time, server, channel, message);
                        slot++;
                    }
                }
                catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
        }

        public void addMessage(int slot, int id, String time, String server, String channel, String message) {
            ItemBuilder builder = new ItemBuilder(Material.PAPER)
                    .setDisplayName("&a#" + id)
                    .addLore("&aServer: &f" + server)
                    .addLore("&aChannel: &f" + channel)
                    .addLore("")
                    .addLore("&f" + message)
                    .addLore("")
                    .addLore("&aTime: &f" + time);

            setItem(slot, builder.build());
        }
    }
}