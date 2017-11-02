import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TronCycle extends JPanel implements KeyListener{

    Player p1;
    Player p2;

    private boolean []keys;

    private String p1nxdirection = "R";
    private String p2nxtdirection = "L";

    ArrayList<Interger> p1xpos = new Arraylist <~>();
    ArrayList<Interger> p1ypos = new Arraylist <~>();

    ArrayList<Interger> p2xpos = new ArrayList<~>();
    ArrrayList<Interger> p2ypos = new ArrayList<~>();

    private GamePanel mainFrame;

    public TronCycle(GamePanel m) {

        keys = new booleams [KeyEvent.KEY_LAST+1];

        mainFrame = m;

        p1 = new Player(3, 290);
        p2 = new Player(594, 290);

        setSize(GamePanel);
        addKeyListener(this);
        setVisible(true);
    }

    public void addNotify() { //starts game when player is ready
        super.addNotify();
        requestFocus();
        mainFrame.start();
    }

    public String directioncheck(String direction. Sting nxtdirection){

        if(direction.equals("R")){
            if (nxtdirection.equals("L")){
                direction = direction;
            }
            else{
                direction = nxtdirection;
            }
        }

        if(direction.equals("L")){
            if(nxtdirection.equals("R")){
                direction = direction;
            }
            else{
                direction = nxtdirection;
            }
        }

        if (direction.equals("U")){
            if(nxtdirection.equals("D")){
                direction = direction;
            }
            else{
                direction = nxtdirection;
            }
            else{
                direction = nxtdirection;
            }
        }
        return direction;
    }

    public String p1direction(){
        if(keys[KeyEvent.VK_RIGHT]){
            p1nxtdirection = "R";
        }
        if (keys[KeyEvent.VK_LEFT]){
            p1nxtdirection ="L";
        }
        if(keys[KeyEvent.VK_UP]){
            p1nxtdirection = "U";
        }
        if(keys[KeyEvent.VK_DOWN]){
            p1nxtdirection = "D";
        }
        return direcitoncheck(p1direction, p1nxtdirection);
    }

 /*   public String p2direction(){
        if(keys[KeyEvent.VK_RIGHT]){
            p2nxtdirection = "R";
        }
        if (keys[KeyEvent.VK_LEFT]){
            p2nxtdirection ="L";
        }
        if(keys[KeyEvent.VK_UP]){
            p2nxtdirection = "U";
        }
        if(keys[KeyEvent.VK_DOWN]){
            p2nxtdirection = "D";
        }
        return direcitoncheck(p2direction, p2nxtdirection);
    } */
    public void p1move(String direction){
        if(direction=="R"){
            p1.moveRight();
        }
        else if(direction=="L"){
            p2.moveLeft();
        }
        else if(direction=="U"){
            p2.moveUp();
        }
        else if(direction=="D"){
            p2.moveDown();
        }
    }

    public boolean inList(ArrayList<Interger>xlist,ArrayList<Interger>ylist, int x, int y){
        for(int i = 0; i<xlist.size(); i++){
            for(int j = 0; j<ylist.size(); j++){
                if(x==xlist.get(i) && y==ylist.get(i)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean borderCollide(player p){
        if (p.getX()>=597) || p.getX()<=0 || p.getY()<=0 || p.getY()>=597){
            return true;
        }
        return false;
    }

    public boolean collide() {
        boolean plcollide = inList(p2xpos, p2ypos, p1.getX(), p1.getY());
        boolean p2collide = inList(p1xpos, p1ypos, p2.getX(), p2.getY());
        boolean p2border = borderCollide(p2);
        boolean p1border = borderCollide(p1);
        if (p1collide == true || p2collide == true || p1border == true || p2border == true) {
            return false;
        }
        else{
             losingPlayer(p1collide, p2collide, p2border, p1border);
             return true;
        }
    }
        return false;

    public void lostingPlayer(boolean p1c, boolean p2c, boolean p2b, boolean p1b) {
        if (p1c == true) {
            loser = "P1";
        }
        if (p2c == true) {
            loser = "P2";
        }
        if (p1b == true) {
            loser = "P1";
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {keys[e.getKeyCode()] = true; }

    public void keyReleased(KeyEvent e) {keys[e.getKeyCode()] = false;

    public void p1pathway(Graphics g){
        p1xpos.add(p1.getX());
        p1ypos.add(p1.getY());
        g.setColor(Color.orange);
        for(int i = 0; i< p1xpos.size(); i++){
            g.fillRect(p1xpos.get(i),p1ypos.get(i), 5,5);
        }

    }

    public void p2pathway(Graphics g){
        p2xpos.add(p2.getX());
        p2ypos.add(p2.getY());
        g.setColor(Color.blue);
        for(int i = 0; i< pxpos.size(); i++){
            g.fillRect(p2xpos.get(i),p2ypos.get(i),5,5);
        }
    }

    public void paintComponent(Graphics g){
        p1pathway(g);
        g.drawImage(p1directionpic, pl.getX()-17,pl.getY()-17,this);
        p2pathway(g);
        g.drawImage(p2directionpic, p2.getX()-12, p2.getY()-12,this);
        if(loser.equals("P1")){
            JFrame.
        }

        }

}
}






