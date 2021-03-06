package com.bergerkiller.generated.org.bukkit.craftbukkit.block;

import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import org.bukkit.Chunk;
import org.bukkit.block.Block;

public class CraftBlockHandle extends Template.Handle {
    public static final CraftBlockClass T = new CraftBlockClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(CraftBlockHandle.class, "org.bukkit.craftbukkit.block.CraftBlock");


    /* ============================================================================== */

    public static CraftBlockHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        CraftBlockHandle handle = new CraftBlockHandle();
        handle.instance = handleInstance;
        return handle;
    }

    public static final Block createNew(Chunk chunk, int x, int y, int z) {
        return T.constr_chunk_x_y_z.newInstance(chunk, x, y, z);
    }

    /* ============================================================================== */

    public static final class CraftBlockClass extends Template.Class<CraftBlockHandle> {
        public final Template.Constructor.Converted<Block> constr_chunk_x_y_z = new Template.Constructor.Converted<Block>();

    }
}
