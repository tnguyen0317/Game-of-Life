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
	private boolean[][] nextGeneration;
	
	public int sizeColumn;
	public int sizeRow;

	//Constructors and get/set methods
	public Board() {
	}

	public Board(int column, int row) {
		this.sizeColumn = column;
		this.sizeRow = row;

		this.cells = new Cell[sizeColumn][sizeRow];

		this.nextGeneration = new boolean[sizeColumn][sizeRow];
		
		final int size = 10;
		
		//foreach element in the board, initialize it with a new instance of a Cell
		for(int i = 0; i < sizeColumn; i++)
			for(int j = 0; j < sizeRow; j++)
				this.nextGeneration[i][j] = false;
				this.cells[i][j] = new Cell(new Point(i,j),size);
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
	public Cell GetCell(int x, int y) {
		return this.cells[x][y];
	}
	
	//Update the board with a constant time counting each cells neighbours
	//and applying rules of the game
	public void UpdateBoard() {
		boolean alive,result;
		int count;
		
		
		for(int i = 0; i < sizeColumn; i++) {
			for (int j = 0; j < sizeRow; j++) {
				alive = this.cells[i][j].isAlive();
				result = false;
				count = this.cells[i][j].GetNeighbours(this);
				
				
				//apply rules
				
				//Death because of loneliness
				if(count < 2 && alive)
					result = false;
				//Right number to stay alive
				if((count == 2 || count == 3) && alive)
					result = true;
				//Death because of overcrowdedness
				if(count > 3 && alive)
					result = false;
				//Right number to become alive
				if(count == 3 && !alive)
					result = true;
				
				this.cells[i][j].setAlive(result);
				this.nextGeneration[i][j] = result;
				
			}
		}
		
		NextGeneration();
		
	}
	
	}
}
