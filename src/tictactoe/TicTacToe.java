package tictactoe;

/** The three-in-a-row game for two human players. */
public class TicTacToe {

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
		StdDraw.text(1.0, -0.5, player + " to play. Click in a square.");
		StdDraw.show(0);
	}

	/** Returns true if the game is over. */
	public static boolean gameOver(char[][] board) {
		return isFull(board);
	}

	/**
	 * Handles a mouse click, placing player's mark in the square on which the user
	 * clicks.
	 */
	public static void handleMouseClick(char[][] board, char player) {
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		double x = Math.round(StdDraw.mouseX());
		double y = Math.round(StdDraw.mouseY());
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		int a = (int) x;
		int b = (int) y;
		if (board[a][b] == ' ') {
			board[a][b] = player;
		}
	}

	/** Returns true if board is full. */
	public static boolean isFull(char[][] board) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if (board[x][y] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

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
		draw(board, currentPlayer);
		while (!gameOver(board)) {
			handleMouseClick(board, currentPlayer);
			currentPlayer = opposite(currentPlayer);
			draw(board, currentPlayer);
		}
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
