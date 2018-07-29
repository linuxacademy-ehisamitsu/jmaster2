package la.servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlusServlet4")
public class PlusServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		
		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);
		int answer = i1 + i2;
		
		request.setAttribute("data1", new Integer(i1));
		request.setAttribute("data2", new Integer(i2));
		request.setAttribute("answer", new Integer(answer));
		
		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet");
		rd.forward(request, response);
	}
}
