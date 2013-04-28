/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author newbie
 */
public class Kolom {
    
    public Kolom(JTable table){
        buatKolomSesuai(table);
    }
    
    public static void buatKolomSesuai(JTable t){
        TableColumnModel kolomModel = t.getColumnModel();
        for (int kol = 0; kol < kolomModel.getColumnCount(); kol++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < t.getRowCount(); baris++) {
                TableCellRenderer render = t.getCellRenderer(baris, kol);
                Object nilaiTabel = t.getValueAt(baris, kol);
                Component komponen = render.getTableCellRendererComponent(t, nilaiTabel, false, false, baris, kol);
                lebarKolomMax = Math.max(komponen.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn kolom = kolomModel.getColumn(kol);
            kolom.setPreferredWidth(lebarKolomMax);
        }
    }
}
