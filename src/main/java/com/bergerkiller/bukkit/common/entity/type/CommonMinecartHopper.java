package com.bergerkiller.bukkit.common.entity.type;

import com.bergerkiller.generated.net.minecraft.server.TileEntityHopperHandle;
import com.bergerkiller.reflection.net.minecraft.server.NMSEntityMinecart;

import org.bukkit.Material;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * A Common Entity implementation for Minecarts with a Hopper
 */
public class CommonMinecartHopper extends CommonMinecartInventory<HopperMinecart> {

    public CommonMinecartHopper(HopperMinecart base) {
        super(base);
    }

    @Override
    public List<ItemStack> getBrokenDrops() {
        return Arrays.asList(new ItemStack(Material.MINECART, 1), new ItemStack(Material.HOPPER, 1));
    }

    @Override
    public Material getCombinedItem() {
        return Material.HOPPER_MINECART;
    }

    /**
     * Sucks all nearby Items into this Hopper Minecart
     *
     * @return True if Items were sucked in, False if not
     */
    public boolean suckItems() {
        return TileEntityHopperHandle.suckItems(handle.getRaw());
    }

    /**
     * Gets whether this Hopper Minecart is currently sucking in nearby Items
     *
     * @return True if sucking items, False if not
     */
    public boolean isSuckingItems() {
    	//TODO: BROKEN!!!!
    	return false;
        //return getHandle(EntityMinecartHopper.class).C();
    }

    /**
     * Sets whether this Hopper Minecart is currently sucking in nearby Items
     *
     * @param sucking state to set to
     */
    public void setSuckingItems(boolean sucking) {
    	//TODO: BROKEN!!!!
    	return;
        //getHandle(EntityMinecartHopper.class).f(sucking);
    }

    /**
     * Sets the remaining ticks until the next Item sucking operation occurs
     *
     * @param cooldownTicks to set to
     */
    public void setSuckingCooldown(int cooldownTicks) {
        NMSEntityMinecart.Hopper.suckingCooldown.set(getHandle(), cooldownTicks);
    }

    /**
     * Gets the remaining ticks until the next Item sucking operation occurs
     *
     * @return sucking cooldown ticks
     */
    public int getSuckingCooldown() {
        return NMSEntityMinecart.Hopper.suckingCooldown.get(getHandle());
    }

}
