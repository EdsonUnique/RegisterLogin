package web.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ע��servlet
 * @author Edson121
 *
 */
public class DoLogout extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
			request.setAttribute("message", "ע���ɹ�  ����������3������ת����ҳ��" +
					"��û����ת������<a href='"+request.getContextPath()+"/index.jsp'>��ҳ</a> " +
							"<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'");
			request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
