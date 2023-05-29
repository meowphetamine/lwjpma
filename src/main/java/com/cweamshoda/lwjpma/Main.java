package com.cweamshoda.lwjpma;

import com.cweamshoda.lwjpma.cases.Case;
import com.cweamshoda.lwjpma.dose.Dose;
import com.cweamshoda.lwjpma.shipment.Shipment;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Shipment shipment = new Shipment();

        Dose dose1 = new Dose("A", new Date(System.currentTimeMillis()), 1, 1);
        Dose dose2 = new Dose("A", new Date(System.currentTimeMillis()), 2, 2);
        Dose dose3 = new Dose("B", new Date(System.currentTimeMillis()), 3, 3);
        Dose dose4 = new Dose("B", new Date(System.currentTimeMillis()), 4, 4);
        Dose dose5 = new Dose("B", new Date(System.currentTimeMillis()), 5, 5);
        Dose dose6 = new Dose("C", new Date(System.currentTimeMillis()), 6, 6);
        Dose dose7 = new Dose("A", new Date(System.currentTimeMillis()), 7, 7);
        Dose dose8 = new Dose("B", new Date(System.currentTimeMillis()), 8, 8);

        shipment.addDose(dose1);
        shipment.addDose(dose2);
        shipment.addDose(dose3);
        shipment.addDose(dose4);
        shipment.addDose(dose5);
        shipment.addDose(dose6);
        shipment.addDose(dose7);
        shipment.addDose(dose8);

        System.out.println(shipment);
        shipment.sort();

        System.out.println();


        System.out.println(shipment);
        /* Should be
        A1: 1, 2, 7
        B1: 3, 4, 5
        C1: 6
        B2: 8
         */

    }

}
