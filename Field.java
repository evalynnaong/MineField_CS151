package MineField;

import tools.Publisher;

import java.io.Serializable;

public class Field extends Publisher implements Serializable {
    private static int size = 20;
    private Tile[][] field = new Tile[size][size];
    private boolean mineStatus = false; // default mine tile status

    public Field() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Tile(i, j, mineStatus); // will need to reconfig this but just do the default now
            }
        }
        notifySubscribers("Field initialized");
    }

}
