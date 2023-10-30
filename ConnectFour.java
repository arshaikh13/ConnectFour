import java.util.Scanner;

public class ConnectFour
{
    public static void main(String args[])
    {
        // variables
        Scanner input = new Scanner(System.in);
        char[][] board = new char[7][8];
        boolean finished = false;
        boolean gameOver = false;
        char currentPlayer = 'X';
        int numMoves = 0;

        // loop until the user wants to stop
        do
        {
            // Initialize the game board
            for (int r = 1; r < board.length; r++)
            {
                for (int c = 1; c < board[r].length; c++)
                {
                    board[r][c] = '-';
                }
            }

            // Display the board
            DisplayBoard(board);

            // Loop until this game is over
            do
            {
                // Get the next move for the current player
                int columnChosen = 0;
                boolean validInput = false;

                do
                {
                    try
                    {
                        System.out.print("Enter the column you want to place your piece: ");
                        columnChosen = input.nextInt();
                        
                        if (columnChosen < 1 || columnChosen > 7 || board[1][columnChosen] != '-') {
                            System.out.println("Please choose another column!");
                        } 
                        
                        else {
                            validInput = true;
                        }

                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Please enter a valid column number (1-7)!");
                        input.nextLine(); // Consume invalid input
                    }

                } while (!validInput);

                // Place the piece
                int row = 1;

                for (row = board.length - 1; row > 0; row--) 
                {
                    if (board[row][columnChosen] == '-') {
                        board[row][columnChosen] = currentPlayer;
                        break; 
                    }
                }

                // Increment the number of moves
                numMoves++;

                // Display the board
                DisplayBoard(board);

                // Check for a win
                if (CheckForWin(board) == true)
                {
                    // If the player wins, display congratulations and set gameOver to true
                    System.out.println("Congratulations, you won!");
                    gameOver = true;
                }

                else if (numMoves == 42)
                {
                    // If it's a tie, display the result and set gameOver to true
                    System.out.println("It was a tie!");
                    gameOver = true;
                }

                else
                {
                    // Switch the current player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            } while (!gameOver);

            // Ask if the user wants to play again, set finished accordingly
            System.out.print("Type 'Yes' to play again or end the game: ");
            String gameOption = input.next();

            if (gameOption.equalsIgnoreCase("Yes")) {
                finished = false;
            } 
            
            else {
                finished = true;
                System.out.println("Good Bye!");
            }
            
        } while (!finished);
    }

    // This method displays the board passed in
    public static void DisplayBoard(char[][] board)
    {
        System.out.println("\t1\t2\t3\t4\t5\t6\t7");
        for (int r = 1; r < board.length; r++)
        {
            System.out.print(r);

            for (int c = 1; c < board[r].length; c++)
            {
                System.out.print("\t" + board[r][c]);
            }
            System.out.println();
        }
    }

    // This method determines if a game has been won
    public static boolean CheckForWin(char[][] board)
    {
        // Check for horizontal wins
        for (int r = 1; r <= 6; r++)
        {
            for (int c = 1; c <= 4; c++)
            {
                if (board[r][c] == board[r][c+1] &&
                    board[r][c] == board[r][c+2] &&
                    board[r][c] == board[r][c+3] &&
                    board[r][c] != '-')
                {
                    return true;
                }
            }
        }

        // Check for vertical wins
        for (int r = 1; r <= 3; r++)
        {
            for (int c = 1; c <= 7; c++)
            {
                if (board[r][c] == board[r+1][c] &&
                    board[r][c] == board[r+2][c] &&
                    board[r][c] == board[r+3][c] &&
                    board[r][c] != '-')
                {
                    return true;
                }
            }
        }

        // Check for diagonal wins (upwards)
        for (int r = 4; r <= 6; r++)
        {
            for (int c = 1; c <= 4; c++)
            {
                if (board[r][c] == board[r-1][c+1] &&
                    board[r][c] == board[r-2][c+2] &&
                    board[r][c] == board[r-3][c+3] &&
                    board[r][c] != '-')
                {
                    return true;
                }
            }
        }

        // Check for diagonal wins (downwards)
        for (int r = 1; r <= 3; r++)
        {
            for (int c = 1; c <= 4; c++)
            {
                if (board[r][c] == board[r+1][c+1] &&
                    board[r][c] == board[r+2][c+2] &&
                    board[r][c] == board[r+3][c+3] &&
                    board[r][c] != '-')
                {
                    return true;
                }
            }
        }

        return false;
    }
}
