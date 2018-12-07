package model;
/**
 * 
 */

/**
 * @author minh
 *
 */
public class Game {
	private Board board;
	private boolean isPaused = false;
	private double updatesPerSecond = 1.0;
	
	public Game() {
	}
	
	public Game(double update) {
		this.updatesPerSecond = update;
	}
	
	public Game(int column, int row) {
		board = new Board(column,row);
	}
	
	public Game(Board board) {
		this.board = board;
;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public double getUpdatesPerSecond() {
		return updatesPerSecond;
	}

	public void setUpdatesPerSecond(double updateTime) {
		this.updatesPerSecond = updateTime;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
}
