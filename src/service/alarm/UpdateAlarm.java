package service.alarm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlarmDAO;
import model.domain.AlarmBean;
import model.domain.ContactBean;
import model.domain.MemberInfoBean;
import util.ContactTypeNumber;

/**
 * Servlet implementation class UpdateAlarm
 */
@WebServlet("/UpdateAlarm")
public class UpdateAlarm extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int contactType = Integer.parseInt(request.getParameter("contactType-category"));
		String coin = request.getParameter("coin-category");
		String percent = request.getParameter("percent-category");

		MemberInfoBean memberInfo = (MemberInfoBean) request.getSession().getAttribute("memberInfo");
		boolean alarmSame = false;
		for(AlarmBean alarm :memberInfo.getAlarmInfo()) {
			if(Float.parseFloat(percent) == alarm.getPercent()) {
				alarmSame= true;
			}
		}
		
		if(memberInfo.getAlarmInfo().size() <3 && !alarmSame) {
			ArrayList<ContactBean> contactList = memberInfo.getContactInfo();
			int contactNo = contactList.get(ContactTypeNumber.EMAIL-1).getContactNo();
			
			try {
				AlarmDAO.addAlarm(memberInfo.getMember().getNo(), 
						new AlarmBean(Integer.parseInt(coin), Integer.parseInt(percent), contactNo, memberInfo.getMember().getNo()));
				memberInfo.setAlarmInfo(AlarmDAO.selectAllAlarmByMemberNo(memberInfo.getMember().getNo()));
				request.getSession().setAttribute("memberInfo", memberInfo);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				response.sendRedirect("/menuPages/alarm.jsp");
			}
		}else {
			response.sendRedirect("/menuPages/alarm.jsp");
		}
	}
}
