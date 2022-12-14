public class Game {
    private static GLib gui;
    private static boolean computerFirst;
    private static Computer cpu;
    private static Player player1, player2;
    public Game() {
    }
    public void play() {
        player1 = new Player();
        player2 = new Player();
        cpu = new Computer();
        gui = new GLib(cpu);
    }
    public static int runMove(int player, int move) {
        int sticks = Board.getSticks();
        if (move > sticks/2) {
            gui.displayMsg("You can't take that many sticks, only up to half of the sticks left not over!");
            return 0;
        } 
    }
    public static void startGame() {
        if (cpu.isActive()) {
            if (Math.round(Math.random()*1.1) == 0) {
                computerFirst = false;
            } else {
                computerFirst = true;
            }
        } else ()
    }
}