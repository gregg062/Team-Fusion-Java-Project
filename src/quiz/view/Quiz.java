package quiz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.controller.QuizController;
import quiz.model.Question;
import quiz.model.User;

/**
 * Servlet implementation class QuizHome
 */
@WebServlet("/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz() {
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
        
        int questionNumber = QuizController.getQuestionNumber(user.getId())+1;
        
        if(questionNumber >= 10){
        	out.println("User not logged in");
            RequestDispatcher rs = request.getRequestDispatcher("EndQuiz");
            rs.forward(request, response);
            return;
        }
        
        Question question = QuizController.getQuestion(user.getId());
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SEN632 - Team Fusion Java Project</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <form method='post' action='SaveAnswer'>");
        out.println("	   <table>");
        out.println("			<tr>");
        out.println("				<td><h2>QUIZ - question "+Integer.toString(questionNumber)+" of 10</h2></td>");
        out.println("			</tr>");
        out.println("			<tr>");
        out.println("				<td><h3>"+question.getPrompt()+"</h3></td>");
        out.println("			</tr>");
        out.println("			<tr>");
        out.println("				<td>");
        out.println("				  <input type='hidden' name='question_id' value='"+question.getQuestionID()+"'>");
        out.println("				  <input type='radio' name='answer' value='A'>"+question.getAnswerOne()+"<br>");
        out.println("				  <input type='radio' name='answer' value='B'>"+question.getAnswerTwo()+"<br>");
        out.println("				  <input type='radio' name='answer' value='C'>"+question.getAnswerThree()+"<br>");
        out.println("				  <input type='radio' name='answer' value='D'>"+question.getAnswerFour()+"<br>");
        out.println("				</td>");
        out.println("			<tr>");
        out.println("				<td width='10%'><input type='submit' value='Answer'></td>");
        out.println("			</tr>");
        out.println("		</table>");
        out.println("	</form>");
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
