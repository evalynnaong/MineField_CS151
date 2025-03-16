package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends AppPanel {
    private Field field;
    private JPanel keys; // my control panel
    private FieldView view;


    public FieldPanel(FieldFactory factory) {
        super(factory);
        field = (Field) factory.makeModel();
        view = new FieldView(field);

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        AppFactory factory = new FieldFactory();
        AppPanel panel = new FieldPanel((FieldFactory) factory);
        panel.display();
    }
}
