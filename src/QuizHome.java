

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.controller.AdminController;
import quiz.model.User;

/**
 * Servlet implementation class QuizHome
 */
@WebServlet("/QuizHome")
public class QuizHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession();  
        
        User user = (User) session.getAttribute("user");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SEN632 - Team Fusion Java Project</title>");
        out.println("</head>");
        out.println("<body>");
        if(user != null){
	        out.println("<h3> Quiz Dashboard</h3>");
	        out.println("<h2> Welcome, "+user.getUsername()+"</h2>");
	        out.println("<h1> Please find your options below</h1>");
	        if(user.getUserLevel() == User.ADMIN){
	        	HashMap<String, User> userList = AdminController.getUserList();
	        	//loop
	        	for (Map.Entry<String, User> entry : userList.entrySet())
    			{
    			    System.out.println(entry.getKey() + "/" + entry.getValue());
    			    
    			    out.println("<p> User: "+entry.getKey().toString()+" <a href='DeleteUser?user_id="+((User)entry.getValue()).getId()+"'>Delete User</a> <a href='ViewScore?user_id="+((User)entry.getValue()).getId()+"'>View Score</a></p>");
    			}
	        	
	        }else if(user.getUserLevel() == User.STUDENT){
	        	 out.println("<p><a href='Quiz'>Start Quiz!</a></p>");
	        }else if(user.getUserLevel() == User.INSTRUCTOR){
	        	RequestDispatcher rs = request.getRequestDispatcher("InstructorHome");
	            rs.forward(request, response);
	            return;
	        }
        }else{
        	out.println("User not logged in");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
