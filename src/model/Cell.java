/**
 * 
 */
package model;

/**
 * @author minh
 *
 */
public class Cell {
	public Point position;
	public boolean isAlive;
	
	public Cell() {
		isAlive = false;
	}
	
	public int GetNeighbours(Board b) {
		int count = 0;
		
		//check all eight cells around if they are alive
		
		//above current cell
		if (b.GetCell(position.X,position.Y+1).isAlive)
			count++;
		//upper right corner
		if(b.GetCell(position.X+1,position.Y+1).isAlive)
			count++;
		//right of current cell
		if(b.GetCell(position.X+1,position.Y).isAlive)
			count++;
		//lower right corner
		if(b.GetCell(position.X+1,position.Y-1).isAlive)
			count++;
		//below current cell
		if(b.GetCell(position.X,position.Y-1).isAlive)
			count++;
		//lower left corner
		if(b.GetCell(position.X-1,position.Y-1).isAlive)
			count++;
		//left of current cell
		if(b.GetCell(position.X-1,position.Y).isAlive)
			count++;
		//upper left corner
		if(b.GetCell(position.X-1,position.Y+1).isAlive)
			count++;
		
		return count;
	}
	
}
