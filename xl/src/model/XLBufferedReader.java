package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, SlotData> map) {
        try {
        	SlotDataFactory factory = new SlotDataFactory();
        	String string;
        	String address;
        	String value;
        	int index;      	
        	
            while (ready()) {
                string = readLine();//whole line
                index = string.indexOf('=');
                
                address = string.substring(0, index); //Split line into address and value
                value = string.substring(index+1, string.length());                
                map.put(address, factory.getSlotType(value));
                
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
