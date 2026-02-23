package model;

public class Board {
    public Cell[][] board;
    private final int SIZE = 3;

    public Board() {
        this.board = new Cell[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    };
}
