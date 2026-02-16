package model;

public class Board {
    public char[][] board;
    private final int SIZE = 3;

    public Board() {
        this.board = new char[SIZE][SIZE];
    }

    public char[][] getBoard() {
        return board;
    };
}
