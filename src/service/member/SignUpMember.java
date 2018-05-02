package service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactDAO;
import model.MemberDAO;
import model.domain.ContactBean;
import model.domain.MemberBean;
import util.ContactTypeNumber;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignUpMember")
public class SignUpMember extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String alarmAgree= request.getParameter("alarmAgree");
		String riskType= request.getParameter("riskType");
		MemberBean member = new MemberBean(id, pw, Integer.parseInt(alarmAgree), Integer.parseInt(riskType));
		try { 
			boolean isAdd = MemberDAO.addMember(member);
			if(isAdd) {
				int memberNo = MemberDAO.selectMemberNoById(id);
				//-----NEED TO UPDATED-------
				ContactBean contact = new ContactBean(ContactTypeNumber.EMAIL, email, 1);
				ContactDAO.addContact(memberNo, contact);
			}else {
				response.sendRedirect("/loginPages/signup.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/loginPages/signupResult.jsp");
	}
}
