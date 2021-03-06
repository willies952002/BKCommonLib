package com.bergerkiller.bukkit.common.entity.type;

import com.bergerkiller.bukkit.common.wrappers.DataWatcher;
import com.bergerkiller.reflection.net.minecraft.server.NMSEntityMinecart;

import org.bukkit.Material;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * A Common Entity implementation for Minecarts with a Furnace
 */
public class CommonMinecartFurnace extends CommonMinecart<PoweredMinecart> {

    /**
     * The amount of fuel ticks a single item of coal gives to a furnace
     * minecart
     */
    public static final int COAL_FUEL = 3600;

    public final DataWatcher.EntityItem<Boolean> metaSmoking = getDataItem(NMSEntityMinecart.Furnace.DATA_SMOKING);

    public CommonMinecartFurnace(PoweredMinecart base) {
        super(base);
    }

    public int getFuelTicks() {
        return NMSEntityMinecart.Furnace.fuel.get(getHandle());
    }

    public void setFuelTicks(int fuelTicks) {
    	NMSEntityMinecart.Furnace.fuel.set(getHandle(), fuelTicks);
    }

    public boolean hasFuel() {
        return getFuelTicks() > 0;
    }

    public void addFuelTicks(int amount) {
        setFuelTicks(getFuelTicks() + amount);
    }

    public double getPushX() {
        return NMSEntityMinecart.Furnace.pushForceX.get(getHandle());
    }

    public void setPushX(double pushX) {
    	NMSEntityMinecart.Furnace.pushForceX.set(getHandle(), pushX);
    }

    public double getPushZ() {
        return NMSEntityMinecart.Furnace.pushForceZ.get(getHandle());
    }

    public void setPushZ(double pushZ) {
    	NMSEntityMinecart.Furnace.pushForceZ.set(getHandle(), pushZ);
    }

    public boolean isSmoking() {
        return metaSmoking.get();
    }

    public void setSmoking(boolean smoking) {
        metaSmoking.set(smoking);
    }

    @Override
    public List<ItemStack> getBrokenDrops() {
        return Arrays.asList(new ItemStack(Material.MINECART, 1), new ItemStack(Material.FURNACE, 1));
    }

    @Override
    public Material getCombinedItem() {
        return Material.POWERED_MINECART;
    }
}
