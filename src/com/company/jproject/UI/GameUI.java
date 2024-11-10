package com.company.jproject.UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameUI extends JFrame {

    public GameUI() {
        BufferedImage zeroSquaresImage = null;
        try {
            zeroSquaresImage = ImageIO.read(new File("zero_squares.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(new ImageIcon(zeroSquaresImage).getImage().getScaledInstance(700,400, Image.SCALE_DEFAULT)));
        JButton startGameBtn = new JButton("Start Playing");
        startGameBtn.setBounds(200,200,200,200);
        startGameBtn.setMargin(new Insets(10,0,10,0));
        startGameBtn.setUI(new BasicButtonUI());
        add(picLabel, BorderLayout.NORTH);
        add(startGameBtn, BorderLayout.SOUTH);
        setTitle("Zero Squares by Khalid Sinan");
        setSize(700, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
