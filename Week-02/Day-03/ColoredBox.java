import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawLine(80, 100, 80, 160);

        graphics.setColor(Color.RED);
        graphics.drawLine(80, 160, 140, 180);

        graphics.setColor(Color.BLUE);
        graphics.drawLine(140, 180, 210, 180);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(210, 180, 210, 120);

        graphics.setColor(Color.CYAN);
        graphics.drawLine(210, 120, 140, 120);

        graphics.setColor(Color.DARK_GRAY);
        graphics.drawLine(140, 120, 140, 180);

        graphics.setColor(Color.GRAY);
        graphics.drawLine(140, 120, 80, 100);

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawLine(210, 120, 150, 100);

        graphics.setColor(Color.MAGENTA);
        graphics.drawLine(150, 100, 80, 100);
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
