package ru.job4j.ood.lsp.parkingCars.parking;

import ru.job4j.ood.lsp.parkingCars.model.Car;

import java.util.ArrayList;
import java.util.List;

public class AbstractParking implements Parking {

    private final List<Car> passengerCars;
    private final List<Car> trucks;
    private int passengerCarsPlace;
    private int trucksPlace;

    public AbstractParking(int passengerCarsPlace,
                           int trucksPlace) {
        this.passengerCars = new ArrayList<>(passengerCarsPlace);
        this.trucks = new ArrayList<>(trucksPlace);
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
