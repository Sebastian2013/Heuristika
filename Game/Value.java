package Game;

import java.util.*;

/**
 * 
 */
public class Value {

    /**
     *
     */
    public final ValueType valueType;

    /**
     *
     */
    private byte valueCount;


    /**
     * Konstruktor erzeugt einen  Value mit dem gegebnen ValueType
     * @param valueType
     */
    public Value(ValueType valueType) {
        this(valueType,(byte)0);
    }

    /**
     * Kopierkonstruktor
     * @param v
     */
    public Value(Value v) {
        this(v.valueType,v.getValueCount());
    }


    /**
     * Hauptkonstruktor
     * @param valueType
     * @param count
     */
    public Value(ValueType valueType, byte count) {
        this.valueType=valueType;
        valueCount=count;
    }



    /**
     * @return
     */
    public byte getValueCount() {
        return valueCount;
    }

    /**
     * @param b setzt auf neue Anzahl
     * @return  gibt die alte Anzahl
     */
    public byte setValueCount(byte b) {
        byte old=valueCount;
        valueCount=b;
        return old;
    }

    /**
     * @param b
     * @return
     */
    public byte mergeValueCount(byte b) {
        int temp=valueCount+b;
        if(temp>Byte.MAX_VALUE){
            valueCount=Byte.MAX_VALUE;
        }else{
            valueCount=(byte)temp;
        }
        return valueCount;
    }

}