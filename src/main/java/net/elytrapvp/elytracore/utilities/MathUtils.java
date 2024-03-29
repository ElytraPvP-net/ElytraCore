package net.elytrapvp.elytracore.utilities;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class MathUtils {
    public static int percent(double currentValue, double maxValue){
        double percent = (currentValue/maxValue) *100;
        return (int) percent;
    }

    public static Vector rotateVector(Vector vector, double whatAngle) {
        double sin = Math.sin(whatAngle);
        double cos = Math.cos(whatAngle);
        double x = vector.getX() * cos + vector.getZ() * sin;
        double z = vector.getX() * -sin + vector.getZ() * cos;

        return vector.setX(x).setZ(z);
    }

    public static double distance(Location a, Location b){
        return Math.sqrt(square(a.getX() - b.getX()) + square(a.getY() - b.getY()) + square(a.getZ() - b.getZ()));
    }

    private static double square(double x){
        return x * x;
    }
}