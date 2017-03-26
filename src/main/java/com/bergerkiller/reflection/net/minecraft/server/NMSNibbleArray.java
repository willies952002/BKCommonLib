package com.bergerkiller.reflection.net.minecraft.server;

import com.bergerkiller.reflection.ClassTemplate;
import com.bergerkiller.reflection.FieldAccessor;

public class NMSNibbleArray {
    public static final ClassTemplate<?> T = ClassTemplate.createNMS("NibbleArray");
    public static final FieldAccessor<byte[]> array = T.selectField("private final byte[] a");

    /**
     * Copies all data contained in the Nibble Array to the byte array specified
     *
     * @param nibbleArray to get the data from
     * @param destArray to copy to
     * @param offset in the array to copy at
     * @return The offset added to the size of the Nibble Array
     */
    public static int copyTo(Object nibbleArray, byte[] destArray, int offset) {
        byte[] data = array.get(nibbleArray);
        System.arraycopy(data, 0, destArray, offset, data.length);
        return data.length + offset;
    }

    /**
     * Obtains a new byte array of the contents of the nibble array
     *
     * @param nibbleArray to get te copied array from
     * @return copied, unreferenced array
     */
    public static byte[] getArrayCopy(Object nibbleArray) {
    	byte[] data = array.get(nibbleArray);
        byte[] rval = new byte[data.length];
        copyTo(nibbleArray, rval, 0);
        return rval;
    }

    /**
     * Obtains a reference to the byte[] contents of a Nibble Array. These
     * contents are unsafe for modification, do not change elements of it!
     *
     * @param nibbleArray to get the referenced byte array contents of
     * @return value array
     */
    public static byte[] getValueArray(Object nibbleArray) {
        return array.get(nibbleArray);
    }
}
