import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <= 190; j+= 10) {
                graphics.drawLine(210, 420 - (j + 10), 210 - j, 210);
                graphics.drawLine(210, 420 - (j + 10), 210 + j, 210);
                graphics.drawLine(210, j + 10, 210 + j, 210);
                graphics.drawLine(210, j + 10, 210 - j, 210);
            }
        }
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
