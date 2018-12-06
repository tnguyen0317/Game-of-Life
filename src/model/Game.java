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
	private double updateTime = 1.0;
	
	public Game() {
	}
	
	public Game(int column, int row) {
		board = new Board(column,row);
	}
	
	public Game(Board board,double updateTime) {
		this.board = board;
		this.updateTime = updateTime;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public double getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(double updateTime) {
		this.updateTime = updateTime;


	}
}
