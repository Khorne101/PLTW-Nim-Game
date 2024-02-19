
import java.util.concurrent.*;

public class Game {
    private static GLib gui;
    private static boolean computerFirst;
    private static Computer cpu;
    // private static Player player1, player2;
    private static Boolean player1first = false;
    private static int sticks;
    private static int player;

    public Game() {
    }

    public void play() {
        // player1 = new Player();
        // player2 = new Player();
        cpu = new Computer();
        gui = new GLib(cpu);
        sticks = Board.getSticks();
    }

    public static void runMove(int move) {
        if (move > sticks / 2) {
            gui.displayMsg("You can't take that many sticks, only up to half of the sticks left not over!");
        } else if ((sticks - move) == 1) {
            if (cpu.isActive()) {
                if (player == 1 && computerFirst) {
                    gui.displayMsg("CPU has won!");
                } else if (player == 2 && !computerFirst) {
                    gui.displayMsg("CPU has won!");
                } else {
                    gui.displayMsg("Player has won!");
                }
            } else {
                gui.displayMsg("Player " + player + " Has won!");
            }
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            Runnable task2 = () -> startGame();
            ses.schedule(task2, 2, TimeUnit.SECONDS);
            ses.shutdown();
        } else {
            sticks -= move;
            gui.updateSticks(sticks);
            player = (player == 1) ? 2 : 1;
            if (cpu.isActive()) {
                gui.displayMsg("Player go.");
                if (player == 1 && computerFirst) {
                    cpu.turn(1, sticks);
                } else if (player == 2 && !computerFirst) {
                    cpu.turn(2, sticks);
                }
            } else {
                gui.displayMsg("Player " + player + " go.");
            }
        }
    }

    public static void startGame() {
        player = 1;
        if (cpu.isActive()) {
            if (Math.round(Math.random() * 1.1) == 0) {
                computerFirst = false;
                gui.displayMsg("CPU goes second");
                System.out.println("CPU SECOND");
            } else {
                computerFirst = true;
                gui.displayMsg("CPU goes first");
                System.out.println("CPU FIRST");
            }
        } else if (!cpu.isActive()) {
            if (Math.round(Math.random() * 1.1) == 0) {
                player1first = true;
                gui.displayMsg("Player 1 goes first.");
            } else {
                player1first = false;
                gui.displayMsg("Player 2 goes first");
            }
        }
        Board.populate();
        sticks = Board.getSticks();
        gui.setupGame();
    }

    public static boolean isFirstPlayerFirst() {
        return player1first;
    }
}