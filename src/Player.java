public class Player {
    private double x;
    private double y;
    private boolean jumping;
    private double jumpVelocityY;
    private double jumpAccelerationY;
    private boolean orbHit;
    private boolean active;
    public Player(boolean active) {
        x = 0;
        y = 0;
        jumping = false;
        jumpAccelerationY = 0;
        jumpVelocityY = 0;
        orbHit = false;
        this.active = active;
    }

    public void update(boolean isInput) {
    }
}
