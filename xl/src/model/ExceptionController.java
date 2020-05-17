package model;

import java.util.Observable;

import gui.StatusLabel;
import util.XLException;

public class ExceptionController extends Observable{
	
	public ExceptionController(StatusLabel statusLabel) {
		this.addObserver(statusLabel);		
	}
	
	public void sendException(String message) {
		
		this.setChanged();
		this.notifyObservers(message);
	}

}
