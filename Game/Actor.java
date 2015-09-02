package Game;

import java.util.*;

/**
 * 
 */
public interface Actor {


    /**
     * @return
     */
    public Vector<Float> getPos();

    /**
     * @param c
     * @return
     */
    public Cell consume(Cell c);

    /**
     * @param c
     * @return
     */
    public Cell produce(Cell c);

}