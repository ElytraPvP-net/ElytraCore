package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.ElytraCore;
import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import net.elytrapvp.elytracore.utilities.gui.CustomGUI;
import net.elytrapvp.elytracore.utilities.items.ItemBuilder;
import net.elytrapvp.elytracore.utilities.items.SkullUtils;
import net.elytrapvp.elytracore.utilities.items.XMaterial;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PunishCMD extends AbstractCommand {
    private final ElytraCore plugin;

    /**
     * Creates the /punish command with the permission "elytracore.punish".
     */
    public PunishCMD(ElytraCore plugin) {
        super("punish", "elytracore.punish", false);
        this.plugin = plugin;
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0) {
            return;
        }

        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                PreparedStatement statement = plugin.getMySQL().getConnection().prepareStatement("SELECT * FROM player_info WHERE username = ?");
                statement.setString(1, args[0]);
                ResultSet results = statement.executeQuery();

                if(results.next()) {
                    String target = results.getString(2);
                    new PunishMainGUI(target).open(player);
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


    private class PunishMainGUI extends CustomGUI {
        public PunishMainGUI(String target) {
            super(54, "Punish - " + target);

            // Loads the filler items.
            int[] fillers = {0,1,2,3,4,5,6,7,8,45,46,47,48,49,50,51,52,53};
            ItemBuilder builder = new ItemBuilder(XMaterial.GRAY_STAINED_GLASS_PANE.parseItem())
                    .setDisplayName(" ");
            for(int i : fillers) {
                setItem(i, builder.build());
            }

            // Loads the player skull.
            ItemBuilder builder2 = new ItemBuilder(Material.PAPER).setDisplayName("&a" + target);
            setItem(13, builder2.build());

            setItem(29, new ItemBuilder(Material.REDSTONE).setDisplayName("&a&lChat Offenses").build(), (p,a) -> new PunishChatGUI(target).open(p));
            setItem(31, new ItemBuilder(Material.IRON_SWORD).setDisplayName("&a&lGame Offenses").build(), (p,a) -> new PunishServerGUI(target).open(p));
            setItem(33, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("&a&lClient Offenses").build(), (p,a) -> new PunishClientGUI(target).open(p));
        }
    }

    private class PunishChatGUI extends CustomGUI {
        public PunishChatGUI(String target) {
            super(54, "Punish - " + target);

            // Loads the filler items.
            int[] fillers = {1,2,3,4,5,6,7,8,45,46,47,48,49,50,51,52,53};
            ItemBuilder builder = new ItemBuilder(XMaterial.GRAY_STAINED_GLASS_PANE.parseItem())
                    .setDisplayName(" ");
            for(int i : fillers) {
                setItem(i, builder.build());
            }

            // Loads the back item.
            ItemBuilder backButton = new ItemBuilder(SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0="))
                    .setDisplayName("&cBack");
            setItem(0, backButton.build(), (p,a) -> new PunishMainGUI(target).open(p));

            // Advertising
            {
                ItemBuilder label = new ItemBuilder(Material.REDSTONE).setDisplayName("&a&lAdvertising");
                setItem(10, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(19, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(28, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(37, severity3.build());
            }

            // General Toxicity
            {
                ItemBuilder label = new ItemBuilder(Material.SPIDER_EYE).setDisplayName("&a&lGeneral Toxicity");
                setItem(12, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(21, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(30, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(39, severity3.build());
            }

            // Spam
            {
                ItemBuilder label = new ItemBuilder(Material.PAPER).setDisplayName("&a&lSpam");
                setItem(14, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(23, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(32, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(41, severity3.build());
            }

            // Trolling
            {
                ItemBuilder label = new ItemBuilder(Material.RED_MUSHROOM).setDisplayName("&a&lTrolling");
                setItem(16, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(25, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(34, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(43, severity3.build());
            }
        }
    }

    private class PunishServerGUI extends CustomGUI {
        public PunishServerGUI(String target) {
            super(54, "Punish - " + target);

            // Loads the filler items.
            int[] fillers = {1,2,3,4,5,6,7,8,45,46,47,48,49,50,51,52,53};
            ItemBuilder builder = new ItemBuilder(XMaterial.GRAY_STAINED_GLASS_PANE.parseItem())
                    .setDisplayName(" ");
            for(int i : fillers) {
                setItem(i, builder.build());
            }

            // Loads the back item.
            ItemBuilder backButton = new ItemBuilder(SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0="))
                    .setDisplayName("&cBack");
            setItem(0, backButton.build(), (p,a) -> new PunishMainGUI(target).open(p));

            // Advertising
            {
                ItemBuilder label = new ItemBuilder(Material.EMERALD).setDisplayName("&a&lBoosting");
                setItem(10, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(19, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(28, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(37, severity3.build());
            }

            // General Toxicity
            {
                ItemBuilder label = new ItemBuilder(Material.BARRIER).setDisplayName("&a&lBug Abuse");
                setItem(12, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(21, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(30, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(39, severity3.build());
            }

            // Spam
            {
                ItemBuilder label = new ItemBuilder(Material.IRON_SWORD).setDisplayName("&a&lCross Teaming");
                setItem(14, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(23, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(32, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(41, severity3.build());
            }

            // Trolling
            {
                ItemBuilder label = new ItemBuilder(XMaterial.IRON_BARS.parseMaterial()).setDisplayName("&a&lReport Abuse");
                setItem(16, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(25, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(34, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(43, severity3.build());
            }
        }
    }

    private class PunishClientGUI extends CustomGUI {
        public PunishClientGUI(String target) {
            super(54, "Punish - " + target);

            // Loads the filler items.
            int[] fillers = {1,2,3,4,5,6,7,8,45,46,47,48,49,50,51,52,53};
            ItemBuilder builder = new ItemBuilder(XMaterial.GRAY_STAINED_GLASS_PANE.parseItem())
                    .setDisplayName(" ");
            for(int i : fillers) {
                setItem(i, builder.build());
            }

            // Loads the back item.
            ItemBuilder backButton = new ItemBuilder(SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0="))
                    .setDisplayName("&cBack");
            setItem(0, backButton.build(), (p,a) -> new PunishMainGUI(target).open(p));

            // Advertising
            {
                ItemBuilder label = new ItemBuilder(Material.SLIME_BALL)
                        .setDisplayName("&a&lCheating")
                        .addLore("&fThe use of hacked clients or other modifications to gain an unfair advantage.", 30);
                setItem(10, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem())
                        .setDisplayName("&a&lSeverity 1")
                        .addLore("&71 month ban")
                        .addLore("")
                        .addLore("&cFirst Offense");
                setItem(19, severity1.build(), (p,a) -> {
                    p.chat("/tempban " + target + " 1mo Use of Blacklisted Modifications");
                });

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem())
                        .setDisplayName("&e&lSeverity 2")
                        .addLore("&72 month ban")
                        .addLore("")
                        .addLore("&cSecond Offense");
                setItem(28, severity2.build(), (p,a) -> {
                    p.chat("/tempban " + target + " 2mo Use of Blacklisted Modifications");
                });

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem())
                        .setDisplayName("&c&lSeverity 3")
                        .addLore("&73 month ban")
                        .addLore("")
                        .addLore("&cThird Offense");
                setItem(37, severity3.build(), (p,a) -> {
                    p.chat("/tempban " + target + " 3mo Use of Blacklisted Modifications");
                });
            }

            // General Toxicity
            {
                ItemBuilder label = new ItemBuilder(XMaterial.WHITE_BANNER.parseMaterial()).setDisplayName("&a&lInappropriate Cape");
                setItem(12, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(21, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(30, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(39, severity3.build());
            }

            // Spam
            {
                ItemBuilder label = new ItemBuilder(Material.NAME_TAG).setDisplayName("&a&lInappropriate Name");
                setItem(14, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(23, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(32, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(41, severity3.build());
            }

            // Trolling
            {
                ItemBuilder label = new ItemBuilder(XMaterial.PLAYER_HEAD.parseMaterial()).setDisplayName("&a&lInappropriate Skin");
                setItem(16, label.build());

                ItemBuilder severity1 = new ItemBuilder(XMaterial.GREEN_STAINED_GLASS_PANE.parseItem()).setDisplayName("&a&lSeverity 1");
                setItem(25, severity1.build());

                ItemBuilder severity2 = new ItemBuilder(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem()).setDisplayName("&e&lSeverity 2");
                setItem(34, severity2.build());

                ItemBuilder severity3 = new ItemBuilder(XMaterial.RED_STAINED_GLASS_PANE.parseItem()).setDisplayName("&c&lSeverity 3");
                setItem(43, severity3.build());
            }
        }
    }
}
