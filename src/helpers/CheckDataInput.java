/**
 * 
 */
package helpers;

import java.util.regex.*;

/**
 * @author thong
 *
 */
public class CheckDataInput {
	
	public static boolean checkMatrixInput(CharSequence textinput) {
		
		return Pattern.matches("[1-9][0-9]*x[1-9][0-9]*", textinput);
	}
}
