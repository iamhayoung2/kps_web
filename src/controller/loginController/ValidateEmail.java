package controller.loginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.EmailUtil;

/**
 * Servlet implementation class ValidateEmail
 */
@WebServlet("/ValidateEmail")
public class ValidateEmail extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email = (String)request.getParameter("email");
		String randomStr = ( (int) (Math.random()*9999 +9999)+"").substring(0, 4);
		PrintWriter out = response.getWriter();
		try {
			EmailUtil.sendEmail(email, randomStr);
			out.print(randomStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("fail");
		}finally {
			out.close();
		}
	}
}
