package model;

import java.io.IOException;

import expr.ExprParser;

public class SlotDataFactory {

	ExprParser parser;

	public SlotDataFactory() {
		parser = new ExprParser();
	}

	public SlotData getSlotType(String value) throws IOException {

		if (value.equals("")) {
			return new BlankSlot();
		} 
		else if (value.charAt(0) == '#') {
			return new CommentSlot(value);
		} 
		else {

			return new ExpressionSlot(parser.build(value));
		}

	}

}
