import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        for (int i = 0; i < 80; i++) {
            makeStar(graphics);
        }

    }
    public static void makeStar(Graphics graphics) {
        Color[] greyShades = new Color[] {new Color(220,220,220), new Color(211,211,211),
                                          new Color(192,192,192), new Color(169,169,169),
                                          new Color(128,128,128), new Color(105,105,105),
                                          new Color(119,136,153), new Color(112,128,144),
                                          new Color(47,79,79)};
        graphics.setColor(greyShades[(int)(Math.random() * 9)]);
        graphics.fillRect((int)(Math.random() * 321), (int)(Math.random() * 321), 2, 2);
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
            this.setBackground(Color.BLACK);
            mainDraw(graphics);
        }
    }
}
