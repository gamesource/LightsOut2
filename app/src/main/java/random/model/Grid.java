package random.model;

/**
 * Created by gamer on 19.05.2015.
 */
public class Grid {

    private final int MAX_ROW = 5;
    private final int MAX_COLUMN = 5;
    private boolean[][] states;

    public Grid() {
        states = new boolean[MAX_ROW][MAX_COLUMN];

        for(int row = 0; row < MAX_ROW; row++) {
            for(int column = 0; column < MAX_COLUMN; column++) {
                states[row][column] = false;
            }
        }

    }

    public boolean isActive(int row, int column) {
        return states[row][column];
    }

    public void updateState(int row, int column) {
        states[row][column] = !states[row][column];
    }

    public boolean isLegal(int row, int column) {
        if(row >= MAX_ROW || row < 0 || column >= MAX_COLUMN || column < 0) {
            return false;
        }
        return true;
    }

    public void setNewGame(int[][] newGame) {
        for(int row = 0; row < MAX_ROW; row++) {
            for(int column = 0; column < MAX_COLUMN; column++) {
                states[row][column] = newGame[row][column] == 0?false:true;
            }

        }
    }

    public boolean[][] getStates() {
        return states;
    }
}
