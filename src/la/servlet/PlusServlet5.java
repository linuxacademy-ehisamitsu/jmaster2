package la.servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PlusBean;

@WebServlet("/PlusServlet5")
public class PlusServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		
		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);
		int answer = i1 + i2;
		
		PlusBean bean = new PlusBean(i1,i2,answer);
		request.setAttribute("plus", bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet");
		rd.forward(request, response);
	}
}
