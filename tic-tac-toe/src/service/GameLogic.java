package service;

import model.Board;
import model.Player;

public class GameLogic {

    public Player checkWinner(char[][] board, char mark) {

        int size = board.length;

        // Check rows
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;

            for (int j = 0; j < size; j++) {
                if (board[i][j] != mark) {
                    rowWin = false;
                    break;
                }
            }

            if (rowWin)
                return PlayerService.getPlayerByMark(mark);
        }

        // Check columns
        for (int i = 0; i < size; i++) {
            boolean colWin = true;

            for (int j = 0; j < size; j++) {
                if (board[j][i] != mark) {
                    colWin = false;
                    break;
                }
            }

            if (colWin)
                return PlayerService.getPlayerByMark(mark);
        }

        // Check main diagonal
        boolean mainDiagonalWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != mark) {
                mainDiagonalWin = false;
                break;
            }
        }

        if (mainDiagonalWin)
            return PlayerService.getPlayerByMark(mark);

        // Check anti-diagonal
        boolean antiDiagonalWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != mark) {
                antiDiagonalWin = false;
                break;
            }
        }

        if (antiDiagonalWin)
            return PlayerService.getPlayerByMark(mark);

        return null;
    }


    public boolean isGameBoardEmpty(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
