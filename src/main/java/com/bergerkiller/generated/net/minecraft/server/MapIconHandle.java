package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;

public class MapIconHandle extends Template.Handle {
    public static final MapIconClass T = new MapIconClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(MapIconHandle.class, "net.minecraft.server.MapIcon");


    /* ============================================================================== */

    public static MapIconHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        MapIconHandle handle = new MapIconHandle();
        handle.instance = handleInstance;
        return handle;
    }

    public static final MapIconHandle createNew(TypeHandle type, byte x, byte y, byte direction) {
        return T.constr_type_x_y_direction.newInstance(type, x, y, direction);
    }

    /* ============================================================================== */

    public byte getTypeId() {
        return T.getTypeId.invoke(instance);
    }

    public byte getX() {
        return T.getX.invoke(instance);
    }

    public byte getY() {
        return T.getY.invoke(instance);
    }

    public byte getDirection() {
        return T.getDirection.invoke(instance);
    }

    public static final class MapIconClass extends Template.Class<MapIconHandle> {
        public final Template.Constructor.Converted<MapIconHandle> constr_type_x_y_direction = new Template.Constructor.Converted<MapIconHandle>();

        public final Template.Method<Byte> getTypeId = new Template.Method<Byte>();
        public final Template.Method<Byte> getX = new Template.Method<Byte>();
        public final Template.Method<Byte> getY = new Template.Method<Byte>();
        public final Template.Method<Byte> getDirection = new Template.Method<Byte>();

    }

    public static class TypeHandle extends Template.Handle {
        public static final TypeClass T = new TypeClass();
        static final StaticInitHelper _init_helper = new StaticInitHelper(TypeHandle.class, "net.minecraft.server.MapIcon.Type");


        /* ============================================================================== */

        public static TypeHandle createHandle(Object handleInstance) {
            if (handleInstance == null) return null;
            TypeHandle handle = new TypeHandle();
            handle.instance = handleInstance;
            return handle;
        }

        /* ============================================================================== */

        public static TypeHandle fromId(byte id) {
            return T.fromId.invokeVA(id);
        }

        public static final class TypeClass extends Template.Class<TypeHandle> {
            public final Template.StaticMethod.Converted<TypeHandle> fromId = new Template.StaticMethod.Converted<TypeHandle>();

        }
    }
}
