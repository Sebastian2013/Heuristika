package Game.Implementations;

import Game.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Sebastian on 04.09.2015.
 */
public class Bushmen implements MovableActor {
    private float posX, posY;
    private float speed;
    private Map<ValueType,Value> valueMap;
    int food;

    public Bushmen(float startX,float startY){
        posX=startX;
        posY=startY;
        speed=0.7f;
        valueMap =new HashMap<ValueType, Value>();
        food=42;
    }

    /**
     * Bushmen like bushes & Water
     * @param c
     * @return
     */
    @Override
    public int rate(Cell c) {
        int bushes=c.getValue(new Value(ValueType.bush)).getValueCount();
        int water=c.getValue(new Value(ValueType.water)).getValueCount();
        return bushes*10+water;
    }

    @Override
    public Cell addMarkToCell(Cell c) {
        return c;
    }

    @Override
    public MovableActor setPos(Vector<Float> v) {
        posX=v.elementAt(0);
        posY=v.elementAt(1);
        return this;
    }

    @Override
    public int rate(Actor a) {
        return 0;
    }

    /**
     * Bushmen divide into two
     * @return
     */
    @Override
    public MovableActor reproduce() {
        return new Bushmen(posX,posY);
    }

    @Override
    public float getMaxSpeed() {
        return speed;
    }

    @Override
    public World live(World w) {
        return w;
    }

    @Override
    public Vector<Float> getPos() {
        Vector<Float> pos=new Vector<Float>(2);
        pos.add(0,posX);
        pos.add(1,posY);
        return pos;
    }

    /**
     * Bushmen eat Bushes
     * @param c
     * @return reduced Cell
     */
    @Override
    public Cell consume(Cell c) {
        byte bushes=c.getValue(new Value(ValueType.bush)).getValueCount();
        food=food+bushes;

        Cell tempC=c.getEmptyCell().merge(c);
        tempC.mergeValue(new Value(ValueType.bush,(byte)-bushes));

        return tempC;
    }

    /**
     * Bushmen only pooo
     * @param c
     * @return
     */
    @Override
    public Cell produce(Cell c) {
        Cell tempC=c.getEmptyCell().merge(c);
        tempC.mergeValue(new Value(ValueType.dung,(byte) 1));
        return tempC;
    }
}
