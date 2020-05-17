package gui;

import model.Model;
import util.XLException;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer {

	private CurrentSlot selected;
	private String address;
	private Model model;

	public SlotLabel(String address, Model model, CurrentSlot selected) {
		super("                    ", Color.WHITE, RIGHT);
		this.selected = selected;
		this.address = address;
		this.model = model;

		selected.addObserver(this);
		model.addObserver(this);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				selected.setCurrentSlot(address);
				setBackground(Color.yellow);
				model.notifyObservers();
			}

		});

	}

	public String address() {
		return address;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if (arg1 instanceof CurrentSlot) {

			selected = (CurrentSlot) arg1;
			this.setBackground(Color.white);

		} else if (arg1 instanceof Map) {

			try {

				String valueAtAddress = model.getStringValue(address);

				if (valueAtAddress.charAt(0) == '#') {
					this.setText(valueAtAddress.substring(1, valueAtAddress.length()));
				} else {
					this.setText(Double.toString(model.value(address))); // chec if gonna use string value or not
				}
				selected.deleteObserver(this);
			} catch (XLException e) {
				this.setText("");
			}
		} 
	}
}