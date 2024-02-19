
public class Board {
    private static int numberOfSticks;

    public static void populate() {
        numberOfSticks = (int) Math.floor((Math.random() * 41) + 14);
    }

    public static int getSticks() {
        return numberOfSticks;
    }
}