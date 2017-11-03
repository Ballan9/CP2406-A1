public class LightCycle {
    int x;
    int y;
    int playerNumber;
    int north = 0;
    int east = 1;
    int south = 2;
    int west = 3;
    int direction;

    public LightCycle(int x, int y, int playerNumber, int direction) {
        this.x = x;
        this.y = y;
        this.playerNumber = playerNumber;
        this.direction = direction;
    }
    public void move(){
        if (direction == 0){
            y--;
        }
        else if (direction ==1){
            x++;
        }
        else if (direction ==2){
            y++;
        }
        else {
            x--;
        }
    }
}
