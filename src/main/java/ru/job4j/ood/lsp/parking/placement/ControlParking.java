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
            int sizeCar = car.getSize();
            if (sizeCar > PASSENGER_SIZE && trucksPlace > 0) {
                trucks.add(car);
                trucksPlace--;
            } else if (sizeCar == PASSENGER_SIZE && passengerCarsPlace > 0) {
                passengerCars.add(car);
                passengerCarsPlace -= car.getSize();
            }
        }
        return accept;
    }

    @Override
    public boolean accept(Car car) {
        int sizeCar = car.getSize();
        return passengerCarsPlace >= sizeCar
               || (trucksPlace > 0 && sizeCar > PASSENGER_SIZE);
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>(passengerCars);
        allCars.addAll(trucks);
        return allCars;
    }
}
