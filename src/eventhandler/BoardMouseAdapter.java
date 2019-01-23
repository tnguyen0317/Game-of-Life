/**
 * 
 */
package eventhandler;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MainWindowView;
import model.Board;
import model.Cell;
import model.Game;

/**
 * @author thong
 *
 */
public class BoardMouseAdapter implements MouseListener {

	private Board board;
	
	public BoardMouseAdapter(Board b){
		board = b;
	}
	/**
	 * Sets a single cell to alive if mouse is clicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				
				Cell cell = board.GetCell(i,j);
				if(cell.getBoundary().contains(new Point(e.getX(),e.getY())))
					cell.setAlive(true);
			}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
