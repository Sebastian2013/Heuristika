package Game.Implementations;

import Game.*;

import java.util.Random;

/**
 *
 */
public class LogicImpl1 implements Logic{
    private static Logic logic;

    public static Logic getLogic(){
        if(logic==null)
            logic=new LogicImpl1(42);
        return  logic;
    }


    private int rndNumber;
    private Random rndGen;

    private LogicImpl1(int rnd){
        rndNumber=rnd;
        rndGen = new Random(rndNumber);
    }

    @Override
    public World simWorld(World w) {
        World world;
        world=rain(w,rndNumber);
        world =growGrass(world);
        return growBush(world);
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

    private World rain(World inputWorld, int count){
        return placeRdmValue(inputWorld,ValueType.water,count);
    }


    /**
     *
     * @param w     where to be placed
     * @param vt    what to be placed
     * @param count how much to be placed
     * @return
     */
    private World placeRdmValue(World w, ValueType vt, int count){
        final int x = w.getDimensionX();
        final int y = w.getDimensionY();

        int rx;
        int ry;

        World tempW = w.getEmptyWorld();
        tempW.mergeWorld(w);
        Cell temC, tempNewC;


        for(int i=0;i < count;i++){
            rx=rndGen.nextInt(x);
            ry=rndGen.nextInt(y);
            temC=tempW.getCell(rx, ry);//kopie oder referenz nicht festgelegt! deshalb nacher setzen
            tempNewC= temC.getEmptyCell();
            tempNewC.mergeValue(new Value(vt, (byte) 1));
            tempW.setCell(rx, ry, temC.merge(tempNewC));
        }
        return tempW;
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

        int growRate=1;
        int sumGrass=0;
        Cell tempCell;

        for(int ix=0;ix<x;ix++){
            for(int iy=0;iy<y;iy++){
                tempCell=inputWorld.getCell(0,0).getEmptyCell();
                tempCell=tempCell.merge(inputWorld.getCell(ix, iy));
                sumGrass=calcSum(ix,iy, ValueType.grass,inputWorld);

                if(sumGrass>0){
                    if(tempCell.getValue(new Value(ValueType.water)).getValueCount()>0){//wenn es Wasser auf dem Feld gibt
                        tempCell.mergeValue(new Value(ValueType.water,(byte)(-1)));
                        growRate=4;
                    }else{
                        growRate=1;
                    }


                    tempCell.mergeValue(new Value(ValueType.grass,(byte)(growRate+sumGrass*0.01)));

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
