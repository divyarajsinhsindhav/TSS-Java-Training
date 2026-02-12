package com.tss.creational.abstractFactory;

public class JapanPaganiFactory extends PaganiFactory {
    @Override
    public Car createCar() {
        return new Pagani();
    }
}
