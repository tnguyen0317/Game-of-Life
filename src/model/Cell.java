/**
 * 
 */
package model;

import java.awt.Rectangle;
import java.io.Serializable;

/**
 * @author minh
 *
 */
public class Cell implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1976899883845227065L;
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
	
	public Point getPosition() {
		return position;
	}

	public int getSize() {
		return size;
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
		if(this.position.Y != 0)
			if (b.GetCell(position.X,position.Y-1).isAlive)
				count++;
		//upper right corner
		if(this.position.X != b.sizeColumn - 1 && this.position.Y != 0)
			if(b.GetCell(position.X+1,position.Y-1).isAlive)
				count++;
		//right of current cell
		if(this.position.X != b.sizeColumn - 1)
			if(b.GetCell(position.X+1,position.Y).isAlive)
				count++;
		//lower right corner
		if((this.position.X != b.sizeColumn - 1) && (this.position.Y != b.sizeRow - 1))
			if(b.GetCell(position.X+1,position.Y+1).isAlive)
				count++;
		//below current cell
		if(this.position.Y != b.sizeRow - 1)
			if(b.GetCell(position.X,position.Y+1).isAlive)
				count++;
		//lower left corner
		if(this.position.X != 0 && this.position.Y != b.sizeRow - 1)
			if(b.GetCell(position.X-1,position.Y+1).isAlive)
				count++;
		//left of current cell
		if(this.position.X != 0)
			if(b.GetCell(position.X-1,position.Y).isAlive)
				count++;
		//upper left corner
		if(this.position.X != 0 && this.position.Y != 0)
			if(b.GetCell(position.X-1,position.Y-1).isAlive)
				count++;
		
		return count;
	}


}
