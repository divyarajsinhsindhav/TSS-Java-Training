package com.tss.guitar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        this.instruments = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price,InstrumentSpec spec){
        instruments.add(new Instrument(serialNumber,price,spec));
    }

    public List<Instrument> search(InstrumentSpec specs){
        List<Instrument> matchingInstruments=new ArrayList<>();

        for(Instrument instrument:instruments){
            if(instrument.getSpecs().match(specs)){
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }

}