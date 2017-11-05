

import java.awt.*;
import java.util.Objects;

public class LightCycle {
    int x;
    int y;
    String myname;
    String username;
    Color color;

public LightCycle(String userName, String myname, int x, int y){
    this.username = userName;
    this.myname = myname;
    this.x = x;
    this.y = y;
    if (Objects.equals(getUsername(), myname)){
        color = Color.green;
    }
    else {
        color = Color.pink;
    }
    }

    public String getUsername() {
        return username;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    void draw(Graphics graphics){
    Graphics local = graphics.create();
    local.setColor(color);
    local.fillOval(getX(),getY(),6, 6);
    local.dispose();

    }
}
