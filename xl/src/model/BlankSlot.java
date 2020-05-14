package model;

import expr.Environment;
import util.XLException;

public class BlankSlot implements SlotData {
	
	public BlankSlot() {
		
	}
	
	@Override
	public double value(Environment value) {
		throw new XLException("Blankslot has no value");
	}

	@Override
	public String stringValue() {
		
		return "";
	}

}
