package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String productNo = request.getParameter("product_no");
		int no = Integer.parseInt(productNo);
		String productName = "???";
		
		Map<Integer, String> productNameMap = new HashMap<Integer, String>();
		productNameMap.put(100, "パソコン");
		productNameMap.put(101, "プリンタ");
		productNameMap.put(102, "デジタルカメラ");
		
		if(productNameMap.containsKey(no)){
			productName = productNameMap.get(no);
		} else {
			productName = "???";
		}
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<String> cart = (ArrayList<String>)session.getAttribute("products");
		if(cart == null){
			cart = new ArrayList<String>();
			session.setAttribute("products", cart);
		}
		cart.add(productName);
		
		out.println("<html><head><title>ShowCart</title></head><body>");
		out.println("現在のカートの中身は下記の通りです<br/><br/>");
		for(int i = 0; i < cart.size(); i++){
			out.println(i+1);
			out.println(":" + cart.get(i) + "<br/>");
		}
		out.println("<hr><a href='/jmaster2/selectProduct3.html'>商品リスト</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
