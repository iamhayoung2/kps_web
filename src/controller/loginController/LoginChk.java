package controller.loginController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import model.MemberDAO;
import model.domain.MemberBean;

/**
 * Servlet implementation class LoginChk
 */
@WebServlet("/LoginChk")
public class LoginChk extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		if(id != null) {
			try {
				MemberBean member = MemberDAO.selectMember(id);
				if (member != null) {
					if(member.getPw().equals(pw)) {
						out.print("ok");
					}else {
						out.print("pw");
					}
				}else {
					out.print("id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			out.print("id");
		}
		out.close();
	}//service
}
