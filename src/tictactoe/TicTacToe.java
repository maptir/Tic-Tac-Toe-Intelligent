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
		boolean youFirst = moveFirst();
		char player1 = pickOX();
		char computer = opposite(player1);
		draw(board, player1);
		while (!gameOver(board)) {
			if (youFirst) {
				handleMouseClick(board, player1);
				draw(board, player1);
			} else {
				chooseMove(board, computer);
				draw(board, computer);
			}
			youFirst = !youFirst;
		}
	}

	/** Choose best move for computer */
	public static void chooseMove(char[][] board, char computer) {
		
	}

	/** Returns true if you are first player. */
	public static boolean moveFirst() {
		StdDraw.text(1, 1.5, "Who move first ?");
		StdDraw.line(1, 0.75, 1, 1.25);
		StdDraw.text(0.5, 1, "You");
		StdDraw.text(1.5, 1, "Computer");
		StdDraw.show(0);
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		double x = StdDraw.mouseX();
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		StdDraw.clear();
		return x < 1;
	}

	/** Returns 'O' if you pick O or 'X' if you pick X. */
	public static char pickOX() {
		StdDraw.text(1, 1.5, "Pick what you want O or X ?");
		StdDraw.line(1, 0.75, 1, 1.25);
		StdDraw.text(0.5, 1, "O");
		StdDraw.text(1.5, 1, "X");
		StdDraw.show(0);
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		double x = StdDraw.mouseX();
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		StdDraw.clear();
		return x < 1 ? 'O' : 'X';
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
			StdDraw.text(1.0, -0.6, winner + " win!");
		else if (isFull(board))
			StdDraw.text(1.0, -0.6, "Draw!");
		else
			StdDraw.text(1.0, -0.6, player + " to play. Click in a square.");
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
	public static void handleMouseClick(char[][] board, char player) {
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		int x = (int) Math.round(StdDraw.mouseX());
		int y = (int) Math.round(StdDraw.mouseY());
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		if (x >= board.length || y >= board.length || x < 0 || y < 0)
			return;
		if (board[x][y] == ' ') {
			board[x][y] = player;
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

	/** Returns the opposite player's character. */
	public static char opposite(char player) {
		if (player == 'X') {
			return 'O';
		} else {
			return 'X';
		}
	}
}
