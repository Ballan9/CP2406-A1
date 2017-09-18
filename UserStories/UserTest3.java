import javax.swing.*;

public class UserTest3 {

    public static void main(String[] args) {
        String userName = getName();
        getLeaderboard(userName);
    }

    public static String getName(){
        String name;
        name = JOptionPane.showInputDialog(null, "Please Enter Your Name");
        return name;
    }
    public static void getLeaderboard(String userName){
        String list;
        JOptionPane.showMessageDialog(null, "1. Dimitri" + "2. Randy" + "3." + userName);
    }

}
