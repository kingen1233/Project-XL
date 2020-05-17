package gui.menu;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.Model;

class ClearMenuItem extends JMenuItem implements ActionListener {

	private Model model;
	private CurrentSlot currentSlot;

	public ClearMenuItem(CurrentSlot currentSlot, Model model) {
		super("Clear");
		addActionListener(this);
		this.model = model;
		this.currentSlot = currentSlot;
	}

	public void actionPerformed(ActionEvent e) {
		model.clearCell(currentSlot.address());
	}
}