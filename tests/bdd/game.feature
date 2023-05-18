Feature: Game

    As a user, I want to attack the board coordinates to find the ships positioned

    Scenario: Attack empty position
        Given the board is sized 5x5
        And that the player has a ship positioned at coordinates (2,3), (2,4) and (2,5)
        When the player attacks the coordinate (5,5)
        Then the player receives a "Miss!" and the coordinate (5,5) is marked as attacked

    Scenario: Attack position with ship
        Given the board is sized 5x5
        And that the player has a ship positioned at coordinates (2,3), (2,4), (2,5) and (2,6)
        When the player attacks the coordinate (2,4)
        Then the player receives a "Hit!" and the coordinate (2,4) is marked as attacked

    Scenario: Win the game
        Given the board is sized 5x5
        And that the player has a ship positioned at coordinates (2,3), (2,4) and (2,5)
        And that the player attacks the coordinates (2,3), (2,4) and (2,5)
        When all ship coordinates are marked as attacked
        Then the player gets a message "You won the game!"
    
    Scenario: Check amount of remaining ships
        Given the board is sized 5x5
        And that the player has four ships positioned
        When the player checks the amount of remaining ships
        Then the player receives the information that he still has four ships
    
    Scenario: Attempt to position ship overlapping another ship
        Given the board is sized 5x5
        And that the player already has a ship positioned at coordinates (3,3), (3,4) and (3,5)
        When the player tries to place a ship at coordinates (3,5)
        Then the player gets an "Invalid Position" error message
