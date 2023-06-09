import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Game gameBoard = new Game();
        System.out.println("Whats your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println();
        System.out.println("####################");
        System.out.println();
        System.out.println("Hello " + userName + "!");
        System.out.println();
        System.out.println("####################");
        System.out.println();
        System.out.println("For begin the game you need to place three ships on the boar and your friend must guess where are the ships");
        Ship ship = new Ship();
        char[][] board = gameBoard.createGameBoard();

        int numberOfCoordinatesToAdd = 3;
        while (ship.ships.size() < numberOfCoordinatesToAdd) {
            System.out.print("Type the ship " + (ship.ships.size()+1) + " coordinates (row column): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            ship.addCoordinates(row, column);
        }

        for(int i = 0; i< 10; i++){
            System.out.println("Loading...");
        }
        System.out.println();
        System.out.println("--- Welcome to de Naval Battle! ---");
        System.out.println();
        ship.placeShip(board, gameBoard.shipNumber, gameBoard.water, gameBoard.ship, ship.ships);
        gameBoard.printGameBoard(board, gameBoard.water, gameBoard.ship);

        while(gameBoard.undetectedShipNumber > 0){
            int row;
            int column;
            do {
                System.out.print("Row: ");
                row = scanner.nextInt();
            } while (row < 0 || row > gameBoard.gameBoardLength + 1);
            do {
                System.out.print("Column: ");
                column = scanner.nextInt();
            } while (column < 0 || column > gameBoard.gameBoardLength + 1);
            int[] coordinates = new int[] {row - 1, column - 1};
            gameBoard.undetectedShip(board, coordinates);
        }
        System.out.println();
        System.out.println("YOU WIN! CONGRATULATIONS! =)");
        System.out.println();
        scanner.close();
    }
}
