package com.problemsolver.runner1.puzzleproblem;

/**
 * Created by runner1 on 4/27/17.
 */

public class Location {

    public Location(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int r) {
        row = r;
    }

    public void setCol(int c) {
        col = c;
    }

    private int row;
    private int col;
}
