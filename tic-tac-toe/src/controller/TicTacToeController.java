package controller;

import model.Player;
import service.TicTacToeFacade;

public class TicTacToeController {

    private final TicTacToeFacade facade = new TicTacToeFacade();

    public void start() {

        Player currentPlayer = facade.getPlayer1();
        Player winner;

        while (true) {

            facade.printBoard();

            System.out.println("______________");
            System.out.println(currentPlayer.getMark() + " turn");
            System.out.println("Enter position (row col): ");

            int row = facade.readNumber();
            int col = facade.readNumber();

            boolean placed = facade.placeMark(row, col, currentPlayer.getMark());

            if (!placed) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            winner = facade.checkWinner(currentPlayer.getMark());

            if (winner != null) {
                facade.printBoard();
                System.out.println("🎉 Winner is " + winner.getMark());
                return;
            }

            if (facade.isGameBoardFull()) {
                facade.printBoard();
                System.out.println("Game is a Draw!");
                return;
            }

            currentPlayer = (currentPlayer == facade.getPlayer1())
                    ? facade.getPlayer2()
                    : facade.getPlayer1();
        }
    }
}
