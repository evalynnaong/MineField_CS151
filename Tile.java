package MineField;


import java.io.Serializable;

public class Tile implements Serializable {
    private int c, r; // column, row
    private boolean mineStatus; // true: mine at tile

    public Tile(int c, int r, boolean mineStatus) {
        this.c = c;
        this.r = r;
        this.mineStatus = mineStatus;
    }

    public int getC() {return c;}
    public int getR() {return r;}
    public boolean getMineStatus() {return mineStatus;}

    public void setMineStatus(boolean mineStatus) {this.mineStatus = mineStatus;}
}
