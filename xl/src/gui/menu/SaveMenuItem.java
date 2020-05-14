package gui.menu;
 
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
 
import javax.swing.JFileChooser;
 
import gui.StatusLabel;
import gui.XL;
import model.SlotData;
import model.XLPrintStream;
 
class SaveMenuItem extends OpenMenuItem {
    private Map<String, SlotData> map;
 
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
        map = new HashMap<String, SlotData>();
    }
 
    protected void action(String path) throws FileNotFoundException {
    	
    	xl.save(path);       
    }
 
    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}