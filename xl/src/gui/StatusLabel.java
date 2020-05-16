package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Model;

public class StatusLabel extends ColoredLabel implements Observer {
	
	Model XLsheet;
	
    public StatusLabel(Model XLsheet) {
        super("", Color.WHITE);
        this.XLsheet = XLsheet;
        XLsheet.addObserver(this);
    }

    public void update(Observable observable, Object object) {
    	setText(XLsheet. /*Känner att någon metod i Model borde hantera exceptions, inte exceptioncontroller*/);
    }
}