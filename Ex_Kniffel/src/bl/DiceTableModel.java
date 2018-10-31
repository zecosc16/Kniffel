/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class DiceTableModel extends AbstractTableModel {

    private int dicetries = 0;
    private boolean[] stable = new boolean[6];
    private ArrayList<ImageIcon> images = new ArrayList<>();
    private ArrayList<ImageIcon> dices = new ArrayList<>();

    {

        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_1.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_2.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_3.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_4.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_5.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\Alea_6.png"));
        images.add(new ImageIcon("C:\\Users\\oskar\\OneDrive\\3CHIF\\POS\\Kniffel\\src\\pictures\\wuerfel.jpg"));

        for (int i = 1; i < 6; i++) {
            dices.add(images.get(6));
        }

    }

    @Override
    public int getRowCount() {
        return 1;
    }

    public int getDicetries() {
        return dicetries;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dices.get(columnIndex);
    }

    public void dice() {

        if (dicetries == 3) {
            JOptionPane.showMessageDialog(null, "No more tries!");
        } else {
            dicetries++;
            Random rand = new Random();
            for (int i = 0; i < dices.size(); i++) {

                if (!stable[i]) {
                    dices.set(i, images.get(rand.nextInt(6)));
                }

            }
        }
        fireTableDataChanged();
    }

    public void setStable(boolean stable[]) {

        this.stable = stable;
    }

    public void setDicetries() {
        this.dicetries = 0;
        dices.clear();
        for (int i = 1; i < 6; i++) {
            dices.add(images.get(6));
        }
        fireTableDataChanged();
    }

    public ArrayList getDices() {
        ArrayList<Integer> d = new ArrayList<>();
        for (ImageIcon dice : dices) {
            d.add(images.indexOf(dice) + 1);
        }
        return d;
    }

}
