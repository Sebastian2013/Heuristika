package Game;

import java.util.*;

/**
 * 
 */
public interface World {





    /**
     * @return
     */
    public int getDimensionX();

    /**
     * @return
     */
    public int getDimensionY();

    /**
     * @return
     */
    public int getDimensionZ();

    /**
     * @param x
     * @param y
     * @param z
     * @return
     */
    public Cell getCell(int x, int y, int z);

    /**
     * @param x
     * @param y
     * @param z
     * @param c
     * @return
     */
    public Cell setCell(int x, int y, int z, Cell c);

    /**
     * @return
     */
    public World getEmptyWorld();

    /**
     * @param vt
     * @param x
     * @param y
     * @param z
     * @return
     */
    public byte getValue(ValueType vt, int x, int y, int z);

    /**
     * @param vt
     * @param x
     * @param y
     * @param z
     * @param value
     * @return
     */
    public byte setValue(ValueType vt, int x, int y, int z, byte value);

}