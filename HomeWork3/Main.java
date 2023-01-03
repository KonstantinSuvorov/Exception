import src.Assistance.Assistance;
import src.View.ConsoleView;
import src.View.View;

public class Main {
    
    public static void main(String[] args) {
        Assistance<View> prog = new Assistance<View>(new ConsoleView());
        prog.start();
    }
}