package la.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payment = request.getParameter("pay");
		String[] values = request.getParameterValues("site");		
		
		String selectedPayment;
		Map<String,String> paymentMap = new HashMap<String,String>();
		paymentMap.put("card", "クレジットカード");
		paymentMap.put("bank", "銀行振込");
		paymentMap.put("cash", "代引き");
		
		if(payment == null){
			selectedPayment = "選択されていません";
		} else {
			if(paymentMap.containsKey(payment)){
				selectedPayment = paymentMap.get(payment);
			} else {
				selectedPayment = "???";
			}
		}
		
		String selectedSite = "-";
		Map<String,String> serviceMap = new HashMap<String,String>();
		serviceMap.put("fb", "Facebook");
		serviceMap.put("tw", "Twitter");
		serviceMap.put("yt", "YouTube");
		
		if(values == null){
			selectedSite = "選択されていません";
		} else {
			for(String site : values){
				selectedSite += serviceMap.get(site) + "-";
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Payment</title></head><body>");
		out.println("あなたが選択したお支払い方法は以下の通りです<br>");
		out.println("[" + selectedPayment + "]");
		out.println("<br><br>");
		out.println("あなたが選択したサービスは以下の通りです<br>");
		out.println("[" + selectedSite + "]");
		out.println("</body></html>");
	}
}
