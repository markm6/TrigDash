public class Level {
    private int xPosition;
    private LevelObject[][] levelObjects;
    public Level(LevelObject[][] levelObjects) {
        this.levelObjects = levelObjects;
        xPosition = 0;
    }
    public void updatePosition() {
        xPosition += 2;
    }

    public int getxPosition() {
        return xPosition;
    }
    public LevelObject getObject(int x, int y) {
        // TODO: add out-of-bound checking
        return levelObjects[y][x];
    }
}