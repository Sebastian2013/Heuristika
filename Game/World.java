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
     * @param x
     * @param y
     * @return
     */
    public Cell getCell(int x, int y);

    /**
     * @param x
     * @param y
     * @param c
     * @return
     */
    public Cell setCell(int x, int y, Cell c);

    /**
     * @return
     */
    public World getEmptyWorld();

    /**
     * @param v
     * @param x
     * @param y
     * @return
     */
    public Value getValue(int x, int y, Value v);

    /**
     * @param v
     * @param x
     * @param y
     * @return
     */
    public Value setValue(int x, int y, Value v);

}