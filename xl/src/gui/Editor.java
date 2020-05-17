package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Model;

public class Editor extends JTextField implements Observer{
	private CurrentSlot selected;
	private Model XLsheet;
    public Editor(CurrentSlot selected, Model XLsheet) {
        setBackground(Color.WHITE);
        this.selected = selected;
        this.XLsheet = XLsheet;
        selected.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		SetText(XLsheet.. /*behöver kunna returna en sträng ifrån en address*/))
		
	}
}