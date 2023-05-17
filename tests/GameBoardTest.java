
import static org.junit.Assert.assertArrayEquals;

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
}
