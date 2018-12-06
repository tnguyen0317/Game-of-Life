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
	
	public Game(int column, int row) {
		board = new Board(column,row);
	}
	
	public Game(Board board,double updateTime) {
		this.board = board;
		this.updatesPerSecond = updateTime;
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
