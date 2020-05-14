package gui.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import javax.swing.JFileChooser;

import gui.StatusLabel;
import gui.XL;
import model.SlotData;
import model.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {
	private Map<String, SlotData> map;

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
		map = new HashMap<String, SlotData>();
	}

	protected void action(String path) throws FileNotFoundException {
		xl.load(path);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}