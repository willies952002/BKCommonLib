package com.bergerkiller.bukkit.common.wrappers;

import com.bergerkiller.bukkit.common.conversion.Conversion;
import com.bergerkiller.bukkit.common.internal.CommonDisabledEntity;
import com.bergerkiller.reflection.net.minecraft.server.NMSDataWatcher;
import com.bergerkiller.reflection.net.minecraft.server.NMSDataWatcherObject;

import java.util.List;

/**
 * This class is a wrapper of the DataWatcher class from CraftBukkit<br>
 * It is used to store data and to keep track of changes so they can be
 * synchronized
 */
public class DataWatcher extends BasicWrapper {

    public DataWatcher(org.bukkit.entity.Entity entityOwner) {
        this(NMSDataWatcher.constructor1.newInstance(Conversion.toEntityHandle.convert(entityOwner)));
    }

    /**
     * Initializes a new Empty DataWatcher. Please avoid binding this
     * constructed DataWatcher to live entities. When doing so, instead use the
     * Entity-accepting constructor.
     */
    public DataWatcher() {
        this(NMSDataWatcher.constructor1.newInstance(CommonDisabledEntity.INSTANCE));
    }

    public DataWatcher(Object handle) {
        setHandle(handle);
    }

    /**
     * Write a new value to the watched objects
     *
     * @param index Object index
     * @param value Value
     */
    public void set(int index, Object value) {
        NMSDataWatcher.write.invoke(handle, index, value);
    }

    /**
     * Read an object from the watched objects and convert it
     *
     * @param index Object index
     * @param def value when conversion fails (can not be null)
     * @return Object
     */
    public <T> T get(int index, T def) {
        return Conversion.convert(get(index), def);
    }

    /**
     * Read an object from the watched objects and convert it
     *
     * @param index Object index
     * @param type Object type
     * @param def value when conversion fails
     * @return Object
     */
    public <T> T get(int index, Class<T> type, T def) {
        return Conversion.convert(get(index), type, def);
    }

    /**
     * Read an object from the watched objects and convert it
     *
     * @param index Object index
     * @param type Object type
     * @return Object
     */
    public <T> T get(int index, Class<T> type) {
        return Conversion.convert(get(index), type);
    }

    /**
     * Read an object from the watched objects
     *
     * @param index Object index
     * @return Object
     */
    public Object get(int index) {
        Object watchable = NMSDataWatcher.read.invoke(handle, index);
        return NMSDataWatcherObject.getHandle.invoke(watchable);
    }

    /**
     * Watch an object
     *
     * @param index Object index
     * @param value Value
     */
    public void watch(int index, Object value) {
        NMSDataWatcher.watch.invoke(handle, index, value);
    }

    /**
     * Get all watched objects
     *
     * @return Watched objects
     */
    public List<Object> getAllWatched() {
        return NMSDataWatcher.returnAllWatched.invoke(handle);
    }

    /**
     * Get all watched objects and unwatch them
     *
     * @return Watched objects
     */
    public List<Object> unwatchAndGetAllWatched() {
        return NMSDataWatcher.unwatchAndReturnAllWatched.invoke(handle);
    }

    /**
     * Gets whether this Data Watcher has changed since the last tick
     *
     * @return True if it had changed, False if not
     */
    public boolean isChanged() {
        return NMSDataWatcher.isChanged.invoke(handle);
    }

    /**
     * Gets whether this Data Watcher is empty or not. An empty Data Watcher
     * does not require any update messages to the players.
     *
     * @return True if empty, False if not
     */
    public boolean isEmpty() {
        return NMSDataWatcher.isEmpty.invoke(handle);
    }
}
