/**
 * 
 */
package model;

import java.awt.Rectangle;

/**
 * @author minh
 *
 */
public class Cell {
	private final Point position;
	private boolean isAlive;
	private final Rectangle Boundary;
	private final int size;
	
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Rectangle getBoundary() {
		return Boundary;
	}
	

	public Cell(Point position,int size) {
		isAlive = false;
		this.position = position;
		this.size = size;
		Boundary = new Rectangle(position.X * size, position.Y * size, size, size);
		
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
