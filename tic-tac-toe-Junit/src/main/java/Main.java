import controller.TicTacToeController;
import service.TicTacToeFacade;

public class Main {
    public static void main(String[] args) {
        TicTacToeFacade facade = new TicTacToeFacade();
        TicTacToeController controller = new TicTacToeController(facade);
        controller.start();
    }
}