/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim 
*/
import java.io.IOException;
public class Nim
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
    System.out.println("Welcome to the Game of Nim");

    Board.populate(); // static method call
    
    Game nim = new Game(); 
    nim.play();
  }
}