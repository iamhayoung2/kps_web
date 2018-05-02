package service.predict;

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
 * Servlet implementation class GetPredictJSON
 */
@WebServlet("/GetPredictJSON")
public class GetPredictJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPredictJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		BitCoinDAO.getBitCoinPredFromDB();
		ArrayList<CoinPredBean> coinList = BitCoinDAO.getBitCoinPredList(); 
		String resultString ="[";
		for(int i = 0 ; i < coinList.size(); i++) {
			if((System.currentTimeMillis()/1000) <= (coinList.get(i).getTimeStamp())) {
			resultString += "["+(coinList.get(i).getTimeStamp()+32400L)*1000L+","+
					String.format("%.3f", coinList.get(i).getPriminum())+"],";
			System.out.println();
			}
		}
		resultString = resultString.substring(0, resultString.length()-1);
		resultString +="]";
		out.print(resultString);
		out.close();
	}
}
