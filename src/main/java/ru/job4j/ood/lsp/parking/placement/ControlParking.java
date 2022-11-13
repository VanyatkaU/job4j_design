package ru.job4j.ood.lsp.parking.placement;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.parking.model.Passenger.PASSENGER_SIZE;

public class ControlParking implements Parking {

    private final List<Car> passengerCars;
    private final List<Car> trucks;
    private int passengerCarsPlace;
    private int trucksPlace;

    public ControlParking(int passengerCarsPlace,
                          int trucksPlace) {
        this.passengerCars = new ArrayList<>(passengerCarsPlace);
        this.trucks = new ArrayList<>(trucksPlace);
        this.passengerCarsPlace = passengerCarsPlace;
        this.trucksPlace = trucksPlace;
    }

    @Override
    public boolean add(Car car) {
        boolean accept = accept(car);
        if (accept) {
            if (car.getSize() > PASSENGER_SIZE
                && trucksPlace > PASSENGER_SIZE) {
                trucks.add(car);
                trucksPlace--;
            } else if (passengerCarsPlace >= PASSENGER_SIZE) {
                passengerCars.add(car);
                passengerCarsPlace -= car.getSize();
            }
        }
        return accept;
    }

    @Override
    public boolean accept(Car car) {
        return passengerCarsPlace >= car.getSize()
               || (trucksPlace > 0 && car.getSize() > PASSENGER_SIZE);
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>(passengerCars);
        allCars.addAll(trucks);
        return allCars;
    }
}
