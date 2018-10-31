/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import bl.KniffelRow;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author oskar
 */
public class KniffelTableRenderer implements TableCellRenderer {

    private boolean[] finished = new boolean[12];

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l = new JLabel();
        KniffelRow k = (KniffelRow) value;
        if (isSelected) {
            finished[row] = true;
        }
        switch (column) {
            case 0:
                l.setText(k.getSpiel());
                break;
            case 1:

                if (isSelected) {
                    k.setSelected();
                }
                return k.getWahl();
            case 2:
                l.setText("" + k.getPunkte());
                break;

        }

        return l;
    }

}
