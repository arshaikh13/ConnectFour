import java.util.Scanner;
public class Lab6
{
	public static void main(String args[])
	{
		// variables
		Scanner input = new Scanner(System.in);
		char[][] board = new char[7][8];
		boolean finished = false;
		boolean gameOver;
		char currentPlayer;
		int numMoves;

		// loop until user wants to stop
		do
		{
			// init game board
			for (int r = 1; r < board.length; r++)
			{
				for (int c = 1; c < board[r].length; c++)
				{
					board[r][c] = '-';
				}
			}

			// initialize variables
			numMoves = 0;
			gameOver = false;
    		currentPlayer = 'X';

			// display the board
			DisplayBoard(board);

			// loop until this game is over
			do
			{
				// get the next move for the current player
				int columnChosen = 0;
				do
				{
					System.out.print("Enter the column you want to place your piece: ");
					columnChosen = input.nextInt();

					if (columnChosen < 1 || columnChosen > 7 || board[1][columnChosen] != '-') {
						System.out.println("Please choose another column!");
					}

				} while (columnChosen < 1 || columnChosen > 7 || board[1][columnChosen] != '-');

				// place piece
				int row = 1;

				for (row = board.length - 1; row > 0; row--) 
				{
					if (board[row][columnChosen] == '-') {
						board[row][columnChosen] = currentPlayer;
						break; 
					}
				}

				// increment number of moves
				numMoves++;

				// display the board
				DisplayBoard(board);

				// check for win
				if (CheckForWin(board) == true)
				{
					// if winner, display congratulations and set gameOver true
					System.out.println("Congratulations, you won!");
					gameOver = true;
				}
				else if (numMoves == 42)
				{
					// if tie, display result and set gameOver true
					System.out.println("It was a tie!");
					gameOver = true;
				}
				else
				{
					// switch current player
					currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
				}


			} while (!gameOver);

			// ask if user wants to play again, set finished accordingly
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

	// this method displays the board passed in
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

	// this method determines if a game has been won
	public static boolean CheckForWin(char[][] board)
	{
		// check for horizontal
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

		// check for vertical
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

		// check for diagonal up
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
			
		// check for diagonal down
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
