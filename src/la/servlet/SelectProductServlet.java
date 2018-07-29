package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String productNo = request.getParameter("product_no");
		int no = Integer.parseInt(productNo);
		Map<Integer,String> productMap = new HashMap<Integer,String>();
		productMap.put(100, "パソコン");
		productMap.put(101, "プリンタ");
		productMap.put(102, "デジタルカメラ");
		
		String productName = null;
		if(productMap.containsKey(no)){
			productName = productMap.get(no);
		} else {
			productName = "???";
		}
		
		out.println("<html><head><title>Payment</title></head><body>");
		out.println("[" + productName + "]");
		out.println("</body></html>");
	}

}
