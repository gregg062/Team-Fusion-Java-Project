package quiz.model;

import quiz.model.util.db.DBConnector;

public class RegisterStudent {
	public static boolean registerUser(String name, String username,String pass) 
    {
		boolean registered = DBConnector.registerUserDB(name, username, pass);
		return registered;
    }
}
