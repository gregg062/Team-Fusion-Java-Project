package quiz.model;

public abstract class User {
	private int _id;
	private int _userlevel;
	private String _username;
	
	public static int ADMIN = 1;
	public static int INSTRUCTOR = 2;
	public static int STUDENT = 3;
	
	
	public User() {}
	
	public User(int id,int userlevel,String username){
		_id = id;
		_userlevel = userlevel;
		_username = username;
	}
	
	public int getId(){
		return _id;
	}
	public void setId(int id){
		_id = id;
	}
	
	public int getUserLevel(){
		return _userlevel;
	}
	public void setUserLevel(int userlevel){
		_userlevel = userlevel;
	}
	
	public String getUsername(){
		return _username;
	}
	public void setUsername(String username){
		_username = username;
	}
		
}
