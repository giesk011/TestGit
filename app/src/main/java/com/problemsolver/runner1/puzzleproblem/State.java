package com.problemsolver.runner1.puzzleproblem;

/**
 * Created by runner1 on 4/27/17.
 */

public class State {

    public State() {

        iState  = new int[][]{{2, 8, 3}, {1, 6, 4}, {7, 0, 5}};
        cState = new int[][]{{2, 8, 3}, {1, 6, 4}, {7, 0, 5}};
        fState = new int[][]{{1, 2, 3},{8, 0, 4},{7, 6, 5}};
    }

    public Location getLocatoin(int tile) {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++){
                if(cState[r][c] == tile)
                    return new Location(r, c);
            }
        }
        return null;
    }

    // switch tile with zero position
    public void setState(int tile) {
        Location move = getLocatoin(tile);
        Location zero = getLocatoin(0);
        cState[move.getRow()][move.getCol()] = 0;
        cState[zero.getRow()][zero.getCol()] = tile;
    }

    public boolean checkGoal(){
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++){
                if(!(cState[r][c] == fState[r][c]))
                    return false;
            }
        }
        return true;
    }

    public boolean canDo(int tile) {
        Location move = getLocatoin(tile);
        Location zero = getLocatoin(0);
        int c1 = move.getCol();
        int r1 = move.getRow();
        int c0 = zero.getCol();
        int r0 = zero.getRow();
        if (c1 == c0 && (r1 - 1 == r0 || r1 + 1 == r0)) {
            boolean test1 = true;
            setState(tile);
            return true;
        }
        if (r1 == r0 && (c1 - 1 == c0 || c1 + 1 == c0)) {
            boolean test2 = true;
            setState(tile);
            return true;
        }
        return false;
    }

    public void reset() {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++){
                cState[r][c] = iState[r][c];
            }
        }
    }

    private int[][] iState;
    private int[][] cState;
    private int[][] fState;
}
