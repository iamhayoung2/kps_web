package service.bitcoin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BitCoinDAO;
import model.domain.CoinPredBean;

/**
 * Servlet implementation class GetBitCoinJSON
 */
@WebServlet("/GetBitCoinJSON")
public class GetBitCoinJSON extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<CoinPredBean> coinList = BitCoinDAO.getBitCoinPremiumList();
		String resultString ="[";
		for(int i = 0 ; i < coinList.size(); i++) {
			resultString += "["+(coinList.get(i).getTimeStamp()+32400L)*1000L+","+
					String.format("%.3f", coinList.get(i).getPriminum())+"],";
			System.out.println();
		}
		resultString = resultString.substring(0, resultString.length()-1);
		resultString +="]";
		out.print(resultString);
		out.close();
	}
}