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
	
	public Game(Board board,double updateTime) {
		this.board = board;
		this.updateTime = updateTime;
	}

}
