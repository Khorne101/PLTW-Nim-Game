import java.util.Scanner;
public class Player {
    private String name;
    public Player() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player name:");
        name = sc.nextLine();
    }
}