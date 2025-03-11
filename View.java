package tools;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JPanel implements Subscriber{
    private Model model;

    public View(Model model){}

    public void update(String message) {
        repaint();
    }

    public void setModel(Model newModel) {
        model.unsubscribe(this);
        model = newModel;
        model.subscribe(this);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
    }
}
