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
 * �����¼�ı���Ϣ
 * @author Edson121
 *
 */
public class DoLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 �ж��Ƿ��¼�ɹ�
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		BusinessSovle service=new BusinessSovleImp();
		User user=service.login(uname, password);
		if(user!=null){//2�ɹ������һ����¼��ǣ�����ҳ����ת����ҳ����ʾ��¼�ɹ�
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{//3 ʧ������ת����¼ҳ����ʾ��¼ʧ��ԭ��
			request.setAttribute("message", "�û�������");
			request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
		}
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
