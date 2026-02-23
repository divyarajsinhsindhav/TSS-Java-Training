package com.tss.guitar.test;

import com.tss.guitar.model.*;

import java.util.List;

public class GuitarTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER,
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER,"Stratocastor", 10);
        MandolinSpec whatSmitLike = new MandolinSpec(Style.A, Builder.FENDER, Type.ELECTRIC, Wood.ALDER, Wood.ALDER, "Stratocastor");

        List<Guitar> guitars = inventory.search(whatErinLikes);
        if (!guitars.isEmpty()) {
            System.out.println("Matching Guitars: ");
            for (Instrument guitar : guitars) {
                System.out.println(guitar);
            }
        } else {
            System.out.println("Sorry !! we have nothing for you");
        }

        List<Mandolin> mandolins = inventory.search(whatSmitLike);
        if (!mandolins.isEmpty()) {
            System.out.println("\nMatching Mandolins: ");
            for (Instrument mandolin : mandolins) {
                System.out.println(mandolin);
            }
        } else {
            System.out.println("Sorry !! we have nothing for you");
        }


    }
    private static void initializeInventory(Inventory inventory) {

        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER,Type.ELECTRIC, Wood.ALDER,Wood.ALDER,"Stratocastor",10));
        inventory.addInstrument("V9512", 1549.95, new GuitarSpec(Builder.FENDER, Type.ELECTRIC, Wood.ALDER, Wood.ALDER,"Stratocastor",5));
        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER, Type.ELECTRIC, Wood.ALDER,Wood.ALDER,"Stratocastor",10));
        inventory.addInstrument("V9512", 1549.95, new GuitarSpec(Builder.FENDER,  Type.ELECTRIC, Wood.ALDER, Wood.ALDER,"Stratocastor",5));

        inventory.addInstrument("R2345",4000,new MandolinSpec(Style.A,Builder.FENDER, Type.ELECTRIC, Wood.ALDER,Wood.ALDER,"Stratocastor"));
    }
}