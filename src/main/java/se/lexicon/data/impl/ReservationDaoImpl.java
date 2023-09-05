package se.lexicon.data.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImpl implements ReservationDao {

    // implemented singleton design pattern
    private List<Reservation> storage;
    private static ReservationDaoImpl instance;

    public ReservationDaoImpl() {
        storage = new ArrayList<>();
    }

    //Get the only object available
    public static ReservationDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDaoImpl();
        }
        return instance;
    }


    @Override
    public Reservation create(Reservation reservationId) {
        if (reservationId == null) throw new RuntimeException("Reservation ID is null");
        storage.add(reservationId);

        return reservationId;
    }

    @Override
    public Optional<Reservation> find(String s) {
        for (Reservation element : storage) {
            if (element.getId().equals(s)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    /*@Override
    public Optional<Reservation> find(int id) {
        for (Reservation element : storage) {
            if (element.getId().equals(id)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }*/
}