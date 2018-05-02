package service.alarm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlarmDAO;
import model.MemberInfoDAO;
import model.domain.MemberInfoBean;

/**
 * Servlet implementation class DeleteAlarm
 */
@WebServlet("/DeleteAlarm")
public class DeleteAlarm extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int alarmNo = Integer.parseInt(request.getParameter("no"));
		try {
			AlarmDAO.deleteAlarmByAlarmNo(alarmNo);
			MemberInfoBean memberInfo = MemberInfoDAO.getMemberInfoByMemberNo((int)request.getSession().getAttribute("memberNo"));
			request.getSession().setAttribute("memberInfo", memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect("/menuPages/alarm.jsp");
		}
	}
}
