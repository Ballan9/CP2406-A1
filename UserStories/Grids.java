import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.*;
import java.awt.event.*;


class Grids {
    int width = 50, height = 50;
    int[][] grids = new int[width][height];

    public Grids() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grids[x][y] = 0;
            }
        }
    }

    public void praint() {
        for (int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                System.out.print(grids[y][x]);
            }
        }
    }


}