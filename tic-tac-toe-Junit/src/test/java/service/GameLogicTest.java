package service;

import model.Board;
import model.Cell;
import model.CellMarks;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private Cell[][] board;
    private Board boardModel;
    private GameLogic gameLogic;
    private CellMarks mark;
    private Player player;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic();
        boardModel = new Board();
        board = boardModel.getBoard();
    }

    @Test
    void testWinnerAtRow() {
        board[0][0].setMarks(CellMarks.X);
        board[0][1].setMarks(CellMarks.X);
        board[0][2].setMarks(CellMarks.X);

        player = gameLogic.checkWinner(board, CellMarks.X);

        assertNotNull(player);
        assertEquals(PlayerService.getPlayerByMark(CellMarks.X),  player);
    }

    @Test
    void testNotWinnerAtRow() {
        board[0][0].setMarks(CellMarks.X);
        board[0][1].setMarks(CellMarks.O);
        board[0][2].setMarks(CellMarks.X);
        board[1][0].setMarks(CellMarks.O);

        player = gameLogic.checkWinner(board, CellMarks.X);

        assertNull(player);
    }

    @Test
    void testWinnerAtColumn() {
        board[0][0].setMarks(CellMarks.O);
        board[1][0].setMarks(CellMarks.O);
        board[2][0].setMarks(CellMarks.O);

        player = gameLogic.checkWinner(board, CellMarks.O);
        assertNotNull(player);
        assertEquals(PlayerService.getPlayerByMark(CellMarks.O),  player);
    }

    @Test
    void testNotWinnerAtColumn() {
        board[0][0].setMarks(CellMarks.O);
        board[1][0].setMarks(CellMarks.O);
        board[2][0].setMarks(CellMarks.X);

        player = gameLogic.checkWinner(board, CellMarks.O);
        assertNull(player);
    }

    @Test
    void testWinnerAtMainDiagonal() {
        board[0][0].setMarks(CellMarks.X);
        board[1][1].setMarks(CellMarks.X);
        board[2][2].setMarks(CellMarks.X);

        player = gameLogic.checkWinner(board, CellMarks.X);

        assertNotNull(player);
        assertEquals(PlayerService.getPlayerByMark(CellMarks.X), player);
    }

    @Test
    void testNotWinnerAtMainDiagonal() {
        board[0][0].setMarks(CellMarks.X);
        board[1][1].setMarks(CellMarks.O);
        board[2][2].setMarks(CellMarks.X);

        player = gameLogic.checkWinner(board, CellMarks.X);

        assertNull(player);
    }

    @Test
    void testWinnerAtAntiDiagonal() {
        board[0][2].setMarks(CellMarks.O);
        board[1][1].setMarks(CellMarks.O);
        board[2][0].setMarks(CellMarks.O);

        player = gameLogic.checkWinner(board, CellMarks.O);

        assertNotNull(player);
        assertEquals(PlayerService.getPlayerByMark(CellMarks.O), player);
    }

    @Test
    void testNotWinnerAtAntiDiagonal() {
        board[0][2].setMarks(CellMarks.O);
        board[1][1].setMarks(CellMarks.X);
        board[2][0].setMarks(CellMarks.O);

        player = gameLogic.checkWinner(board, CellMarks.O);

        assertNull(player);
    }

}