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
        if(spec instanceof GuitarSpec){
            instruments.add(new Guitar(serialNumber,price,(GuitarSpec) spec));
        }
        if(spec instanceof MandolinSpec){
            instruments.add(new Mandolin(serialNumber,price,(MandolinSpec) spec));
        }
    }

    public List<Guitar> search(GuitarSpec guitarSpec){
        List<Guitar> guitarList=new ArrayList<>();
        for(Instrument g:instruments){
            if(g.getSpec().matches(guitarSpec)){
                guitarList.add((Guitar)g);
            }
        }
        return guitarList;
    }
    public List<Mandolin> search(MandolinSpec searchSpec) {
        List<Mandolin> mandolinList=new ArrayList<>();
        for(Instrument i:instruments){
            if(i.getSpec().matches(searchSpec))mandolinList.add((Mandolin)i);
        }
        return mandolinList;
    }
}