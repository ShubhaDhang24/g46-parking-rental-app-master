package se.lexicon.data.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.data.VehicleDao;
import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao{
    //implemented singleton design pattern

    private List<Vehicle> storage;
    private static VehicleDaoImpl instance;
    public VehicleDaoImpl() {storage = new ArrayList<>();
    }

    //Get the only object available
    public static VehicleDaoImpl getInstance(){
        if (instance == null){
            instance = new VehicleDaoImpl();
        }
        return instance;
    }

    @Override
    public Vehicle create(Vehicle data) {
        if (data == null) throw new IllegalArgumentException("Vehicle Data is null.");
        //Optional<Vehicle> vehicleOptional = find(data.getLicensePlate());
        //if (vehicleOptional.isPresent()) throw new IllegalArgumentException("License Plate is duplicate.");
        if (find(data.getLicensePlate()).isPresent())
            throw new IllegalArgumentException("License Plate is duplicate.");
        storage.add(data);
        return data;
    }

        @Override
    public Optional<Vehicle> find(String licensePlate) {
        for (Vehicle element : storage) {
            if (element.getLicensePlate().equals(licensePlate)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String licensePlate) {
        Optional<Vehicle> vehicleOptional = find(licensePlate);
        if (vehicleOptional.isEmpty()) {
            return false;
        } else {
            storage.remove(vehicleOptional.get());
            return true;
        }
    }

    @Override
    public Collection<Vehicle> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Vehicle toUpdate) {
        if (toUpdate == null) throw new IllegalArgumentException("Vehicle Data is null.");
        Optional<Vehicle> existingVehicleOptional = find(toUpdate.getLicensePlate());
        if (existingVehicleOptional.isEmpty()) throw new IllegalArgumentException("License Plate not found.");
        Vehicle originalData = existingVehicleOptional.get();
        int index = storage.indexOf(originalData);
        if (index == -1) throw new IllegalArgumentException("Existing vehicle not found in the storage.");
        storage.set(index, toUpdate);
    }


}
