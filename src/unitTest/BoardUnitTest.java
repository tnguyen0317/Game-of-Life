/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;

/**
 * @author minh
 *
 */
class BoardUnitTest {

	Board b;
	void setUp() {
		b = new Board(15,15,15);
		
		
	}
	
	/**
	 * Test method for {@link model.Board#Board(model.Cell[][])}.
	 */
	@Test
	void testBoardCellArrayArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Board#Board(int, int)}.
	 */
	@Test
	void testBoardIntInt() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetCell() {
		setUp();
		
		
		b.GetCell(2, 5);
		
		
	}

	/**
	 * Test method for {@link model.Board#UpdateBoard()}.
	 */
	@Test
	void testUpdateBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Board#CheckRules()}.
	 */
	@Test
	void testCheckRules() {
		fail("Not yet implemented");
	}

}
