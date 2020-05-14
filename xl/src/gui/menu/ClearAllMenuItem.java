package gui.menu;
 
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.Model;
 
class ClearAllMenuItem extends JMenuItem implements ActionListener {
	
    private Model model;
    
    public ClearAllMenuItem(Model model) {
        super("Clear all");
        addActionListener(this);
        this.model = model;
    }
 
    public void actionPerformed(ActionEvent e) {
        model.clearData();
    }
}