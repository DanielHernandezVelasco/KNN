/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Point.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author cachubis
 */
public class Panel extends JPanel implements MouseListener{
    private ArrayList<Point> patterns=null;
    private Point newPoint=null;
    private int k;
    public Panel(){
        addMouseListener(this);
    }
    private void MousePressed(MouseEvent evt) {
        
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
    
    public ArrayList<Point> getPatterns() {
        return patterns;
    }

    public void setPatterns(ArrayList<Point> patterns) {
        this.patterns = patterns;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
        this.repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(this.getWidth()/2, 0, 4, this.getHeight());
        g.fillRect(0, getHeight()/2, getWidth(), 4);
        if(patterns!=null){
            for(Point p : patterns){
                g.setColor(p.getC());
                g.fillOval(p.getX(), p.getY(), 6, 6);
            }
        }
        if(newPoint!=null){
            g.setColor(newPoint.getC());
            g.fillOval(newPoint.getX(), newPoint.getY(), 11, 11);
        }
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1){
            newPoint = new Point(e.getX(),e.getY(),Color.BLACK);
            
            System.out.println(newPoint.getX()+"");
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
