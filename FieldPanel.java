package MineField;

import tools.AppFactory;
import tools.AppPanel;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends AppPanel {
    private Field field;
    private JPanel keys; // my control panel
    private FieldView view;


    JButton N = new JButton("N");
    JButton S = new JButton("S");
    JButton E = new JButton("E");
    JButton W = new JButton("W");
    JButton NE = new JButton("NE");
    JButton NW = new JButton("NW");
    JButton SE = new JButton("SE");
    JButton SW = new JButton("SW");

    private void layout3() {

        //setLayout(new BorderLayout());
        JPanel p = new JPanel();
        //JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 2));

        p = new JPanel();
        p.add(N);
        keys.add(p);

        p = new JPanel();
        p.add(S);
        keys.add(p);

        p = new JPanel();
        p.add(E);
        keys.add(p);

        p = new JPanel();
        p.add(W);
        keys.add(p);

        p = new JPanel();
        p.add(NE);
        keys.add(p);

        p = new JPanel();
        p.add(NW);
        keys.add(p);

        p = new JPanel();
        p.add(SE);
        keys.add(p);

        p = new JPanel();
        p.add(SW);
        keys.add(p);

        add(keys);
    }

    public void setListeners() {
        /*JFrame colorFrame = new JFrame();
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = colorFrame.getContentPane();
        cp.add(this);

        colorFrame.setVisible(true); */

        N.addActionListener(e -> field.move("N"));
        S.addActionListener(e -> field.move("S"));
        E.addActionListener(e -> field.move("E"));
        W.addActionListener(e -> field.move("W"));
        NE.addActionListener(e -> field.move("NE"));
        NW.addActionListener(e -> field.move("NW"));
        SE.addActionListener(e -> field.move("SE"));
        SW.addActionListener(e -> field.move("SW"));
    }

    public FieldPanel(AppFactory factory) {
        super(factory);
        field = (Field) factory.makeModel();
        view = new FieldView(field);
        keys = new JPanel(new GridLayout(3,3));
        layout3();
        setListeners();

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        add(keys, BorderLayout.WEST);
        setVisible(true);
    }

    public static void main(String[] args) {
        AppFactory factory = new FieldFactory();
        AppPanel panel = new FieldPanel(factory);
        panel.display();
    }
}
