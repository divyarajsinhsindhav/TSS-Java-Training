package service;

import model.CellMarks;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    PlayerService playerService = new PlayerService();

    @Test
    void testGetPlayer1() {
        assertNotNull(playerService.getPlayer1());
    }

    @Test
    void testGetPlayer2() {
        assertNotNull(playerService.getPlayer2());
    }

    @Test
    void testGetPlayerByMark() {
        Player playerX = PlayerService.getPlayerByMark(CellMarks.X);
        Player playerO = PlayerService.getPlayerByMark(CellMarks.O);

        assertEquals(CellMarks.X, playerX.getMark());
        assertEquals(CellMarks.O, playerO.getMark());

        assertNotSame(playerX, playerO);

        assertSame(playerX, PlayerService.getPlayerByMark(CellMarks.X));
        assertSame(playerO, PlayerService.getPlayerByMark(CellMarks.O));
    }
}