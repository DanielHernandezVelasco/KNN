/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Point.Point;
import java.util.Comparator;

/**
 *
 * @author cachubis
 */
public class Sort implements Comparator<Point>{

    @Override
    public int compare(Point p1,Point p2) {
        int resp =0;
        if (p1.getDistance()>p2.getDistance())
            resp=1;
        else if (p1.getDistance()<p2.getDistance())
            resp= -1;
       
        return resp;
    }
}
