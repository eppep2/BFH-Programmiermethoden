package folien.topic01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class AwtExample extends Frame {
    public AwtExample() {
        // Set title and size
        this.setTitle("AWT Example");
        this.setBounds(100, 100, 200, 80);

        // Create a panel and add it to the frame
        Panel p = new Panel(); this.add(p);

        // Create a label and a text field and add them to the panel
        Label l = new Label("Name"); p.add(l);
        TextField t = new TextField(10); p.add(t);

        // Create a button and add it to the frame
        Button b = new Button("Quit");
        this.add(b, BorderLayout.SOUTH);
    }
    public static void main(String argv[]) {
        AwtExample frame = new AwtExample();
        frame.setVisible(true);
    }
}
