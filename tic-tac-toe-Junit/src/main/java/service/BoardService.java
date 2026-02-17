package service;

import model.Cell;
import model.CellMarks;

public class BoardService {

    public boolean placeMark(int row, int col, CellMarks mark, Cell[][] board) {
        int size = board.length;
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col].getMarks() == CellMarks.EMPTY) {
            board[row][col].setMarks(mark);
            return true;
        }
        return false;
    }

    public void printBoard(Cell[][] board) {

        int size = board.length;

        System.out.println();

        // Print column indices
        System.out.print("      ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // Print top border
        System.out.print("    ┌");
        for (int i = 0; i < size; i++) {
            System.out.print("───");
            if (i < size - 1)
                System.out.print("┬");
        }
        System.out.println("┐");

        // Print rows
        for (int i = 0; i < size; i++) {

            System.out.print(" " + i + "  │");

            for (int j = 0; j < size; j++) {
                String cell = board[i][j].getMarks() == CellMarks.EMPTY
                        ? " "
                        : board[i][j].getMarks().toString();

                System.out.print(" " + cell + " │");
            }


            System.out.println();

            // Print middle separator
            if (i < size - 1) {
                System.out.print("    ├");
                for (int j = 0; j < size; j++) {
                    System.out.print("───");
                    if (j < size - 1)
                        System.out.print("┼");
                }
                System.out.println("┤");
            }
        }

        // Print bottom border
        System.out.print("    └");
        for (int i = 0; i < size; i++) {
            System.out.print("───");
            if (i < size - 1)
                System.out.print("┴");
        }
        System.out.println("┘");

        System.out.println();
    }

    public boolean isBoardFull(Cell[][] board) {

        int size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getMarks() == CellMarks.EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

}
