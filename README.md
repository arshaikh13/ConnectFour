Purpose:
The "Connect Four" program is a Java implementation of the classic two-player board game, Connect Four. In this game, two players take turns dropping colored discs (one being 'X' and the other 'O') into a vertically suspended grid. The goal of the game is to be the first to form a line of four of one's own discs, either horizontally, vertically, or diagonally.

Overview:
Initialization: The program starts by initializing the game board, setting up variables, and displaying an empty game board.

Game Loop: The main game loop continues until the players decide not to play another round. Inside this loop, the following steps occur:

a. Player Input: The program prompts the current player to choose a column where they want to place their piece ('X' or 'O').

b. Input Validation: The program validates the input to ensure it's within the range of 1-7 (the columns on the board) and that the chosen column is not already full.

c. Piece Placement: The program drops the player's piece into the selected column, occupying the lowest available row in that column.

d. Display Board: After each move, the updated game board is displayed, showing the pieces placed by the players.

e. Win and Tie Check: The program checks if the current player has won the game by connecting four pieces in any direction (horizontal, vertical, or diagonal) or if there's a tie when all cells are filled.

f. Switch Player: If the game is not over, the program switches to the other player for their turn.

End of Round: When the game ends (either due to a win or a tie), it asks the players if they want to play another round.

Restart or Exit: Depending on the players' choice, the program either resets the game for another round or exits the program.
