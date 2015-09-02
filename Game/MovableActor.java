package Game;

import java.util.*;

/**
 * 
 */
public interface MovableActor extends Actor {

    /**
     * @param c
     * @return
     */
    public short rate(Cell c);

    /**
     * @param c
     * @return
     */
    public Cell addMarkToCell(Cell c);

    /**
     * @param v
     * @return
     */
    public MovableActor setPos(Vector v );

    /**
     * @param a
     * @return
     */
    public short rate(Actor a);

    /**
     * @return
     */
    public MovableActor reproduce();

    /**
     * @return
     */
    public float getMaxSpeed();

    /**
     * @param w
     * @return
     */
    public World live(World w);

}