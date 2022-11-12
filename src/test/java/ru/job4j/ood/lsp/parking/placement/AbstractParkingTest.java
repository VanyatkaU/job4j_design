package ru.job4j.ood.lsp.parking.placement;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Passenger;
import ru.job4j.ood.lsp.parking.model.Truck;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AbstractParkingTest {

    @Test
    public void whenTwoPassengerAndOneTruck() {
        Parking parking = new AbstractParking(2, 1);
        Car passengerOne = new Passenger();
        Car passengerTwo = new Passenger();
        Car truck = new Truck(2);
        parking.add(passengerOne);
        parking.add(passengerTwo);
        parking.add(truck);
        assertThat(parking.getAllCar().contains(passengerOne));
        assertThat(parking.getAllCar().contains(passengerTwo));
        assertThat(parking.getAllCar().contains(truck));
    }

    @Test
    public void whenOnlyOneTruck() {
        Parking parking = new AbstractParking(0, 1);
        Car truck = new Truck(3);
        Car passenger = new Passenger();
        parking.add(truck);
        assertThat(parking.getAllCar().contains(truck));
        assertThat(parking.add(passenger)).isFalse();
    }

    @Test
    public void whenOnlyThreePassengerPlace() {
        Parking parking = new AbstractParking(3, 0);
        Car passengerOne = new Passenger();
        Car truck = new Truck(2);
        parking.add(passengerOne);
        parking.add(truck);
        assertThat(parking.getAllCar().contains(passengerOne));
        assertThat(parking.getAllCar().contains(truck));
    }

    @Test
    public void whenThreePassengerPlaceAndOneTruckPlace() {
        Parking parking = new AbstractParking(2, 1);
        Car truckOne = new Truck(2);
        Car truckTwo = new Truck(2);
        parking.add(truckOne);
        parking.add(truckTwo);
        assertThat(parking.getAllCar().contains(truckOne));
        assertThat(parking.getAllCar().contains(truckTwo));
    }

    @Test
    public void whenOnlyTwoPassengerPlace() {
        Parking parking = new AbstractParking(2, 0);
        Car truck = new Truck(3);
        assertThat(parking.add(truck)).isFalse();
    }

    @Test
    public void whenCarIsNotTruck() {
        assertThatThrownBy(() -> new Truck(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
