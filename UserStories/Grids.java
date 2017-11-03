import java.awt.*;
import java.awt.event.*;



class Grids extends Canvas {
    int width, height;
    int [][] grids = new int[width][height];

    Grids(int w, int h) {
        setSize(width = w, height = h);

    }
    public void paint(Graphics g) {
        int k;
        width = getSize().width;
        height = getSize().height;



        class DrawGrids extends Frame {
            DrawGrids(String title, int w, int h, int rows, int columns) {
                setTitle(title);
                Grids grid = new Grids(w, h);
                add(grid);
                }
    }}
    public static void main(String[] args) {
        new DrawGrids("Draw Grids", 500, 500, 10, 10).setVisible(true);
    }
}