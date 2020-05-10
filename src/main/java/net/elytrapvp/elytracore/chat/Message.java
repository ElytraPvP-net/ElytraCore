package net.elytrapvp.elytracore.chat;

import org.bukkit.ChatColor;

public class Message
{
    /**
     * Get the divider message.
     * @return Divider message.
     */
    public static String divder()
    {
        return translate("&2&l]&8&m---------------------------------------------------&2&l[");
    }

    /**
     * Get the "No Permission" message.
     * @return "No Permission" message.
     */
    public static String noPermission()
    {
        return translate("&2&lError &8- &cYou do not have permission to do that.");
    }

    /**
     * Get the "Not A Player" Message
     * @return "Not A Player Message"
     */
    public static String notAPlayer()
    {
        return translate("&2&lError &8- &cOnly a player can do that!");
    }

    /**
     * Get the usage message
     * @param usage  Usage
     * @return Usage message
     */
    public static String usage(String usage)
    {
        return translate("&2&lUsage &8- &c" + usage);
    }

    /**
     * Translate color codes into colors.
     * @param message Message to translate.
     * @return Translated message.
     */
    public static String translate(String message)
    {
        String str = ChatColor.translateAlternateColorCodes('&', message);
        return str;
    }

}