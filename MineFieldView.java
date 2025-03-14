package MineField;

import tools.KeyPad;
import tools.Publisher;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends JPanel {
    private static final int SIZE = 20;
    private JLabel[][] tiles = new JLabel[SIZE][SIZE];
    private Field field;

    public MineFieldView(Field field) {
        this.field = field;
        field.subscribe(this::updateView); // Listen for game updates

        setLayout(new BorderLayout());

        // Add movement buttons (KeyPad) on the left
        KeyPad keyPad = new KeyPad();
        keyPad.setMovementListener(this::handleMove);
        add(keyPad, BorderLayout.WEST);

        // Create minefield grid panel
        JPanel minefieldPanel = new JPanel(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = new JLabel("?", SwingConstants.CENTER);
                tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tiles[i][j].setOpaque(true);
                tiles[i][j].setBackground(Color.DARK_GRAY);
                minefieldPanel.add(tiles[i][j]);
            }
        }
        add(minefieldPanel, BorderLayout.CENTER);

        updateView("Game started");
    }

    private void handleMove(String direction) {
        boolean moved = field.movePlayer(direction);
        if (moved) {
            updateView("Moved " + direction);
        }
    }

    private void updateView(String message) {
        // Reset grid
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j].setBackground(Color.DARK_GRAY);
            }
        }

        // Highlight player position
        int x = field.getPlayerX();
        int y = field.getPlayerY();
        tiles[x][y].setBackground(Color.WHITE);

        // If game over, highlight mine
        Tile tile = field.getTile(x, y);
        if (tile != null && tile.getMineStatus()) {
            tiles[x][y].setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Game Over! You hit a mine.");
        }
    }

    public static void main(String[] args) {
        Field field = new Field();

        JFrame frame = new JFrame("Mine Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);

        MineFieldView view = new MineFieldView(field);
        frame.add(view);
        frame.setVisible(true);
    }
}
