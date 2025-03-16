package mineField;

import java.io.Serializable;

public class Tile implements Serializable {
    private int c, r; // column, row
    private boolean mineStatus; // true: mine at tile
    private boolean stepStatus; // true: player has stepped here

    public Tile(int c, int r, boolean mineStatus, boolean stepStatus) {
        this.c = c;
        this.r = r;
        this.mineStatus = mineStatus;
        this.stepStatus = stepStatus;
    }

    public int getC() {return c;}
    public int getR() {return r;}
    public boolean getMineStatus() {return mineStatus;}
    public void setMineStatus(boolean mineStatus) {this.mineStatus = mineStatus;}
    public boolean getStepStatus() {return stepStatus;}
    public void setStepStatus(boolean stepStatus) {this.stepStatus = stepStatus;}

}
