package net.elytrapvp.elytracore.regions;

import org.bukkit.Location;
import org.bukkit.World;

/**
 * Represents an area between 2 locations.
 * @author partykid4
 * @version 1.0
 * @since 0.2
 */
public class Region
{
    private final World world;
    private int maxX;
    private int maxY;
    private int maxZ;
    private int minX;
    private int minY;
    private int minZ;
    private String name;

    /**
     * Create a new Region
     * @param loc1 Location 1
     * @param loc2 Location 2
     */
    public Region(Location loc1, Location loc2)
    {
        this(loc1.getWorld(), loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ(), loc2.getBlockX(), loc2.getBlockY(), loc2.getBlockZ());
    }

    /**
     * Create a new Region
     * @param world World
     * @param x1 X-Coordinate 1
     * @param y1 Y-Coordinate 1
     * @param z1 Z-Coordinate 1
     * @param x2 X-Coordinate 2
     * @param y2 Y-Coordinate 2
     * @param z2 Z-Coordinate 2
     */
    public Region(World world, int x1, int y1, int z1, int x2, int y2, int z2)
    {
        this.world = world;

        maxX = Math.max(x1, x2);
        maxY = Math.max(y1, y2);
        maxZ = Math.max(z1, z2);
        minX = Math.min(x1, x2);
        minY = Math.min(y1, y2);
        minZ = Math.min(z1, z2);

        name = "";
    }

    /**
     * Get the world the region is in.
     * @return World
     */
    public World getWorld()
    {
        return world;
    }

    /**
     * Get the Maximum X Coordinate in the Region
     * @return Max X
     */
    public int getMaxX()
    {
        return maxX;
    }

    /**
     * Get the Maximum Y Coordinate in the Region
     * @return Max Y
     */
    public int getMaxY()
    {
        return maxY;
    }

    /**
     * Get the Maximum Z Coordinate in the Region
     * @return Max Z
     */
    public int getMaxZ()
    {
        return maxZ;
    }

    /**
     * Get the Minimum X Coordinate in the Region
     * @return Min X
     */
    public int getMinX()
    {
        return minX;
    }

    /**
     * Get the Minimum Y Coordinate in the Region
     * @return Min Y
     */
    public int getMinY()
    {
        return minY;
    }

    /**
     * Get the Minimum Z Coordinate in the Region
     * @return
     */
    public int getMinZ()
    {
        return minZ;
    }

    /**
     * Get the name of the Region.
     * @return Region's Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Check if the region contains another region.
     * @param region Region to be checked
     * @return Whether the region contains the region to be checked.
     */
    public boolean contains(Region region)
    {
        return region.getWorld().equals(world) &&
                region.getMinX() >= minX && region.getMaxX() <= maxX &&
                region.getMinY() >= minY && region.getMaxY() <= maxY &&
                region.getMinZ() >= minZ && region.getMaxZ() <= maxZ;
    }

    /**
     * Check if the region contains a location.
     * @param location Location to be checked.
     * @return Whether the region contains the location.
     */
    public boolean contains(Location location)
    {
        return contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Check if the region contrains a coordinate.
     * @param x X Coordinate to be checked.
     * @param y Y Coordinate to be checked.
     * @param z Z Coordinate to be checked.
     * @return Whether or not the region contains this coordinate.
     */
    public boolean contains(int x, int y, int z)
    {
        return x >= minX && x <= maxX &&
                y >= minY && y <= maxY &&
                z >= minZ && z <= maxZ;
    }

    /**
     * Set the name of the region.
     * @param name Name to be set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
