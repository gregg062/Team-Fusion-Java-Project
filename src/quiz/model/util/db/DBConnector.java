package quiz.model.util.db;

import java.sql.*;
import java.util.HashMap;

import quiz.model.Admin;
import quiz.model.Instructor;
import quiz.model.Question;
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
	
	public static boolean registerUserDB(String name, String username, String pass){
		try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("insert into users(user_level,username,password, name) values (?,?,password(?),?)");
	        ps.setInt(1, 3);
	        ps.setString(2, username);
	        ps.setString(3, pass);
	        ps.setString(4, name);
	        ps.execute();
	         
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	         return false;
	     }
		
	    return true; 
	}
	
	public static boolean addQuestionDB(String subject, String prompt, String answer_one, String answer_two, String answer_three, String answer_four, String correct){
		try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("insert into questions(subject, prompt, answer_one, answer_two, answer_three, answer_four, correct) values (?,?,?,?,?,?,?)");
	        ps.setString(1, subject);
	        ps.setString(2, prompt);
	        ps.setString(3, answer_one);
	        ps.setString(4, answer_two);
	        ps.setString(5, answer_three);
	        ps.setString(6, answer_four);
	        ps.setString(7, correct);
	        ps.execute();
	         
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	         return false;
	     }
		
	    return true; 
	}
	
	public static boolean saveAnswer(int user_id, String question_id, String answer){
		try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("insert into answers(user_id, question_id, answer) values (?,?,?)");
	        ps.setInt(1, user_id);
	        ps.setInt(2, Integer.parseInt(question_id));
	        ps.setString(3, answer);
	        ps.execute();
	         
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	         return false;
	     }
		
	    return true; 
	}
	
	public static boolean deleteQuestion(String question_id){
		try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("delete from questions where question_id= ?");
	        ps.setInt(1, Integer.parseInt(question_id));
	        ps.execute();
	         
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	         return false;
	     }
		
	    return true; 
	}
	
	public static boolean deleteUserDB(String user_id){
		try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("delete from users where id= ?");
	        ps.setInt(1, Integer.parseInt(user_id));
	        ps.execute();
	         
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	         return false;
	     }
		
	    return true; 
	}
	
	public static HashMap<String, User> getUserList(){
		HashMap<String, User> userList = new HashMap<String, User>();
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
		        userList.put(username, user);
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
	
	public static HashMap<String, Question> getQuestionList(){
		HashMap<String, Question> questionList = new HashMap<String, Question>();
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select * from questions order by question_id");
	        
	        ResultSet rs =ps.executeQuery();
	        while(rs.next()){
	        	Question question;
	        	int question_id = rs.getInt("question_id");
	        	String subject = rs.getString("subject");
	        	String prompt = rs.getString("prompt");
	        	String answer_one = rs.getString("answer_one");
	        	String answer_two = rs.getString("answer_two");
	        	String answer_three = rs.getString("answer_three");
	        	String answer_four = rs.getString("answer_four");
	        	String correct = rs.getString("correct");
	        	question = new Question(question_id, subject, prompt, answer_one, answer_two, answer_three, answer_four, correct);
	        	questionList.put(Integer.toString(question_id), question);
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return questionList;
	}	
	
	public static Question getRandomQuestion(int user_id){
		Question question = null;
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select * from questions where question_id not in (select user_id from answers where user_id=?) order by rand() limit 1");
	        
	        ps.setInt(1, user_id);
	        ResultSet rs =ps.executeQuery();
	        while(rs.next()){
	        	int question_id = rs.getInt("question_id");
	        	String subject = rs.getString("subject");
	        	String prompt = rs.getString("prompt");
	        	String answer_one = rs.getString("answer_one");
	        	String answer_two = rs.getString("answer_two");
	        	String answer_three = rs.getString("answer_three");
	        	String answer_four = rs.getString("answer_four");
	        	String correct = rs.getString("correct");
	        	question = new Question(question_id, subject, prompt, answer_one, answer_two, answer_three, answer_four, correct);
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return question; 
	}
	
	public static int getQuestionNumber(int user_id){
		int number = 1;
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select count(*) as number from answers where user_id=?");
	        
	        ps.setInt(1, user_id);
	        ResultSet rs =ps.executeQuery();
	        while(rs.next()){
	        	number = rs.getInt("number");
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return number;
	}
	
	public static int getQuizScore(int user_id){
		int number = 1;
	    try{
			Connection conn = openDBConn();
		 
	        PreparedStatement ps =conn.prepareStatement
	                            ("select count(*) as number from answers a, questions q where a.user_id=? and a.answer = q.correct and a.question_id = q.question_id");
	        
	        ps.setInt(1, user_id);
	        ResultSet rs =ps.executeQuery();
	        while(rs.next()){
	        	number = rs.getInt("number");
	        }
	         
	        rs.close();
	        ps.close();
	        conn.close();
	       
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	    return number;
	}
}
