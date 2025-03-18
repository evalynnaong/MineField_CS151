package mineField;


import mvc.Model;

import java.util.Random;

public class Field extends Model {
    private static final int size = 20;
    private Tile[][] field = new Tile[size][size];
    private int playerX = 0, playerY = 0; // Player starts at (0,0)
    public static int percentMined = 5; // % of tiles mined
    private boolean gameOver = false; // Track game state

    public Field() {
        Random rand = new Random();
        int totalMines = (size * size * percentMined) / 100; // Determine number of mines

        // Initialize field with empty tiles
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Tile(i, j, false, false, 0);
            }
        }

        // step status of first step is true
        field[0][0].setStepStatus(true);

        // Randomly place mines
        for (int i = 0; i < totalMines; i++) {
            int x, y;
            do {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            } while (field[x][y].getMineStatus()); // Ensure we don't place a mine on an already mined tile

            field[x][y].setMineStatus(true);
        }

        // Count number of mines surrounding space
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int n = countMines(x, y);
                field[x][y].setNumMines(n);
            }
        }

        notifySubscribers("Field initialized with " + totalMines + " mines.");
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return field[x][y]; //field[row][col]
        }
        return null; // Handle out-of-bounds access safely
    }

    public boolean movePlayer(String direction) {
        if (gameOver) return false;

        int newX = playerX, newY = playerY;
        switch (direction) {
            case "NW": newX--; newY--; break;
            case "N":  newY--; break;
            case "NE": newX++; newY--; break;
            case "W":  newX--; break;
            case "E":  newX++; break;
            case "SW": newX--; newY++; break;
            case "S":  newY++; break;
            case "SE": newX++; newY++; break;
        }

        // Validate new position
        if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
            playerX = newX;
            playerY = newY;

            field[playerX][playerY].setStepStatus(true);

            // Check for mine
            if (field[playerX][playerY].getMineStatus()) {
                gameOver = true;
                notifySubscribers("Game Over! You hit a mine.");
                return false;
            }
            return true;
        }
        return false;
    }

    public int getPlayerX() { return playerX; }
    public int getPlayerY() { return playerY; }
    public int getSize() { return size; }
    public int countMines(int x, int y){
        int count = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && y >= 0 && x < getSize() && y < getSize()){
                if (getTile(x, y).getMineStatus()) {
                    count++;
                }
            }
        }
        return count;
    }
}
