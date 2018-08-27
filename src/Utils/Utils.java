/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Point.Point;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author cachubis
 */
public class Utils{
    private static final Color colors[]={
        new Color(40, 180, 99),
        new Color(230, 126, 34),
        new Color(155, 89, 182),
        new Color(204, 51, 51),
        Color.BLACK,Color.YELLOW
    };
    public static int getEuclideanDistance(Point p1, Point p2) {

        int d;
        /*d= (int)Math.sqrt(Math.pow((p2.getX()-p1.getX()),2)+Math.pow((p2.getY()-p1.getY()), 2));*/
        int x1 = p1.getX();
        int x2 = p2.getX();
        int y1 = p1.getY();
        int y2 = p2.getY();

        d = (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return d;
    }

    public static void sortByDist(ArrayList<Point> puntos){
        Collections.sort(puntos, new Sort());
    }
    
    public static ArrayList<Point> randomPatterns(int numPatterns) {
        ArrayList<Point> list = new ArrayList<>(); 
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < numPatterns; i++) {
           
            list.add(new Point((int) (r.nextDouble() * 590 + 5), (int) (r.nextDouble() * 590 + 5),colors[r.nextInt(colors.length)]));
        }
        return list;
    }
    public static void zeros(int [] ar){
        for(int i=0;i<ar.length;i++){
            ar[i]=0;
        }
    }
}
