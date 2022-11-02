package ru.job4j.ood.lsp;

import java.util.List;

public interface Parking {

    boolean add(Car car);

    boolean accept(Car car);

    List<Car> getAllCar();
}