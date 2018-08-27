package Knn;

import Point.Point;
import Utils.Utils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author cachubis
 */
public class Knn {
    private ArrayList<Point> patterns;
    private Point newPoint;
    private int numPatterns;
    private int K;
    public Knn(){
    }
    public Knn(Point p, int numberOfPat,int k){
        newPoint=p;
        numPatterns=numberOfPat;
        this.K=k;
    }
    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }
    public void setNumPatterns(int np){
        numPatterns=np;
    }
    public void setNewPoint(Point p){
        newPoint=p;
    }
    public Point getNewPoint(){
        return newPoint;
    }
    public ArrayList<Point> getPatterns(){
        return patterns;
    }
    public void run(){
        
        patterns=Utils.randomPatterns(numPatterns);
        ArrayList<Color> ts = new ArrayList<>();
        
        for(Point e : patterns){
            e.setDistance(Utils.getEuclideanDistance(e, newPoint));
            if(!ts.contains(e.getC()))
                ts.add(e.getC());
        }
        int[] counters = new int[ts.size()];
        Utils.zeros(counters);
        Utils.sortByDist(patterns);
        for(int i = 0; i<K;i++){
            for (int j=0;j<ts.size();j++){
                if(patterns.get(i).getC()==ts.get(j)){
                    counters[j]++;
                }
            }
        }
        int tmp = counters[0];
        int index=0;
        for (int i = 1; i < counters.length; i++) {
            if (counters[i] > tmp) {
                tmp = counters[i];
                index=i;
            }
        }
        newPoint.setC(ts.get(index));
    }
    /*public static void main(String[] args) {
        Knn knn= new Knn(new Point(50,5,Color.BLUE),10,3);
        knn.run();
    }*/
}
