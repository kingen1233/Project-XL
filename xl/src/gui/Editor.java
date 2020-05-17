package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.ExceptionController;
import model.Model;
import util.XLException;

public class Editor extends JTextField implements Observer, ActionListener {

	private CurrentSlot selected;
	private Model model;
	private ExceptionController excController;

	public Editor(CurrentSlot selected, Model model, ExceptionController excController) {
		setBackground(Color.WHITE);
		this.selected = selected;
		this.model = model;
		this.excController = excController;
		selected.addObserver(this);
		this.addActionListener(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof CurrentSlot) {
			selected = (CurrentSlot) arg;

			try {
				setText(model.getStringValue(selected.address()));
			} catch (XLException e) {
				setText("");
			}

		} else {
			throw new XLException("Update method can only take in String represenation of address");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			model.setData(selected.address(), this.getText());
			model.printMap();
			excController.sendException("");

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (XLException e1) {
			e1.printStackTrace();
			excController.sendException(e1.getMessage());
		}

	}
}