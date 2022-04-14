package com.company;

import javax.swing.*;
import java.awt.*;

public class Spaceship {
    protected ImageIcon image;
    protected Rectangle area;
    protected int energy;
    protected boolean clicked;

    public Spaceship() {
        area = new Rectangle();
        int x = (int) Math.floor(Math.random() * 800);
        int y = (int) Math.floor(Math.random() * 800);
        area.setLocation(x, y);

        energy = (int) Math.floor(Math.random() * 2000);
        clicked = false;
    }

    public void setImage(String filename) {
        image = new ImageIcon(filename);
        int x = image.getIconWidth();
        int y = image.getIconHeight();
        area.setSize(x, y);
    }

    public boolean getClicked() {
        return clicked;
    }

    public void setClicked(boolean b) {
        clicked = b;
    }

    public void draw(Graphics g) {
        if (this.area != null) {
            image.paintIcon(null, g, area.x, area.y);
            g.setColor(Color.white);
            g.drawString("Energy now is " + energy, area.x, area.y);

            if (clicked) {
                int x = image.getIconWidth();
                int y = image.getIconHeight();
                g.drawLine(area.x - 10, area.y - 10,area.x + x, area.y - 10);
            }
        }
    }

    public boolean overlapping(int x, int y) {
        return area.contains(x, y);
    }

    public Rectangle getLocation() {
        return this.area;
    }

    public int getEnergy() {
        return energy;
    }

    public void setArea_to_null() {
        this.area = null;
    }
}
