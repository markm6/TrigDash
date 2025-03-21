import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class LevelLoader {

    private static LevelObject parseObject(String chr, int x, int y) {
        if (chr.equals("S")) {
            return new Spike(x, y);
        } else if (chr.equals("B")) {
            return new DefaultBlock(x, y);
        } else if (chr.equals("b")) {
            return new BackgroundBlock(x, y);
        } else {
            return null;
        }
    }

    public static Level load(String levelPath) throws IOException {
        int yLength = 0;
        int xLength = 0;
        try (Stream<String> stream = Files.lines(Paths.get(levelPath))) {
            //Lines count
            yLength = (int) stream.count();
        }
        try {
            File levelFile = new File(levelPath);
            Scanner scanner = new Scanner(levelFile);
            scanner.nextLine();
            scanner.nextLine();
            xLength = scanner.nextLine().length();
        } catch (Exception e) {
            return null;
        }
        LevelObject[][] objects = new LevelObject[yLength][xLength];
        String title = "";
        try {
            File levelFile = new File(levelPath);
            Scanner scanner = new Scanner(levelFile);
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.charAt(0) == ':') {
                    title = line.substring(1);
                    continue;
                }
                System.out.println(line.length());
                for (int x = 0; x < line.length() - 1; x++) {

                    try {
                        int l = objects.length;
                    } catch (NullPointerException e) {
                        objects = new LevelObject[yLength][line.length()];
                    }
                    int y = yLength - i - 1;
                    String chr = line.substring(x, x + 1);
                    LevelObject obj = parseObject(chr, x, y);
                    System.out.println(x);
                    System.out.println(i);
                    objects[i][x] = obj;
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return null;
        }

        return new Level(title, objects);

    }
}
