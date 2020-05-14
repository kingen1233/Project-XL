package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
import util.XLException;

@SuppressWarnings("deprecation")
public class Model extends Observable implements Environment {

	private Map<String, SlotData> map;
	private Map<String, CircularSlot> visited;
	private SlotDataFactory factory;

	public Model() {
		map = new HashMap<String, SlotData>();
		factory = new SlotDataFactory();
		visited = new HashMap<String, CircularSlot>();
	}

	public void setData(String address, String value) throws IOException {

		SlotData previous = map.get(address);

		try {
			map.put(address, new CircularSlot());
			SlotData slot = factory.getSlotType(value);
			slot.value(this);
			map.put(address, slot);

		} catch (XLException xle) { //Circular slot detected
			xle.printStackTrace();
			
			if (previous == null) { //if the address previously had a value, put that back
				map.remove(address);
			} 
			else {
				map.put(address, previous);
			}

		}

		alertObservers();

	}

	public void clearData() {
		map.clear();
		alertObservers();
	}

	public void clearCell(String address) {
		map.remove(address);
		alertObservers();
	}

	public void save(String path) throws FileNotFoundException {

		XLPrintStream xlPrintStream = new XLPrintStream(path);
		xlPrintStream.save(map.entrySet());
		xlPrintStream.close();
	}

	public void load(String path) throws FileNotFoundException {
		try {
			map.clear();
			XLBufferedReader xlBufferedReader = new XLBufferedReader(path);
			xlBufferedReader.load(map);
			xlBufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		alertObservers();
	}

	private void alertObservers() {
		setChanged();
		notifyObservers(map);
	}

	@Override
	public double value(String address) {

		if (map.containsKey(address)) {
			return map.get(address).value(this);
		} else
			throw new XLException("No such address in map: " + address);
	}

	public Set<Entry<String, SlotData>> getEntries() {

		return map.entrySet();
	}

}
