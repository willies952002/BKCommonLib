package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;

public class Handle extends Template.Handle {
    public static final Class T = new Class();
    static final StaticInitHelper _init_helper = new StaticInitHelper(Handle.class, "");


    /* ============================================================================== */

    public static Handle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        Handle handle = new Handle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public static final class Class extends Template.Class<Handle> {
    }
}
