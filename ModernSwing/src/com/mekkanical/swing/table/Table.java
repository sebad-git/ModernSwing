package com.mekkanical.swing.table;

import com.mekkanical.swing.Theme;
import java.awt.Color;
import java.awt.Component;
import com.mekkanical.swing.table.scroll.ScrollBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    
    private static final Color GRID_COLOR = new Color(231, 230, 232);
    private static final Color TEXT_COLOR = new Color(118, 113, 125);
    private static final Color SELECTED_COLOR = new Color(247, 247, 248);
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(GRID_COLOR);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(BACKGROUND_COLOR);
                 com.setForeground(TEXT_COLOR);
                setBorder(noFocusBorder);
                if (selected) {
                    com.setBackground(SELECTED_COLOR);
                    com.setForeground(TEXT_COLOR);
                } else {
                    com.setBackground(BACKGROUND_COLOR);
                    com.setForeground(TEXT_COLOR);
                }
                return com;
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(BACKGROUND_COLOR);
        scroll.getViewport().setBackground(BACKGROUND_COLOR);
        JPanel p = new JPanel();
        p.setBackground(BACKGROUND_COLOR);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
}
