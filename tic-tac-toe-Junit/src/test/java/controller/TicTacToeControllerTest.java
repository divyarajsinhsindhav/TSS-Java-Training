package controller;

import model.CellMarks;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.TicTacToeFacade;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;

class TicTacToeControllerTest {

    TicTacToeController controller;
    TicTacToeFacade facade;

    @BeforeEach
    void setUp() {
        facade = Mockito.mock(TicTacToeFacade.class);
        controller = new TicTacToeController(facade);
    }

    @Test
    void testDeclareWinner() {
        Player player1 = new Player(CellMarks.X);
        Mockito.when(facade.getPlayer1()).thenReturn(player1);
        Mockito.when(facade.readNumber()).thenReturn(0, 0);
        Mockito.when(facade.placeMark(0, 0, CellMarks.X)).thenReturn(true);
        Mockito.when(facade.checkWinner(CellMarks.X)).thenReturn(player1);

        controller.start();

        Mockito.verify(facade, atLeastOnce()).printBoard();
        Mockito.verify(facade).placeMark(0, 0, CellMarks.X);
        Mockito.verify(facade).checkWinner(CellMarks.X);
    }

}