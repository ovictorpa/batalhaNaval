import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class ShipCoordinatesTest {
   
    @Test
    public void testAddShipCoordinates(){
        Ship ship = new Ship();
        int row = 1;
        int col = 1;
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(row);
        coordinates.add(col);
        ship.addCoordinates(row, col);
        assertEquals(ship.ships.get(0), coordinates);
    }
    @Test
    public void testAddShipCoordinatesWithNegativesValues(){
        Ship ship = new Ship();
        int row = -1;
        int col = -1;
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(row);
        coordinates.add(col);
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> ship.addCoordinates(row, col));
        assertTrue(runtimeException.getMessage().contains("Row and column must be non-negative."));
    }
    @Test
    public void testAddShipCoordinatesThatExceedBoardLimits(){
        Ship ship = new Ship();
        int row = 6;
        int col = 1;
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(row);
        coordinates.add(col);
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> ship.addCoordinates(row, col));
        assertTrue(runtimeException.getMessage().contains("Invalid ship placement: coordinate outside game board."));
        
    }
}
