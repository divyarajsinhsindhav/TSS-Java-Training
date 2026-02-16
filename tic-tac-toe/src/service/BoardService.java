package service;

public class BoardService {

    public boolean placeMark(int row, int col, char mark, char[][] board) {
        int size = board.length;
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '\0') {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public void printBoard(char[][] board) {

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
                char cell = board[i][j] == '\0' ? ' ' : board[i][j];
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

    public boolean isBoardFull(char[][] board) {

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
