package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class FieldPanel extends AppPanel {
    //private JPanel keys;

    JButton b1 = new JButton("N");
    JButton b2 = new JButton("S");
    JButton b3 = new JButton("E");
    JButton b4 = new JButton("W");
    JButton b5 = new JButton("NE");
    JButton b6 = new JButton("NW");
    JButton b7 = new JButton("SE");
    JButton b8 = new JButton("SW");

    /*private void layout3() {

        setLayout(new BorderLayout());
        //JPanel keys = new JPanel();
        JPanel p = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 3));
        controlPanel.setPreferredSize(new Dimension(80, 400));

        p = new JPanel();
        p.add(b1);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b2);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b3);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b4);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b5);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b6);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b7);
        controlPanel.add(p);

        p = new JPanel();
        p.add(b8);
        controlPanel.add(p);

        add(controlPanel);
    }*/

    /*public void setListeners() {

        b1.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"N");
            moveCommand.execute();
            view.update("");
        });
        b2.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"S");
            moveCommand.execute();
            view.update("");
        });
        b3.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"E");
            moveCommand.execute();
            view.update("");
        });
        b4.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"W");
            moveCommand.execute();
            view.update("");
        });
        b5.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"NE");
            moveCommand.execute();
            view.update("");
        });
        b6.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"NW");
            moveCommand.execute();
            view.update("");
        });
        b7.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"SE");
            moveCommand.execute();
            view.update("");
        });
        b8.addActionListener(e -> {
            Move moveCommand = new Move(this.getModel(),"SW");
            moveCommand.execute();
            view.update("");
        });
    }*/

   /* public FieldPanel(AppFactory factory) {
        super(factory);

        if (getModel() == null) {
            setModel(factory.makeModel());
        }

        this.setLayout(new BorderLayout());

        layout3();
        setListeners();

        //this.add(view, BorderLayout.EAST);

        this.revalidate();
        this.update();

    }*/

    public FieldPanel(AppFactory factory) {
        super(factory);

        b1.addActionListener(this);
        controlPanel.add(b1);

        b2.addActionListener(this);
        controlPanel.add(b2);

        b3.addActionListener(this);
        controlPanel.add(b3);

        b4.addActionListener(this);
        controlPanel.add(b4);

        b5.addActionListener(this);
        controlPanel.add(b5);

        b6.addActionListener(this);
        controlPanel.add(b6);

        b7.addActionListener(this);
        controlPanel.add(b7);

        b8.addActionListener(this);
        controlPanel.add(b8);

    }

    public static void main(String[] args) {
        FieldFactory factory = new FieldFactory();
        AppPanel panel = new FieldPanel(factory);
        panel.display();
    }
}
