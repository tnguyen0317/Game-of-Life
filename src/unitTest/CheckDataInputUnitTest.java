/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import helpers.CheckDataInput;

/**
 * @author thong
 *
 */
class CheckDataInputUnitTest {

	/**
	 * Test method for {@link helpers.CheckDataInput#checkMatrixInput(java.lang.CharSequence)}.
	 */
	@Test
	void testCheckMatrixInput() {
		CharSequence testData = "15x10";
		
		boolean Actual = CheckDataInput.checkMatrixInput(testData);
		assertEquals(true, Actual);
	}

}
