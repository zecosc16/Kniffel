/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Checkbox;
import javax.swing.JCheckBox;

/**
 *
 * @author oskar
 */
public class KniffelRow {

    private String spiel;
    private JCheckBox wahl = new JCheckBox();
    private int punkte;

    public KniffelRow(String spiel, int punkte) {
        this.spiel = spiel;

        this.punkte = punkte;

    }

    public String getSpiel() {
        return spiel;
    }

    public int getPunkte() {
        return punkte;
    }

    public boolean isSelected() {
        return wahl.isSelected();
    }

    public JCheckBox getWahl() {
        return wahl;
    }

    public void setSelected() {
        this.wahl.setSelected(true);
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

}
