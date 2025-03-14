package MineField;

import tools.Publisher;

import java.io.Serializable;
import java.util.Random;

public class Field extends Publisher implements Serializable {
    private static int size = 20;
    private Tile[][] field = new Tile[size][size];
    private boolean mineStatus = false; // default mine tile status
    private int playerX = 0, playerY = 0; // Player starts at (0,0)
    public static int percentMined = 5; // % of tiles mined
    private boolean gameOver = false; // Track game state

    public Field() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Tile(i, j, mineStatus); // will need to reconfig this but just do the default now
            }
        }
        notifySubscribers("Field initialized");
    }
    public Tile getTile(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return field[x][y];
        } else {
            return null; // Handle out-of-bounds access safely
        }
    }
    // Move the player if the game is still running
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
        if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
            playerX = newX;
            playerY = newY;

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

}
