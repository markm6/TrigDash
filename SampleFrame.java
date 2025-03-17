import javax.swing.JFrame;

public class SampleFrame {

    public SampleFrame() {
        JFrame frame = new JFrame("Frame title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}