/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Random;

/**
 * @author minh
 *
 */
public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9080955515452557280L;
	private Cell[][] cells;
	private boolean[][] nextGeneration;
	private int countGeneration = 0;
	private double initProbRate = 0.02;
	
	public int size = 15;
	public int sizeColumn;
	public int sizeRow;

	//Constructors and get/set methods
	public Board() {
	}

	public Board(int column, int row, int size) {
		this.sizeColumn = column;
		this.sizeRow = row;
		this.size = size;
	}
	
	//Getters and setters
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
	public Cell GetCell(int x, int y) {
		return this.cells[x][y];
	}
	
	public int getCountGeneration() {
		return countGeneration;
	}

	public void setCountGeneration(int countGeneration) {
		this.countGeneration = countGeneration;
	}
	public double getInitProbRate() {
		return initProbRate;
	}

	public void setInitProbRate(double initProbRate) {
		this.initProbRate = initProbRate;
	}

	//Update the board with a constant time counting each cells neighbours
	//and applying rules of the game
	/**
	 * Updates the board using GetNeighbours(); from the Cell class.
	 * And applies the rules of the game.
	 * 
	 * @param initProb gives the user an option of using initilization probability
	 * in the game. If this parameter is true, initilization probability is enabled
	 * and vice versa.
	 * The result is stored in the nextGeneration matrix array.
	 */
	public void UpdateBoard(boolean initProb) {
		boolean alive,result;
		int count;
		
		for(int i = 0; i < sizeColumn; i++) {
			for (int j = 0; j < sizeRow; j++) {
				alive = this.cells[i][j].isAlive();
				result = false;
				count = this.cells[i][j].GetNeighbours(this);
					
				Random random = new Random();
				
				float chance = random.nextFloat();
				
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
				
				if(initProb)
					if (chance <= initProbRate)
						result = true;
				
				this.nextGeneration[i][j] = result;
				
			}
		}
		countGeneration++;
		
		NextGeneration();
			
	}
	/**
	 * Sets the cells in this board object according to the nextGeneration matrix array
	 * 
	 */
	public void NextGeneration() {
		for(int i = 0; i < sizeColumn; i++)
			for(int j  = 0; j < sizeRow; j++)
				this.cells[i][j].setAlive(nextGeneration[i][j]);
	}
	/**
	 * Sets every cell in this board object to false.
	 */
	public void ClearBoard() {
		for(int i = 0; i < sizeColumn; i++)
			for(int j  = 0; j < sizeRow; j++)
				this.cells[i][j].setAlive(false);
	}
	/**
	 * Initializes field members with values and new instances
	 */
	public void InitBoard() {
		this.cells = new Cell[sizeColumn][sizeRow];

		this.nextGeneration = new boolean[sizeColumn][sizeRow];
		
		//foreach element in the board, initialize it with a new instance of a Cell
		for(int i = 0; i < sizeColumn; i++)
			for(int j = 0; j < sizeRow; j++)
			{
				this.nextGeneration[i][j] = false;
				this.cells[i][j] = new Cell(new Point(i,j),size);

			}
	}
}
