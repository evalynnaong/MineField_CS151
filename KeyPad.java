package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyPad extends JPanel implements ActionListener {
    JButton b1 = new JButton("NW");
    JButton b2 = new JButton("N");
    JButton b3 = new JButton("NE");
    JButton b4 = new JButton("W");
    JButton b5 = new JButton("E");
    JButton b6 = new JButton("SW");
    JButton b7 = new JButton("S");
    JButton b8 = new JButton("SE");

    private void layout1() {
        //add(display);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
    }

    private void layout2() {

        setLayout(new BorderLayout());
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        keys.add(b1);
        keys.add(b2);
        keys.add(b3);
        keys.add(b4);
        keys.add(b5);
        keys.add(b6);
        keys.add(b7);
        keys.add(b8);

        //add(keys, "South");
        add(keys, "Center");
    }


    private void layout3() {

        setLayout(new BorderLayout());
        JPanel keys = new JPanel();
        JPanel p = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        p = new JPanel();
        p.add(b1);
        keys.add(p);

        p = new JPanel();
        p.add(b2);
        keys.add(p);

        p = new JPanel();
        p.add(b3);
        keys.add(p);

        p = new JPanel();
        p.add(b4);
        keys.add(p);

        p = new JPanel();
        p.add(b5);
        keys.add(p);

        p = new JPanel();
        p.add(b6);
        keys.add(p);

        p = new JPanel();
        p.add(b7);
        keys.add(p);

        p = new JPanel();
        p.add(b8);
        keys.add(p);

        add(keys);
    }

    public void setListeners() {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
    }

    // Define a functional interface for movement actions
    public interface MovementListener {
        void move(String direction);
    }

    private MovementListener movementListener; // Variable to hold the listener

    // Method to set movement listener
    public void setMovementListener(MovementListener listener) {
        this.movementListener = listener;
    }

    public KeyPad() {
        //layout1();
        //layout2();
        layout3();
        setListeners();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setTitle("Key Pad");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        KeyPad kp = new KeyPad();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (movementListener != null) {
            movementListener.move(e.getActionCommand()); // Pass movement direction to the listener
        }
    }


}
