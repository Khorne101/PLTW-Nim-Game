import javax.swing.*;
import java.awt.event.KeyEvent;
import java.net.SocketTimeoutException;
import java.awt.event.KeyAdapter;
public class GLib {
    private JFrame frame;
    private Computer cpu; 
    private int menu, menuSel, menuItems;
    private JLabel line1, line2, line3, line4, line5;
    public GLib(Computer computer) {
        cpu = computer;
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addKeyListener(new KeyListener(this));
        menu = 1;
        menuSel = 1;
        menuItems = 2;
        // * creation of the menu lines;
        line1 = new JLabel("hi");
        line2 = new JLabel("hello");
        line3 = new JLabel("hewo");
        line4 = new JLabel("hewu");
        line5 = new JLabel("hai");
        line1.setBounds(0, 0, 800, 12);
        line2.setBounds(0, 12, 800, 12);
        line3.setBounds(0, 24, 800, 12);
        line4.setBounds(0, 36, 800, 12);
        line5.setBounds(0, 48, 800, 12);
        frame.add(line1);frame.add(line2);frame.add(line3);frame.add(line4);frame.add(line5); // * adds labels
        line1.setVisible(true);line2.setVisible(true);line3.setVisible(true);line4.setVisible(true);line5.setVisible(true); // * sets lables visible
    }
    public void menu(String key) {
        if (key.equals("up")) {
            if (menuSel++ > menuItems) menuSel = 1;
            else menuSel += 1;
            updateMenu();
        } else if (key.equals("down")) {
            if (menuSel-- < menuItems) menuSel = menuItems;
            else menuSel -= 1;
            updateMenu();
        } else if (key.equals("enter")) selectItem();
    }
    public void updateMenu() {

    }
    public void selectItem() {
        if (menu == 1) {
            if (menuSel == 1) {
                cpu.computerActive(true);
                menu = 2;
                updateMenu()
            } else cpu.computerActive(false);
        } else (menu == 2) {

        }
    }
    public void displayMsg(String msg) {
        line5.setText(msg);
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
        if (code == KeyEvent.VK_ENTER) glib.menu("enter");
    }
}