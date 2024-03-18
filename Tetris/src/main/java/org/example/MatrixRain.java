package org.example;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MatrixRain extends JFrame {

    private static final int FONT_SIZE = 20;
    private static final int NUMBER_OF_REPEATS = 5;
    private static JPanel panel = new JPanel(null);
    private static JLabel label[] = new JLabel[NUMBER_OF_REPEATS];


    public static void main(String[] args) {
        MatrixRain frame = new MatrixRain();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
