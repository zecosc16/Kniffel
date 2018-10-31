/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author oskar
 */
public class DiceTableRenderer implements TableCellRenderer {

    private boolean[] stable = new boolean[6];

    public boolean[] getStable() {
        return stable;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l = new JLabel((ImageIcon) value, JLabel.CENTER);
        l.setOpaque(true);

        if (isSelected) {
            l.setBackground(Color.red);
            l.setAlignmentX(l.getWidth() / 2);
            stable[column] = true;
        } else {
            stable[column] = false;
        }

        return l;
    }

}
