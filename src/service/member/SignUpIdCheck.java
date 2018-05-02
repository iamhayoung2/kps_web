package service.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.domain.MemberBean;

/**
 * Servlet implementation class SignInIdCheck
 */

@WebServlet("/SignUpIdCheck")
public class SignUpIdCheck extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = (String)request.getParameter("id");

		response.setContentType("text/xml;charset=utf-8");
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<data><result>");
		if(id != null && !id.equals("")) {
			MemberBean member = null;
			try { 
				member = MemberDAO.selectMember(id);
				if(member != null) {
					// id exists
					out.print("exist");
				}else {
					//id okay
					out.print("okay");
				}
			} catch (SQLException e) {
				//id okay
				System.out.print("SQLException");
				out.print("sqlError");
			}
		}else {	
			out.print("noInput");
		}
		out.print("</result></data>");
		out.close();
	}
}
