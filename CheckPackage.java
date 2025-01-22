package staycation.tourism;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    
    public CheckPackage() {
        setBounds(450, 200, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] packages = {
            {"Gold Package", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "Book Package", "Summer Special", "RS 12,000/-", "package1.jpg"},
            {"Silver Package", "5 Days and 6 Nights", "Toll Free", "Entrance Fees", "Meet and Greet At Airport", "Welcome Drink on Arrival", "Night Safari", "Book Now","Daily Buffet", "Winter Special", "RS 24,000/-", "package2.jpg",},
            {"Bronze Package", "6 Days and 5 Nights", "Return Airfare", "Free Clubbing", "Horse Riding & Other Games", "Hard Drinks Free", "Daily Buffet", "BBQ Dinner", "Book Now", "Winter Special", "RS 32,000/-", "package3.jpg"}
        };

        JTabbedPane tab = new JTabbedPane();

        for (String[] pack : packages) {
            JPanel panel = createPackage(pack);
            tab.addTab(pack[0], null, panel);
        }

        add(tab);
        setVisible(true);
    }
    
    private JPanel createPackage(String[] pack) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Add labels dynamically
        int yPosition = 5;
        for (int i = 0; i < pack.length - 1; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setBounds(30, yPosition, 400, 30);
            label.setFont(new Font("Tahoma", i == 0 ? Font.BOLD : Font.PLAIN, 20));
            label.setForeground(i % 2 == 0 ? Color.BLUE : Color.RED);
            panel.add(label);
            yPosition += 50;
        }

        // Add image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[11]));
        Image img = icon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(350, 20, 500, 300);
        panel.add(imageLabel);

        return panel;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}

