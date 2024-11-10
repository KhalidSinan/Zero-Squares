package com.company.jproject.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuUI extends JFrame {

    public MainMenuUI(){
        setLayout(new BorderLayout());
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
        setSize(700, 400);
        setVisible(true);
    }
}
