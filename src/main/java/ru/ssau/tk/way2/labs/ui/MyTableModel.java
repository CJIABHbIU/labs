package ru.ssau.tk.way2.labs.ui;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;
public class MyTableModel extends AbstractTableModel{
    private static final int X_COLUMN = 0;
    private static final int Y_COLUMN = 1;
    private static final long serialVersionUID = -443916866115057318L;
    private final List<String> xValues;
    private final List<String> yValues;

    public MyTableModel(List<String> xValues, List<String> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    @Override
    public int getRowCount() {
        return xValues.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case X_COLUMN:
                return xValues.get(rowIndex);

            case Y_COLUMN:
                return yValues.get(rowIndex);

        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case X_COLUMN -> xValues.set(rowIndex, String.valueOf(value));
            case Y_COLUMN -> yValues.set(rowIndex, String.valueOf(value));
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !NumberUtils.isNumber((String) getValueAt(rowIndex, columnIndex));
    }

    @Override
    public void fireTableDataChanged() {
        fireTableChanged(new TableModelEvent(this));
        boolean flag = false;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case X_COLUMN -> "X";
            case Y_COLUMN -> "Y";
            default -> super.getColumnName(column);
        };
    }

    public void removeAll() {
        xValues.clear();
        yValues.clear();
    }
}
