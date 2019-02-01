import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Tree {

    public static void mainDraw(Graphics graphics) {

        Branch branches = new Branch(Color.YELLOW);

        branches.drawBranches(graphics, 0, 0, 0, 0, WIDTH, HEIGHT, 9);

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
            super.setBackground(Color.BLACK);
            mainDraw(graphics);
        }
    }

    public static class Branch {
        Color drawColor;

        Branch(Color newDrawColor) {
            drawColor = newDrawColor;
        }

        public void drawBranches(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height, int size) {
            if (size != 1) {
                drawBranch(graphics, x1, y1, x2, y2, width, height);
                drawBranches(graphics, x1, y1, x2, y2 - 35, width, height, size - 1);
                drawBranches(graphics, x1, y1 - 45, x2 - 25, y2 - 30, width, height, size - 1);
                drawBranches(graphics, x1, y1 - 45, x2 + 25, y2 - 30, width, height, size - 1);
            }
        }

        public void drawBranch(Graphics graphics, int x1, int y1, int x2, int y2, int width, int height) {
            graphics.setColor(drawColor);
            graphics.drawLine(x1 + width / 2, y1 + height / 2 + height / 4, x2 + width / 2, y2 + height / 2 + height / 8);
            //graphics.drawLine(x1 + width / 2, y1 + height / 2 + height / 8, x2 + width / 2, y2 + height / 2 + height / 16);
        }
    }
}
