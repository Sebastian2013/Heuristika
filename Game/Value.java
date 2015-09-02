package Game;

import java.util.*;

/**
 * 
 */
public class Value {
    /**
     * @param vt
     * @return
     */
    public static Value  valueFactory(ValueType vt) {
        return null;
    }

    /**
     *
     */
    public final ValueType valueType;


    /**
     * 
     */
    public Value(ValueType valueType) {
        this.valueType=valueType;
    }



    /**
     * 
     */
    private byte valueCount;




    /**
     * @param vt
     */
    private void Value(ValueType vt) {
        // TODO implement here
    }

    /**
     * @return
     */
    public byte getValueCount() {
        // TODO implement here
        return 0;
    }

    /**
     * @param b
     * @return
     */
    public byte setValueCount(byte b) {
        // TODO implement here
        return 0;
    }

    /**
     * @param b
     * @return
     */
    public byte mergeValueCount(byte b) {
        // TODO implement here
        return 0;
    }

}