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
@WebServlet("/SaveAnswer")
public class SaveAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAnswer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("Forbidden");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String question_id = request.getParameter("question_id");
        String answer = request.getParameter("answer");
        
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        
        boolean savedAnswer = QuizController.saveAnswer(user.getId(), question_id, answer);
        		
        if(savedAnswer)
        {
            RequestDispatcher rs = request.getRequestDispatcher("Quiz");
            rs.forward(request, response);
        }
        else
        {
           out.println("Error saving answer");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.forward(request, response);
        }
	}

}

