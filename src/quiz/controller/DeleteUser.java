package quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(user.getUserLevel() != User.ADMIN)
        {
        	out.println("Error, not allowed");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
            return;
        }
        else
        {
        	boolean userDeleted = QuizController.deleteUser(user_id);
        	if(userDeleted)
            {
                RequestDispatcher rs = request.getRequestDispatcher("QuizHome");
                rs.forward(request, response);
                return;
            }
            else
            {
               out.println("Error deleting user");
               System.out.println("Error deleting user");
               RequestDispatcher rs = request.getRequestDispatcher("index.html");
               rs.forward(request, response);
               return;
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

