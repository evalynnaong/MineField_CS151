package MineField;

import tools.Model;

public class Field extends Model {
    private static int size = 20; // 20 by 20 grid
    private static int numMines = 20; // 20 total mines in field
    private Tile[][] field = new Tile[size][size];
    private Player player = new Player(0,0);

    public Field() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Tile(i, j, false, false); // initialize Mines to false
            }
        }
        field[0][0].setStepStatus(true); // part of initializing the board; steps on 0,0
        MineDistributor.place(field, numMines);
        notifySubscribers("Field initialized");
    }

    public void move(String direction) { // where the move logic lives
        int x = player.getX();
        int y = player.getY();

        switch (direction) {
            case "N":
                if (y > 0) {
                    player.setY(y - 1);
                }
                break;
            case "S":
                if (y < size) {
                    player.setY(y + 1);
                }
                break;
            case "E":
                if (x < size) {
                    player.setX(x + 1);
                }
                break;
            case "W":
                if (x > 0) {
                    player.setX(x - 1);
                }
                break;
            case "NW":
                if (x > 0 && y > 0) {
                    player.setX(x - 1);
                    player.setY(y - 1);
                }
                break;
            case "SW":
                if (x > 0 && y < size) {
                    player.setX(x - 1);
                    player.setY(y + 1);
                }
                break;
            case "NE":
                if (x < size && y > 0) {
                    player.setX(x + 1);
                    player.setY(y - 1);
                }
                break;
            case "SE":
                if (x < size && y < size) {
                    player.setX(x + 1);
                    player.setY(y + 1);
                }
                break;
        }
        changed(); // from Model, sets changed flag and fires changed event
    }

    public int getSize() {return size;}

    public Tile getTile(int x, int y) {
        return field[x][y];
    }

    public int getAdjacentMines(int x, int y) {

        return 0;
    }
}
