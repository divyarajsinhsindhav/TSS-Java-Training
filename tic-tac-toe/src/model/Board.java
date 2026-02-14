package model;

public class Board {
    public char[][] board;
    public final int ROW = 3;
    public final int COL = 3;

    public Board() {
        this.board = new char[ROW][COL];
    }

    public char[][] getBoard() {
        return board;
    };
}
