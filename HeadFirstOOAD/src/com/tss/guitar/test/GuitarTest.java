package com.tss.guitar.test;

import com.tss.guitar.model.Guitar;
import com.tss.guitar.model.Inventory;

public class GuitarTest {
    public static void main(String[] args) {
        Inventory inventory=new Inventory();
        initializeInventory(inventory);

//        Guitar whatErinLikes=new Guitar("",0,"fender","Stratocastor",
//                "electric","Alder","Alder");
        Guitar whatErinLikes = new Guitar("", 0,
                "Fender", "Stratocastor",
                "electric", "Alder", "Alder");

        Guitar guitar=inventory.search(whatErinLikes);
        if(guitar!=null){
            System.out.println(whatErinLikes);
        }
        else{
            System.out.println("Sorry,Erin !! we have nothing for you");
        }

    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V95693",
                1499.95, "Fender", "Stratocastor",
                "electric", "Alder", "Alder");
    }
}
