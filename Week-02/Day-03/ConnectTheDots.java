import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        lineDrawing(graphics, new int[][] {{10, 10}, {290, 10}, {290, 290}, {10, 290}, {10, 10}}); // {10, 10} had to be added for the final side.
        lineDrawing(graphics, new int[][] {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}});
    }
    public static void lineDrawing(Graphics graphics, int[][] points) {
        for (int i = 0; i < points.length - 1; i++) {
            graphics.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
        }
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
