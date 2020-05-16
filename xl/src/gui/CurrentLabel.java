	package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
	
	private CurrentSlot selected;

    public CurrentLabel(CurrentSlot selected) {
        super("A1", Color.WHITE);
        this.selected = selected;
        selected.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        setText(selected.toString());
    
		
	}
}