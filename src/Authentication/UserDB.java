/**
 * 
 */
package Authentication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author thong
 *
 */
public class UserDB {
	
	private Map<String,String> User;
	
	public UserDB() {
		User = new HashMap<String,String>();
		
		User.put("booli", "booli");
		User.put("hej", "hejdå");
		User.put("neq32", "123456");
		User.put("r432qe", "g5445ge223fT&3S");
		User.put("anders", "andersson");
	}

	public Map<String, String> getUser() {
		return User;
	}
	

}
