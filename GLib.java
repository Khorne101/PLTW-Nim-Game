import javax.swing.*;
import java.awt.KeyEvent;
import java.awt.KeyAdapter;
public class GLib {
    private JFrame frame;
    public GLib() {
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
class KeyListener extends KeyAdapter {
    @Override
}