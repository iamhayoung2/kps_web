package controller.loginController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AlarmDAO;
import model.ContactDAO;
import model.MemberDAO;
import model.domain.AlarmBean;
import model.domain.ContactBean;
import model.domain.MemberBean;
import model.domain.MemberInfoBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		try {
				MemberBean member = MemberDAO.selectMember(id);
				session.setAttribute("memberNo", member.getNo());
				ArrayList<ContactBean> contactList = null;
				ArrayList<AlarmBean> alarmList = null;
				contactList = ContactDAO.selectAllContactByMemberNo(member.getNo());
				alarmList = AlarmDAO.selectAllAlarmByMemberNo(member.getNo());
				MemberInfoBean memberInfo = new MemberInfoBean(member, alarmList, contactList);
				session.setAttribute("memberInfo", memberInfo);
				System.out.println(member.getNo());
				System.out.println(member.getId());
		}
			catch(SQLException e) {
				e.printStackTrace();
		}finally {
			if(id.equals("master")) {
				response.sendRedirect("/masterPages/masterView.jsp");
			}else {
				response.sendRedirect("/index.jsp");
			}
		}
	}
}
