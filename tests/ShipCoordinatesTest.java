import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> {
            ship.addCoordinates(row, col);
        });
    }
    @Test
    public void testAddShipCoordinatesThatExceedBoardLimits(){
        Ship ship = new Ship();
        int row = 7;
        int col = 7;
        assertThrows(RuntimeException.class, () -> ship.addCoordinates(row, col));
    }
    
}
