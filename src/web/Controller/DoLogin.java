package web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Access2db;
import dao.impl.Access2dbImpl;
import domain.User;

import service.BusinessSovle;
import service.impl.BusinessSovleImp;
/**
 * 处理登录的表单信息
 * @author Edson121
 *
 */
public class DoLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 判断是否登录成功
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		BusinessSovle service=new BusinessSovleImp();
		User user=service.login(uname, password);
		if(user!=null){//2成功则分配一个登录标记，并将页面跳转到首页，显示登录成功
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{//3 失败则跳转到登录页面显示登录失败原因
			request.setAttribute("message", "用户不存在");
			request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
		}
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
