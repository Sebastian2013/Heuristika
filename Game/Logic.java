package Game;

import java.util.*;

/**
 * 
 */
public interface Logic {





    /**
     * @param w
     * @return
     */
    public World simWorld(World w);

    /**
     * @param w
     * @param a
     * @return
     */
    public Actors simActors(World w, Actors a);

    /**
     * @param w
     * @param a
     * @return
     */
    public Actors simStaticActors(World w, Actors a);

    /**
     * @param w
     * @param a
     * @return
     */
    public Actors simMovableActors(World w, Actors a);

}