import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps {
    public static void mainDraw(Graphics graphics) {
        for (int i = 1; i <= 19; i++) {
            squareDrawing(graphics, i*10, i*10, 100);
        }
    }
    public static void squareDrawing(Graphics graphics, int x1, int y1, int size) {
        graphics.setColor(new Color(150,85,211));
        graphics.fillRect(x1, y1, size/10, size/10);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x1, y1, size/10, size/10);
    }

    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}
