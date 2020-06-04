package net.elytrapvp.elytracore.utils;

import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder
{
    private ItemStack item;
    private ItemMeta meta;

    /**
     * Create a new ItemStack with Material m
     * @param m Material for the ItemStack
     */
    public ItemBuilder(Material m)
    {
        this(m, 1);
    }

    /**
     * Create a new ItemStack of i items with material m
     * @param m Material for the ItemStack
     * @param i Number of items in the ItemStack
     */
    public ItemBuilder(Material m, int i)
    {
        this(new ItemStack(m, i));
    }

    /**
     * Start a builder with an existing ItemStack
     * @param item ItemStack
     */
    public ItemBuilder(ItemStack item)
    {
        this.item = item;
        meta = item.getItemMeta();
    }

    /**
     * Add lore to the item.
     * @param str String
     */
    public void addLore(String str)
    {
        List<String> lore = meta.getLore();
        lore.add(Message.translate(str));
        meta.setLore(lore);
    }

    /**
     * Get the ItemStack from the builder.
     * @return ItemStack
     */
    public ItemStack build()
    {
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Set the display name of the item.
     * @param str Display name
     */
    public void setDisplayName(String str)
    {
        meta.setDisplayName(Message.translate(str));
    }

    /**
     * Set the lore of an item.
     * @param lore
     */
    public void setLore(String... lore)
    {
        meta.setLore(Arrays.asList(lore));
    }

    /**
     * Set the item to be unbreakable.
     */
    public void setUnbreakable()
    {
        meta.setUnbreakable(true);
    }

}