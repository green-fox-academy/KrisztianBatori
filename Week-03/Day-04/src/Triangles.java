import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

    public static void mainDraw(Graphics graphics) {

        Triangle triangle = new Triangle(new Color[] {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.BLUE, new Color(128, 0, 128),
                new Color(238, 130, 238)}, graphics);

        triangle.drawTriangles(graphics, 0, 0, 0, 0, WIDTH, HEIGHT, 7);
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
            super.setBackground(Color.GRAY);
            mainDraw(graphics);
        }
    }

    public static class Triangle {
        Color[] fillColors;

        Triangle (Color[] newFillColors, Graphics graphics) {
            fillColors = newFillColors;

            Polygon triangle = new Polygon( new int[] { 0, 0, 0, WIDTH, WIDTH / 2, WIDTH}, new int[] { 0, 0, 0, 0, HEIGHT, HEIGHT * 2}, 6);
            graphics.drawPolygon(triangle);
            graphics.setColor(fillColors[6]);
            graphics.fillPolygon(triangle);
            graphics.setColor(Color.BLACK);
        }

        public void drawTriangle(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height, Color fillColor) {
            Polygon triangle = new Polygon(
                    new int[] {
                            x1 + width / 4,
                            x1 + width / 2,
                            x1 + width / 4,
                            x2 + width / 2,
                            x2 + width / 2 + width / 4,
                            x2 + width / 2 + width / 4},
                    new int[] {
                            y1 + height / 2,
                            y1,
                            y1 + height / 2,
                            y2,
                            y2 + height / 2,
                            y2 + height / 2},
                    6);

            graphics.drawPolygon(triangle);
            graphics.setColor(fillColor);
            graphics.fillPolygon(triangle);
            graphics.setColor(Color.BLACK);
        }

        public void drawTriangles(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height, int size) {
            if (size != 1) {
                drawTriangle(graphics, x1, y1, x2, y2, width, height, fillColors[size - 2]);
                drawTriangles(graphics, x1, y1, x2, y2, width / 2, height / 2, size - 1);
                drawTriangles(graphics, x1 + width / 2, y1, x2 + width / 2, y2, width / 2, height / 2, size - 1);
                drawTriangles(graphics, x1 + width / 4, y1 + height / 2, x2 + width / 4, y2 + height / 2, width / 2, height / 2, size -1);
            }
        }
    }
}
