package model;

public class Player {
    private CellMarks mark;

    public Player(CellMarks mark) {
        this.mark = mark;
    }

    public CellMarks getMark() {
        return mark;
    }
}
