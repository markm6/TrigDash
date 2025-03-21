public class Level {
    private int xPosition;
    private LevelObject[][] levelObjects;
    private String name;
    public Level(String name, LevelObject[][] levelObjects) {
        this.levelObjects = levelObjects;
        this.name = name;
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

    public void render() {
        for (int i = 0; i < levelObjects.length; i++) {
            for (int j = 0; j < levelObjects[i].length; j++) {
                levelObjects[i][j].render();
            }
        }
    }
}