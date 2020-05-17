package model;

import expr.Environment;
import util.XLException;

public class CommentSlot implements SlotData{

	String value;
	
	public CommentSlot(String input) {
		value = input;
	}
	
	@Override
	public double value(Environment value) {
		return 0.0;
	}

	@Override
	public String stringValue() {
		
		return value;
	}

}
