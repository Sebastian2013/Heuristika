package Game.Implementations;

import Game.Cell;
import Game.Value;
import Game.World;

/**
 *
 */
public class WorldImpl1 implements World{

    public static World worldGenerator(int x, int y, Cell c) {
        WorldImpl1 w = new WorldImpl1(x,y);
        w.cells = new Cell[x][];
        for(int ax=0; ax < x ;ax++){
            w.cells[ax] = new Cell[y];
            for(int ay=0;ay<y;ay++){
                w.cells[ax][ay]=c.getEmptyCell();
            }
        }
        return w;
    }

    private Cell[][] cells;

    private final int x,y;

    private WorldImpl1(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int getDimensionX() {
        return x;
    }

    @Override
    public int getDimensionY() {
        return y;
    }


    @Override
    public Cell getCell(int x, int y) {
        Cell output;
        if(x>=0&&y>=0&&x<getDimensionX()&&y<getDimensionY()){
            output= cells[x][y];
        }else{
            output= cells[0][0].getEmptyCell();
        }
        return output;
    }

    @Override
    public Cell setCell(int x, int y, Cell c) {
        Cell oldCell=getCell(x,y);
        cells[x][y]=c;
        return oldCell;
    }

    @Override
    public World getEmptyWorld() {
        return WorldImpl1.worldGenerator(x,y,getCell(0,0));
    }

    @Override
    public World mergeWorld(World w) {
        int wx=w.getDimensionX();
        int wy=w.getDimensionY();
        for(int x=0; x<wx;x++){
            for(int y=0; y< wy;y++){
                cells[x][y].merge(w.getCell(x,y));
            }
        }




        return this;
    }

    @Override
    public Value getValue(int x, int y, Value v) {
        return getCell(x,y).getValue(v);
    }

    @Override
    public Value setValue(int x, int y, Value v) {
        return getCell(x,y).setValue(v);
    }
}
