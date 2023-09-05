package se.lexicon.data.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    private List<ParkingSpot> storage;
    private static ParkingSpotDaoImpl instance;

    // implemented singleton design pattern
    public ParkingSpotDaoImpl() {
        storage = new ArrayList<>();
    }

    //Get the only object available
    public static ParkingSpotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingSpotDaoImpl();
        }
        return instance;
    }


    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        //  implemented the method
        if (parkingSpot == null) throw new RuntimeException("ParkingSpot is null");
        parkingSpot.getSpotNumber();
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(Integer spotNo) {
        //  implemented the method
        if (spotNo == null) throw new IllegalArgumentException("Id Was null.");
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == spotNo)
                return Optional.of(parkingSpot);
        }
        return Optional.empty();
    }

    @Override
    public void occupyParkingSpot(int spotNumber) { // spotNumber => 2

        // step1: check parkingSpot is existed or not through find method
        Optional<ParkingSpot> existingParkingSpot = find(spotNumber);

        // step2: check if parking spot occupied is false
        if (existingParkingSpot.isEmpty()) throw new RuntimeException("empty");
        ParkingSpot originalData = existingParkingSpot.get();
        // step3: find its index and update it in the storage
        int index = storage.indexOf(originalData);
        if (index == -1) throw new RuntimeException("NUll");
        storage.set(index, originalData);
    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        //  implemented the method
        for (ParkingSpot element : storage) {
            if (element.equals(spotNumber))
                storage.remove(spotNumber);
        }

    }
}
