package Game;

import java.util.*;

/**
 * 
 */
public interface Cell {


    /**
     * Mutierend - ergänzt die aufgerufene Cell mit denen der übergebenen
     * @param c
     * @return this
     */
    public Cell merge(Cell c);

    /**
     * @return
     */
    public Cell getEmptyCell();

    /**
     * @param v
     * @return gibts das passende Value
     */
    public Value getValue(Value v);

    /**
     * @param v
     * @return
     */
    public Value setValue(Value v);

    /**
     * Mutierend - ergänzt den Value der Cell mit dem der übergebenen
     * @param v
     * @return neuer value
     */
    public Value mergeValue(Value v);

    /**
     *
     * @return
     */
    public Set<ValueType> getValueTypes();
}