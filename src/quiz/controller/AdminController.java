package quiz.controller;

import java.util.Map;

import quiz.model.User;
import quiz.model.util.db.DBConnector;

public class AdminController {
	public Map<String, User> getUserList(){
		Map<String, User> userList = DBConnector.getUserList();
		return userList;
	}
}
