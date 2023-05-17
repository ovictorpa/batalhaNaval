import java.util.ArrayList;
import java.util.List;

public class Ship {

    Game game = new Game();
    ArrayList<List<Integer>> ships = new ArrayList<>();

    public void addCoordinates(int row, int col) {
        int limit = game.gameBoardLength;
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be non-negative.");
        }
        if(row > limit || col > limit){
            throw new IndexOutOfBoundsException("Invalid ship placement: coordinate outside game board.");
        }
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(row);
        coordinates.add(col);
        ships.add(coordinates);
    }

    public char[][] placeShip(char[][] gameBoard, int shipNumber, char water, char ship, ArrayList<List<Integer>> ships){
        for(int i = 0; i< 3; i++){
            List<Integer> coordinates = ships.get(i);
            char possiblePlacement = gameBoard[coordinates.get(0) -1][coordinates.get(1) -1];
            if(possiblePlacement ==  water) {
                gameBoard[coordinates.get(0) -1][coordinates.get(1) -1] = ship;
            }
            else if (possiblePlacement == ship) {
                throw new IllegalArgumentException("Invalid ship placement: coordinate already occupied.");
            }
            else if (ships.get(i).get(i) < 0 || ships.get(i).get(i + 1) < 0){
                throw new IllegalArgumentException("Row and column must be non-negative.");
            }
        }
        return gameBoard;
    }
}


