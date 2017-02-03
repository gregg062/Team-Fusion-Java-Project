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
@WebServlet("/DeleteQuestion")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question_id = request.getParameter("question_id");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(user.getUserLevel() != User.INSTRUCTOR)
        {
        	out.println("Error, not allowed");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
            return;
        }
        else
        {
        	boolean questionDeleted = QuizController.deleteQuestion(question_id);
        	if(questionDeleted)
            {
                RequestDispatcher rs = request.getRequestDispatcher("InstructorHome");
                rs.forward(request, response);
                return;
            }
            else
            {
               out.println("Error deleting question");
               System.out.println("Error deleting question");
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

