package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.Model;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Model model, CurrentSlot currentSlot) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, model, currentSlot));
    }
}