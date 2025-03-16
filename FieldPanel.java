package mineField;

import mvc.AppPanel;

import java.awt.*;

public class FieldPanel extends AppPanel {
    private Field field;
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
        FieldFactory factory = new FieldFactory();
        AppPanel panel = new FieldPanel(factory);
        panel.display();
    }
}
