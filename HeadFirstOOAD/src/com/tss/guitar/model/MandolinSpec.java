package com.tss.guitar.model;

public class MandolinSpec extends InstrumentSpec{
    private Style style;

    public MandolinSpec(Style style,Builder builder, Type type, Wood backWood, Wood topWood, String model) {
        super(builder, type, backWood, topWood, model);
        this.style=style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if(!super.matches(otherSpec))return false;
        if(!(otherSpec instanceof MandolinSpec))return false;
        if(((MandolinSpec) otherSpec).getStyle()!=style)return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
