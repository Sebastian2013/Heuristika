package Game.Implementations;


import Game.Cell;
import Game.Value;
import Game.ValueType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class CellImpl1 implements Cell{

    private Map<ValueType,Value> valueMap;

    public CellImpl1(){
        valueMap =new HashMap<ValueType, Value>();
    }

    @Override
    public Cell merge(Cell c) {
        Value tempV;
        //merge own Cell to other cell
        for(ValueType vt:c.getValueTypes()){
            tempV=c.getValue(new Value(vt));
            mergeValue(tempV);
        }
        return this;
    }
    /*
    /* nicht mutierend wie PLUS
    @Override
    public Cell merge(Cell c) {
        CellImpl1 newCell=new CellImpl1();
        Value tempV;

        //merge own Cell to new cell
        for(ValueType vt:getValueTypes()){
            tempV=getValue(new Value(vt));
            newCell.mergeValue(tempV);
        }

        //merge other cell to new cell
        for(ValueType vt:c.getValueTypes()){
            tempV=c.getValue(new Value(vt));
            newCell.mergeValue(tempV);
        }
        return newCell;
    }
    */

    @Override
    public Cell getEmptyCell() {
        return new CellImpl1();
    }

    /**
     * TODO not null as return valueMap
     * @param v
     * @return
     */
    @Override
    public Value getValue(Value v) {
        return valueMap.getOrDefault(v.valueType,new Value(v.valueType));
    }

    @Override
    public Value setValue(Value v) {
        return valueMap.put(v.valueType,v);
    }

    /**
     *
     * @param v
     * @return the merged values
     */
    @Override
    public Value mergeValue(Value v) {
        Value thisValue=getValue(v);
        int h= thisValue.getValueCount()+ v.getValueCount();
        byte b;
        if(h>Byte.MAX_VALUE){// Wrap around check!
            b=Byte.MAX_VALUE;
        }else{
            b =(byte)h;
        }
        thisValue.setValueCount(b);
        setValue(thisValue);
        return thisValue;
    }

    @Override
    public Set<ValueType> getValueTypes() {
        return valueMap.keySet();
    }
}
