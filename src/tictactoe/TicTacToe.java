package tictactoe;

/** The three-in-a-row game for two human players. */
public class TicTacToe {

	/** Plays the game. */
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				board[x][y] = ' ';
			}
		}
		StdDraw.setXscale(-0.5, 2.5);
		StdDraw.setYscale(-0.5, 2.5);
		char currentPlayer = 'X';
		char npc = 'O';
		draw(board, currentPlayer);
		while (!gameOver(board)) {
			if (handleMouseClick(board, currentPlayer)) {
				currentPlayer = opposite(currentPlayer);
				draw(board, currentPlayer);
			}
		}
	}

	/**
	 * Draws the state of board, including instructions or a game over message.
	 */
	public static void draw(char[][] board, char player) {
		StdDraw.clear();
		StdDraw.line(0.5, -0.5, 0.5, 2.5);
		StdDraw.line(1.5, -0.5, 1.5, 2.5);
		StdDraw.line(-0.5, 0.5, 2.5, 0.5);
		StdDraw.line(-0.5, 1.5, 2.5, 1.5);
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				StdDraw.text(x, y, board[x][y] + "");
			}
		}
		char winner = winner(board);
		if (winner != 0)
			StdDraw.text(1.0, -0.5, winner + " win!");
		else if(isFull(board))
			StdDraw.text(1.0, -0.5, "Draw!");
		else
			StdDraw.text(1.0, -0.5, player + " to play. Click in a square.");
		StdDraw.show(0);
	}

	/** Returns true if the game is over. */
	public static boolean gameOver(char[][] board) {
		return winner(board) != 0 || isFull(board);
	}

	/**
	 * Handles a mouse click, placing player's mark in the square on which the user
	 * clicks. Return true if click on blank space else false.
	 */
	public static boolean handleMouseClick(char[][] board, char player) {
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		int x = (int) Math.round(StdDraw.mouseX());
		int y = (int) Math.round(StdDraw.mouseY());
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		if (x >= board.length || y >= board.length || x < 0 || y < 0)
			return false;
		if (board[x][y] == ' ') {
			board[x][y] = player;
			return true;
		}
		return false;
	}

	public static char winner(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
				return board[i][0];
			else if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
				return board[0][i];
		}
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
			return board[0][0];
		else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
			return board[0][2];
		return 0;
	}

	/** Returns true if board is full. */
	public static boolean isFull(char[][] board) {
		System.out.println(1);
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if (board[x][y] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	/** Returns the opposite player's character. */
	public static char opposite(char player) {
		if (player == 'X') {
			return 'O';
		} else {
			return 'X';
		}
	}
}
