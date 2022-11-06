package ru.job4j.ood.lsp;

import static ru.job4j.ood.lsp.Passenger.PASSENGER_SIZE;

public class Truck implements Car {

    private int size;

    public Truck(int size) {
        if (size <= PASSENGER_SIZE) {
            throw new IllegalArgumentException("This is passenger car!");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}