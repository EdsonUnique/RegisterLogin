package web.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 注销servlet
 * @author Edson121
 *
 */
public class DoLogout extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
			request.setAttribute("message", "注销成功  服务器将在3秒内跳转到首页，" +
					"若没有跳转，请点击<a href='"+request.getContextPath()+"/index.jsp'>首页</a> " +
							"<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'");
			request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
