package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * This class runs the invisible command, which allows a player to toggle invisibility.
 */
public class InvisibleCMD extends AbstractCommand {

    /**
     * Creates the /invisible command with the permission "elytracore.invisible".
     */
    public InvisibleCMD() {
        super("invisible", "elytracore.invisible", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            ChatUtils.chat(player, "&aYou are no longer invisible.");
        }
        else {
            PotionEffect invisible = new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0);
            player.addPotionEffect(invisible);
            ChatUtils.chat(player, "&aYou are now invisible.");
        }
    }
}