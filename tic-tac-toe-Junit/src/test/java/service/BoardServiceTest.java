package service;

import model.Board;
import model.Cell;
import model.CellMarks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {

    private Cell[][] board;
    private Board boardModel;
    private BoardService service;

    @BeforeEach
    void setUp() {
        service = new BoardService();
        boardModel = new Board();
        board = boardModel.getBoard();
    }

    @Test
    void testPlaceMarkValidMove() {
        boolean result =  service.placeMark(1, 1, CellMarks.X, board);

        assertTrue(result);
        assertEquals(CellMarks.X, board[1][1].getMarks());
    }



    @Test
    void testPlaceMarkOutOfBounds() {
        boolean result =  service.placeMark(10, 5, CellMarks.X, board);
        assertFalse(result);
    }

    @Test
    void testPlaceMarkOccupied() {
        // Player 1 put mark on [1, 1]
        board[1][1].setMarks(CellMarks.X);

        //Now, Player 2 again try to put the mark on [1, 1]
        boolean result =  service.placeMark(1, 1, CellMarks.O, board);
        assertFalse(result);
    }

    @Test
    void testIsBoardFullInitially() {
        assertFalse(service.isBoardFull(board));
    }

    @Test
    void testIsBoardFullInBetweenGame() {
        board[1][1].setMarks(CellMarks.X);
        board[1][2].setMarks(CellMarks.O);

        assertFalse(service.isBoardFull(board));
    }

    @Test
    void testIsBoardFullTrue() {
        board[0][0].setMarks(CellMarks.X);
        board[0][1].setMarks(CellMarks.O);
        board[0][2].setMarks(CellMarks.X);
        board[1][0].setMarks(CellMarks.O);
        board[1][1].setMarks(CellMarks.X);
        board[1][2].setMarks(CellMarks.O);
        board[2][0].setMarks(CellMarks.X);
        board[2][1].setMarks(CellMarks.O);
        board[2][2].setMarks(CellMarks.X);

        assertTrue(service.isBoardFull(board));
    }
}