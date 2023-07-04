package org.example.GUI;

import org.example.entity.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu implements ActionListener {

    Start start;
    Frame frame;
    private JPanel panelMenu;
    private JButton buttonSpocitaj;
    private JTextField pocetDni1;
    private JTextField pocetDni2;
    private JTextField pocetDni3;
    private JLabel vysledok1;
    private JLabel vysledok2;
    private JLabel vysledok3;
    private JLabel vysledokCelkovo;
    private JTextField aktualneDiety1;
    private JTextField aktualneDiety2;
    private JTextField aktualneDiety3;
    private JLabel errorLabel;
    private JButton buttonVynuluj;

    //Kon�truktor v ktorom si pridam actionListenery a metodu enterListener ktora sleduje �i som stla�il enter v textfieldoch
    public Menu(Start start, Frame frame) {
        this.start = start;
        this.frame = frame;
        buttonSpocitaj.addActionListener(this);
        buttonVynuluj.addActionListener(this);
        enterListener(aktualneDiety1);
        enterListener(aktualneDiety2);
        enterListener(aktualneDiety3);
        enterListener(pocetDni1);
        enterListener(pocetDni2);
        enterListener(pocetDni3);
    }

    //Vracia tento panel
    public JPanel getContent(){
        return panelMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ak bol stla�en� button spo��taj vykon�m n�sledovn�
        if (e.getSource().equals(buttonSpocitaj)){
            //Error text si v�dy pri volani skryjem
            errorLabel.setVisible(false);
            //Try catch blok m�m k�li v�nimkam keby pri�iel nespr�vny form�t ako vstup
            try {
                //Skontrolujem �i su vyplnen� v�etky polia
                if (!aktualneDiety1.getText().isEmpty() && !aktualneDiety2.getText().isEmpty() && !aktualneDiety3.getText().isEmpty()){
                    if (!pocetDni1.getText().isEmpty() && !pocetDni2.getText().isEmpty() && !pocetDni3.getText().isEmpty()){
                        //pomocne premenne do ktor�ch si uklad�m hodnoty ako double ( z textfieldu pr�de string )
                        double pomDiet = Double.parseDouble(aktualneDiety1.getText());
                        double pomDni = Double.parseDouble(pocetDni1.getText());
                        //Vyn�sob�m hodnotu di�t * po�et dn�
                        double pom1 = pomDiet * pomDni;
                        //Do vysledku nasetujem hodnotu z pom1 ktoru si prehodim na String
                        vysledok1.setText(String.valueOf(pom1));

                        double pomDiet2 = Double.parseDouble(aktualneDiety2.getText());
                        double pomDni2 = Double.parseDouble(pocetDni2.getText());
                        double pom2 = pomDiet2 * pomDni2;
                        vysledok2.setText(String.valueOf(pom2));

                        double pomDiet3 = Double.parseDouble(aktualneDiety3.getText());
                        double pomDni3 = Double.parseDouble(pocetDni3.getText());
                        double pom3 = pomDiet3 * pomDni3;
                        vysledok3.setText(String.valueOf(pom3));

                        //Do premennej celkovo si ulo��m celkovu hodnotu diet
                        double celkovo = (pom1 + pom2 + pom3);
                        //Do vysledku si nasetujem celkovu hodnotu
                        vysledokCelkovo.setText(String.valueOf(celkovo));
                        //Ak niesu v�etky polia pre po�et dni vyplnen� nasetujem n�sledovn� hl�ku do errorlabel a setVisible ju nastav� ako viditeln�
                    }else {
                        errorLabel.setText("Musia by� vyplnen� v�etky polia pre po�et dn�");
                        errorLabel.setVisible(true);
                    }
                    //Ak niesu v�etky polia pre hodontu diet vyplnen� nasetujem n�sledovn� hl�ku do errorlabel a setVisible ju nastav� ako viditeln�
                }else {
                    errorLabel.setText("Musia by� vyplnen� v�etk� polia pre aktu�lnu hodnotu di�t ! ");
                    errorLabel.setVisible(true);
                }


            } catch (NumberFormatException x) {
                //Ak nastala in� v�nimka ako napriklad zl� form�t nasetujem do errorlabel nasledovnu hl�ku a zobraz�m ju
                errorLabel.setText("Zle zadan� desatinna �iarka alebo vstupn� parameter nieje ��slo");
                errorLabel.setVisible(true);
                //V pr�pade v�nimky si nech�m vyp�sa� jej cestu
                x.printStackTrace();
            }
        }
        if (e.getSource().equals(buttonVynuluj)){
            //Ak bol odkliknut� button Vynuluj tak len zavol�m nove okno ��m sa vyma�e preto�e pr�de znovu pr�zdny context
            frame.setContext(new Menu(start , frame).getContent());
        }
    }

    //Metoda vr�ti frame tohoto okna
    public Frame getFrame(){return this.frame;}

    //Metoda pr�jma textField ako vstupn� parameter a n�sledovne mu prid�m listener na stla�enie kl�vesy enter
    public void enterListener(JTextField field){
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //Ak je enter stla�en� tak vykon� program funkciu doClick na buttonSpocitaj tak�e enter je to ist� ako kliknutie na spo��taj
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    buttonSpocitaj.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
