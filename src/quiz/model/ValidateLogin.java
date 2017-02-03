package quiz.model;

import quiz.model.util.db.DBConnector;

public class ValidateLogin {

	public static User checkUser(String username,String pass) 
    {
		User validated = DBConnector.verifyLoginDB(username, pass);
		return validated;
    }   
}