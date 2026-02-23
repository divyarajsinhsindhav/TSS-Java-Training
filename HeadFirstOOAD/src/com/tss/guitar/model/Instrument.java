package com.tss.guitar.model;

public abstract class Instrument {
    private String serialNumber;
    private double price;

    public Instrument(String serialNumber, double price) {
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public abstract InstrumentSpec getSpec();

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+"{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", builder='" + getSpec().getBuilder() + '\'' +
                ", top wood='" + getSpec().getTopWood() + '\'' +
                ", back wood='" + getSpec().getBackWood() + '\'' +
                ", type='" + getSpec().getType() + '\'' +
                ", model='" + getSpec().getModel() + '\'';
    }
}
