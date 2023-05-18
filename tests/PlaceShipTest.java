import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class PlaceShipTest {
    private Ship ship;
    private char[][] gameBoard;

    @Before
    public void setUp() {
        ship = new Ship();
        gameBoard = new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };
    }
    @Test
    public void testPlaceShip() {
        ArrayList<List<Integer>> coordinates = new ArrayList<>();
        coordinates.add(Arrays.asList(1, 1));
        coordinates.add(Arrays.asList(2, 2));
        coordinates.add(Arrays.asList(3, 3));
        gameBoard = ship.placeShip(gameBoard, 3, '-', 'x', coordinates);
        assertEquals(gameBoard[0][0], 'x');
        assertEquals(gameBoard[1][1], 'x');
        assertEquals(gameBoard[2][2], 'x');
    }
    @Test
    public void testPlaceShipInACoordinateAlreadyOccupied() {
        ArrayList<List<Integer>> coordinates = new ArrayList<>();
        coordinates.add(Arrays.asList(1,1));
        coordinates.add(Arrays.asList(1,1));
        RuntimeException runtimeException = assertThrows(IllegalArgumentException.class, () -> {
            ship.placeShip(gameBoard, 3, '-', 'x', coordinates);
        });
        assertTrue(runtimeException.getMessage().contains("Invalid ship placement: coordinate already occupied."));
    }
    @Test
    public void testPlaceShipWithCoordinatesThatExceedBoardLimits() {
        ArrayList<List<Integer>> coordinates = new ArrayList<>();
        coordinates.add(Arrays.asList(10, 1));
        coordinates.add(Arrays.asList(10, 10));
        coordinates.add(Arrays.asList(10, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ship.placeShip(gameBoard, 3, '-', 'x', coordinates);
        });
    }
    @Test
    public void testPlaceShipInvalidCoordinates() {
        ArrayList<List<Integer>> coordinates = new ArrayList<>();
        coordinates.add(Arrays.asList(-1, 2));
        coordinates.add(Arrays.asList(1, -1));
        assertThrows(IllegalArgumentException.class, () -> {
            ship.placeShip(gameBoard, 5, '-', 's', coordinates);
        });
    }
    
}
