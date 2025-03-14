package MineField;

import tools.Subscriber;
import tools.View;

import java.awt.*;

public class FieldView extends View implements Subscriber {
    private Field field;
    private final int cellSize = 20;

    public FieldView (Field field) {
        super(field);
        this.field = field;
        field.subscribe(this);
        repaint();
    }

    public void setFieldView(Field newField) {
        field.unsubscribe(this);
        field = newField;
        field.subscribe(this);
        repaint();
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        int rows = field.getSize();
        int cols = field.getSize();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tile tile = field.getTile(i, j); // Assuming Field has a method to get a Cell
                gc.setColor(Color.lightGray);

                int x = j * cellSize;
                int y = i * cellSize;

                gc.fillRect(x, y, cellSize, cellSize);
                gc.setColor(Color.BLACK);
                gc.drawRect(x, y, cellSize, cellSize);

                if (tile.getStepStatus()) {
                    int mines = field.getAdjacentMines(i, j);
                    if (mines > 0) {
                        gc.setColor(Color.BLACK);
                        gc.drawString(String.valueOf(mines), x + cellSize / 2 - 5, y + cellSize / 2 + 5);
                    }
                }
            }
        }
    }
}
