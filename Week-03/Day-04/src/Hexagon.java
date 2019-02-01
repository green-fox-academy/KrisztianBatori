import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {

    static Color[] rainbowColors = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE, new Color(128, 0, 128),
            new Color(238, 130, 238)};

    public static void mainDraw(Graphics graphics) {
        drawHexagons(graphics, 0, 0, 0, 0, WIDTH, HEIGHT, 2);
    }

    public static void drawHexagons(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height, int size) {
        if (size != 1) {
            drawHexagon(graphics, x1, y1, x2, y2, width, height, rainbowColors[size - 2]);
            //drawHexagons(graphics, x1, y1, x2, y2, width / 2, height / 2, size - 1);
            //drawHexagons(graphics, x1 + width / 2, y1, x2 + width / 2, y2, width / 2, height / 2, size - 1);
            //drawHexagons(graphics, x1 + width / 4, y1 + height / 2, x2 + width / 4, y2 + height / 2, width / 2, height / 2, size -1);
        }
    }

    public static void drawHexagon(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height, Color fillColor) {
        Polygon hexagon = new Polygon(
                new int[]{5, 20, 20, 40, 40, 60, 60, 40, 40, 20, 20, 5},
                new int[]{180, 5, 5, 5, 5, 180, 180, 360, 360, 360, 360, 5},
                12);

        graphics.drawPolygon(hexagon);
        graphics.setColor(fillColor);
        graphics.fillPolygon(hexagon);
        graphics.setColor(Color.BLACK);
    }

    static int WIDTH = 512;
    static int HEIGHT = 512;

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