    package model;

    public class Cell {
        private CellMarks marks;

        public Cell() {
            this.marks = CellMarks.EMPTY;
        }

        public CellMarks getMarks() {
            return marks;
        }

        public void setMarks(CellMarks marks) {
            this.marks = marks;
        }
    }
