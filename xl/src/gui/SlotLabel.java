package gui;
import model.Model;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer {
	
	
	private CurrentSlot selected;
	private String address;
	private Model XLsheet;
	
    public SlotLabel(String address, CurrentSlot selected, Model XLsheet) {
        super("                    ", Color.WHITE, RIGHT);
        
        this.selected = selected;
        this.address = address;
        this.XLsheet = XLsheet;
        XLsheet.addObserver(this);
    }
    
    public String address() {
        return address;
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(XLsheet.. /*Behöver väl en metod som kan hämta innehållet av en address och returnera det som en sträng?*/);
		selected.deleteObserver(this);
	}
}