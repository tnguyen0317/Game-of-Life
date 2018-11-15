/**
 * 
 */
package model;

/**
 * @author minh
 *
 */
public class Board {
	private Cell[][] cells;
	public int sizeColumn;
	public int sizeRow;

	//Constructors and get/set methods
	public Board(Cell[][] Cells) {
		this.cells = Cells;
	}

	public Board(int column, int row) {
		this.sizeColumn = column;
		this.sizeRow = row;

		this.cells = new Cell[sizeColumn][sizeRow];
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	//Update the board with a constant time counting each cells neighbours
	//and applying rules of the game
	public void updateBoard() {
		
	}
	
}
