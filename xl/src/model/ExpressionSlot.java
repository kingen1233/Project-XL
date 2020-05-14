package model;

import expr.Environment;
import expr.Expr;

public class ExpressionSlot implements SlotData {
	
	Expr expr;
	
	public ExpressionSlot(Expr expr) {
		
		this.expr = expr;		
	}
	
	@Override
	public double value(Environment value) {		
		
		return expr.value(value);
	}

	@Override
	public String stringValue() {
		
		return expr.toString();
	}

}
