package ru.job4j.ood.lsp;

import java.util.List;

public class AbstractParking implements Parking {
    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public boolean accept(Car car) {
        return false;
    }

    @Override
    public List<Car> getAllCar() {
        return null;
    }
}
