package staycation.tourism;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {

    Thread t1;
    JLabel[] labels = new JLabel[10];
    JLabel caption;

    public void run() {
        String[] text = new String[]{
                "JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel",
                "Radisson Blu Hotel", "Classio Hotel", "The Bay Club Hotel",
                "The Taj Hotel", "Breeze Blow Hotel", "Happy Morning Hotel", "River View Hotel"
        };

        try {
            for (int i = 0; i <= 9; i++) {
                final int index = i;
                SwingUtilities.invokeLater(() -> {
                    labels[index].setVisible(true);
                    caption.setText(text[index]);
                });
                Thread.sleep(2500);
                SwingUtilities.invokeLater(() -> labels[index].setVisible(false));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 500, 700, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 30));
        caption.setForeground(Color.WHITE);
        add(caption);

        for (int i = 0; i <= 9; i++) {
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
            Image scaledImage = imageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            labels[i] = new JLabel(scaledIcon);
            labels[i].setBounds(0, 0, 800, 600);
            labels[i].setVisible(false);
            add(labels[i]);
        }

        t1 = new Thread(this);
        t1.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckHotels();
    }
}
