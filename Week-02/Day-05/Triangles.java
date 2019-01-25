import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int j = 21; j >= 0; j--) {
            lineLeftToRight(graphics, j, j);
        }
    }
    public static void lineLeftToRight (Graphics graphics, int x2, int y2) {
        graphics.drawLine(WIDTH - x2*20, 350, WIDTH - x2*10, 350 - y2*15);
        graphics.drawLine(WIDTH - x2*20, 350, (WIDTH/2) - x2*10, 35 + y2*15);
        graphics.drawLine(x2*10, 350 - y2*15, WIDTH - x2*10, 350 - y2*15);
    }

    static int WIDTH = 420;
    static int HEIGHT = 420;

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
