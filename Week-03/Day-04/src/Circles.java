import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

    static Color[] rainbowColors = new Color[] {Color.RED, Color.ORANGE, Color.BLACK,
            Color.MAGENTA, Color.BLUE};

    public static void mainDraw(Graphics graphics) {

        Circle circle = new Circle(new Color[] {Color.RED, Color.ORANGE, Color.BLACK,
                Color.MAGENTA, Color.BLUE});

        circle.drawCircles(graphics, 0, 0, WIDTH, HEIGHT, 6, 0);

    }

    static int WIDTH = 486;
    static int HEIGHT = 486;

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
            super.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }

    public static class Circle {
        Color[] drawColors;

        Circle(Color[] newDrawColors) {
            drawColors = newDrawColors;
        }

        public void drawCircles (Graphics graphics, int x, int y, int width, int height, int size, int colorIndex) {
            if (size != 1) {
                drawCircle(graphics, x, y, width, height, colorIndex);
                drawCircles(graphics, x + width / 4, y, width / 2, height / 2, size - 1, colorIndex + 1);
                drawCircles(graphics, x + width / 58, y + height / 3, width / 2, height / 2, size - 1, colorIndex + 1);
                drawCircles(graphics, x + width / 2 - width / 58, y + height / 3, width / 2, height / 2, size - 1, colorIndex + 1);
            }
        }

        public void drawCircle(Graphics graphics, int x, int y, int width, int height, int colorIndex) {
            graphics.setColor(rainbowColors[colorIndex]);
            graphics.drawOval(x, y, width, height);
        }
    }
}