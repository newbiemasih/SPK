/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Corespk.CoreApps;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author newbie
 */
public class TabelModel extends AbstractTableModel{
    
    private List<CoreApps> list = new ArrayList<>();
    
    public TabelModel(){
        
    }
    
    public TabelModel(List<CoreApps> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getNama();
            case 1:
                return list.get(rowIndex).getNik();
            case 2:
                return list.get(rowIndex).getKelas();
            case 3:
                return list.get(rowIndex).getSosiologi();
            case 4:
                return list.get(rowIndex).getAkutansi();
            case 5:
                return list.get(rowIndex).getGeografi();
            case 6:
                return list.get(rowIndex).getKimia();
            case 7:
                return list.get(rowIndex).getFisika();
            case 8:
                return list.get(rowIndex).getBiolgi();
            case 9:
                return list.get(rowIndex).getMatematika();
            case 10:
                return list.get(rowIndex).getMinat();
            case 11:
                return list.get(rowIndex).getHasilMinat();
                 
            default:
                return null;
        }
        
    }
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Nama";
            case 1:
                return "No Induk";
            case 2:
                return "Kelas Asal";
            case 3:
                return "Sosiologi";
            case 4:
                return "Akutansi";
            case 5:
                return "Geografi";
            case 6:
                return "Kimia";
            case 7:
                return "Fisika";
            case 8:
                return "Biologi";
            case 9: 
                return "Matematika";
            case 10:
                return "Minat Penjurusan";
            case 11:
                return "Hasil Penjurusan";
            default:
                return null;
        }
    }
}
