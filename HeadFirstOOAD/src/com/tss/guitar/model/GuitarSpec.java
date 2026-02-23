package com.tss.guitar.model;

public class GuitarSpec extends InstrumentSpec{
    private int numOfStrings;

    public GuitarSpec(Builder builder, Type type, Wood backWood, Wood topWood, String model,int numOfStrings) {
        super(builder, type, backWood, topWood, model);
        this.numOfStrings=numOfStrings;
    }

    public int getNumOfStrings(){
        return numOfStrings;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if(!super.matches(otherSpec)) return false;
        if(!(otherSpec instanceof GuitarSpec)) return false;
        if(!(((GuitarSpec) otherSpec).getNumOfStrings()==this.getNumOfStrings())) return false;
        return true;
    }

}