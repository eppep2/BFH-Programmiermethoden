package folien.topic01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingExample extends JFrame {
    public SwingExample() {
        // Set title and size
        this.setTitle("Swing Example");
        this.setBounds(100, 100, 200, 80);

        // Create a panel and add it to the frame
        JPanel p = new JPanel(); this.add(p);

        // Create a label and a text field and add them to the panel
        JLabel l = new JLabel("Name"); p.add(l);
        JTextField t = new JTextField(10); p.add(t);

        // Create a button and add it to the frame
        JButton b = new JButton("Quit");
        this.add(b, BorderLayout.SOUTH);
    }
    public static void main(String argv[]) {
        SwingExample jFrame = new SwingExample();
        jFrame.setVisible(true);
    }
}
