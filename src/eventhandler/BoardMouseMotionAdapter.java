/**
 * 
 */
package eventhandler;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import model.*;


/**
 * @author thong
 *
 */
public class BoardMouseMotionAdapter implements MouseMotionListener{

	private Board board;
	
	public BoardMouseMotionAdapter(Board b) {
		board = b;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		boolean state = false;
		
		//add cells
		if(SwingUtilities.isLeftMouseButton(e))
			state = true;
		
		//remove cells
		if(SwingUtilities.isRightMouseButton(e))
			state = false;
	
		
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				
				Cell cell = board.GetCell(i,j);
				if(cell.getBoundary().contains(new Point(e.getX(),e.getY())))
					cell.setAlive(state);
			}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
