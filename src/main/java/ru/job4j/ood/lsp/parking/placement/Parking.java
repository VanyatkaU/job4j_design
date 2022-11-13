package ru.job4j.ood.lsp.parking.placement;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.List;

public interface Parking {

    boolean add(Car car);

    boolean accept(Car car);

    List<Car> getAllCars();
}
