package ru.job4j.ood.lsp.parking.model;

public class Passenger implements Car {

    public static final int PASSENGER_SIZE = 1;

    @Override
    public int getSize() {
        return PASSENGER_SIZE;
    }
}