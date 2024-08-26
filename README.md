# Connect Four - Java Implementation

## Purpose

The **Connect Four** program is a Java implementation of the classic two-player board game, *Connect Four*. In this game, two players take turns dropping colored discs into a vertically suspended grid. The goal is to be the first to form a line of four discs, either horizontally, vertically, or diagonally.

## Overview

### 1. Initialization

The program starts by:
- Initializing the game board.
- Setting up necessary variables.
- Displaying an empty game board to the players.

### 2. Game Loop

The main game loop runs until the players decide to stop playing. The loop includes the following steps:

- **a. Player Input**:  
  The program prompts the current player to choose a column where they want to place their piece ('X' or 'O').

- **b. Input Validation**:  
  The program validates the input to ensure it is within the valid range of columns (1-7) and that the selected column is not already full.

- **c. Piece Placement**:  
  The program drops the player's piece into the chosen column, occupying the lowest available row.

- **d. Display Board**:  
  After each move, the updated game board is displayed, showing the current positions of all pieces.

- **e. Win and Tie Check**:  
  The program checks if the current player has won by forming a line of four pieces (in any direction). It also checks for a tie if all cells are filled with no winner.

- **f. Switch Player**:  
  If the game is not over, the program switches to the other player for their turn.

### 3. End of Round

At the end of the game (either due to a win or a tie), the program asks the players if they would like to play another round.

### 4. Restart or Exit

Based on the players' choice:
- **Restart**: The program resets the game and starts a new round.
- **Exit**: The program terminates.
