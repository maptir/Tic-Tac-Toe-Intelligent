package tictactoe;

public class BestMove {
	public int x, y, score;

	public BestMove() {

	}

	public BestMove(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
