package quiz.model.util.db;

import java.sql.*;
import java.util.Map;

import quiz.model.Admin;
import quiz.model.Instructor;
import quiz.model.Student;
import quiz.model.User;

public abstract class DBConnector {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/quiz";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "sen603";
	
	public DBConnector(){}
	
	private static Connection openDBConn(){
		Connection conn = null;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		return conn;
	}
	
	public static String selectQuery(String query_sql) throws SQLException{
		return "";
	}
	
	public static User verifyLoginDB(String username,String pass){
		User user = null;
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select * from users where username=? and password=password(?)");
	        ps.setString(1, username);
	        ps.setString(2, pass);
	        ResultSet rs =ps.executeQuery();
	        rs.next();
	        int id = rs.getInt("id");
	        int userlevel = rs.getInt("user_level");
	        if(userlevel == User.ADMIN){
	        	user = new Admin(id, userlevel, username);
	        }else if(userlevel == User.INSTRUCTOR){
	        	user = new Instructor(id, userlevel, username);
	        }else{
	        	user = new Student(id, userlevel, username);
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return user; 
	}
	
	public static Map<String, User> getUserList(){
		Map<String, User> userList = null;
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select * from users");
	        
	        ResultSet rs =ps.executeQuery();
	        while(rs.next()){
	        	User user;
		        int id = rs.getInt("id");
		        int userlevel = rs.getInt("user_level");
		        String username = rs.getString("username");
		        if(userlevel == User.ADMIN){
		        	user = new Admin(id, userlevel, username);
		        }else if(userlevel == User.INSTRUCTOR){
		        	user = new Instructor(id, userlevel, username);
		        }else{
		        	user = new Student(id, userlevel, username);
		        }
		        userList.put("username", user);
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return userList; 
	}
}
