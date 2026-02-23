package com.tss.guitar.model;

public class Guitar extends Instrument{
    GuitarSpec guitarSpec;
    public Guitar(String serialNumber, double guitarPrice,GuitarSpec guitarSpec) {

        super(serialNumber,guitarPrice);
        this.guitarSpec=guitarSpec;
    }

    public String toString() {
        return super.toString()+
                ", numOfString=" + guitarSpec.getNumOfStrings() +"}";
    }

    @Override
    public InstrumentSpec getSpec() {
        return guitarSpec;
    }
}