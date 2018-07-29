package la.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentServlet_img")
public class PaymentServlet_img extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentServlet_img() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payment = request.getParameter("pay");
		String[] values = request.getParameterValues("site");		
		String selectedPayment;
		
		if(payment == null){
			selectedPayment = "選択されていません";
		} else {
			switch(payment){
				case "card":
					selectedPayment = "https://1.bp.blogspot.com/-7fOk5lbv6pI/VM9ZTJhlpRI/AAAAAAAArQ4/yMao_klZkKI/s800/credit_card_platina_silver.png";
					break;
				case "bank":
					selectedPayment = "https://2.bp.blogspot.com/-Gs4MgMoRfwI/Ur1HRZ-odII/AAAAAAAAcdc/-ROKSGsN61Y/s800/atm_woman.png";
					break;
				case "cash":
					selectedPayment = "https://3.bp.blogspot.com/-3bOZxZ0tJFU/V7kyX6e27_I/AAAAAAAA9M0/bcwHSYkJNtcMNzkulxfVa8f2yZ1VMVFkgCLcB/s800/takuhai_daibiki.png";
					break;
				default:
					selectedPayment = "???";
					break;
			}
		}
		
		String selectedSite = "-";
		
		if(values == null){
			selectedSite = "選択されていません";
		} else {
			for(String site : values){
				switch(site){
					case "fb":
						selectedSite += "Facebook" + "-";
						break;
					case "tw":
						selectedSite += "Twitter" + "-";
						break;
					case "yt":
						selectedSite += "YouTube" + "-";
						break;
					default:
						selectedSite += "???" + "-";
						break;
				}
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Payment</title></head><body>");
		out.println("あなたが選択したお支払い方法は以下の通りです<br>");
		out.println("<img width='150px' src='" + selectedPayment + "'><br>");
		out.println("<br><br>");
		out.println("あなたが選択したサービスは以下の通りです<br>");
		out.println("[" + selectedSite + "]");
		out.println("</body></html>");
	}
}
