import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.*;

public class GamePlayTest {
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
    public void testEvaluateGuessAndGetTheTarget_hit() {
        Game game = new Game();
        int[] guessCoordinates = {0,0};
        char expected = 'x';
        char actual = game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoardHit, game.ship, game.water, game.hit, game.miss);
        assertEquals(expected, actual);
    }
    @Test
    public void testEvaluateGuessAndGetTheTarget_miss() {
        Game game = new Game();
        int[] guessCoordinates = {1,1};
        char expected = '0';
        char actual = game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, game.ship, game.water, game.hit, game.miss);
        assertEquals(expected, actual);
    }
    @Test
    public void testEvaluateGuessAndGetTheTarget_alreadyHit() {
        Game game = new Game();
        int[] guessCoordinates = {0,0};
        game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, game.ship, game.water, game.hit, game.miss);
        char expected = '0';
        char actual = game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, game.ship, game.water, game.hit, game.miss);
        assertEquals(expected, actual);
    }
    @Test
    public void testEvaluateGuessAndGetTheTargetWithInvalidCoordinates(){
        Game game = new Game();
        int[] guessCoordinates = {-1,-1};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, game.ship, game.water, game.hit, game.miss);
        });
    }
    @Test
    public void testEvaluateGuessAndGetTheTargetWithCoordinatesThatExceedBoardLimits(){
        Game game = new Game();
        int coordinateExceeded = game.gameBoardLength +1;
        int[] guessCoordinates = {coordinateExceeded,coordinateExceeded};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            game.evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, game.ship, game.water, game.hit, game.miss);
        });
    }
    @Test
    public void testUndetectedShipMiss() {
        int[] shipLocation = {1, 1};
        Game game = new Game();
        game.undetectedShip(gameBoard, shipLocation);
        assertEquals(game.undetectedShipNumber, game.shipNumber);
    }
    @Test
    public void testUndetectedShipHit() {
        int[] shipLocation = {0, 0};
        Game game = new Game();
        game.undetectedShip(gameBoardHit, shipLocation);
        assertEquals(game.undetectedShipNumber, game.shipNumber - 1);
    }
}
