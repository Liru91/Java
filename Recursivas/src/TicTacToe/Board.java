package TicTacToe;
public class Board {

	// Implement this method returning the winner's coordinates
	// {(x,y),(x,y),(x,y)} from left to right and top to bottom
	public static int[] winner(int[][] board) {

		int[] coordinates = new int[6];
		
		// Write here your code
		// Check all the winners
		
		// HORITZONTAL - 3 possibilities
		for (int i = 0; i< board.length; i++) {
			if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2])) {
				coordinates[0] = i;
				coordinates[1] = 0;
				coordinates[2] = i;
				coordinates[3] = 1;
				coordinates[4] = i;
				coordinates[5] = 2;
				
				return coordinates;
			}
		}
		
		// 1 0 1
		// 1 0 0
		// 0 0 1

		// VERTICAL - 3 possibilities
		for (int i = 0; i< board.length; i++) {
			if ((board[0][i] == board[1][i]) && (board[0][i] == board[2][i])) {
				coordinates[0] = 0;
				coordinates[1] = i;
				coordinates[2] = 1;
				coordinates[3] = i;
				coordinates[4] = 2;
				coordinates[5] = i;
				
				return coordinates;
			}
		}
		
		// DIAGONAL - 2 possibilities
 
		if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2])) {
			coordinates[0] = 0;
			coordinates[1] = 0;
			coordinates[2] = 1;
			coordinates[3] = 1;
			coordinates[4] = 2;
			coordinates[5] = 2;
			
			return coordinates;
		}
		
		if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0])) {
			coordinates[0] = 0;
			coordinates[1] = 2;
			coordinates[2] = 1;
			coordinates[3] = 1;
			coordinates[4] = 2;
			coordinates[5] = 0;
			
			return coordinates;
		}
		

		return coordinates;
	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printWinner(int[] coordinates) {
		for (int i = 0; i < coordinates.length; i++) {
			System.out.print(coordinates[i]);
			if (i % 2 == 0)
				System.out.print(",");
			else
				System.out.print(" ");
		}
	}

}