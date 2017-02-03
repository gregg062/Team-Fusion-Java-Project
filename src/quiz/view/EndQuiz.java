package quiz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.controller.QuizController;
import quiz.model.User;

/**
 * Servlet implementation class QuizHome
 */
@WebServlet("/EndQuiz")
public class EndQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndQuiz() {
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
        
        int quizScore = QuizController.getQuizScore(user.getId());
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SEN632 - Team Fusion Java Project</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("	   <table>");
        out.println("			<tr>");
        out.println("				<td><h2>QUIZ results</h2></td>");
        out.println("			</tr>");
        out.println("			<tr>");
        out.println("				<td><h3>You answered "+Integer.toString(quizScore)+" out of 10 correctly.</h3></td>");
        if(quizScore >= 7){
        	out.println("				<td><h3>You Passed.</h3></td>");
        }else{
        	out.println("				<td><h3>You Failed.</h3></td>");	
        }
        out.println("			</tr>");
        out.println("		</table>");
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
