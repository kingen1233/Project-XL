package model;

import expr.Environment;
import util.XLException;

public class CircularSlot implements SlotData {

	@Override
	public double value(Environment value) {
		
		throw new XLException("Circular expression");
	}

	@Override
	public String stringValue() {
		
		throw new XLException("Circular expression");
	}

}
