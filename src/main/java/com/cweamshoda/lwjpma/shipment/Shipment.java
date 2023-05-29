package com.cweamshoda.lwjpma.shipment;

import com.cweamshoda.lwjpma.cases.Case;
import com.cweamshoda.lwjpma.dose.Dose;

import java.util.ArrayList;
import java.util.LinkedList;

public class Shipment {

    private final ArrayList<Dose> doses;
    private final LinkedList<Case> cases;
    private boolean sorted;

    public Shipment() {
        this.doses = new ArrayList<Dose>();
        this.cases = new LinkedList<Case>();
        this.sorted = false;
    }

    public boolean addDose(Dose dose) {
        if (this.doses.contains(dose)) {
            System.err.println("Error (Shipment): duplicate dose");
            return false;
        }
        this.doses.add(dose);
        return true;
    }

    public LinkedList<Case> getCases() {
        return cases;
    }

    public void sort() {
        if (this.sorted) {
            System.err.println("Error (Shipment): shipment already sorted");
            return;
        }

        for (int i = 0; i < doses.size(); ++i) {
            Dose curr = doses.get(i);

            // Check if dose is already in case
            if (isDosePacked(curr)) continue;

            Case temp = new Case(curr.getCustomer(), Case.Unit.TRIPLE);

            temp.add(curr);

            for (int j = i + 1; j < doses.size(); ++j) {
                Dose sorting = doses.get(j);

                if (curr.compareTo(sorting) == 0) { // SAME DEST.
                    if (!temp.add(sorting)) break; // CASE LIMIT REACHED
                }
            }

            temp.changeUnit(Case.Unit.values()[temp.getDoses().size() - 1]);
            cases.add(temp);
            this.sorted = true;
        }
    }

    public void sort(int singles, int doubles, int triples) {
        if (this.sorted) {
            System.err.println("Error (Shipment): shipment already sorted");
            return;
        }
    }

    private boolean isDosePacked(Dose dose) {
        for (Case cases : this.cases) {
            if (cases.contains(dose)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.doses.isEmpty()) return "Shipment: [Empty shipment]";

        String contents;
        if (!this.sorted) {
            contents = "Shipment (Unsorted): [";
            for (Dose dose : this.doses) {
                if (this.doses.get(this.doses.size() - 1).equals(dose)) {
                    contents += dose + "]";
                    break;
                }
                contents += dose + ", ";
            }
        } else {
            contents = "Shipment (Sorted): [";
            for (Case cases : this.cases) {
                if (this.cases.getLast().equals(cases)) {
                    contents += cases + "]";
                    break;
                }
                contents += cases + ", ";
            }
        }
        return contents;
    }
}
