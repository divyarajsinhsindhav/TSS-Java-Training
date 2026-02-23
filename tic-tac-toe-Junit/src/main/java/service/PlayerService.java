package service;

import model.CellMarks;
import model.Player;

public class PlayerService {
    private static final Player player1 = new Player(CellMarks.X);
    private static final Player player2 = new Player(CellMarks.O);

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public static Player getPlayerByMark(CellMarks mark) {
        if (mark == CellMarks.X) {
            return player1;
        }
        return player2;
    }
}
