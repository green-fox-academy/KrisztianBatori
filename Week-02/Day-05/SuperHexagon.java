import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        boolean reverse = false;
        int hexNumber = 8;
        int hexHeight = 72;
        int hexWidth = 150;
        for (int i = 1; i <= 4; i++) {
            lineDrawer(graphics, hexHeight, hexNumber, hexWidth, reverse);
            hexNumber += 2;
            hexHeight -= 36;
        }
        hexNumber -= 3;
        hexWidth = 120;
        hexHeight += 18;
        for (int i = 1; i <= 4; i++) {
            lineDrawer(graphics, hexHeight, hexNumber, hexWidth, reverse);
            hexNumber -= 2;
            hexHeight -= 18;
            hexWidth -= 30;
        }
        reverse = true;
        hexNumber = 8;
        hexHeight = 72;
        hexWidth = 70;
        for (int i = 1; i <= 4; i++) {
            lineDrawer(graphics, hexHeight, hexNumber, hexWidth, reverse);
            hexNumber += 2;
            hexHeight -= 36;
        }
        hexNumber -= 3;
        hexWidth = 40;
        hexHeight += 18;
        for (int i = 1; i <= 3; i++) {
            lineDrawer(graphics, hexHeight, hexNumber, hexWidth, reverse);
            hexNumber -= 2;
            hexHeight -= 18;
            hexWidth -= 30;
        }
        lineDrawing(graphics, 50, -108, false, false);
        lineDrawer(graphics, hexHeight, hexNumber, hexWidth, reverse);
    }
    public static void lineDrawer(Graphics graphics, int y, int number, int Width, boolean reverse) {
        boolean diagonal = true;
        int hexWidth = Width;
        int hexHeight = y;
        for (int i = 1; i <= number; i++) {
            if (reverse) {
                lineDrawing(graphics, hexWidth, hexHeight, diagonal, reverse);
            }
            else {
                lineDrawing(graphics, hexWidth, hexHeight, diagonal, reverse);
            }
            if (diagonal) {
                hexWidth -= 10;
                hexHeight += 18;
            }
            else {
                hexWidth -= 20;
            }
            diagonal = !diagonal;
        }
    }
    public static void lineDrawing(Graphics graphics, int x, int y, boolean diagonal, boolean reverse) {
        if (reverse) {
            if (diagonal) {
                graphics.drawLine(WIDTH/2 + x, HEIGHT/2 - y, WIDTH/2 + x - 10, HEIGHT/2 - y - 18);
            }
            else {
                graphics.drawLine(WIDTH/2 + x, HEIGHT/2 - y, WIDTH/2 + x - 20, HEIGHT/2 - y);
            }
        }
        else {
            if (diagonal) {
                graphics.drawLine(WIDTH/2 - x, HEIGHT/2 - y, WIDTH/2 - x + 10, HEIGHT/2 - y - 18);
            }
            else {
                graphics.drawLine(WIDTH/2 - x, HEIGHT/2 - y, WIDTH/2 - x + 20, HEIGHT/2 - y);
            }
        }
    }

    static int WIDTH = 400;
    static int HEIGHT = 400;

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