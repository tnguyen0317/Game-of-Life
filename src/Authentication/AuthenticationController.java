/**
 * 
 */
package Authentication;

import java.util.Map;

/**
 * @author thong
 *
 */
public class AuthenticationController {
	
	private AuthenticationView _view;
	private UserDB _model;
	
	public AuthenticationController(AuthenticationView view, UserDB model) {
		_view = view;
		_model = model;
		
		_view.getBtnLogin().addActionListener(e -> this.Validate());
		
//		for (String user : _model.getUser()) {
//			
//		}
	}

	private void Validate() {
		
		String username = _view.getTextFieldUserName().getText();
		String password = new String(_view.getPasswordField().getPassword());
		Map<String, String> db = _model.getUser();
	
		if(db.containsKey(username)) {
			String dbPassword = db.get(username);

			if (dbPassword.equals(password))
				System.out.println("success!");
			else
				System.out.println("FAIL!");

		}
			
		
		System.out.println("test");
		
	}
	
	
	

}
