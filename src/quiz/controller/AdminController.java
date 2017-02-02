package quiz.controller;

import java.util.HashMap;

import quiz.model.User;
import quiz.model.util.db.DBConnector;

public class AdminController {
	public static HashMap<String, User> getUserList(){
		HashMap<String, User> userList = DBConnector.getUserList();
		return userList;
	}
}
