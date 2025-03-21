import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        SampleFrame frame = new SampleFrame();
        Level l = LevelLoader.load("src/level1.level");
        assert l != null;
        System.out.println(l.getObject(3, 3));
    }
}
