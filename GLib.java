import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
public class GLib {
    private JFrame frame;
    private int menuSel;
    private int menuItems;
    private JLabel line1;
    private JLabel line2;
    private JLabel line3;
    private JLabel line4;
    private JLabel line5;
    public GLib() {
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addKeyListener(new KeyListener(this));
        menuSel = 1;
        menuItems = 2;
        // * creation of the menu lines;
        line1 = new JLabel("hi");
        line2 = new JLabel("hello");
        line3 = new JLabel("hewo");
        line4 = new JLabel("hewu");
        line5 = new JLabel("hai");
        frame.add(line1);frame.add(line2);frame.add(line3);frame.add(line4);frame.add(line5); // * adds labels
        line1.setVisible(true);line2.setVisible(true);line3.setVisible(true);line4.setVisible(true);line5.setVisible(true); // * sets lables visible
    }
    public void menu(String key) {
        if (key.equals("up")) {
            if (menuSel++ > menuItems) {
                menuSel = 1;
            } else {
                menuSel += 1;
            }
            updateMenu();
        } else if (key.equals("down")) {
            if (menuSel-- < menuItems) {
                menuSel = menuItems;
            } else {
                menuSel -= 1;
            }
            updateMenu();
        }
    }
    public void updateMenu() {
    }
}

class KeyListener extends KeyAdapter {
    private GLib glib;
    public KeyListener(GLib lib) {
        glib = lib;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) glib.menu("up");
        if (code == KeyEvent.VK_DOWN) glib.menu("down");
    }
}