package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {

	private String address;
	
	public CurrentSlot() {
		address = "A1";
	}

	public void setCurrentSlot(String address) {
		this.address = address;
		setChanged();
		notifyObservers(this);
		
	}

	public String address() {
		return address;
	}

}
