package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.objects.StaffModePlayer;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffModeCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public StaffModeCMD() {
        super("staffmode", "staffmode", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        if(StaffModePlayer.getPlayers().containsKey(p.getUniqueId())) {
            StaffModePlayer s = StaffModePlayer.getPlayers().get(p.getUniqueId());
            s.delete();

            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are no longer in staff mode.");
        }
        else {
            new StaffModePlayer(p.getUniqueId());
            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are now in staff mode.");

            p.getInventory().clear();
        }
    }
}