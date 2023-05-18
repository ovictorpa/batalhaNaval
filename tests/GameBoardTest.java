import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;


public class GameBoardTest {
    private char[][] gameBoard, gameBoardHit;

    @Before
    public void setUp() {
        gameBoard = new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };
        gameBoardHit = new char[][]{
            {'x', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-'}
    };
    }
    @Test
    public void testCreateAGameBoard(){
        Game game = new Game();
        char[][] actualGameBoard = game.createGameBoard();
        assertArrayEquals(gameBoard, actualGameBoard);
    }
    @Test
    public void testUpdateGameBoard() {
        Game game = new Game();
        int[] guessCoordinates = {0, 0};
        char locationViewUpdate = 'x';
        char[][] actualGameBoard = game.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
        assertArrayEquals(gameBoardHit, actualGameBoard);
    }
    @Test
    public void testCreateGameBoardWithInvalidLength() {
        Game gameBoard = new Game();
        gameBoard.gameBoardLength = -1;
        char[][] result = gameBoard.createGameBoard();
        assertNull(result);
    }
    @Test
    public void testUpdateGameBoardWhenGameBoardIsNull() {
        char[][] gameBoard = null;
        int[] guessCoordinates = {2, 2};
        char locationViewUpdate = 'X';
        Game game = new Game();
        char[][] result = game.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
        assertNull(result);
    }
}
