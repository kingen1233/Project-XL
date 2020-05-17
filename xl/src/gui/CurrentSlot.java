package gui;

import java.util.Observable;

public class CurrentSlot extends Observable{
 
private SlotLabel selected;
	
	public void set(SlotLabel slotLabel) {
        selected = slotLabel;
        setChanged();
        notifyObservers();
        addObserver(slotLabel);
    }
	
	public String address() {
		return selected.address();
		}

    
}
