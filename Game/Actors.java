package Game;

import java.util.*;

/**
 * 
 */
public interface Actors {






    /**
     * @return
     */
    public int getMovableActorCount();

    /**
     * @param i
     * @return
     */
    public MovableActor getMovableActor(int i);

    /**
     * @param ma
     */
    public void addMovableActor(MovableActor ma);

    /**
     * @param ma
     */
    public void delMovableActor(MovableActor ma);

    /**
     * @return
     */
    public int getStaticActorCount();

    /**
     * @param i
     * @return
     */
    public StaticActor getStaticActor(int i);

    /**
     * @param sa
     */
    public void addStaticActor(StaticActor sa);

    /**
     * @param sa
     */
    public void delStaticActor(StaticActor sa);

}