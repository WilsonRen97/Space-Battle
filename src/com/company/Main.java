package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Main extends JPanel implements MouseListener {

    private ArrayList<Spaceship> ss = new ArrayList<>();

    public Main() {
        // create 10 new spaceship
        for (int i = 0; i < 9; i++) {
            int random_number = (int) Math.floor(Math.random() * 5);
            System.out.println(random_number);
            if (random_number == 0) {
                ss.add(new StarDestroyer());
            } else if (random_number == 1) {
                ss.add(new SuperStarDestroyer());
            } else if (random_number == 2) {
                ss.add(new TIEFighter());
            } else if (random_number == 3) {
                ss.add(new VaderShip());
            } else {
                ss.add(new XWingFighter());
            }
        }
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        // fill background
        int width = getWidth();
        int height = getHeight();
        g.fillRect(0, 0, width, height);

        // draw the spaceship
        for (Spaceship s : ss) {
            s.draw(g);
        }
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Spaceship");
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (Spaceship s : ss) {
            if (s.overlapping(x, y)) {
                s.setClicked(true);
                break;
            }
        }

        int count = 0;
        ArrayList<Spaceship> arr = new ArrayList<>();

        // check if 2 ships are selected
        for (Spaceship s : ss) {
            if (s.getLocation() != null && s.getClicked() != false){
                count++;
                arr.add(s);
            }
        }

        if (count == 2) {
            if (arr.get(0).getEnergy() > arr.get(1).getEnergy()) {
                arr.get(1).setArea_to_null();
                ss.remove(arr.get(1));
            } else {
                arr.get(0).setArea_to_null();
                ss.remove(arr.get(0));
            }
        }

        repaint();

        if (ss.size() == 1) {
            JOptionPane.showMessageDialog(null, "Game Over!!!");
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
