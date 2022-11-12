package ru.job4j.ood.lsp.parking.placement;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Passenger;
import ru.job4j.ood.lsp.parking.model.Truck;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AbstractParkingTest {

    @Test
    public void whenTwoPassengerAndOneTruck() {
        Parking parking = new AbstractParking(2, 1);
        Car passengerOne = new Passenger();
        Car passengerTwo = new Passenger();
        Car truckOne = new Truck(2);
        assertTrue(parking.add(passengerOne));
        assertTrue(parking.add(passengerTwo));
        assertTrue(parking.add(truckOne));
    }

    @Test
    public void whenOnlyOneTruck() {
        Parking parking = new AbstractParking(0, 1);
        Car truck = new Truck(3);
        Car passenger = new Passenger();
        assertTrue(parking.add(truck));
        assertFalse(parking.add(passenger));
    }

    @Test
    public void whenOnlyThreePassengerPlace() {
        Parking parking = new AbstractParking(3, 0);
        Car passengerOne = new Passenger();
        Car truck = new Truck(2);
        parking.add(passengerOne);
        parking.add(truck);
        assertEquals(parking.getAllCar().contains(passengerOne), truck);
    }

    @Test
    public void whenThreePassengerPlaceAndOneTruckPlace() {
        Parking parking = new AbstractParking(3, 1);
        Car truckOne = new Truck(2);
        Car truckTwo = new Truck(2);
        parking.add(truckOne);
        parking.add(truckTwo);
        assertEquals(parking.getAllCar().contains(truckOne), truckTwo);
    }

    @Test
    public void whenOnlyTwoPassengerPlace() {
        Parking parking = new AbstractParking(2, 0);
        Car truck = new Truck(3);
        assertFalse(parking.add(truck));
    }

    @Test
    public void whenCarIsNotTruck() {
        assertThatThrownBy(() -> new Truck(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
