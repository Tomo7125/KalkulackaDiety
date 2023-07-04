package org.example.GUI;


import org.example.entity.Start;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(Start start) {
        Menu menu;

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1300,800);

        //Vytvor�m si nove menu a zavolam jeho metodu ktora mi dod� obsah okna
        menu = new Menu(start,this);
        setContentPane(menu.getContent());

        // Z�skanie ve�kosti obrazovky
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // V�po�et strednej polohy pre okno
        int centerX = (screenSize.width - menu.getFrame().getWidth()) / 2;
        int centerY = (screenSize.height - menu.getFrame().getHeight()) / 2;

        // Nastavenie poz�cie okna na stred obrazovky
        menu.getFrame().setLocation(centerX, centerY);

        setVisible(true);

    }

    public void setContext(JPanel novyContext){
        setContentPane(novyContext);
        revalidate();
        repaint();
    }

}
