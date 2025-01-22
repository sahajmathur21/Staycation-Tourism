package staycation.tourism;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread t1;
    JLabel[] labels = new JLabel[10];

    public void run() {
        try {
            for (int i = 0; i <=9; i++) {
                final int index = i;
                SwingUtilities.invokeLater(() -> {
                    labels[index].setVisible(true); // Show the current image
                });
                Thread.sleep(2500); // Wait for 2.5 seconds
                SwingUtilities.invokeLater(() -> {
                    labels[index].setVisible(false); // Hide the current image
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        for (int i = 0; i <=9; i++) {
            try {
                ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
                Image scaledImage = imageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                labels[i] = new JLabel(scaledIcon);
                labels[i].setBounds(0, 0, 800, 600);
                labels[i].setVisible(false); // Initially hide all images
                add(labels[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        t1 = new Thread(this);
        t1.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
