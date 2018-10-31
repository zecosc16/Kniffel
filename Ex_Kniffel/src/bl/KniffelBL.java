/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author oskar
 */
public class KniffelBL {

    public int chooseSpiel(int row, ArrayList<Integer> würfel) throws Exception {

        switch (row) {
            case 0:
                return this.NurZahl(würfel, 1);
            case 1:
                return this.NurZahl(würfel, 2);
            case 2:
                return this.NurZahl(würfel, 3);
            case 3:
                return this.NurZahl(würfel, 4);
            case 4:
                return this.NurZahl(würfel, 5);
            case 5:
                return this.NurZahl(würfel, 6);
            case 6:
                return this.Pasch(würfel, 3);
            case 7:
                return this.Pasch(würfel, 4);
            case 8:
                return this.FullHouse(würfel);
            case 9:
                return this.KleineStraße(würfel);
            case 10:
                return this.GroßeStraße(würfel);
            case 11:
                return this.Kniffel(würfel);
        }
        throw new Exception("Please choose new");
    }

    public int Kniffel(ArrayList<Integer> würfel) {
        for (int i = 0; i < würfel.size(); i++) {
            if (würfel.get(0) != würfel.get(i)) {
                JOptionPane.showMessageDialog(null, "Kein Kniffel vorhanden");
                return 0;
            }

        }
        return 50;
    }

    public int NurZahl(ArrayList<Integer> würfel, int zahl) {
        int sum = 0;
        for (int i : würfel) {
            if (i == zahl) {
                sum += zahl;
            }
        }

        return sum;
    }

    public int Pasch(ArrayList<Integer> würfel, int zahl) {
        int sum = 0, countP = 0, z;
        z = würfel.get(0);
        for (int j = 0; j < würfel.size(); j++) {
            countP = 1;
            for (int i = j + 1; i < würfel.size(); i++) {
                if (würfel.get(j) == würfel.get(i)) {
                    countP++;
                    if (countP == zahl) {
                        for (Integer integer : würfel) {
                            sum += integer;

                        }
                        return sum;
                    }
                }

            }

        }

        JOptionPane.showMessageDialog(null, "Kein Pasch vorhanden");
        return 0;
    }

    public int FullHouse(ArrayList<Integer> würfel) {
        int c1 = 0, c2 = 0;
        int n2 = 0;
        for (int i : würfel) {
            if (würfel.get(0) == i) {
                c1++;
            } else if (n2 == i) {
                c2++;
            } else {
                n2 = i;
                c2 = 1;
            }
        }

        if ((c1 == 3 && c2 == 2) || (c2 == 3 && c1 == 2)) {

            return 25;
        }

        JOptionPane.showMessageDialog(null, "Kein Full House vorhanden");
        return 0;
    }

    public int KleineStraße(ArrayList<Integer> würfel) {

        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        if (würfel.containsAll(s)) {
            return 30;
        }
        s.remove(0);
        s.add(5);
        if (würfel.containsAll(s)) {
            return 30;
        }
        s.remove(0);
        s.add(6);
        if (würfel.containsAll(s)) {
            return 30;
        }

        JOptionPane.showMessageDialog(null, "Keine Kleine Straße vorhanden");
        return 0;

    }

    public int GroßeStraße(ArrayList<Integer> würfel) {

        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        if (würfel.containsAll(s)) {
            return 40;
        }
        s.remove(0);
        s.add(6);
        if (würfel.containsAll(s)) {
            return 40;
        }

        JOptionPane.showMessageDialog(null, "Keine Große Straße vorhanden");
        return 0;
    }

}
