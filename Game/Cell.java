package Game;

import java.util.*;

/**
 * 
 */
public interface Cell {



    /**
     * @param c
     * @return
     */
    public Cell merge(Cell c);

    /**
     * @return
     */
    public Cell getEmptyCell();

    /**
     * @param v
     * @return
     */
    public Value getValue(Value v);

    /**
     * @param v
     * @return
     */
    public Value setValue(Value v);

    /**
     * @param v
     * @return
     */
    public Value mergeValue(Value v);

}