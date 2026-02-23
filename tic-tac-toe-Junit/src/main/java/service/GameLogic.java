package service;

import model.Cell;
import model.CellMarks;
import model.Player;

public class GameLogic {

    public Player checkWinner(Cell[][] board, CellMarks mark) {
        if (hasRowWin(board, mark) || hasColumnWin(board, mark) || hasMainDiagonalWin(board, mark) || hasAntiDiagonalWin(board, mark)) {

            return PlayerService.getPlayerByMark(mark);
        }

        return null;
    }

    private boolean hasRowWin(Cell[][] board, CellMarks mark) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            boolean win = true;

            for (int j = 0; j < size; j++) {
                if (board[i][j].getMarks() != mark) {
                    win = false;
                    break;
                }
            }

            if (win) return true;
        }

        return false;
    }

    private boolean hasColumnWin(Cell[][] board, CellMarks mark) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            boolean win = true;

            for (int j = 0; j < size; j++) {
                if (board[j][i].getMarks() != mark) {
                    win = false;
                    break;
                }
            }

            if (win) return true;
        }

        return false;
    }

    private boolean hasMainDiagonalWin(Cell[][] board, CellMarks mark) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            if (board[i][i].getMarks() != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean hasAntiDiagonalWin(Cell[][] board, CellMarks mark) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i].getMarks() != mark) {
                return false;
            }
        }

        return true;
    }
}
