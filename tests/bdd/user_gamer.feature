Feature: User Gamer

    As a user, I want to type a row and a column and check if the system returns me a ship or not;

    Scenario: Perform move on the board
        Given the board is visible to the user
        When he types a valid line
        And a valid column
        Then the system will mark the move on the board
        And returns if the position has a ship or not

    Scenario: Perform a move with previously revealed coordinates
        Given the board is visible to the user
        When he types a row and a column it is already revealed
        Then the system returns that the move has already been made in that position

    Scenario: Perform a move with coordinates that exceed the size of the board
        Given the board is visible to the user
        When he types a row or a column that exceeds the board size
        Then the system returns an error or exception message indicating that the entered coordinate is exceeding the boundaries of the board
        And asks the user to enter them again

    Scenario: Perform a move with incompatible format
        Given the board is visible to the user
        When he types a row or a column in a format other than integer
        Then the system returns an error or exception message indicating that the entered coordinate needs to be of integer type
        And asks the user to enter them again

    Scenario: Perform a move with negative numbers
        Given the board is visible to the user
        When he enters a row or a column with a negative number
        Then the system returns an error or exception message indicating that the entered coordinate cannot be negative
        And asks the user to enter them again