import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        Color[] whiteBlack = new Color[] {Color.WHITE, Color.BLACK};
        boolean isWhite = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isWhite) {
                    squareDrawing(graphics, j*80, i*80, whiteBlack[0]);
                }
                else {
                    squareDrawing(graphics, j*80, i*80, whiteBlack[1]);
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
    }
    public static void squareDrawing(Graphics graphics, int x1, int y1, Color color) {
        graphics.setColor(color);
        graphics.fillRect(x1, y1, 80, 80);
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
