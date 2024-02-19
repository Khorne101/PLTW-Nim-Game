
public class Computer {
    private boolean active;
    private String difficulty;

    public Computer() {
    }

    public void computerActive(boolean isActive) {
        active = isActive;
    }

    public boolean isActive() {
        return active;
    }

    public void setDiff(String diff) {
        difficulty = diff;
    }

    public void turn(int player, int sticks) {
        if (difficulty == "easy") {
            Game.runMove((int) Math.floor((Math.random() * ((sticks / 2) + 1)) + 1));
        } else if (difficulty == "medium") {
            if (7 < sticks && sticks < 14) {
                Game.runMove(sticks - 7);
            } else {
                switch (sticks) {
                    case 6:
                        Game.runMove(3);
                        break;
                    case 5:
                        Game.runMove(2);
                        break;
                    case 7:
                    case 4:
                    case 3:
                    case 2:
                        Game.runMove(1);
                        break;
                    default:
                        Game.runMove((int) Math.floor((Math.random() * ((sticks / 2) + 1)) + 1));
                        break;
                }
                ;
            }
        } else if (difficulty == "hard") {
            if (31 < sticks) {
                Game.runMove(sticks - 31);
            } else if (15 < sticks && sticks < 31) {
                Game.runMove(sticks - 15);
            } else if (7 < sticks && sticks < 14) {
                Game.runMove(sticks - 7);
            } else {
                switch (sticks) {
                    case 6:
                        Game.runMove(3);
                        break;
                    case 5:
                        Game.runMove(2);
                        break;
                    case 7:
                    case 4:
                    case 3:
                    case 2:
                        Game.runMove(1);
                        break;
                    default:
                        Game.runMove((int) Math.floor((Math.random() * ((sticks / 2) + 1)) + 1));
                        break;
                }
                ;
            }
        }
    }
}