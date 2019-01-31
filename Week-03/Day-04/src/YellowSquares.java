import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class YellowSquares {
    public static void mainDraw(Graphics graphics) {

        drawSquares(graphics, 0, 0, 486, 486);
        
    }
    public static void drawSquares (Graphics graphics, int x, int y, int width, int height) {
        if (width == 2 && height == 2) {
            drawSquare(graphics, x, y, width, height);
        }
        else {
            drawSquare(graphics, x, y, width, height);
            drawSquares(graphics, x + width / 3, y, width / 3, height / 3);
            drawSquares(graphics, x + width / 3, y + height * 2, width / 3, height / 3);
            drawSquares(graphics, x - (width / 3) * 2, y + height, width / 3, height / 3);
            drawSquares(graphics, x + ((width / 3) * 2) * 2, y + height, width / 3, height / 3);
        }
    }

    public static void drawSquare(Graphics graphics, int x, int y, int width, int height) {
        graphics.drawRect(x, y, width, height);
        graphics.drawRect(x, y + height * 2, width, height);
        graphics.drawRect(x - width, y + height, width, height);
        graphics.drawRect(x + width, y + height, width, height);
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
            super.setBackground(Color.YELLOW);
            mainDraw(graphics);
        }
    }
}
