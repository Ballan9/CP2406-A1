import java.awt.*;
import java.util.Objects;

public class Trail {

    String myname;
    String userName;
    int x;
    int y;
    Color trailColor;

    public Trail(String myname, String userName, int x, int y) {
        this.myname = myname;
        this.userName = userName;
        this.x = x;
        this.y = y;
        if(Objects.equals(userName, myname)){
            trailColor = Color.green;
        }
        else trailColor = Color.pink;
    }

    void draw (Graphics graphics){
        Graphics local = graphics.create();
        local.setColor(trailColor);
        local.fillRect(x,y,2,2);
        local.dispose();
    }
    public String getUserName() {
        return userName;
    }
}
