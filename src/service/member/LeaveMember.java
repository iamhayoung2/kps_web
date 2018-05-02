package service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.domain.MemberInfoBean;

/**
 * Servlet implementation class LeaveMember
 */
@WebServlet("/LeaveMember")
public class LeaveMember extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberInfoBean memberInfo = (MemberInfoBean) request.getSession().getAttribute("memberInfo");
		try {
			int memberNo =memberInfo.getMember().getNo();
			System.out.println(memberNo);
			if(MemberDAO.deleteMember(memberInfo.getMember().getNo())) {
				response.sendRedirect("/biz/leaveMemberBiz.jsp");
			}else {
				//탈퇴 실패
				response.sendRedirect("/loginPages/mypage.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/loginPages/mypage.jsp");
		}
	}
}
