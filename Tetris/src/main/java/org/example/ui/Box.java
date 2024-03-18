package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {
    private int color;

    public int getColor() {
        return color;
    }

    public Box(int x, int y){
        setBounds(x * Config.size, y * Config.size, Config.size, Config.size);
        setBackground(Config.COLORS[0]);
    }
    public void setColor(int color){
        this.color = color;
    if(color >= 0 && color < Config.COLORS.length)
        setBackground(Config.COLORS[color]);
    //else setBackground(Config.COLORS[color]);
    }
    
}
