package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import expr.Environment;

public class Model extends Observable implements Environment{

	private Map<String, SlotData> map;
	
	public Model() {
		map = new HashMap<String,SlotData>();
		
	}
	 
	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
