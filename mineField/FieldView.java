package mineField;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class FieldView extends View {
    private static final int SIZE = 20;
    private JLabel[][] tiles = new JLabel[SIZE][SIZE];
    private Field field;

    public FieldView(Model field) {
        super(field);
        this.field = (Field) field;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));

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
    }

    public void refresh() {
        System.out.println("repaint being called");
        // Reset grid
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(field.getTile(j,i).getStepStatus()){
                    tiles[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    tiles[i][j].setBackground(Color.DARK_GRAY);
                }
            }
        }

        // Highlight player position
        int x = field.getPlayerY();
        int y = field.getPlayerX();
        tiles[x][y].setBackground(Color.WHITE);

        // If game over, highlight mine
        Tile tile = field.getTile(x, y);
        if (tile != null && tile.getMineStatus()) {
            tiles[x][y].setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Game Over! You hit a mine.");
        }

        System.out.println("refresh working");
    }

    @Override
    public void update(String message) {
        System.out.println("update being caught");
        refresh();
    }

    /*@Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        gc.setColor(Color.LIGHT_GRAY);
        gc.fillRect(0, 0, getWidth(), getHeight()); // Background fill
    }*/

}
