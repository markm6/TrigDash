public class Spike extends LevelObject {
    public Spike(int x, int y) {
        super(1, x, y, true, 0);
    }

    @Override
    public boolean collidingWithPlayer(Player player) {
        return true; // stub
        // Note: spikes have different hitboxes than other objects
    }
}
