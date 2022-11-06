package ru.job4j.ood.lsp;

import java.util.List;

public class AbstractParking implements Parking {

    private final List<Car> passengerCars;
    private final List<Car> trucks;
    private int passengerCarsPlace;
    private int trucksPlace;

    public AbstractParking(List<Car> passengerCars,
                           List<Car> trucks,
                           int passengerCarsPlace,
                           int trucksPlace) {
        this.passengerCars = passengerCars;
        this.trucks = trucks;
        this.passengerCarsPlace = passengerCarsPlace;
        this.trucksPlace = trucksPlace;
    }

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