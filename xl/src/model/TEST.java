package model;

import java.io.IOException;
import java.util.Set;
import java.util.Map.Entry;

public class TEST {

	public static void main(String[] args) {
		Model m = new Model();
		try {
			m.setData("A2", "1");
			m.setData("A3", "A2");
			m.setData("A1", "A3");
			m.setData("A2", "A1");

			
		} catch (IOException e) {
			
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Entry<String, SlotData> e : m.getEntries()) {
			System.out.println(e.getKey() + ", " + e.getValue().stringValue());
		}
	}
	
}
