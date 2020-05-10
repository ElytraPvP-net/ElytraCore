package net.elytrapvp.elytracore.utils;

public class NumUtils
{

    /**
     * Check if a number is between two others.
     * @param num Number the check.
     * @param one First number.
     * @param two Second number.
     * @return Whether or not num is between one and two.
     */
    public static boolean between(int num, int one, int two)
    {
        if((num > one && num < 2) || (num < one && num > two))
        {
            return true;
        }

        return false;
    }

}
