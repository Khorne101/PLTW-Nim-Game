import javax.swing.*;
import java.awt.event.*;
public class GLib {
    private JFrame frame;
    private Computer cpu; 
    private int menu, menuSel, menuItems;
    private JLabel line1, line2, line3, line4, line5, line6, line7;
    private JTextField entryBox;
    private boolean gameActive = false;
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
        line1 = new JLabel("----------------WELCOME-TO-NIM----------------");
        line2 = new JLabel();
        line3 = new JLabel();
        line4 = new JLabel();
        line5 = new JLabel();
        line6 = new JLabel();
        line7 = new JLabel();
        entryBox = new JTextField("Input number of sticks to take.");
        line1.setBounds(0, 12, 800, 12);
        line2.setBounds(0, 24, 800, 12);
        line3.setBounds(0, 36, 800, 12);
        line4.setBounds(0, 48, 800, 12);
        line5.setBounds(0, 60, 800, 12);
        line6.setBounds(0, 72, 800, 12);
        line7.setBounds(0, 84, 800, 12);
        entryBox.setBounds(0, 96, 800,20);
        frame.add(line1);frame.add(line2);frame.add(line3);frame.add(line4);frame.add(line5);frame.add(line6);frame.add(line7);frame.add(entryBox); // * adds labels
        line1.setVisible(true);line2.setVisible(true);line3.setVisible(true);line4.setVisible(true);line5.setVisible(true);line6.setVisible(true);line7.setVisible(true); // * sets lables visible
        entryBox.setVisible(false);
        updateMenu();
    }
    public void menu(String key) {
        if (!gameActive) {
            if (key.equals("down")) {
                if (menuSel+1 > menuItems) menuSel = 1;
                else menuSel += 1;
                updateMenu();
            } else if (key.equals("up")) {
                if (menuSel-1 < 1) menuSel = menuItems;
                else menuSel -= 1;
                updateMenu();
            } else if (key.equals("enter")) selectItem();
        }
    }
    public void updateMenu() {
        line3.setText("NUMBER OF PLAYERS");
        if (menu == 1) {
            if (menuSel == 1) {
                line4.setText("1 PLAYER <<");
                line5.setText("2 PLAYER");
            } else if (menuSel == 2) {
                line4.setText("1 PLAYER");
                line5.setText("2 PLAYER <<");
            }
        } else if (menu == 2) {
            line3.setText("SET DIFFICULTY");
            if (menuSel == 1) {
                line4.setText("EASY <<");
                line5.setText("MEDIUM");
                line6.setText("HARD");
            } else if (menuSel == 2) {
                line4.setText("EASY");
                line5.setText("MEDIUM <<");
                line6.setText("HARD");
            } else if (menuSel == 3) {
                line4.setText("EASY");
                line5.setText("MEDIUM");
                line6.setText("HARD <<");
            }
        }
    }
    public void selectItem() {
        if (menu == 1) {
            if (menuSel == 1) {
                cpu.computerActive(true);
                menu = 2;
                menuItems = 3;
                updateMenu();
            } else {
                cpu.computerActive(false);
                setupGame();
            }
        } else if (menu == 2) {
            if (menuSel == 1) {
                cpu.setDiff("easy");
            } else if (menuSel == 2) {
                cpu.setDiff("medium");
            } else {
                cpu.setDiff("hard");;
            }
            setupGame();
        }
    }
    public void displayMsg(String msg) {
        line6.setText(msg);
    }
    public void updateSticks(int sticks) {
        String sticksString = " ";
        for (int i = 0; i < sticks; i++) {
            sticksString += "| ";
        }
        line3.setText(sticksString);
        line4.setText("Sticks left: " + sticks);
    }
    public void setupGame() {
        clearScreen();
        if (!gameActive) {
            gameActive = true;
            updateSticks(Board.getSticks());
            entryBox.setVisible(true);
            entryBox.addActionListener(new ActionListenerNew(this));
        } else {
            updateSticks(Board.getSticks());
        }
    }
    public void clearScreen() {
        line2.setText("");
        line3.setText("");
        line4.setText("");
        line5.setText("");
        line6.setText("");
        line7.setText("");
    }
    public void parseInput() {
        String input = entryBox.getText();
        int inputSticks = Integer.parseInt(input);
        Game.runMove(inputSticks);
        entryBox.setText("");
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
class ActionListenerNew implements ActionListener {
    private GLib glib;
    public ActionListenerNew(GLib lib) {
        glib = lib;
    }
    public void actionPerformed(ActionEvent e) {  
         glib.parseInput();
    }  
}