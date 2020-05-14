package gui.menu;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Model;

class ClearMenuItem extends JMenuItem implements ActionListener {

	private Model model;
	private String adress;

	public ClearMenuItem(String adress, Model model) {
		super("Clear");
		addActionListener(this);
		this.model = model;
		this.adress = adress;
	}

	public void actionPerformed(ActionEvent e) {
		model.clearCell(adress);
	}
}