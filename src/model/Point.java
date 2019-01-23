/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author minh
 *
 */
public class Point implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8220854637395030605L;
	public int X;
	public int Y;
	
	public Point(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
}
