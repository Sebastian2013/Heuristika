package Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 */
public class Game {

    /**
     *
     */
    public Game() {
    }

    /**
     *
     */
    public World wOld;

    /**
     *
     */
    public World wNew;

    /**
     *
     */
    public Actors aOld;

    /**
     *
     */
    public Actors aNew;

    /**
     *
     */
    public double refreshRate = 1;

    /**
     *
     */
    public short refreshActors = 1;

    /**
     *
     */
    public short refreshWorld = 10;

    /**
     *
     */
    public Logic logo;




    /**
     *
     */
    public static void main(String [] arg) {
        System.out.println("Hallo Welt");
        Game x = new Game();
        x.genWorld();
        x.gameLoop();
        System.out.println("Bye Welt");
    }

    /**
     *
     */
    public void genWorld() {
    /*
        wOld = World3.worldGenerator(100, 100, 1);
        wOld=placeRdmValue(wOld, ValueType.grass, 2);
        wNew=wOld;
        //drawPic(0, ValueType.grass, wNew);
        */
    }

    /**
     *
     * @param w     where to be placed
     * @param vt    what to be placed
     * @param count how much to be placed
     * @return
     */
    private World placeRdmValue(World w, ValueType vt, int count){
        /*
        int x = w.getDimensionX();
        int y = w.getDimensionY();
        int z = w.getDimensionZ();
        int rx;
        int ry;
        int rz;
        World tempW = w.getEmptyWorld();
        Cell temC, tempNewC;
        Random rnd = new Random(20);

        for(int i=0;i < count;i++){
            rx=rnd.nextInt(x);
            ry=rnd.nextInt(y);
            rz=rnd.nextInt(z);
            temC=tempW.getCell(rx,ry,rz);
            tempNewC= new CellImpl2();
            tempNewC.addValue(vt,(byte)1);
            tempW.setCell(rx,ry,rz,temC.mergeCell(tempNewC));
        }

        return tempW;
        */
        return null;
    }


    /**
     *
     */
    public void gameLoop() {
        /*
        Logic logic=LogicImpl.getLogic();
        World w1,w2;
        JFrame frameGrass=null , frameBush=null;
        long time1,time2;
        do{
            wOld=wNew;
            aOld=aNew;
            try {
                Thread.sleep((long)(refreshRate*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time1 = System.currentTimeMillis();

            wNew=logic.simWorld(wOld);
            aNew = logic.simActors(wOld, aOld);

            time2 = System.currentTimeMillis();
            //drawPic(0, ValueType.grass, wNew);
            frameGrass=drawPicSwing(0,ValueType.grass,wNew,frameGrass);
            frameBush=drawPicSwing(0,ValueType.bush,wNew,frameBush);

            System.out.println(time2-time1);

        }while(true);
        */
    }
    /*
    private void drawPic(int levelZ, ValueType vt, World inputWorld) {
        final int x = inputWorld.getDimensionX();
        final int y = inputWorld.getDimensionY();
        String format;

        for(int iy=0;iy<x;iy++){
            for(int ix=0;ix<x;ix++){
                format=String.format("%1$6d |",inputWorld.getCell(ix,iy,levelZ).getValues().getOrDefault(vt,(byte)0));
                //System.out.print(inputWorld.getCell(ix,iy,levelZ).getValues().getOrDefault(vt,(short)0));
                System.out.print(format);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }

    private JFrame drawPicSwing(int levelZ, ValueType vt, World inputWorld, JFrame frame) {
        JFrame helpFrame;
        if(frame == null){
            helpFrame = new JFrame(vt.toString());
            helpFrame.setSize(900, 350);
            //helpFrame.add(new JLabel());
            JTextArea tx = new JTextArea();
            tx.setLineWrap(false);
            tx.setEditable(false);
            tx.setFont(new Font("Serif", Font.ITALIC, 20));


            helpFrame.add(tx);
            helpFrame.setVisible(true);
        }
        else{
            helpFrame=frame;
        }



        final int x = inputWorld.getDimensionX();
        final int y = inputWorld.getDimensionY();
        String format= "";

        for(int iy=0;iy<x;iy++){
            for(int ix=0;ix<x;ix++){
                format=format+String.format("%1$6d |",inputWorld.getCell(ix,iy,levelZ).getValues().getOrDefault(vt,(byte)0));
            }
            format=format+"\n";
        }
        //if(helpFrame.getContentPane().getClass().getName()==JLabel)
        if(helpFrame.getContentPane().getComponent(0) instanceof  JTextArea){
            JTextArea jl = (JTextArea) helpFrame.getContentPane().getComponent(0);
            format=format.replace(' ','_');
            jl.setText(format);
        }else{
            System.out.println(helpFrame.getContentPane().getComponent(0).getClass().getName());
        }

        //System.out.println(format);


        return helpFrame;
    }

    */

}