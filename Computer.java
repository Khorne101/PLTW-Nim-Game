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
            Game.runMove((int) Math.floor((Math.random()*((sticks/2)+1))+1));
        } else if (difficulty == "medium") {
            if (7 < sticks && sticks < 14) {
                Game.runMove(sticks-7);
            } else if (sticks == 7) {
                Game.runMove(1);
            } else if (sticks == 6) {
                Game.runMove(3);
            } else if (sticks == 5) {
                Game.runMove(2);
            } else if (sticks == 4 || sticks == 3 || sticks == 2) {
                Game.runMove(1);
            } else {
                Game.runMove((int) Math.floor((Math.random()*((sticks/2)+1))+1));
            }
        } else if (difficulty == "hard") {
            if (31 < sticks) {
                Game.runMove(sticks-31);
            } else if (15 < sticks && sticks < 31) {
                Game.runMove(sticks-15);
            } else if (7 < sticks && sticks < 14) {
                Game.runMove(sticks-7);
            } else if (sticks == 7) {
                Game.runMove(1);
            } else if (sticks == 6) {
                Game.runMove(3);
            } else if (sticks == 5) {
                Game.runMove(2);
            } else if (sticks == 4 || sticks == 3 || sticks == 2) {
                Game.runMove(1);
            } else {
                Game.runMove((int) Math.floor((Math.random()*((sticks/2)+1))+1));
            }
        }
    }
}