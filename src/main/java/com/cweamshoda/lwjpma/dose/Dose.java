package com.cweamshoda.lwjpma.dose;

import java.util.Date;

public class Dose implements Comparable<Dose> {

    private final String customer;
    private final Date calDate;
    private final double volume;
    private final double activity;

    public Dose(String customer, Date calDate, double volume, double activity) {
        this.customer = customer;
        this.calDate = calDate;
        this.volume = volume;
        this.activity = activity;
    }

    public String getCustomer() {
        return this.customer;
    }

    public Date getCalDate() {
        return this.calDate;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getActivity() {
        return this.activity;
    }

    @Override
    public String toString() {
        return "(" + this.customer + "; calibration date: " + this.calDate + "; vol: " + this.volume + " ml; act: " + this.activity + " Gbq)";
        //return "(" + this.getCustomer() + "; vol: " + this.volume + " ml)";
    }

    @Override
    public int compareTo(Dose other) {
        if (this.customer.equals(other.customer)) return 0;
        return -1;
    }
}
