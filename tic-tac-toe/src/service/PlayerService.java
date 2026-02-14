package service;

import model.Player;

public class PlayerService {
    private static final Player player1 = new Player('X');
    private static final Player player2 = new Player('O');

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public static Player getPlayerByMark(char mark) {
        if (mark == 'X') {
            return player1;
        }
        return player2;
    }
}
