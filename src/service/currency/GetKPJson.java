package service.currency;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PremiumDAO;
import model.domain.PremiumMarketBean;
import model.domain.PriceMarketBean;

/**
 * Servlet implementation class GetKPJson
 */
@WebServlet("/GetKPJson")
public class GetKPJson extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<PremiumMarketBean> preList= PremiumDAO.getPreList();
		ArrayList<PremiumMarketBean> sortedList = PremiumDAO.getSortedPreList();
		ArrayList<PriceMarketBean> krwList = PremiumDAO.getKrwListArray();
		ArrayList<PriceMarketBean> usdList = PremiumDAO.getUsdListArray();
		float currency = PremiumDAO.getCurrencyValue();
		String returnString = "{\""+"preList\":[";
		for(PremiumMarketBean pList: preList) {
			returnString += "{\"kMarket\": \""+pList.getkMarket()+"\",";
			returnString += "\"uMarket\": \""+pList.getuMarket()+"\",";
			returnString += "\"premium\": \""+String.format("%.2f", pList.getValue())+"\"},";
		}
		returnString = returnString.substring(0, returnString.length()-1);
		returnString += "], \"sortedList\":[";
		for(PremiumMarketBean sList: sortedList) {
			returnString += "{\"kMarket\": \""+sList.getkMarket()+"\",";
			returnString += "\"uMarket\": \""+sList.getuMarket()+"\",";
			returnString += "\"premium\": \""+String.format("%.3f", sList.getValue())+"\"},";
		}
		returnString = returnString.substring(0, returnString.length()-1);
		returnString += "], \"krwList\":[";
		for(PriceMarketBean pm: krwList) {
			returnString += pm.getValue()+",";
		}
		returnString = returnString.substring(0, returnString.length()-1);
		returnString += "], \"usdList\":[";
		for(PriceMarketBean pmu: usdList) {
			returnString += pmu.getValue()+",";
		}
		returnString = returnString.substring(0, returnString.length()-1);
		returnString +="], \"currency\":\""+ currency+"\"}";
		out.print(returnString);
		out.close();
	}
}
