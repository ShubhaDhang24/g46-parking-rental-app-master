package se.lexicon.data.impl;

import se.lexicon.data.ParkingLotDao;
import se.lexicon.model.ParkingLot;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ParkingLotDaoImpl implements ParkingLotDao {

    private List<ParkingLot> storage;
    // implemented singleton design pattern
    //create an object of SingleObject
    private static ParkingLotDaoImpl instance;

    //make the constructor private so that this class cannot be
    //instantiated
    private ParkingLotDaoImpl() {
        storage = new ArrayList<>();
    }

    //Get the only object available
    public static ParkingLotDaoImpl getInstance(){
        if (instance == null){
            instance = new ParkingLotDaoImpl();
        }
        return instance;
    }


    @Override
    public ParkingLot create(ParkingLot parkingLot) {
        // method implemented
        if(parkingLot==null)throw new RuntimeException("Parking lot is null");
        parkingLot.getAreCode();
        return parkingLot;
    }

    @Override
    public Optional<ParkingLot> find(Integer areaCode) {
        // implemented the method
        if(areaCode==null)throw new RuntimeException("ID is null");
        for (ParkingLot parkingLot:storage) {
            if(parkingLot.getAreCode()==areaCode)
                return Optional.of(parkingLot);
        }

        return Optional.empty();
    }


}
