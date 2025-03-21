import java.awt.Image;

public class LevelObject {
    private int x;
    private int y;
    private int scaledX;
    private int scaledY;
    private boolean collidable;
    private int rotation;
    private Image image;

    public LevelObject(int spriteIndex, int x, int y, boolean canCollide, int rotation) {
        this.x = x;
        this.y = y;
        // for rendering
        this.scaledX = x * 15;
        this.scaledY = y * 15;
        this.collidable = canCollide;
        this.rotation = rotation;
        this.image = SpriteHandler.getInstance().getImage(spriteIndex);
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

    public int getScaledX() {
        return scaledX;
    }

    public int getScaledY() {
        return scaledY;
    }

    public boolean isCollidable() {
        return collidable;
    }
    public boolean collidingWithPlayer(Player player) {
        return false; // TODO: finish collidingWithPlayer(player)
    }

    public Image getImage() {
        return image;
    }

    // TODO: Render function with screen parameter.

    public void render() {
        
    }

}
