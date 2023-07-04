package org.example.entity;

import org.example.GUI.Frame;
import org.example.GUI.Menu;

public class Start {
    //Riadiaca trieda v ktorej vytvorím triedu frame a zavolam metodu spusti ktora prida vytvorenemu oknu context
    public void start(){

        Frame frame = new Frame(this);

        frame.setContext(new Menu(this , frame).getContent());
    }

}
