package io.github.znemux.chrono;

import static io.github.znemux.chrono.GUI.START_TEXT;
import static io.github.znemux.chrono.GUI.STOP_TEXT;
import javax.swing.table.AbstractTableModel;

public class ChronoTableModel extends AbstractTableModel {
    
    private final String[] columnNames = {"Name", "Duration", START_TEXT, STOP_TEXT};

    @Override
    public int getRowCount() {
        return Main.CHRONOS.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Chrono timer = Main.CHRONOS.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> timer.getName();
            case 1 -> timer.getFormattedDuration();
            case 2 -> timer.getFormattedStart();
            case 3 -> timer.getFormattedStop();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
}
