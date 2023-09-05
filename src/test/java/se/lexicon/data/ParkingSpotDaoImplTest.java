package se.lexicon.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.lexicon.data.impl.ParkingSpotDaoImpl;
import se.lexicon.model.ParkingSpot;

public class ParkingSpotDaoImplTest {
    //  implement unit test for this class

    ParkingSpotDaoImpl testObject;
    ParkingSpot parkingSpot;

    @BeforeEach
    public void setUp()
    {
        testObject=new ParkingSpotDaoImpl();
        parkingSpot=new ParkingSpot(0,false);

    }
    @Test
    public void testCreateParkingSpot()
    {
        ParkingSpot created=testObject.create(parkingSpot);
        assertEquals(parkingSpot,created);
    }
   @Test
    public void testForThrowException()
   {
       testObject.create(parkingSpot);
       assertThrows(RuntimeException.class, new Executable() {
           @Override
           public void execute() throws Throwable {
               testObject.create(parkingSpot);
           }
       });


   }

}
