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
        }
        if (difficulty == "medium") {

        }
    }
}