package com.tss.guitar.model;

public class Guitar {
    private String serialNumber;
    private String builder;
    private String model;
    private String type;
    private String topWood;
    private String backWood;
    private double price;

    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getTopWood() {
        return topWood;
    }

    public String getBackWood() {
        return backWood;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", topWood='" + topWood + '\'' +
                ", backWood='" + backWood + '\'' +
                ", price=" + price +
                '}';
    }
}
