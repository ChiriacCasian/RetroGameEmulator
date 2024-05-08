package game;

public class PacmanGame implements GamingConsole{
    public void up(){
        System.out.println("^");
    }
    public void down(){
        System.out.println("v");
    }
    public void left(){
        System.out.println("->");
    }
    public void right(){
        System.out.println("<-");
    }
}
