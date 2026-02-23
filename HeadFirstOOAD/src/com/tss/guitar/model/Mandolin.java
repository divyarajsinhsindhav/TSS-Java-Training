package com.tss.guitar.model;

public class Mandolin extends Instrument{

    MandolinSpec mandolinSpec;

    public Mandolin(String serialNumber,double price,MandolinSpec mandolinSpec) {
        super(serialNumber, price);
        this.mandolinSpec=mandolinSpec;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", style='" + mandolinSpec.getStyle() + '\'' +"}";
    }

    @Override
    public InstrumentSpec getSpec() {
        return mandolinSpec;
    }
}
