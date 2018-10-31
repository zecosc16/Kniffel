/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Checkbox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class KniffelTableModel extends AbstractTableModel {

    private KniffelRow[] rows = new KniffelRow[12];
    private String[] colNames = {"Spiel", "Wahl", "Punkte"};

    {
        rows[0] = new KniffelRow("NurEinser", 0);
        rows[1] = new KniffelRow("NurZweier", 0);
        rows[2] = new KniffelRow("NurDreier", 0);
        rows[3] = new KniffelRow("NurVierer", 0);
        rows[4] = new KniffelRow("NurFuenfer", 0);
        rows[5] = new KniffelRow("NurSechser", 0);
        rows[6] = new KniffelRow("Pasch3", 0);
        rows[7] = new KniffelRow("Pasch4", 0);
        rows[8] = new KniffelRow("FullHouse", 0);
        rows[9] = new KniffelRow("StrasseKlein", 0);
        rows[10] = new KniffelRow("StraßeGroß", 0);
        rows[11] = new KniffelRow("Kniffel", 0);
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex];
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public KniffelRow getRow(int i) {
        return rows[i];
    }

    public void setSelected(int row) {
        this.rows[row].setSelected();

    }

    public void setPoints(int row, int points) {
        rows[row].setPunkte(points);

        boolean b = true;
        for (KniffelRow r : rows) {
            if (!r.isSelected()) {
                b = false;
            }
        }

        if (b) {

            JOptionPane.showMessageDialog(null, "You finished the game");
            System.exit(0);
        }
    }

}
