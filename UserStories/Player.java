public class Player {

    private int x; //X position
    private int y; //Y position

    public Player(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){return x;}

    public int getY(){return y;}

    public void moveUp() { y-=incint; }

    public void moveDown() { y+=incint; }

    public void moveRight() { x+=incint; }

    public void moveLeft() { x-=incint; }


}
