package service;

import model.Board;
import model.Player;
import utils.PositionValidation;

public class TicTacToeFacade {

    private Board board = new Board();

    private final BoardService boardService = new BoardService();
    private final GameLogic gameLogic = new GameLogic();
    private final PlayerService playerService = new PlayerService();
    private final PositionValidation positionValidation = new PositionValidation();

    public Player getPlayer1() {
        return playerService.getPlayer1();
    }

    public Player getPlayer2() {
        return playerService.getPlayer2();
    }

    public void printBoard() {
        boardService.printBoard(board.getBoard());
    }

    public boolean placeMark(int row, int col, char mark) {
        return boardService.placeMark(row, col, mark, board.getBoard());
    }

    public Player checkWinner(char mark) {
        return gameLogic.checkWinner(board.getBoard(), mark);
    }

    public boolean isGameBoardFull() {
        return boardService.isBoardFull(board.getBoard());
    }

    public int readNumber() {
        return positionValidation.readNumber();
    }
}
