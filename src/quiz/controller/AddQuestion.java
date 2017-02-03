package quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestion() {
        super();
        // TODO Auto-generated constructor stub
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
        
        String subject = request.getParameter("subject");
        String prompt = request.getParameter("prompt");
        String answer_one = request.getParameter("answer_one");
        String answer_two = request.getParameter("answer_two");
        String answer_three = request.getParameter("answer_three");
        String answer_four = request.getParameter("answer_four");
        String correct = request.getParameter("correct");
        
        boolean added = QuizController.addQuestion(subject, prompt, answer_one, answer_two, answer_three, answer_four, correct);
        		
        if(added)
        {
        	out.println("Question added");
        	RequestDispatcher rs = request.getRequestDispatcher("InstructorHome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Error. Question not added.");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.forward(request, response);
        }
	}

}
