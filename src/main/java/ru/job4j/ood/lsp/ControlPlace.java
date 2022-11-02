package ru.job4j.ood.lsp;

import java.util.List;

public class ControlPlace {

    private final List<Parking> parkingList;

    public ControlPlace(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public void checkParking(Car car) {
        for (Parking parking : parkingList) {
            if (parking.add(car)) {
                break;
            }
            if (!parkingList.isEmpty()) {
                throw new IllegalArgumentException("There are no empty seats");
            }
            if (!parking.accept(car)) {
                throw new IllegalArgumentException("Place only passenger car");
            }
        }
    }
}
