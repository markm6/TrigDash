public class Level {
    private int xPosition;
    private Block[][] blocks;
    public Level(Block[][] blocks) {
        this.blocks = blocks;
        xPosition = 0;
    }
    public void updatePosition() {
        xPosition += 2;
    }

    public int getxPosition() {
        return xPosition;
    }
    public Block getBlock(int x, int y) {
        // TODO: add out-of-bound checking
        return blocks[y][x];
    }
}