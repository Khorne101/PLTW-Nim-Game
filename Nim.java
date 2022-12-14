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
    System.out.println("Welcome to the Game of Nim! Second player name is not required for 1 player games!");

    Board.populate(); // static method call
    
    Game nim = new Game(); 
    nim.play();
  }
}