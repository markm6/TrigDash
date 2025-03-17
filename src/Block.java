public class Block {
    private int x;
    private int y;
    private boolean collidable;
    private int rotation;

    public Block(int x, int y, boolean canCollide, int rotation) {
        this.x = x;
        this.y = y;
        this.collidable = canCollide;
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCollidable() {
        return collidable;
    }
    public boolean collidingWithPlayer(Player player) {
        return false; // TODO: finish collidingWithPlayer(player)
    }

}
