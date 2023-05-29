package com.cweamshoda.lwjpma.cases;

import com.cweamshoda.lwjpma.dose.Dose;

import java.util.LinkedList;

public class Case implements Comparable<Case> {

    public enum Unit {
        SINGLE(1),
        DOUBLE(2),
        TRIPLE(3);

        private final int size;

        Unit(int size) {
            this.size = size;
        }

        public int getSize() {
            return this.size;
        }
    }

    private final String customer;
    private Unit unit;
    private final LinkedList<Dose> doses;

    public Case(String customer, Unit unit) {
        this.customer = customer;
        this.unit = unit;
        this.doses = new LinkedList<Dose>();
    }

    public String getCustomer() {
        return this.customer;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public LinkedList<Dose> getDoses() {
        return this.doses;
    }

    public boolean add(Dose dose) {
        if (this.doses.contains(dose)) {
            System.err.println("Error (Case): duplicate dose");
            return false;
        }
        if (this.doses.size() == this.unit.size) {
            System.err.println("Error (Case): case full");
            return false;
        }
        if (!this.customer.equals(dose.getCustomer())) {
            System.err.println("Error (Case): case destination differs from dose destination");
            return false;
        }
        this.doses.add(dose);
        return true;
    }

    public Dose remove(int index) {
        Dose ret = this.doses.get(index);
        this.doses.remove(index);
        return ret;
    }

    public void changeUnit(Unit unit) {
        this.unit = unit;
    }

    public boolean contains(Dose dose) {
        return this.doses.contains(dose);
    }

    @Override
    public String toString() {
        if (this.doses.isEmpty()) return this.customer + " case: [Empty case]";

        String contents = this.customer + " case (" + this.unit + "): [";
        for (Dose dose : this.doses) {
            if (this.doses.getLast().equals(dose)) {
                contents += dose + "]";
                break;
            }
            contents += dose + ", ";
        }
        return contents;
    }

    @Override
    public int compareTo(Case other) {
        if (this.customer.equals(other.customer)) return 0;
        return -1;
    }
}
