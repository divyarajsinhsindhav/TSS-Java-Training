package controller;

import model.Board;
import model.Player;
import service.BoardService;
import service.GameLogic;
import service.PlayerService;
import utils.PositionValidation;


public class TicTacToeController {
    Board board = new Board();

    BoardService boardService = new BoardService();
    GameLogic gameLogic = new GameLogic();
    PlayerService playerService = new PlayerService();
    PositionValidation positionValidation = new PositionValidation();

    public void start() {

        Player currentPlayer = playerService.getPlayer1();
        Player winner;

        while (true) {

            boardService.printBoard(board.getBoard());

            System.out.println("______________");
            System.out.println(currentPlayer.getMark() + " turn");
            System.out.println("Enter position (row col): ");

            int row = positionValidation.readNumber();
            int col = positionValidation.readNumber();

            boolean placed = boardService.placeMark(
                    row,
                    col,
                    currentPlayer.getMark(),
                    board.getBoard()
            );

            if (!placed) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            winner = gameLogic.checkWinner(board.getBoard(), currentPlayer.getMark());

            if (winner != null) {
                boardService.printBoard(board.getBoard());
                System.out.println("🎉 Winner is " + winner.getMark());
                return;
            }

            if (gameLogic.isGameBoardFull(board.getBoard())) {
                boardService.printBoard(board.getBoard());
                System.out.println("Game is a Draw!");
                return;
            }

            // Switch player
            currentPlayer = (currentPlayer == playerService.getPlayer1())
                    ? playerService.getPlayer2()
                    : playerService.getPlayer1();

        }
    }

}
