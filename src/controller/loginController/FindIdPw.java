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
import model.MemberDAO;
import model.domain.MemberBean;

/**
 * @Author Junmin Seong (chicolivia@gmail.com)
 */
@WebServlet("/FindIdPw")
public class FindIdPw extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = (String)request.getParameter("id");
		String email = (String)request.getParameter("email");
		if(id.equals("1")) {
			//find id
			try {
				int resultInt = ContactDAO.selectContactByAddress(email);
				if(resultInt == -1) {
					out.print("email");
				}else {
					int memberNo = resultInt;
					MemberBean member = MemberDAO.selectMember(memberNo);
					out.print(member.getId());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//find pw
			MemberBean member = null;
			try {
				member = MemberDAO.selectMember(id);
				if(member == null) {
					out.print("id");
				}else{
					int memberNo = ContactDAO.selectContactByAddress(email);
					if(memberNo == -1 || memberNo != member.getNo()) {
						out.print("email");
					}else if(memberNo == member.getNo()){
						out.println(member.getPw().substring(0, member.getPw().length()-2)+"**");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.close();
	}
}
