import java.util.Arrays;

public class Game {
    public int gameBoardLength = 5;
    char water = '-';
    char ship = 's';
    char hit = 'x';
    char miss = '0';
    int shipNumber = 3;
    int undetectedShipNumber = shipNumber;

    public char[][] createGameBoard() {
        try {
            char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
            for (char[] row : gameBoard) {
                Arrays.fill(row, water);
            }
            return gameBoard;
        } catch (NegativeArraySizeException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        try {
            int row = guessCoordinates[0];
            int column = guessCoordinates[1];
            gameBoard[row][column] = locationViewUpdate;
            return gameBoard;
        } catch (NullPointerException e) {
            System.err.println("Gameboard Is Null");
            return null;
        }
    }
    public char evaluateGuessAndGetTheTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
            String message;
            int row = guessCoordinates[0];
            int column = guessCoordinates[1];
            char target = gameBoard[row][column];
            if (target == ship) {
                message = "Hit!";
                target = hit;
            } else if (target == water) {
                message = "Miss!";
                target = miss;
            } else {
                message = "Already hit!";
            }
            System.out.println(message);
            return target;
    }
    
    public void undetectedShip(char[][] board, int[] coordinates) {
        try {
            char locationViewUpdate = evaluateGuessAndGetTheTarget(coordinates, board, ship, water, hit, miss);
            if (locationViewUpdate == hit) {
                undetectedShipNumber--;
            }
            board = updateGameBoard(board, coordinates, locationViewUpdate);
            printGameBoard(board, water, ship);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void printGameBoard(char[][] gameBoard, char water, char ship){
        System.out.println();
        System.out.print("  ");
        for(int i = 0; i< gameBoardLength; i++){
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for(int row = 0; row < gameBoardLength; row++){
            System.out.print(row + 1 + " ");
            for(int col = 0; col < gameBoardLength; col++) {
                char position = gameBoard[row][col];
                if(position == ship){
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
