package se.lexicon.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.data.impl.ReservationDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ReservationDaoImplTest {
    ReservationDaoImpl testObject;
    Reservation reservation;
    ParkingSpot parkingSpot;

    //  implemented unit test for this class
    @BeforeEach
    public void setUp() {
        testObject = ReservationDaoImpl.getInstance();
        ParkingSpot parkingSpot = new ParkingSpot(1, true);
        // DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:MM");
        //String str="09:00";
        //String str2="012:00";
        //reservation=new Reservation(LocalTime.parse(str),LocalTime.parse(str2),parkingSpot);
    }

    @Test
    public void testCreateReservation() {
        Reservation reservation1 = new Reservation(LocalTime.parse("09:00"), LocalTime.parse("11:00"), parkingSpot);
        assertEquals(reservation1, testObject.create(reservation1));
    }


}
