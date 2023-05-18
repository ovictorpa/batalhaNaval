Feature: Initial User

    As a user, I want to pick coordinates of ships on the board so my friend can try to get it right.

    Scenario: Enter coordinates of ships on the board
        Given The user has the coordinates of the line
        And have the column coordinates
        When entering these coordinates in the game
        Then the system stores the location of the ships
        And the board with the hidden ships will return

    Scenario: Enter coordinates of ships that exceed the limit of the board
        Given The user has the coordinates of the line
        And have the column coordinates
        And these coordinates are larger than the size of the board
        When entering these coordinates in the game
        Then the system returns an error or exception message indicating that the entered coordinate is exceeding the boundaries of the board
        And asks the user to enter them again

    Scenario: Enter ship coordinates with incompatible format
        Given The user has the coordinates of the line
        And have the column coordinates
        And these coordinates are incompatible with the integer variable type
        When entering these coordinates in the game
        Then the system returns an error or exception message indicating that the entered coordinate needs to be of integer type
        And asks the user to enter them again

    Scenario: Insert ship coordinates with negative numbers
        Given The user has the coordinates of the line
        And have the column coordinates
        And these coordinates are negative
        When entering these coordinates in the game
        Then the system returns an error or exception message indicating that the entered coordinate cannot be negative
        And asks the user to enter them again


