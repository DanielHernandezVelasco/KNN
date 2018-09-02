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
    ArrayList<Color> color;
    private Point newPoint;
    private int numPatterns;
    private int K;
    private int kindOfDistance;
    public Knn() {
    }

    public Knn(Point p, int numberOfPat, int k) {
        newPoint = p;
        numPatterns = numberOfPat;
        this.K = k;
    }

    public int getKindOfDistance() {
        return kindOfDistance;
    }

    public void setKindOfDistance(int kindOfDistance) {
        this.kindOfDistance = kindOfDistance;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public void setNumPatterns(int np) {
        numPatterns = np;
    }

    public void setNewPoint(Point p) {
        newPoint = p;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public ArrayList<Point> getPatterns() {
        return patterns;
    }

    public void run() {

        //patterns=Utils.randomPatterns(numPatterns);
        color = new ArrayList<>();
        calcDistance(kindOfDistance);
        int[] counters = new int[color.size()];
        Utils.zeros(counters);
        Utils.sortByDist(patterns);
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < color.size(); j++) {
                if (patterns.get(i).getC() == color.get(j)) {
                    counters[j]++;
                }
            }
        }
        int tmp = counters[0];
        int index = 0;
        for (int i = 1; i < counters.length; i++) {
            if (counters[i] > tmp) {
                tmp = counters[i];
                index = i;
            }
        }
        newPoint.setC(color.get(index));
        /*for(int i=K;i<patterns.size();i++){
            patterns.get(i).setC(Color.GRAY);
        }*/
    }

    
    /**
     * 
     * @param opc reprecent the kind of distance that will be 
     * calculate: 
     *      1 -> Euclidean distance
     *      2 -> Manhattan distance 
     *      
     */
    private void calcDistance(int opc) {
        switch (opc) {
            case 0:
                for (Point e : patterns) {
                    e.setDistance(Utils.euclideanDistance(e, newPoint));
                    if (!color.contains(e.getC())) {
                        color.add(e.getC());
                    }
                }
                break;
            case 1:
                for (Point e : patterns) {
                    e.setDistance(Utils.manhattanDistance(e, newPoint));
                    if (!color.contains(e.getC())) {
                        color.add(e.getC());
                    }
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }

    public void setPatterns(ArrayList<Point> randomPatterns) {
        this.patterns = randomPatterns;
    }
}
