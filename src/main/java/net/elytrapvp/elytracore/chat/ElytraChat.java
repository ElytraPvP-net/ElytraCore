package net.elytrapvp.elytracore.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ElytraChat
{
    private final static int CENTER_PX = 154;

    /**
     * Send a centered chat message to a player.
     * @param player Player to be sent to.
     * @param message message to be sent.
     */
    public static void centeredChat(Player player, String message)
    {
        message = Message.translate(message);

        if(message == null || message.equals("")) player.sendMessage("");
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for(char c : message.toCharArray())
        {
            if(c == '§')
            {
                previousCode = true;
                continue;
            }
            else if(previousCode == true)
            {
                previousCode = false;
                if(c == 'l' || c == 'L')
                {
                    isBold = true;
                    continue;
                }
                else isBold = false;
            }
            else
            {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while(compensated < toCompensate)
        {
            sb.append(" ");
            compensated += spaceLength;
        }
        player.sendMessage(sb.toString() + message);
    }

    /**
     * Sender a centered chat message to a CommandSender.
     * @param sender Command Sender to be sent to.
     * @param message Message to be sent
     */
    public static void centeredChat(CommandSender sender, String message)
    {
        message = Message.translate(message);

        if(message == null || message.equals("")) sender.sendMessage("");
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for(char c : message.toCharArray())
        {
            if(c == '§')
            {
                previousCode = true;
                continue;
            }
            else if(previousCode == true)
            {
                previousCode = false;
                if(c == 'l' || c == 'L')
                {
                    isBold = true;
                    continue;
                }
                else isBold = false;
            }
            else
            {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while(compensated < toCompensate)
        {
            sb.append(" ");
            compensated += spaceLength;
        }
        sender.sendMessage(sb.toString() + message);
    }

    /**
     * Send a formatted message to a CommandSender
     * @param sender CommandSender to be sent to.
     * @param message message to be sent.
     */
    public static void sendMessage(CommandSender sender, String message)
    {
        sender.sendMessage(Message.translate(message));
    }

    /**
     * Send a formatted message to a Player
     * @param player Player to be sent to.
     * @param message message to be sent.
     */
    public static void sendMessage(Player player, String message)
    {
        player.sendMessage(Message.translate(message));
    }
}