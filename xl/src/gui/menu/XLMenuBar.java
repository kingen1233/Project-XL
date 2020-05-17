package gui.menu;

import gui.CurrentSlot;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import model.Model;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Model model, CurrentSlot currentSlot) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(currentSlot, model)); //Here be "currentSlot"
        edit.add(new ClearAllMenuItem(model));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}