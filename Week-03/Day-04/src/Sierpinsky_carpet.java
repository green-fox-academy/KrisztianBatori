import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Sierpinsky_carpet {

    static Color[] rainbowColors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE};

    public static void mainDraw(Graphics graphics) {

        drawSquares(graphics, WIDTH / 3, HEIGHT / 3, WIDTH / 3, HEIGHT / 3, 6, 0);

    }
    public static void drawSquares (Graphics graphics, int x, int y, int width, int height, int size, int colorIndex) {
        if (size != 1) {
            drawSquare(graphics, x, y, width, height, colorIndex);
            drawSquares(graphics, x - width + width / 3, y - height / 3 - height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x - width + width / 3, y + height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x - width + width / 3, y + height + height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x + width + width / 3, y - height / 3 - height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x + width + width / 3, y + height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x + width + width / 3, y + height + height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x + width / 3, y + height + height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
            drawSquares(graphics, x + width / 3, y - height / 3 - height / 3, width / 3, height / 3, size - 1, colorIndex + 1);
        }
    }

    public static void drawSquare(Graphics graphics, int x, int y, int width, int height, int colorIndex) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, width, height);
        graphics.setColor(rainbowColors[colorIndex]);
        graphics.fillRect(x, y, width, height);
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
}