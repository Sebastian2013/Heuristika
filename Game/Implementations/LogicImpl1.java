package Game.Implementations;

import Game.*;

/**
 *
 */
public class LogicImpl1 implements Logic{
    private static Logic logic;

    public static Logic getLogic(){
        if(logic==null)
            logic=new LogicImpl1();
        return  logic;
    }

    @Override
    public World simWorld(World w) {
        return growBush(growGrass(w));
    }

    @Override
    public Actors simActors(World w, Actors a) {
        return null;
    }

    @Override
    public Actors simStaticActors(World w, Actors a) {
        return null;
    }

    @Override
    public Actors simMovableActors(World w, Actors a) {
        return null;
    }


    /**
     * If grass is a direct neighbor (2d), it grows by 1 plus 10% of the sum of all neighbor grass
     * @param inputWorld
     * @return a new world with more grass on it
     */
    private World growGrass(World inputWorld){
        final int x = inputWorld.getDimensionX();
        final int y = inputWorld.getDimensionY();
        final World outputWorld = inputWorld.getEmptyWorld();


        int sumGrass=0;
        Cell tempCell;

        for(int ix=0;ix<x;ix++){
            for(int iy=0;iy<y;iy++){
                tempCell=inputWorld.getCell(0,0).getEmptyCell();
                tempCell=tempCell.merge(inputWorld.getCell(ix, iy));
                sumGrass=calcSum(ix,iy, ValueType.grass,inputWorld);

                if(sumGrass>0){
                    tempCell.mergeValue(new Value(ValueType.grass,(byte)(1+sumGrass*0.10)));
                }
                outputWorld.setCell(ix,iy,tempCell);
            }
        }
        return outputWorld;
    }

    /**
     * Same as grass consumes it if enought
     * @param inputWorld
     * @return
     */
    private World growBush(World inputWorld){
        final int x = inputWorld.getDimensionX();
        final int y = inputWorld.getDimensionY();
        final World outputWorld = inputWorld.getEmptyWorld();


        Cell tempCell;

        for(int ix=0;ix<x;ix++)
            for(int iy=0;iy<y;iy++) {
                    tempCell=inputWorld.getCell(0,0).getEmptyCell();
                    tempCell=tempCell.merge(inputWorld.getCell(ix, iy));

                    if(tempCell.getValue(new Value(ValueType.grass)).getValueCount()>100
                            && tempCell.getValue(new Value(ValueType.bush)).getValueCount()<Byte.MAX_VALUE){
                        tempCell.mergeValue(new Value(ValueType.grass, (byte) -100));
                        tempCell.mergeValue(new Value(ValueType.bush, (byte) 1));
                    }
                    outputWorld.setCell(ix,iy,tempCell);
                }
        return outputWorld;
    }

    /**
     * Sums all count of value in the connected cells to the x,y,z specific cell in the world.
     * 100
     * 011  = 1+1+1 = 3
     * 000
     * @param ix
     * @param iy
     * @param vt
     * @param inputWorld
     * @return
     */
    private int calcSum(int ix, int iy, ValueType vt, World inputWorld) {
        int output=0;

        output+=inputWorld.getCell(ix-1,iy-1).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix-1,iy).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix-1,iy+1).getValue(new Value(vt)).getValueCount();

        output+=inputWorld.getCell(ix,iy-1).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix,iy).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix,iy+1).getValue(new Value(vt)).getValueCount();

        output+=inputWorld.getCell(ix+1,iy-1).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix+1,iy).getValue(new Value(vt)).getValueCount();
        output+=inputWorld.getCell(ix+1,iy+1).getValue(new Value(vt)).getValueCount();

        return output;
    }
}
