package ru.job4j.ood.lsp.parkingCars.parking;

import ru.job4j.ood.lsp.parkingCars.model.Car;

import java.util.List;

public interface Parking {

    boolean add(Car car);

    boolean accept(Car car);

    List<Car> getAllCar();
}
