package controller.loginController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactDAO;

/**
 * Servlet implementation class SignInEmailCheck
 */
@WebServlet("/SignUpEmailCheck")
public class SignUpEmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String emailAddress = request.getParameter("email");
		PrintWriter out = response.getWriter();
		if(emailAddress != null && !emailAddress.equals("")) {
			try {
				int resultNo = ContactDAO.selectContactByAddress(emailAddress);
				if(resultNo == -1) {
					//no such email
					out.print("okay");
				}else {
					//email exists
					out.print("exist");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			out.print("noInput");
		}
		out.close();
	}
}
