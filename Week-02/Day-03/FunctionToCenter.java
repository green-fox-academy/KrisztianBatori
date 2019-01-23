import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int i = 20; i <= 300; i += 20) {
            lineDrawing(graphics, i, 20);
            lineDrawing(graphics, i, 300);
            lineDrawing(graphics, 20, i);
            lineDrawing(graphics, 300, i);
        }
    }
    public static void lineDrawing(Graphics graphics, int x, int y) {
        graphics.drawLine(x, y, WIDTH/2, HEIGHT/2);
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