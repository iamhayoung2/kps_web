package controller.crwController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PremiumDAO;

/**
 * Servlet implementation class CRWController
 */
@WebServlet("/CRWController")
public class CRWController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRWController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String go = (String)request.getParameter("go");
		if(go.equals("1")) {
			PremiumDAO.startCRW();
		}else if(go.equals("0")) {
			PremiumDAO.stopCRW();
		}
		response.sendRedirect("/masterPages/masterView.jsp");
	}

}
