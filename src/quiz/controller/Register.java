package quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.model.RegisterStudent;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
        
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        
        boolean registered = RegisterStudent.registerUser(name, username, pass);
        		
        if(registered)
        {
            //HttpSession session=request.getSession();  
	        //session.setAttribute("user",user);
        	out.println("User registered");
        	RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Error. User not registered.");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.forward(request, response);
        }
	}

}
