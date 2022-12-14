import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class Test {
 
    public static void main(String[] argv) throws Exception {

  JTextField text = new JTextField();
 
  JFrame jframe = new JFrame();

  jframe.add(text);
 
  jframe.addKeyListener(new KeyListener());
 
  jframe.setSize(320,200);
 
  jframe.setVisible(true);
 
    }
}