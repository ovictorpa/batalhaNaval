import java.util.ArrayList;
import java.util.List;

public class Ship {

    Game game = new Game();
    ArrayList<List<Integer>> ships = new ArrayList<>();

    public void addCoordinates(int row, int col) {
        boolean isValidCoordinate = false;
        boolean exceptionThrown = false;
    
        while (!isValidCoordinate && !exceptionThrown) {
                int limit = game.gameBoardLength;
                if (row < 0 || col < 0) {
                    exceptionThrown = true;
                    throw new IllegalArgumentException("Row and column must be non-negative.");
                }
                if (row > limit || col > limit) {
                    exceptionThrown = true;
                    throw new IndexOutOfBoundsException("Invalid ship placement: coordinate outside game board.");
                }
                try {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(row);
                    coordinates.add(col);
                    ships.add(coordinates);
                    isValidCoordinate = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    exceptionThrown = true;
                } catch (IndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                    exceptionThrown = true;
                } 
        }
    }
    public char[][] placeShip(char[][] gameBoard, int shipNumber, char water, char ship, ArrayList<List<Integer>> ships) {
            for (int i = 0; i < 3; i++) {
                List<Integer> coordinates = ships.get(i);
                int row = coordinates.get(0) - 1;
                int col = coordinates.get(1) - 1;
    
                if (row < 0 || col < 0) {
                    throw new IllegalArgumentException("Row and column must be non-negative.");
                }
                if (row >= gameBoard.length || col >= gameBoard.length) {
                    throw new IndexOutOfBoundsException("Invalid ship placement: coordinate outside game board.");
                }
                char possiblePlacement = gameBoard[row][col];
                if (possiblePlacement == water) {
                    gameBoard[row][col] = ship;
                } else if (possiblePlacement == ship) {
                    throw new IllegalArgumentException("Invalid ship placement: coordinate already occupied.");
                }
            }
            return gameBoard;
    }
}


