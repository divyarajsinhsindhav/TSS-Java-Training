package com.tss.guitar.test;

import com.tss.guitar.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstrumentTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);


        Map<String, Object> properties = new HashMap<>();
//        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.SITKA);

        InstrumentSpec clientSpec = new InstrumentSpec(properties);


        List<Instrument> matchingInstruments = inventory.search(clientSpec);

        if (!matchingInstruments.isEmpty()) {

            System.out.println("\nYou might like these instruments:");
            System.out.println("========================================================");

            for (Instrument instrument : matchingInstruments) {

                InstrumentSpec spec = instrument.getSpecs();

                System.out.println("We have a " +
                        spec.getProperty("instrumentType") +
                        " with the following properties:\n");


                for (String propertyName : spec.getProperties().keySet()) {

                    if (propertyName.equals("instrumentType")) {
                        continue;
                    }

                    System.out.println(" " + propertyName + ": " +
                            spec.getProperty(propertyName));
                }

                System.out.println("You can have this " +
                        spec.getProperty("instrumentType") +
                        " for $" + instrument.getPrice());

                System.out.println("---------------------------");
            }

        } else {
            System.out.println("Sorry, we have nothing for you.");
        }

    }
    private static void initializeInventory(Inventory inventory) {

        Map<String, Object> properties = new HashMap<>();

        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);

        inventory.addInstrument("11277", 3999.95,
                new InstrumentSpec(new HashMap<>(properties)));

        properties.clear();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("type", Type.ACOUSTIC);
        properties.put("model", "F-5G");
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        properties.remove("numStrings");

        inventory.addInstrument("9019920", 5495.99,
                new InstrumentSpec(new HashMap<>(properties)));

        properties.clear();
        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("model", "RB-3 Wreath");
        properties.remove("topWood");
        properties.put("numStrings", 5);

        properties.put("backwood", Wood.SITKA);

        inventory.addInstrument("8900231", 2945.95,
                new InstrumentSpec(new HashMap<>(properties)));
    }
}
