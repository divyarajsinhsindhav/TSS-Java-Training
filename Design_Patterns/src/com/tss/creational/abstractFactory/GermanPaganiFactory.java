package com.tss.creational.abstractFactory;

public class GermanPaganiFactory extends PaganiFactory {
    @Override
    public Car createCar() {
        return new Pagani();
    }
}
