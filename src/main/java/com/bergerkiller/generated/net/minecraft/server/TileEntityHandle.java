package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;

public class TileEntityHandle extends Template.Handle {
    public static final TileEntityClass T = new TileEntityClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(TileEntityHandle.class, "net.minecraft.server.TileEntity");


    /* ============================================================================== */

    public static TileEntityHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        TileEntityHandle handle = new TileEntityHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public WorldHandle getWorld() {
        return T.getWorld.invoke(instance);
    }

    public BlockPositionHandle getPosition() {
        return T.getPosition.invoke(instance);
    }

    public static final class TileEntityClass extends Template.Class<TileEntityHandle> {
        public final Template.Method.Converted<WorldHandle> getWorld = new Template.Method.Converted<WorldHandle>();
        public final Template.Method.Converted<BlockPositionHandle> getPosition = new Template.Method.Converted<BlockPositionHandle>();

    }
}
